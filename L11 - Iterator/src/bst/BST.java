package bst;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.function.Consumer;

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
            while (current != null && inserted) {
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    inserted = false; // Duplicate node not inserted
            }
            // Create the new node and attach it to the parent node
            if (inserted) {
                if (c.compare(e, parent.element) < 0)
                    parent.left = createNewNode(e);
                else
                    parent.right = createNewNode(e);
            }
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
        BSTIterator inorderIterator = new BSTIterator(root, TraversalOrder.INORDER);
        while (inorderIterator.hasNext()) {
            System.out.println(inorderIterator.next());
        }
    }

    private void inorder(TreeNode<E> node) {
        //TODO
        // left as an exercise
    }

    @Override
    /** Postorder traversal from the root */
    public void postorder() {
        BSTIterator postOrderIterator = new BSTIterator(root, TraversalOrder.POSTORDER);
        while (postOrderIterator.hasNext()) {
            System.out.println(postOrderIterator.next());
        }
    }


    @Override
    /** Preorder traversal from the root */
    public void preorder() {
        BSTIterator preOrderIterator = new BSTIterator(root, TraversalOrder.PREORDER);
        while (preOrderIterator.hasNext()) {
            System.out.println(preOrderIterator.next());
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

//

    public Iterator<E> iterator(TraversalOrder order) {
        return new BSTIterator(root, order);
    }

    public enum TraversalOrder {
        PREORDER,
        INORDER,
        POSTORDER
    }
    //-------------------------------------------------------------------
    private class BSTIterator implements Iterator<E> {
        private Stack<TreeNode<E>> stack;
        private Stack<TreeNode<E>> stack2;
        private TreeNode<E> current;
        private BST.TraversalOrder order;

        public BSTIterator(TreeNode<E> root, BST.TraversalOrder order) {
            this.order = order;
            this.stack = new Stack<>();
            this.current = root;
            initializeStack(root);
        }

        private void initializeStack(TreeNode<E> node) {
            if (order == BST.TraversalOrder.PREORDER) {
                if (node != null) stack.push(node);
            } else if (order == BST.TraversalOrder.INORDER) {
                pushLeft(node);
            } else if (order == BST.TraversalOrder.POSTORDER) {
                stack2 = new Stack<>();
                if (node != null) {
                    stack.push(node);
                    while (!stack.isEmpty()) {
                        TreeNode<E> nodeCurrent = stack.pop();
                        stack2.push(nodeCurrent);
                        if (nodeCurrent.left != null) {
                            stack.push(nodeCurrent.left);
                        }
                        if (nodeCurrent.right != null) {
                            stack.push(nodeCurrent.right);
                        }
                    }
                }
            }
        }

        private void pushLeft(TreeNode<E> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        @Override
        public boolean hasNext() {
            if (order.equals(TraversalOrder.INORDER) || order.equals(TraversalOrder.PREORDER)) {
                return !stack.isEmpty();
            } else {
                return !stack2.isEmpty();
            }
        }
        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();

            if (order.equals(TraversalOrder.PREORDER)) {
                TreeNode<E> node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                return node.element;
            } else if (order.equals(TraversalOrder.INORDER)) {
                TreeNode<E> node = stack.pop();
                if (node.right != null) {
                    pushLeft(node.right);
                }
                return node.element;
            } else if (order.equals(TraversalOrder.POSTORDER)) {
                return stack2.pop().element;
            }
            return null;
        }
        @Override
        public void remove() {
            Iterator.super.remove();
        }
        /*@Override
        public void forEachRemaining(Consumer<? super E> action) {
            Iterator.super.forEachRemaining(action);
        }*/
    }
}
