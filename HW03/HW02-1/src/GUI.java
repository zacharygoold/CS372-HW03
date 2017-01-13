import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * this is HW03
 * Still need to make it possible for them to know where they are
 * This class is the GUI that shows pictures of JAAIL, CityHall, and School
 * 
 *
 * @author zgoold17
 *
 */


public class GUI extends JComponent implements MouseMotionListener, MouseListener {
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;



	/**
     * main 
     * @param args
     */
    public static void main(String[] args) {
    	 
    	/**
    	 * get images 
    	 */
    	String police = "/Pictures/Police.jpg";
    	String school = "/Pictures/School.jpg";
    	String cityHall = "/Pictures/CityHall.jpeg";
    	String jail = "/Pictures/PoliceStation.jpg";
    	String teacher = "/Pictures/Teacher.jpg";
    	String kid = "/Pictures/Kid.jpg";
    	
    	
    	/**
         * Put pictures in the UI
         */
     
        
        Image image1 = Toolkit.getDefaultToolkit().getImage(GUI.class.getResource(jail));
        image1 = image1.getScaledInstance(500,300,Image.SCALE_DEFAULT);
        
        Image image2 = Toolkit.getDefaultToolkit().getImage(GUI.class.getResource(school));
        image2 = image2.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        
        Image image3 = Toolkit.getDefaultToolkit().getImage(GUI.class.getResource(cityHall));
        image3 = image3.getScaledInstance(500,300,Image.SCALE_DEFAULT);
        
        Image image4 = Toolkit.getDefaultToolkit().getImage(GUI.class.getResource(police));
        image4 = image4.getScaledInstance(75, 100, Image.SCALE_DEFAULT);
        
        Image image5 = Toolkit.getDefaultToolkit().getImage(GUI.class.getResource(teacher));
        image5 = image5.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
        
        Image image6 = Toolkit.getDefaultToolkit().getImage(GUI.class.getResource(kid));
        image6 = image6.getScaledInstance(100, 150, Image.SCALE_DEFAULT);
            
        
        /**
         * Create the JFrame
         */
        JFrame frame = new JFrame("In a galaxy far... far... away.....");
        frame.add( new GUI(image1, image2, image3, image4, image5, image6));
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
     }
    
    
	
	
	/**
	 * Variables for the GUI Class
	 * Sets the X and Y for the images
	 * Sets up Images
	 * Set up buildings and people in the city
	 * Had to make new people as I couldn't figure out how to import them in, as well as not wanting to have multiples to have to code for
	 */
	int backgroundX, backgroundY, kidX = 550, kidY = 50, teacherX = 550, teacherY = 200, policeX = 750, policeY = 50, pressed = 0; //had to start them in a position
	Image image1, image2, image3, image4, image5, image6;
	
	//people and buildings
	Person[] people = {new Kid("KitKat", "Phil", 5, "0"), new Teacher("Computer Science", 20, "Pete Tucker", 
			45, "4567891"),new Police(Police.Role.Captain,"Frank", 48, "1234567")};
	Building[] buildings = {new School("Jedi Temple", "300 W Hawthorne"), new CityHall("Courasant", "Star Wars Planet"), new CityHall("Jail","Courasant")};
	//to store the names
	
	
	
