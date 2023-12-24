package pages;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class DrawingRoom extends room 
{
    public DrawingRoom() 
    {
        super("Drawing Room");

        img1 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\light_off.png"));
        img2 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\fan_off.png"));
        img3 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\light_on.png"));
        img4 = new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\fan_on.gif");
        img5 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\robot_off.png"));
        img6 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\tv_off.png"));
        img7 = new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\robot_on.gif");
        img8 = new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\tv_on.gif");
        
        button1.setText("Light On/Off");
        button2.setText("Fan On/Off");
        button3.setText("Robot On/Off");
        button4.setText("TV On/Off");

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
        SwingUtilities.invokeLater(() -> new DrawingRoom());
    }
}
