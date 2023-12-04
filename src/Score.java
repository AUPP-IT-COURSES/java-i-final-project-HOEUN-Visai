// package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

public class Score extends JFrame {
    Score(String name, int score) {
        // Set up the score image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60, 200, 200, 150);
        add(image);

        // Set up the heading label
        JLabel heading = new JLabel("Thank you " + name + " for Playing QUIZ Test ");
        heading.setBounds(100, 80, 700, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(heading);

        // Set up the score label
        JLabel Score = new JLabel("Your Score is " + score);
        Score.setBounds(350, 200, 300, 30);
        Score.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(Score);

        // Set up the exit button
        JButton exit = new JButton("EXIT");
        exit.setBounds(380, 270, 120, 30);
        exit.setBackground(new Color(22, 99, 54));
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        // Set up the background image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image i22 = i11.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imagee = new JLabel(i33);
        imagee.setBounds(0, 0, 750, 550);
        add(imagee);

        // Set JFrame properties
        setSize(750, 550);
        setLocation(400, 150);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    // Main method to create an instance of the Score class
    public static void main(String[] args) {
        new Score("User", 0);
    }
}
