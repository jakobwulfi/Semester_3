package bst;

public class App {
    public static void main(String[] args) {
        Integer[] intArray = {45, 22, 11, 15, 30, 25, 77, 90, 88};
        BST tree = new BST(intArray);
        /*for (int i = 0; i < intArray.length; i++) {
            System.out.println(tree.search(intArray[i]));
        }*/

        System.out.println(tree.greaterThan(25));
        System.out.println(tree.greaterThan(50));
        System.out.println(tree.greaterThan(43));
    }
}
