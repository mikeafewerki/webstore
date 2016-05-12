/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mike
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginError(Model model){
        model.addAttribute("error", "true");
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model){
        return "login";
    }
}
