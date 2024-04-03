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

import logico.Componente;
import logico.Microprocesador;
import logico.TiendaElite;
import java.awt.Toolkit;

public class AgregarCPU extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTipoConexion;
	private JTextField txtNumSerie;
	private JSpinner spnPrecio;
	private JSpinner spnVelocidadProcesamiento;
	private JSpinner spnCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarCPU dialog = new AgregarCPU();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

	/**
	 * Create the dialog.
	 */
	public AgregarCPU() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarCPU.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("CPU");
		setBounds(100, 100, 429, 324);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 413, 264);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCantidad.setBounds(28, 189, 103, 14);
			panel.add(lblCantidad);
			
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(239, 189, 136, 20);
			panel.add(spnCantidad);
			{
				JLabel lblNumSerie = new JLabel("Numero de serie:");
				lblNumSerie.setBounds(28, 35, 112, 14);
				panel.add(lblNumSerie);
				lblNumSerie.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(28, 60, 57, 14);
				panel.add(lblMarca);
				lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(27, 162, 46, 14);
				panel.add(lblPrecio);
				lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			txtNumSerie = new JTextField();
			txtNumSerie.setBounds(239, 33, 136, 20);
			panel.add(txtNumSerie);
			txtNumSerie.setColumns(10);
			{
				JLabel lblTipoConexion = new JLabel("Tipo de conexion:");
				lblTipoConexion.setBounds(28, 135, 188, 14);
				panel.add(lblTipoConexion);
				lblTipoConexion.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblVelocidadProcesamiento = new JLabel("Velocidad de procesamiento:");
				lblVelocidadProcesamiento.setBounds(28, 110, 199, 14);
				panel.add(lblVelocidadProcesamiento);
				lblVelocidadProcesamiento.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setBounds(28, 85, 81, 14);
				panel.add(lblModelo);
				lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			spnPrecio = new JSpinner();
			spnPrecio.setBounds(239, 160, 136, 20);
			panel.add(spnPrecio);
			spnPrecio.setToolTipText("");
			spnPrecio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			
			txtTipoConexion = new JTextField();
			txtTipoConexion.setBounds(239, 133, 136, 20);
			panel.add(txtTipoConexion);
			txtTipoConexion.setColumns(10);
			{
				spnVelocidadProcesamiento = new JSpinner();
				spnVelocidadProcesamiento.setBounds(239, 108, 136, 20);
				panel.add(spnVelocidadProcesamiento);
				spnVelocidadProcesamiento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			}
			
			txtModelo = new JTextField();
			txtModelo.setBounds(239, 83, 136, 20);
			panel.add(txtModelo);
			txtModelo.setColumns(10);
			
			txtMarca = new JTextField();
			txtMarca.setBounds(239, 58, 136, 20);
			panel.add(txtMarca);
			txtMarca.setBackground(new Color(255, 255, 255));
			txtMarca.setColumns(10);
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
						String numserie = txtNumSerie.getText();
						float precio = Float.valueOf(spnPrecio.getValue().toString());
						float velocidadprocesamiento = Float.valueOf(spnVelocidadProcesamiento.getValue().toString());
						int cantidad = Integer.valueOf(spnCantidad.getValue().toString());

						if(TiendaElite.getInstance().serialExiste(numserie)) {
							JOptionPane.showMessageDialog(null, "Este numero de serie ya esta en uso!", "Error",JOptionPane.ERROR_MESSAGE);
							clean();
						}else {
							aux = new Microprocesador(marca,numserie,precio,cantidad,modelo,tipoconexion,velocidadprocesamiento);
							TiendaElite.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "CPU agregado", "Informacion",JOptionPane.INFORMATION_MESSAGE);
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
		spnVelocidadProcesamiento.setValue(new Float(0.0));
		spnCantidad.setValue(new Integer(1));	
	}
	
}
