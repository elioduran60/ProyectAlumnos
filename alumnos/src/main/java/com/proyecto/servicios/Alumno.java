package com.proyecto.servicios;


import java.util.ArrayList;
import java.util.List;

import com.proyecto.interfaces.IScanner;

public class Alumno implements IScanner {private String rut, nombre, apellido, direccion;
    private List<Materia> materias;

    public Alumno(String rut, String nombre, String apellido, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        materias = new ArrayList<>();
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        System.out.println("Ingrese el run del alumno: ");
        this.rut = leer.nextLine();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre( ) {
        System.out.println("Ingrese el Nombre del alumno: ");
        this.nombre = leer.nextLine();
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido( ) {
        System.out.println("Ingrese el Apellido del alumno: ");
        this.apellido = leer.nextLine();
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion( ) {
        System.out.println("Ingrese la Direccion del alumno: ");
        this.direccion = leer.nextLine();
    }
    public List<Materia> getMaterias() {
        return materias;
    }
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
