/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos_trabajadores;

/**
 *
 * @author javie
 */
public class Persona {
    
    private static String nombre;
    private static int dni;
    private int horas= 0;
    private static String apellidos;
    
    public static void setdni(int num){

        dni = num;

    }//()
    
    public static void setnombre(String nom){

        nombre = nom;

    }//()    
    
    public static void setapellidos(String surname){

        apellidos = surname;

    }//()    
    
    public void add_horas(int horas_anyadidas){

        horas = horas + horas_anyadidas;

    }//()        
    
    
    public String getnombre(){
    
      return this.nombre;
    
    }//()
    
    public String getapellidos(){
    
        return this.apellidos;
    }//()
    
    public int getdni(){
        
        return this.dni;
    }//()
    
    public int gethoras(){
    
        return this.horas;
    }//()
    
}// class
