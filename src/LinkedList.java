
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<K, V> implements SymbolTable<K, V> {

	Node<K, V> head;
	Node<K, V> tail;
	int ListCount=0;

	public LinkedList() {
		head = null;
	}

	@Override
	public void put(K key, V value) {
		if(head==null){
			head = new Node<K, V>(key, value);
			tail = head;
			ListCount++;
		}else{
			tail.setNext(new Node<K,V>(key, value));
			tail = tail.getNext();
			ListCount++;
		}
	}
	
	public void set(K key,V value){
		Node<K,V> current = this.head;
		while(current!=null && !current.key.equals(key)){
			current=current.getNext();
		}
		
		if(current!=null){
			current.value=value;
		}
	}

	@Override
	public V get(K key) {
		Node<K,V> current = this.head;
		while(current!=null && !current.key.equals(key)){
			current=current.getNext();
		}
		try {
			return current.value;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("The key doesn't exists in the list, try a different key.");
		}

	}

	@Override
	public int size() {
		return ListCount;
	}

	public boolean IsEmpty(){
		return this.size()==0;
	}



	//	@Override
	//	public Iterator<K> keyss() {
	//		final LinkedList<K, V> list = this;
	//		return new Iterator<K>() {
	//			final Node<K,V> firstNode = list.head;
	//			Node<K,V> currentNode = null;
	//
	//			@Override
	//			public boolean hasNext() {
	//				return !isEmpty() && currentNode != tail;
	//			}
	//			@Override
	//			public K next() {
	//				if (currentNode == null) {
	//					currentNode = firstNode;
	//					return currentNode.key;
	//				}
	//				if (currentNode.getNext() == null) {
	//					throw new NoSuchElementException();
	//				}
	//				currentNode = currentNode.getNext();
	//				return currentNode.key;
	//			}
	//		};
	//	}

	@Override
	public Iterable<K> keys() {

		final LinkedList<K, V> list = this;

		return new Iterable<K>() {

			@Override
			public Iterator<K> iterator() {
				return new Iterator<K>() {
					final Node<K,V> firstNode = list.head;
					Node<K,V> currentNode = null;

					@Override
					public boolean hasNext() {
						return !isEmpty() && currentNode != tail;
					}
					@Override
					public K next() {
						if (currentNode == null) {
							currentNode = firstNode;
							return currentNode.key;
						}
						if (currentNode.getNext() == null) {
							throw new NoSuchElementException();
						}
						currentNode = currentNode.getNext();
						return currentNode.key;
					}
				};
			}
		}; 
	}
}
