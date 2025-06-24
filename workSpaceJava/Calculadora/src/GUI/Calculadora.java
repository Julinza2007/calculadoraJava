package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;

	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(0, 0, 450, 300);
	    setLocationRelativeTo(null);
	    
		panelPrincipal = new JPanel(); // Este es el contenedor principal, que es un Panel
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.setBackground(new Color(128, 128, 128));
		
		
		JPanel contenedorCentral = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        contenedorCentral.setOpaque(false); // que no tape el fondo gris


	    // Panel de menú
	    PanelMenu menu = new PanelMenu();
	    menu.setPreferredSize(new Dimension(400, 300)); // Tamaño del "card"
        contenedorCentral.add(menu);
        panelPrincipal.add(contenedorCentral, BorderLayout.CENTER);
	    
		setContentPane(panelPrincipal); // Lo que hace esto es guardar en el JFrame justamente el panelPrincipal
	    setVisible(true); // Va a mostrar el JFrame
	}
	
	
}
