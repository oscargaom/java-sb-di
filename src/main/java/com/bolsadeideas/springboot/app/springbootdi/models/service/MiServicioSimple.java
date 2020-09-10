package com.bolsadeideas.springboot.app.springbootdi.models.service;

import org.springframework.stereotype.Component;

//@Component("miServicioSimple")
public class MiServicioSimple implements IServicio {

    @Override
    public String operacion(){
        return "Ejecutando operación simple....";
    }
}