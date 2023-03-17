import javax.swing.ImageIcon; // Images
import javax.swing.JFrame; // Window
import javax.swing.JLabel; // Background
import javax.swing.JButton; // Button
import javax.swing.JOptionPane; // Members
import javax.swing.border.LineBorder;
import javax.swing.Icon;

import java.awt.event.ActionEvent; // Start 
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font; // Font

public class Home extends JFrame implements ActionListener {
    
    JButton startButton;
    JButton aboutButton;
    JButton diffButton;
    JLabel gameTitle;


    // Constructor
    Home() {

        super("Brick Breaker"); // Title of window

        // Icon
        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());

        // Image Background
        ImageIcon background = new ImageIcon("Stars.gif");
        JLabel label = new JLabel(background);
        label.setSize(500, 920);

        // gameTitle
        gameTitle = new JLabel("BRICK BREAKER");
        gameTitle .setBounds(125, 200, 447, 35);
        gameTitle .setForeground(Color.ORANGE); // Font color

        // Start button
        // label.setLayout(new FlowLayout());
        startButton = new JButton();
        startButton.setText("START");
        startButton.setBounds(210, 310, 120, 55);
        startButton.setBackground(new Color(13, 14, 71)); 
        startButton.setBorder(new LineBorder(Color.WHITE, 3, true)); // Border
        startButton.setForeground(Color.WHITE); // Font color
        startButton.addActionListener(this);

        // About button
        aboutButton = new JButton();
        aboutButton.setText("ABOUT");
        aboutButton.setBounds(340, 310, 120, 55);
        aboutButton.setBackground(new Color(13, 14, 71));
        aboutButton.setBorder(new LineBorder(Color.WHITE, 3, true)); // Border
        aboutButton.setForeground(Color.WHITE); // Font color
        aboutButton.addActionListener(this);

        // Create the font
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, App.class.getResourceAsStream("Emulogic.ttf"));
            startButton.setFont(font.deriveFont(Font.PLAIN, 13));
            aboutButton.setFont(font.deriveFont(Font.PLAIN, 13));
            gameTitle.setFont(font.deriveFont(Font.PLAIN, 34));
     } catch(Exception e) {

        }

        // Add to window
        this.add(label);
        label.add(startButton);
        label.add(aboutButton);
        label.add(gameTitle);
    
    }

    // For Start button
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == startButton) {
            new Difficulty();
            dispose();
        }
        if (obj == aboutButton) {
            Icon iconMembers = new ImageIcon("dp1.png");
            JOptionPane.showMessageDialog(null,
                "Amber Gwenn Balboa\nRezelee Enoc\nMark Tupas",
                "About",
                JOptionPane.PLAIN_MESSAGE,
                iconMembers);
        }
     }
}
