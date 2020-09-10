package com.bolsadeideas.springboot.app.springbootdi;

import java.util.Arrays;
import java.util.List;

import com.bolsadeideas.springboot.app.springbootdi.models.domain.ItemFactura;
import com.bolsadeideas.springboot.app.springbootdi.models.domain.Producto;
import com.bolsadeideas.springboot.app.springbootdi.models.service.IServicio;
import com.bolsadeideas.springboot.app.springbootdi.models.service.MiServicioComplejo;
import com.bolsadeideas.springboot.app.springbootdi.models.service.MiServicioSimple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean("miServicioSimple")
    public IServicio registrarServicioSimple() {
        return new MiServicioSimple();
    }

    @Bean("miServicioComplejo")
    public IServicio registrarServicioComplejo() {
        return new MiServicioComplejo();
    }

    @Bean("miItemFactura")
    public List<ItemFactura> registrarItems() {
        Producto producto1 = new Producto("Macbook Pro", 39548.15);
        Producto producto2 = new Producto("Go Pro", 7560.01);

        ItemFactura item1 = new ItemFactura(producto1, 5);
        ItemFactura item2 = new ItemFactura(producto2, 3);

        return Arrays.asList(item1, item2);
    }

    @Bean("miItemFacturaOficina")
    //@Primary
    public List<ItemFactura> registrarItemsOficina() {
        Producto producto1 = new Producto("Computadora", 15000.00);
        Producto producto2 = new Producto("Escritorio", 4580.64);
        Producto producto3 = new Producto("Impresora", 3245.12);
        Producto producto4 = new Producto("Silla", 1895.25);

        ItemFactura itemFactura1 = new ItemFactura(producto1, 2);
        ItemFactura itemFactura2 = new ItemFactura(producto2, 1);
        ItemFactura itemFactura3 = new ItemFactura(producto3, 1);
        ItemFactura itemFactura4 = new ItemFactura(producto4, 2);

        return Arrays.asList(itemFactura1, itemFactura2, itemFactura3 ,itemFactura4);
    }
}