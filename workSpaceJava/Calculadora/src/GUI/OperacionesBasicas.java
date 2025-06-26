package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacionesBasicas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OperacionesBasicas(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {
		
		
		setLayout(new BorderLayout());

        JLabel tituloOpeBas = new JLabel("OPERACIONES BASICAS", SwingConstants.CENTER);
        add(tituloOpeBas, BorderLayout.CENTER);

        add(BotonVolver.crear(cardLayout, contenedorDeCartas), BorderLayout.SOUTH);
        
        JButton btnReg = new JButton("REGRESAR");
        btnReg.setBackground(new Color(255, 255, 255));
		btnReg.setVerticalAlignment(SwingConstants.BOTTOM);
		add(btnReg, BorderLayout.NORTH);
        btnReg.setMaximumSize(new Dimension(200, 30));
        
        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	contenedorDeCartas.setVisible(false);
                cardLayout.show(contenedorDeCartas, "");
                panelBotones.setVisible(true);
                titulo.setVisible(true);
            }
        });
		
		
		
	}

}
