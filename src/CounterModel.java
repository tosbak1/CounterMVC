import java.util.Observable;

public class CounterModel extends Observable {
	private int max;
	private int min;
	private int currValue;
	

	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
		
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getCurrValue() {
		return currValue;
	}
	
	public void setCurrValue(int currValue) {
		this.currValue = currValue;
		this.setChanged();
		this.notifyObservers();
	}
	

	
	public void inc(){
		if(this.getCurrValue() < min){
			this.setCurrValue(min);
		}
		else if(this.getCurrValue() >= max){
			this.setCurrValue(max);
		}
		else{
			this.setCurrValue(this.getCurrValue() + 1);}
	}
	
	public void dec(){
		if(this.getCurrValue() <= min){
			this.setCurrValue(min);
		}
		else if(this.getCurrValue() > max){
			this.setCurrValue(max);
		}
		else{
			this.setCurrValue(this.getCurrValue() - 1);}

	}


	public static void main(String[] args){
		CounterModel cm = new CounterModel();
		cm.setCurrValue(0);
		cm.setMax(10);
		cm.setMin(2);
		
/*		cm.dec();
		cm.dec();
		cm.dec();
		cm.dec();
		cm.inc();
		cm.inc();

		cm.inc();

		cm.inc();

		cm.inc();

		cm.inc();

		cm.inc();
		cm.inc();
		cm.inc();*/
		
		cm.dec();
		System.out.println(cm.getCurrValue());

		cm.inc();

		System.out.println(cm.getCurrValue());
		cm.inc();

		System.out.println(cm.getCurrValue());
		cm.inc();

		System.out.println(cm.getCurrValue());
		cm.inc();

		System.out.println(cm.getCurrValue());
		
	}





}
