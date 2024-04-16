package addressbook.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookAppUI {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField nameField, phoneField, emailField;
    private AddressBook addressBook;

    public AddressBookAppUI() {
        addressBook = new AddressBook();
        frame = new JFrame("Address Book Application");
        textArea = new JTextArea(15, 30);
        nameField = new JTextField(10);
        phoneField = new JTextField(10);
        emailField = new JTextField(10);

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add contact logic here
            }
        });

        // Similar action listeners for other buttons

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(addButton);
        // Add other buttons to the panel

        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AddressBookAppUI();
    }
}