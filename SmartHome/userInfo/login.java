package userInfo;
import pages.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class login extends JFrame 
{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JButton forgotButton;
    public String loggedInUsername;

    public login() 
    {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20,40,80,25);
        usernameField = new JTextField();
        usernameField.setBounds(100,40,200,30);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20,100,80,25);
        passwordField = new JPasswordField();
        passwordField.setBounds(100,100,200,30);
        loginButton = new JButton("Login");
        loginButton.setBounds(120,150,150,30);
        registerButton = new JButton("Register");
        registerButton.setBounds(120,200,150,30);
        forgotButton = new JButton("Forgot Password");
        forgotButton.setBounds(120,250,150,30);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(forgotButton);

        loginButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                loginUser();
            }
        });
        
        registerButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	Register reg = new Register();
                reg.setVisible(true);
                dispose();
            }
        });
        
        forgotButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	forgotPassword fpass = new forgotPassword();
                fpass.setVisible(true);
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void loginUser() 
    {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        try (BufferedReader reader = new BufferedReader(new FileReader("user_info.txt"))) 
        {
            String line;
            boolean userFound = false;

            while ((line = reader.readLine()) != null) 
            {
                String[] userInfo = line.split(",");
                if (userInfo.length == 3 && userInfo[0].equals(username) && userInfo[2].equals(password)) 
                {
                    userFound = true;
                    loggedInUsername = username;
                    break;
                }
            }

            if (userFound) 
            {
            	HomePage home = new HomePage(username);
            	home.setVisible(true);
                clearFields();
                dispose();
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this, "Error reading user information.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void clearFields() 
    {
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	login loginPage = new login();
                loginPage.setVisible(true);
            }
        });
    }
}

