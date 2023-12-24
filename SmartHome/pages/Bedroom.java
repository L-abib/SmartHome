package pages;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Bedroom extends room 
{
    public Bedroom() 
    {
        super("Bedroom");

        img1 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\light_off.png"));
        img2 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\ac_off.png"));
        img3 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\light_on.png"));
        img4 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\ac_on.png"));
        img5 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\lock.jpg"));
        img6 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\music_off.png"));
        img7 = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\unlock.jpg"));
        img8 = new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\music_on.gif");
        
        button1.setText("Light On/Off");
        button2.setText("AC On/Off");
        button3.setText("Door Lock/Unlock");
        button4.setText("Music On/Off");

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
        SwingUtilities.invokeLater(() -> new Bedroom());
    }
}
