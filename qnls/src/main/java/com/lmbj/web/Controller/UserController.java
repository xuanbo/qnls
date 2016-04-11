package com.lmbj.web.controller;

import com.lmbj.web.entity.User;
import com.lmbj.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/9 16:57
 */
@Controller
@RequestMapping("/personal")
@PreAuthorize("hasAuthority('USER')")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 个人中心
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String personal(@PathVariable Integer id, ModelMap map) {
        User user = userService.findOne(id);
        map.addAttribute("user", user);
        return "user/personal";
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void personal(@PathVariable int id) throws IOException {
        User user = userService.findOne(1);
        File file = new File("d:/user.png");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        user.setPhoto(bos.toByteArray());
        userService.save(user);
    }*/


    /**
     * 用户修改个人信息
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean personalModify(@PathVariable Integer id) {
        User user = userService.findOne(id);
        return true;
    }

    /**
     * 获取用户头像
     *
     * @param id
     * @param response
     */
    @RequestMapping(value = "/{id}/photo", method = RequestMethod.GET)
    public void getUserPhoto(@PathVariable Integer id, HttpServletResponse response) {
        User user = userService.findOne(id);
        byte[] photo = user.getPhoto();
        try {
            showPhoto(photo, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户修改头像
     * @param id
     * @param photo
     * @return
     */
    @RequestMapping(value = "/{id}/photo", method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateUserPhoto(@PathVariable Integer id, MultipartFile photo) {
        User user = userService.findOne(id);
        try {
            user.setPhoto(photo.getBytes());
            userService.save(user);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 将图片字节数组写入HttpServletResponse
     *
     * @param photo
     * @param response
     * @throws IOException
     */
    public static void showPhoto(byte[] photo, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        os.write(photo);
        os.flush();
        os.close();
    }
}
