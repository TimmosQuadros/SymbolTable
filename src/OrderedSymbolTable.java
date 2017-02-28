
public interface OrderedSymbolTable<K extends Comparable<K>, V>  extends Comparable{
	K min();
	K max();
	K floor(K key);
	K ceilling(K key);
}
