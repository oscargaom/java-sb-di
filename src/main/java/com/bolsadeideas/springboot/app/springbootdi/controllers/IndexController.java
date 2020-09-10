package com.bolsadeideas.springboot.app.springbootdi.controllers;

import com.bolsadeideas.springboot.app.springbootdi.models.service.IServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class IndexController {

    /*  Inyección de dependencias mediante constructor  */
    // @Autowired
    // public IndexController(IServicio miServicio) {
    //     this.miServicio = miServicio;
    // }

    /*  Inyección de dependencias mendiante setters */
    // @Autowired
    // public void setMiServicio(IServicio miServicio) {
    //     this.miServicio = miServicio;
    // }

    /*  Inyección de dependencias mediante propiedades y qualifier */
    // @Autowired
    // @Qualifier("miServicio")
    // IServicio miServicio;

    @Autowired
    @Qualifier("miServicioComplejo")
    IServicio miServicio;

    @GetMapping({ "", "/", "index" })
    public String index(Model model) {
        model.addAttribute("objeto", miServicio.operacion());
        return "index";
    }
}