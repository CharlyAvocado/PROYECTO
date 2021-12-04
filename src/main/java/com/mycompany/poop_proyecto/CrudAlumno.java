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
import java.io.IOException;

public class CrudAlumno {
   /**
    * Esta clase es la encargada de ejecutar todas las clases secundarias así 
    * como la utilizada para administrar los datos de los alumnos con ayuda de
    * un menu
    * @param args
    * @throws IOException 
    */
    public static void main(String[] args) throws IOException {
        Alumno alu = new Alumno();
        AdmnistracionEscolar ad = new AdmnistracionEscolar();
        Ascii soo = new Ascii();
        int op, op1;
        int contrasena;          
        KeyboardInput in = new KeyboardInput();
        alu.traerDatos();
        ad.archivoAlumnos(alu.registrosAlumnos);
        boolean flag = true;
        soo.separador();
        soo.Aperture();
        while (flag == true) {
            soo.separador();
            soo.Admin();
            soo.separador();
            System.out.println("||1. Consultar informacion de estudiante\t||2.Ingresar como administrador para realizar modificaciones\t||3.Salir\t||");
             soo.separador();
            System.out.println("Ingrese la opción que escoja: ");
            op = in.readInteger();
            switch (op) {
                case 1:
                    System.out.println("Consulta tus datos con tu nombre");
                    alu.consultar();
                    break;
                case 2:
                    
                    boolean flag1 = true;
                    boolean flag2 = true;
                    while (flag1 == true) {
                        System.out.println("Ingresa contraseña de administrador: ");
                        contrasena = in.readInteger();
                        switch (contrasena) {
                            case 117:
                                alu.CRUD();
                                ad.archivoAlumnos(alu.registrosAlumnos);
                                while(flag2 == true){
                                    System.out.println("Desea realizar otra modificación\n| 1. Si || 2.No |");
                                    op1 = in.readInteger();
                                    if (op1 == 1){
                                        alu.CRUD();
                                        ad.archivoAlumnos(alu.registrosAlumnos);
                                    }
                                    else if(op1 == 2){
                                        flag2 = false;
                                        flag1 = false;
                                        break;
                                    }
                                    else
                                        System.out.println("Opción incorrecta, por favor intente nuevamente");
                                }
                                break;
                            case 4:
                                flag1 = false;
                                break;
                            default:
                                System.out.println("Contraseña incorrecta. Intente nuevamente\nIngrese 4 para salir");
                                break;                                
                        }
                    }
                case 3:                   
                    soo.Solutions();
                    soo.Bye();
                    flag = false;
                    break;
                default:
                    System.out.println("Opción incorrecta\n Intente nuevamente");
                    break;
            }
        }
        
        
        
    }
    
    
}
