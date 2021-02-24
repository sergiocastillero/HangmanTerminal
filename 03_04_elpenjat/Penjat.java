/*
*Progama que simula el joc del penjat
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Penjat{

    public static void main(String[] args)  throws IOException{
        
        int intento = 10;
        
        String paraula = "recursos/paraules.txt";
        
            FileReader fileReader = new FileReader(paraula);
            
            BufferedReader input = new BufferedReader(fileReader);
            
            char [] respostes = new char [paraula.length()];
            
        System.out.println("Començem a jugar");
        
      
        for (int i=0; i<paraula.length(); i++){
        
               respostes[i] = '*';  //cambia la palabra por *
   
                System.out.println("Paraula: "+ respostes); 
         }
         
         
         }
 }
         
    
    
