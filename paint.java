/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;
public class paint extends JComponent{
    
    //begin hack




    //end hack
        Image image;
        //this is gonna be your image that you draw on
        Graphics2D graphics2D;
        //this is what we'll be using to draw on
        int currentX, currentY, oldX, oldY;
        //these are gonna hold our mouse coordinates

        public static void main(String[] args)throws IOException {

	    //begin hack
               String clientSentence;
               String capitalizedSentence;
         
	       String list[] = {"","",""};
	       int counter = 0;
	       String k = null;
	
       	   double a = 0.0;	
	       double b = 0.0;
	       int c = 0;
	       // end hack








                Icon iconB = new ImageIcon("blue.gif");

                //the blue image icon

                Icon iconM = new ImageIcon("magenta.gif");

                //magenta image icon

                Icon iconR = new ImageIcon("red.gif");

                //red image icon

                Icon iconBl = new ImageIcon("black.gif");

                //black image icon

                Icon iconG = new ImageIcon("green.gif");

                //finally the green image icon

                //These will be the images for our colors.

                

                JFrame frame = new JFrame("Paint It");

                //Creates a frame with a title of "Paint it"

                

                Container content = frame.getContentPane();

                //Creates a new container

                content.setLayout(new BorderLayout());

                //sets the layout

                

                final paint drawPad = new paint();

                //creates a new padDraw, which is pretty much the paint program

                

                content.add(drawPad, BorderLayout.CENTER);

                //sets the padDraw in the center

                

                JPanel panel = new JPanel();

                //creates a JPanel

                panel.setPreferredSize(new Dimension(32, 68));

                panel.setMinimumSize(new Dimension(32, 68));

                panel.setMaximumSize(new Dimension(32, 68));

                //This sets the size of the panel

                

                JButton clearButton = new JButton("Clear");

                //creates the clear button and sets the text as "Clear"

                clearButton.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent e){

                                drawPad.clear();

                        }

                });

                //this is the clear button, which clears the screen.  This pretty

                //much attaches an action listener to the button and when the

                //button is pressed it calls the clear() method

                

                JButton redButton = new JButton(iconR);

                //creates the red button and sets the icon we created for red

                redButton.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent e){

                                drawPad.red();

                        }


                });

                //when pressed it will call the red() method.  So on and so on =]

                

                JButton blackButton = new JButton(iconBl);

                //same thing except this is the black button

                blackButton.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent e){

                                drawPad.black();

                        }

                });

                

                JButton magentaButton = new JButton(iconM);

                //magenta button

                magentaButton.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent e){

                                drawPad.magenta();

                        }

                });

                

                JButton blueButton = new JButton(iconB);

                //blue button

                blueButton.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent e){

                                drawPad.blue();

                        }

                });

                

                JButton greenButton = new JButton(iconG);

                //green button

                greenButton.addActionListener(new ActionListener(){

                        public void actionPerformed(ActionEvent e){

                                drawPad.green();

                        }

                });
