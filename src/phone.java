import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class phone extends JPanel {
    ///////////////////////////
    ///      VARIABLES      ///
    ///////////////////////////
    private ContactList c;
    private int pixelSize = 3;
    private String message = "";
    private JButton contactList = new JButton("View Contacts");
    private JButton addContact = new JButton("Add Contact");
    private JButton close = new JButton("Exit App");
    private JButton returnToMenu = new JButton("Return to Main Menu");
    private JTextField text = new JTextField();
    private JButton submitSearch = new JButton("Submit");

    ///////////////////////////
    ///    CONSTRUCTORS     ///
    ///////////////////////////
    public phone(ContactList contacts) {
        c = contacts;
        JFrame frame = new JFrame("Phone Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 125 * pixelSize;
        int height = 200 * pixelSize;
        frame.setSize(width + 16, height + 39);
        setLayout(new FlowLayout(FlowLayout.CENTER, 210, 20));
        frame.add(this);

        submitSearch.addActionListener(e -> {
            String input = text.getText();
            String ct = "";
            c.searchByName(input);
        });
        contactList.addActionListener(e -> {
            showContacts();
        });
        returnToMenu.addActionListener(e -> {
            mainMenu();
        });
        addContact.addActionListener(e -> {
            addContact();
        });
        close.addActionListener(e -> {
            System.exit(0);
        });

        frame.setVisible(true);
        setFocusable(true);
        requestFocusInWindow();
        mainMenu();
    }

    private void mainMenu() {
        removeAll();
        add(contactList);
        add(addContact);
        add(close);
        revalidate();
        repaint();
    }


    private void showContacts() {
        removeAll();
        add(returnToMenu);
        //message = c.getContactList();
        revalidate();
        repaint();
    }
    private void addContact() {
        removeAll();
        add(text);
        add(submitSearch);
        String list = "";
        for(Contact s : c.getAllContacts()) {
            message += s.toString();
        }
        revalidate();
        repaint();
    }

    ///////////////////////////
    ///       METHODS       ///
    ///////////////////////////
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(message, 50, 50);

    }
}
