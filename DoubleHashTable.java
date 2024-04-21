public class DoubleHashTable {
    private SpellSimple[] table;
    private int capacity;
    private int size=0;
    private int steps=0;

    /**
     * Constructor
     * @param capacity - Creating hash table in the size of the capacity
     */
    public DoubleHashTable(int capacity) {
        table = new SpellSimple[capacity];
        this.capacity = capacity;
    }

    /**
     *  Putting the new spell in the right index, if the index is taking then steps++ doing another loop with index++
     *  open addressing hash
     */
    public boolean put(SpellSimple spell) {
        steps = 0;  // reset
            int index = -1;
            if (capacity == size){
                return false;
            }

            while (true){
                index++;
                int check_in_table = (hash1(spell.getName()) + index * hash2(spell.getName())) % capacity;  // hashing
                if (index > 0){  // index is taking
                    steps++;
                }
                if (table[check_in_table] == null){ // index is npt taking
                    table[check_in_table] = spell;
                    size++;
                    return true;
                }
            }
    }

    /**
     * We are getting the key and want to return the value which is the magic spell
     */
    public String getCastWords(String name) {
        int index = 0;
        while (index < capacity){  // Going every index
            int check_in_table = (hash1(name) + index * hash2(name)) % capacity;
            if (table[check_in_table] != null && table[check_in_table].getName() == name){  // equals
                return table[check_in_table].getWords();
            }
            index++;
        }
        return null;
    }

    /**
     * return size - int
     */
    public int getSize() {
        return size;
    }

    /**
     * return last steps
     */
    public int getLastSteps() { return steps; }

    /**
     * First hash function
     */
    private int hash1(String name) {
        int hash =0;
        for (int i =0; i < name.length(); i++){
            char ch = name.charAt(i);
            hash = hash + (31 * (int)ch);
        }
        return hash % capacity;
    }

    /**
     *  Second hash function
     */
    private int hash2(String name) {
        int hash =0;
        for (int i =0; i < name.length(); i++){
            char ch = name.charAt(i);
            hash = hash + (13 * (int)ch);
        }
        return 1+hash % (capacity-2);
    }
}