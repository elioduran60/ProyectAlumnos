package com.proyecto.servicios;

import java.util.List;


public class PromedioServicioImp {

    public double calcularPromedio(List<Double> notas) {//Ingresan notas para llenar Lista de Notas
        if (notas == null || notas.isEmpty()) { // Valida que el ingreso de notas no tenga valor nulo ni que esté vacia esa informacion. 
            return 0.0;
        } else {
            return notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);//Calcula el promedio con la clase "stream" y el 
            																		//método "average", en caso de fallo  tendrá salida de 0.0
        }
    }
}