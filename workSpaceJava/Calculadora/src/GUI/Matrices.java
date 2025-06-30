package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class Matrices extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private java.util.List<JTextField> camposMatriz1 = new java.util.ArrayList<>();
	private java.util.List<JTextField> camposMatriz2 = new java.util.ArrayList<>();
	private JTextField escalar;
	private double[][] ansMatriz = null;
	

	/**
	 * Create the panel.
	 */
	public Matrices(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {
		
		setLayout(new BorderLayout());
		
		JPanel centroLibre = new JPanel(null);

        JLabel tituloMatriz = new JLabel("MATRICES", SwingConstants.CENTER);
        tituloMatriz.setBounds(165, 1, 120, 40);
        centroLibre.add(tituloMatriz);

        
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
        panelFilas1.setBounds(366, 52, 122, 52);     
        centroLibre.add(panelFilas1);
        
        JLabel lblMatriz1 = new JLabel("MATRIZ 1");
        lblMatriz1.setHorizontalAlignment(SwingConstants.CENTER);
        lblMatriz1.setBounds(366, 27, 122, 14);
        centroLibre.add(lblMatriz1);
        
        JPanel panelFilas2 = new JPanel ();
        JComboBox<Integer> comboFilas2 = new JComboBox<>(new Integer[] {1, 2, 3, 4});
        JComboBox<Integer> comboColumn2 = new JComboBox<>(new Integer[] {1, 2, 3, 4});
   
        panelFilas2.setBorder(BorderFactory.createTitledBorder("filas - columnas"));
        panelFilas2.add(comboFilas2);
        panelFilas2.add(comboColumn2);
        panelFilas2.setBounds(366, 146, 122, 52);     
        centroLibre.add(panelFilas2);
        
        JLabel lblMatriz2 = new JLabel("MATRIZ 2");
        lblMatriz2.setHorizontalAlignment(SwingConstants.CENTER);
        lblMatriz2.setBounds(366, 121, 122, 14);
        centroLibre.add(lblMatriz2);
        
        JPanel panelMatriz1 = new JPanel();
        panelMatriz1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panelMatriz1.setBounds(10, 70, 322, 180);
        centroLibre.add(panelMatriz1);
        
        JPanel panelMatriz2 = new JPanel();
        panelMatriz2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panelMatriz2.setBounds(10, 302, 322, 180);
        centroLibre.add(panelMatriz2);
        
        JPanel panelResultado = new JPanel();
        panelResultado.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panelResultado.setBounds(366, 302, 322, 180);
        centroLibre.add(panelResultado);
        
        panelResultado.setVisible(false);
        panelMatriz1.setVisible(false);
        panelMatriz2.setVisible(false);
        

        
        JButton btncrear = new JButton("GENERAR MATRIZ");
        btncrear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		camposMatriz1.clear();
        		camposMatriz2.clear();
        		
        		panelMatriz1.setVisible(true);
                panelMatriz2.setVisible(true);
        		int filas1 = (Integer) comboFilas1.getSelectedItem();
                int columnas1 = (Integer) comboColumn1.getSelectedItem();
        		panelMatriz1.removeAll();
        		panelMatriz1.setLayout(new GridLayout(filas1, columnas1, 5, 5 ));
        		
        		
        		int filas2 = (Integer) comboFilas2.getSelectedItem();
                int columnas2 = (Integer) comboColumn2.getSelectedItem();
        		panelMatriz2.removeAll();
        		panelMatriz2.setLayout(new GridLayout(filas2, columnas2, 5, 5 ));
        		
        		for (int i=0 ; i < filas1 * columnas1; i++) {
        			JPanel casillero = new JPanel ();
        			casillero.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        			JTextField campo = new JTextField();
        			campo.setPreferredSize(new Dimension(65, 25));
        			camposMatriz1.add(campo); 
        			campo.setMargin(new Insets(3, 5, 3, 5));
        			casillero.setBackground(new Color(245, 245, 245));
        			campo.setBackground(Color.WHITE);
        			casillero.setLayout(new FlowLayout(FlowLayout.CENTER));
        			casillero.add(campo);
        			panelMatriz1.add(casillero);
        		}
        		
                
        		
        		for (int i=0 ; i < filas2 * columnas2; i++) {
        			JPanel casillero = new JPanel ();
        			casillero.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        			JTextField campo = new JTextField();
        			campo.setPreferredSize(new Dimension(65, 25));
        			camposMatriz2.add(campo);
        			campo.setMargin(new Insets(3, 5, 3, 5));
        			casillero.setBackground(new Color(245, 245, 245));
        			campo.setBackground(Color.WHITE);
        			casillero.setLayout(new FlowLayout(FlowLayout.CENTER));
        			casillero.add(campo);
        			panelMatriz2.add(casillero);
        		}
        		
        		panelMatriz1.revalidate();
        		panelMatriz1.repaint();
        		
        		panelMatriz2.revalidate();
        		panelMatriz2.repaint();
        	}
        });
        btncrear.setBounds(366, 203, 122, 23);
        centroLibre.add(btncrear);
        
        JLabel valorMatriz1 = new JLabel("INGRESE LA MATRIZ 1");
        valorMatriz1.setHorizontalAlignment(SwingConstants.CENTER);
        valorMatriz1.setBounds(92, 45, 149, 14);
        centroLibre.add(valorMatriz1);
        
        JLabel valorMatriz2 = new JLabel("INGRESE LA MATRIZ 2");
        valorMatriz2.setHorizontalAlignment(SwingConstants.CENTER);
        valorMatriz2.setBounds(92, 277, 149, 14);
        centroLibre.add(valorMatriz2);
        
        JLabel lblResultado = new JLabel("RESULTADO");
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setBounds(469, 277, 122, 14);
        centroLibre.add(lblResultado);
        
        JButton btnSuma = new JButton("SUMA");
        btnSuma.setForeground(new Color(0, 0, 0));
        btnSuma.setBounds(498, 10, 93, 23);
        centroLibre.add(btnSuma);
        btnSuma.setBorder(new LineBorder(new Color(0, 204, 153), 2, true));
         
        
        
        JButton btnAns = new JButton("ANS");
        btnAns.setVisible(true);
        
        btnAns.setBackground(new Color(255, 128, 0));
        btnAns.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (ansMatriz != null) {
        			int filas = Integer.parseInt(comboFilas1.getSelectedItem().toString());
    				int columnas = Integer.parseInt(comboColumn1.getSelectedItem().toString());
        			llenarMatrizDesdeArray(ansMatriz, camposMatriz1, filas, columnas);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "No hay resultado guardado aún.");
        		}
        	}
        });
        btnAns.setBounds(630, 273, 58, 23);
        centroLibre.add(btnAns);
        
        
        JButton btnResta = new JButton("RESTA");
        btnResta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int filas = Integer.parseInt(comboFilas1.getSelectedItem().toString());
				int columnas = Integer.parseInt(comboColumn1.getSelectedItem().toString());
				ansMatriz = new double[filas][columnas];
				
        		if (filas == (Integer)comboFilas2.getSelectedItem() && columnas == (Integer)comboColumn2.getSelectedItem()) {
        				panelResultado.removeAll();
        				panelResultado.setLayout(new GridLayout(filas, columnas, 5, 5));
        				panelResultado.setVisible(true);
        				int i, j;
//                		int[][] num1 = new int[n][m];
//               		int[][] num2 = new int[n][m];
//                		int[][] resultado = new int[n][m];
                		
                		for(i=0; i < filas; i++){
                			for(j=0; j < columnas; j++){
                				int index = i * columnas + j;
                				double num1 = Double.parseDouble(camposMatriz1.get(index).getText());  
                				double num2 = Double.parseDouble(camposMatriz1.get(index).getText());  
                				double resta = num1 - num2;
                				
                				ansMatriz[i][j] = resta;
                				
                				JTextField campoResultado = new JTextField(String.valueOf(resta));
                				campoResultado.setEditable(false);
                				campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
                				campoResultado.setBackground(new Color(224, 255, 224));
                				panelResultado.add(campoResultado);
                			}
                		}
                		panelResultado.revalidate();
                        panelResultado.repaint();
                		
        			
        		}
        	}
        	
        });
        btnResta.setForeground(Color.BLACK);
        btnResta.setBorder(new LineBorder(new Color(0, 204, 153), 2, true));
        btnResta.setBounds(605, 10, 93, 23);
        centroLibre.add(btnResta);
        
        
                
        
        btnSuma.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int filas = Integer.parseInt(comboFilas1.getSelectedItem().toString());
				int columnas = Integer.parseInt(comboColumn1.getSelectedItem().toString());
				ansMatriz = new double[filas][columnas];
				
        		if (filas == (Integer)comboFilas2.getSelectedItem() && columnas == (Integer)comboColumn2.getSelectedItem()) {
        				panelResultado.removeAll();
        				panelResultado.setLayout(new GridLayout(filas, columnas, 5, 5));
        				panelResultado.setVisible(true);
        				int i, j;
//                		int[][] num1 = new int[n][m];
//               		int[][] num2 = new int[n][m];
//                		int[][] resultado = new int[n][m];
                		
                		for(i=0; i < filas; i++){
                			for(j=0; j < columnas; j++){
                				int index = i * columnas + j;
                				double num1 = Double.parseDouble(camposMatriz1.get(index).getText());  
                				double num2 = Double.parseDouble(camposMatriz1.get(index).getText());  
                				double suma = num1 + num2;
                				
                				ansMatriz[i][j] = suma;
                				
                				JTextField campoResultado = new JTextField(String.valueOf(suma));
                				campoResultado.setEditable(false);
                				campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
                				campoResultado.setBackground(new Color(224, 255, 224));
                				panelResultado.add(campoResultado);
                			}
                		}
                		panelResultado.revalidate();
                        panelResultado.repaint();
        			
        		}
        	}
        });
        
        
        
        escalar = new JTextField();
        escalar.setToolTipText("");
        escalar.setBounds(605, 49, 58, 20);
        centroLibre.add(escalar);
        escalar.setColumns(10);
        
        escalar.setText("escalar");
        escalar.setForeground(Color.GRAY);
        
        escalar.addFocusListener(new java.awt.event.FocusAdapter(){
        	public void focusGained(java.awt.event.FocusEvent e) {
        		if (escalar.getText().equals("escalar")) {
        			escalar.setText("");
        			escalar.setForeground(Color.BLACK);
        		}
        	}
        	
        	public void focusLost(java.awt.event.FocusEvent e) {
        		if (escalar.getText().trim().isEmpty()) {
        			escalar.setText("escalar");
        			escalar.setForeground(Color.GRAY);
        		}
        	}
        });
        
        JButton btnMultEsc = new JButton("MULT_ESCALAR");
        btnMultEsc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int filas = Integer.parseInt(comboFilas1.getSelectedItem().toString());
				int columnas = Integer.parseInt(comboColumn1.getSelectedItem().toString());	
				ansMatriz = new double[filas][columnas];
        				panelResultado.removeAll();
        				panelResultado.setLayout(new GridLayout(filas, columnas, 5, 5));
        				panelResultado.setVisible(true);
        				int num_escalar = 0;
        				if(!escalar.getText().trim().isEmpty()) {
        					num_escalar = Integer.parseInt(escalar.getText());
        				}
        				else {
        					JOptionPane.showMessageDialog(null, "ingrese un valor correcto para el escalar");
        				}
        				int i, j;
