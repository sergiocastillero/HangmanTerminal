/*
*Progama que simula el joc del penjat
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Penjat{

    public static void main(String[] args)  throws IOException{
        int intent = 10;
        String paraula = "recursos/paraules.txt";
        String utilitzades = "";
        int encerts = 0;
        int fallades = 0;
        int cancel = 0;
        int numfigura = 0;
        String lletra = "*";
        String lletresutilitzades = "";
        BufferedReader lecturaparaula = new BufferedReader(new FileReader(paraula));
            
            
        System.out.println("Començem a jugar");

        String linia = lecturaparaula.readLine(); 
        char[] arraylletra;
        arraylletra = new char[linia.length()];
                         
        while (intent >= 0 && intent <= 10) {
            if (intent == 0){
                intent = 10;
                numfigura = 0;
                lletra = "*";
                linia = lecturaparaula.readLine();
                fallades++;
                arraylletra = new char[linia.length()];
            }
            
            
            palabraoculta(lletra, linia, arraylletra);
            
            System.out.print("Utilitzades: ");
            if (lletra != "*" && lletra.length() == 1) {
                lletresutilitzades = lletresutilitzades + lletra.toUpperCase();
                for(int y=0; y<lletresutilitzades.length(); y++){
                    System.out.print(lletresutilitzades.charAt(y));
                    if (y == lletresutilitzades.length()-2){
                        System.out.print(" i ");
                    }else if(y != lletresutilitzades.length()-1){
                        System.out.print(", ");
                    }  
                }
                System.out.println();
            }else if(lletra.length() > 1){
                for(int z=0; z<lletresutilitzades.length(); z++){
                    System.out.print(lletresutilitzades.charAt(z));
                    if (z == lletresutilitzades.length()-2){
                        System.out.print(" i ");
                    }else if(z != lletresutilitzades.length()-1){
                        System.out.print(", ");
                    }  
                }  
                System.out.println();
            }else {
                System.out.println("cap");
            }
            System.out.println("Intents disponibles: "+ intent);
            System.out.println("Introdueix una lletra");
            lletra = Entrada.readLine();  
            
            if (lletra.equals("prou")){
                cancel++;
                System.out.println("Paraules jugades: " + (encerts + fallades + cancel));
                System.out.println("Paraules encertades: " + encerts);
                System.out.println("Paraules fallades: " + fallades);
                System.out.println("Paraules cancel·lades: " + cancel);
                System.out.println("Espero que t'hagis divertit");
                break;
            }else if(lletra.equals("glups")){
                intent = 11;
                numfigura = -1;
                lletra = "*";
                linia = lecturaparaula.readLine();
                cancel++;
                arraylletra = new char[linia.length()];
            }else if ((lletra.isEmpty() || lletra.isBlank()) || !(lletra.charAt(0) >= 'a' && lletra.charAt(0) <= 'z') || lletra.length() > 1){
                System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");
            }
            
            if (linia.contains(lletra) == false  && lletra.length() == 1) {
                intent--;
                mostraFigura(numfigura);
                numfigura++;
            }
        }
        lecturaparaula.close();
    }
    public static void mostraFigura(int numfigura)  throws IOException{
        if (numfigura >= 0){
            String figura = "recursos/figura" + numfigura + ".txt";
            BufferedReader mostrafigura = new BufferedReader(new FileReader(figura));
            while ((figura = mostrafigura.readLine()) != null) {
                System.out.println(figura.strip());
            } 
            mostrafigura.close(); 
        }
    }
    public static void palabraoculta(String lletra, String linia, char[] arraylletra){
        if (lletra.equals("*")){
            for (int j = 0; j < linia.length(); j++){
                arraylletra[j] = lletra.charAt(0);
            }   
        }
        System.out.print("Paraula: ");
        for (int i=0; i<linia.length(); i++){
            if ((linia.charAt(i) == lletra.charAt(0)) && lletra.length() == 1) {
                 arraylletra[i] = linia.charAt(i);
            }
            System.out.print(arraylletra[i]);
        }
        System.out.println();
    }
}   
