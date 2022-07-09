/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datos_trabajadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Datos_trabajadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Datos_trabajadores datos1 = new Datos_trabajadores();
        
        datos1.login();
        
    }
    
    
   
    public void login(){
        
        Scanner scanner = new Scanner(System.in);
            
        System.out.println("Indica tu nombre de usuario");
        
        String username = scanner.nextLine();
        
        try{
                LogicaDelNegocio logica = new LogicaDelNegocio("jdbc:sqlite:D:/Users/javier/Documents/GITHUB/datos_trabajadores/src/datos_trabajadores/datos.db;");
        
                
                Persona p1 = logica.getPersonaPorUsuario(username);
                        
                String contraseña1  = scanner.nextLine();
                
                boolean pass_ok = contraseña1.equals(p1.getpassword());

                while(pass_ok == false){
                    
                    System.out.println("La password es incorrecta, TRY AGAIN");
                    contraseña1= scanner.nextLine();
                    pass_ok = contraseña1.equals(p1.getpassword());
                        
                }// while
                
                    
                
               

        System.out.println("TODO OK, TU DNI ES: " + p1.getdni());
  
        
       
        } catch(SQLException ex){
        
            System.out.println("excepcion  " + ex.getMessage());
        
        }
           
    
    }
    
        
class LogicaDelNegocio {

	private final Connection laConexion;

	// ---------------------------------------------------------------------
	// urlBD: Texto -> () ->
	// ---------------------------------------------------------------------
	public LogicaDelNegocio(String urlBD) throws SQLException {
		this.laConexion = DriverManager.getConnection(urlBD);

		assert this.laConexion != null;
	} // ()

	// ---------------------------------------------------------------------
	// dni: Texto -> () <-
	// Persona    <-
	// ---------------------------------------------------------------------
	public Persona getPersonaPorUsuario(String usuario) {
		try {
			assert this.hayConexion();
			String textoSQL = "select * from Persona where usuario='" + usuario + "';";

			Statement sentencia = this.laConexion.createStatement();

			ResultSet resultados = sentencia.executeQuery(textoSQL);
			if (resultados.next() == false) {
				return null;
			}

			return new Persona(resultados.getString("usuario"), resultados.getString("contraseña"), resultados.getString("dni"), resultados.getString("nombre"), resultados.getString("apellidos"));

		} catch (SQLException ex) {
			return null;
		}

	} // ()

	// ---------------------------------------------------------------------
	// VoF <- () <- 
	// ---------------------------------------------------------------------
	private boolean hayConexion() {
		try {
			return this.laConexion.isClosed() == false;
		} catch (SQLException ex) {
			return false;
		}
	}

	// ---------------------------------------------------------------------
	//  () -> 
	// ---------------------------------------------------------------------
	public void cerrarConexion() {
		try {
			this.laConexion.close();
		} catch (SQLException ex) {
// ignoro porque, total, iba a cerrar
		}

	} // ()
} // class
    

}
