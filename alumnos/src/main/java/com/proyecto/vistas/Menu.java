package com.proyecto.vistas;

import java.util.List;

import java.util.Scanner;

import com.proyecto.modelos.Alumno;
import com.proyecto.modelos.Materia;
import com.proyecto.servicios.AlumnoServicio;
import com.proyecto.servicios.ArchivosServicio;
public class Menu extends MenuTemplate {

    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivosServicio archivosServicio = new ArchivosServicio();

    public Menu() {
        super(); //Invocacion de Supoercalse (herencia)
    }

    protected void exportarDatos() {
        archivosServicio.exportarDatos(alumnoServicio.listarAlumnos(), "promedios.txt"); //****************
        System.out.println("Datos exportados correctamente.");
    }

    protected void crearAlumno() {
        System.out.println("--- Crear Alumno ---");
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();
        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.crearAlumno(alumno);
        System.out.println("--- ¡Alumno agregado! ---");
    }

    protected void agregarMateria() {
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa RUT del Alumno: ");
        String rut = scanner.nextLine();
        System.out.println("1. MATEMATICAS\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
        System.out.print("Selecciona una Materia: ");
        int opcion = scanner.nextInt();
        alumnoServicio.agregarMateria(rut, opcion);
        System.out.println("--- ¡Materia agregada! ---");
    }

    protected void agregarNotaPasoUno() {
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa RUT del Alumno: ");
        String rut = scanner.nextLine();

        List<Materia> materias = alumnoServicio.materiasPorAlumnos(rut); // ************************
        if (materias != null && !materias.isEmpty()) {
            for (int i = 0; i < materias.size(); i++) {
                System.out.println((i + 1) + ". Materia: " + materias.get(i).getNombremateria());
                System.out.println("Notas: " + materias.get(i).getNotas());
            }

            // Seleccionar materia para agargar nota
            System.out.print("Selecciona la materia a la que deseas agregar una nota: ");
            int seleccion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (seleccion > 0 && seleccion <= materias.size()) {
                Materia materiaSeleccionada = materias.get(seleccion - 1);
                System.out.print("Ingresa la nueva nota: ");
                double nuevaNota = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                // Agregar la nueva nota a la lista de notas
                materiaSeleccionada.getNotas().add(nuevaNota);
                System.out.println("--- ¡Nota agregada a " + materiaSeleccionada.getNombremateria() + " correctamente ! ---");
            } else {
                System.out.println("Selección inválida.");
            }
        } else {
            System.out.println("No se encontraron materias para este alumno.");
        }

    }

    protected void listarAlumnos() {
        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("Alumno RUT: " + alumno.getRut() + " - " + alumno.getNombre());

            if (alumno.getMaterias() != null && !alumno.getMaterias().isEmpty()) {
                alumno.getMaterias().forEach(materia -> {
                    System.out.println("Materia: " + materia.getNombremateria());
                    System.out.println("Notas: " + materia.getNotas());
                });
            } else {
                System.out.println("No tiene materias");
            }

        });
    }

    protected void terminarPrograma() {
        System.out.println("Terminando programa...");
        System.exit(0);
    }

    public AlumnoServicio getAlumnoServicio() {
        return alumnoServicio;
    }

    public void setAlumnoServicio(AlumnoServicio alumnoServicio) {
        this.alumnoServicio = alumnoServicio;
    }

    public ArchivosServicio getArchivosServicio() {
        return archivosServicio;
    }

    public void setArchivosServicio(ArchivosServicio archivosServicio) {
        this.archivosServicio = archivosServicio;
    }
}