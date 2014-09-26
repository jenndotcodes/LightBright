package Module8;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*This class has a group of radio buttons and allows
 * the user to select the color of peg they'd like to place 
 * on the board
 */

public class PegColorChooser extends JPanel implements ActionListener
{
	//this is the color variable that will contain the color that the user
	//has selected
	private Color selectedColor;
	//Create a label that we can use and set the background on to display the selected color
	private JLabel sample = new JLabel("Color Sample");
	
	public PegColorChooser()
	{
		this.setPreferredSize(new Dimension(100,350));
		//Set this layout to a vertical layout that will contain the radio buttons
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//Create the radio buttons and the radio button group
		ButtonGroup rBG = new ButtonGroup();
		JRadioButton red = new JRadioButton("Red");
		JRadioButton orange = new JRadioButton("Orange");
		JRadioButton yellow = new JRadioButton("Yellow");
		JRadioButton green = new JRadioButton("Green");
		JRadioButton blue = new JRadioButton("Blue");
		JRadioButton purple = new JRadioButton("Purple");
		JRadioButton black = new JRadioButton("Black");
		JRadioButton white = new JRadioButton("White");
		
		
		//sets the label to be opaque, labels are transparent by default
		//my background color wont show if I don't do that
		sample.setOpaque(true);
		
		
		
		//Add the radio buttons to a radio button group
		rBG.add(red);
		rBG.add(orange);
		rBG.add(yellow);
		rBG.add(green);
		rBG.add(blue);
		rBG.add(purple);
		rBG.add(white);
		rBG.add(black);
		
		//add the label
		this.add(sample);
		
		//add the radio buttons to the jpanel
		this.add(red);
		this.add(orange);
		this.add(yellow);
		this.add(green);
		this.add(blue);
		this.add(purple);
		this.add(white);
		this.add(black);
		
		
		
		//Set black as the default
		black.setSelected(true); //Makes the black button be selected
		sample.setBackground(Color.black);
		selectedColor = Color.black;
		
		
		//Make the radio buttons listen for events
		red.addActionListener(this);
		orange.addActionListener(this);
		yellow.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		purple.addActionListener(this);
		black.addActionListener(this);
		white.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent evt)
	{
		//Set the color of the sample label and set the 
		//selectedColor variable to the appropriate color
		//depending on what radio button the user selected.
		switch(evt.getActionCommand()) //returns a string with the text of each radio button, so if it's red select will return Red
		{
			case "Red":
				selectedColor = Color.red;
				sample.setBackground(Color.red);
			break;
			case "Orange":
				selectedColor = Color.orange;
				sample.setBackground(Color.orange);
			break;
			case "Yellow":
				selectedColor = Color.yellow;
				sample.setBackground(Color.yellow);
			break;
			case "Green":
				selectedColor = Color.green;
				sample.setBackground(Color.green);
				break;
			case "Blue":
				selectedColor = Color.blue;
				sample.setBackground(Color.blue);
				break;
			case "Purple":
				selectedColor = new Color(148,0,211);
				sample.setBackground(new Color(148,0,211));
				break;
			case "Black":
				selectedColor = Color.black;
				sample.setBackground(Color.black);
				break;
			case "White":
				selectedColor = Color.white;
				sample.setBackground(Color.white);
				break;
		}
	}
	
	//Returns the selected color
	public Color getSelectedColor()
	{
		return selectedColor;
		
	}
}
