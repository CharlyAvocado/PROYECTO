/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.S
 */
package com.mycompany.poop_proyecto;

/**
 *
 * @author ApertureSolutions
 */
import java.io.IOException;
import java.util.Scanner;


public class Alumno extends AdmnistracionEscolar {
    

    protected String[][] registrosAlumnos = new String[500][2];
    protected String[] datosAlumnos = new String[500];
    protected int[] semestre=new int[500];
/**
 * Esta clase se encarga de consultar o modificar los datos de los alumnos
 * @throws IOException 
 */
    public Alumno() throws IOException {
        GeneradorNombres pr1 = new GeneradorNombres();
        Datos pr = new Datos();
        RegistrosAcademicos reg = new RegistrosAcademicos();
        GeneradorNumerosInscripcion NumInscripcion = new GeneradorNumerosInscripcion();
        this.nombreCompleto = pr1.generarNombre(pr1.nombres, pr1.apellidosP,pr1.apellidosM);
        this.edades = pr.generar();
        this.semestres = pr.generarSemestre();
        this.asiganturasCreditos = reg.generarAsignaturas(this.semestres);
        this.promedios = reg.generarPromedio();
        this.direcciones = pr.generarDirecciones();
        this.numeroInscripcion = NumInscripcion.generarNumero(reg.totalMateriasReprobadas, this.asiganturasCreditos,
        this.promedios, reg.creditosDescontar);
        this.materias=reg.generarMaterias();
        this.calificaciones=reg.getCalificaciones();

    }

    protected String[][] traerDatos( ) {
        for (int i = 0; i < this.datosAlumnos.length; i++) {
            this.datosAlumnos[i] = this.edades[i] + ", " + this.semestres[i] + ", " + this.numeroInscripcion[i] + ", "
                    + this.direcciones[i]+ "\n ,Materias,"+materias[i]+ "\n ,Calificaciones,"+calificaciones[i];
            for (int j = 0; j < registrosAlumnos[i].length; j++) {
                if (j == 0)
                    this.registrosAlumnos[i][j] = nombreCompleto[i];
                else if (j == 1)
                    this.registrosAlumnos[i][j] = datosAlumnos[i];
            }
        }
        return registrosAlumnos;
    }
    
    public void CRUD(){
        String name;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int indiceAcambiar=-1;
        while(flag == true){
            System.out.println("Ingrese el nombre del alumno a modificar con el formato:\n Nombre (s) Apellido Apellido");
            name = sc.nextLine();
            
            for (int i = 0; i < nombreCompleto.length; i++) {
                if (name.equals(nombreCompleto[i])){
                    indiceAcambiar=i;
                    flag=false;
                    break;
                }else if(i == 501){
                    System.out.println("Alumno no encontrado");
                }
            }
        }
        KeyboardInput in = new KeyboardInput();
        int op;
        System.out.println("Ingrese la opción que desea cambiar\n1.Edad || 2.Semestres || 3.Dirección || 4.Salir\n");
        op = in.readInteger();
        int cambio = 0;
        String cambioDir = "";
        switch (op) {
                case 1:
                    while(true){
                        System.out.println("Ingrese el nuevo valor de la edad: ");
                        cambio = in.readInteger();
                        if (cambio > 18 && cambio < 28){
                            this.edades[indiceAcambiar] = cambio;
                            break;
                        }else
                            System.out.println("Edad inválida. Intente nuevamente");
                    }
                    traerDatos( );
                break;
                case 2:
                    cambio = 0;
                    //boolean flag = true;
                    while(true){
                        System.out.println("Ingrese el nuevo valor del semestre: ");
                        cambio = in.readInteger();
                        if (cambio > 1 && cambio < 11){
                            this.semestres[indiceAcambiar] = cambio;
                            break;
                        }else
                            System.out.println("Semestre inválido. Intente nuevamente");
                    }
                    traerDatos( );
                break;    
                case 3:
                    System.out.println("Escriba la nueva dirección: \nCon el formato: Estado Delegación Colonia");
                    cambioDir = sc.nextLine();
                    this.direcciones[indiceAcambiar]= cambioDir;
                    traerDatos( );
                    break;
                
                case 4:
                    System.out.println("Salir");
                    break;
                
                default:
                    System.out.println("Opción incorrecta. Intente nuevamente\nIngrese 4 para salir");
        }
    }

    protected void consultar() {
        // metodo para consultar los datos de un alumno en específico
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu nombre con el formato:\n Nombre(s) Apellido Apellido");
        name = sc.nextLine();
        for (int i = 0; i < nombreCompleto.length; i++) {
            if(name.equals(nombreCompleto[i])){
                System.out.println("Edad: "+ this.edades[i] + "\nSemestre: " + this.semestres[i] + "\nNumero de inscripción: " + this.numeroInscripcion[i] + "\nDirección: "
                    + this.direcciones[i]+ "\nMaterias: "+materias[i]+ "\nCalificaciones: "+calificaciones[i]);
                break;
            }else if (i == 500)
                System.out.println("Alumno no encontrado");
        
        }
    }
}
