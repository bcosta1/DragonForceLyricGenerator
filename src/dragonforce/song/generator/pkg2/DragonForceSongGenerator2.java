package dragonforce.song.generator.pkg2;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Slicer001
 * The main class of the program. 
 * Generates the full songs and the UI. 
 */
public class DragonForceSongGenerator2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        generateSong(7+rand.nextInt(8), 4+rand.nextInt(3), 3+rand.nextInt(4));
    }
    
    public static void generateSong(int syllableCount, int stanzaSize, int chorusSize){
        //procedurally generates a song chorus and title
        ArrayList<Line> chorus = new ArrayList<>();
        for(int i = 0; i < chorusSize-1; i++){
            chorus.add(new Line(syllableCount));
        }
        Line titleLine = new Line(syllableCount-3);
        Line title = new Line(3);
        chorus.add(titleLine);
        chorus.add(title);
        
        System.out.println(title.toString().toUpperCase());
        System.out.println();
        
        //procedurally generates and prints the first verse
        System.out.println("[first verse]");
        for(int i = 0; i < stanzaSize; i ++){
            System.out.println(new Line(syllableCount));
        }
        System.out.println();
        for(int i = 0; i < stanzaSize; i++){
            System.out.println(new Line(syllableCount));
        }
        System.out.println();
        
        //prints the chorus
        System.out.println("[chorus]");
        for(int i = 0; i < chorus.size(); i++){
            System.out.println(chorus.get(i));
        }
        System.out.println();
        
        //procedurally generates and prints the second verse
        System.out.println("[second verse]");
        for(int i = 0; i < stanzaSize; i++){
            System.out.println(new Line(syllableCount));
        }
        System.out.println();
        for(int i = 0; i < stanzaSize; i++){
            System.out.println(new Line(syllableCount));
        }
        System.out.println();
        
        //prints the chorus
        System.out.println("[chorus]");
        for(int i = 0; i < chorus.size(); i++){
            System.out.println(chorus.get(i));
        }
        System.out.println();
        
        //random instumental/solo
        Random rand = new Random();
        System.out.print("[");
        System.out.print(Words.adj());
        System.out.print(" ");
        switch(rand.nextInt(3)){
            case(0):
                System.out.print("guitar");
                break;
            case(1):
                System.out.print("bass");
                break;
            case(2):
                System.out.print("drum");
                break;
            default:
                System.out.print("guitar");
        }
        System.out.print(" ");
        if(rand.nextBoolean())
            System.out.print("solo");
        else
            System.out.print("instrumental");
        System.out.println("]");
        System.out.println();
        
        //prints the chorus
        System.out.println("[chorus]");
        for(int i = 0; i < chorus.size(); i++){
            System.out.println(chorus.get(i));
        }
        System.out.println();
    }
    
}
