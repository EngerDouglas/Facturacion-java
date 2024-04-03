package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import logico.TiendaElite;
import logico.Cliente;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListaClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model;
	private static Object row[];
	private Cliente selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaClientes dialog = new ListaClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaClientes() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ListaClientes.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Listado de Clientes");
		setBounds(100, 100, 646, 369);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 620, -117);
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 5, 610, 279);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				contentPanel.add(scrollPane);
				{
					String headers[] = { "Cedula", "Nombre", "Direccion", "Telefono" };
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if (index >= 0) {
								String cedula = table.getValueAt(index, 0).toString();
								selected = TiendaElite.getInstance().buscarClienteByCedula(cedula);
							}
						}

					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);

				}

			}

		}

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(SystemColor.info);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBackground(SystemColor.info);
			cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
		
		loadClientes();

	}

	public static void loadClientes() {
		row = new Object[model.getColumnCount()];
		model.setRowCount(0);

		for (Cliente aux : TiendaElite.getInstance().getMisClientes()) {
			row[0] = aux.getCedula();
			row[1] = aux.getNombre();
			row[2] = aux.getTelefono();
			row[3] = aux.getDireccion();
			model.addRow(row);
		}
	}
}
