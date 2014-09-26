package Module8;

import java.awt.Color;
import java.awt.geom.Ellipse2D;



@SuppressWarnings("serial")
/*
 * This is class Peg, it 'extends' or inherits from Ellipse2D.Float.
 * Ellipse2D.Float is just a 2 dimensional circle. You can read more about
 * the class in the online Java reference. An Ellipse2D has elements such as
 * x, y, width and height. What it doesn't have is a particular color associated with it.
 * When you draw an Ellipse2D on a JPanel, you set the color or fill you'd like to draw it with
 * first, then fill the shape. That is the reason why I chose to create this class.
 * It inherits from Ellipse2D.Float which means it 'is' an Ellipse2D.float, it has all the methods
 * and functionality of an Ellipse2D, with the addition of the private member to contain
 * the desired color of this particular shape.
 */

public class Peg extends Ellipse2D.Float
{
	private Color pegColor;
	
		
	public Peg(float x, float y, float width, float height, Color pegColor)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.pegColor = pegColor;
		
	}
	
	public Color getPegColor()
	{
		return pegColor;
	}
	
	public void setPegColor(Color pegColor)
	{
		this.pegColor = pegColor;
	}
	
	

}
