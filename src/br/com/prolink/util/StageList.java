/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.model;

import java.util.HashMap;
import java.util.Map;
import javafx.stage.Stage;

/**
 *
 * @author Tiago
 */
public class StageList {

    private static StageList instance;
    private final Map<Class, Stage> mapStages = new HashMap<>();
    //classe usada para armazenar as stage abertas
    public static StageList getInstance(){
        if(instance == null)
            instance = new StageList();
        return instance;
    }
    public Stage findScene(Class classe){
        return mapStages.get(classe);
    }
    public void addScene(Class classe, Stage newScene){
        this.mapStages.put(classe, newScene);
    }
    public void removeScene(Class classe){
        this.mapStages.remove(classe);
    }
}
