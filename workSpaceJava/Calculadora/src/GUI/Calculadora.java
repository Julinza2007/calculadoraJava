package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Calculadora extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panelPrincipal;

    public Calculadora() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 900, 600);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel();
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(128, 128, 128));

        // Agrega el PanelMenu directamente al centro
        PanelMenu menu = new PanelMenu();
        panelPrincipal.add(menu, BorderLayout.CENTER);

        setContentPane(panelPrincipal);
        setVisible(true);
    }
}
