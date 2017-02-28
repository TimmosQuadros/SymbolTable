
public class Stopwatch {

	private long start;

	public Stopwatch() {
		
	}
	
	public void start(){
		start = System.currentTimeMillis();
		//System.out.println(start);
	}

	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now-start)/1000.0;
	}
}
