package com.example.NumerosAleatorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.NumerosAleatorios.service.NumerosService;

@Controller

public class NumerosController {

    @Autowired NumerosService numerosService;

    @GetMapping({"/","/list",""})
    public String showList (Model model){
        model.addAttribute("totalAmount", numerosService.getTotalNumbers());
        model.addAttribute("numberList", numerosService.getList());
        return "listView";
    }

    @GetMapping("/new")
    public String showNew(){
        numerosService.add();
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete (@PathVariable Integer id){
        numerosService.delete(id);
        return "redirect:/list";
    }
}
