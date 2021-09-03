/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragonforce.song.generator.pkg2;

import java.util.Random;

/**
 * @author Slicer001
 * Randomly generates and stores a line of the song. 
 */
public class Line {
    
    //intializes a random
    Random rand = new Random();
    
    //stores the minimum syllables and total syllables
    private int minSyllables, totalSyllables;
    
    //stores the generated line
    private final String line;
    
    /**
     * Constructs and randomly generates a new Line.
     * @param minSyllables the least amount of syllables allowed in the line
     */
    public Line(int minSyllables){
        this.minSyllables = minSyllables;
        
        switch(rand.nextInt(4)){
            case(0):
                line = pronoun();
                break;
            case(1):
                line = noun();
                break;
            case(2):
                line = verb("ing");
                break;
            case(3):
                line = prep();
                break;
            default:
                line = pronoun();
        }
    }
    
    /**
     * Returns a random string starting with a pronoun.
     * @return a random string starting with a pronoun
     */
    private String pronoun(){
        totalSyllables++;
        if(rand.nextBoolean())
            return "they " + verb("justplural");
        return "we " + verb("justplural");
    }
    
    /**
     * Returns a random string starting with a noun.
     * @return a random string starting with a noun
     */
    private String noun(){
        //establishes a starting string to return
        String result = "";
        
        //chance of article/our/their
        if(rand.nextBoolean()){
            totalSyllables++;
            if(rand.nextInt(4) == 0){
                if(rand.nextBoolean())
                    result += "our ";
                else
                    result += "their ";
            }else{
                result += "the ";
            }
        }
        
        //chance of adjective
        if(rand.nextBoolean()){
            Word adj = Words.adj();
            totalSyllables += adj.getSyllables();
            result += adj.getWord() + " ";
        }
        
        //determines whether the noun is singular or plural
        String type;
        if(rand.nextBoolean())
            type = "singular";
        else
            type = "plural";
        
        //pulls a random noun
        Word noun = Words.noun(type);
        totalSyllables += noun.getSyllables();
        result += noun.getWord();
        
        //returns current result and nothing more if the syllable count is too high
        if(totalSyllables >= minSyllables)
            return result;
        
        //randomly determines what follows the noun
        switch(rand.nextInt(3)){
            case(0):
                return result + " of " + noun();
            case(1):
                return result + " " + verb(type);
            case(2):
                return result + " " + prep();
        }
        return result + " of " + noun();
    }
    
    /**
     * Returns a random string starting with a verb.
     * @param type either "ing", "singular", "plural", or "justplural"
     * @return a random string starting with a verb
     */
    private String verb(String type){
        //pulls a random verb
        Word verb = Words.verb(type);
        totalSyllables += verb.getSyllables();
        
        //returns the verb and nothing more if the syllable count is too high
        if(totalSyllables >= minSyllables)
            return verb.getWord();
        
        //randomly determines what follows the verb
        if(rand.nextBoolean())
            return verb.getWord() + " " + noun();
        return verb.getWord() + " " + prep();
    }
    
    /**
     * Returns a random string starting with a preposition.
     * @return a random string starting with a preposition
     */
    private String prep(){
        //pulls a random preposition
        Word prep = Words.prep();
        totalSyllables += prep.getSyllables();
        
        //returns the preposition and nothing more if the syllable count is too high
        if(totalSyllables >= minSyllables)
            return prep.getWord();
        
        //prepositions are always followed by nouns
        return prep.getWord() + " " + noun();
    }
    
    @Override
    public String toString(){
        return line;
    }
    
}
