package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

import logico.TiendaElite;
import logico.Componente;
import logico.Factura;
import logico.Cliente;
import logico.MemoriaRAM;
import logico.Combo;
import logico.DiscoDuro;
import logico.Microprocesador;
import logico.TarjetaMadre;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;


public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtTotal;
	private JScrollPane scrollPaneCompDisponibles;
	private JList ListCompDisponibles;
	private DefaultListModel<String>modelListCompDisponibles;
	private JButton btnComponenteIzquierda;
	private JButton btnComponentesDerecho;
	private JButton btnComboDerecha;
	private JButton btnComboIzquierda;
	private DefaultListModel<String>modelListCombos;
	private JScrollPane scrollPaneCarrito;
	private JList ListCarrito;
	private JList listCombo;
	private JScrollPane scrollPaneCombo;
	private DefaultListModel<String>modelListCarrito;
	private ArrayList<String>compdisp;
	private ArrayList<String>combosdisp;
	private ArrayList<String>carrito;
	private int selected = -1;
	private float total = 0;
	private int ind = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		
		compdisp = new ArrayList<>();
		combosdisp = new ArrayList<>();
		carrito = new ArrayList<>();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Facturar");
		setBounds(100, 100, 563, 759);
		getContentPane().setLayout(new BorderLayout()); 
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(97, 30, 182, 20);
		txtCodigo.setText("F-"+ TiendaElite.codigo_factura);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(97, 62, 182, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(97, 94, 182, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(96, 123, 423, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(289, 97, 89, 14);
		contentPanel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(360, 94, 159, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = TiendaElite.getInstance().buscarClienteByCedula(txtCedula.getText());
				
				if(cliente != null)
				{
					txtNombre.setText(cliente.getNombre());
					txtTelefono.setText(cliente.getTelefono());
					txtDireccion.setText(cliente.getDireccion());
					
					
				}
				else
				{
					
					txtNombre.setEditable(true);
					txtTelefono.setEditable(true);
					txtDireccion.setEditable(true);
				}
				
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setBounds(289, 61, 89, 23);
		contentPanel.add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 547, 685);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 255, 255));
		panelPrincipal.setBounds(10, 11, 527, 149);
		panel.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(10, 22, 70, 21);
		panelPrincipal.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 50, 60, 21);
		panelPrincipal.add(lblCedula);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 82, 70, 21);
		panelPrincipal.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setBounds(10, 114, 70, 14);
		panelPrincipal.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel PanelSecundario = new JPanel();
		PanelSecundario.setBackground(new Color(255, 255, 255));
		PanelSecundario.setBounds(10, 171, 527, 472);
		panel.add(PanelSecundario);
		PanelSecundario.setLayout(null);
		
		JLabel lblComponentesDisp = new JLabel("Componentes Disponibles");
		lblComponentesDisp.setBounds(10, 11, 199, 14);
		PanelSecundario.add(lblComponentesDisp);
		lblComponentesDisp.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnComponenteIzquierda = new JButton("<<");
		btnComponenteIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = carrito.get(selected);
				compdisp.add(temp);
				modelListCompDisponibles.addElement(temp);
				btnComponentesDerecho.setEnabled(false);
				btnComboDerecha.setEnabled(false);
				btnComboIzquierda.setEnabled(false);
				
				total -= Float.valueOf(carrito.get(selected).substring(carrito.get(selected).indexOf(" ")+6,carrito.get(selected).length()));
			
				txtTotal.setText("$" + Float.toString(total));

				carrito.remove(selected);
				reloadcarrito();
				ind--;
				
				
			}
		});
		btnComponenteIzquierda.setBounds(219, 142, 79, 23);
		PanelSecundario.add(btnComponenteIzquierda);
		btnComponenteIzquierda.setEnabled(false);
		btnComponenteIzquierda.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnComponentesDerecho = new JButton(">>");
		btnComponentesDerecho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = compdisp.get(selected);
				carrito.add(temp);
				modelListCarrito.addElement(temp);
				btnComponenteIzquierda.setEnabled(false);
				btnComboDerecha.setEnabled(false);
				btnComboIzquierda.setEnabled(false);
				
				
				compdisp.remove(selected);
				
				
				
				reloadcomponentes();
				
				total += Float.valueOf(carrito.get(ind).substring(carrito.get(ind).indexOf(" ")+6,carrito.get(ind).length()));
				
				txtTotal.setText("$" + Float.toString(total));
				
				ind++;
				
								
				
			}
		});
		btnComponentesDerecho.setBounds(219, 108, 79, 23);
		PanelSecundario.add(btnComponentesDerecho);
		btnComponentesDerecho.setEnabled(false);
		btnComponentesDerecho.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3 = new JLabel("Combos Disponibles");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 245, 199, 14);
		PanelSecundario.add(lblNewLabel_3);
	
		
		JPanel PanelCombo = new JPanel();
		PanelCombo.setToolTipText("");
		PanelCombo.setBackground(Color.WHITE);
		PanelCombo.setBounds(10, 270, 188, 191);
		PanelSecundario.add(PanelCombo);
		PanelCombo.setLayout(new BorderLayout(0, 0));
		
		
		btnComboDerecha = new JButton(">>");
		btnComboDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = combosdisp.get(selected);
				carrito.add(temp);
				modelListCombos.addElement(temp);
				btnComboIzquierda.setEnabled(false);
				
				combosdisp.remove(selected);
				
				reloadcombo();
				
                total += Float.valueOf(combosdisp.get(ind).substring(combosdisp.get(ind).indexOf(" ")+2,combosdisp.get(ind).length()));
				
				txtTotal.setText("$" + Float.toString(total));
				
				ind++;
				
				
			}
		});
		btnComboDerecha.setFont(new Font("Tahoma", Font.BOLD, 13)); 
		btnComboDerecha.setEnabled(false);
		btnComboDerecha.setBounds(219, 325, 79, 23);
		PanelSecundario.add(btnComboDerecha);
		
		btnComboIzquierda = new JButton("<<");
		btnComboIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = carrito.get(selected);
				combosdisp.add(temp);
				modelListCombos.addElement(temp);
				btnComboDerecha.setEnabled(false);
				
				total -= Float.valueOf(carrito.get(selected).substring(carrito.get(selected).indexOf(" ")+2,carrito.get(selected).length()));
			
				txtTotal.setText("$" + Float.toString(total));

				carrito.remove(selected);
				reloadcarrito();
				ind--;
				
				
				
			}
		});
		btnComboIzquierda.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnComboIzquierda.setEnabled(false);
		btnComboIzquierda.setBounds(219, 359, 79, 23);
		PanelSecundario.add(btnComboIzquierda);
		
		JPanel PanelCompDisponibles = new JPanel();
		PanelCompDisponibles.setBackground(Color.LIGHT_GRAY);
		PanelCompDisponibles.setBounds(10, 36, 188, 198);
		PanelSecundario.add(PanelCompDisponibles);
		PanelCompDisponibles.setLayout(new BorderLayout(0, 0));
		
		scrollPaneCompDisponibles = new JScrollPane();
		PanelCompDisponibles.add(scrollPaneCompDisponibles, BorderLayout.CENTER);
		
		
		ListCompDisponibles = new JList<>();
		ListCompDisponibles.setBackground(Color.WHITE);
		ListCompDisponibles.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListCompDisponibles.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnComponentesDerecho.setEnabled(true);
					btnComponenteIzquierda.setEnabled(false);
					
					btnComboIzquierda.setEnabled(false);
					btnComboDerecha.setEnabled(false);
					
				}
			}
			
		});
		
		modelListCompDisponibles = new DefaultListModel<String>();
		ListCompDisponibles.setModel(modelListCompDisponibles);
		ListCompDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPaneCompDisponibles.setViewportView(ListCompDisponibles);
		
		JPanel PanelCarrito = new JPanel();
		PanelCarrito.setBackground(Color.LIGHT_GRAY);
		PanelCarrito.setBounds(313, 41, 204, 420);
		PanelSecundario.add(PanelCarrito);
		PanelCarrito.setLayout(new BorderLayout(0, 0));
		
		scrollPaneCarrito = new JScrollPane();
		PanelCarrito.add(scrollPaneCarrito, BorderLayout.CENTER);
		
		ListCarrito = new JList<>();
		ListCarrito.setFont(new Font("Tahoma", Font.BOLD, 11));
		ListCarrito.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListCarrito.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnComponenteIzquierda.setEnabled(true);
					btnComponentesDerecho.setEnabled(false);
					
					btnComboDerecha.setEnabled(false);
					btnComboIzquierda.setEnabled(true);
					
				}
			}
			
			
		});
		
		modelListCarrito = new DefaultListModel<String>();
		ListCarrito.setModel(modelListCarrito);
		scrollPaneCarrito.setViewportView(ListCarrito);
		
		JLabel lblCarritoCompra = new JLabel("Carrito de Compra");
		lblCarritoCompra.setBounds(313, 11, 139, 14);
		PanelSecundario.add(lblCarritoCompra);
		lblCarritoCompra.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		scrollPaneCombo = new JScrollPane();
		PanelCombo.add(scrollPaneCombo, BorderLayout.CENTER);
		
		listCombo = new JList<>();
		listCombo.setBackground(Color.WHITE);
		listCombo.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = listCombo.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnComboDerecha.setEnabled(true);
					btnComboIzquierda.setEnabled(false);
					
					btnComponentesDerecho.setEnabled(false);
					btnComponenteIzquierda.setEnabled(false);
				}
			}
			
			
		});
		
		modelListCombos = new DefaultListModel<String>();
		listCombo.setModel(modelListCombos);
		listCombo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneCombo.setViewportView(listCombo);
		
		JScrollPane scrollPaneCarrito2 = new JScrollPane();
		scrollPaneCarrito2.setBounds(520, 270, -205, 191);
		PanelSecundario.add(scrollPaneCarrito2);
		
		txtTotal = new JTextField();
		txtTotal.setText("$0.0");
		txtTotal.setBounds(367, 654, 158, 20);
		panel.add(txtTotal);
		txtTotal.setEnabled(false);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setBounds(318, 656, 59, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonFacturar = new JButton("Facturar");
				ButtonFacturar.setBackground(new Color(255, 255, 224));
				ButtonFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Cliente cliente = TiendaElite.getInstance().buscarClienteByCedula(txtCedula.getText());
						Componente aux = null;
						
						if(cliente == null)
						{
							cliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
							TiendaElite.getInstance().getMisClientes().add(cliente);
						}
						
						ArrayList<Componente> compcarrito = new ArrayList<>();
						
						for(int i = 0; i < carrito.size(); i++)
						{
							String codcomponente = carrito.get(i).substring(0,carrito.get(i).indexOf(" "));
							
							Componente componente = TiendaElite.getInstance().buscarComponenteBySerial(codcomponente);
							
							int posicion = TiendaElite.getInstance().buscarComponenteIndexBySerial(componente.getNumeroSerie());
							
							componente.setCantidad(componente.getCantidad()-1);
							
							if(componente.getCantidad() > 0)
							{ 
								aux = componente;
								compcarrito.add(aux);	
							
							}
							else
							{
								compcarrito.add(TiendaElite.getInstance().getMisComponentes().remove(posicion));
								
							}
			
						}
						
						Factura factura = new Factura(txtCodigo.getText(), compcarrito,null, cliente);
						
						TiendaElite.getInstance().insertarFactura(factura);
						
						JOptionPane.showMessageDialog(null, "Factura realizada", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
						
						clear();
						dispose();
						
						
						
						
						
						
					}
				});
				ButtonFacturar.setFont(new Font("Tahoma", Font.BOLD, 13));
				ButtonFacturar.setActionCommand("OK");
				buttonPane.add(ButtonFacturar);
				getRootPane().setDefaultButton(ButtonFacturar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadcomponentes();
		loadcarrito();
		loadcombo();
		
		
	}
	
	private void clear()
	{
		txtCodigo.setText("F-" + TiendaElite.codigo_factura);
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtTotal.setText("$0.0");
		txtNombre.setEditable(false);
		txtTelefono.setEditable(false);
		txtDireccion.setEditable(false);
		total = 0;
		compdisp = new ArrayList<>();
		carrito = new ArrayList<>();
		combosdisp = new ArrayList<>();
		modelListCarrito.removeAllElements();
		loadcomponentes();
		loadcombo();
		btnComponenteIzquierda.setEnabled(false);
		btnComponentesDerecho.setEnabled(false);
		btnComboIzquierda.setEnabled(false);
		btnComboDerecha.setEnabled(false);
		
		
		
	}
	
	private void reloadcomponentes()
	{
		modelListCompDisponibles.removeAllElements();
		String aux = "";
		
		for(String componente : compdisp)
		{
			aux = componente;
			modelListCompDisponibles.addElement(aux);
		}

		
	}
	
	private void reloadcarrito()
	{
		modelListCarrito.removeAllElements();
		String aux = "";
		
		for(String carrito : carrito)
		{
			aux = carrito;
			modelListCarrito.addElement(aux);
		}
	}
	
	private void reloadcombo()
	{
		modelListCombos.removeAllElements();
		String aux = "";
		
		for(String combo : combosdisp)
		{
			aux = combo;
			modelListCarrito.addElement(aux);
		}
		
	}
	
	private void loadcombo()
	{
		modelListCombos.removeAllElements();
		String aux = "";
		
		for(Combo combo : TiendaElite.getInstance().getMisCombos())
		{
			aux = combo.getCodigo() + " $" + combo.getPrecio();
			combosdisp.add(aux);
			modelListCombos.addElement(aux);
		}
		
	}
	
	private void loadcomponentes()
	{
		modelListCompDisponibles.removeAllElements();
		String aux = "";
		
		for(Componente componente : TiendaElite.getInstance().getMisComponentes())
		{				
			
			for(int i = 0; i < componente.getCantidad(); i++)	
			{
				if(componente instanceof TarjetaMadre && componente.getDisponibilidad() == 'D')
				{
					aux = componente.getNumeroSerie() + " MB  $" + componente.getPrecio();
					compdisp.add(aux);
					modelListCompDisponibles.addElement(aux);
				}
				if(componente instanceof MemoriaRAM && componente.getDisponibilidad() == 'D')
				{
					aux = componente.getNumeroSerie() + " RAM $" + componente.getPrecio();
					compdisp.add(aux);
					modelListCompDisponibles.addElement(aux);
				}
				if(componente instanceof DiscoDuro && componente.getDisponibilidad() == 'D')
				{
					aux = componente.getNumeroSerie() + " SSD $" + componente.getPrecio();
					compdisp.add(aux);
					modelListCompDisponibles.addElement(aux);
				}
				if(componente instanceof Microprocesador && componente.getDisponibilidad() == 'D')
				{
					aux = componente.getNumeroSerie() + " CPU $" + componente.getPrecio();
					compdisp.add(aux);
					modelListCompDisponibles.addElement(aux);
				}
				
			}
			
		}
	}
	
	private void loadcarrito()
	{
		modelListCarrito.removeAllElements();
	}
	
	
	
	
	
}