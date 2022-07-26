package Design;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;



//FRAME-UL PENTRU LOGAREA IN APLICATIE
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtAwb;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//FUNCTIA CARE CITESTE DIN FISIERUL "USERS.TXT" SI VERIFICA DACA DATELE INTRODUSE SUNT VALIDE
	public static boolean verif(String user, String pass) throws IOException {
		BufferedReader buff = new BufferedReader(new FileReader("users.txt"));
		String line;
		boolean ok = false;
		while ((line = buff.readLine()) != null) {
			String[] x = line.split(";");
			if (x[0].equals(user) && x[1].equals(pass))

				ok = true;
		}
		if (ok)
			return true;
		return false;

	}

	/**
	 * Create the frame.
	 */
	
	
	
	
	public Login() {
setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 375);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("FastCurier");
		lblNewLabel.setBounds(271, 21, 226, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("AWB");
		lblNewLabel_1.setBounds(10, 58, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtAwb = new JTextField();
		txtAwb.setBounds(66, 58, 558, 20);
		contentPane.add(txtAwb);
		txtAwb.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(72, 154, 558, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_2 = new JLabel("User");
		lblNewLabel_2.setBounds(10, 187, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("pass");
		lblNewLabel_3.setBounds(10, 231, 46, 14);
		contentPane.add(lblNewLabel_3);

		txtUser = new JTextField();
		txtUser.setBounds(72, 184, 558, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		JButton btnCauta = new JButton("Cauta colet");
		btnCauta.setBounds(271, 120, 89, 23);
		contentPane.add(btnCauta);

		
		//FUNCTIA CARE TE TRIMITE IN FRAME-UL "DEPOZIT"
		JButton btnLogare = new JButton("Logare");
		btnLogare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user=txtUser.getText();
				try {
					if (verif(txtUser.getText(),  txtPass.getText())) {						
						Depozit d = new Depozit();
						d.update(user);
						d.setContentPane(d.getContentPane());
						d.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Utilizator gresit");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnLogare.setBounds(271, 282, 89, 23);
		contentPane.add(btnLogare);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(72, 228, 558, 20);
		contentPane.add(txtPass);
	}
}
