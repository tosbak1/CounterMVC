import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CounterView extends JFrame implements Observer{
	private ActionListener listener;
	private JFrame jframe;
	private JPanel jpanel;
	private JTextField min, max, previousValue, presentValue;
	private JButton inc, dec;
	private Border textBorder;
	private JLabel minLabel, maxLabel, currLabel;
	
	private CounterModel cm;
	
	public CounterView(ActionListener listener){
		this.listener = listener;
		jframe = new JFrame("Counter :)");
		jframe.setSize(400, 400);

		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jframe.setLayout(new BorderLayout());
		
		// Panel set up with a grid layout of 4X2
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(4, 2));
		

		
		// Set a border for the first and last name blocks
		textBorder = BorderFactory.createLineBorder(Color.GREEN);
		
		//Text areas
		min = new JTextField("");
		max = new JTextField("");
		presentValue = new JTextField("");
		previousValue = new JTextField("");
		
		min.setBorder(textBorder);
		max.setBorder(textBorder);
		presentValue.setBorder(textBorder);
		previousValue.setBorder(textBorder);
		
		min.setEditable(true);
		max.setEditable(true);
		presentValue.setEditable(false);
		previousValue.setEditable(true);
		
		//Set up buttons
		inc = new JButton("Increment");
		dec = new JButton("Decrement");
		
		inc.addActionListener(this.listener);
		dec.addActionListener(this.listener);
		
		inc.setActionCommand("Increment");
		dec.setActionCommand("Decrement");
		
		minLabel = new JLabel("Minimum value:");
		maxLabel = new JLabel("Maximum value:");
		currLabel = new JLabel("Enter your present value:");
		
		//always add action listener
		jpanel.add(maxLabel);
		jpanel.add(max);
		jpanel.add(minLabel);
		jpanel.add(min);
		jpanel.add(currLabel);
		jpanel.add(previousValue);
		jpanel.add(inc);
		jpanel.add(dec);
		
		jframe.getContentPane().add(this.presentValue, BorderLayout.SOUTH);
		jframe.getContentPane().add(jpanel, BorderLayout.CENTER);
		jframe.setVisible(true);
		
		
	}
	
	public String getMin(){
		return this.min.getText();
	}
	
	public String getMax(){
		return this.max.getText();
	}

	public String getPre(){
		return this.previousValue.getText();
	}
	
	public String getPresent(){
		return this.presentValue.getText();
	}
	public String decButton(){
		return this.dec.getActionCommand();
	}
	
	public String incButton(){
		return this.inc.getActionCommand();
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		CounterModel cm = (CounterModel) o;
		//this.max.setText(String.valueOf(cm.getMax()));
		//this.min.setText(String.valueOf(cm.getMin()));
		this.presentValue.setText(Integer.toString(cm.getCurrValue()));
	}

	public static void main(String[] args){
		CounterModel cm = new CounterModel();
		CounterController a = new CounterController(cm);
		CounterView cv = new CounterView(a);

	}
}
