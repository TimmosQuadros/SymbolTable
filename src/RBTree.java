
public class RBTree<Key extends Comparable<Key>,Value> implements SymbolTable<Key, Value> {

	private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;
    
    //Binary search tree node class
    private class Node {
        private Key key;           //key
        private Value val;         //associated data
        private Node left, right;  //links to left and right subtrees
        private boolean color;     //color of parent link
        private int size;          //subtree count

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }
    
    public RBTree() {
    }

	@Override
	public void put(Key key, Value value) {
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }

        root = put(root, key, value);
        root.color = BLACK;
	}
	
	//Insert the key-value pair in the subtree rooted at h
	private Node put(Node h, Key key, Value val) { 
        if (h == null) return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = put(h.left,  key, val); 
        else if (cmp > 0) h.right = put(h.right, key, val); 
        else              h.val   = val;

        //Fix-up any right-leaning links
        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }
	
	private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
	
	private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }
	
	//Flip the colors of a node and its two children
    private void flipColors(Node h) {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
    
 // make a left-leaning link lean to the right
    private Node rotateRight(Node h) {
        // assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }
    
 // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        // assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

	@Override
	public Value get(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
	}
	
	// value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }
    
    
	public void set(Key key,Value val) {
		if (key == null) throw new IllegalArgumentException("argument to get() is null");
        set(root, key, val);
	}
	
    private void set(Node x, Key key, Value val) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              x.val=val; return;
        }
    }

	@Override
	public int size() {
		return size(root);
	}

	@Override
	public Iterable<Key> keys() {
		return null;
	}
    
    
    
}
