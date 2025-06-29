package GUI.Vectores.Operaciones;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import GUI.Respuestas;
import net.miginfocom.swing.MigLayout;

public class panelProductoEscalar extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel panelContenido;
    private JTextField tamanioInput;
    private JPanel panelVectores;
    private JTextField[] camposVector1;
    private JTextField[] camposVector2;
    private JTextField resultadoCampo;
    private double ansBasico;
    
    public panelProductoEscalar(CardLayout cardLayout, JPanel contenedorDeCartas) {
    	
    	setLayout(new BorderLayout());
		setBackground(new Color(210, 210, 210));
	    
		 panelContenido = new JPanel(new MigLayout("", "[grow]", "[][][][][]"));
		 panelContenido.setOpaque(false);

        JLabel lblProductoEscalar = new JLabel("Producto Escalar");
        lblProductoEscalar.setFont(new Font("Tahoma", Font.BOLD, 14));
        panelContenido.add(lblProductoEscalar, "cell 0 0,alignx center,aligny center");

        JLabel lblDescripcion = new JLabel("Ingrese el tamaño de los vectores:");
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panelContenido.add(lblDescripcion, "cell 0 1,alignx center");

        tamanioInput = new JTextField();
        tamanioInput.setColumns(10);
        panelContenido.add(tamanioInput, "cell 0 2,alignx center");

        tamanioInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tamanio = Integer.parseInt(tamanioInput.getText());
                if (tamanio < 1 || tamanio > 8) {
                    JOptionPane.showMessageDialog(null, "El tamaño debe ser un número entre 1 y 8.");
                } else {
                    imprimirVectores(tamanio);
                }
            }
        });
        
        
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    panelInferior.setOpaque(false);       
        
	    JButton btnVolver = new JButton("Volver al Menú de Vectores");
	    btnVolver.addActionListener(e -> cardLayout.show(contenedorDeCartas, "vectores"));
	    panelInferior.add(btnVolver);
        
        
	    
	    add(panelContenido, BorderLayout.CENTER);
	    add(panelInferior, BorderLayout.SOUTH);
        
    }

    public JPanel imprimirVectores(int N) {
        if (panelVectores != null) {
            remove(panelVectores);
        }

        panelVectores = new JPanel();
        panelVectores.setLayout(new BoxLayout(panelVectores, BoxLayout.Y_AXIS));

        camposVector1 = new JTextField[N];
        camposVector2 = new JTextField[N];

        // Vector 1
        JPanel row1 = new JPanel(new GridLayout(1, N + 1, 5, 0));
        JLabel labelV1 = new JLabel("Vector A");
        labelV1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        row1.add(labelV1);
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
        JLabel labelV2 = new JLabel("Vector B");
        labelV2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        row2.add(labelV2);
        for (int i = 0; i < N; i++) {
            camposVector2[i] = new JTextField();
            camposVector2[i].setPreferredSize(new Dimension(50, 30));
            camposVector2[i].setHorizontalAlignment(JTextField.CENTER);
            camposVector2[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            row2.add(camposVector2[i]);
        }
        panelVectores.add(row2);

        panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón calcular
        JButton btnProducto = new JButton("Calcular Producto Escalar");
        JPanel botonPanel = new JPanel();
        botonPanel.add(btnProducto);
        panelVectores.add(botonPanel);

        panelVectores.add(Box.createRigidArea(new Dimension(0, 10)));

        // Resultado
        JPanel resultadoPanel = new JPanel();
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 12));
        resultadoCampo = new JTextField(10);
        resultadoCampo.setEditable(false);
        resultadoCampo.setHorizontalAlignment(JTextField.CENTER);
        resultadoPanel.add(lblResultado);
        resultadoPanel.add(resultadoCampo);
        panelVectores.add(resultadoPanel);
        
        btnProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ansBasico = calcularProductoEscalar(camposVector1, camposVector2);
                resultadoCampo.setText("" + ansBasico);
                Respuestas.guardarRespuestas(2, ansBasico, null, null);
            }
        });
        
        panelContenido.add(panelVectores, "cell 0 5, alignx center");
        revalidate();
        repaint();

        return panelVectores;
    }

    public static double calcularProductoEscalar(JTextField[] v1, JTextField[] v2) {
        double resultado = 0;
        for (int i = 0; i < v1.length; i++) {
            double a = Double.parseDouble(v1[i].getText());
            double b = Double.parseDouble(v2[i].getText());
            resultado += a * b;
        }
        return resultado;
    }
}