	/**
	 * Constructor for GUI
	 * Sets up images
	 * Mouse Listeners
	 */
	public GUI(Image a, Image b , Image c, Image d, Image e, Image f){
		image1 = a;
		image2 = b;
		image3 = c;
		image4 = d;
		image5 = e;
		image6 = f;
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	/**
     * Function for mouse click
     */
    public void mousePressed(MouseEvent mouse) //works same as snake masam
    {
    	if (mouse.getX() >= policeX && mouse.getX() <= policeX + 100 && mouse.getY()>= policeY && mouse.getY() <= policeY +100)
    	{
			pressed = 1;
    	}
		else if (mouse.getX() >= teacherX && mouse.getX() <= teacherX + 100 && mouse.getY()>= teacherY && mouse.getY() <= teacherY +100)
		{
			pressed = 2;
		}
		else if (mouse.getX() >= kidX && mouse.getX() <= kidX + 100 && mouse.getY()>= kidY && mouse.getY() <= kidY +100)
		{
			pressed = 3;
		}
    }
    
   
	
    
    /**
     * Display information if picture is clicked (name... address... ect)
     * @param
     */
    public void mouseClicked(MouseEvent mouse)
    {
    	if(mouse.getY() >= 0 && mouse.getY() <= 500 && mouse.getX() >= 0 && mouse.getX() <= 300){ // buildings 0 = school 1 = cityhall 2 = jail
			System.out.printf("%s,%s\n", buildings[2].getName(),buildings[2].getAddress()); //FOR JAIL COORDS
		}		
		else if (mouse.getY() >=350  && mouse.getY() <= 650 && mouse.getX() >= 450 && mouse.getX() <= 950){ //FOR SCHOOL COORDS
			System.out.printf("%s,%s\n", buildings[0].getName(),buildings[0].getAddress());
		}
		else if	(mouse.getY() >=0  && mouse.getY() <= 300 && mouse.getX() >= 900 && mouse.getX() <= 1400){ //FOR CITYHALL COORDS
			System.out.printf("%s,%s\n",buildings[1].getName(),buildings[1].getAddress());
		}
		else if (mouse.getX() > kidX && mouse.getX()< kidX + 100 && mouse.getY() > kidY && mouse.getY() < kidY + 150){
			System.out.printf("%s\n",people[0].getName());
		}
		else if (mouse.getX()> policeX && mouse.getX() < policeX + 75 && mouse.getY() > policeY && mouse.getY() < policeY + 100){
			System.out.printf("%s\n", people[2].getName());
		}
		else if (mouse.getX()>teacherX && mouse.getX() < teacherX + 150 && mouse.getY() > teacherY && mouse.getY() < teacherY + 100){
			System.out.printf("%s\n", people[1].getName());
		}
    }
    
    /**
     * Functions for mouse dragging and deciding where the picture ends up (put x and y coords in them)
     */
    public void mouseDragged(MouseEvent mouse) {
    	if (pressed == 0) {
    		if (mouse.getX() >= policeX && mouse.getX() <= policeX + 75 && mouse.getY() >= policeY && mouse.getY() <= policeY+100)
    		{
    			pressed = 1;
    		}
    		else if(mouse.getX() >= teacherX && mouse.getX() <= teacherX + 150 && mouse.getY() >= teacherY && mouse.getY() <= teacherY + 100)
    		{
    			pressed = 2;
    		}
    		else if (mouse.getX() >= kidX && mouse.getX() <= kidX + 100 && mouse.getY() >= kidY && mouse.getY() <= kidY + 125)
    		{
    			pressed = 3;
    		}
    	}
    	if (pressed == 1) { //ITS THE POPO
	      policeX = mouse.getX();
	      policeY = mouse.getY();
    	}
    	else if (pressed == 2) //Teacher
    	{
    	teacherX = mouse.getX();
      	teacherY = mouse.getY();
    	}
    	else if (pressed == 3) // Kid
    	{
    	kidX = mouse.getX();
    	kidY = mouse.getY();
    	}
      repaint();
    }
    
    /**
     * paint the images
     */
    public void paint(Graphics g) {
      Graphics2D gg = (Graphics2D)g;
      gg.drawImage(image1, 0, 0, this);
      gg.drawImage(image2, 450, 350, this);
      gg.drawImage(image3, 900, 0, this);
      gg.drawImage(image4, policeX, policeY, this);
      gg.drawImage(image5, teacherX, teacherY, this);
      gg.drawImage(image6, kidX, kidY, this);
    }
    
    public void mouseReleased(MouseEvent mouse)
    {
    	pressed = 0;
    }    
    
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
    
    
    
    
    
    

 }