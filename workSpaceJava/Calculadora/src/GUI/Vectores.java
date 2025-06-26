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
		
		JPanel centroLibre = new JPanel(null);

        JLabel tituloVectores = new JLabel("VECTORES", SwingConstants.CENTER);
        tituloVectores.setBounds(165, 1, 120, 40);
        centroLibre.add(tituloVectores);

        add(BotonVolver.crear(cardLayout, contenedorDeCartas), BorderLayout.SOUTH);
        
        JButton btnReg = new JButton("REGRESAR");
        btnReg.setBackground(new Color(255, 255, 255));
        btnReg.setBounds(10, 11, 100, 20);
		centroLibre.add(btnReg);
        btnReg.setMaximumSize(new Dimension(200, 30));
        
        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	contenedorDeCartas.setVisible(false);
                cardLayout.show(contenedorDeCartas, "");
                panelBotones.setVisible(true);
                titulo.setVisible(true);
            }
        });
        add(centroLibre, BorderLayout.CENTER);
	}

}
