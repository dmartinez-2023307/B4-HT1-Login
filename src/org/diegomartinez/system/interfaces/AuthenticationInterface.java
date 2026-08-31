/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.diegomartinez.system.interfaces;

import org.diegomartinez.system.model.Users;

/**
 *
 * @author diego
 */
public interface AuthenticationInterface {
    Users login(String email, String password);
}
