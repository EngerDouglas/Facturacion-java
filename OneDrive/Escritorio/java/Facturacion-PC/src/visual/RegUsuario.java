package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import logico.Control;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtnombre;
	private JTextField txtPassword;
	private JTextField txtConfirmarPass;
	private JComboBox cbxTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(RegUsuario.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Registrar Usuario\r\n");
		setBounds(100, 100, 450, 228);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreUsuario.setBounds(20, 26, 116, 14);
		contentPanel.add(lblNombreUsuario);

		txtnombre = new JTextField();
		txtnombre.setBounds(20, 49, 127, 20);
		contentPanel.add(txtnombre);
		txtnombre.setColumns(10);

		cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Administrador", "Comercial" }));
		cbxTipo.setBounds(20, 113, 127, 20);
		contentPanel.add(cbxTipo);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(20, 88, 97, 14);
		contentPanel.add(lblTipo);

		JPasswordField passwordField = new JPasswordField(20);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(190, 49, 147, 20);
		contentPanel.add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(189, 26, 97, 14);
		contentPanel.add(lblPassword);

		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
		lblConfirmarPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmarPassword.setBounds(189, 88, 167, 14);
		contentPanel.add(lblConfirmarPassword);

		txtConfirmarPass = new JPasswordField();
		txtConfirmarPass.setColumns(10);
		txtConfirmarPass.setBounds(190, 113, 147, 20);
		contentPanel.add(txtConfirmarPass);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.info);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				okButton.setBackground(SystemColor.info);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!Control.getInstance().userExist(txtnombre.getText())) {
							if(txtPassword.getText().equalsIgnoreCase(txtConfirmarPass.getText())){
								User user = new User(cbxTipo.getSelectedItem().toString(),txtnombre.getText(),txtPassword.getText());
							    Control.getInstance().regUser(user);
							    clear();
							    
							    JOptionPane.showMessageDialog(null, "Usuario agreagdo", "Informacion",JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden intente otra vez!", "Error",JOptionPane.ERROR_MESSAGE);
								clear();
							}
						
						}else {
							JOptionPane.showMessageDialog(null, "Este usuario ya exite intente otro nombre!", "Error",JOptionPane.ERROR_MESSAGE);
							clear();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.setBackground(SystemColor.info);
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

	public void clear() {
		txtConfirmarPass.setText("");
		txtPassword.setText("");
		txtnombre.setText("");
		cbxTipo.setSelectedIndex(0);
	}
}
