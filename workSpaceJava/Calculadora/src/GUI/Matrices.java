package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Matrices extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Matrices(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {
		
		setLayout(new BorderLayout());
		
		JPanel centroLibre = new JPanel(null);

        JLabel tituloMatriz = new JLabel("MATRICES", SwingConstants.CENTER);
        tituloMatriz.setBounds(165, 1, 120, 40);
        centroLibre.add(tituloMatriz);

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
        
        
        
        
        JPanel panelFilas1 = new JPanel ();
        JComboBox<Integer> comboFilas1 = new JComboBox<>(new Integer[] {1, 2, 3, 4});
        JComboBox<Integer> comboColumn1 = new JComboBox<>(new Integer[] {1, 2, 3, 4});
   
        panelFilas1.setBorder(BorderFactory.createTitledBorder("filas - columnas"));
        panelFilas1.add(comboFilas1);
        panelFilas1.add(comboColumn1);
        panelFilas1.setBounds(318, 44, 122, 52);     
        centroLibre.add(panelFilas1);
        
        JLabel lblMatriz1 = new JLabel("MATRIZ 1");
        lblMatriz1.setHorizontalAlignment(SwingConstants.CENTER);
        lblMatriz1.setBounds(318, 27, 122, 14);
        centroLibre.add(lblMatriz1);
        
        JPanel panelFilas2 = new JPanel ();
        JComboBox<Integer> comboFilas2 = new JComboBox<>(new Integer[] {1, 2, 3, 4});
        JComboBox<Integer> comboColumn2 = new JComboBox<>(new Integer[] {1, 2, 3, 4});
   
        panelFilas2.setBorder(BorderFactory.createTitledBorder("filas - columnas"));
        panelFilas2.add(comboFilas2);
        panelFilas2.add(comboColumn2);
        panelFilas2.setBounds(318, 134, 122, 52);     
        centroLibre.add(panelFilas2);
        
        JLabel lblMatriz2 = new JLabel("MATRIZ 2");
        lblMatriz2.setHorizontalAlignment(SwingConstants.CENTER);
        lblMatriz2.setBounds(318, 115, 122, 14);
        centroLibre.add(lblMatriz2);
        
        JPanel panelMatriz = new JPanel();
        panelMatriz.setBounds(10, 64, 267, 165);
        centroLibre.add(panelMatriz);
        
        int filas = (Integer) comboFilas1.getSelectedItem();
        int columnas = (Integer) comboColumn1.getSelectedItem();
        
        JButton btncrear = new JButton("GENERAR MATRIZ");
        btncrear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panelMatriz.removeAll();
        		panelMatriz.setLayout(new GridLayout(filas, columnas ));
        		
        		for (int i=0 ; i < filas * columnas; i++) {
        			JTextField campo = new JTextField();
        			panelMatriz.add(campo);
        		}
        		
        		panelMatriz.revalidate();
        		panelMatriz.repaint();
        	}
        });
        btncrear.setBounds(318, 201, 122, 23);
        centroLibre.add(btncrear);
        
        
        
        
	}
}
