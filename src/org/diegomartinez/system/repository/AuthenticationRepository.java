/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.diegomartinez.system.repository;

/**
 *
 * @author diego
 */
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.diegomartinez.system.config.ConexionDB;
import org.diegomartinez.system.interfaces.AuthenticationInterface;
import org.diegomartinez.system.model.Users;

public class AuthenticationRepository implements AuthenticationInterface {

    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    @Override
    public Users login(String email, String password) {
        Users user = null;

        try {
            CallableStatement callSP = conexionDB.getConnection().prepareCall("{call sp_create_user(?, ?)}");
            callSP.setString(1, email);
            callSP.setString(2, password);

            ResultSet rs = callSP.executeQuery();

            if (rs.next()) {
                user = new Users();
                user.setIdUser(rs.getInt("id_user"));
                user.setUser(rs.getString("user"));
                user.setName(rs.getString("name"));
                user.setLastname(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
            }
            rs.close();
            callSP.close();

        } catch (SQLException e) {
            System.out.println("Error en login repository: " + e.getMessage());
        }
    }

}
