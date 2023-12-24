package pages;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Kitchen extends room 
{
    public Kitchen() 
    {
        super("Kitchen");

        img1 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\light_off.png"));
        img2 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\efan_off.png"));
        img3 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\light_on.png"));
        img4 = new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\efan_on.gif");
        img5 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\oven_off.png"));
        img6 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\coffee_off.png"));
        img7 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\oven_on.png"));
        img8 = new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\coffee_on.gif");
        
        button1.setText("Light On/Off");
        button2.setText("Exhaust Fan On/Off");
        button3.setText("Smart Oven on/Off");
        button4.setText("Coffee Machine");

        imgLabel1.setIcon(img1);
        imgLabel2.setIcon(img2);
        imgLabel3.setIcon(img5);
        imgLabel4.setIcon(img6);
    }

    public void actionPerformed(ActionEvent e) 
    {
        super.actionPerformed(e); 
    }
    
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new Kitchen());
    }
}
