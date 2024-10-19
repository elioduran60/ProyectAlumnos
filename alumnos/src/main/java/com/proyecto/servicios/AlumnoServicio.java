package com.proyecto.servicios;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.proyecto.modelos.*;


public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos;

    public AlumnoServicio() {
        this.listaAlumnos = new HashMap<>();
    }

    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
    }
    public void agregarMateria(String rutAlumno, int opcion) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            Materia materia = new Materia(opcion);
            alumno.getMaterias().add(materia);
            System.out.println("Materia agragada...!");
        }else {
            System.out.println("Alumno no encontrado, intente nuevamente."); // ***************
        }
    }
    public List<Materia> materiasPorAlumnos(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            return alumno.getMaterias();
        }
        return null;     
    }
    public Map<String, Alumno> listarAlumnos() {
        return this.listaAlumnos;
    }
}