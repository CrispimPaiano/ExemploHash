package exemplo00;

import java.util.HashMap;

/**
 * @author Crispim Paiano dos Santos
 */

public class Exemplo01 {

    public static void main(String[] args) {
        
        HashMap<String, Integer> idades = new HashMap<>();
        idades.put("Cleiton", 22);
        idades.put("Kleyton", 24);
        
        if(idades.containsKey("Kreyton")){
            System.out.println("TEM KREYTOM");
        }else{
            System.out.println("NÃO TEM KREYTOM");
        }
        
        // Pega 
        int idade = idades.get("Kleyton");
        System.out.println("Idade do Kleyton: " + idade);
        
        // Altera o valor daquela chave
        idades.put("Kleyton", 27);
        
        idade = idades.get("Kleyton");
        System.out.println("Idade nova do Kleyton: " + idade);
        
    }
    
}
