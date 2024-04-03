package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.TiendaElite;
import logico.Componente;
import logico.TarjetaMadre;

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

public class AgregarTarjetaMadre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTipoConector;
	private JTextField txtTipoDiscoCompatible;
	private JTextField txtNumSerie;
	private JSpinner spnPrecio;
	private JTextField txtTipoMemoria;
	private JSpinner spnCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarTarjetaMadre dialog = new AgregarTarjetaMadre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarTarjetaMadre() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AgregarTarjetaMadre.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Tarjeta Madre");
		setBounds(100, 100, 427, 335);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 411, 304);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCantidad.setBounds(30, 202, 89, 14);
			panel.add(lblCantidad);

			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(239, 200, 136, 20);
			panel.add(spnCantidad);
			{
				JLabel lblNumSerie = new JLabel("Numero de serie:");
				lblNumSerie.setBounds(30, 26, 112, 14);
				panel.add(lblNumSerie);
				lblNumSerie.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
					txtNumSerie = new JTextField();
					txtNumSerie.setBounds(239, 24, 136, 20);
					panel.add(txtNumSerie);
					txtNumSerie.setColumns(10);
					{
						JLabel lblPrecio = new JLabel("Precio:");
						lblPrecio.setBounds(30, 177, 46, 14);
						panel.add(lblPrecio);
						lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
					}
					
							spnPrecio = new JSpinner();
							spnPrecio.setBounds(239, 175, 136, 20);
							panel.add(spnPrecio);
							spnPrecio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
							{
								JLabel lblTipoDisco = new JLabel("Tipo de Disco compatible:");
								lblTipoDisco.setBounds(30, 152, 188, 14);
								panel.add(lblTipoDisco);
								lblTipoDisco.setFont(new Font("Tahoma", Font.BOLD, 12));
							}
							
									txtTipoDiscoCompatible = new JTextField();
									txtTipoDiscoCompatible.setBounds(239, 150, 136, 20);
									panel.add(txtTipoDiscoCompatible);
									txtTipoDiscoCompatible.setColumns(10);
									{
										JLabel lblTipoMemoria = new JLabel("Tipo de Memoria compatible:");
										lblTipoMemoria.setBounds(30, 125, 199, 14);
										panel.add(lblTipoMemoria);
										lblTipoMemoria.setFont(new Font("Tahoma", Font.BOLD, 12));
									}
									
											txtTipoMemoria = new JTextField();
											txtTipoMemoria.setBounds(239, 123, 136, 20);
											panel.add(txtTipoMemoria);
											txtTipoMemoria.setColumns(10);
											
													txtTipoConector = new JTextField();
													txtTipoConector.setBounds(239, 98, 136, 20);
													panel.add(txtTipoConector);
													txtTipoConector.setColumns(10);
													{
														JLabel lblTipoConector = new JLabel("Tipo de conector:");
														lblTipoConector.setBounds(30, 100, 146, 14);
														panel.add(lblTipoConector);
														lblTipoConector.setFont(new Font("Tahoma", Font.BOLD, 12));
													}
													{
														JLabel lblModelo = new JLabel("Modelo:");
														lblModelo.setBounds(30, 75, 81, 14);
														panel.add(lblModelo);
														lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
													}
													
															txtModelo = new JTextField();
															txtModelo.setBounds(239, 73, 136, 20);
															panel.add(txtModelo);
															txtModelo.setColumns(10);
															{
																JLabel lblMarca = new JLabel("Marca:");
																lblMarca.setBounds(30, 51, 57, 14);
																panel.add(lblMarca);
																lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
															}
															
																	txtMarca = new JTextField();
																	txtMarca.setBounds(239, 49, 136, 20);
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
						String tipoconector = txtTipoConector.getText();
						String tipomemoria = txtTipoMemoria.getText();
						String TipoDiscoCompatible = txtTipoDiscoCompatible.getText();
						String numserie = txtNumSerie.getText();
						float precio = Float.valueOf(spnPrecio.getValue().toString());
						int cantidad = Integer.valueOf(spnCantidad.getValue().toString());
						
						if(TiendaElite.getInstance().serialExiste(numserie)) {
							JOptionPane.showMessageDialog(null, "Este numero de serie ya esta en uso!", "Error",JOptionPane.ERROR_MESSAGE);
							clean();
						}else {
							
							aux = new TarjetaMadre(marca,numserie,precio,cantidad,modelo,tipoconector,tipomemoria,TipoDiscoCompatible);
	
							TiendaElite.getInstance().insertarComponente(aux);
							
							JOptionPane.showMessageDialog(null, "Tarjeta Madre agregada", "Informacion",JOptionPane.INFORMATION_MESSAGE);
	
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
		txtTipoConector.setText("");
		txtTipoMemoria.setText("");
		txtTipoDiscoCompatible.setText("");
		txtNumSerie.setText("");
		spnPrecio.setValue(new Float(0.0));
		spnCantidad.setValue(new Integer(1));
		
	}
}
