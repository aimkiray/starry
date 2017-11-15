package com.starry.controller;

import com.starry.domain.Permission;
import com.starry.domain.Role;
import com.starry.domain.User;
import com.starry.service.RoleService;
import com.starry.service.UserService;
import com.starry.util.DataTables;
import com.starry.util.DateTools;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/login/page")
    public String loginPage() {
        return "user/login";
    }


    @RequestMapping(value = "/login")
    public String login(HttpServletResponse resp, HttpSession session, User user) {
        boolean result = userService.verifyUser(user);
        if (result) {
            User realUser = userService.findUserByName(user.getUserName());
            List<Permission> permissions = roleService.findRoleById(realUser.getUserRole()).getPermissions();
            session.setAttribute("user", realUser);
            session.setAttribute("permissions", permissions);
            return "redirect:/panel";
        } else {
            try {
                resp.getWriter().print("<script>alert('登陆失败，请检查用户名和密码是否正确');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @RequestMapping("/register/page")
    public String signUpPage() {
        return "user/register";
    }

    @RequestMapping("/register")
    public String signUp(HttpServletResponse resp, User user) {
        int result = 0;
        if (user != null) {
            user.setUserRole(2);
            result = userService.insertUser(user);
        }
        if (result == 1) {
            return "redirect:/user/login/page";
        } else if (result == -1) {
            try {
                resp.getWriter().print("<script>alert('注册失败，用户名已注册');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            try {
                resp.getWriter().print("<script>alert('注册失败，用户名已注册');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @RequestMapping("/forgot/page")
    public String forgotPage() {
        return "user/forgot";
    }

    //    转到作者列表界面
    @RequestMapping("/list/page")
    public String getUserPage() {
        return "user/user_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataTables getUser(Integer start, Integer length, String userName, String nickName) {
        DataTables dataTables = new DataTables();
        start = start == null ? 0 : start;
        length = length == null ? 5 : length;
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

    /**
     * 获取添加界面
     *
     * @return ModelAndView
     */
    @RequestMapping("/add/page")
    public String addUserPage(HttpServletRequest request) {
        List<Role> roles = roleService.findAllRole();
        request.setAttribute("roles", roles);
        return "user/user_add";
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
    @RequestMapping(value = "/add")
    public String addUser(HttpServletResponse resp, HttpServletRequest req, @RequestParam(value = "uploadPic", required = false) MultipartFile file, User user) {

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

    //    转到修改界面
    @RequestMapping(value = "/update/{userId}")
    public String updateUserPage(HttpServletRequest req, @PathVariable int userId) {
        User user = userService.findUserById(userId);
        List<Role> roles = roleService.findAllRole();
        req.setAttribute("user", user);
        req.setAttribute("roles", roles);
        return "user/user_update";
    }

    //    执行修改操作
    @RequestMapping(value = "/update")
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
                File oldImg = new File(path, oldHeadImg);
//            如果图片删除失败，返回false，end.
                if (oldImg.exists() && !oldImg.delete()) {
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

    @RequestMapping(value = "/del/{userId}")
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
}
