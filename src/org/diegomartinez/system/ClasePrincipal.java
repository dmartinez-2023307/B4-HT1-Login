/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.diegomartinez.system;

import javafx.application.Application;
import javafx.stage.Stage;
import org.diegomartinez.system.utils.SceneManager;
import org.diegomartinez.system.utils.ViewFactory;

/**
 *
 * @author informatica
 */
public class ClasePrincipal extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start (Stage stageRoot){
        SceneManager.getInstanciaSceneManager().setStagePrincipal(stageRoot);
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }
    
}

// LA PEOPLE ANDA ACTIVA ALLA EN CULIACAN
/**
 * DICEN QUE HAY POLVOS QUE NO SE OLVIDAN Y YO VOYU A SERT TU ANTOJO DE POR VIDA
 * 
 */