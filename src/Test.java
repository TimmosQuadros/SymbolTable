import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test<K,V> {

	public static <T> void main(String[] args) {
		Test<String, Integer> t = new Test<>();
		FileHandler fh = new FileHandler();
		Stopwatch stopwatch = new Stopwatch();

		ArrayList<String> words = fh.loadTextFromFile("C:/temp/merge.txt");


		LinkedList<String, Integer> linkedSymbolTable = new LinkedList<>();

		stopwatch.start();
		for (String s : words) {
			t.put(s, linkedSymbolTable);
		}
		System.out.println("Time linkedSymbolTable: "+stopwatch.elapsedTime()+"sec");

		System.out.println("Number of a's: "+linkedSymbolTable.get("a"));

		System.out.println("size of linkedSymbolTable: "+linkedSymbolTable.size());

		Array<String,Integer> arraySymbolTable = new Array<>();
		
		stopwatch.start();
		for (String s : words) {
			t.put(s, arraySymbolTable);
		}
		System.out.println("Time arraySymbolTable: "+stopwatch.elapsedTime()+"sec");
		
		System.out.println("Number of a's: "+arraySymbolTable.get("a"));
		
		System.out.println("size of arraySymbolTable: "+arraySymbolTable.size());


		HashMap<String, Integer> hashMap = new HashMap<>();

		stopwatch.start();
		for (String s : words) {
			t.put(s, hashMap);
		}
		System.out.println("Time hashmap: "+stopwatch.elapsedTime()+"sec");

		System.out.println("size of hashMap: "+hashMap.size());

		System.out.println("Number of a's: "+hashMap.get("a"));

		RBTree<String,Integer> rbtree = new RBTree<>();
		
		stopwatch.start();
		for (String s : words) {
			t.put(s, rbtree);
		}
		System.out.println("Time rbTree: "+stopwatch.elapsedTime()+"sec");
		
		System.out.println("Number of a's: "+rbtree.get("a"));
		
		System.out.println("size of rbTree: "+rbtree.size());

	}

	//Special duplicate helper function to linkedLists so i can update the value on duplicate
	private void put(String key,LinkedList<String, Integer> words){
		Node<String, Integer> current = words.head;

		while(current!=null && !current.key.equals(key)){
			current=current.getNext();
		}

		if(current!=null){
			current.value++;
		}else{
			words.put(key, 1);	
		}
	}

	//Special duplicate helper function to Array so i can update the value on duplicate
	private void put(String key,Array<String, Integer> array){
		DArray<String> keys = array.getKeys();
		DArray<Integer> vals = array.getVals();
		for (int i = 0; i < keys.size(); i++) {
			if(key.equals(keys.get(i))){
				vals.set(i,vals.get(i)+1);
				return;
			}
		}
		array.put(key, 1);
	}

	//Special duplicate helper function to Hashmap so i can update the value on duplicate
	private void put(String key,HashMap<String, Integer> hm){
		Integer value=1;
		try {
			value = hm.get(key);
			hm.set(key, value+1);
			return;
		} catch (Exception e) {
			hm.put(key, value);	
		}
	}

	//Special duplicate helper function to RBTree so i can update the value on duplicate
	private void put(String key,RBTree<String, Integer> rbt){
		Integer value = rbt.get(key);
		if(value!=null){
			rbt.set(key, value+1);
		}else{
			rbt.put(key, 1);
		}
	}

}
