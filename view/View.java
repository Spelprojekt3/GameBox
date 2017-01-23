package view; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View extends JFrame {
	
private JPanel topPanel,bottomPanel,centerPanel,westPanel,eastPanel; 
private JButton[][] gameButtons; 
private static View firstInstance = null; 
	
private View(){
	
	createWindow();
	createGameButtons(4,4); 
	setVisible(true);
	
	
}

public static View getInstance(){
	
	if(firstInstance ==null){
		
		firstInstance = new View(); 
	}
	return firstInstance; 
}
public void createWindow() {
	
	setPreferredSize(new Dimension(600,800));
    getContentPane().setLayout(new BorderLayout());

    
    topPanel= new JPanel(); 
    JLabel label = new JLabel(); 
    label.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 50));
    label.setForeground(new Color(255,255,255));
    
    
	topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    topPanel.setPreferredSize(new Dimension(200, 120));
    topPanel.setBackground(new Color(46,46,46));
    add(topPanel,BorderLayout.NORTH); 
    //topPanel.setBackground(new Color(0,0,0));
	
	centerPanel= new JPanel(); 
    centerPanel.setLayout(new GridLayout(4,4));
	centerPanel.setBackground(new Color(46,46,46));
	add(centerPanel,BorderLayout.CENTER);
	
	westPanel= new JPanel(); 
	westPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    westPanel.setPreferredSize(new Dimension(40, 0));
    westPanel.setBackground(new Color(46,46,46));
    add(westPanel,BorderLayout.WEST); 
   
    eastPanel= new JPanel(); 
	eastPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    eastPanel.setPreferredSize(new Dimension(40,0));
    eastPanel.setBackground(new Color(46,46,46));
    add(eastPanel,BorderLayout.EAST); 
	
	
	bottomPanel= new JPanel(); 
	bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,30));
    bottomPanel.setPreferredSize(new Dimension(0,150));
    bottomPanel.setBackground(new Color(46,46,46));
    add(bottomPanel,BorderLayout.SOUTH); 
	
	
	pack();  
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
			    
}

public void createGameButtons(int x, int y){
	
	setGameButtons(new JButton[x][y]); 
	
	for(int i=0;i<getGameButtons().length;i++){
	
	for(int j=0;j<getGameButtons().length;j++){
		
		 gameButtons[i][j] = new JButton();
		 gameButtons[i][j].setBackground(new Color(255,255,255));
		 gameButtons[i][j].setFont(new Font("Tahoma",Font.PLAIN,50));
		 gameButtons[i][j].setForeground(new Color(46,46,46));
         centerPanel.add(getGameButtons()[i][j]);     
	}
}	
}
	
public void setButtonInvisible()
	{

	for(int i=0;i<gameButtons.length;i++){
	
	for(int j=0;j<gameButtons.length;j++){
		
			if(gameButtons[i][j].getText().equals("0"))
			{
			   
				gameButtons[i][j].setContentAreaFilled(false);
			    gameButtons[i][j].setFocusable(false);
			    gameButtons[i][j].setText(" ");
			    gameButtons[i][j].setBorderPainted(false);
			}
			else
			{
				gameButtons[i][j].setContentAreaFilled(true);
			    gameButtons[i][j].setFocusable(true);
			    gameButtons[i][j].setBorderPainted(true);
			}
			
		}
    }	
}		
	
	


public JButton[][] getGameButtons() {
	return gameButtons;
}

public void setGameButtons(JButton[][] gameButtons) {
	this.gameButtons = gameButtons;
}
	
};



