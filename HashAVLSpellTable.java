import java.util.LinkedList;
import java.util.List;

public class HashAVLSpellTable {
    private LinkedList<AVLTree> buckets[];
    private int tableSize;
    private int numSpells=0;

    private int capacity;

    /**
     * Constructor- creating link list and every element is null at start
     */
    public HashAVLSpellTable(int size) {
        buckets = new LinkedList[size];
        capacity = size;
        for (int i=0; i < size; i++){
            buckets[i] = null;
        }
        }

    /**
     * Hash function
     */
    private int hash(String category) {
        int hash =0;
        for (int i =0; i < category.length(); i++){
            char ch = category.charAt(i);
            hash = hash + (31 * (int)ch);
        }
        return hash % capacity;
    }


    /**
     * Adding a new spell the hash table, if the hash index is taking, check if
     * there is already the spell category and if yes add the spell his AVl tree category
     * and if not then crate new avl tree as it own category
     */
    public void addSpell(Spell s) {
        numSpells++;
        int index = hash(s.getCategory());
        if (buckets[index] == null){  // not taken
            LinkedList<AVLTree> new_link_list = new LinkedList<>();  // new link list to its index
            AVLTree new_avl = new AVLTree(s);  // new avl tree
            new_link_list.add(new_avl);
            buckets[index] = new_link_list;
        }
        else { // was taken
            LinkedList<AVLTree> link_list = buckets[index];
            boolean found_avl = false;
            for (AVLTree avlTree : link_list) {  // check spell category have already an avl tree
                if (s.getCategory().equals(avlTree.getCategory())) {  // if there is then adding the new spell to the avl tree
                    avlTree.insert(s);
                    found_avl = true;
                    break;
                }

            }
            if (!found_avl){  // if there not then create new avl tree
                AVLTree new_avl = new AVLTree(s);
                link_list.add(new_avl);
            }
        }
    }

    /**
     * Searching for the spell in the link list avl trees
     */
    public Spell searchSpell(String category, String spellName, int powerLevel) {
        int index = hash(category);
        if (buckets[index] != null){
            LinkedList<AVLTree> link_list = buckets[index];
            for (AVLTree avlTree : link_list) {
                if ((category.equals(avlTree.getCategory()))){
                    return avlTree.search(spellName, powerLevel);  // found
                }
            }
        }
        return null;  // not exits return null
    }

    /**
     * return the nuber of spell in all the hash table
     */
    public int getNumberSpells(){
        return numSpells;
    }

    /**
     * returning the number of spells in the avl tree category
     */
    public int getNumberSpells(String category){
        int index = hash(category);
        if (buckets[index] != null){
            LinkedList<AVLTree> link_list = buckets[index];
            for (AVLTree avlTree : link_list) {
                if ((category.equals(avlTree.getCategory()))){
                    return avlTree.getSize();  // retuning the avl tree size
                }
            }
        }
        return 0;  // not exits return zero
    }

    /**
     * retuning the biggest top k spells in the same category
     */
    public List<Spell> getTopK(String category, int k) {
        int index = hash(category);
        if (buckets[index] != null){
            LinkedList<AVLTree> link_list = buckets[index];
            for (AVLTree avlTree : link_list) {
                if ((category.equals(avlTree.getCategory()))) {
                    return avlTree.getTopK(k);
                }
            }
        }
        return null;  // not exits
    }
}
