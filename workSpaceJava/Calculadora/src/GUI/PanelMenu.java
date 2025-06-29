package GUI;

import javax.swing.*;

import GUI.Vectores.Vectores;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
    private JPanel contenedorDeCartas;
	
	    public PanelMenu() {
	    	setLayout(new BorderLayout());
	 	    setBackground(new Color(255, 99, 71));
	 	    
	 	   cardLayout = new CardLayout();

	        contenedorDeCartas = new JPanel();
	        contenedorDeCartas = new JPanel(cardLayout);
    	
    	JLabel titulo = new JLabel("Calculadora G3L");
		titulo.setFont(new Font("Consolas", Font.BOLD, 25));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // margen arriba y abajo
        add(titulo, BorderLayout.NORTH);        
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setOpaque(false); // para que se vea el fondo rojo
		
        JButton btnEj1 = new JButton("Operaciones Básicas");
        btnEj1.setFocusPainted(false);
        btnEj1.setFont(new Font("Consolas", Font.PLAIN, 12));
        btnEj1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEj1.setMaximumSize(new Dimension(200, 30));
        panelBotones.add(btnEj1);
        panelBotones.add(Box.createVerticalStrut(10)); // espacio
        
        // Botón 2
        JButton btnEj2 = new JButton("Operaciones Vectoriales");
        btnEj2.setFocusPainted(false);
        btnEj2.setFont(new Font("Consolas", Font.PLAIN, 12));
        btnEj2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEj2.setMaximumSize(new Dimension(200, 30));
        panelBotones.add(btnEj2);
        panelBotones.add(Box.createVerticalStrut(10));

        // Botón 3
        JButton btnEj3 = new JButton("Operaciones Matriciales");
        btnEj3.setFocusPainted(false);
        btnEj3.setFont(new Font("Consolas", Font.PLAIN, 12));
        btnEj3.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEj3.setMaximumSize(new Dimension(200, 30));
        panelBotones.add(btnEj3);
        panelBotones.add(Box.createVerticalStrut(10));

        // Botón 4
        JButton btnEj4 = new JButton("Ecuaciones de 2X2 y 3X3");
        btnEj4.setFocusPainted(false);
        btnEj4.setFont(new Font("Consolas", Font.PLAIN, 12));
        btnEj4.setAlignmentX(Component.CENTER_ALIGNMENT);	
        btnEj4.setMaximumSize(new Dimension(200, 30));
        panelBotones.add(btnEj4);

        // Agregar botones al centro
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        
        OperacionesBasicas operacionesBasicas = new OperacionesBasicas(cardLayout, contenedorDeCartas, panelBotones, titulo);
        Vectores vectores = new Vectores(cardLayout, contenedorDeCartas, panelBotones, titulo);
        Matrices matrices = new Matrices(cardLayout, contenedorDeCartas, panelBotones, titulo);
        Ecuaciones ecuaciones = new Ecuaciones(cardLayout, contenedorDeCartas, panelBotones, titulo);
        
        contenedorDeCartas.add(operacionesBasicas, "operacionesBasicas");
        contenedorDeCartas.add(vectores, "vectores");
        contenedorDeCartas.add(matrices, "matrices");
        contenedorDeCartas.add(ecuaciones, "ecuaciones");
        
        
        
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setOpaque(false);

        panelCentral.add(panelBotones, BorderLayout.NORTH);
        panelCentral.add(contenedorDeCartas, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);
        
        contenedorDeCartas.setVisible(false);


        
        
		
        btnEj1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	contenedorDeCartas.setVisible(true);
                cardLayout.show(contenedorDeCartas, "operacionesBasicas");
                panelBotones.setVisible(false);
                titulo.setVisible(false);
            }
        });

        btnEj2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	contenedorDeCartas.setVisible(true);
                cardLayout.show(contenedorDeCartas, "vectores");
                panelBotones.setVisible(false);
                titulo.setVisible(false);            
            }
        });

        btnEj3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	contenedorDeCartas.setVisible(true);
                cardLayout.show(contenedorDeCartas, "matrices");
                panelBotones.setVisible(false);
                titulo.setVisible(false);
            }
        });

        btnEj4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	contenedorDeCartas.setVisible(true);
                cardLayout.show(contenedorDeCartas, "ecuaciones");
                panelBotones.setVisible(false);
                titulo.setVisible(false);
            }
        });

		
		
    }
}
