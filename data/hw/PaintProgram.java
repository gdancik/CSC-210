/**********************************************************************
 * This is a 'paint' program that allows a user to paint to the screen
 * using some basic tools. In this assignment, you will use loops to
 * draw lines and squares. Follow the instructions in the FIX ME's in
 * the userDraw method (you should not modify any other code)
 * 
 * Name: 
 * 
***********************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/***********************************************************************
* The main class - a PaintProgram
************************************************************************/
public class PaintProgram implements ActionListener
{
	static PointPanel pp;		
    static JComboBox <String> toolSelection;
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    Random randGen = new Random();
    
    
	PaintProgram() {		
		pp = new PointPanel(WIDTH, HEIGHT);
		
		// the main frame
	    JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        f.setLayout(new BorderLayout());
        f.setFocusable(true);
        f.requestFocus();
             
        // the tool panel - includes instructions and tool selection
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new GridLayout(1,4));        
                
        // instructions
        String instr1 = "<html>r = red<br>g = green</html>";
        String instr2 = "<html>b = blue<br>d = default(black)</html>";
        String instr3 = "<html>c = clear screen</html>";             
        JLabel headerLabel1 = new JLabel(instr1,JLabel.CENTER );
        JLabel headerLabel2 = new JLabel(instr2,JLabel.CENTER );
        JLabel headerLabel3 = new JLabel(instr3,JLabel.CENTER );        
        toolPanel.add(headerLabel1);
        toolPanel.add(headerLabel2);
        toolPanel.add(headerLabel3);
        
        // tool selection drop-down
    		String[] toolStrings = { "Point", "Horizontal Line", "Vertical Line", "Square"};
	    toolSelection = new JComboBox <String> (toolStrings);
	    toolSelection.setSelectedIndex(0);	
        toolPanel.add(toolSelection);
        
        f.add(toolPanel, BorderLayout.PAGE_START);                
        f.getContentPane().add(pp);        
        f.setSize(WIDTH,HEIGHT);
        f.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        f.setMaximumSize(new Dimension(WIDTH, HEIGHT));		
        f.setLocation(200,100);
        f.setVisible(true);
        
        // handle key press
        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            }
                       
            @Override
            public void keyPressed(KeyEvent e) {
            		// get the key that was pressed
                char ch = e.getKeyChar();
                if (ch == 'r' || ch == 'R') {
                		pp.setColor(Color.red);
                } else if (ch == 'b' || ch == 'B') {
                		pp.setColor(Color.BLUE);
                } else if (ch == 'g' || ch == 'G') {
                		pp.setColor(Color.GREEN);
                } else if (ch == 'c' || ch == 'C') {
                		pp.reset();
                } else if (ch == 'd' || ch == 'D') {
                		pp.setColor(Color.BLACK);                	
                } else if (ch == 'm' || ch == 'M') {
                
                		// FIX ME (optional): if the user presses 'm', give
                		// the user a random mystery color by setting red, green, and blue                		
                		// values to random integers between 0 and 255 (inclusive), using
                		// the 'randGen' object that has been created for you (near the
                		// top of the program)
                	  
                		// set red, green, and blue values
                		int red = 255;
                		int green = 0;
                		int blue = 255;
                                  		 
                		Color color = new Color(red,green,blue);
                		pp.setColor(color);
                	}                           
        }
	

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
                    
        
        // handle tool selection
        toolSelection.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent eventSource) {    		       		  
        			JComboBox combo = (JComboBox) eventSource.getSource();
        			String selected = (String) combo.getSelectedItem();    		   
        			pp.setTool(selected);
        			f.requestFocus();
        		}
        });
                        
	}

    public static void main(String[] args) {    	       
    		// launch program
        PaintProgram paint = new PaintProgram();        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
        
};
       

/***********************************************************************
* handles graphics (based on the point list and corresponding colors)
************************************************************************/

class PointPanel extends JPanel {	
    
	int width, height;
	static Color canvas[][];
	
    String drawTool = "Point";
    private static final long serialVersionUID = 1;
    
