package dictionaryelev;

public class DictionaryBST<K extends Comparable<K>, V> implements
									Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	@Override
	public V get(K key) {
		Node node = find(key);
		if (node == null) {
			return null;
		} else {
			return node.value;
		}
	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (found) {
			return current;
		} else {
			return null;
		}

	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public V put(K key, V value) {
		//Node node = new Node(key, value);
		V oldValue = null;
		if (root == null) {
			root = new Node(key, value);
			return oldValue;
		}
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
				oldValue = current.value;
				current.value = value;
			} else if (d > 0) {
				if (current.left == null) {
					current.left = new Node(key, value);
					found = true;
				} else {
					current = current.left;
				}
			} else {
				if (current.right == null) {
					current.right = new Node(key, value);
					found = true;
				} else {
				current = current.right;
				}
			}
		}
		return oldValue;
	}

	@Override
	public V remove(K key) {
		// TODO
		return null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		int size = size(root);
		return size;
	}
	private int size(Node node) {
		int left = 0;
		int right = 0;
		if (node.left != null) {
			left = size(node.left);
		}
		if (node.right != null) {
			right = size(node.right);
		}
		return left + right + 1;
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}


	}

}
