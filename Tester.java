import java.util.ArrayList;
import java.util.List;


/**
 * Tester class
 */
public class Tester {
    private static boolean testPassed = true;
    private static int testNum = 0;

    /**
     * Testing the prohect classes
     */
    public static void main(String[] args) {

        Part_one();
        testAVLTree();
        Part_two();



        // Notifying the user that the code have passed all tests.
        if (testPassed) {
            System.out.println("All " + testNum + " tests passed!");
        }
    }
    /**
     * Couning the number of tests and if test did not pass print what test was bad and if all test was good then print the number of test that passed
     */
    private static void test(boolean exp, String msg) {
        testNum++;

        if (!exp) {
            testPassed = false;
            System.out.println("Test " + testNum + " failed: "  + msg);
        }
    }

    /**
     * Part one is checking the classes DoubleHashTable and SpellSimple
     */
    private static void Part_one(){
        DoubleHashTable table = new DoubleHashTable(7);
        table.put(new SpellSimple("Abracadabra", "Avada Kedavra"));
        table.put(new SpellSimple("Expecto Patronum", "I’m gonna stand here like a unicorn"));
        table.put(new SpellSimple("Wingardium Leviosa", "Get up, stand up"));
        table.put(new SpellSimple("Shazam", "24K Magic in the air"));

        test((table.getCastWords("Shazam").equals("24K Magic in the air")), "Part one - Shazam: " + table.getCastWords("Shazam"));
        test((table.getCastWords("Abracadabra").equals("Avada Kedavra")), "Part one - Abracadabra: " + table.getCastWords("Abracadabra"));
        test(table.getSize() == 4, "Part one - Table size: " + "is 4 and not " + table.getSize());
        test(table.getLastSteps() == 1,"Part one - Table steps: " + "is 1 and not " + table.getLastSteps() );
    }

    /**
     * Class tester of the classes HashAVLSpellTable, Spell
     */
    private static void Part_two(){

        // create a new hash AVL spell table
        HashAVLSpellTable table = new HashAVLSpellTable(10);

        Spell spell1 = new Spell("fireball", "fire", 10, "fireball!");
        Spell spell2 = new Spell("frostbolt", "ice", 7, "freeze please");
        Spell spell3 = new Spell("thunderstorm", "lightning", 9, "I`m going to shock you");
        Spell spell4 = new Spell("poison spray", "poison", 5, "sssss");
        Spell spell5 = new Spell("shockwave", "lightning", 8, "go pikachu!");
        Spell spell6 = new Spell("flamethrower min", "fire", 6, "foo");
        Spell spell7 = new Spell("flamethrower", "fire", 8, "foo better");
        Spell spell8 = new Spell("fireball II", "fire", 12,"fireball!!");
        Spell spell9 = new Spell("flamethrower II", "fire", 15, "foooooooo!");
        Spell spell10 = new Spell("shockwave II", "lightning", 10,"be useful pikachu.");
        Spell spell11 = new Spell("frost nova", "ice", 4, "chill dude");
        Spell spell12 = new Spell("lightning bolt", "lightning", 11, "go lightning bolt");

        table.addSpell(spell1);
        table.addSpell(spell2);
        table.addSpell(spell3);
        table.addSpell(spell4);
        table.addSpell(spell5);
        table.addSpell(spell6);
        table.addSpell(spell7);
        table.addSpell(spell8);
        table.addSpell(spell9);
        table.addSpell(spell10);
        table.addSpell(spell11);
        table.addSpell(spell12);

        //Test number of spells for reach category
        test(table.getNumberSpells() == 12, "Part two- The number of spells need to be 12 but its " + table.getNumberSpells());
        test(table.getNumberSpells("fire") == 5, "Part two- The number of spells need to be 5 but its " + table.getNumberSpells("fire"));
        test(table.getNumberSpells("ice") == 2, "Part two- The number of spells need to be 2 but its " + table.getNumberSpells("ice"));
        test(table.getNumberSpells("lightning") == 4, "Part two- The number of spells need to be 4 but its " + table.getNumberSpells("lightning"));
        test(table.getNumberSpells("poison") == 1, "Part two- The number of spells need to be 1 but its " + table.getNumberSpells("poison"));

        //Top K function checking
        List<Spell> check_lightning_topK = new ArrayList<>();
        check_lightning_topK.add(spell12);
        check_lightning_topK.add(spell10);
        check_lightning_topK.add(spell3);
        check_lightning_topK.add(spell5);
        test((table.getTopK("lightning", 4).equals(check_lightning_topK)),"Part two- the output need to be [12,10,3,5] bit its " + table.getTopK("lightning", 4));
        List<Spell> check_poison_topK = new ArrayList<>();
        check_poison_topK.add(spell4);
        test((table.getTopK("poison", 1).equals(check_poison_topK)),"Part two- the output need to be [4] bit its " + table.getTopK("poison", 1));

        //Checking if spell exists
        test(table.searchSpell("poison", "poison spray", 5) == spell4, "Part two - the poison need to be found and it is spell4");
        test(table.searchSpell("lightning", "thunderstorm", 9) == spell3, "Part two - the lightning need to be found and it is spell3");
        test(table.searchSpell("lightning", "bulibuli", 9) == null, "The spell dost exists, lightning, bulibuli, 9");
        test(table.searchSpell("lightning", "thunderstorm", 7) == null, "The spell dost exists, lightning, thunderstorm, 7");

        Spell spell13 = new Spell("dance in the rain", "lightning", 7, "just dance");
        table.addSpell(spell13);
        test(table.searchSpell("lightning", "dance in the rain", 7) == spell13, "The was new added");


    }

