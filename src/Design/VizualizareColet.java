package Design;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clase.Colet;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;


//FRAME-UL IN CARE POTI VIZUALIZA DATELE DESPRE UN COLET SI SA II SCHIMB STATUSUL,RESPECTIV SA ANULEZI O COMANDA
public class VizualizareColet extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeColet;
	private JTextField txtNumeExpeditor;
	private JTextField txtAdresaExpeditor;
	private JTextField txtTelefonExpeditor;
	private JTextField txtNumeDestinatar;
	private JTextField txtAdresaDestinatar;
	private JTextField txtTelefonDestinatar;
	private JTextField txtGreutate;
	private JTextField txtTipColet;
	private JTextField txtStatusColet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VizualizareColet frame = new VizualizareColet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void update(String date)
	{
		Gson gson=new Gson();
		Colet colet=gson.fromJson(date, Colet.class);
		txtNumeColet.setText(colet.getColet());
		txtNumeExpeditor.setText(colet.getNumeDestinatar());
		
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public VizualizareColet() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nume Colet:");
		lblNewLabel.setBounds(21, 60, 122, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume Expeditor:");
		lblNewLabel_1.setBounds(21, 90, 122, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adresa Expeditor:");
		lblNewLabel_2.setBounds(21, 113, 122, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefon Expeditor:");
		lblNewLabel_3.setBounds(21, 136, 122, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nume Destinatar:");
		lblNewLabel_4.setBounds(21, 159, 122, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Adresa Destinatar:");
		lblNewLabel_5.setBounds(21, 182, 122, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefon Destinatar:");
		lblNewLabel_6.setBounds(21, 205, 122, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Greutate:");
		lblNewLabel_7.setBounds(21, 228, 122, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tip Colet:");
		lblNewLabel_8.setBounds(21, 252, 122, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Status Colet:");
		lblNewLabel_9.setBounds(21, 275, 122, 13);
		contentPane.add(lblNewLabel_9);
		
		txtNumeColet = new JTextField();
		txtNumeColet.setBounds(153, 62, 147, 19);
		contentPane.add(txtNumeColet);
		txtNumeColet.setColumns(10);
		
		txtNumeExpeditor = new JTextField();
		txtNumeExpeditor.setBounds(153, 87, 147, 19);
		contentPane.add(txtNumeExpeditor);
		txtNumeExpeditor.setColumns(10);
		
		txtAdresaExpeditor = new JTextField();
		txtAdresaExpeditor.setBounds(153, 110, 147, 19);
		contentPane.add(txtAdresaExpeditor);
		txtAdresaExpeditor.setColumns(10);
		
		txtTelefonExpeditor = new JTextField();
		txtTelefonExpeditor.setBounds(153, 133, 147, 19);
		contentPane.add(txtTelefonExpeditor);
		txtTelefonExpeditor.setColumns(10);
		
		txtNumeDestinatar = new JTextField();
		txtNumeDestinatar.setBounds(153, 156, 147, 19);
		contentPane.add(txtNumeDestinatar);
		txtNumeDestinatar.setColumns(10);
		
		txtAdresaDestinatar = new JTextField();
		txtAdresaDestinatar.setBounds(153, 179, 147, 19);
		contentPane.add(txtAdresaDestinatar);
		txtAdresaDestinatar.setColumns(10);
		
		txtTelefonDestinatar = new JTextField();
		txtTelefonDestinatar.setBounds(153, 202, 147, 19);
		contentPane.add(txtTelefonDestinatar);
		txtTelefonDestinatar.setColumns(10);
		
		txtGreutate = new JTextField();
		txtGreutate.setBounds(153, 225, 147, 19);
		contentPane.add(txtGreutate);
		txtGreutate.setColumns(10);
		
		txtTipColet = new JTextField();
		txtTipColet.setBounds(153, 249, 147, 19);
		contentPane.add(txtTipColet);
		txtTipColet.setColumns(10);
		
		txtStatusColet = new JTextField();
		txtStatusColet.setBounds(153, 272, 147, 19);
		contentPane.add(txtStatusColet);
		txtStatusColet.setColumns(10);
		
		JButton btnNewButton = new JButton("Prelungire statut");
		btnNewButton.setBounds(180, 318, 136, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizare statut");
		btnNewButton_1.setBounds(23, 318, 136, 21);
		contentPane.add(btnNewButton_1);
	}
}
