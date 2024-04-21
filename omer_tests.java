import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.List;

public class omer_tests {

    public static void main(String[] args) {

        /**
         *---------------------------in order to see if the AVL tree is good--------------------------------------------
         * -------------------------this method need to implement this method in AVL tree class-------------------------
         */

//        public void inorder(){
//            inorder_help(this.root);
//        }
//        private void inorder_help(AVLTree.Node node){
//            if(node == null)
//                return;
//            inorder_help(node.left);
//            System.out.println("the name : "+node.spell.getName()+ ", and the height : "+node.height+" ");
//            if(node.left == null)
//                System.out.println(" he's left son : null");
//            else System.out.println(" he's left son : "+node.left.spell.getName());
//            if(node.right == null)
//                System.out.println(" he's right son : null");
//            else System.out.println(" he's right son : "+node.right.spell.getName());
//            System.out.println();
//            inorder_help(node.right);
//        }

        /**
         * -------------------------remove it before uploading to moodle------------------------------------------------
         */

        // create a new hash AVL spell table
        HashAVLSpellTable table = new HashAVLSpellTable(10);

        // create some spells
        Spell spell1 = new Spell("fireball", "fire", 10, "fireball!");
        Spell spell2 = new Spell("frostbolt", "ice", 7, "freeze please");
        Spell spell3 = new Spell("thunderstorm", "lightning", 9, "I`m going to shock you");
        Spell spell4 = new Spell("poison spray", "poison", 5, "sssss");
        Spell spell5 = new Spell("shockwave", "lightning", 8, "go pikachu!");

        // add the spells to the hash AVL spell table
        table.addSpell(new Spell("lightning bolt", "lightning", 11, "go lightning bolt"));  //lightning
        table.addSpell(spell1);  //fire
        table.addSpell(spell2);  //ice
        table.addSpell(spell3);  //lightning
        table.addSpell(spell4);  //poison
        table.addSpell(spell5);  //lightning

        // add more spells to an existing category
        table.addSpell(new Spell("flamethrower min", "fire", 6, "foo"));                    //fire
        table.addSpell(new Spell("flamethrower", "fire", 8, "foo better"));                 //fire
        table.addSpell(new Spell("fireball II", "fire", 12,"fireball!!"));                  //fire
        table.addSpell(new Spell("flamethrower II", "fire", 15, "foooooooo!"));             //fire
        table.addSpell(new Spell("shockwave II", "lightning", 10,"be useful pikachu."));    //lightning
        table.addSpell(new Spell("frost nova", "ice", 4, "chill dude"));                    //ice

        System.out.println("------Test number of Spells------");
        System.out.println("The current number of spells is " + table.getNumberSpells() +" need to be : 12"); // prints the total number of spells
        System.out.println("The current number of fire spells spells is " + table.getNumberSpells("fire") + " need to be : 5"); // prints the total number of fire spells
        System.out.println("The current number of lightning spells spells is " + table.getNumberSpells("lightning") + " need to be : 4");
        System.out.println("The current number of ice spells spells is " + table.getNumberSpells("ice") + " need to be : 2");
        System.out.println("The current number of poison spells spells is " + table.getNumberSpells("poison") + " need to be : 1");

        System.out.println();
        System.out.println();
        System.out.println("------Test top fire Spells------");
        // get the top 3 spells in the "fire" category
        System.out.println("Top 3 spells in the 'fire' category:");
        List<Spell> fireSpells = table.getTopK("fire", 3);
        for (Spell s : fireSpells) {
            System.out.println(s.toString()); // prints the top 3 spells in fire category in descending order
        }
        System.out.println("Need to be [flamethrower II - 15,fireball II - 12,fireball - 10]");

        System.out.println();
        System.out.println();
        System.out.println("------Test top lightning Spells------");
        // get the top 3 spells in the "lightning" category
        System.out.println("Top 3 spells in the 'lightning' category:");
        List<Spell> lightningSpells = table.getTopK("lightning", 3);
        for (Spell s : lightningSpells) {
            System.out.println(s.toString()); // prints the top 3 spells in lightning category in descending order
        }
        System.out.println("Need to be [lightning bolt - 11,shockwave II - 10,thunderstorm - 9]");

        System.out.println();
        System.out.println();
        System.out.println("------Test searchSpell------");
        // spell that exists in the table
        Spell searchedSpell = table.searchSpell("fire","fireball",  10);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found");
        }

