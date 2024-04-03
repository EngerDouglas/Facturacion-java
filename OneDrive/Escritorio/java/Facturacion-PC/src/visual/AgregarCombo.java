package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.TiendaElite;
import logico.Combo;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Choice;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class AgregarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JButton btnIzquierda;
	private JButton btnDerecha;
	
	private DefaultListModel<String>modelListComponentesDisp;
	private DefaultListModel<String>modelListCombo;
	

	private ArrayList<String>Combo;
	private ArrayList<String>Componentes;
	
	private int selected = -1;
	private float total = 0;
	private int ind = 0;
	private JLabel lblComponentesDisponibles;
	private JPanel PanelComponentesDisp;
	private JPanel panel_Combo;
	private JScrollPane scrollPaneComponentes;
	private JList ListComponentes;
	private JScrollPane scrollPaneCombo;
	private JList ListCombo;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JComboBox cbxOpciones;
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarCombo dialog = new AgregarCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarCombo() {
		
		Combo = new ArrayList<>();
		Componentes = new ArrayList<>();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarCombo.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Agregar Combo");
		setBounds(100, 100, 620, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel PanelPrincipal = new JPanel();
		PanelPrincipal.setBackground(new Color(30, 144, 255));
		PanelPrincipal.setBounds(0, 0, 604, 398);
		contentPanel.add(PanelPrincipal);
		PanelPrincipal.setLayout(null);
				
		JLabel lblCombos = new JLabel("Combo");
		lblCombos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCombos.setBounds(373, 78, 61, 14);
		PanelPrincipal.add(lblCombos);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(460, 646, 46, 14);
		PanelPrincipal.add(lblNewLabel_2);
		
		cbxOpciones = new JComboBox();
		cbxOpciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbxOpciones.setModel(new DefaultComboBoxModel(new String[] {"Combo Normal", "Combo Profesor", "Combo Estudiante"}));
		cbxOpciones.setToolTipText("Opciones");
		cbxOpciones.setBounds(373, 10, 169, 20);
		PanelPrincipal.add(cbxOpciones);
		
		btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float descuento = 0;
				String temp = Combo.get(selected);
				Componentes.add(temp);
				modelListComponentesDisp.addElement(temp);
				btnDerecha.setEnabled(false);
				
				total -= Float.valueOf(Combo.get(selected).substring(Combo.get(selected).indexOf(" ")+6,Combo.get(selected).length()));

				
				
				if(cbxOpciones.getSelectedIndex() == 1)
				{
					descuento = (float) (total * 0.10);
				}
				
				if(cbxOpciones.getSelectedIndex() == 2)
				{
					descuento = (float) ( total * 0.20);
				}
				
				total = total + descuento;
				
				if(total < 0)
				{
					total = 0;
				}
				
				txtTotal.setText("$" + Float.toString(total));

				Combo.remove(selected);
				reloadcombo();
				ind--;
				
			}
		});
		btnIzquierda.setEnabled(false);
		btnIzquierda.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIzquierda.setBounds(260, 213, 89, 23);
		PanelPrincipal.add(btnIzquierda);
		
		btnDerecha = new JButton(">>");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float descuento = 0;
				String temp = Componentes.get(selected);
				Combo.add(temp);
				modelListCombo.addElement(temp);
				btnIzquierda.setEnabled(false);
				
				Componentes.remove(selected);
				
				reloadcomponentes();
				
				total += Float.valueOf(Combo.get(ind).substring(Combo.get(ind).indexOf(" ")+6,Combo.get(ind).length()));
				
			
				if(cbxOpciones.getSelectedIndex() == 1)
				{
					descuento = (float) (total * 0.10);
				}
				
				if(cbxOpciones.getSelectedIndex() == 2)
				{
					descuento = (float) (total * 0.20);
				}
				

				total = total - descuento;
				txtTotal.setText("$" + Float.toString(total));
				
				ind++;
				
				
			}
		});
		btnDerecha.setEnabled(false);
		btnDerecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDerecha.setBounds(260, 176, 89, 23);
		PanelPrincipal.add(btnDerecha);
		
		modelListCombo = new DefaultListModel<String>();
		
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigo.setBounds(27, 11, 74, 18);
		PanelPrincipal.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(87, 12, 121, 20);
		txtCodigo.setText("C-"+TiendaElite.codigo_combo);
		PanelPrincipal.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblComponentesDisponibles = new JLabel("Componentes Disponibles");
		lblComponentesDisponibles.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComponentesDisponibles.setBounds(27, 78, 182, 14);
		PanelPrincipal.add(lblComponentesDisponibles);
		
		PanelComponentesDisp = new JPanel();
		PanelComponentesDisp.setBounds(27, 102, 211, 234);
		PanelPrincipal.add(PanelComponentesDisp);
		PanelComponentesDisp.setLayout(new BorderLayout(0, 0));
		
		scrollPaneComponentes = new JScrollPane();
		PanelComponentesDisp.add(scrollPaneComponentes, BorderLayout.CENTER);
		
		ListComponentes = new JList<>();
		ListComponentes.setBounds(0, 235, 211, -233);
		ListComponentes.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListComponentes.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnIzquierda.setEnabled(false);
					btnDerecha.setEnabled(true);
					
				}
				
				
			}
			
			
		});
		
		modelListComponentesDisp = new DefaultListModel<String>();
		ListComponentes.setModel(modelListComponentesDisp);
		scrollPaneComponentes.setViewportView(ListComponentes);
		
		panel_Combo = new JPanel();
		panel_Combo.setBounds(376, 102, 204, 234);
		PanelPrincipal.add(panel_Combo);
		panel_Combo.setLayout(new BorderLayout(0, 0));
		
		scrollPaneCombo = new JScrollPane();
		panel_Combo.add(scrollPaneCombo, BorderLayout.CENTER);
		
		ListCombo = new JList<>();
		ListCombo.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListCombo.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnIzquierda.setEnabled(true);
					btnDerecha.setEnabled(false);
					
				}
			}
			
			
		});
		
		modelListCombo = new DefaultListModel<String>();
		ListCombo.setModel(modelListCombo);
		scrollPaneCombo.setViewportView(ListCombo);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(373, 360, 46, 14);
		PanelPrincipal.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setText("$0.0");
		txtTotal.setEditable(false);
		txtTotal.setBounds(420, 358, 160, 20);
		PanelPrincipal.add(txtTotal);
		txtTotal.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Agregar = new JButton("Agregar");
				Agregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Componente aux = null;
						
						ArrayList<Componente> combos = new ArrayList<>();
						
						for(int i = 0; i < Combo.size(); i++)
						{
							String codcomponente = Combo.get(i).substring(0,Combo.get(i).indexOf(" "));

							Componente comp = TiendaElite.getInstance().buscarComponenteBySerial(codcomponente);

							int posicion = TiendaElite.getInstance().buscarComponenteIndexBySerial(comp.getNumeroSerie());

							comp.setCantidad(comp.getCantidad()-1);

							if(comp.getCantidad() > 0)
							{ 
								aux = comp;
								combos.add(aux);	
							
							}
							else
							{
								combos.add(TiendaElite.getInstance().getMisComponentes().remove(posicion));
								
							}
						}
						
						Combo combo = new Combo(txtCodigo.getText(),null,total);
						
						TiendaElite.getInstance().insertarCombo(combo);

						JOptionPane.showMessageDialog(null, "Combo agregado", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
						
						clear();
						dispose();
						
						
					}
				});
				Agregar.setBackground(new Color(255, 255, 224));
				Agregar.setFont(new Font("Tahoma", Font.BOLD, 12));
				Agregar.setActionCommand("OK");
				buttonPane.add(Agregar);
				getRootPane().setDefaultButton(Agregar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadcomponentes();
		loadCombo();
		
	
		
	}
	
	private void clear()
	{
		txtCodigo.setText("C-" + TiendaElite.getCodigo_combo());
		txtTotal.setText("$0.0");
		total = 0;
		Componentes = new ArrayList<>();
		Combo = new ArrayList<>();
		modelListCombo.removeAllElements();
		modelListComponentesDisp.removeAllElements();
		loadcomponentes();
		loadCombo();
		btnDerecha.setEnabled(false);
		btnIzquierda.setEnabled(false);
		txtTotal.setText("$0.0");
	}
	
	private void reloadcomponentes()
	{
		modelListComponentesDisp.removeAllElements();
		String aux = "";
		
		for(String componente : Componentes)
		{
			aux = componente;
			modelListComponentesDisp.addElement(aux);
		}
	}
	
	private void reloadcombo()
	{
		modelListCombo.removeAllElements();
		String aux = "";
		
		for(String carrito : Combo)
		{
			aux = carrito;
			modelListCombo.addElement(aux);
		}
	}
	
	private void loadcomponentes()
	{
		modelListComponentesDisp.removeAllElements();
		String aux = "";
		
		for(Componente componente : TiendaElite.getInstance().getMisComponentes())
		{				
			
			for(int i = 0; i < componente.getCantidad(); i++)	
			{
				if(componente instanceof TarjetaMadre && componente.getDisponibilidad() == 'D')
				{
					aux = componente.getNumeroSerie() + " MB  $" + componente.getPrecio();
					Componentes.add(aux);
					modelListComponentesDisp.addElement(aux);
				}
				if(componente instanceof MemoriaRAM && componente.getDisponibilidad() == 'D')
				{
					aux = componente.getNumeroSerie() + " RAM $" + componente.getPrecio();
					Componentes.add(aux);
					modelListComponentesDisp.addElement(aux);
				}
				if(componente instanceof DiscoDuro && componente.getDisponibilidad() == 'D')
				{
					aux = componente.getNumeroSerie() + " SSD $" + componente.getPrecio();
					Componentes.add(aux);
					modelListComponentesDisp.addElement(aux);
				}
				if(componente instanceof Microprocesador && componente.getDisponibilidad() == 'D')
				{
					aux = componente.getNumeroSerie() + " CPU $" + componente.getPrecio();
					Componentes.add(aux);
					modelListComponentesDisp.addElement(aux);
				}
				
			}
			
		}
	}
	
	private void loadCombo()
	{
		modelListCombo.removeAllElements();
	}
	
	

	
}
