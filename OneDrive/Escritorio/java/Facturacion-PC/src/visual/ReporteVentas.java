package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Factura;
import logico.TiendaElite;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class ReporteVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtTarjetaMadre;
	private static JTextField txtDiscoDuro;
	private static JTextField txtRAM; 
	private static JTextField txtCPU;
	private static JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteVentas dialog = new ReporteVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteVentas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReporteVentas.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Reporte de Ventas");
		setBounds(100, 100, 482, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Cantidad:");
			lblNewLabel_1.setBounds(221, 30, 138, 14);
			contentPanel.add(lblNewLabel_1);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		{
			txtTarjetaMadre = new JTextField();
			txtTarjetaMadre.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtTarjetaMadre.setBounds(221, 55, 138, 20);
			contentPanel.add(txtTarjetaMadre);
			txtTarjetaMadre.setBackground(Color.WHITE);
			txtTarjetaMadre.setText("0");
			txtTarjetaMadre.setEnabled(false);
			txtTarjetaMadre.setColumns(10);
		}
		{
			JLabel lblTarjetaMadre = new JLabel("Tarjeta Madre:");
			lblTarjetaMadre.setBounds(102, 57, 109, 14);
			contentPanel.add(lblTarjetaMadre);
			lblTarjetaMadre.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		{
			JLabel lblDiscoDuro = new JLabel("Disco Duro:");
			lblDiscoDuro.setBounds(102, 87, 93, 14);
			contentPanel.add(lblDiscoDuro);
			lblDiscoDuro.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		{
			txtDiscoDuro = new JTextField();
			txtDiscoDuro.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtDiscoDuro.setBounds(221, 86, 138, 20);
			contentPanel.add(txtDiscoDuro);
			txtDiscoDuro.setBackground(Color.WHITE);
			txtDiscoDuro.setText("0");
			txtDiscoDuro.setEnabled(false);
			txtDiscoDuro.setColumns(10);
		}
		{
			JLabel lblRAM = new JLabel("Memoria RAM:");
			lblRAM.setBounds(102, 119, 93, 14);
			contentPanel.add(lblRAM);
			lblRAM.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		{
			JLabel lblNewLabel = new JLabel("CPU:");
			lblNewLabel.setBounds(102, 154, 46, 14);
			contentPanel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		{
			txtCPU = new JTextField();
			txtCPU.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtCPU.setBounds(221, 148, 138, 20);
			contentPanel.add(txtCPU);
			txtCPU.setBackground(Color.WHITE);
			txtCPU.setText("0");
			txtCPU.setEnabled(false);
			txtCPU.setColumns(10);
		}
		{
			txtRAM = new JTextField();
			txtRAM.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtRAM.setBounds(221, 117, 138, 20);
			contentPanel.add(txtRAM);
			txtRAM.setBackground(Color.WHITE);
			txtRAM.setText("0");
			txtRAM.setEnabled(false);
			txtRAM.setColumns(10);
		}
		{
			JLabel lblTotal = new JLabel("Total:");
			lblTotal.setBounds(221, 181, 46, 14);
			contentPanel.add(lblTotal);
			lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		{
			txtTotal = new JTextField();
			txtTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtTotal.setBounds(263, 179, 97, 20);
			contentPanel.add(txtTotal);
			txtTotal.setBackground(Color.WHITE);
			txtTotal.setText("0");
			txtTotal.setEnabled(false);
			txtTotal.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 466, 246);
			contentPanel.add(panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadComponentesVendidos();
	}
	
	public static void loadComponentesVendidos()
	{
		int TarjetaMadre = 0;
		int RAM = 0;
		int Microprocesador = 0;
		int DiscoDuro = 0;
		int total = 0;
		
		for(Factura aux : TiendaElite.getInstance().getMisFacturas())
		{
			TarjetaMadre += aux.cantTarjetaMadreVendido();
			RAM += aux.cantMemoriaRAMVendido();
			Microprocesador += aux.cantCPUVendido();
			DiscoDuro += aux.cantDiscoDuroVendido();
		}
		
		total = TarjetaMadre + RAM + Microprocesador + DiscoDuro;
		
		txtTarjetaMadre.setText(String.valueOf(TarjetaMadre));
		txtDiscoDuro.setText(String.valueOf(DiscoDuro));
		txtRAM.setText(String.valueOf(RAM));
		txtCPU.setText(String.valueOf(Microprocesador));
		txtTotal.setText(String.valueOf(total));
		
		
	}

}
