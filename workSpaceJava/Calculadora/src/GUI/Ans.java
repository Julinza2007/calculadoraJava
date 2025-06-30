package GUI;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;

public class Ans extends JButton {

    private static final long serialVersionUID = 1L;

    public Ans() {
        super("Ans");
        setFocusPainted(false);
        setFont(new Font("Consolas", Font.PLAIN, 12));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setText("Usar resultado anterior");        
    }
}
