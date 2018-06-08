package com.raukhvarger.spring_first.controllers;

import com.raukhvarger.spring_first.MyBean;
import com.raukhvarger.spring_first.MyDAOService;
import com.raukhvarger.spring_first.MyUser;
import com.raukhvarger.spring_first.entities.MyEntity;
import com.raukhvarger.spring_first.entities.Polzovatel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@SessionAttributes(value="pol")
public class MyController {

    @ModelAttribute("pol")
    public Polzovatel Pol(){
        return new Polzovatel();
    }

    @Autowired
    MyBean myBean;

    @Autowired
    private MyDAOService myDAOService;

    @GetMapping(path = "/")
    public ModelAndView root(@RequestParam(value="first", required=true) String first,
                             @RequestParam(value="last", required=true) String last) throws IOException {
        return hello(first, last);
    }

    @GetMapping(value = "/hello")
    public ModelAndView hello(@RequestParam(value="first", required=true) String first,
                              @RequestParam(value="last", required=true) String last
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new MyUser(first, last));
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @GetMapping(value = "add")
    public ModelAndView add(@RequestParam(value="name", required=true) String name,
                            @RequestParam(value="picture", required=true) String picture,
                            @RequestParam(value="sum",required=true) Double sum) {
        myDAOService.add(new MyEntity(name, picture,sum));

        ModelAndView modelAndView = new ModelAndView(
                (model, request, response) -> response.getWriter().write("<h1>OK</h1>"));
        return modelAndView;
    }

    @GetMapping(value = "/gds")
    public ModelAndView list(@ModelAttribute ("pol") Polzovatel polzovatel) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("entities", myDAOService.listAll(MyEntity.class));
        /*polzovatel = (Polzovatel) myDAOService.findPol(polzovatel).get(1);
        modelAndView.addObject("pol",polzovatel);*/
        polzovatel = myDAOService.findPol(polzovatel);
        //modelAndView.addObject("pol",polzovatel);
        return modelAndView;
    }

    @RequestMapping(value = "/aut",method = RequestMethod.GET)
    public ModelAndView Aut(@ModelAttribute ("pol") Polzovatel polzovatel)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pol",new Polzovatel());
        return modelAndView;
    }
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public ModelAndView Login(@ModelAttribute ("pol") Polzovatel polzovatel)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gds");
        modelAndView.addObject("pol", polzovatel);
        return modelAndView;
    }

    @GetMapping(value = "dat")
    public String dat() {
        myDAOService.add(new MyEntity("Schnider Weisse TAP 1", "Pivo1.jpg",(double)190));
        myDAOService.add(new MyEntity("Grimbergen Blonde", "Pivo2.jpg",(double)175));
        myDAOService.add(new MyEntity("Cesky Dzbanek", "Pivo3.jpg",(double)95));
        myDAOService.add(new MyEntity("Budweiser Original", "Pivo4.jpg",(double)170));
        myDAOService.add(new MyEntity("Krusovice Imperial", "Pivo5.jpg",(double)150));
        myDAOService.add(new Polzovatel( "mavra1","sa1"));
        myDAOService.add(new Polzovatel( "mavra2","sa2"));
        return "redirect:/gds";
    }
   /* @GetMapping(value="/gds/add")
    public String addToKorz(){

    }*/
}