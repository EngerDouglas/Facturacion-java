package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.TiendaElite;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import javafx.scene.control.SelectionMode;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class ListadoComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JComboBox cbxTipos;
	private JTable table;
	private Object rows[];
	private Componente selected = null;
	private JButton btnMostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoComponente dialog = new ListadoComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoComponente() {
		setTitle("Lista de componente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoComponente.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setBounds(100, 100, 667, 422);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 96, 626, 236);
		contentPanel.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(0, 0, 626, 236);
		panel.add(scrollPane,BorderLayout.CENTER);
		{
			String[] headers = {"Numero de Serie","Marca","Precio", "Cantidad", "Tipo"};
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					if(index>=0){
						btnMostrar.setEnabled(true);
						String serial = table.getValueAt(index, 0).toString();
						selected = TiendaElite.getInstance().buscarComponenteBySerial(serial);
					}
					
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			table.setModel(model);
		}

		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 626, 74);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		cbxTipos = new JComboBox();
		cbxTipos.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbxTipos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				loadComponentes(cbxTipos.getSelectedIndex());
			}
		});
		
		
		cbxTipos.setModel(new DefaultComboBoxModel(
				new String[] { "<Todos>", "Tarjeta Madre", "Memoria RAM", "Disco Duro", "CPU" }));
		cbxTipos.setBounds(183, 24, 158, 25);
		panel_1.add(cbxTipos);

		JLabel lblTipo = new JLabel("Tipo de componente:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(35, 17, 151, 36);
		panel_1.add(lblTipo);
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
				
				btnMostrar = new JButton("Mostrar\r\n");
				btnMostrar.setBackground(SystemColor.info);
				btnMostrar.setEnabled(false);
				btnMostrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MostrarComponente MC = new MostrarComponente(selected);
						MC.setModal(true);
						MC.setVisible(true);
					}
				});
				btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 13));
				buttonPane.add(btnMostrar);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadComponentes(0);
	}

	public void loadComponentes(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if (index == 0) {
			
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				
				if (aux.getDisponibilidad() == 'D') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = "$" + aux.getPrecio();
					rows[3] = aux.getCantidad();
					
					if (aux instanceof TarjetaMadre) {
						rows[4] = "MB";
					}
					if (aux instanceof DiscoDuro) {
						rows[4] = "HDD";
					}
					if (aux instanceof Microprocesador) {
						rows[4] = "CPU";
					}
					if (aux instanceof MemoriaRAM) {
						rows[4] = "RAM";
					}
					
				}
					model.addRow(rows);
					
			}
			
		}
		if (index == 1) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				
				
					if (aux instanceof TarjetaMadre && aux.getDisponibilidad() == 'D') {
						rows[0] = aux.getNumeroSerie();
						rows[1] = aux.getMarca();
						rows[2] = "$" + aux.getPrecio();
						rows[3] = aux.getCantidad();
						rows[4] = "MB";
						model.addRow(rows);
					}
				
				
			}
		}
		if (index == 2) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				
					
					if (aux instanceof MemoriaRAM && aux.getDisponibilidad() == 'D') {
						rows[0] = aux.getNumeroSerie();
						rows[1] = aux.getMarca();
						rows[2] = "$" + aux.getPrecio();
						rows[3] = aux.getCantidad();
						rows[4] = "RAM";
						model.addRow(rows);
					}
				
			}
		}
		if (index == 3) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				
					if (aux instanceof DiscoDuro && aux.getDisponibilidad() == 'D') {
						rows[0] = aux.getNumeroSerie();
						rows[1] = aux.getMarca();
						rows[2] = "$" + aux.getPrecio();
						rows[3] = aux.getCantidad();
						rows[4] = "HDD";
						model.addRow(rows);
					}
					
				
				
			}
		}
		if (index == 4) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				
					if (aux instanceof Microprocesador && aux.getDisponibilidad() == 'D') {
						rows[0] = aux.getNumeroSerie();
						rows[1] = aux.getMarca();
						rows[2] = "$" + aux.getPrecio();
						rows[3] = aux.getCantidad();
						rows[4] = "CPU"; 
						model.addRow(rows);
					}
				
				
				
			}
		}
	}
	
}