package bst;

import java.util.ArrayList;
import java.util.List;

public class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);

    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    //opgave 2
    public int removeMin() {
        if (root == null) {
            throw new IllegalArgumentException("The tree is empty");
        }
        TreeNode current = root;
        TreeNode parent = null;
        if (root.left == null) {
            root.right = root;
        }
        while (current.right != null) {
            parent = current;
            current = current.right;
        }
        if (current.left != null) {
            parent.right = current.left;
            return (int) current.element;
        } else {
            parent.right = null;
            return (int) current.element;
        }
    }

    public ArrayList<Integer> greaterThan(E element) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            greaterThan(root, list, element);
        }
        return (ArrayList<Integer>) list;
    }
    private void greaterThan(TreeNode<E> node, List<Integer> list, E element) {
        if (node != null) {
            greaterThan(node.left, list, element);
            if ((int) node.element > (int) element) {
                list.add((int) node.element);
            }
            greaterThan(node.right, list, element);
        }
    }

    public int removeMax() {
        if (root == null) {
            throw new IllegalArgumentException("The tree is empty");
        }
        TreeNode current = root;
        TreeNode parent = null;
        if (root.right == null) {
            root.left = root;
        }
        while (current.left != null) {
            parent = current;
            current = current.left;
        }
        if (current.right != null) {
            parent.left = current.right;
            return (int) current.element;
        } else {
            parent.left = null;
            return (int) current.element;
        }
    }

    @Override
    /** Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                found = true; // Element is found
        }

        return found;
    }

    @Override
    /** Insert element e into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e) {
        boolean inserted = true;
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null && inserted)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    inserted = false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return inserted; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    /** Inorder traversal from the root */
    public void inorder() {
        if (root != null) {
            inorder(root);
        }
    }
    private void inorder(TreeNode<E> node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.element);
            inorder(node.right);
        }
    }


    @Override
    /** Postorder traversal from the root */
    public void postorder() {
        if (root != null) {
            postorder(root);
        }
    }
    private void postorder(TreeNode<E> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.element);
        }
    }


    @Override
    /** Preorder traversal from the root */
    public void preorder() {
        if (root != null) {
            preorder(root);
        }
    }
    private void preorder(TreeNode<E> node) {
        if (node != null) {
            System.out.println(node.element);
            preorder(node.left);
            preorder(node.right);
        }
    }

    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }


    @Override
    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                found = true; // Element is in the tree pointed at by current
        }

        if (found) {
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

    public boolean isLeaf(TreeNode node) {
        if (node.right == null && node.left == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isInternal(TreeNode node) {
        if (node.right != null || node.left != null) {
            return true;
        } else {
            return false;
        }
    }

    public int height() {
        int heightRight = height(root.right);
        int heightLeft = height(root.left);
        return Math.max(heightRight + 1, heightLeft + 1);

    }
    private int height(TreeNode node) {
        if (node == null) {
            return -1; // Return -1 at at tage "højde" for blade
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int sum() {
        int sumRight = sum(root.right);
        int sumLeft = sum(root.left);
        return sumRight + sumLeft + (int) root.element;
    }
    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumRight = sum(node.right);
        int sumLeft = sum(node.left);
        return sumRight + sumLeft + (int) node.element;
    }

    public int findMax() {
        int maxRight = findMax(root.right);
        return Math.max(maxRight, (int) root.element);
    }
    private int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxRight = findMax(node.right);
        return Math.max(maxRight, (int) node.element);
    }
    public int findMin() {
        if (root == null) {
            throw new IllegalArgumentException("The tree is empty");
        }
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return (int) current.element;
    }

//
    //-------------------------------------------------------------------



}
