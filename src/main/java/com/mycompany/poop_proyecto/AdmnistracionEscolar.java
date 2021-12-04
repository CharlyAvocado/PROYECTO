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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class AdmnistracionEscolar {
    protected String[] nombreCompleto = new String[500];
    protected int[] edades = new int[500];
    protected int[] semestres = new int[500];
    protected int[][] asiganturasCreditos = new int[500][2];
    protected int[] numeroInscripcion = new int[500];
    protected float[] promedios = new float[500];
    protected String[] direcciones = new String[500];
    protected String[] materias = new String[500];
    protected String[] calificaciones = new String[500];
    
    KeyboardInput in = new KeyboardInput();
/**
 * Esta clase se encarga de almacenar los datos generados o leídos por las otras clases
 * para imprimirlo en un archivo CSV
 * @param registrosAlumnos 
 */
    
    public void archivoAlumnos(String[][] registrosAlumnos){
        
        String texto = "Nombre, Edad, Semestre, Numero DE Inscripcion, Direccion"+"\n";
        for (int i = 0; i < registrosAlumnos.length; i++) {
            texto += registrosAlumnos[i][0] + ", " + registrosAlumnos[i][1]+"\n";
        }
        
        try{
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("DATOSFINALES.csv");//Se crea un archivo
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println(texto);
            salida.close();
        }catch(IOException ioe){
            System.out.println("\n\nError al abrir o guardar el archivo: ");
            ioe.printStackTrace();
        }catch(Exception e){
            System.out.println("\n\nError al leer de teclado: ");
            e.printStackTrace();
        }
    }
}
