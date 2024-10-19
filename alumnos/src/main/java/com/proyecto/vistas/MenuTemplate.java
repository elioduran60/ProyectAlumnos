package com.proyecto.vistas;


import java.util.Scanner;

public abstract class MenuTemplate {

    protected Scanner scanner = new Scanner(System.in);

    // Método que no se sobrescribirá
    public final void iniciarMenu() {
        int opcion;
        do {
            System.out.println("1. Crear Alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Salir");
            System.out.print("Seleccione: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> crearAlumno();
                case 2 -> listarAlumnos();
                case 3 -> agregarMateria();
                case 4 -> agregarNotaPasoUno();
                case 5 -> exportarDatos();
                case 6 -> terminarPrograma();
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }


    protected abstract void exportarDatos();

    protected abstract void crearAlumno();

    protected abstract void agregarMateria();

    protected abstract void agregarNotaPasoUno();

    protected abstract void listarAlumnos();

    protected abstract void terminarPrograma();
}
