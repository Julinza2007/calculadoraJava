package GUI.Vectores.Operaciones;

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

import net.miginfocom.swing.MigLayout;

public class panelMultiPorEscalar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tamanioInput;
	private JTextField escalarInput;
	private JPanel panelVectores;
	private JTextField[] camposVector;
	private JTextField[] camposResultado;


	/**
	 * Create the panel.
	 */
	public panelMultiPorEscalar() {
		setLayout(new MigLayout("", "[grow]", "[][][][][]"));
	    setBackground(new Color(255, 255, 255));

	    JLabel lblMultiplicacionEscalar = new JLabel("Multiplicación por Escalar");
	    lblMultiplicacionEscalar.setFont(new Font("Tahoma", Font.BOLD, 14));
	    add(lblMultiplicacionEscalar, "cell 0 0,alignx center,aligny center");

	    JLabel lblTamanio = new JLabel("Ingrese el tamaño del vector: ");
	    lblTamanio.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    add(lblTamanio, "cell 0 1,alignx left,aligny center");
	    
	    JLabel lblEscalar = new JLabel("Ingrese el escalar: ");
	    lblEscalar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    add(lblEscalar, "cell 0 2,alignx left,aligny center");
	    
	    tamanioInput = new JTextField();
	    tamanioInput.setColumns(10);
	    add(tamanioInput, "cell 0 1,alignx right");
	    
	    
	    tamanioInput.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String entradaTexto = tamanioInput.getText();
	    		int tamanio = Integer.parseInt(entradaTexto);
	    		if(tamanio < 1 || tamanio > 8) {
	    			JOptionPane.showMessageDialog(null, "El tamaño debe ser un número entre 1 y 8.");
	    		}
	    		else {
//	    			imprimirVectores(tamanio);	    		    			
	    		}
	    	}
	    });
	    
	    
	    
	    
	    
	}
	
	public JPanel imprimirVectores(int N, double escalar) {
		if (panelVectores != null) {
	        remove(panelVectores);
	    }

	    panelVectores = new JPanel();
	    panelVectores.setLayout(new BoxLayout(panelVectores, BoxLayout.Y_AXIS));

	    camposVector = new JTextField[N];
//	    escalar = new JTextField[N];
	    camposResultado = new JTextField[N];
	    
	    // First row: Label + Vector 1
	    JPanel row1 = new JPanel(new GridLayout(1, N + 1, 5, 0));
	    JLabel labelVector1 = new JLabel("Vector 1");
	    labelVector1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    row1.add(labelVector1);
	    for (int i = 0; i < N; i++) {
	    	camposVector[i] = new JTextField();
	        camposVector[i].setPreferredSize(new Dimension(50, 30));
	        camposVector[i].setHorizontalAlignment(JTextField.CENTER);
	        camposVector[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        row1.add(camposVector[i]);
	    }
	    panelVectores.add(row1);

	    // Add vertical space
	    panelVectores.add(Box.createRigidArea(new Dimension(0, 15)));

	    // Second row: Label + Vector 2
//	    JPanel row2 = new JPanel(new GridLayout(1, N + 1, 5, 0));
//	    JLabel labelVector2 = new JLabel("Vector 2");
//	    labelVector2.setFont(new Font("Tahoma", Font.PLAIN, 12));
//	    row2.add(labelVector2);
//	    for (int i = 0; i < N; i++) {
//	    	camposVector2[i] = new JTextField();
//	        camposVector2[i].setPreferredSize(new Dimension(50, 30));
//	        camposVector2[i].setHorizontalAlignment(JTextField.CENTER);
//	        camposVector2[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
//	        row2.add(camposVector2[i]);
//	    }
//	    panelVectores.add(row2);

	    panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

	    // Botón Sumar
	    JButton btnMulti = new javax.swing.JButton("Multiplicar por Escalar");
	    panelVectores.add(btnMulti);
	    
	    panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

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
	    


	    // Acción del botón
	    btnMulti.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
//	            int total = multiPorEscalar(camposVector, escalar, camposResultado);
	        }
	    });

	    add(panelVectores, "cell 0 2, alignx center");
	    revalidate();
	    repaint();

	    return panelVectores;		
	}
	
//	public static void multiPorEscalar(JTextField[] camposVector, JTextField[] escalar, JTextField[] camposResultado) {
//		try {
//			for (int i = 0; i < camposVector.length; i++) {
//				String valorVector = camposVector[i].getText();
//				String valorEscalar = escalar[i].getText();
//				
//				if (valorVector.isEmpty() || valorEscalar.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
//					return;
//				}
//				
//				double vectorValue = Double.parseDouble(valorVector);
//				double escalarValue = Double.parseDouble(valorEscalar);
//				
//				double resultado = vectorValue * escalarValue;
//				camposResultado[i].setText(String.valueOf(resultado));
//			}
//		} catch (NumberFormatException e) {
//			JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos.");
//		}


}