    Color color = Color.black;
    
    // PointPanel constructor
    public PointPanel(int w, int h) {    	    		
    		width = w;
    		height = h;    	
    		canvas = new Color[width][height];
        PointLocater pp = new PointLocater(this);
        addMouseListener(pp);         
        addMouseMotionListener(pp);
        setBackground(Color.white);
        reset();
    }
  
    // sets the selected tool
    public void setTool(String tool) {
    		drawTool = tool;
    }
    
    // paints to the screen
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;        
    
        // fill in canvas pixel by pixel
        for (int i = 0; i < height; i++) {
        		for (int j = 0; j < width; j++) {
        			if (canvas[i][j] != null) {        				
        				g2.setColor(canvas[i][j]);
        				g2.fillRect(i, j,1,1);
        			}
        		}
        }                   
    }
  
    // sets the selected color
    public void setColor(Color col) {
    		color = col;
    }
  
    // clears the screen
    public void reset() {
    		 
    		// clear each pixel
    		for (int i = 0; i < height; i++) {
    			for (int j = 0; j < width; j++) {
    				canvas[i][j] = null;
    			}
    		}
    		
    		repaint();
    		
    }

    // adds a point at location (x,y)
    public void addPoint(int x, int y) {

    		// convert from coordinate position to index
    		x--;
    		y--;
    		
    		// if index is not valid return
    		if (x < 1 || x >= width-1) return;
    		if (y < 1 || y >= height-1) return;

    		// add point to canvas (width and height of 3)
    		canvas[x-1][y-1] = color;
    		canvas[x][y-1] = color;
    		canvas[x+1][y-1] = color;
    		
    		canvas[x-1][y] = color;
    		canvas[x][y] = color;
    		canvas[x+1][y] = color;
    		
    		canvas[x-1][y+1] = color;
    		canvas[x][y+1] = color;
    		canvas[x+1][y+1] = color;
    		    		
        this.repaint();        
    }
    
    // draw using the currently selected tool when the user clicks on the point (x,y)  
    public void userDraw(int x, int y) {

    		// the width and height of the paint window
    		int width = PaintProgram.WIDTH;
    		int height = PaintProgram.HEIGHT;
    	    	    	
    		// if out of bounds, then ignore it
    		if (x > width || y > width) {
    			return;
    		}
        	
    		/* FIX ME: Delete this output before submitting */
    		System.out.println("User clicks at (" + x + "," + y + ") with selection of " + drawTool);
    	
    		/* FIX ME: Draw the appropriate shape depending on the selected tool, which
    		 * is stored in the String variable drawTool. Note: in all cases you will
    		 * use addPoint(x,y) to draw the shape one point at a time
    		 * 
    		 * Point - draw a single point at (x,y)
    		 * Horizontal line - draw a horizontal line that extends across the entire window
    		 * 		through the point where the user clicked (from a x value of 1 to 'width')
    		 * Vertical line - draw a vertical line that extends across the entire window
    		 * 		through the point where the user clicked (from a y-value of 1 to 'height') 
    		 * Square - draw a filled-in square 41 pixels high and 41 pixels wide that is
    		 * 			centered at the selected point
    		 *	 		  
    		 * Note #1: the width and height of the window are stored in 'width' and
    		 * 		'height'
    		 * Note #2: the code below (to be modified) will always draw a single 
    		 * 		point at (x,y)
    		 */
    	   	
    		addPoint(x,y);
    	    	
    }
}
  

/***********************************************************************
* handles mouse movement
************************************************************************/
class PointLocater extends MouseAdapter implements MouseMotionListener
{
    PointPanel pointPanel;
  
    public PointLocater(PointPanel pp)
    {
        pointPanel = pp;
    }
  
     public void mouseDragged(MouseEvent e) {  
        Point p = e.getPoint();           
        pointPanel.userDraw(p.x, p.y);                  
     }

     public void mouseClicked(MouseEvent e) {
    	 	Point p = e.getPoint();
    	 	pointPanel.userDraw(p.x, p.y);    	 	
     }       
}
