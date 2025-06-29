package GUI.Vectores.Operaciones;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.Ans;
import GUI.Respuestas;
import net.miginfocom.swing.MigLayout;

public class panelResta extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField tamanioInput;
	private JPanel panelVectores;
	private JTextField[] camposVector1;
	private JTextField[] camposVector2;
	private JTextField[] camposResultado;
	private double[] ansVector;
	
	/**
	 * Create the panel.
	 */
	public panelResta(CardLayout cardLayout, JPanel contenedorDeCartas) {
		
			setLayout(new MigLayout("", "[grow]", "[][][][][]"));
		    setBackground(new Color(255, 255, 255));

		    JLabel lblResta = new JLabel("Resta de Vectores");
		    lblResta.setFont(new Font("Tahoma", Font.BOLD, 14));
		    add(lblResta, "cell 0 0,alignx center,aligny center");

		    JLabel lblResta1 = new JLabel("Ingrese el tamaño de los vectores a restar:");
		    lblResta1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    add(lblResta1, "cell 0 1,alignx center,aligny center");

		    
		    tamanioInput = new JTextField();
		    tamanioInput.setColumns(10);
		    add(tamanioInput, "cell 0 1");
		    
		    tamanioInput.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String entradaTexto = tamanioInput.getText();
		    		int tamanio = Integer.parseInt(entradaTexto);
		    		if(tamanio < 1 || tamanio > 8) {
		    			JOptionPane.showMessageDialog(null, "El tamaño debe ser un número entre 1 y 8.");
		    		}
		    		else {
		    			imprimirVectores(tamanio);	    		    			
		    		}
		    	}
		    });
		    
		    JButton btnVolver = new JButton("Volver al Menú de Vectores");
		    btnVolver.addActionListener(e -> cardLayout.show(contenedorDeCartas, "vectores"));
		    add(btnVolver, "cell 0 4,alignx left");
		    
		    
		    
		}
	
	
	
	
	
	public JPanel imprimirVectores(int N) {
	    if (panelVectores != null) {
	        remove(panelVectores);
	    }

	    panelVectores = new JPanel();
	    panelVectores.setLayout(new BoxLayout(panelVectores, BoxLayout.Y_AXIS));

	    camposVector1 = new JTextField[N];
	    camposVector2 = new JTextField[N];
	    camposResultado = new JTextField[N];
	    
	    // First row: Label + Vector 1
	    JPanel row1 = new JPanel(new GridLayout(1, N + 1, 5, 0));
	    JLabel labelVector1 = new JLabel("Vector 1");
	    labelVector1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    row1.add(labelVector1);
	    for (int i = 0; i < N; i++) {
	    	camposVector1[i] = new JTextField();
	        camposVector1[i].setPreferredSize(new Dimension(50, 30));
	        camposVector1[i].setHorizontalAlignment(JTextField.CENTER);
	        camposVector1[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        row1.add(camposVector1[i]);
	    }
	    panelVectores.add(row1);

	    // Add vertical space
	    panelVectores.add(Box.createRigidArea(new Dimension(0, 15)));

	    // Second row: Label + Vector 2
	    JPanel row2 = new JPanel(new GridLayout(1, N + 1, 5, 0));
	    JLabel labelVector2 = new JLabel("Vector 2");
	    labelVector2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    row2.add(labelVector2);
	    for (int i = 0; i < N; i++) {
	    	camposVector2[i] = new JTextField();
	        camposVector2[i].setPreferredSize(new Dimension(50, 30));
	        camposVector2[i].setHorizontalAlignment(JTextField.CENTER);
	        camposVector2[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        row2.add(camposVector2[i]);
	    }
	    panelVectores.add(row2);

	    panelVectores.add(Box.createRigidArea(new Dimension(0, 15)));

	    // Botón adadasda
	    JButton btnRestar = new javax.swing.JButton("Restar");
	    panelVectores.add(btnRestar);
	    
	    panelVectores.add(Box.createRigidArea(new Dimension(0, 15)));

	    // Fila Resultado
	    JPanel rowResultado = new JPanel(new GridLayout(1, N + 1, 5, 0));
	    JLabel labelResultado = new JLabel("Resultado");
	    labelResultado.setFont(new Font("Tahoma", Font.BOLD, 12));
	    rowResultado.add(labelResultado);
	    for (int i = 0; i < N; i++) {
	        camposResultado[i] = new JTextField();
	        camposResultado[i].setPreferredSize(new Dimension(50, 30));
	        camposResultado[i].setHorizontalAlignment(JTextField.CENTER);
	        camposResultado[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        camposResultado[i].setEditable(false);
	        rowResultado.add(camposResultado[i]);
	    }
	    panelVectores.add(rowResultado);
	    
	    
	    Ans btnAns = new Ans();
	    if(Respuestas.obtenerVector() != null) {
	    	btnAns.setEnabled(true);
	    }
	    else {
	    	btnAns.setEnabled(false);
	    }

	    // Acción del botón
	    btnRestar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            ansVector = resta(camposVector1, camposVector2, camposResultado);
	            Respuestas.guardarRespuestas(2, 0, ansVector, null);
		    	btnAns.setEnabled(true);
	        }
	    });
	    
	    btnAns.addActionListener(e -> {
	        double[] ans = Respuestas.obtenerVector();
	        if (ans != null && ans.length == camposVector1.length) {
	            for (int i = 0; i < ans.length; i++) {
	                camposVector1[i].setText("" + ans[i]);
	            }
	        }
	    });
	    
	    
	    panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

	    panelVectores.add(btnAns);
	    

	    add(panelVectores, "cell 0 2, alignx center");
	    revalidate();
	    repaint();

	    return panelVectores;
	}
	
	public static double[] resta(JTextField[] vector1, JTextField[] vector2, JTextField[] resultado) {
	    double[] restaVector = new double[vector1.length];
	    for (int i = 0; i < vector1.length; i++) {
	        String texto1 = vector1[i].getText().replace(',', '.');
	        String texto2 = vector2[i].getText().replace(',', '.');
	        if (!texto1.matches("-?\\d*(\\.\\d+)?") || !texto2.matches("-?\\d*(\\.\\d+)?")) {
	            resultado[i].setText("Err");
	            restaVector[i] = Double.NaN;
	        } else {
	            double v1 = Double.parseDouble(texto1);
	            double v2 = Double.parseDouble(texto2);
	            double resta = v1 - v2;
	            resultado[i].setText("" + resta);
	            restaVector[i] = resta;
	        }
	    }
	    return restaVector;
	}
	
}
