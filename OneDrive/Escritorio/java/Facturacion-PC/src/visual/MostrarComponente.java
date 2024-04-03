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

import logico.*;

import logico.Componente;
import logico.Microprocesador;
import logico.TiendaElite;
import java.awt.Toolkit;

public class MostrarComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTipoConexion;
	private JTextField txtNumSerie;
	private JTextField txtVelocidadProcesamiento;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private Componente componente = null;
	private JTextField txtCapacidadAlmacenamiento;
	private JTextField txtTipoMemoria;
	private JTextField txtTipoMemoriaCompatible;
	private JTextField txtTipoDiscoCompatible;
	private JTextField txtcomponente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarComponente dialog = new MostrarComponente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarComponente(Componente seleccionado) {
		componente = seleccionado;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AgregarCPU.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("CPU");
		setBounds(100, 100, 414, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 398, 362);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCantidad.setBounds(30, 206, 103, 14);
			panel.add(lblCantidad);
			{
				JLabel lblNumSerie = new JLabel("Numero de serie:");
				lblNumSerie.setBounds(30, 52, 112, 14);
				panel.add(lblNumSerie);
				lblNumSerie.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(30, 77, 57, 14);
				panel.add(lblMarca);
				lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(29, 179, 46, 14);
				panel.add(lblPrecio);
				lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
			}

			txtNumSerie = new JTextField();
			txtNumSerie.setEditable(false);
			txtNumSerie.setBounds(241, 50, 136, 20);
			panel.add(txtNumSerie);
			txtNumSerie.setColumns(10);
			{
				JLabel lblTipoConexion = new JLabel("Tipo de conexion:");
				lblTipoConexion.setBounds(30, 152, 188, 14);
				panel.add(lblTipoConexion);
				lblTipoConexion.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblVelocidadProcesamiento = new JLabel("Velocidad de procesamiento:");
				lblVelocidadProcesamiento.setBounds(30, 127, 199, 14);
				panel.add(lblVelocidadProcesamiento);
				lblVelocidadProcesamiento.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setBounds(30, 102, 81, 14);
				panel.add(lblModelo);
				lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
			}

			txtTipoConexion = new JTextField();
			txtTipoConexion.setEditable(false);
			txtTipoConexion.setBounds(241, 150, 136, 20);
			panel.add(txtTipoConexion);
			txtTipoConexion.setColumns(10);

			txtModelo = new JTextField();
			txtModelo.setEditable(false);
			txtModelo.setBounds(241, 100, 136, 20);
			panel.add(txtModelo);
			txtModelo.setColumns(10);

			txtMarca = new JTextField();
			txtMarca.setEditable(false);
			txtMarca.setBounds(241, 75, 136, 20);
			panel.add(txtMarca);
			txtMarca.setBackground(new Color(255, 255, 255));
			txtMarca.setColumns(10);

			txtVelocidadProcesamiento = new JTextField();
			txtVelocidadProcesamiento.setEditable(false);
			txtVelocidadProcesamiento.setColumns(10);
			txtVelocidadProcesamiento.setBounds(241, 125, 136, 20);
			panel.add(txtVelocidadProcesamiento);

			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(241, 177, 136, 20);
			panel.add(txtPrecio);

			txtCantidad = new JTextField();
			txtCantidad.setEditable(false);
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(241, 204, 136, 20);
			panel.add(txtCantidad);

			JLabel lblCapacidaDeProcesamiento = new JLabel("Capacida de almacenamiento:");
			lblCapacidaDeProcesamiento.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCapacidaDeProcesamiento.setBounds(30, 233, 199, 14);
			panel.add(lblCapacidaDeProcesamiento);

			txtCapacidadAlmacenamiento = new JTextField();
			txtCapacidadAlmacenamiento.setEditable(false);
			txtCapacidadAlmacenamiento.setColumns(10);
			txtCapacidadAlmacenamiento.setBounds(241, 231, 136, 20);
			panel.add(txtCapacidadAlmacenamiento);

			JLabel label = new JLabel("Tipo de Memoria:");
			label.setFont(new Font("Tahoma", Font.BOLD, 12));
			label.setBounds(30, 258, 188, 14);
			panel.add(label);

			txtTipoMemoria = new JTextField();
			txtTipoMemoria.setEditable(false);
			txtTipoMemoria.setColumns(10);
			txtTipoMemoria.setBounds(241, 256, 136, 20);
			panel.add(txtTipoMemoria);

			JLabel label_1 = new JLabel("Tipo de Disco compatible:");
			label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			label_1.setBounds(32, 312, 188, 14);
			panel.add(label_1);

			JLabel label_2 = new JLabel("Tipo de Memoria compatible:");
			label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
			label_2.setBounds(32, 285, 199, 14);
			panel.add(label_2);

			txtTipoMemoriaCompatible = new JTextField();
			txtTipoMemoriaCompatible.setEditable(false);
			txtTipoMemoriaCompatible.setColumns(10);
			txtTipoMemoriaCompatible.setBounds(241, 283, 136, 20);
			panel.add(txtTipoMemoriaCompatible);

			txtTipoDiscoCompatible = new JTextField();
			txtTipoDiscoCompatible.setEditable(false);
			txtTipoDiscoCompatible.setColumns(10);
			txtTipoDiscoCompatible.setBounds(241, 310, 136, 20);
			panel.add(txtTipoDiscoCompatible);

			txtcomponente = new JTextField();
			txtcomponente.setEditable(false);
			txtcomponente.setColumns(10);
			txtcomponente.setBounds(81, 11, 227, 20);
			panel.add(txtcomponente);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		loadComponente();
	}

	public void loadComponente() {
		if (componente != null) {
			txtCantidad.setText(String.valueOf(componente.getCantidad()));
			txtMarca.setText(componente.getMarca());
			txtNumSerie.setText(componente.getNumeroSerie());
			txtPrecio.setText(String.valueOf(componente.getPrecio()));

			if (componente instanceof Microprocesador) {
				txtcomponente.setText("Microprocesador");
				txtMarca.setText(((Microprocesador) componente).getModelo());
				txtTipoConexion.setText(((Microprocesador) componente).getTipoConexion());
				txtVelocidadProcesamiento.setText(String.valueOf(((Microprocesador) componente).getVelocidadProcesamientos()));
				txtModelo.setText(((Microprocesador) componente).getModelo());
			} else {
				txtMarca.setText("None");
				txtTipoConexion.setText("None");
				txtVelocidadProcesamiento.setText("None");
				txtModelo.setText("None");
			}

			if (componente instanceof DiscoDuro) {
				txtcomponente.setText("Disco Duro");
				txtModelo.setText(((DiscoDuro) componente).getModelo());
				txtMarca.setText(((DiscoDuro) componente).getModelo());
				txtTipoConexion.setText(((DiscoDuro) componente).getTipoConexion());
			} else {
				txtMarca.setText("None");
				txtTipoConexion.setText("None");
				txtModelo.setText("None");
			}
			if (componente instanceof MemoriaRAM) {
				txtcomponente.setText("Memoria RAM");
				txtCapacidadAlmacenamiento.setText(String.valueOf(((MemoriaRAM) componente).getCantMemoria()));
				txtTipoMemoria.setText(String.valueOf(((MemoriaRAM) componente).getTipoMemoria()));
			} else {
				txtCapacidadAlmacenamiento.setText("None");
				txtTipoMemoria.setText("None");
			}
			if (componente instanceof TarjetaMadre) {
				txtcomponente.setText("Tarjeta Madre");
				txtModelo.setText(((TarjetaMadre) componente).getModelo());
				txtTipoConexion.setText(((TarjetaMadre) componente).getTipoConector());
				txtTipoMemoriaCompatible.setText(((TarjetaMadre) componente).getTipoMemoriaRAM());
				txtTipoDiscoCompatible.setText(((TarjetaMadre) componente).getTipoConexionDiscoDuro());
			} else {
				txtTipoConexion.setText("None");
				txtTipoMemoriaCompatible.setText("None");
				txtTipoDiscoCompatible.setText("None");
				txtModelo.setText("None");
			}
		}
	}

}
