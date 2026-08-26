package org.diegomartinez.system.config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author informatica
 */
public class ConexionDB {
    private static ConexionDB instanciaConexionDB;
    private Connection connection;
    
    private ConexionDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // CORRECCIÓN 1: Verifica que tu clase de constantes se llame "Environment" (con 'n')
            // Si tu archivo se llama exactamente "Enviroment.java" (sin la n), cámbialo aquí de vuelta.
            connection = DriverManager.getConnection(
                "jdbc:mysql://" + Environment.LOCATION_SERVICE + "/" + Environment.DATA_BASE, 
                Environment.USER, 
                Environment.PASSWORD
            );
            
        } catch (ClassNotFoundException classNotFound) {
            System.out.println("Error de clase no encontrada: " + classNotFound.getMessage());
        } catch (SQLException sqlException) {
            System.out.println("Error de conexion SQL: " + sqlException.getMessage());
        } catch (Exception e) {
            System.out.println("Error padre: " + e.getMessage());
        }
    }
    
    public static ConexionDB getInstanciaConexionDB(){
        if(instanciaConexionDB == null) {
            instanciaConexionDB = new ConexionDB();
        }
        return instanciaConexionDB;
    }
    
    // CORRECCIÓN 2: Agregamos este método getter que faltaba
    // Esto es lo que permite que UserRepository haga: ConexionDB.getInstanciaConexionDB().getConnection()
    public Connection getConnection() {
        return this.connection;
    }
}