package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Factura;
import logico.TiendaElite;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListaFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model;
	private static Object row[];
	private Factura selected = null;
	private Facturar fac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaFactura dialog = new ListaFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog. 
	 */
	public ListaFactura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaFactura.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Listado de Facturas");
		setBounds(100, 100, 624, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 608, 287);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane ListFacturasPane = new JScrollPane();
			ListFacturasPane.setBounds(10, 11, 588, 265);
			ListFacturasPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(ListFacturasPane);
			{
				String headers[] = {"Codigo", "Cliente", "Cantidad de componentes", "Total"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(headers);
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e)
					{
						int index = table.getSelectedRow();
						
						if(index >= 0)
						{
							String codigo = table.getValueAt(index, 0).toString();
							selected = TiendaElite.getInstance().buscarFacturaBycodigo(codigo);
							
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(model);
				ListFacturasPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadFacturas(0);
	}
	
	public static void loadFacturas(int index)
	{
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		
		if(index == 0)
		{
			for(Factura aux : TiendaElite.getInstance().getMisFacturas())
			{
				row[0] = aux.getCodigo();
				row[1] = aux.getCliente().getNombre();
				row[2] = aux.ComponentesVendidos();
				row[3] = "$" + aux.precioFactura();
				
				model.addRow(row);
			}
		}
	}
	
	
}
