package com.proyecto.modelos;

import java.util.List;
import java.util.ArrayList;

import com.proyecto.interfaces.IScanner;

public class Materia implements IScanner {
    private MateriaEnum nombremateria;//Vairable del tipo Enum
    private List<Double> notas;

    public Materia(int opcion) {
        notas = new ArrayList<>();
        switch (opcion) { // Selector de las materias disponibles.
            case 1 -> this.nombremateria = MateriaEnum.MATEMATICAS;
            case 2 -> this.nombremateria = MateriaEnum.LENGUAJE;
            case 3 -> this.nombremateria = MateriaEnum.CIENCIA;
            case 4 -> this.nombremateria = MateriaEnum.HISTORIA;
            default -> throw new IllegalArgumentException("Opción inválida para materia");
        }

    }

    //Metódos para las Materias y notas:
    public MateriaEnum getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(MateriaEnum nombremateria) {
        this.nombremateria = nombremateria;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}
