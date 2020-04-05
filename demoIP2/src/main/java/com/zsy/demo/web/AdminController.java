package com.zsy.demo.web;
import com.zsy.demo.entity.Admin;
import com.zsy.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public String login(@RequestParam String a_name, @RequestParam String a_password, Model model, HttpServletResponse response, HttpSession session) {
        Admin admin = adminService.login(a_name);
        String code;
        if (admin != null) {
            if (admin.getA_password().equals(a_password)) {
                session.setAttribute("name", admin.getA_name());
                response.setHeader("name",session.getId());
                code = "200";
                return code;
            } else {
                model.addAttribute("message", "wrong password or username");
                code = "402";
                return code;
            }
        } else {
            model.addAttribute("message", "login failed");
            code = "401";
            return code;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public String register(Admin admin,HttpServletResponse response, HttpSession session) {
        adminService.insert(admin);
        session.setAttribute("name", admin.getA_name());
        response.setHeader("name",session.getId());
        return "200";
    }

    @RequestMapping(value = "/outLogin", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public String outLogin(HttpSession session) {
        session.invalidate();
        return "200";
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public String findByName(@RequestBody Admin admin) {
        Admin info = adminService.findByName(admin.getA_name());
        System.out.println(JSONObject.toJSONString(info));
        return JSONObject.toJSONString(info);
    }
}
