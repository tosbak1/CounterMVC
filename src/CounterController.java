import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterController implements ActionListener {
	private CounterModel cm;
	private CounterView cv;
	
	public CounterController(CounterModel cm){
		this.cm = cm;
	}
	
	public void setView(CounterView cv){
		this.cv = cv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		
		String max = cv.getMax();
		String min = cv.getMin();
		String prev = cv.getPre();
		String present = cv.getPresent();
		
		cm.setMax(Integer.parseInt(max));
		cm.setMin(Integer.parseInt(min));
		
		if(!present.equals("")){
			cm.setCurrValue(Integer.parseInt(present));
		}
		else{
			cm.setCurrValue(Integer.parseInt(prev));
		}
		if(action.equals(cv.decButton())){
			cm.dec();
		}
		else if (action.equals(cv.incButton())){
			cm.inc();
		}
		
	}

}
