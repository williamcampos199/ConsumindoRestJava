/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumes;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Alimento;
import util.HttpRequest;

/**
 *
 * @author William
 */
public class ConsumesAlimento {
    private String url = "http://localhost:8080/Comida/webresources/alimentos";
    
    public List<Alimento> GetAlimentos(){
        
         HttpRequest httpRequest = new HttpRequest();
        
        String json = httpRequest.sendGet(url);
        
        System.out.println(json);
        
        Gson g = new Gson();
        
    Alimento[] alimentoArray =  g.fromJson(json, Alimento[].class);
    
    //List<Alimento> alimentos = Arrays.asList(alimentoArray);
    List<Alimento> alimentos = new ArrayList<>(Arrays.asList(alimentoArray));
    
    return alimentos;
    }
        
    
    
    
    
}
