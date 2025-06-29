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

public class panelMultiPorEscalar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tamanioInput;
	private JPanel panelVectores;
	private JTextField[] camposVector;
	private JTextField[] camposResultado;
	private double[] ansVector;
	
	
	public panelMultiPorEscalar(CardLayout cardLayout, JPanel contenedorDeCartas) {
		
		setLayout(new MigLayout("", "[grow]", "[][][][][][]"));
	    setBackground(new Color(255, 255, 255));

	    JLabel lblMultiplicacionEscalar = new JLabel("Multiplicación por Escalar");
	    lblMultiplicacionEscalar.setFont(new Font("Tahoma", Font.BOLD, 14));
	    add(lblMultiplicacionEscalar, "cell 0 0,alignx center,aligny center");

	    JLabel lblTamanio = new JLabel("Ingrese el tamaño del vector: ");
	    lblTamanio.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    add(lblTamanio, "cell 0 1,alignx left,aligny center");

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
	    			imprimirVector(tamanio);  		    			
	    		}
	    	}
	    });
	    
	    
	    JButton btnVolver = new JButton("Volver al Menú de Vectores");
	    btnVolver.addActionListener(e -> cardLayout.show(contenedorDeCartas, "vectores"));
	    add(btnVolver, "cell 0 4,alignx left");
	    
	    
	}

	public JPanel imprimirVector(int N) {
		if (panelVectores != null) {
	        remove(panelVectores);
	    }

	    panelVectores = new JPanel();
	    panelVectores.setLayout(new BoxLayout(panelVectores, BoxLayout.Y_AXIS));

	    camposVector = new JTextField[N];
	    camposResultado = new JTextField[N];

	    // Vector input
	    JPanel row = new JPanel(new GridLayout(1, N + 1, 5, 0));
	    JLabel labelVector1 = new JLabel("Vector");
	    labelVector1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    row.add(labelVector1);
	    for (int i = 0; i < N; i++) {
	    	camposVector[i] = new JTextField();
	        camposVector[i].setPreferredSize(new Dimension(50, 30));
	        camposVector[i].setHorizontalAlignment(JTextField.CENTER);
	        camposVector[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        row.add(camposVector[i]);
	    }
	    panelVectores.add(row);
	    panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

	    // Escalar input
	    JPanel escalarPanel = new JPanel();
	    JLabel lblEscalar = new JLabel("Ingrese el escalar:");
	    lblEscalar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    escalarPanel.add(lblEscalar);
	    JTextField escalarInput = new JTextField(10);
	    escalarPanel.add(escalarInput);
	    panelVectores.add(escalarPanel);

	    panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

	    // Botón 
	    JButton btnMulti = new JButton("Multiplicar por Escalar");
	    panelVectores.add(btnMulti);

	    panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

	    // Resultado
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
	    btnMulti.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	double escalar = Double.parseDouble(escalarInput.getText());
	        	ansVector = multiPorEscalar(camposVector, escalar, camposResultado);
	            Respuestas.guardarRespuestas(2, 0, ansVector, null);
		    	btnAns.setEnabled(true);
	        }
	    });
	    
	    btnAns.addActionListener(e -> {
	        double[] ans = Respuestas.obtenerVector();
	        if (ans != null && ans.length == camposVector.length) {
	            for (int i = 0; i < ans.length; i++) {
	                camposVector[i].setText("" + ans[i]);
	            }
	        }
	    });
	    
	    
	    panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

	    panelVectores.add(btnAns);
	    
	    

	    add(panelVectores, "cell 0 5, alignx center");
	    revalidate();
	    repaint();

	    return panelVectores;
	}

	public static double[] multiPorEscalar(JTextField[] camposVector, double escalar, JTextField[] camposResultado) {
		double[] resultado = new double[camposVector.length];
		for (int i = 0; i < camposVector.length; i++) {
			double valor = Double.parseDouble(camposVector[i].getText());
			resultado[i] = valor * escalar;
			camposResultado[i].setText(String.valueOf(resultado[i]));
		}
		return resultado;
	}
}
