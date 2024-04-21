import java.util.ArrayList;
import java.util.List;


/**
 * AVL Tree
 * Input-Spell type, with the spell creating new node and insert as a root or new leaf
 */
public class AVLTree {

    private Node root;
    private int size=0;
    private String category;  // every tree has his own category
	
	//
    /**
     * Private Node class for the AVL Tree nodes
     * Input - Spell type
     */
    private class Node { 
        private Spell spell;
        private Node left=null;
        private Node right=null;
        private int height;

        /**
         * Node - Constructor
         */
        private Node(Spell spell) {
            this.spell = spell;
            set_height();
            category = spell.getCategory();
        }

        /**
         *  Getter
         */
        protected Spell get_spell(){
            return spell;
        }

        /**
         * Updating height to the branch who got a new leaf node
         */
        private void set_height(){
            if (left == null && right == null){  //leaf
                height = 0;
            } else if (left == null) {  // only have right son
                height = right.height + 1;
            } else if (right == null) {  // only have left son
                height = left.height + 1;
            }
            else {  // max from left and right son heights
                if (left.height > right.height){
                    height = left.height + 1;
                }
                else {
                    height = right.height + 1;
                }
            }
        }
    }

    /**
     * AVL tree - Constructor
     */
    public AVLTree(Spell spell) {
        root = new Node(spell);
        size++;
        category = spell.getCategory();
    }

    /**
     * Getter for the tree Height - int
     */
    public int getTreeHeight(){
        if (size == 0){
            return -1;
        }
        return root.height;
    }

    /**
     * Getter for the tree size - int
     */
    public int getSize(){
        return size;
    }

    /**
     * Getter for the tree category
     */
    public String getCategory() {  // Every Tree is a category, then the root category is all the nodes category
        return root.get_spell().getCategory();
    }

    /**
     * Searching for the node, calling binary search helper func
     */
    public Spell search(String spellName, int powerLevel) {
        return binary_search_helper(root, spellName, powerLevel);
    }

    /**
     * Searching for the node with the input specific details, if was not found return null
     */
    private Spell binary_search_helper(Node temp_root, String spellName, int powerLevel){
        if (temp_root != null && temp_root.get_spell().getPowerLevel() == powerLevel && (temp_root.get_spell().getName().equals(spellName))){
            return temp_root.get_spell();  // new add
        }
        if (temp_root == null){  // was not found
            return null;
        }
        if (temp_root.get_spell().getPowerLevel() > powerLevel){ // Go left
            return binary_search_helper(temp_root.left, spellName, powerLevel);
        }
        else {
            return binary_search_helper(temp_root.right, spellName, powerLevel);  // Go right
        }
    }

    /**
     * Inserting new node, first insert like it was binary tree, then arrange it as avl tree and at last update height branch to be safe
     */
    public void insert(Spell spell) {
        Node new_spell = insert_binary_tree(root, spell);
        Node new_node = new Node(spell);
        order_by_avl(new_node, root);
        height_update(new_node, root);
        size++;
    }

    /**
     * Insert as binary tree inserting, getting as an input the new spell and the root
     */
    private Node insert_binary_tree(Node temp_root, Spell spell){
        if (temp_root == null){  // adding the node
            temp_root = new Node(spell);
            return temp_root;
        } else if (temp_root.get_spell().getPowerLevel() > spell.getPowerLevel()) {
            temp_root.left = insert_binary_tree(temp_root.left, spell);  // Go left
        }
        else {
            temp_root.right = insert_binary_tree(temp_root.right, spell);  // Go right
        }
        height_update(new Node(spell), this.root);  // branch height update

        return temp_root;
    }

    /**
     * Updating height, after inserting the avl can change heights to the nodes then we will update branch heights
     */
    private void height_update(Node new_leaf, Node temp_root){
        if (new_leaf.get_spell().getPowerLevel() != temp_root.get_spell().getPowerLevel()){
            if (temp_root.get_spell().getPowerLevel() > new_leaf.get_spell().getPowerLevel()){
                height_update(new_leaf, temp_root.left);  // go left
            }
            else{
                height_update(new_leaf, temp_root.right);  // go right
            }

            if (temp_root.right != null){
                if (temp_root.left == null || temp_root.right.height > temp_root.left.height){
                    temp_root.height = temp_root.right.height +1;
                } // if left is not null and the power is more than right
                else {
                    temp_root.height = temp_root.left.height +1;
                }
            }
            else { // if right is null
                if (temp_root.left != null){
                    temp_root.height = temp_root.left.height +1;
                }

            }
        }
    }


