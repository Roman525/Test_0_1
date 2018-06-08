package com.raukhvarger.spring_first.Servlets;

import com.raukhvarger.spring_first.entities.Polzovatel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Mavra on 06.06.2018.
 */
public class SessionServ extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        Polzovatel pol = new Polzovatel();
        session.setAttribute("myObj", pol);
    }

}