/*
                blackButton.setPreferredSize(new Dimension(16, 16));

                magentaButton.setPreferredSize(new Dimension(16, 16));

                redButton.setPreferredSize(new Dimension(16, 16));

                blueButton.setPreferredSize(new Dimension(16, 16));

                greenButton.setPreferredSize(new Dimension(16,16));

                //sets the sizes of the buttons

                

                panel.add(greenButton);

                panel.add(blueButton);

                panel.add(magentaButton);

                panel.add(blackButton);

                panel.add(redButton);
*/
                panel.add(clearButton);

                //adds the buttons to the panel

                

                content.add(panel, BorderLayout.WEST);

                //sets the panel to the left

                

                frame.setSize(1500, 800);

                //sets the size of the frame

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //makes it so you can close

                frame.setVisible(true);
                //
                
                //makes it so you can see it
                

	 ServerSocket welcomeSocket = new ServerSocket(12345);
	 welcomeSocket.setSoTimeout(500);
	 while(true){
         try{
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader msg =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            		
		
			
		k = msg.readLine();
		StringTokenizer st = new StringTokenizer(k,",");
		while(st.hasMoreTokens()){
		String key = st.nextToken();
		list[counter] = new String(key);
		counter++;
		}
	        
   			
		a = Double.parseDouble(list[0])*2;
		b = Double.parseDouble(list[1]);		
		
				if(c == 2){
					drawPad.oldX = (int)a;
					drawPad.oldY = (int)b;
					drawPad.graphics2D.drawLine(drawPad.oldX, drawPad.oldY, drawPad.oldX, drawPad.oldY);
		            c--;
					//System.out.println("hello1");
					
	
				}
				if(c == 0 || c == 1){
                drawPad.currentX = (int)a;
                drawPad.currentY = (int)b;
                
                if(drawPad.graphics2D != null ){
                	drawPad.graphics2D.setStroke(new BasicStroke(5));
                drawPad.graphics2D.drawLine(drawPad.oldX, drawPad.oldY, drawPad.currentX, drawPad.currentY);
                drawPad.repaint();

                drawPad.oldX = drawPad.currentX;
                drawPad.oldY = drawPad.currentY;
                
				}
                else
                	c -- ;


				}


		
		counter = 0;
	}
	catch(Exception e ){
		
		c = 2;
		//System.out.println(e.toString());
	}	
            
      }







        }//main

//paint

/*class PadDraw extends JComponent{
        Image image;
        //this is gonna be your image that you draw on
        Graphics2D graphics2D;
        //this is what we'll be using to draw on
        int currentX, currentY, oldX, oldY;
    //these are gonna hold our mouse coordinates
    //Now for the constructors*/
        public paint(){
//getX()
 //
                setDoubleBuffered(false);

                addMouseListener(new MouseAdapter(){

                        public void mousePressed(MouseEvent e){
			    /*
                                oldX = e.getX();

                                oldY = e.getY();
				*/
                        }

                });

                //if the mouse is pressed it sets the oldX & oldY

                //coordinates as the mouses x & y coordinates

                addMouseMotionListener(new MouseMotionAdapter(){

                        public void mouseDragged(MouseEvent e){

			    /*
                                currentX = e.getX();

                                currentY = e.getY();

                                if(graphics2D != null)

                                graphics2D.drawLine(oldX, oldY, currentX, currentY);

                                repaint();

                                oldX = currentX;

                                oldY = currentY;*/

                        }


                });

                //while the mouse is dragged it sets currentX & currentY as the mouses x and y

                //then it draws a line at the coordinates

                //it repaints it and sets oldX and oldY as currentX and currentY

        }


        public void paintComponent(Graphics g){

                if(image == null){

                        image = createImage(getSize().width, getSize().height);

                        graphics2D = (Graphics2D)image.getGraphics();

                        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        clear();


                }

                g.drawImage(image, 0, 0, null);

        }

        //this is the painting bit

        //if it has nothing on it then

        //it creates an image the size of the window

        //sets the value of Graphics as the image

        //sets the rendering

        //runs the clear() method

        //then it draws the image



        public void clear(){

                graphics2D.setPaint(Color.white);

                graphics2D.fillRect(0, 0, getSize().width, getSize().height);

                graphics2D.setPaint(Color.black);

                repaint();

        }

        //this is the clear

        //it sets the colors as white

        //then it fills the window with white

        //thin it sets the color back to black

        public void red(){

                graphics2D.setPaint(Color.red);

                repaint();

        }

        //this is the red paint

        public void black(){

                graphics2D.setPaint(Color.black);

                repaint();

        }

        //black paint

        public void magenta(){

                graphics2D.setPaint(Color.magenta);

                repaint();

        }

        //magenta paint

        public void blue(){

                graphics2D.setPaint(Color.blue);

                repaint();

        }

        //blue paint

        public void green(){

                graphics2D.setPaint(Color.green);

                repaint();

        }

        //green paint


}


