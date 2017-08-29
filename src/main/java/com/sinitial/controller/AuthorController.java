package com.sinitial.controller;

import com.sinitial.domain.User;
import com.sinitial.service.UserService;
import com.sinitial.utils.DataTables;
import com.sinitial.utils.DateTools;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * ━━━━━━神兽出没━━━━━━
 *      ┏┓   ┏┓
 *     ┏┛┻━━━┛┻┓
 *     ┃       ┃
 *     ┃   ━   ┃
 *     ┃ ┳┛ ┗┳ ┃
 *     ┃       ┃
 *     ┃   ┻   ┃ Created by nekuata.
 *     ┃       ┃
 *     ┗━┓   ┏━┛ Code is far away from bug with
 *       ┃   ┃   the alpaca protecting.
 *       ┃   ┃   神兽保佑,代码无bug.💊💊💊
 *       ┃   ┗━━━┓
 *       ┃       ┣┓
 *       ┃       ┏┛
 *       ┗┓┓┏━┳┓┏┛
 *        ┃┫┫ ┃┫┫
 *        ┗┻┛ ┗┻┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */

@Controller
@RequestMapping("/author/")
public class AuthorController {

    @Autowired
    private UserService userService;

    @RequestMapping("search")
    @ResponseBody
    public DataTables searchUser(int start, int length, String userName, String nickName) {
        DataTables dataTables = new DataTables();
        /*int pageSize = start == null ? 10 : Integer.parseInt(start);
        int pageNumber = length == null ? 1 : Integer.parseInt(length);*/
        int pageSize = length;
        int pageNumber = (start / length) + 1;//当前页码
        User user = new User();
        if (userName != null && !"".equals(userName)) {
            user.setUserName(userName);
        }
        if (nickName != null && !"".equals(nickName)) {
            user.setNickName(nickName);
        }
//        if (pageNumber != 0 && pageSize != 0) {
        dataTables.setData(userService.searchUser(pageNumber, pageSize, user));
//        }
        int count = userService.queryUserNum(user);
        dataTables.setRecordsFiltered(count);
        dataTables.setRecordsTotal(count);
        return dataTables;
    }

    @RequestMapping(value = "login/page",method = RequestMethod.GET)
    public ModelAndView userLogin() {
//        return "author/login";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("author/login_page");
//        modelAndView.addObject("message","hello world");
        return modelAndView;
    }

