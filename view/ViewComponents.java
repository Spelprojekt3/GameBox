package view;

import java.awt.BorderLayout;
import java.awt.Component;
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

public abstract class ViewComponents {
	
JLabel label; 
	
public void addBackground(JFrame frame ,JLabel label){
; 
		try {
		Image img = ImageIO.read(getClass().getResource("/images/menu.png"));
		label= new JLabel(new ImageIcon(img));
		} catch (IOException ex) {
		}
		frame.add(label);
		}
}