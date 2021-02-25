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
        String utilitzades = "";
        
            FileReader fileReader = new FileReader(paraula);
            BufferedReader input = new BufferedReader(fileReader);
            
            
        System.out.println("Començem a jugar");

            String linia = input.readLine();                       
             System.out.print("Paraula: ");
             for (int i=0; i<linia.length(); i++){
                System.out.print("*");
                }
                System.out.println();
                System.out.println("Intents disponibles: "+ intento);
                
                
                System.out.println("Introdueix una lletra");
                String lletra = Entrada.readLine();
         }
 }
         
    
    
