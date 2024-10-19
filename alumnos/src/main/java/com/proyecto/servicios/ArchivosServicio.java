package com.proyecto.servicios;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.proyecto.modelos.Alumno;


public class ArchivosServicio {
    //private PromedioServicioImp promedioServicioImp = new PromedioServicioImp();

    private List<Alumno> alumnosCargar;

    private PromedioServicioImp promediosServicioImp;

    public ArchivosServicio() {
        promediosServicioImp = new PromedioServicioImp();
        alumnosCargar = new ArrayList<>();//Instanciamos la lista
    }
    
    // Método para exportar los datos (informacion de los ingresos y consultas ) a un archivo .txt
    public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno : " + alumno.getRut() + " - " + alumno.getNombre());
                writer.newLine();

                // Iterar sobre las materias del alumno
                alumno.getMaterias().forEach(materia -> {
                    double promedio_out = promediosServicioImp.calcularPromedio(materia.getNotas());
                    try {
                        writer.write("Materia: " + materia.getNombremateria() + " - Notas: " + materia.getNotas()); //Salida de las materias y 
                        																							//notas en el archivo txt
                        writer.newLine();
                        writer.write("Promedio: " + promedio_out); ////Salida del promedio en el archivo txt
                        writer.newLine();
                    } catch (IOException e) {//Salida de excepcion o falla por entradas inválidas
                        e.printStackTrace();
                    }
                });
                writer.newLine();
            }
            System.out.println("Datos exportados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    public PromedioServicioImp getPromediosServicioImp() {
        return promediosServicioImp;
    }

    public void setPromediosServicioImp(PromedioServicioImp promediosServicioImp) {
        this.promediosServicioImp = promediosServicioImp;
    }

    public List<Alumno> getAlumnosCargar() {
        return alumnosCargar;
    }

    public void setAlumnosCargar(List<Alumno> alumnosCargar) {
        this.alumnosCargar = alumnosCargar;
    }
}
