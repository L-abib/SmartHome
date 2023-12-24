package pages; 
import userInfo.*;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HomePage extends JFrame implements ActionListener 
{

    private JButton logoutButton, bedroomButton, kitchenButton, drawingRoomButton, deleteAcc;
    private ImageIcon bigPicture;
    private JLabel text;
    private String username;

    public HomePage(String username) 
    {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        this.username=username;
        text =new JLabel("Welcome To Our App " + username + "!");
        text.setBounds(190, 370, 400, 50);
        add(text);

        bigPicture = resizeImage(new ImageIcon("F:\\Java Project\\SmartHome\\src\\pages\\Home.jpg")); 
        JLabel bigPictureLabel = new JLabel(bigPicture);
        bigPictureLabel.setBounds(50, 60, 400, 320); 
        add(bigPictureLabel);

        bedroomButton = new JButton("Bedroom");
        bedroomButton.setBounds(50, 430, 150, 50);
        bedroomButton.addActionListener(this);
        add(bedroomButton);

        kitchenButton = new JButton("Kitchen");
        kitchenButton.setBounds(300, 430, 150, 50);
        kitchenButton.addActionListener(this);
        add(kitchenButton);

        drawingRoomButton = new JButton("Drawing Room");
        drawingRoomButton.setBounds(50, 530, 150, 50);
        drawingRoomButton.addActionListener(this);
        add(drawingRoomButton);
        
        logoutButton = new JButton("Log Out");
        logoutButton.setBounds(50, 20, 80, 30);
        logoutButton.addActionListener(this); 
        add(logoutButton);
        
        deleteAcc = new JButton("Delete Account");
        deleteAcc.setBounds(300, 530, 150, 50);
        deleteAcc.addActionListener(this); 
        add(deleteAcc);

        setSize(500, 700); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    protected ImageIcon resizeImage(ImageIcon icon) 
    {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(400, 320, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == logoutButton) 
        {
            login logout = new login();
            logout.setVisible(true);
            this.dispose();
        } 
        else if (e.getSource() == bedroomButton) 
        {
            Bedroom bed = new Bedroom();
            bed.setVisible(true);
            this.dispose();
        } 
        else if (e.getSource() == kitchenButton) 
        {
        	Kitchen kit = new Kitchen();
            kit.setVisible(true);
            this.dispose();
        } 
        else if (e.getSource() == drawingRoomButton) 
        {
        	DrawingRoom dr = new DrawingRoom();
            dr.setVisible(true);
            this.dispose();
        } 
        else if (e.getSource() == deleteAcc) 
        {
            String filename = "user_info.txt";
            String tempFile = "temp_user_info.txt";
            String lineToRemove = username; 

            File oldFile = new File(filename);
            File newFile = new File(tempFile);

            try (BufferedReader reader = new BufferedReader(new FileReader(oldFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) 
            {

                String line;
                while ((line = reader.readLine()) != null) 
                {
                    String[] userInfo = line.split(",");
                    if (userInfo.length >= 1 && !userInfo[0].equals(lineToRemove)) 
                    {
                        writer.write(line + System.getProperty("line.separator"));
                    }
                }
            } 
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(this, "Error deleting user account.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }

            if (oldFile.delete()) 
            {
                newFile.renameTo(oldFile);
                JOptionPane.showMessageDialog(this, "Account deleted successfully!");
                login logout = new login();
                logout.setVisible(true);
                this.dispose();
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Error deleting user account.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }
    
    
    

    public static void main(String[] args) 
    {
    	String username = "";
        SwingUtilities.invokeLater(() -> new HomePage(username));
    }
}
