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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
            if (admin.getA_name().equals(a_name) && admin.getA_password().equals(a_password)) {
                session.setAttribute("name", admin.getA_name());
                response.setHeader("name",session.getId());
                code = "200";
                return code;
            } else if(admin.getA_name().equals(a_name)){
                model.addAttribute("message", "wrong password");
                code = "402";
                return code;
            } else{
                model.addAttribute("message", "Not register");
                code = "403";
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

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public Map<String, Object> getAdminList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Admin> list = adminService.getAdminList();
        System.out.println(list);
        modelMap.put("adminList", list);
        return modelMap;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public void deleteUser(@RequestParam int a_id) {
        adminService.deleteUser(a_id);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public void deleteUser(@RequestParam String a_password, @RequestParam int a_id) {
        adminService.updatePassword(a_password,a_id);
    }
}
