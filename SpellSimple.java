public class SpellSimple {
    private String name;
    private String words;

    /**
     * Constructor
     */
    SpellSimple(String name, String words) {
        this.name = name;
        this.words = words;
    }

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * magic spell getter
     */
    public String getWords(){
        return words;
    }
}