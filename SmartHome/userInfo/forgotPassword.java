package userInfo;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class forgotPassword extends JFrame 
{
    private JTextField emailField;
    private JPasswordField newPasswordField;
    private JButton updateButton;
    private JButton loginButton;

    public forgotPassword() 
    {
        setTitle("Forgot Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 270);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 40, 80, 25);
        emailField = new JTextField();
        emailField.setBounds(100, 40, 200, 30);
        JLabel newPasswordLabel = new JLabel("New Pass:");
        newPasswordLabel.setBounds(20, 90, 100, 25);
        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(100, 90, 200, 30);
        updateButton = new JButton("Update Password");
        updateButton.setBounds(125, 140, 150, 30);
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 180, 100, 30);

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(updateButton);
        panel.add(loginButton);

        updateButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (validateFields()) 
                {
                    String email = emailField.getText().trim();
                    String newPassword = String.valueOf(newPasswordField.getPassword()).trim();
                    updateUserPassword(email, newPassword);
                }
            }
        });

        loginButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	login log = new login();
                log.setVisible(true);
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }

    private boolean validateFields() 
    {
        String email = emailField.getText().trim();
        String newPassword = String.valueOf(newPasswordField.getPassword()).trim();

        if (email.isEmpty() || newPassword.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void updateUserPassword(String email, String newPassword) 
    {
        boolean emailFound = false;

        try 
        {
            File inputFile = new File("user_info.txt");
            File tempFile = new File("temp_user_info.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = reader.readLine()) != null) 
            {
                String[] userInfo = line.split(",");
                if (userInfo.length >= 3 && userInfo[1].equals(email)) 
                {
                    line = userInfo[0] + "," + email + "," + newPassword;
                    emailFound = true;
                }
                writer.write(line + "\n");
            }

            reader.close();
            writer.close();

            if (!emailFound) 
            {
                JOptionPane.showMessageDialog(this, "Email not found.", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                inputFile.delete();
                tempFile.renameTo(inputFile);

                JOptionPane.showMessageDialog(this, "Password updated successfully!");
                clearFields();
            }
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this, "Error occurred while updating password.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }



    private void clearFields() 
    {
        emailField.setText("");
        newPasswordField.setText("");
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new forgotPassword());
    }
}

