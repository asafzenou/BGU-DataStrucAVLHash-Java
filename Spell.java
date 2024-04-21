public class Spell {
    private String name;
    private String category;
    private int powerLevel;
    private String words;

    /**
     *  Constructor
     */
    public Spell(String name, String category, int powerLevel, String words) {
        this.name = name;
        this.category = category;
        this.powerLevel = powerLevel;
        this.words = words;
    }

    /**
     * name getter
     */
    public String getName() {
        return name;
    }

    /**
     * category getter
     */
    public String getCategory() {
        return category;
    }

    /**
     * power level getter
     */
    public int getPowerLevel() {
        return powerLevel;
    }

    /**
     * return the object as a string
     */
    @Override
    public String toString() {
        return name + " (" + category + ") - Power Level: " + powerLevel + ", to cast say: " + words;
    }
}