        System.out.println();
        System.out.println();
        System.out.println("------Test searchSpell not Found------");
        // search for a spell that does not exist in the table
        searchedSpell = table.searchSpell("fire", "fireball", 11);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found, the Spell is null");
        }

        // search for a spell that does not exist in the table
        searchedSpell = table.searchSpell("ice", "fireball", 10);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found, the Spell is null");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();



        Spell sp1 = new Spell("one", "poison", 1, "one");
        Spell sp2 = new Spell("two", "lightning", 2, "two");
        Spell sp3 = new Spell("three ", "lightning", 3, "three ");
        Spell sp4 = new Spell("four", "poison", 4, "four");
        Spell sp5 = new Spell("five", "lightning", 5, "five");
        Spell sp5_1 = new Spell("five.1", "poison", 5, "five.1");
        Spell sp6 = new Spell("six", "poison", 6, "six");
        Spell sp7 = new Spell("seven", "lightning", 7, "seven");
        Spell sp8 = new Spell("eight", "lightning", 8, "eight");
        Spell sp9 = new Spell("nine", "lightning", 9, "nine");
        Spell sp10 = new Spell("ten", "poison", 10, "ten");
        Spell sp11 = new Spell("Eleven", "poison", 11, "Eleven");
        Spell sp12 = new Spell("Twelve", "lightning", 12, "Twelve");
        Spell sp13 = new Spell("Thirteen", "poison", 13, "Thirteen");
        Spell sp17 = new Spell("Seventeen", "fire", 17, "Seventeen");
        Spell sp22 = new Spell("Twenty-two", "fire", 22, "Twenty-two");


        HashAVLSpellTable table_2 = new HashAVLSpellTable(10);
        table_2.addSpell(sp3);
        table_2.addSpell(sp2);
        table_2.addSpell(sp5); // here
        table_2.addSpell(sp7);
        table_2.addSpell(sp12);


        table_2.addSpell(sp10);
        table_2.addSpell(sp13);



        table_2.addSpell(sp4);

        table_2.addSpell(sp6);
        table_2.addSpell(sp5_1);
        table_2.addSpell(sp1);
        table_2.addSpell(sp8);
        table_2.addSpell(sp9);
        table_2.addSpell(sp11);





        System.out.println("----------------------Omer's Test----------------------");
        System.out.println();
        System.out.println();
        System.out.println("------Test number of Spells------");
        System.out.println("The current number of spells is " + table_2.getNumberSpells() +" need to be : 14"); // prints the total number of spells
        System.out.println("The current number of lightning spells spells is " + table_2.getNumberSpells("lightning") + " need to be : 7");
        System.out.println("The current number of poison spells spells is " + table_2.getNumberSpells("poison") + " need to be : 7");

        System.out.println();
        System.out.println();
        System.out.println("------Test top 5 poison Spells------");
        // get the top k spells in the "poison" category
        System.out.println("Top 5 spells in the 'poison' category:");
        List<Spell> poisonSpells = table_2.getTopK("poison", 5);
        for (Spell s : poisonSpells) {
            System.out.println(s.toString()); // prints the top 5 spells in poison category in descending order
        }
        System.out.println("Need to be [13, 11, 10, 6, 5.1]");
//
        System.out.println();
        System.out.println();
        System.out.println("------Test top 2 lightning Spells------");
        // get the top 2 spells in the "lightning" category
        System.out.println("Top 5 spells in the 'lightning' category:");
        List<Spell> lightningSpells_2 = table_2.getTopK("lightning", 2);
        for (Spell s : lightningSpells_2) {
            System.out.println(s.toString()); // prints the top 2 spells in lightning category in descending order
        }
        System.out.println("Need to be [12, 9]");

        System.out.println();
        System.out.println();
        System.out.println("------Test searchSpell------");
        // spell that exists in the table
        Spell searchedSpell_2 = table_2.searchSpell("lightning","five",  5);
        if (searchedSpell_2 != null) {
            System.out.println("need to be found");
            System.out.println("Spell Found: " + searchedSpell_2.toString());
        } else {
            System.out.println("not good has a problem");
            System.out.println("Spell Not Found");
        }
        System.out.println();
        System.out.println();
