
import javax.swing.*;
import java.awt.event.*;

class OnlineTest extends JFrame implements ActionListener      // implementing ActionListener to handle action
{
	
	private static final long serialVersionUID = 1L;

	// creating JLabel, JRadioButton JButton an JFrame

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];


	// create jFrame with radioButton and JButton

	OnlineTest(String message)     //constructor
	{
		super(message);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++)
		{
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 100, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}


	// handle all actions based on event
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == btnNext) 
		{
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9)
			{
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) 
		{
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) 
		{
			if (e.getActionCommand().equals("Bookmark" + y)) 
			{
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result"))
		{
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options,  and this code is for how to display Questions with options on JFrame. Those are 10 questions with options
	void set() 
	{
		radioButton[4].setSelected(true);

		if (current == 0)
		{
			label.setText("Q.1:  Which of the following is not introduced with Java 8?");
			radioButton[0].setText("Stream API");
			radioButton[1].setText("Serialization");
			radioButton[2].setText("Spliterator");
			radioButton[3].setText("Lambda Expression");
		}

		if (current == 1) 
		{
			label.setText("Q.2:  How many Keywords in Java?");
			radioButton[0].setText("10");
			radioButton[1].setText("52");
			radioButton[2].setText("31");
			radioButton[3].setText("None of Them");
		}

		if (current == 2)
		{
			label.setText("Q.3:  Does java supports Multiple Inheritance?");
			radioButton[0].setText("true");
			radioButton[1].setText("None of Them");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}

		if (current == 3) 
		{
			label.setText("Q.4:  How to call Abstract method in Java?");
			radioButton[0].setText("Using this");
			radioButton[1].setText("Using super");
			radioButton[2].setText("Using class");
			radioButton[3].setText("Using object");
		}

		if (current == 4) 
		{
			label.setText("Que5:  Who invented Java?");
			radioButton[0].setText("James Gosling");
			radioButton[1].setText("Vinod Khosla");
			radioButton[2].setText("Artur Gosling");
			radioButton[3].setText("Nero Khosla");
		}

		if (current == 5) 
		{
			label.setText("Q.6:  In which company java was created?");
			radioButton[0].setText("Sun Microsystems");
			radioButton[1].setText("Oracle");
			radioButton[2].setText("Amazon");
			radioButton[3].setText("Yahoo");
		}

		if (current == 6) 
		{
			label.setText("Q.7:  Which exception occurs if divide by zero?");
			radioButton[0].setText("DivideByZeroExcepton");
			radioButton[1].setText("ArithmeticException");
			radioButton[2].setText("IOException");
			radioButton[3].setText("None of them");
		}

		if (current == 7) 
		{
			label.setText("Q.8:  How to know that an event is occured?");
			radioButton[0].setText("actionPerformed()");
			radioButton[1].setText("getActionCommand()");
			radioButton[2].setText("ActionListener()");
			radioButton[3].setText("EventHandler()");
		}

		if (current == 8) 
		{
			label.setText("Q.9:  Can we create object of Abstract class?");
			radioButton[0].setText("Yes Truly possible");
			radioButton[1].setText("We can inherit it");
			radioButton[2].setText("False");
			radioButton[3].setText("God knows");
		}

		if (current == 9) 
		{
			label.setText("Que10:  Does Operating system is also an example of Multithreading?");
			radioButton[0].setText("Is is an example of single threading");
			radioButton[1].setText("Yes");
			radioButton[2].setText("I don't know");
			radioButton[3].setText("No");
		}

		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}


	// declare correct answers.
	boolean check() 
	{
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[3].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}


	public static void main(String args[])
	{
		OnlineTest obj = new OnlineTest("Online Test App");
	}

}
