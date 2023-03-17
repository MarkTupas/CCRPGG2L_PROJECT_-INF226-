import javax.swing.WindowConstants;

public class App {
    public static void main(String[] args) {
        
        Home title = new Home(); // Call Home

        // Create the Home window
        title.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        title.setSize(710, 620);
        title.setVisible(true);
        title.setResizable(false);
        title.setLocationRelativeTo(null);
    }
}
