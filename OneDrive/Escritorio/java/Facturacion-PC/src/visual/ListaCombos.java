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

import javafx.scene.control.SelectionMode;

import logico.TiendaElite;
import logico.Combo;
import logico.Componente;

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

public class ListaCombos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	private Object rows[];
	private Componente selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaCombos dialog = new ListaCombos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaCombos() {
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
		panel.setBounds(10, 11, 626, 326);
		contentPanel.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(0, 0, 626, 332);
		panel.add(scrollPane,BorderLayout.CENTER);
		{
			String[] headers = {"Codigo","Precio"};
			
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			table.setModel(model);
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
		loadCombos(0);
	}
	public void loadCombos(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
		if(index == 0)
		{
		
		for(Combo aux: TiendaElite.getInstance().getMisCombos()) {
			rows[0] = aux.getCodigo();
			rows[1] = aux.getPrecio();
			model.addRow(rows);
		}
		
		}
	}

	
}