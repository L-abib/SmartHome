package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class room extends JFrame implements ActionListener {
    protected JLabel imgLabel1, imgLabel2, imgLabel3, imgLabel4, text;
    protected JButton button1, button2, button3, button4, Hbutton;
    protected ImageIcon img1, img2, img3, img4, img5, img6, img7, img8;
    protected String username;


    public room(String roomTitle) {
        setTitle(roomTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        this.username=username;
        text =new JLabel("Welcome To " + username + "'s " + roomTitle);
        text.setBounds(50, 410, 400, 50);
        add(text);

        imgLabel1 = new JLabel(img1);
        imgLabel1.setBounds(50, 80, 150, 150);
        imgLabel2 = new JLabel(img2);
        imgLabel2.setBounds(275, 80, 150, 150);
        imgLabel3 = new JLabel(img5);
        imgLabel3.setBounds(50, 250, 150, 150);
        imgLabel4 = new JLabel(img6);
        imgLabel4.setBounds(275, 250, 150, 150);

        Hbutton = new JButton("⏪ 🏠");
        Hbutton.setBounds(50, 20, 60, 30);
        button1 = new JButton("");
        button1.setBounds(50, 470, 150, 60);
        button2 = new JButton("");
        button2.setBounds(275, 470, 150, 60);
        button3 = new JButton("");
        button3.setBounds(50, 550, 150, 60);
        button4 = new JButton("");
        button4.setBounds(275, 550, 150, 60);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        Hbutton.addActionListener(this);

        add(imgLabel1);
        add(imgLabel2);
        add(imgLabel3);
        add(imgLabel4);
        add(Hbutton);
        add(button1);
        add(button2);
        add(button3);
        add(button4);

        setSize(500, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected ImageIcon resizeImage(ImageIcon icon) 
    {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == button1) 
        {
            if (imgLabel1.getIcon().equals(img1)) 
            {
                imgLabel1.setIcon(img3);
            } 
            else 
            {
                imgLabel1.setIcon(img1);
            }
        } 
        else if (e.getSource() == button2) 
        {
            if (imgLabel2.getIcon().equals(img2)) 
            {
                imgLabel2.setIcon(img4);
            } 
            else 
            {
                imgLabel2.setIcon(img2);
            }
        }
        else if (e.getSource() == button3) 
        {
            if (imgLabel3.getIcon().equals(img5)) 
            {
                imgLabel3.setIcon(img7);
            } 
            else 
            {
                imgLabel3.setIcon(img5);
            }
        }
        else if (e.getSource() == button4) 
        {
            if (imgLabel4.getIcon().equals(img6)) 
            {
                imgLabel4.setIcon(img8);
            } 
            else 
            {
                imgLabel4.setIcon(img6);
            }
        }
        else if (e.getSource() == Hbutton) 
        {
        	String username = "";
        	HomePage home = new HomePage(username);
        	home.setVisible(true);
            this.dispose();
        }
    }
}
