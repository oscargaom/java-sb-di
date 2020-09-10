package com.bolsadeideas.springboot.app.springbootdi.models.domain;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/*  Si agregamos la anotación @RequestScope a la clase Factura, el contexto de esta 
    será válido por cada solicitud que se realice, lo que significa que el objeto 
    Factura se creara cada vez que se haga una petición al controller FacturaController o 
    de donde sea que este sea llamada, invocada y/o instanciada.
    Si en este caso dejamos el objeto cliente sin anotación su contexto será de singleton por 
    lo que será válida en un contexto más amplio que el de RequestScope y cada vez que se invoque 
    Factura ira modificando el valor de su propiedad nombre por medio de setNombre, de tal forma 
    que siempre se irá concatenando el valor indicado (Manuel) y este ira creciendo.

    Si agregamos la anotación @SessionScope a la clase Factura, el contexto de esta es válida por
    todo lo que dura la sesión del usuario, es decir, el tiempo en el que este navegando, cuando 
    cierra el navegador o se genera un timeout, para esto es importante que la clase implemente 
    Serializable para convertir el objeto en bytes y obtener una representación del objeto en 
    su forma original.

    Cuando agregamos la anotación @ApplicationScope es similar a no poner nada, que es equivalente
    a que esta se ade tipo singleton, es decir, que su ámbito es general en toda la aplicación.
*/

@Component
@RequestScope
public class Factura {

    private static final long serialVersionUID = 4613441684800684039L;

    @Value("${factura.descripcion}")
    private String descripcion;
    
    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("miItemFacturaOficina")
    private List<ItemFactura> items;

    @PostConstruct()
    public void inicializar(){
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Manuel"));
        descripcion = descripcion.concat(" del cliente ").concat(cliente.getNombre());
    }

    @PreDestroy()
    public void destruir(){
        System.out.println("Objeto Factura destruida ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}