    /**
     * Class tester of the classes AVLTree, Spell
     */
    private static void testAVLTree() {
        // Spells
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
        List<Spell> avl_1_top_3 = new ArrayList<>();
        avl_1_top_3.add(spell_12);
        avl_1_top_3.add(spell_10);
        avl_1_top_3.add(spell_9);
        test(avl_1.getTreeHeight() == 2, "AVL_1 - Tree height need to be 2 but its " + avl_1.getTreeHeight());
        test(avl_1.getSize() == 6, "AVL_1 - The size need to be 6 but its" + avl_1.getSize());
        test(((avl_1.getTopK(3).equals(avl_1_top_3))), "AVL_1 - The TOP 3 array need to be [12,10,9] but its " + avl_1.getTopK(3));


        //right_right checker
        AVLTree avl_2 = new AVLTree(spell_9);
        avl_2.insert(spell_5);
        avl_2.insert(spell_11);
        avl_2.insert(spell_10);
        avl_2.insert(spell_12);
        //after spell one rotate right_right
        avl_2.insert(spell_13);
        List<Spell> avl_2_top_2 = new ArrayList<>();
        avl_2_top_2.add(spell_13);
        avl_2_top_2.add(spell_12);
        test(avl_2.getTreeHeight() == 2, "AVL_2 - Tree height need to be 2 but its " + avl_2.getTreeHeight());
        test(avl_2.getSize() == 6, "AVL_2 - The size need to be 6 but its" + avl_2.getSize());
        test(((avl_2.getTopK(2).equals(avl_2_top_2))), "AVL_2 - The TOP 2 array need to be [13,12] but its " + avl_2.getTopK(2));


        // Right Left
        AVLTree avl_3 = new AVLTree(spell_3);
        avl_3.insert(spell_1);
        avl_3.insert(spell_12);
        avl_3.insert(spell_10);
        avl_3.insert(spell_13);
        avl_3.insert(spell_11);
        List<Spell> avl_3_top_4 = new ArrayList<>();
        avl_3_top_4.add(spell_13);
        avl_3_top_4.add(spell_12);
        avl_3_top_4.add(spell_11);
        avl_3_top_4.add(spell_10);
        test(avl_3.getTreeHeight() == 2, "AVL_3 - Tree height need to be 2 but its " + avl_3.getTreeHeight());
        test(avl_3.getSize() == 6, "AVL_3 - The size need to be 6 but its" + avl_3.getSize());
        test(((avl_3.getTopK(4).equals(avl_3_top_4))), "AVL_3 - The TOP 4 array need to be [13,12,11,10] but its " + avl_3.getTopK(4));


        // Left_right
        AVLTree avl_4 = new AVLTree(spell_12);
        avl_4.insert(spell_5);
        avl_4.insert(spell_13);
        avl_4.insert(spell_3);
        avl_4.insert(spell_11);
        avl_4.insert(spell_10);
        List<Spell> avl_4_top_2 = new ArrayList<>();
        avl_4_top_2.add(spell_13);
        avl_4_top_2.add(spell_12);
        test(((avl_3.getTopK(2).equals(avl_4_top_2))), "AVL_4 - The TOP 2 array need to be [13,12] but its " + avl_4.getTopK(2));
        test(avl_4.getSize() == 6, "AVL_4 - The size need to be 6 but its " + avl_4.getSize());
        test(avl_4.getTreeHeight() == 2, "AVL_4 - Tree height need to be 2 but its " + avl_4.getTreeHeight());


        //Left_left
        AVLTree avl_5 = new AVLTree(spell_10);
        avl_5.insert(spell_9);
        avl_5.insert(spell_5);
        List<Spell> avl_5_top_1 = new ArrayList<>();
        avl_5_top_1.add(spell_10);
        test(((avl_5.getTopK(1).equals(avl_5_top_1))), "AVL_5 - The TOP 1 array need to be [10] but its " + avl_5.getTopK(1));
        test(avl_5.getSize() == 3, "AVL_5 - The size need to be 6 but its " + avl_5.getSize());
        test(avl_5.getTreeHeight() == 1, "AVL_5 - Tree height need to be 2 but its " + avl_5.getTreeHeight());

        //Left_right
        AVLTree avl_6 =  new AVLTree(spell_10);
        avl_6.insert(spell_5);
        avl_6.insert(spell_9);
        List<Spell> avl_6_top_1 = new ArrayList<>();
        avl_6_top_1.add(spell_10);
        test(((avl_6.getTopK(1).equals(avl_6_top_1))), "AVL_6 - The TOP 1 array need to be [10] but its " + avl_6.getTopK(1));
        test(avl_6.getSize() == 3, "AVL_6 - The size need to be 6 but its " + avl_6.getSize());
        test(avl_6.getTreeHeight() == 1, "AVL_6 - Tree height need to be 2 but its " + avl_6.getTreeHeight());



        AVLTree avl_7 =  new AVLTree(spell_5);
        avl_7.insert(spell_9);
        avl_7.insert(spell_10);
        List<Spell> avl_7_top_1 = new ArrayList<>();
        avl_7_top_1.add(spell_10);
        test(((avl_7.getTopK(1).equals(avl_7_top_1))), "AVL_7 - The TOP 1 array need to be [10] but its " + avl_7.getTopK(1));
        test(avl_7.getSize() == 3, "AVL_7 - The size need to be 6 but its " + avl_7.getSize());
        test(avl_7.getTreeHeight() == 1, "AVL_7 - Tree height need to be 2 but its " + avl_7.getTreeHeight());


        AVLTree avl_8 =  new AVLTree(spell_5);
        avl_8.insert(spell_10);
        avl_8.insert(spell_9);
        List<Spell> avl_8_top_1 = new ArrayList<>();
        avl_8_top_1.add(spell_10);
        test(((avl_8.getTopK(1).equals(avl_8_top_1))), "AVL_8 - The TOP 1 array need to be [10] but its " + avl_8.getTopK(1));
        test(avl_8.getSize() == 3, "AVL_8 - The size need to be 6 but its " + avl_8.getSize());
        test(avl_8.getTreeHeight() == 1, "AVL_8 - Tree height need to be 2 but its " + avl_8.getTreeHeight());



        AVLTree avl_9 = new AVLTree(spell_10);
        avl_9.insert(spell_5);
        avl_9.insert(spell_9);
        avl_9.insert(spell_11);
        avl_9.insert(spell_12);

        List<Spell> avl_9_top_5 = new ArrayList<>();
        avl_9_top_5.add(spell_12);
        avl_9_top_5.add(spell_11);
        avl_9_top_5.add(spell_10);
        avl_9_top_5.add(spell_9);
        avl_9_top_5.add(spell_5);
        test(((avl_9.getTopK(5).equals(avl_9_top_5))), "AVL_9 - The TOP 5 array need to be [10] but its " + avl_9.getTopK(5));
        test(avl_9.getSize() == 5, "AVL_9 - The size need to be 6 but its " + avl_9.getSize());
        test(avl_9.getTreeHeight() == 2, "AVL_9 - Tree height need to be 2 but its " + avl_9.getTreeHeight());


    }
}
