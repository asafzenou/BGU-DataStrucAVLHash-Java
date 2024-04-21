import java.util.Objects;

public class MainPart1 {
    public static void main(String[] args) {
        DoubleHashTable table = new DoubleHashTable(7);

        // Add some spells to the table
        table.put(new SpellSimple("Abracadabra", "Avada Kedavra"));
        table.put(new SpellSimple("Expecto Patronum", "I’m gonna stand here like a unicorn"));
        table.put(new SpellSimple("Wingardium Leviosa", "Get up, stand up"));
        table.put(new SpellSimple("Shazam", "24K Magic in the air"));

        // Get the spells by name
        if (!Objects.equals(table.getCastWords("Shazam"), "24K Magic in the air")){
            System.out.println("Shazam: " + table.getCastWords("Shazam")); // prints "24K Magic in the air"
            }
        if (!Objects.equals(table.getCastWords("Abracadabra"), "Avada Kedavra")){
            System.out.println("Abracadabra: " + table.getCastWords("Abracadabra")); // prints "Avada Kedavra"
        }

        // Get the size of the table
        if (table.getSize() != 4){
            int size = table.getSize();
            System.out.println("Table size: " + "4 and not " + size); // prints "Table size: 4"
        }


        Spell spell_10 = new Spell("Disarming Charm", "Harry", 10, "Expelliarmus");
        Spell spell_12 = new Spell("Patronus Charm", "Harry", 12, "Expecto Patronum");
        Spell spell_5 = new Spell("Levitation Charm", "Harry", 5, "");
        Spell spell_3 = new Spell("Summoning Charm", "Harry", 3, " Accio");
        Spell spell_9 = new Spell(" Killing Curse", "Harry", 9, "Avada Kedavra");
        Spell spell_1 = new Spell("Unlocking Charm", "Harry", 1, "Alohomora ");
        Spell spell_11 = new Spell("Wand-Lighting Charm", "Harry", 11, "Lumos");
        Spell spell_13 = new Spell("Full Body-Bind Curse", "Harry", 13, "Petrificus Totalus");


        //left_left checker
        AVLTree avl_1 = new AVLTree(spell_10);
        avl_1.insert(spell_12);
        avl_1.insert(spell_5);
        avl_1.insert(spell_3);
        avl_1.insert(spell_9);
        //after spell one rotate left_left
        avl_1.insert(spell_1);
//        int size = 6; // Update the size to match the number of elements in the AVL tree
//        int[] result = avl_1.inorder();
//        for (int i = 0; i < size; i++) {
//            System.out.println(result[i]);
//        } // 1 3 5 9 10 12
        //System.out.println(avl_1.getTopK(3));


        //right_right checker
        AVLTree avl_2 = new AVLTree(spell_9);
        avl_2.insert(spell_5);
        avl_2.insert(spell_11);
        avl_2.insert(spell_10);
        avl_2.insert(spell_12);
        //after spell one rotate right_right
        avl_2.insert(spell_13);
//        int size = 6; // Update the size to match the number of elements in the AVL tree
//        int[] result = avl_2.inorder();
//        for (int i = 0; i < size; i++) {
//            System.out.println(result[i]);
//        }
//        System.out.println(avl_2.getTopK(3));

        // Right_left
        AVLTree avl_3 = new AVLTree(spell_3);
        avl_3.insert(spell_1);
        avl_3.insert(spell_12);
        avl_3.insert(spell_10);
        avl_3.insert(spell_13);
        avl_3.insert(spell_11);
//        int size = 6; // Update the size to match the number of elements in the AVL tree
//        int[] result = avl_3.inorder();
//        for (int i = 0; i < size; i++) {
//            System.out.println(result[i]);
//        }
//        System.out.println(avl_3.getTopK(3));

        // Left_right
        AVLTree avl_4 = new AVLTree(spell_12);
        avl_4.insert(spell_5);
        avl_4.insert(spell_13);
        avl_4.insert(spell_3);
        avl_4.insert(spell_11);
        avl_4.insert(spell_10);
//        int size = 6; // Update the size to match the number of elements in the AVL tree
//        int[] result = avl_4.inorder();
//        for (int i = 0; i < size; i++) {
//            System.out.println(result[i]);
//        }
//        System.out.println(avl_4.getTopK(3));

        AVLTree avl_5 = new AVLTree(spell_10);
        avl_5.insert(spell_9);
        avl_5.insert(spell_5);

        AVLTree avl_6 =  new AVLTree(spell_10);
        avl_6.insert(spell_5);
        avl_6.insert(spell_9);

        AVLTree avl_7 =  new AVLTree(spell_5);
        avl_7.insert(spell_9);
        avl_7.insert(spell_10);

        AVLTree avl_8 =  new AVLTree(spell_5);
        avl_8.insert(spell_10);
        avl_8.insert(spell_9);


        AVLTree avl_10 = new AVLTree(spell_10);
        avl_10.insert(spell_5);
        avl_10.insert(spell_9);
        avl_10.insert(spell_11);
        avl_10.insert(spell_12);










    }
}