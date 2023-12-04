import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    // GUI components
    JButton start, back;
    String name;

    // Constructor for the Rules class
    Rules(String name) {

        this.name = name;
        // Set up the heading label
        JLabel heading = new JLabel("Welcome " + name + " to QUIZ TEST");
        heading.setBounds(150, 100, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);
        // Set up the rules label
        JLabel rules = new JLabel();
        rules.setBounds(70, 150, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setForeground(new Color(22, 99, 54));
        rules.setText(
                "<html>" +
                        "1. Code4U is free and opened to everyone who wants to improve coding knowledge." + "<br><br>"
                        +
                        "2. There are a total 10 questions. " + "<br><br>" +
                        "3. You only have 15 seconds to answer the question." + "<br><br>" +
                        "4. No cell phones or other secondary devices in the room or test area." + "<br><br>" +
                        "5. No talking." + "<br><br>" +
                        "6. No one else can be in the room with you." + "<br><br>" +
                        "<html>");
        add(rules);
        // Set up the Back button
        back = new JButton("Back");
        back.setBounds(300, 500, 100, 30);
        back.setBackground(new Color(22, 99, 54));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        // Set up the Start button
        start = new JButton("Start");
        start.setBounds(450, 500, 100, 30);
        start.setBackground(new Color(22, 99, 54));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        // Set up the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image i = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 800, 650);
        add(image);
        // Set JFrame properties
        setSize(800, 650);
        setLocation(350, 100);
        setLayout(null);
        setVisible(true);
    }

    // ActionListener interface method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // If Start button is clicked, hide the current JFrame and start the quiz
        if (e.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        }
        // If Back button is clicked, hide the current JFrame and go back to the Login
        // screen
        else {
            setVisible(false);
            new Login();
        }
    }

    // Main method to create an instance of the Rules class
    public static void main(String[] args) {
        new Rules("User");
    }
}
