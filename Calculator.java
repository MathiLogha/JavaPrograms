import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class LaunchCalc implements ActionListener
{
	JButton[] butArray;
	JButton plusBut,minusBut,mulBut,divBut,equalToBut;
	JTextField dis;
	boolean isLeft = false;
	String leftOp="", rightOp="";
	int operatorType;   // 1-add 2-sub 3-mul 4-div
	
	boolean isLeftOp()
	{
		if(leftOp.length() != 0)
			return true;
		else 
			return false;
	}
	
	public LaunchCalc()
	{
		JFrame fr = new JFrame("My Calc");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fr.setSize(250, 250);
		Container cc = fr.getContentPane();
		cc.setBackground(Color.RED);
		fr.setResizable(false);
		
		fr.getContentPane().setLayout(new FlowLayout());

		JLabel lab = new JLabel("Standard calculator");
		fr.getContentPane().add(lab);

		 dis= new JTextField("enter data here");
		dis.setEditable(false);
		fr.getContentPane().add(dis);
		
		butArray = new JButton[10];
		for(int i=0;i<10;i++)
		{
			butArray[i] = new JButton(""+i);
			butArray[i].addActionListener(this);
			fr.getContentPane().add(butArray[i]);
		}
		plusBut = new JButton("+");
		plusBut.addActionListener(this);
		cc.add(plusBut);
		
		minusBut = new JButton("-");
		minusBut.addActionListener(this);
		cc.add(minusBut);
		
		mulBut = new JButton("x");
		mulBut.addActionListener(this);
		cc.add(mulBut);
		
		divBut = new JButton("/");
		divBut.addActionListener(this);			
		cc.add(divBut);
		
		
		equalToBut = new JButton("=");
		equalToBut.addActionListener(this);			
		cc.add(equalToBut);
		
		//fr.pack();
		fr.setVisible(true);
	}

	void assembleNumbers(String n)
	{
		if(!isLeft)
		{
			leftOp = leftOp+n;
			dis.setText(leftOp);
		}
		else
		{
			rightOp = rightOp+n;
			dis.setText(rightOp);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(butArray[0]))
			assembleNumbers("0");
		else if (e.getSource().equals(butArray[1]))
			assembleNumbers("1");
		else if (e.getSource().equals(butArray[2]))
			assembleNumbers("2");
		else if (e.getSource().equals(butArray[3]))
			assembleNumbers("3");		
		else if (e.getSource().equals(butArray[4]))
			assembleNumbers("4");
		else if (e.getSource().equals(butArray[5]))
			assembleNumbers("5");
		else if (e.getSource().equals(butArray[6]))
			assembleNumbers("6");
		else if (e.getSource().equals(butArray[7]))
			assembleNumbers("7");
		else if (e.getSource().equals(butArray[8]))
			assembleNumbers("8");
		else if (e.getSource().equals(butArray[9]))
			assembleNumbers("9");
		else if (e.getSource().equals(plusBut))
		{
			isLeft = true;
			dis.setText("");
			operatorType=1;
		}
		else if (e.getSource().equals(minusBut))
		{
			isLeft = true;
			dis.setText("");
			operatorType=2;
		}
		else if (e.getSource().equals(mulBut))
		{
			isLeft = true;
			dis.setText("");
			operatorType=3;
		}
		else if (e.getSource().equals(divBut))
		{
			isLeft = true;
			dis.setText("");
			operatorType=4;
		}
		else if (e.getSource().equals(equalToBut))
		{
			int x=99;
			if(operatorType==1)
				x = Integer.parseInt(leftOp) + Integer.parseInt(rightOp);
			if(operatorType==2)
				x = Integer.parseInt(leftOp) - Integer.parseInt(rightOp);
			if(operatorType==3)
				x = Integer.parseInt(leftOp) * Integer.parseInt(rightOp);
			if(operatorType==4)
				x = Integer.parseInt(leftOp) / Integer.parseInt(rightOp);
			System.out.println(x);
			Integer y = (Integer)x;
			dis.setText(y.toString());
			
			leftOp  = rightOp = "";
			isLeft = false;
		}
	}
}
class CreateCalc implements ActionListener
{
	JButton[] butArray;
	JTextField dis;
	public CreateCalc()
	{
		//1. Create the frame.
		JFrame frame = new JFrame("FrameDemo");
		frame.setTitle("Calculator");
		frame.setSize(300,300);
		
		dis= new JTextField("Enter Text Here");
		frame.getContentPane().setBackground(Color.YELLOW);
		//dis.setSize(200, 20);
		 butArray = new JButton[10];
		 butArray[0] = new JButton("0");
		 butArray[0].addActionListener(this);
		 butArray[1]= new JButton("1");
		 butArray[2] = new JButton("2");
		 butArray[3] = new JButton("3");
		 butArray[4] = new JButton("4");
		 butArray[5]= new JButton("5");
		 butArray[6] = new JButton("6");
		 butArray[7] = new JButton("7");
		 butArray[8] = new JButton("8");
		 butArray[9] = new JButton("9");
		//but1.setBounds(100, 100, 50, 20);
		//frame.add(but1);
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(dis);
		for(int i=0;i<10;i++)
			frame.getContentPane().add(butArray[i]);
			
		
		//2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Container  cb = frame.getContentPane();
		//cb.setBackground(Color.YELLOW);
		
		//3. Create components and put them in the frame.
		//...create emptyLabel...
		//String emptyLabel = "";
		//frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		//4. Size the frame.
		//frame.pack();

		//5. Show it.
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(butArray[0]) )
			System.out.println("zero button clicked");
			dis.setText("0");
			dis.setEditable(false);
	}
	
}



public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MathiLogha's calculator");
		new LaunchCalc();
		

	}

}
