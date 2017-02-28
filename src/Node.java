
public class Node<K, V> {
	
	public K key;
	public V value;
	private Node<K, V> next;
	
	public Node(K key, V value) {
		this.key=key;
		this.value=value;
	}

	public Node<K, V> getNext() {
		return next;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}
	
	

}
