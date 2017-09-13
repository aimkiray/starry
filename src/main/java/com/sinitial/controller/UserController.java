package com.sinitial.controller;

import com.sinitial.domain.Permission;
import com.sinitial.domain.Role;
import com.sinitial.domain.User;
import com.sinitial.service.RoleService;
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
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * ┏┓   ┏┓
 * ┏┛┻━━━┛┻┓
 * ┃       ┃
 * ┃   ━   ┃
 * ┃ ┳┛ ┗┳ ┃
 * ┃       ┃
 * ┃   ┻   ┃ Created by nekuata.
 * ┃       ┃
 * ┗━┓   ┏━┛ Code is far away from bug with
 * ┃   ┃   the alpaca protecting.
 * ┃   ┃   神兽保佑,代码无bug.💊💊💊
 * ┃   ┗━━━┓
 * ┃       ┣┓
 * ┃       ┏┛
 * ┗┓┓┏━┳┓┏┛
 * ┃┫┫ ┃┫┫
 * ┗┻┛ ┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //    转到作者列表界面
    @RequestMapping("/list/page")
    public String userList(HttpServletRequest req) {
//        List<User> users = userService.findAllUser();
//        req.setAttribute("users", users);
        return "user/user_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataTables searchUser(int start, int length, String userName, String nickName) {
        DataTables dataTables = new DataTables();
        length = length == 0 ? 5 : length;
        User user = new User();
        if (userName != null && !"".equals(userName)) {
            user.setUserName(userName);
        }
        if (nickName != null && !"".equals(nickName)) {
            user.setNickName(nickName);
        }
//        if (pageNumber != 0 && pageSize != 0) {
        dataTables.setData(userService.searchUser(start, length, user));
//        }
        int count = userService.queryUserNum(user);
        dataTables.setRecordsFiltered(count);
        dataTables.setRecordsTotal(count);
        return dataTables;
    }

    @RequestMapping(value = "/del/{userId}", method = RequestMethod.POST)
    public String deleteUser(HttpServletResponse resp, HttpServletRequest req, @PathVariable int userId) {

        int result = 0;
        String msg = "false";

        /**
         * 先删除文件
         */
        String path = req.getSession().getServletContext().getRealPath("/resources/headimg");
        User user = userService.findUserById(userId);
        String headImg = user.getHeadshot();
//        表示文件是图片或别的什么，执行删除
        if (headImg.contains(".")) {
            File imgPath = new File(path, headImg);
            if (imgPath.delete()) {
//            文件删除后再从数据库删除作者
                result = userService.deleteUser(userId);
            } else {
                msg = "false";
            }
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
     *
     * @return ModelAndView
     */
    @RequestMapping("add/page")
    public String showAddUser(HttpServletRequest request) {
        List<Role> roles = roleService.findAllRole();
        request.setAttribute("roles", roles);
        return "user/user_add";
    }

    @RequestMapping("/add")
    public String userDoRegister(HttpServletRequest req, HttpServletResponse resp, User user) {
        int result = 0;
        if (user != null) {
            result = userService.insertUser(user);
        }
        if (result == 1) {
            return "redirect:/user/login/page";
        } else if (result == -1) {
            try {
                resp.getWriter().print("<script>alert('false:-1');history.go(-1);</script>");
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

    //    转到修改界面
    @RequestMapping(value = "update/{userId}", method = RequestMethod.POST)
    public String showUpdateUser(HttpServletRequest req, @PathVariable int userId) {
        User user = userService.findUserById(userId);
        List<Role> roles = roleService.findAllRole();
        req.setAttribute("user", user);
        req.setAttribute("roles", roles);
        return "user/user_update";
    }

    //    执行修改操作
    @RequestMapping(value = "update", method = RequestMethod.POST)
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
            String path = req.getSession().getServletContext().getRealPath("/resources/headimg");
            String oldHeadImg = user.getHeadshot();
//        表示文件是图片或别的什么，执行删除
            if (oldHeadImg.contains(".")) {
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
     * 执行添加操作
     *
     * @param resp
     * @param req
     * @param file
     * @param user
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
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
            String path = req.getSession().getServletContext().getRealPath("/resources/headimg");
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
        if (user != null) {
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
}
