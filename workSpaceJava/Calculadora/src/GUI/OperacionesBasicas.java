package GUI;

import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JLabel;

public class OperacionesBasicas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OperacionesBasicas(CardLayout cardLayout, JPanel contenedorDeCartas) {
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		
	}

}
