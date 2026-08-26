/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.diegomartinez.system.repository;

import java.sql.CallableStatement;
import java.sql.SQLException;
import org.diegomartinez.system.config.ConexionDB;
import org.diegomartinez.system.model.Users;

/**
 *
 * @author diego
 */
public class UserRepository
        implements UserInterface {

    //CallableStatement
    private CallableStatement callSP;
    //ConexionDB
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    @Override
    public void create(Users user) {
        try {
            callSP = conexionDB.getConnection().prepareCall("{call sp_create_users(?,?,?,?,?)}");
            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastname());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());
            callSP.execute();
            callSP.close(); // Liberar los recurso utilizados
        } catch (SQLException e) {
            System.out.println("Error al crear el usuario");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
