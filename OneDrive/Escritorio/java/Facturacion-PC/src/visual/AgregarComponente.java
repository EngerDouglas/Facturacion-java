package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class AgregarComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarComponente dialog = new AgregarComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarComponente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarComponente.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setForeground(new Color(255, 255, 224));
		setBackground(new Color(255, 255, 224));
		setTitle("Agregar Componente");
		setBounds(100, 100, 619, 489);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnTarjetaMadre = new JButton("");
		btnTarjetaMadre.setBackground(new Color(30, 144, 255));
		btnTarjetaMadre.setBounds(174, 31, 121, 101);
		btnTarjetaMadre.setIcon(new ImageIcon(AgregarComponente.class.getResource("/imagenes/icons8-placa-base-96.png")));
		btnTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarTarjetaMadre tarjeta_madre = new AgregarTarjetaMadre();
				tarjeta_madre.setModal(true);
				tarjeta_madre.setVisible(true);
			}
		});
		contentPanel.add(btnTarjetaMadre);
		
		JButton btnMemoriaRam = new JButton("");
		btnMemoriaRam.setBackground(new Color(30, 144, 255));
		btnMemoriaRam.setIcon(new ImageIcon(AgregarComponente.class.getResource("/imagenes/icons8-ranura-de-memoria-96.png")));
		btnMemoriaRam.setBounds(327, 32, 109, 100);
		btnMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarRAM ram = new AgregarRAM();
				ram.setModal(true);
				ram.setVisible(true);
			}
		});
		contentPanel.add(btnMemoriaRam);
		
		JButton btnCPU = new JButton("");
		btnCPU.setBackground(new Color(30, 144, 255));
		btnCPU.setBounds(470, 32, 101, 100);
		btnCPU.setIcon(new ImageIcon(AgregarComponente.class.getResource("/imagenes/icons8-cpu-de-smartphone-96.png")));
		btnCPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarCPU CPU = new AgregarCPU();
				CPU.setModal(true);
				CPU.setVisible(true);
			}
		});
		contentPanel.add(btnCPU);
		
		JLabel lblDiscoDuro = new JLabel("Disco Duro");
		lblDiscoDuro.setBounds(51, 143, 73, 14);
		lblDiscoDuro.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblDiscoDuro);
		
		JLabel lblTarjetaMadre = new JLabel("Tarjeta Madre");
		lblTarjetaMadre.setBounds(188, 143, 112, 14);
		lblTarjetaMadre.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblTarjetaMadre);
		
		JLabel lblRAM = new JLabel("Memoria RAM");
		lblRAM.setBounds(337, 143, 101, 14);
		lblRAM.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblRAM);
		
		JLabel lblCPU = new JLabel("CPU");
		lblCPU.setBounds(507, 143, 37, 14);
		lblCPU.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblCPU);
		
		JButton btnDiscoDuro = new JButton("");
		btnDiscoDuro.setForeground(new Color(30, 144, 255));
		btnDiscoDuro.setBackground(new Color(30, 144, 255));
		btnDiscoDuro.setBounds(30, 31, 116, 101);
		contentPanel.add(btnDiscoDuro);
		btnDiscoDuro.setIcon(new ImageIcon(AgregarComponente.class.getResource("/imagenes/icons8-hdd-96.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 603, 415);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(AgregarComponente.class.getResource("/imagenes/wallpaper clean.png")));
		lblNewLabel.setBounds(0, 160, 603, 255);
		panel.add(lblNewLabel);
		btnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarDiscoDuro disco_duro = new AgregarDiscoDuro();
				disco_duro.setModal(true);
				disco_duro.setVisible(true);
			}
		});
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
	}
}