//                		int[][] num1 = new int[n][m];
//               		int[][] num2 = new int[n][m];
//                		int[][] resultado = new int[n][m];
                		
                		for(i=0; i < filas; i++){
                			for(j=0; j < columnas; j++){
                				int index = i * columnas + j;
                				double num1 = Double.parseDouble(camposMatriz1.get(index).getText());    
                				double mul_escalar = num1 * num_escalar;
                				
                				ansMatriz[i][j] = mul_escalar;
                				
                				JTextField campoResultado = new JTextField(String.valueOf(mul_escalar));
                				campoResultado.setEditable(false);
                				campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
                				campoResultado.setBackground(new Color(224, 255, 224));
                				panelResultado.add(campoResultado);
                			}
                		}
                		panelResultado.revalidate();
                        panelResultado.repaint();                		        			        		
        	}
        });
        btnMultEsc.setForeground(Color.BLACK);
        btnMultEsc.setBorder(new LineBorder(new Color(0, 204, 153), 2, true));
        btnMultEsc.setBounds(498, 48, 93, 23);
        centroLibre.add(btnMultEsc);
        
	        JButton btnMultiplicar = new JButton("MULTIPLICAR");
	        btnMultiplicar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int filas1 = Integer.parseInt(comboFilas1.getSelectedItem().toString());
					int columnas1 = Integer.parseInt(comboColumn1.getSelectedItem().toString());
					int filas2 = Integer.parseInt(comboFilas2.getSelectedItem().toString());
					int columnas2 = Integer.parseInt(comboColumn2.getSelectedItem().toString());
					
					ansMatriz = new double[filas1][columnas2];
					
					double[][] num1 = new double[filas1][columnas1];
					double[][] num2 = new double[filas2][columnas2];
					
	        		if (columnas1 == filas2) {
	        				
	        			
	        				panelResultado.removeAll();
	        				panelResultado.setLayout(new GridLayout(filas1, columnas2, 5, 5));
	        				panelResultado.setVisible(true);
	        				int i, j;
	//                		int[][] num1 = new int[n][m];
	//               		int[][] num2 = new int[n][m];
	//                		int[][] resultado = new int[n][m];
	                		
	        				for(i=0; i < filas2; i++){
	        					for(j=0; j < columnas2; j++){
	        						int index2 = i * columnas2 + j;
	        						num2[i][j] = Double.parseDouble(camposMatriz1.get(index2).getText());    
	        					}
	        				}
	        				
	        				for(i=0; i < filas1; i++){
	        					for(j=0; j < columnas1; j++){
	        							int index1 = i * columnas1 + j;
	        							num1[i][j] = Double.parseDouble(camposMatriz1.get(index1).getText());            			
	                				
	                			}
	                		}
	        				
	        				double[][] resultado = multiplicar(num1, num2, columnas1, filas1, columnas2);
	        					
	        						
	        				for(i=0; i < filas1; i++){
	        					for(j=0; j < columnas2; j++){
	        						ansMatriz[i][j] = resultado[i][j];
	        						
	        						JTextField campoResultado = new JTextField(String.valueOf(resultado[i][j]));
	        						campoResultado.setEditable(false);
	        						campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
	        						campoResultado.setBackground(new Color(224, 255, 224));
	        						panelResultado.add(campoResultado);
            						panelResultado.revalidate();
            						panelResultado.repaint();
	        					}
	        				}
	        		}
	        		else {
	        			JOptionPane.showMessageDialog(null, "no se pudo realizar la multiplicació ya que la columna de la matriz 1 no es igual a la fila de la matriz 2");
	        		}
	        	}
	        });
	        btnMultiplicar.setForeground(Color.BLACK);
	        btnMultiplicar.setBorder(new LineBorder(new Color(0, 204, 153), 2, true));
	        btnMultiplicar.setBounds(498, 92, 93, 23);
	        centroLibre.add(btnMultiplicar);
	        
	        JButton btnDeterminante = new JButton("DETERMINANTE");
	        btnDeterminante.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int filas = Integer.parseInt(comboFilas1.getSelectedItem().toString());
					int columnas = Integer.parseInt(comboColumn1.getSelectedItem().toString());
					
					ansMatriz = new double[filas][columnas];
					
	        		if (columnas == filas) {
	        				panelResultado.removeAll();
	        				panelResultado.setLayout(new GridLayout(filas, columnas, 5, 5));
	        				panelResultado.setVisible(true);
	        				int i = 0, j = 0;
	//                		int[][] num1 = new int[n][m];
	//               		int[][] num2 = new int[n][m];
	//                		int[][] resultado = new int[n][m];
	        				
	        				int[][] matriz = new int[filas][columnas];
	        				int resultado = 0;
	        				int n = Integer.parseInt(comboFilas1.getSelectedItem().toString()); //o puede ser tambien con comboColumn, no cambia nada porque las filas y columnas son iguales
	        				for (i=0;i < filas;i++) {
        						for (j=0;j < columnas;j++) {
        							int index = i * columnas + j;
        							matriz[i][j] = Integer.parseInt(camposMatriz1.get(index).getText());
        						}
        					}
	        				resultado = determinante(matriz, n);
	        				
	        				ansMatriz[i][j] = resultado;
	        				
	        				JTextField campoResultado = new JTextField(String.valueOf(resultado));
	        				campoResultado.setEditable(false);
	        				campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
	        				campoResultado.setBackground(new Color(224, 255, 224));
	        				panelResultado.add(campoResultado);
	        					
	        				panelResultado.revalidate();
	        			    panelResultado.repaint();
	        				
	        		
	        		}
	        		
	        		
	        		
	        		else {
	        			JOptionPane.showMessageDialog(null, "no se pudo realizar la multiplicación ya que las columnas y filas de la primer matriz deben ser iguales");
	        		}
	        	}	
	        });
	        btnDeterminante.setForeground(Color.BLACK);
	        btnDeterminante.setBorder(new LineBorder(new Color(0, 204, 153), 2, true));
	        btnDeterminante.setBounds(498, 129, 93, 23);
	        centroLibre.add(btnDeterminante);
	        
	        JButton btnInversa = new JButton("INVERSA");
	        btnInversa.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panelResultado.setVisible(true);
	        		int filas = Integer.parseInt(comboFilas1.getSelectedItem().toString());
					int columnas = Integer.parseInt(comboColumn1.getSelectedItem().toString());
					
					ansMatriz = new double[filas][columnas];
					
					if (camposMatriz1.size() < filas * columnas) {
					    JOptionPane.showMessageDialog(null, "La matriz no tiene suficientes campos cargados.");
					    return;
					}
					
	        		if (columnas == filas) {
	        			int n = filas;
						double [][] matriz = new double[n][n];
						for (int i=0;i<n;i++) {
							for (int j=0;j<n;j++) {
								int index = i * n + j;
								matriz[i][j] = Double.parseDouble(camposMatriz1.get(index).getText());
							}
						}
	        				double[][] matInversa = inversa(matriz);

	        				panelResultado.removeAll();
	        				panelResultado.setLayout(new GridLayout(n, n, 5, 5));
	        				
	        				for(int i=0;i<n;i++) {
	        					for(int j=0;j<n;j++) {
	        							ansMatriz[i][j] = matInversa[i][j];
	        						
	        					    	JTextField campoResultado = new JTextField(String.valueOf(matInversa[i][j]));
	        					    	campoResultado.setEditable(false);
	        					    	campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
	        					    	campoResultado.setBackground(new Color(224, 255, 224));
	        					    	panelResultado.add(campoResultado);
	        					}
	        				}
	        					panelResultado.revalidate();
	        				    panelResultado.repaint();
	        			
	        		}
	        	}
	        });
	        btnInversa.setForeground(Color.BLACK);
	        btnInversa.setBorder(new LineBorder(new Color(0, 204, 153), 2, true));
	        btnInversa.setBounds(605, 92, 93, 23);
	        centroLibre.add(btnInversa);
	        
	        JButton btnDividir = new JButton("DIVIDIR");
	        btnDividir.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int filas1 = Integer.parseInt(comboFilas1.getSelectedItem().toString());
					int columnas1 = Integer.parseInt(comboColumn1.getSelectedItem().toString());
					int filas2 = Integer.parseInt(comboFilas2.getSelectedItem().toString());
					int columnas2 = Integer.parseInt(comboColumn2.getSelectedItem().toString());
					
					ansMatriz = new double[filas1][columnas2];
					
					double[][] num1 = new double[filas1][columnas1];
					double[][] num2 = new double[filas2][columnas2];
					
	        		if (columnas1 == filas2) {
	        				
	        			
	        				panelResultado.removeAll();
	        				panelResultado.setLayout(new GridLayout(filas1, columnas2, 5, 5));
	        				panelResultado.setVisible(true);
	        				int i, j;
	        				double[][] resultado = new double[filas1][columnas2];
	        				
	                		
	        				for(i=0; i < filas2; i++){
	        					for(j=0; j < columnas2; j++){
	        						int index2 = i * columnas2 + j;
	        						num2[i][j] = Double.parseDouble(camposMatriz2.get(index2).getText());


	        					}
	        				}
	        				
	        				for(i=0; i < filas1; i++){
	        					for(j=0; j < columnas1; j++){
	        							int index1 = i * columnas1 + j;
	        							num1[i][j] = Double.parseDouble(camposMatriz1.get(index1).getText());               			
	                				
	                			}
	                		}
	        				if (columnas2 == filas2) {
	        					double[][] inversa = inversa(num2);
	        					resultado = multiplicar(num1, inversa, columnas1, filas1, columnas2);
	        				}
	        				else {
	        					JOptionPane.showMessageDialog(null, "La matriz no es invertible.");
	        				}
	        				for(i=0; i < filas1; i++){
	        					for(j=0; j < columnas2; j++){
	        						
	        						ansMatriz[i][j] = resultado[i][j];
	        						
	        						
	        						String valorCortado = String.format("%.2f", resultado[i][j]);
	        						JTextField campoResultado = new JTextField(valorCortado);
	        						campoResultado.setEditable(false);
	        						campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
	        						campoResultado.setBackground(new Color(224, 255, 224));
	        						panelResultado.add(campoResultado);
            						panelResultado.revalidate();
            						panelResultado.repaint();
	        					}
	        				}
	        		}
	        	}
	        });
	        btnDividir.setForeground(Color.BLACK);
	        btnDividir.setBorder(new LineBorder(new Color(0, 204, 153), 2, true));
	        btnDividir.setBounds(605, 129, 93, 23);
	        centroLibre.add(btnDividir);
	        
	        JButton btnTranspuesta = new JButton("TRANSPUESTA");
	        btnTranspuesta.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panelResultado.setVisible(true);
	        		int filas = Integer.parseInt(comboFilas1.getSelectedItem().toString());
					int columnas = Integer.parseInt(comboColumn1.getSelectedItem().toString());
					
					
						double [][] matriz = new double[filas][columnas];
						double [][] transpuesta = new double[columnas][filas];
						for (int i=0;i<filas;i++) {
							for (int j=0;j<columnas;j++) {
								int index = i * columnas + j;
								matriz[i][j] = Integer.parseInt(camposMatriz1.get(index).getText());
							}
						}
						for (int i=0;i<columnas;i++) {
							for (int j=0;j<filas;j++) {
								transpuesta[i][j] = matriz[j][i];
							}
						}
	        				

	        				panelResultado.removeAll();
	        				panelResultado.setLayout(new GridLayout(columnas, filas, 5, 5));
	        				
	        				for(int i=0;i<columnas;i++) {
	        					for(int j=0;j<filas;j++) {
	        							ansMatriz[i][j] = transpuesta[i][j];
	        					    	JTextField campoResultado = new JTextField(String.valueOf(transpuesta[i][j]));
	        					    	campoResultado.setEditable(false);
	        					    	campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
	        					    	campoResultado.setBackground(new Color(224, 255, 224));
	        					    	panelResultado.add(campoResultado);
	        					}
	        				}
	        					panelResultado.revalidate();
	        				    panelResultado.repaint();
	        			
	        		
	        	}
	        });
	        btnTranspuesta.setForeground(Color.BLACK);
	        btnTranspuesta.setBorder(new LineBorder(new Color(0, 204, 153), 2, true));
	        btnTranspuesta.setBounds(498, 163, 93, 23);
	        centroLibre.add(btnTranspuesta);
	        
	        
	        
        
        
        
        centroLibre.revalidate();
        centroLibre.repaint();
	}
	private static void submatriz(int[][] origen, int[][] destino, int n, int filas, int columnas) {
	    int ni=0;
	    for (int i = 0; i < n; i++) {
	        if (i == columnas) continue;
	        int nj = 0;
	        for (int j = 0; j < n; j++) {
	            if (j == filas) continue;
	            destino[ni][nj] = origen[i][j];
	            nj++;
	        }
	        ni++;
	    }
	}
	private static int determinante(int[][] matriz, int n) {
		int resultado = 0;
		
		if (n==1) {
			resultado = matriz[0][0];
		}
		if (n==2) {
			resultado = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
		}
		
		
		int signo = 1;
		
		if (n >= 3) {
			for(int column=0;column < n; column++) {
				int[][] menor = new int[n-1][n-1];
				submatriz(matriz, menor, n, 0, column);
				signo *= -1;
				resultado += signo * matriz[0][column] * determinante(menor, n - 1);
			}
			
		}
		return resultado;
	
	}
	private static double[][] inversa(double[][] matriz) {
		int n = matriz.length;
		double[][] identidad = new double[n][n];
		int i, j; 
		int k = 0;
		for (i=0;i<n;i++) {
			for (j=0;j<n;j++) {
				if (i == j) {
					identidad[i][j] = 1;
				}
				else {
					identidad[i][j] = 0;
				}
			}
		}
		for (i=0;i<n;i++) {
			double pivote = matriz[i][i];
			for (j=0;j<n;j++) {
				matriz[i][j] = matriz[i][j] / pivote;
				identidad[i][j] = identidad[i][j] / pivote;
			}
			
			for (k=0;k<n;k++) {
				if (k != i) {
					double factor = matriz[k][i];
					for(j=0;j<n;j++) {
						matriz[k][j] = matriz[k][j] - factor * matriz[i][j];
						identidad[k][j] = identidad[k][j] - factor * identidad[i][j];
					}
				}
			}
		}
		return identidad;
		
	}
	private static double[][] multiplicar(double[][] num1, double[][] num2, int columnas1, int filas1, int columnas2) {
		int i, j;
		double[][] resultado = new double[filas1][columnas2];
//                		int[][] num1 = new int[n][m];
//               		int[][] num2 = new int[n][m];
//                		int[][] resultado = new int[n][m];
		
		for(i=0; i < filas1; i++){
			for(j=0; j < columnas2; j++){
				double multiplicacion = 0;
				for (int k=0;k<columnas1;k++) {
					multiplicacion += num1[i][k] * num2[k][j];
				}	
				resultado[i][j]  = multiplicacion;
			}
		}
		return resultado;
	}
	private void llenarMatrizDesdeArray(double[][] ansMatriz, List<JTextField> camposMatriz1, int filas, int columnas ) {
	    for (int i = 0; i < filas; i++) {
	        for (int j = 0; j < columnas; j++) {
	        	int index = i * columnas + j;
	        	String valorRedondeado = String.format("%.2f", ansMatriz[i][j]);
	            camposMatriz1.get(index).setText(String.valueOf(valorRedondeado));
	        }
	    }
	}
}