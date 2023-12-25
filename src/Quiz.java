import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Quiz class that extends JFrame and implements ActionListener
public class Quiz extends JFrame implements ActionListener {

    // Arrays to store questions, answer options, correct answers, and user answers
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    // GUI components
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    // Timer and scoring variables
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    // User's name
    String name;

    Quiz(String name) {
        this.name = name;
        // Initialize JFrame properties
        setBounds(5, 5, 1250, 680);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Load and display an image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/JavaQuiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1250, 292);
        add(image);

        // Set up questions and answers
        qno = new JLabel();
        qno.setBounds(10, 45, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 310, 800, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "1. What is a correct syntax to output \"Hello World\" in Java?";
        questions[0][1] = "Console.WriteLine('Hello World')";
        questions[0][2] = "print('Hello World')";
        questions[0][3] = "System.out.println('Hello World')";
        questions[0][4] = "echo('Hello World')";

        questions[1][0] = "2. How do you insert COMMENTS in java code?";
        questions[1][1] = "// This is a comment";
        questions[1][2] = "/* This is a comment";
        questions[1][3] = "# This is a comment";
        questions[1][4] = "** This is a comment";

        questions[2][0] = "3. Which data type is used to create a variable that should store text?";
        questions[2][1] = "String";
        questions[2][2] = "string";
        questions[2][3] = "myString";
        questions[2][4] = "Txt";

        questions[3][0] = "4. How do you create a variable with the numeric value 5?";
        questions[3][1] = "float x = 5; ";
        questions[3][2] = "int x = 5; ";
        questions[3][3] = "x = 5; ";
        questions[3][4] = "num x = 5";

        questions[4][0] = "5. Arrays in java are?";
        questions[4][1] = "Object References";
        questions[4][2] = "Objects";
        questions[4][3] = "Primitive data type";
        questions[4][4] = "None";

        questions[5][0] = "6. Which method can be used to find the length of a string?";
        questions[5][1] = "getSize()";
        questions[5][2] = "length()";
        questions[5][3] = "len()";
        questions[5][4] = "getLength()";

        questions[6][0] = "7. What is the correct way to create an object called myObj of MyClass?";
        questions[6][1] = "class MyClass = new myObj(); ";
        questions[6][2] = "new myObj = MyClass(); ";
        questions[6][3] = "class myObj = new MyClass(); ";
        questions[6][4] = "MyClass myObj = new MyClass(); ";

        questions[7][0] = "8. How do you start writing an if statement in Java?";
        questions[7][1] = "if x > y: ";
        questions[7][2] = "if x > y then: ";
        questions[7][3] = "If x > y; ";
        questions[7][4] = "if (x > y)";

        questions[8][0] = "9. To which of the following does the class string belong to";
        questions[8][1] = "java.lang";
        questions[8][2] = "java.awt";
        questions[8][3] = "java.applet";
        questions[8][4] = "java.String";

        questions[9][0] = "10. How do you start writing a while loop in java?";
        questions[9][1] = "x > y while { ";
        questions[9][2] = "while (x > y)";
        questions[9][3] = "while x > y:";
        questions[9][4] = "while x > y {";

        answers[0][1] = "System.out.println('Hello World')";
        answers[1][1] = "// This is a comment";
        answers[2][1] = "String";
        answers[3][1] = "int x = 5;";
        answers[4][1] = "Object References";
        answers[5][1] = "length()";
        answers[6][1] = "MyClass myObj = new MyClass(); ";
        answers[7][1] = "if (x > y)";
        answers[8][1] = "java.lang";
        answers[9][1] = "while (x > y)";

        // Initialize and set properties for radio buttons
        opt1 = new JRadioButton();
        opt1.setBounds(170, 350, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 390, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 430, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 470, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        // Initialize and set properties for buttons (Next, Help, Submit)
        next = new JButton("Next");
        next.setBounds(800, 550, 100, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("Help");
        lifeline.setBounds(910, 550, 100, 30);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline.setBackground(new Color(22, 99, 54));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1020, 550, 100, 30);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(255, 215, 0));

        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    // ActionListener interface method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        // Handling Next button click
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            // Move to the next question
            count++;
            start(count);
            // Handling help button click
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
            // Handling Submit button click
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        // Display timer countdown
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 800, 500);
        } else {
            g.drawString("Times up!!", 1000, 500);
        }

        timer--; // Update the timer and repaint

        // Check if an answer was given or if the timer has expired
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        // Set text for labels, radio buttons, and clear selection
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    // Main method to create an instance of the Quiz class
    public static void main(String[] args) {
        new Quiz("User");
    }
}