//        System.out.println("------Test AVL tree------");
//        // spell that exists in the table
//        boolean bool = false;
//        LinkedList<AVLTree> link_avl = table_2.get_backet()[2];
//        for(int i=0; i<link_avl.size(); i++){
//            AVLTree t = link_avl.get(i);
//            if(t.getCategory().equals("lightning")){
//                if(t.getSize() != 7) {System.out.println("has problem with lightning tree size"); bool=true;}
//                if(t.getTreeHeight() != 2) {System.out.println("has problem with lightning tree Height"); bool=true;}
//            }
//            else{
//                if(t.getSize() != 7) {System.out.println("has problem with poison tree size");; bool=true;}
//                if(t.getTreeHeight() != 3) {System.out.println("has problem with poison tree Height");; bool=true;}
//            }
//        }
//        if(bool) System.out.println("has problem with AVL tree");
//        else System.out.println("AVL tree is good");


//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("-------------- Test building tree --------------");
//        System.out.println();
//        System.out.println("------- Test 1 -------");
//        AVLTree t = new AVLTree(sp4); //need to be regular    //                       4
//        t.insert(sp2);                                        //                 _ /   \__
//        t.insert(sp6);                                        //                2            6
//        t.insert(sp1);                                        //             __/ \          /
//        t.insert(sp3);                                        //            1      3       5
//        t.insert(sp5);                                        //
//        t.inorder();                                        //
//
//        System.out.println();
//        System.out.println();
//        System.out.println("------- Test 2 -------");
//        AVLTree t2 = new AVLTree(sp4);
//        t2.insert(sp2);                                     //                       4
//        t2.insert(sp6);                                     //                 _ /   \__
//        t2.insert(sp1);                                          //                2            6
//        t2.insert(sp3);                                     //             __/ \           / \
//        t2.insert(sp5);                                    //            1      3         5   ___8
//        t2.insert(sp7);                                    //                                   /  \
//        t2.insert(sp8);                                   //                                   7     9
//        t2.insert(sp9);
//        int[] x = (int[])t2.inorder();
////        System.out.println(x);
//
//        System.out.println();
//        System.out.println();
//        System.out.println("------- Test 3 -------");
//        AVLTree t3 = new AVLTree(sp3);
//        t3.insert(sp2);                                     //                       2
//        t3.insert(sp1);                                     //                 _ /   \__
//        t3.insert(sp4);                                     //                1            3
//        t3.inorder();                                       //                               \
//        //                                 4
////
//        System.out.println();
//        System.out.println();
//        System.out.println("------- Test 4 -------");
//        AVLTree t4 = new AVLTree(sp13); //work number 3 data structure
//        t4.insert(sp6);                                     //                       8
//        t4.insert(sp17);                                    //              __ /   \____
//        t4.insert(sp4);                                     //             6                   13
//        t4.insert(sp8);                                     //            /  \                 /  \
//        t4.insert(sp22);                                    //      __    __        __    ___
//        t4.insert(sp2);                                  //        2               7       9           17
//        t4.insert(sp7);            //                             /  \                       \            \
//        t4.insert(sp9);           //                             1     4                       10           22
//        t4.insert(sp1);
//        t4.insert(sp10);
//        t4.inorder();
////
////
//        System.out.println();
//        System.out.println();
//        System.out.println("------- Test 5 -------");
//        AVLTree t5 = new AVLTree(sp5); //work number 3 data structure                    6
//        t5.insert(sp1);  //                                                         _/  \_
//        t5.insert(sp9);  //                                                        5             9
//        t5.insert(sp6);   //                                                      /           _/  \__
//        t5.insert(sp10);  //                                                     1           8          10
//        t5.insert(sp8);
//        t5.inorder();
////
//        System.out.println();
//        System.out.println();
//        System.out.println("------- Test 6 -------");
//        AVLTree t6 = new AVLTree(sp10); //work number 3 data structure                   6
//        t6.insert(sp4);  //                                                          _/  \___
//        t6.insert(sp13);  //                                                        5             10
//        t6.insert(sp6);   //                                                       /            _/ \_
//        t6.insert(sp5);  //                                                       4            8        13
//        t6.insert(sp8);
//        t6.inorder();
//
//    }

//    //     TODO: DELETE!!
//    public int[] inorder() {
//        int[] num = new int[size];
//        inorderHelper(root, num, 0);
//        return num;
//    }
//
//    private int inorderHelper(AVLTree.Node node, int[] num, int index) {
//        if (node != null) {
//            index = inorderHelper(node.left, num, index);
//            num[index] = node.get_spell().getPowerLevel();
//            index++;
//            index = inorderHelper(node.right, num, index);
//        }
//        return index;
    }
}
