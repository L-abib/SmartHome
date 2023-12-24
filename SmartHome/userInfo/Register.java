package userInfo;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Register extends JFrame 
{
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loginButton;

    public Register() 
    {
        setTitle("Registration Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 40, 80, 25);
        usernameField = new JTextField();
        usernameField.setBounds(100, 40, 200, 30);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 100, 80, 25);
        emailField = new JTextField();
        emailField.setBounds(100, 100, 200, 30);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 160, 80, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 160, 200, 30);
        registerButton = new JButton("Register");
        registerButton.setBounds(120, 220, 150, 30);
        loginButton = new JButton("Login");
        loginButton.setBounds(120, 260, 150, 30);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(loginButton);

        registerButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (validateRegistration()) 
                {
                    String username = usernameField.getText();
                    String email = emailField.getText();
                    String password = String.valueOf(passwordField.getPassword());

                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("user_info.txt", true))) 
                    {
                        bufferedWriter.write(username + "," + email + "," + password + "\n");
                        JOptionPane.showMessageDialog(Register.this, "Registration Successful!");
                        clearFields();
                    } 
                    catch (IOException ex) 
                    {
                        JOptionPane.showMessageDialog(Register.this, "Error occurred while registering user.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

        loginButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                login logout = new login();
                logout.setVisible(true);
                dispose();
            }
        });
        add(panel);
        setVisible(true);
    }

    private boolean validateRegistration() 
    {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = String.valueOf(passwordField.getPassword()).trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
        else if (!isValidEmail(email)) 
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) 
    {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private void clearFields() 
    {
        usernameField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new Register());
    }
}
