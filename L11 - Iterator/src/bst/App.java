package bst;

public class App {
    public static void main(String[] args) {
        BST bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        System.out.println("\nInorder traversal:");
        bst.inorder();
        System.out.println("Preorder traversal:");
        bst.preorder();
        System.out.println("\nPostorder traversal:");
        bst.postorder();
    }
}
