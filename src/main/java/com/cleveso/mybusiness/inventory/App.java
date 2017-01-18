/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cleveso.mybusiness.inventory;

/**
 *
 * @author Selvadurai Handeeban <s.handeeban@gmail.com>
 */

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;   
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class App
{
    @RequestMapping(value="/App",method = RequestMethod.GET)
    public ModelAndView ndex(HttpServletRequest request,HttpServletResponse response){
    ModelAndView view  = new ModelAndView();   
    
    if(request.getSession().getAttribute("unajhjme") == null){
        view.setViewName("Appui/signin");
       // return view;
    }
    else{
    view.setViewName("Appui/index");
    }
        System.err.println(request.getSession().getAttribute("uname")+" : "+view);
    return view;
    }
    
    
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public void login(HttpServletRequest request,HttpServletResponse response){
        try{
        response.sendRedirect(request.getContextPath() + "/App");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @RequestMapping(value="/signin",method = RequestMethod.GET)
    public ModelAndView signin(HttpServletRequest req,HttpServletResponse res){
        ModelAndView view = new ModelAndView("Appui/signin");
        return view;
    }
}