    /**
     *  Order the tree to comply with the laws of AVL trees
     */
    private void order_by_avl(Node spell, Node temp_root) {
        if (temp_root != null) {  // Branch going down to the new node add
            if (temp_root.get_spell().getPowerLevel() < spell.get_spell().getPowerLevel()) {
                order_by_avl(spell, temp_root.right);  // Go right
            } else if (temp_root.get_spell().getPowerLevel() > spell.get_spell().getPowerLevel()) {
                order_by_avl(spell, temp_root.left);  // Go left
            } else {
                return;
            }

            Node right_son = temp_root.right;
            Node left_son = temp_root.left;

            // if temp.root != this.root
            if (temp_root.height > 2 && right_son != null && left_son != null) {
                //right
                if (right_son.height - left_son.height == 2){
                    // right_right
                    if (right_son.right != null && right_son.left == null){
                        temp_root.right = right_right(temp_root.right);
                        return;
                    }
                    else if (right_son.right == null && right_son.left != null){
                        temp_root.right = left_left(temp_root.right);
                        return;
                    }
                } //left
                else if (right_son.height - left_son.height == -2) {
                    // left_left
                    if (left_son.left != null && left_son.right == null){
                        temp_root.left = left_left(temp_root.left);
                        return;
                    } // left_right
                    else if (left_son.left == null && left_son.right != null) {
                        temp_root.left = right_right(temp_root.left);
                        return;
                    }
                }
            }
            if (right_son != null && left_son != null) {
                // Right
                if (temp_root.height > 1 && right_son.height - left_son.height == 2) {
                    if (right_son.right == null || (right_son.left != null && right_son.left.height > right_son.right.height)) {
                        right_left(temp_root);
                    } else {
                        right_right(temp_root);
                    }
                }
                // Left
                else if (temp_root.height > 1 && right_son.height - left_son.height == -2) {
                    if (left_son.left == null || (left_son.right != null && left_son.right.height < left_son.left.height)) {
                        left_left(temp_root);
                    } else {
                        left_right(temp_root);
                    }
                }
            }                                                              //     o\
            // if temp.root == this.root                                 //         o\
            else if (temp_root.height == 2 && temp_root == this.root) {  //           o\
                // left
                if (left_son != null){  // && right_son == null - didn't enter to the first
                    //left_left
                    if (left_son.left != null) {
                        left_left(temp_root);
                        // left_right
                    } else if (left_son.right != null) {
                        left_right(temp_root);

                    }
                    // right
                } else if (right_son != null) { // && left_son == null - didn't enter to the first
                    // right_right
                    if (right_son.right != null){
                        right_right(temp_root);
                        // right_left
                    } else if (right_son.left != null) {
                        right_left(temp_root);
                    }
                }
            }
        }
    }


    /**
     * Left_left- need to rotate right
     */
    private Node  left_left(Node root){
        root.height = root.height -2;
        return rotate_right(root);
    }

    /**
     * Right_right - need to rotate left
     */
    private Node right_right(Node root){
        root.height = root.height -2;
        this.root.height--;
        return rotate_left(root);
    }

    /**
     * Right_left - need to rotate right and then rotate left
     */
    private Node right_left(Node root){
        root.height = root.height -2;
        root.right.height--;
        root.right.left.height++;

        // Multiple action as rotating right and then rotating left
        Node replace_root = root;
        Node new_root = root.right.left;
        Node right_son_root = root.right;
        right_son_root.left = new_root.right;
        new_root.right = right_son_root;
        root.right = new_root.left;
        new_root.left = root;

        if (replace_root == this.root){
            this.root = new_root;
        }
        return new_root;
    }

    /**
     * Left_right - need to rotate left and the rotate right
     */
    private Node left_right(Node root){
        root.height = root.height -2;
        root.left.right.height++;
        root.left.height--;

        // Multiple action as rotating left and then rotating right
        Node replace_root = root;
        Node left_son = root.left;
        Node new_root = root.left.right;
        left_son.right = new_root.left;
        new_root.left = left_son;
        root.left = new_root.right;
        new_root.right = root;

        if (replace_root == this.root){
            this.root = new_root;
        }
        return new_root;
    }

    /**
     * Left rotation
     */
    private Node rotate_left(Node root){
        Node replace_root = root;   // was the root of the tree
        Node right_left = root.right.left;
        Node new_root = root.right;     // new root
        replace_root.right = right_left;  // old root new right son
        new_root.left = replace_root;  // old root is left son of the new root
        if (replace_root == this.root) {  // if the root is the original root then update it
            this.root = new_root;
        }
        return new_root;
    }

    /**
     * Right rotation
     */
    private Node rotate_right(Node root){
        Node replace_root = root; // was the root of the tree
        Node left_right = root.left.right;
        Node new_root = root.left; // new root
        replace_root.left = left_right; // old root new left son
        new_root.right = replace_root; // old root is right son of the new root
        if (replace_root == this.root) { // if the root is the original root then update it
            this.root = new_root;
        }

        return new_root;
    }

    /**
     * Returning the biggest Top K Spells power level and getting the help of TopK helper
     */
    public List<Spell> getTopK(int k) {
        List<Spell> list = new ArrayList<>(k);
        TopK_helper(list, k, this.root);
        return list;
    }

    /**
     * Reverse inorder to get the biggest Top K Spells power level
     */
    private void TopK_helper(List<Spell> list, int k, Node root){
        // reverse inorder
        if (root.right != null){
            TopK_helper(list, k, root.right);  // Go left
        }
        if (list.size() < k ) {
            list.add(root.get_spell());
        }
        if (root.left != null){
            TopK_helper(list, k, root.left);  // Go right
        }

    }


}


