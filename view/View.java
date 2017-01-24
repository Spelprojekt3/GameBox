package view; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;


public class View {
	
private JPanel topPanel,bottomPanel,centerPanel,westPanel,eastPanel; 
private JButton[][] gameButtons;
public JButton[] mainButtons; 
private static View firstInstance = null; 
private JButton exitButton; 
private static JFrame mainframe; 

	
private View(){
	
	createWindow();
	createGameButtons(4,4); 
	createExitButton(); 
	mainframe.setVisible(true);
	removeRootPane();
}

public static View getInstance(){
	
	if(firstInstance ==null){
		
		firstInstance = new View(); 
	}
	return firstInstance; 
}

public static void closeWindow(){
	
	mainframe.dispatchEvent(new WindowEvent(mainframe, WindowEvent.WINDOW_CLOSING));
	
}

public static void setInstance(){
		
		firstInstance =null; 
	
}
public void createWindow() {
	
	mainframe= new JFrame(); 
	mainframe.setPreferredSize(new Dimension(600,800));
    mainframe.getContentPane().setLayout(new BorderLayout());

    
    topPanel= new JPanel(); 
    JLabel label = new JLabel(); 
    label.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 50));
    label.setForeground(new Color(255,255,255));
    
    
	topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    topPanel.setPreferredSize(new Dimension(200, 120));
    topPanel.setBackground(new Color(46,46,46));
    mainframe.add(topPanel,BorderLayout.NORTH); 
    //topPanel.setBackground(new Color(0,0,0));
	
	centerPanel= new JPanel(); 
    centerPanel.setLayout(new GridLayout(4,4));
	centerPanel.setBackground(new Color(46,46,46));
	mainframe.add(centerPanel,BorderLayout.CENTER);
	
	westPanel= new JPanel(); 
	westPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    westPanel.setPreferredSize(new Dimension(40, 0));
    westPanel.setBackground(new Color(46,46,46));
    mainframe.add(westPanel,BorderLayout.WEST); 
   
    eastPanel= new JPanel(); 
	eastPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    eastPanel.setPreferredSize(new Dimension(40,0));
    eastPanel.setBackground(new Color(46,46,46));
    mainframe.add(eastPanel,BorderLayout.EAST); 
	
	
	bottomPanel= new JPanel(); 
	bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,30));
    bottomPanel.setPreferredSize(new Dimension(0,150));
    bottomPanel.setBackground(new Color(46,46,46));
    mainframe.add(bottomPanel,BorderLayout.SOUTH); 
	
	
	mainframe.pack();  
	mainframe.setLocationRelativeTo(null);
			    
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
public void createExitButton(){
	
	exitButton=(new JButton("X")); 
	exitButton.setBackground(new Color(255,0,0));
	topPanel.add(getExitButton()); 
	
	
}


	
public void setButtonInvisible()
	{

	for(int i=0;i<gameButtons.length;i++){
	
	for(int j=0;j<gameButtons.length;j++){
		
			if(gameButtons[i][j].getText().equals("0"))
			{
			   
				gameButtons[i][j].setContentAreaFilled(false);
			    gameButtons[i][j].setFocusable(false);
			    gameButtons[i][j].setText("");
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
public void removeRootPane(){	
mainframe.getRootPane().setWindowDecorationStyle(JRootPane.NONE);	
}

public JButton[][] getGameButtons() {
	return gameButtons;
}

public void setGameButtons(JButton[][] gameButtons) {
	this.gameButtons = gameButtons;
}

public JButton getExitButton() {
	return exitButton;
}

public void setExitButton(JButton exitButton) {
	this.exitButton = exitButton;
}
	
};



