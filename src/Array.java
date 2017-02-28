public class Array<K,V> implements SymbolTable<K, V> {
	
    private DArray<V> vals;   // symbol table values
    private DArray<K> keys;     // symbol table keys
    private int n = 0;      // number of elements in symbol table
    
    public Array() {
        keys = new DArray<>();
        vals = new DArray<>();
    }

	@Override
	public void put(K key, V value) {
        // add new key and value at the end of array
        vals.add(value);
        keys.add(key);
        n++;
	}

	@Override
	public V get(K key) {
		for (int i = 0; i < keys.size(); i++) {
			if(key.equals(keys.get(i))){
				return vals.get(i);
			}
		}
		return null;
	}
	
	public void set(K key, V value){
		for (int i = 0; i < keys.size(); i++) {
			if(key.equals(keys.get(i))){
				vals.set(i, value);
			}
		}
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return n;
	}

	public DArray<V> getVals() {
		return vals;
	}

	public void setVals(DArray<V> vals) {
		this.vals = vals;
	}

	public DArray<K> getKeys() {
		return keys;
	}

	public void setKeys(DArray<K> keys) {
		this.keys = keys;
	}
	
	
}
