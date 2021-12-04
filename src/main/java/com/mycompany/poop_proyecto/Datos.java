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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;



public class Datos extends AdmnistracionEscolar {
    public int Semestre;
    /**
     * Esta clase está encargada de generar la edad de los alumnos, asignarles 
     * el semestre correspondiente y asignar los domicilios
     * @return
     * @throws IOException 
     */
    public int[] generar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        FileWriter fw = new FileWriter("Semestre.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salida = new PrintWriter(bw);        

        //Edad.
        int aleat = 0, NS = 0;
        String Txt = null;
        for (int c=0;c<500;c++){
        aleat = (int)(Math.random()*(10)+18);
        edades[c]=aleat;
        //Semestre.
            if(aleat==17){Semestre = 1;}
            else if(aleat==18){
                NS = (int)(Math.random()*(2)+1);
                if(NS==1){Semestre = 1;}
                if(NS==2){Semestre = 2;}
                if(NS==3){Semestre = 3;}
            }
            else if(aleat==19){
                NS = (int)(Math.random()*(4)+1);
                if(NS==1){Semestre = 1;}
                if(NS==2){Semestre = 2;}
                if(NS==3){Semestre = 3;}
                if(NS==4){Semestre = 4;}
                if(NS==5){Semestre = 5;}
            }
            else if(aleat==20){
                NS = (int)(Math.random()*(5)+2);
                if(NS==2){Semestre = 2;}
                if(NS==3){Semestre = 3;}
                if(NS==4){Semestre = 4;}
                if(NS==5){Semestre = 5;}
                if(NS==6){Semestre = 6;}
                if(NS==7){Semestre = 7;}
            }
            else if(aleat==21){
                NS = (int)(Math.random()*(5)+4);
                if(NS==4){Semestre = 4;}
                if(NS==5){Semestre = 5;}
                if(NS==6){Semestre = 6;}
                if(NS==7){Semestre = 7;}
                if(NS==8){Semestre = 8;}
                if(NS==9){Semestre = 9;}
            }
            else if(aleat==22){
                NS = (int)(Math.random()*(4)+6);
                if(NS==6){Semestre = 6;}
                if(NS==7){Semestre = 7;}
                if(NS==8){Semestre = 8;}
                if(NS==9){Semestre = 9;}
                if(NS==10){Semestre = 10;}
            }
            else if(aleat==23){
                NS = (int)(Math.random()*(4)+6);
                if(NS==6){Semestre = 6;}
                if(NS==7){Semestre = 7;}
                if(NS==8){Semestre = 8;}
                if(NS==9){Semestre = 9;}
                if(NS==10){Semestre = 10;}
            }
            else if(aleat==24){
                NS = (int)(Math.random()*(4)+6);
                if(NS==6){Semestre = 6;}
                if(NS==7){Semestre = 7;}
                if(NS==8){Semestre = 8;}
                if(NS==9){Semestre = 9;}
                if(NS==10){Semestre = 10;}
            }
            else if(aleat==25){
                NS = (int)(Math.random()*(3)+7);
                if(NS==7){Semestre = 7;}
                if(NS==8){Semestre = 8;}
                if(NS==9){Semestre = 9;}
                if(NS==10){Semestre = 10;} 
            }
            else if(aleat==26){
                NS = (int)(Math.random()*(1)+9);
                if(NS==9){Semestre = 9;}
                if(NS==10){Semestre = 10;}   
            }
            else if(aleat==27){Semestre = 10;}   
        salida.println(Semestre);      
        
        }
        salida.close();       
        return edades;
     }
     
    public int [] generarSemestre() throws IOException{
        BufferedReader as;
        FileReader  nm=new FileReader("Semestre.csv");        
        as=new BufferedReader(nm);     
        String line=as.readLine();
        String[] seme=new String[500];
        int cont=0;
        while(line!=null){            
            seme[cont]=line;
            line=as.readLine();
            cont++;
        }
        for (int i = 0; i < seme.length; i++) {
            semestres[i]=Integer.parseInt(seme[i]);
        }
         return semestres;
    }

    String[] generarDirecciones() throws IOException {
        FileReader  gs=new FileReader("direcciones.csv");
        BufferedReader ba;
        ba=new BufferedReader(gs);
        String lin=ba.readLine();
        String[] direc=new String[500];
        int cont=0;     
        while(lin!=null){          
            direc[cont]=lin;
            lin=ba.readLine();
            cont++;
        }
        for (int i = 0; i < direc.length; i++) {
            direcciones[i]=direc[i];
        }
        return direcciones;
    }
}