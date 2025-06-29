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
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.Ans;
import GUI.Respuestas;
import net.miginfocom.swing.MigLayout;

public class panelProductoVectorial extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel panelVectores;
    private JTextField[] camposVector1;
    private JTextField[] camposVector2;
    private JTextField[] camposResultado;
    private double[] ansVector;
    

    public panelProductoVectorial(CardLayout cardLayout, JPanel contenedorDeCartas) {
    	
        setLayout(new MigLayout("", "[grow]", "[][][][][]"));
        setBackground(new Color(255, 255, 255));

        JLabel lblProductoVectorial = new JLabel("Producto Vectorial");
        lblProductoVectorial.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblProductoVectorial, "cell 0 0,alignx center,aligny center");

        JLabel lblDescripcion = new JLabel("Ingrese los valores de los vectores (de 3 espacios):");
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lblDescripcion, "cell 0 1,alignx center,aligny center");

        imprimirVectores();
        
        JButton btnVolver = new JButton("Volver al Menú de Vectores");
	    btnVolver.addActionListener(e -> cardLayout.show(contenedorDeCartas, "vectores"));
	    add(btnVolver, "cell 0 4,alignx left");
        
        
    }

    public JPanel imprimirVectores() {
        if (panelVectores != null) {
            remove(panelVectores);
        }

        int N = 3; // siempre va a ser de tamaño 3 el producto vectorial

        panelVectores = new JPanel();
        panelVectores.setLayout(new BoxLayout(panelVectores, BoxLayout.Y_AXIS));

        camposVector1 = new JTextField[N];
        camposVector2 = new JTextField[N];
        camposResultado = new JTextField[N];

        // Vector 1
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
        panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

        // Vector 2
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
        panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón
        JButton btnCalcular = new JButton("Calcular Producto Vectorial");
        panelVectores.add(btnCalcular);
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
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ansVector = productoVectorial(camposVector1, camposVector2);
                for (int i = 0; i < ansVector.length; i++) {
                    camposResultado[i].setText("" + ansVector[i]);
                }
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
        
        

        add(panelVectores, "cell 0 3, alignx center");
        revalidate();
        repaint();

        return panelVectores;
    }

    public static double[] productoVectorial(JTextField[] vector1, JTextField[] vector2) {
        double[] resultado = new double[3];

        double a1 = Double.parseDouble(vector1[0].getText());
        double a2 = Double.parseDouble(vector1[1].getText());
        double a3 = Double.parseDouble(vector1[2].getText());

        double b1 = Double.parseDouble(vector2[0].getText());
        double b2 = Double.parseDouble(vector2[1].getText());
        double b3 = Double.parseDouble(vector2[2].getText());

        resultado[0] = a2 * b3 - a3 * b2;
        resultado[1] = a3 * b1 - a1 * b3;
        resultado[2] = a1 * b2 - a2 * b1;

        return resultado;
    }
}
