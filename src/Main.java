import java.awt.*;
import javax.swing.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Calculator implements ActionListener
{

	JFrame frame;
	JPanel panel;
	JTextField tf;
	JButton numberButtons[]=new JButton[10];
	JButton functionButtons[]=new JButton[8];
	JButton add, sub, div,mul;
	JButton dec, equ,del,clr,fact,percent;
	Font font=new Font("TimesNewRoman",Font.BOLD,22);
	double num1=0,num2=0,result=0;
	char operator;
	Calculator()
	{
		frame=new JFrame("Calculator");
		panel=new JPanel();
		tf=new JTextField();
		add=new JButton("+");
		sub=new JButton("-");
		div=new JButton("/");
		mul=new JButton("*");
		dec=new JButton(".");
		equ=new JButton("=");
		del=new JButton("Del");
		clr=new JButton("Clr");
		fact=new JButton("!");
		percent=new JButton("%");
		
		functionButtons[0]=add;
		functionButtons[1]=sub;
		functionButtons[2]=div;
		functionButtons[3]=mul;
		functionButtons[4]=dec;
		functionButtons[5]=equ;
		functionButtons[6]=del;
		functionButtons[7]=clr;
		//functionButtons[8]=add;
		
		for(int i=0; i<functionButtons.length;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setFont(font);
			
		}
		
		for(int i=0;i<numberButtons.length;i++) {
			numberButtons[i]=new JButton(String.valueOf(i));
			numberButtons[i].setFont(font);
			numberButtons[i].setFocusable(false);
			numberButtons[i].addActionListener(this);
			//numberButtons[i].setSize(30, 30);
			
		}
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(420, 550);
		tf.setBounds(50, 25, 300, 40);
		tf.setEditable(false);
		panel.setBounds(50, 80, 300, 300);
		//panel.setBackground(Color.cyan);
		panel.setLayout(new GridLayout(5,4,10,10));
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(add);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(sub);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mul);
		panel.add(dec);
		panel.add(numberButtons[0]);
		panel.add(equ);
		panel.add(div);
		panel.add(fact);
		panel.add(percent);
		panel.add(del);
		panel.add(clr);
		
	
		tf.setFont(font);
		//tf.setVisible(false);
		
		frame.add(tf);
		frame.add(panel);
		frame.setVisible(true);
		
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<numberButtons.length;i++) {
			if(e.getSource()==numberButtons[i]) {
				tf.setText(tf.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==dec) {
			tf.setText(tf.getText().concat("."));
		}
		if(e.getSource()==clr) {
			tf.setText("");
		}
		if(e.getSource()==add) {
			num1=Double.parseDouble(tf.getText());
			operator='+';
			tf.setText("");
		}
		if(e.getSource()==sub) {
			num1=Double.parseDouble(tf.getText());
			operator='-';
			tf.setText("");
		}
		if(e.getSource()==mul) {
			num1=Double.parseDouble(tf.getText());
			operator='*';
			tf.setText("");
		}
		if(e.getSource()==div) {
			num1=Double.parseDouble(tf.getText());
			operator='/';
			tf.setText("");
		}
		if(e.getSource()==equ) {
			num2=Double.parseDouble(tf.getText());
			switch(operator) 
			{
			case'+':
				result=num1+num2;
				tf.setText(String.valueOf(result));
				break;
			case'-':
				result=num1-num2;
				tf.setText(String.valueOf(result));
				break;
			case '*':
				result=num1*num2;
				tf.setText(String.valueOf(result));
				break;
			case '/':
				if(num2==0) {
					tf.setText("Math Error");
				}
				else {
					result=num1/num2;
					tf.setText(String.valueOf(result));
				}
				
				break;
				
			}
			/*if(e.getSource()==div&& num2==0) {
				tf.setText("Math Error");
			}
			else {
				tf.setText(String.valueOf(result));
			}*/
			
			num1=result;
			
		}
		if(e.getSource()==del) {
			String str=tf.getText();
			String str1=str.substring(0, (str.length()-1));
			//StringBuffer s=new StringBuffer(str);
			//s.deleteCharAt((s.length()-1));
			tf.setText(str1);
		}
	}
	
}












public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator clac=new Calculator();

	}

}
