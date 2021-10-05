// needs Die.java file to execute program
// Author Lani Hurley
// Date 10/5/2021

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{
	
	// INSTANCE VARIABLES / GRAPHICAL COMPONENTS FOR THIS CLASS
	Font mainFont = new Font("Impact", Font.PLAIN, 32);
	JLabel title = new JLabel("Two Dice Game");
	JLabel playerLabel = new JLabel("The player's roll was: ");
	JLabel comLabel = new JLabel("The computer's roll was: ");
	JLabel result = new JLabel("");
	JTextField pRoll = new JTextField(4);
	JTextField cRoll = new JTextField(4);
	JButton button = new JButton("Click to Play");

	// custom constructor for this class
	public TwoDiceGUI()
	{
		super("Two Dice Game");
		setBounds(450, 250, 300, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout());
		setVisible(true);

		title.setFont(mainFont);
		result.setFont(mainFont);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		//pRoll.setEditable(false);

		add(title);
		add(playerLabel);
		add(pRoll);
		add(comLabel);
		add(cRoll);
		add(button);
		add(result);

		// add the event listener to the button component
		button.addActionListener(this);
	}

	// event handling method for this class
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		// Create two objects from the Die.java class
		Die playerDie = new Die();
		Die comDie = new Die();
		String outcome;

		// Processing phase to decide the outcome of the game
		if(playerDie.getDieValue() == comDie.getDieValue())
		{
			outcome = "We have a tie!";
			result.setForeground(Color.BLUE);	
		}
		else if(playerDie.getDieValue() > comDie.getDieValue())
		{
			outcome = "The Player wins!";
			result.setForeground(Color.GREEN);
		}
		else
		{
			outcome = "The computer wins!";
			result.setForeground(Color.RED);
		}

		// output to the GUI
		pRoll.setText("" + playerDie.getDieValue());
		cRoll.setText("" + comDie.getDieValue());
		result.setText(outcome);
		button.setText("Play Again?");	
	}

	public static void main(String[] args) 
	{
		new TwoDiceGUI();	
	}
}