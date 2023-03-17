import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficulty extends JFrame {
// implements ActionListener 

    JButton easyButton;
    JButton mediumButton;
    JButton hardButton;
    JLabel difficultyTitle;
    JLabel gameTitle;

    // Constructor
    Difficulty() {

        super("Brick Breaker"); // Title of window

        // Icon
        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());

        // Image Background
        ImageIcon background = new ImageIcon("Stars.gif");
        JLabel label = new JLabel(background);
        label.setSize(710, 620);

        // gameTitle
        gameTitle = new JLabel("BRICK BREAKER");
        gameTitle.setBounds(125, 130, 450, 40);
        gameTitle.setForeground(Color.ORANGE); // Font color

        // Choose your difficulty
        difficultyTitle = new JLabel("Choose a difficulty");
        difficultyTitle.setBounds(126, 225, 447, 35);
        difficultyTitle.setForeground(Color.ORANGE); // Font color

        // Easy button
        easyButton = new JButton();
        easyButton.setText("EASY");
        easyButton.setBounds(140, 290, 120, 55);
        easyButton.setBackground(new Color(13, 14, 71)); 
        easyButton.setForeground(Color.WHITE);
        easyButton.setBorder(new LineBorder(Color.WHITE, 3, true));
        EventHandler easyHandler = new EventHandler(10);
        easyButton.addActionListener(easyHandler);

        // Medium button
        mediumButton = new JButton();
        mediumButton.setText("MEDIUM");
        mediumButton.setBounds(275, 290, 150, 55);
        mediumButton.setBackground(new Color(13, 14, 71)); 
        mediumButton.setForeground(Color.WHITE);
        mediumButton.setBorder(new LineBorder(Color.WHITE, 3, true));
        EventHandler mediumHandler = new EventHandler(20);
        mediumButton.addActionListener(mediumHandler);

        // Hard button
        hardButton = new JButton();
        hardButton.setText("HARD");
        hardButton.setBounds(440, 290, 120, 55);
        hardButton.setBackground(new Color(13, 14, 71)); 
        hardButton.setForeground(Color.WHITE);
        hardButton.setBorder(new LineBorder(Color.WHITE, 3, true));
        EventHandler hardHandler = new EventHandler(30);
        hardButton.addActionListener(hardHandler);

        // Create the font
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, App.class.getResourceAsStream("Emulogic.ttf"));
            gameTitle.setFont(font.deriveFont(Font.PLAIN, 34));
            difficultyTitle.setFont(font.deriveFont(Font.PLAIN, 23));
            easyButton.setFont(font.deriveFont(Font.PLAIN, 13));
            mediumButton.setFont(font.deriveFont(Font.PLAIN, 13));
            hardButton.setFont(font.deriveFont(Font.PLAIN, 13));
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Add to window
        this.add(label);
        label.add(easyButton);
        label.add(mediumButton);
        label.add(hardButton);
        label.add(difficultyTitle);
        label.add(gameTitle);

        // Dimensions
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(710, 620);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public class EventHandler implements ActionListener{
        int ballSpeed;

        EventHandler(int speed) {
            this.ballSpeed = speed;
        }

        public void actionPerformed(ActionEvent e) {
            GamePlay gp = new GamePlay();
            gp.delay = ballSpeed;

            new PlayerName();
            dispose();
        }
    }
}