
public class CounterRun {
	
	public static void main(String[] args) {
		
		CounterModel m = new CounterModel();
		CounterController c = new CounterController(m);
		CounterView v = new CounterView(c);
		c.setView(v);
		m.addObserver(v);
		
	}
}
