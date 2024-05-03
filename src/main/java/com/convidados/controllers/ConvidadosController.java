package com.convidados.controllers;

import com.convidados.model.Convidado;
import com.convidados.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvidadosController {
    @Autowired
    private ConvidadoRepository convidadosRepository;

    @GetMapping("/convidados")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("ListaConvidados");
        modelAndView.addObject("convidado",new Convidado());
        modelAndView.addObject("convidados", convidadosRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/convidados")
    public String salvar(@ModelAttribute("convidado") Convidado convidado, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ListaConvidados";
        }
        convidadosRepository.save(convidado);
        return "redirect:/convidados";
    }

    @PutMapping("/convidados/{id}")
    public String atualizar(@PathVariable("id") Long id, Convidado convidado) {
        if (convidadosRepository.existsById(id)) {
            convidado.setId(id);
            convidadosRepository.save(convidado);
            return "redirect:/convidados";
        }
        return "redirect:/convidados";
    }

    @DeleteMapping("/convidados/{id}")
    public String excluir(@PathVariable("id") Long id) {
        if (convidadosRepository.existsById(id)) {
            convidadosRepository.deleteById(id);
            return "redirect:/convidados";
        }
        return "redirect:/convidados";
    }
}
