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
        int comptadorlletres = 0;
        int paraulesencertades = 0;
        int encerts = 0;
        int fallades = 0;
        int cancel = 0;
        int numfigura = 0;
        String lletra = "*";
        String lletresutilitzades = "";
        BufferedReader lecturaparaula = new BufferedReader(new FileReader(paraula));
            
            
        System.out.println("Comencem a jugar");

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
                comptadorlletres = 0;
                if (null == linia) {
                    System.out.println("No queden més paraules");
                    System.out.println("Paraules jugades: " + (encerts + fallades + cancel));
                    System.out.println("Paraules encertades: " + encerts);
                    System.out.println("Paraules fallades: " + fallades);
                    System.out.println("Paraules cancel·lades: " + cancel);
                    System.out.println("Espero que t'hagis divertit");
                break;
            }
                arraylletra = new char[linia.length()];
            }
            palabraoculta(lletra, linia, arraylletra);
            
            System.out.print("Utilitzades: ");
            if (lletresutilitzades.contains(lletra.toUpperCase()) == true){
                for(int y=0; y<lletresutilitzades.length(); y++){
                    System.out.print(lletresutilitzades.charAt(y));
                    if (y == lletresutilitzades.length()-2){
                        System.out.print(" i ");
                    }else if(y != lletresutilitzades.length()-1){
                        System.out.print(", ");
                    }
                }  
                System.out.println();
                } else if (lletra != "*" && lletra.length() == 1) {
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
            }else if ((intent == 10 && lletra.length() > 1) || lletra == "*"){
                System.out.println("cap");
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
            }
            System.out.println("Intents disponibles: "+ intent);
            System.out.println("Introdueix una lletra");
            lletra = Entrada.readLine();  
            
            if (lletresutilitzades.contains(lletra.toUpperCase()) == true){
                System.out.println("La lletra ja ha estat utilitzada");
            }else if (lletra.toLowerCase().equals("prou")){
                cancel++;
                System.out.println("Paraules jugades: " + (encerts + fallades + cancel));
                System.out.println("Paraules encertades: " + encerts);
                System.out.println("Paraules fallades: " + fallades);
                System.out.println("Paraules cancel·lades: " + cancel);
                System.out.println("Espero que t'hagis divertit");
                break;
            }else if(lletra.toLowerCase().equals("glups")){
                intent = 11;
                numfigura = -1;
                lletra = "*";
                lletresutilitzades = "";
                comptadorlletres = 0;
                linia = lecturaparaula.readLine();
                cancel++;
                 if (null == linia) {
                    System.out.println("No queden més paraules");
                    System.out.println("Paraules jugades: " + (encerts + fallades + cancel));
                    System.out.println("Paraules encertades: " + encerts);
                    System.out.println("Paraules fallades: " + fallades);
                    System.out.println("Paraules cancel·lades: " + cancel);
                    System.out.println("Espero que t'hagis divertit");
                    break;
                }
                arraylletra = new char[linia.length()];
            }else if (lletra.isEmpty() || lletra.isBlank() || !(lletra.toLowerCase().charAt(0) >= 'a' && lletra.toLowerCase().charAt(0) <= 'z') || lletra.length() > 1){
                System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");
            }
            
            if ((linia.contains(lletra.toLowerCase()) == false)  && (lletra.length() == 1) && (lletresutilitzades.contains(lletra.toUpperCase()) == false)) {
                intent--;
                mostraFigura(numfigura);
                numfigura++;
            } else if ((linia.contains(lletra.toLowerCase()) == true)  && (lletra.length() == 1) && (lletresutilitzades.contains(lletra.toUpperCase()) == false)){
                for (int x=0; x < linia.length(); x++) {
                     if (linia.charAt(x) == lletra.toLowerCase().charAt(0)) {
                        comptadorlletres++;
                     }
                 }
            }
            if (comptadorlletres == linia.length()){
                encerts++;
                comptadorlletres = 0;
                intent = 10;
                numfigura = 0;
                lletra = "*";
                lletresutilitzades = "";
                System.out.println("Has encertat! La paraula era " + linia);
                linia = lecturaparaula.readLine();
                if (null == linia) {
                    System.out.println("No queden més paraules");
                    System.out.println("Paraules jugades: " + (encerts + fallades + cancel));
                    System.out.println("Paraules encertades: " + encerts);
                    System.out.println("Paraules fallades: " + fallades);
                    System.out.println("Paraules cancel·lades: " + cancel);
                    System.out.println("Espero que t'hagis divertit");
                    break;
                }
                arraylletra = new char[linia.length()];
            }
        }
        lecturaparaula.close();
    }
    public static void mostraFigura(int numfigura)  throws IOException{
        if (numfigura >= 0){
            String figura = "recursos/figura" + numfigura + ".txt";
            BufferedReader mostrafigura = new BufferedReader(new FileReader(figura));
            while ((figura = mostrafigura.readLine()) != null) {
                System.out.println(figura);
            } 
            mostrafigura.close(); 
            if (numfigura == 9){
                System.out.println("Has mort");
            }
        }
    }
    public static void palabraoculta(String lletra, String linia, char[] arraylletra){
        if (lletra.equals("*")){
            for (int j = 0; j < linia.length(); j++){
                arraylletra[j] = lletra.toLowerCase().charAt(0);
            }   
        }
        System.out.print("Paraula: ");
        for (int i=0; i<linia.length(); i++){
            if ((linia.charAt(i) == lletra.toLowerCase().charAt(0)) && lletra.length() == 1) {
                 arraylletra[i] = linia.charAt(i);
            }
            System.out.print(arraylletra[i]);
        }
        System.out.println();
    }
}   
