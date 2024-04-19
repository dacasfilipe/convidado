package com.convidados.controllers;

import com.convidados.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ConvidadosController {
    @Autowired
    private ConvidadoRepository convidadosRepository;

    @GetMapping("/convidados")
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("ListaConvidados");

        modelAndView.addObject("convidados", convidadosRepository.findAll());

        return modelAndView;
    }
}
