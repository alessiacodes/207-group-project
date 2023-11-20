package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupViewTest {
    public static void main(String[] args) {
        SignupViewTest view = new SignupViewTest();
        view.launchWindow();
    }

    public void launchWindow(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MARVN: Your Virtual Fitness Assistant");
        frame.setSize(1920,1080);
        frame.setVisible(true);



        final CardLayout cardLayout = new CardLayout();
        final JPanel startPanel = new JPanel();
        startPanel.setLayout(cardLayout);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setBackground(Color.BLUE);
        JButton button = new JButton("switch to next screen");

        panel2.setBackground(Color.PINK);

        startPanel.add(panel1, "1");
        panel1.add(button);
        startPanel.add(panel2, "2");
        cardLayout.show(startPanel, "1");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(startPanel, "2");
            }
        });

        frame.add(startPanel);
        frame.setVisible(true);



    }
}
