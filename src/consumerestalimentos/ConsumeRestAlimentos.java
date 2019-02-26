/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumerestalimentos;

import Consumes.ConsumesAlimento;
import java.util.List;
import model.Alimento;
import util.HttpRequest;

/**
 *
 * @author William
 */
public class ConsumeRestAlimentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ConsumesAlimento consumesAlimento = new ConsumesAlimento();
       
        Alimento alimento = new Alimento();
        //alimento.setIdAlimento(5);
        alimento.setNome("laranja");
        alimento.setCalorias(200);
        alimento.setGordura(1.9);
        alimento.setCarboidratos(20);
        alimento.setPorcao("100g");
        
        consumesAlimento.PostAlimento(alimento);
        
        //String retorno = consumesAlimento.DeleteAlimento(6) ;
        
        
        
    }
    
}
