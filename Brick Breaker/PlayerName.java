import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PlayerName extends JFrame {
    JLabel playerTitle;
    JLabel gameTitle;
    JTextField textField;

    // Constructor
    PlayerName() {

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
        playerTitle = new JLabel("Enter your name");
        playerTitle.setBounds(170, 225, 447, 35);
        playerTitle.setForeground(Color.ORANGE); // Font color

        // Enter name textfield
        textField = new JTextField(15);
        EventHandler handler = new EventHandler();
        textField.setBounds(120,270, 447, 35);
        textField.addKeyListener(handler);

        // Create the font
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, App.class.getResourceAsStream("Emulogic.ttf"));
            gameTitle.setFont(font.deriveFont(Font.PLAIN, 34));
            playerTitle.setFont(font.deriveFont(Font.PLAIN, 23));
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Add to window
        this.add(label);
        label.add(playerTitle);
        label.add(gameTitle);
        label.add(textField);

        // Dimensions
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(710, 620);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private class EventHandler implements KeyListener {

        public void keyPressed(KeyEvent event) {

            // If ENTER button is pressed, do this
            if (event.getKeyCode() == KeyEvent.VK_ENTER) {

                GamePlay.playerName = textField.getText();

                // Close playermenu frame
                dispose();

                // Go to game frame
                new Main();
            }
        }

        public void keyTyped(KeyEvent event) {
            //
        }

        public void keyReleased(KeyEvent event) {
            //
        }
    }
}