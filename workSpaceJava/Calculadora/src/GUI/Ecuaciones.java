package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ecuaciones extends JPanel {

    private static final long serialVersionUID = 1L;

    public Ecuaciones(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {
        
    	
    	setLayout(new BorderLayout());

    	JPanel centroLibre = new JPanel(null);
    	
        JLabel tituloEcuaciones = new JLabel("ECUACIONES", SwingConstants.CENTER);
        tituloEcuaciones.setBounds(165, 1, 120, 40);
        centroLibre.add(tituloEcuaciones);

        
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
