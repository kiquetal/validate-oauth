package me.cresterida.conf.controller;

import java.security.Principal;

import me.cresterida.conf.entity.UserDetailsCustom;
import me.cresterida.conf.service.UserDetailsServiceCustom;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @RequestMapping("/kiquetal")
    @ResponseBody
	    public String greeting() {
	        return "aa";
	    }
    @RequestMapping("/home")
    public String getHome()
    {
    	return "home";
    }
    @RequestMapping("/login")
    public String getLogin()
    {
    	return "login";
    }
    @RequestMapping("/")
    public String getHom(Authentication p)
    {
    
    	return "home";
    }

    @RequestMapping("/hello")
    public String getHello()
    {
    	return "hello";
    }
    
}
