import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test<K,V> {

	public static <T> void main(String[] args) {
		Test<String, Integer> t = new Test<>();
		FileHandler fh = new FileHandler();
		Stopwatch stopwatch = new Stopwatch();
		
		//ArrayList<String> words = fh.loadTextFromFile("C:/temp/merge.txt");

		
//		LinkedList<String, Integer> linkedSymbolTable = new LinkedList<>();
//		
//		for (String s : words) {
//			t.put(s, linkedSymbolTable);
//		}
//		
//		System.out.println("size of linkedSymbolTable: "+linkedSymbolTable.size());
		
		
		
		//		LinkedList<String, Integer> words = new LinkedList<>();
		//		
		//		t.put("a", words);
		//		t.put("a", words);
		//		t.put("a", words);
		//		t.put("to", words);
		//		
		//		Iterator<String> var = words.keys().iterator();
		//		
		//		while(var.hasNext()){
		//			String key = var.next();
		//			System.out.println("Key: \""+key+"\" Value: "+words.get(key));
		//		}
		//		
		//		System.out.println("Size of list: "+words.size());
		
		
		

//				Array<String,Integer> arraySymbolTable = new Array<>();
//				
//				for (String s : words) {
//					t.put(s, arraySymbolTable);
//				}
//				
//				System.out.println("size of arraySymbolTable: "+arraySymbolTable.size());
		
		
		
		
		//		
		//		t.put("a", array);
		//		t.put("a", array);
		//		t.put("not", array);
		//		
		//		System.out.println("Size of array: "+array.size());
		//		
		//		for (int i = 0; i < array.size(); i++) {
		//			System.out.println("Key: "+"\""+array.getKeys().get(i)+"\" Value: "+array.getVals().get(i));
		//		}

//		HashMap<String, Integer> hashMap = new HashMap<>();
//		
//		stopwatch.start();
//		for (String s : words) {
//			t.put(s, hashMap);
//		}
//		System.out.println("Time: "+stopwatch.elapsedTime()+"sec");
//		
//		System.out.println("size of hashMap: "+hashMap.size());
//		
//		System.out.println(hashMap.get("a"));
		
		RBTree<String,Integer> rbtree = new RBTree<>();
		
//		for (String s : words) {
//			t.put(s, rbtree);
//		}
		
		t.put("a", rbtree);
		t.put("a", rbtree);
		t.put("b", rbtree);
		t.put("b", rbtree);
		t.put("c", rbtree);
		t.put("c", rbtree);
		t.put("c", rbtree);
		
		System.out.println(rbtree.get("c"));
		
		System.out.println(rbtree.size());


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
