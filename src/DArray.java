public class DArray<T> {
	
	private T[] array1 = null;
	private T[] array2 = (T[]) new Object[2];
	
	private int split = 0;
	private int copy = 0;
	
	public void add(T o){
		if(array1==null){
			array1 = (T[]) new Object[1];
			array1[0]=o;
			split = array1.length;
		}else if(copy<array1.length){
			array2[copy]=array1[copy];
			array2[split]=o;
			copy++;
			split++;
		}else{
			array1=array2;
			array2 = (T[]) new Object[array1.length*2];
			copy=0;
			split = array1.length;
			array2[copy]=array1[copy];
			array2[split]=o;
			split++;
			copy++;
		}
	}
	
	public T get(int index){
		if(split-array1.length==array1.length){
			return array2[index];
		}else{
			if(index>=split-array1.length && index<array1.length){
				return array1[index];
			}else{
				return array2[index];
			}
		}
	}
	
	public void set(int index, T t){
		if(split-array1.length==array1.length){
			array2[index]=t;
		}else{
			if(index>=split-array1.length && index<array1.length){
				array1[index]=t;
			}else{
				array2[index]=t;
			}
		}
	}
	
	public int size(){
		return split;
	}

}
