import java.math.BigInteger;
import java.util.NoSuchElementException;

public class HashMap<K,V> implements SymbolTable<K, V> {

	private final int INITIAL_SIZE=32;
	private Node<K,V>[] elements;
	private int size = 0;

	public HashMap() {
		elements = new Node[INITIAL_SIZE];
	}

	public BigInteger bigIntFunction(K key) {

		BigInteger bi = new BigInteger((String) key, 36);

		bi = bi.mod(new BigInteger("32"));

		return bi;
	}

	@Override
	public void put(K key, V value) {
		size++;
		Node<K,V> current;
		int index = bigIntFunction(key).intValue();
		if(elements[index]!=null){ //on collision add a linked list
			current = elements[index];
//			System.out.println("Colision for key: " + key+" Value: "+value+" on" +" key: "+current.key+" with value: " + current.value);
			while(current.getNext()!=null){
				current = current.getNext();
			}
			current.setNext(new Node<K,V>(key, value));
		}else{
			elements[index]=new Node<K,V>(key, value);
		}
	}

	@Override
	public V get(K key) {
		Node<K,V> current;
		int index = bigIntFunction(key).intValue();
		current = elements[index];
		if(current==null) throw new NoSuchElementException();
		while(current.getNext()!=null && !current.key.equals(key)){
			current = current.getNext();
		}
		
		if(current.key.equals(key)){
			return current.value;	
		}else{
			throw new NoSuchElementException("Hasmap doesn't contain this key");
		}
	}
	
	public void set(K key,V value){
		Node<K,V> current;
		int index = bigIntFunction(key).intValue();
		current = elements[index];
		while(current.getNext()!=null && !current.key.equals(key)){
			current = current.getNext();
		}
		if(current.key.equals(key)){
			current.value=value;	
		}else{
			throw new NoSuchElementException("Hasmap doesn't contain this key");
		}
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}



}
