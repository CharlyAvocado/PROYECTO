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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneradorNombres extends AdmnistracionEscolar{
    /**
     * Esta clase se encarga de generar los nombres de los alumnos
     */
    String Titulo = "Nombre completo\n";
    public String[] nombres=new String[50];
    public String[] apellidosP=new String[50];
    public String[] apellidosM=new String[50];
    public int cont=0;

    public GeneradorNombres() {
    }
    public String[] generarNombre(String nombres[], String apellidosP[], String apellidosM[]){
    try{
        BufferedReader br,as,ba;
        FileReader  fr=new FileReader("nombres.csv");
        FileReader  nm=new FileReader("apellidosP.csv");
        FileReader  gs=new FileReader("apellidosM.csv");

        as=new BufferedReader(nm);     
        br=new BufferedReader(fr);
        ba=new BufferedReader(gs);
        String line=as.readLine();
        String linea=br.readLine();
        String lin=ba.readLine();

        while(linea!=null){            
            nombres[cont]=linea;
            linea=br.readLine();                       
            cont++;
        }
        cont=0;
        while(line!=null){            
            apellidosP[cont]=line;
            line=as.readLine();
            cont++;
        }
        cont=0;
        while(lin!=null){          
            apellidosM[cont]=lin;
            lin=ba.readLine();
            cont++;
        }
        
    }catch(FileNotFoundException ex){
        System.out.println(ex.getMessage());
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
   
       try {
            FileWriter fw=new FileWriter("NombreCompleto.csv");
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter salida=new PrintWriter(bw);
            for (int i = 0; i < 500; i++) {
            salida.println(nombreCompleto[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
            + apellidosP[(int) (Math.floor(Math.random() * ((apellidosP.length - 1) - 0 + 1) + 0))]+ " " +apellidosM[(int) 
            (Math.floor(Math.random() * ((apellidosM.length - 1) - 0 + 1) + 0))]);            
            }
           
            salida.close();
        } catch (IOException ex) {
                System.out.println(ex.getMessage());
        }
       return this.nombreCompleto;
   }
    
    
}
