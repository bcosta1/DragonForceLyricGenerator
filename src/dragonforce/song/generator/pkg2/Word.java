package dragonforce.song.generator.pkg2;

/**
 * @author Brandon Costa
 * Stores a word and its syllable count. 
 */
public class Word {
    
    //creates private variables for the word, its syllable count, and its end rhyme
    private final String word;
    private final int syllables;
    
    /**
     * This creates a word and stores its meta-data.
     * @param word the word itself
     * @param syllables the syllable count of the word
     */
    public Word(String word, int syllables){
        this.word = word;
        this.syllables = syllables;
    }

    /**
     * Returns the word.
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the syllable count of the word.
     * @return the syllable count of the word
     */
    public int getSyllables() {
        return syllables;
    }
    
    @Override
    public String toString(){
        return word;
    }
    
}
