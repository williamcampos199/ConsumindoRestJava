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
       
        List<Alimento> alimentos = consumesAlimento.GetAlimentos();
        
        for(Alimento a :  alimentos ){
            System.out.println("Alimento " +  a.getNome() + " calorias " + a.getCalorias() );
    }
        
    }
    
}
