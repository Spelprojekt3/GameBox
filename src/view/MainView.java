package view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Image;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView{
	

private JPanel centerPanel; 
private JFrame mainframe; 
private JLabel label;
public JButton[] mainButtons; 


public MainView(){

createMainWindow(); 
addBackground();  
addButtons(); 
mainframe.setVisible(true);
}


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



public void addButtons(){
	mainButtons= new JButton[2]; 
	
	for(int i = 0;i<mainButtons.length;i++){
	 mainButtons[i] = new JButton();	
	 mainButtons[i].setSize(197,200);
	 setImage(mainButtons[i],"/images/button"+Integer.toString(i+1)+".png"); 
	 mainButtons[i].setFocusable(false);
	 centerPanel.add(mainButtons[i]);
	}
	
}

public void addBackground(){

		try {
		Image img = ImageIO.read(getClass().getResource("/images/menu.png"));
		label= new JLabel(new ImageIcon(img));
		} catch (IOException ex) {
		}
		mainframe.add(label);
		
}

public void setImage(JButton button ,String string) {
try {
Image img = ImageIO.read(getClass().getResource(string));
button.setIcon(new ImageIcon(img));
} catch (IOException ex) {
}
}

}







