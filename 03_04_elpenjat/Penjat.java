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
            
            
            
        System.out.println("Començem a jugar");

            String linia = input.readLine();                       
            String str = linia;
             for (int i=0; i<linia.length(); i++){
                str= str + "*";
                System.out.print("Paraula: "+ str); 
                }
                
                System.out.println("Intents disponibles: "+ intento);
                
                
                System.out.println("Introdueix una lletra");
                 String lletra = Entrada.readLine();
         }
 }
         
    
    
