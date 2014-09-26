package Module8;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;



/*This class extends panel, it is the panel that holds
 * The main board for the light bright. It consists of an array of
 * Pegs. Each peg is a group of points and shapes that are used to draw
 * a the peg in it's specified location on the board. It implements MouseListener
 * so that the board can listen for clicks. When the user clicks the board, it determines
 * which peg is closest to the click and will redraw the board updating it in the area
 * where it was clicked.
 */
public class PegGrid extends JPanel implements MouseListener
{
	//Creating an array of pegs.
	private Peg[] pegs = new Peg[711];
	//Getting a reference to the color chooser panel on the mainProgram so that
	//I can determine what color is selected on that JPanel when I draw a new peg
	private PegColorChooser pegColorChooser;
	
	public PegGrid(PegColorChooser pegColorChooser)
	{
		//Set the private pegColorChooser member of this class to the one that is passed in.
		//This is needed so i can get the color that's selected on that other JPanel
		
		this.pegColorChooser = pegColorChooser;
		//make this panel the right size
		this.setPreferredSize(new Dimension(300,350));
		
		//Make this panel listen to mouse clicks
		this.addMouseListener(this);
		
		//Set the background color of this panel to black
		this.setBackground(Color.black);
		//Load 711 pegs into the pegs list collection. A light bright consists of 
		//29 rows of 25 pegs and 24 rows of 24 pegs, and there is an offset, just like
		//in the brick wall program
		
		//For the number of rows that are on the light bright, I will use the modulus operator to determine
		//if this is an odd row or an even row, and position the objects with an offset every other row
		//just like a real light bright. Sure it would've been easier just to put them on a normal grid,
		//but where's the fun in that?
		//A light bright has 29 rows, the 1,3,5,7th rows each have 29 pegs, the 2,4,6,8th rows each have 24
		
		
		
		//I will need this below index to have a continuous index counting from 0 to 710 to access my array
		int index = 0;
		
		//The below  variables will be used to keep track of the x Positions and y Positions of the shapes,
		//Each new shape they will be incremented accordingly to keep track of where the shapes should be drawn
		//on the board
		int xPos = 0;
		int yPos = 0;
		
		final int width = 10;
		final int height = 10;
		int offset = width/2; //on shorter rows, the row is offset by half the length of one peg
		
		//for every row on the lightbright... (i is 1 to 29).
		for(int i = 1; i <= 29; i++)
		{
			
			
			//if i % 2 results in a zero then i is an even number, so that means it is a 24 space row with an offset
			if(i%2==0)
			{
				//for each of the 24 pegs on this shorter, offset row/';.
				for(int j = 0; j < 24; j++)
				{
					pegs[index] = new Peg(xPos + offset, yPos, width,height,Color.DARK_GRAY);
					xPos += width + 2;
					index++; //move to next position in the pegs array
				}
			}
			else //else i is an odd number, so that means the row has 29 pegs
			{
				//For each of the 29 pegs on this row
				for(int j = 0; j < 25; j++)
				{
					pegs[index] = new Peg(xPos,yPos,width,height,Color.DARK_GRAY);
					xPos += width + 2; //Move to the left 22 pixels so the next shape will be drawn next to the one I just drew
					index++; //move to next position in the pegs array
					
				}
			}
			
			//A row has been drawn above, increment the yPos to draw the next row below it
			yPos += height + 2;
			//Reset xPos to zero so that it will start to the far left for the next row
			xPos = 0;
		}
		System.out.println(index);
	}


	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2D = (Graphics2D)g;
		super.paintComponent(g2D);
		for(int i = 0; i < 711; i++)
		{
		
			g2D.setColor(pegs[i].getPegColor());
			g2D.fill(pegs[i]);
		}
		//System.out.println("x " + this.getWidth() + " y " + this.getHeight());
		
	}
	
	@Override
	public void mouseClicked(MouseEvent evt)
	{
		/*
		 * When this panel is clicked, determine where the click came from and find out
		 * what peg that affects, get the currently selected color, change that peg's color
		 * to the currently selected color, and redraw all the pegs on the panel. The updated
		 * peg will now reflect the new color
		 */
		System.out.println("Clicked x" + evt.getX());
		System.out.println("Selected Color" + pegColorChooser.getSelectedColor());
		//for every peg in the array, check to see if the click was on that peg
		for(int i = 0; i < 711; i++)
		{
			//if the x,y coords of the click was 'contained' in the peg's area
			//I know the below line of code is pretty copact.
			
			//evt.getX() and evt.getY() return the x and y Coordinates of the place where we clicked
			//new Point(evt.getX(), evt.getY()) creates a Point that uses those coordinates
			//pegs[i].contains() is a method that takes a point as a parameter, we've passed in the
			//point we created that holds the coordinatees where we clicked.
			//contains will return a true if the point is on the ellipse or false if it was not.
			
			if(pegs[i].contains(new Point(evt.getX(),evt.getY())))
			{
				//If the above call to the contains method results in true then
				//pegs[i] contains the pegs object (ellipse) that was clicked.
				//Time to change the color of that ellipse to the color that was 
				//selected
				
				pegs[i].setPegColor(pegColorChooser.getSelectedColor());
				
			}
		}
		
		//redraw the light bright
		repaint(); //calls the paintComponent method
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
