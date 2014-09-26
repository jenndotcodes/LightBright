package Module8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainProgram extends JFrame
{

	public MainProgram()
	{
		PegColorChooser pegColorChooser = new PegColorChooser();
		PegGrid board = new PegGrid(pegColorChooser);
		this.setLayout(new BorderLayout());
		this.add(board, BorderLayout.CENTER);
		
		this.add(pegColorChooser,BorderLayout.LINE_START);
		//this.add(p2);
	}
	public static void main(String[] args)
	{
		
		MainProgram m = new MainProgram();
		m.setResizable(false);
		//m.setSize(600,600);
		m.pack();
		m.setVisible(true);
		
	}
}
