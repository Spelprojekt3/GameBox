package view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;

<<<<<<< HEAD


import java.awt.event.ActionListener;
=======
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
>>>>>>> origin/master

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exception.GameException;

/**
 * The view of the MainMenu state
 * @author Marcus, Christoffer 
 *
 */
public class MainView{
	

private JPanel centerPanel; 
private JFrame mainframe; 
private JLabel label;
public JButton[] mainButtons; 

/**
 * Constructor of MainView
 */
public MainView(){

createMainWindow(); 
addBackground();  
addButtons(); 
mainframe.setVisible(true);
}

<<<<<<< HEAD
public class MainController {
	
	GameButtonListener gamebuttonlistener; 
	private static MainController firstInstance=null;
    private MainView mainview;
    private static GameBox box = new GameBox();
/**
 * Constructor of the main 
 */
private MainController(){
	
	 
    mainview= new MainView(); 
	TicTacToe tGame= new TicTacToe(box); 
	SlidePuzzle sGame =new SlidePuzzle(box); 
  
	
	
GameButtonListener gamebuttonlistener = new GameButtonListener(mainview,tGame,sGame);
	
	this.gamebuttonlistener = gamebuttonlistener; 
	
	for (int i= 0; i< mainview.mainButtons.length; i++) {
	
         mainview.mainButtons[i].addActionListener(gamebuttonlistener);
     }
}

public static MainController getInstance(){
	
	if(firstInstance == null){
		
		firstInstance = new MainController(); 
	}
	return firstInstance; 
}
/**
 * Main method of the game 
 * @param arg
 * @throws GameException
 */
public static void main(String[] arg) throws GameException{
        try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            // start application
        } catch (Exception ex) {
            ex.printStackTrace();
} 
          
   
        box.run();
        
        
	}
	
public class GameButtonListener implements ActionListener {

	    MainView view;
	    GameState state1,state2; 
	    

public GameButtonListener(MainView view ,GameState state1,GameState state2){
	        
		this.view  = view;
		this.state1=state1; 
		this.state2=state2; 
		
	      
	    }

public void actionPerformed(ActionEvent e) {
	       	
       for (int i= 0; i< view.mainButtons.length; i++) {
	        
	        	
	                if(e.getSource()==view.mainButtons[0]) {
	                	try {
							state1.run();
						} catch (GameException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	               
	                    }
	               if (e.getSource()==view.mainButtons[1]) {
		                try {
							state2.run();
						} catch (GameException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                    }
	                	
	                	
	                }
	        	}
	    }
=======
/**
 * Creates the window and sets the layout 
 */

public void createMainWindow(){      	

mainframe= new JFrame();
   
mainframe.setPreferredSize(new Dimension(800,600));
mainframe.getContentPane().setLayout(new BorderLayout());
mainframe.setResizable(false);
					    

centerPanel= new JPanel(); 
centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT,22,200));
centerPanel.setOpaque(false);
mainframe.add(centerPanel,BorderLayout.CENTER); 

mainframe.pack();  
mainframe.setLocationRelativeTo(null);
mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				    
}
/**
 * Adds the game-buttons to the main menu
 */


public void addButtons(){
	mainButtons= new JButton[2]; 
	
	for(int i = 0;i<mainButtons.length;i++){
	 mainButtons[i] = new JButton();	
	 mainButtons[i].setSize(197,200);
	 try {
		setImage(mainButtons[i],"/images/button"+Integer.toString(i+1)+".png");
	} catch (GameException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 mainButtons[i].setFocusable(false);
	 centerPanel.add(mainButtons[i]);
	}
	
}
/**
 * Creates a label with a background from a directory 
 */

public void addBackground(){

		try {
		Image img = ImageIO.read(getClass().getResource("/images/menu.png"));
		label= new JLabel(new ImageIcon(img));
		} catch (IOException ex) {
		}
		mainframe.add(label);
		
}

/** 
 * Gets an image from file and sets it a JBUtton 
 * @param button
 * @param string
 * @throws GameException if file is not found
 */

public void setImage(JButton button ,String string) throws GameException {
try {
URL picture = getClass().getResource(string);


if(picture==null)
{
	throw new GameException("Bild saknas"); 
}
Image img = ImageIO.read(picture);
button.setIcon(new ImageIcon(img));
} catch (IOException ex) {
}
>>>>>>> origin/master
}

}
