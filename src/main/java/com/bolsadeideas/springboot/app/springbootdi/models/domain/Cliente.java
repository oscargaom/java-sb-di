package com.bolsadeideas.springboot.app.springbootdi.models.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/*  Si agregamos la anotación @RequestScope a la clase Cliente, el contexto de este 
    será válido por cada solicitud que se realice, lo que significa que el objeto 
    Cliente se creara cada vez que se haga una petición al controller del cual sea haga 
    la llamda.
*/

@Component
@RequestScope
public class Cliente implements Serializable {

    private static final long serialVersionUID = 4613441684800689746L;

    @Value("${cliente.nombre}")
    private String nombre;

    @Value("${cliente.apellido}")
    private String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}