package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Vectores extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Vectores(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {
		
		setLayout(new BorderLayout());

        JLabel tituloVectores = new JLabel("VECTORES", SwingConstants.CENTER);
        add(tituloVectores, BorderLayout.CENTER);

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
