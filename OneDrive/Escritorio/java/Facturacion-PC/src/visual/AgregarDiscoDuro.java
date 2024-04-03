package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

import logico.Componente;
import logico.DiscoDuro;
import logico.TiendaElite;

public class AgregarDiscoDuro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTipoConexion;
	private JTextField txtNumSerie;
	private JSpinner spnPrecio;
	private JSpinner spnCapacidadAlmacenamiento;
	private JSpinner spnCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarDiscoDuro dialog = new AgregarDiscoDuro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarDiscoDuro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarDiscoDuro.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Disco Duro");
		setBounds(100, 100, 428, 329);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(322, 263, 89, 41);
			contentPanel.add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 411, 255);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNumSerie = new JLabel("Numero de serie:");
				lblNumSerie.setBounds(28, 37, 112, 14);
				panel.add(lblNumSerie);
				lblNumSerie.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			txtNumSerie = new JTextField();
			txtNumSerie.setBounds(240, 35, 136, 20);
			panel.add(txtNumSerie);
			txtNumSerie.setColumns(10);
			{
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(28, 162, 46, 14);
				panel.add(lblPrecio);
				lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			spnPrecio = new JSpinner();
			spnPrecio.setBounds(240, 160, 136, 20);
			panel.add(spnPrecio);
			spnPrecio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			{
				JLabel lblTipoDeConexion = new JLabel("Tipo de conexion:");
				lblTipoDeConexion.setBounds(28, 137, 188, 14);
				panel.add(lblTipoDeConexion);
				lblTipoDeConexion.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			txtTipoConexion = new JTextField();
			txtTipoConexion.setBounds(240, 135, 136, 20);
			panel.add(txtTipoConexion);
			txtTipoConexion.setColumns(10);
			{
				JLabel lblCapacidadAlmacenamiento = new JLabel("Capacidad de almacenamiento:");
				lblCapacidadAlmacenamiento.setBounds(28, 112, 199, 14);
				panel.add(lblCapacidadAlmacenamiento);
				lblCapacidadAlmacenamiento.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				spnCapacidadAlmacenamiento = new JSpinner();
				spnCapacidadAlmacenamiento.setBounds(240, 110, 136, 20);
				panel.add(spnCapacidadAlmacenamiento);
				spnCapacidadAlmacenamiento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			}
			{
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setBounds(28, 87, 81, 14);
				panel.add(lblModelo);
				lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			txtModelo = new JTextField();
			txtModelo.setBounds(240, 85, 136, 20);
			panel.add(txtModelo);
			txtModelo.setColumns(10);
			{
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(28, 187, 96, 14);
				panel.add(lblCantidad);
				lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(28, 62, 57, 14);
				panel.add(lblMarca);
				lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			txtMarca = new JTextField();
			txtMarca.setBounds(240, 60, 136, 20);
			panel.add(txtMarca);
			txtMarca.setBackground(new Color(255, 255, 255));
			txtMarca.setColumns(10);
			{
				spnCantidad = new JSpinner();
				spnCantidad.setBounds(240, 185, 136, 20);
				panel.add(spnCantidad);
				spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setBackground(new Color(255, 255, 224));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Componente aux = null;
						String marca = txtMarca.getText();
						String modelo = txtModelo.getText();
						String tipoconexion = txtTipoConexion.getText();
						String serie = txtNumSerie.getText();
						float precio = Float.valueOf(spnPrecio.getValue().toString());
						float almacenamiento =  Float.valueOf(spnCapacidadAlmacenamiento.getValue().toString());
						int cantidad = Integer.valueOf(spnCantidad.getValue().toString());
						
						if(TiendaElite.getInstance().serialExiste(serie)) {
							JOptionPane.showMessageDialog(null, "Este numero de serie ya esta en uso!", "Error",JOptionPane.ERROR_MESSAGE);
							clean();
						}else {
						
							aux = new DiscoDuro(marca,serie,precio,cantidad,modelo,almacenamiento,tipoconexion);
							
							TiendaElite.getInstance().insertarComponente(aux);
					
							JOptionPane.showMessageDialog(null, "Disco Disco agregado", "Informacion",JOptionPane.INFORMATION_MESSAGE);
							
							clean();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
	}
	
	private void clean()
	{
		txtMarca.setText("");
		txtModelo.setText("");
		txtTipoConexion.setText("");
		txtNumSerie.setText("");
		spnPrecio.setValue(new Float(0.0));
		spnCapacidadAlmacenamiento.setValue(new Float(0.0));
		spnCantidad.setValue(new Integer(1));
	}
}
