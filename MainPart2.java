import java.util.List;

public class MainPart2 {

    public static void main(String[] args) {

        // create a new hash AVL spell table
        HashAVLSpellTable table = new HashAVLSpellTable(10);

        // create some spells
        Spell spell1 = new Spell("fireball", "fire", 10, "fireball!");
        Spell spell2 = new Spell("frostbolt", "ice", 7, "freeze please");
        Spell spell3 = new Spell("thunderstorm", "lightning", 9, "I`m going to shock you");
        Spell spell4 = new Spell("poison spray", "poison", 5, "sssss");
        Spell spell5 = new Spell("shockwave", "lightning", 8, "go pikachu!");

        // add the spells to the hash AVL spell table
        table.addSpell(new Spell("lightning bolt", "lightning", 11, "go lightning bolt"));
        table.addSpell(spell1);
        table.addSpell(spell2);
        table.addSpell(spell3);
        table.addSpell(spell4);
        table.addSpell(spell5);

        // add more spells to an existing category
        table.addSpell(new Spell("flamethrower min", "fire", 6, "foo"));
        table.addSpell(new Spell("flamethrower", "fire", 8, "foo better"));
        table.addSpell(new Spell("fireball II", "fire", 12,"fireball!!"));
        table.addSpell(new Spell("flamethrower II", "fire", 15, "foooooooo!"));
        table.addSpell(new Spell("shockwave II", "lightning", 10,"be useful pikachu."));
        table.addSpell(new Spell("frost nova", "ice", 4, "chill dude"));

        if (table.getNumberSpells() != 12) {
            System.out.println("The current number of spells is " + table.getNumberSpells()); // prints the total number of spells
        }
        System.out.println("The current number of fire spells spells is " + table.getNumberSpells("fire")); // prints the total number of fire spells

        // get the top 3 spells in the "fire" category
        System.out.println("Top 3 spells in the 'fire' category:");
        List<Spell> fireSpells = table.getTopK("fire", 3);
        for (Spell s : fireSpells) {
            System.out.println(s.toString()); // prints the top 3 spells in fire category in descending order
        }

        // get the top 3 spells in the "lightning" category
        System.out.println("Top 3 spells in the 'lightning' category:");
        List<Spell> lightningSpells = table.getTopK("lightning", 3);
        System.out.println(lightningSpells);
        for (Spell s : lightningSpells) {
            System.out.println(s.toString()); // prints the top 3 spells in lightning category in descending order
        }

		// spell that exists in the table
        Spell searchedSpell = table.searchSpell("fire","fireball",  10);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found");
        }

        // search for a spell that does not exist in the table
        searchedSpell = table.searchSpell("fire", "fireball", 11);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found");
        }

        // search for a spell that does not exist in the table
        searchedSpell = table.searchSpell("ice", "fireball", 10);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found");
        }
    }
}


// TODO: DELETE!!
//    public int[] inorder() {
//        int[] num = new int[size];
//        inorderHelper(root, num, 0);
//        return num;
//    }
//
//    private int inorderHelper(Node node, int[] num, int index) {
//        if (node != null) {
//            index = inorderHelper(node.left, num, index);
//            num[index] = node.get_spell().getPowerLevel();
//            index++;
//            index = inorderHelper(node.right, num, index);
//        }
//        return index;
//    }