    @RequestMapping("verify")
    public String verifyUser(HttpServletRequest req, HttpServletResponse resp, HttpSession httpSession, User user) {
        boolean result = userService.verifyUser(user);
        if (result) {
//            req.setAttribute("userName", user.getUserName());
            httpSession.setAttribute("userName", user.getUserName());
            return "redirect:/author/panel";
        } else {
            try {
                resp.getWriter().print("<script>alert('false:-1,exist');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @RequestMapping("register")
    public String userRegister(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("title", "hello world");
        return "author/register";
    }

    @RequestMapping("delete")
    public String deleteUser(HttpServletResponse resp, HttpServletRequest req, Integer userId) {

        int result = 0;
        String msg = "false";

        /**
         * 先删除文件
         */
        String path = req.getSession().getServletContext().getRealPath("headimg");
        User user = userService.findUserById(userId);
        String headImg = user.getHeadshot();
        File imgPath = new File(path, headImg);
        if (imgPath.delete()) {
//            文件删除后再从数据库删除作者
            result = userService.deleteUser(userId);
        } else {
            msg = "false";
        }

        if (result == 1) {
            msg = "true";
        } else if (result == -1) {
            msg = "false";
        } else {
            msg = "false";
        }
        try {
            resp.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("doregister")
    public String userDoRegister(HttpServletRequest req, HttpServletResponse resp, User user) {
        int result = 0;
        if (user != null) {
            result = userService.insertUser(user);
        }
        if (result == 1) {
            return "redirect:/author/author_list";
        } else if (result == -1) {
            try {
                resp.getWriter().print("<script>alert('false:-1,exist');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            try {
                resp.getWriter().print("<script>alert('false:0');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

//    转到作者列表界面
    @RequestMapping("author_list")
    public String userList(HttpServletRequest req) {
//        List<User> users = userService.findAllUser();
//        req.setAttribute("users", users);
        return "author/author_list";
    }

//    转到修改界面
    @RequestMapping("update")
    public String showUpdateUser(HttpServletRequest req, int userId) {
        User user = userService.findUserById(userId);
        req.setAttribute("user", user);
        return "author/author_update";
    }

//    执行修改操作
    @RequestMapping(value = "doupdate", method = RequestMethod.POST)
    public String updateUser(HttpServletResponse resp, HttpServletRequest req, @RequestParam(value = "uploadPic", required = false) MultipartFile file, User user) {

        String msg = "false";

        /**
         * 上传文件并保存到headimg目录下
         */
        String headImg = null; // 用户保存用户头像文件名
        String realName = null;
        if (file != null && !file.isEmpty()) {
            realName = file.getOriginalFilename();
//            获取上传的文件名称（new File用于去除可能存在的路径，在spring中有专门的方法）
//            realName = new File(file.getName()).getName();
//            获取文件后缀名
            String ext = FilenameUtils.getExtension(realName);
            headImg = DateTools.getFileName(ext);
//            先删除文件，然后构建上传目录及文件对象，不存在则自动创建
            String path = req.getSession().getServletContext().getRealPath("headimg");
            String oldHeadImg = user.getHeadshot();
            File oldImgPath = new File(path, oldHeadImg);
//            如果图片删除失败，返回false，end.
            if (!oldImgPath.delete()) {
                try {
                    resp.getWriter().print("false");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            File imgPath = new File(path);
            if (!imgPath.exists()) {
                imgPath.mkdir();
            }
            File imgFile = new File(path, headImg);

//            保存文件
            try {
                file.transferTo(imgFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 修改作者信息
         */
        user.setHeadshot(headImg);
        int result = 0;
        if (user != null && user.getUserId() != null) {
            result = userService.updateUser(user);
        }

        if (result == 1) {
            msg = "true";
        } else if (result == -1) {
            msg = "false";
        } else {
            msg = "false";
        }
        try {
            resp.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取添加界面
     * @return ModelAndView
     */
    @RequestMapping("add")
    public String showAddUser() {
        return "author/author_add";
    }

    /**
     * 执行添加操作
     * @param resp
     * @param req
     * @param file
     * @param user
     * @return
     */
    @RequestMapping(value = "doadd", method = RequestMethod.POST)
    public String addUser(HttpServletResponse resp, HttpServletRequest req, @RequestParam(value = "uploadPic", required = false) MultipartFile file, User user) {
//        System.out.println(user);

        String msg = "false";

        /**
         * 上传文件并保存到headimg目录下
         */
        String headImg = null; // 用户保存用户头像文件名
        String realName = null;
        if (file != null && !file.isEmpty()) {
            realName = file.getOriginalFilename();
//            获取文件后缀名
            String ext = FilenameUtils.getExtension(realName);
            headImg = DateTools.getFileName(ext);
//            构建上传目录及文件对象，不存在则自动创建
            String path = req.getSession().getServletContext().getRealPath("headimg");
            File imgPath = new File(path);
            if (!imgPath.exists()) {
                imgPath.mkdir();
            }
            File imgFile = new File(path, headImg);

//            保存文件
            try {
                file.transferTo(imgFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 添加作者
         */
        user.setHeadshot(headImg);
        int result = 0;
        if (user != null && user.getUserId() != null) {
            result = userService.insertUser(user);
        }

        if (result == 1) {
            msg = "true";
        } else if (result == -1) {
            msg = "false";
        } else {
            msg = "false";
        }
        try {
            resp.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转到用户面板
     * @return
     */
    @RequestMapping("panel")
    public String userPanel(HttpServletRequest req) {
//        User user = (User) req.getAttribute("userName");
//        System.out.println(user);
        return "panel/author_panel";
    }
}
