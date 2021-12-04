/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poop_proyecto;

/**
 *
 * @author ApertureSolutions
 */

public class GeneradorNumerosInscripcion extends AdmnistracionEscolar {
    /**
     * Esta clase genera el número de inscripción con base en la ecuación que se 
     * encuentra en la página de la Facultad de Ingeniería
     * (Promedio)*(Escolaridad)*(Velacidad) donde
     * Escolaridad=(Asignatura aprobadas en ordinario/Asignaturas inscritas en ordinario)*100
     * Velocidad=(Creditos del alumno/Creditos desde el ingreso)*100
     */
    private int indicadorEscolar; 
    private float escolaridad; 
    private float velocidad; 
    private float promedio;
    private int asignaturasAprobadas, creditosAlumno;

    public int[] generarNumero(int[] totalReprobadas, int[][] asignaturas_y_creditos, float[] promedio, int[] creditosDescontar) {
        for (int i = 0; i < 500; i++) {
            this.escolaridad = generarEscolaridad(totalReprobadas, asignaturas_y_creditos);
            this.velocidad = generarVelacidad(creditosDescontar, asignaturas_y_creditos);

            this.promedio = promedio[i];
            indicadorEscolar = (int) (this.promedio * this.escolaridad * this.velocidad);
            numeroInscripcion[i] = indicadorEscolar;
        }

        return numeroInscripcion;
    }

    /**
     * (Asignatura aprobadas en ordinario/Asignaturas inscritas en ordinario)*100
     * Se le resta el total de asignatiuras reprobadas a el total de asignaturas, que se trae
     * del arreglo totalMateriasReprobadas
     */
    private float generarEscolaridad(int[] totalReprobadas, int[][] asignaturas_y_creditos) {
        for (int i = 0; i < asignaturas_y_creditos.length; i++) {
            asignaturasAprobadas = asignaturas_y_creditos[i][0] - totalReprobadas[i];
            escolaridad = (float) ((float) asignaturasAprobadas / (float) asignaturas_y_creditos[i][0]) * 100;
        }
        return escolaridad;
    }

    /**
     * (Creditos del alumno/Creditos desde el ingreso)*100 total de creditos -
     * cantidad de asignaturas reprobadas *(8)
     */
    private float generarVelacidad(int[] creditosDescontar, int[][] asignaturas_y_creditos) {
        for (int i = 0; i < 50; i++) {
            creditosAlumno = (asignaturas_y_creditos[i][1]) - (creditosDescontar[i]);
            velocidad = (float) (((float) creditosAlumno / (float) asignaturas_y_creditos[i][1]) * 100);
        }
        return velocidad;
    }

}