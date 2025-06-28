package GUI.Vectores.Operaciones;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class panelProductoEscalar extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public panelProductoEscalar() {
		setLayout(new MigLayout("", "[grow]", "[][][][][]"));
	    setBackground(new Color(255, 255, 255));

	    JLabel lblProductoEscalar = new JLabel("Producto Escalar");
	    lblProductoEscalar.setFont(new Font("Tahoma", Font.BOLD, 14));
	    add(lblProductoEscalar, "cell 0 0,alignx center,aligny center");

	    JLabel lblDescripcion = new JLabel("Ingrese los valores de los vectores para el producto escalar:");
	    lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    add(lblDescripcion, "cell 0 1,alignx center,aligny center");

	}

}
