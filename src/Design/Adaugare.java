package Design;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import Clase.*;


//CLASA PENTRU ADAUGAREA DE COLETE
public class Adaugare extends JFrame {
	private JPanel contentPane;
	private JTextField txtNumeExp;
	private JTextField txtAdresaExp;
	private JTextField txtTelefonExp;
	private JTextField txtNumeDest;
	private JTextField txtAdresaDest;
	private JTextField txtTelefonDest;
	private JTextField txtGreutate;
	private JTextField txtNumeColet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Adaugare frame = new Adaugare();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//FUNCTIA CARE PREIA ADRESA DE UNDE VA PLECA COLETUL
	public void update(String location)
	{
		txtAdresaExp.setText(location);
		txtAdresaExp.enable(false);
	}
	


	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Adaugare() throws IOException {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nume Expeditor");
		lblNewLabel.setBounds(10, 30, 144, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adresa Expeditor");
		lblNewLabel_1.setBounds(10, 55, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon Expeditor");
		lblNewLabel_2.setBounds(10, 80, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nume Destinatar");
		lblNewLabel_3.setBounds(10, 105, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Adresa Destinatar");
		lblNewLabel_4.setBounds(10, 130, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefon Destinatar");
		lblNewLabel_5.setBounds(10, 155, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Greutate");
		lblNewLabel_6.setBounds(10, 180, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tip Colet");
		lblNewLabel_7.setBounds(10, 205, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		txtNumeColet = new JTextField();
		txtNumeColet.setBounds(101, 2, 86, 20);
		contentPane.add(txtNumeColet);
		txtNumeColet.setColumns(10);
		
		txtNumeExp = new JTextField();
		txtNumeExp.setBounds(101, 27, 86, 20);
		contentPane.add(txtNumeExp);
		txtNumeExp.setColumns(10);
		
		txtAdresaExp = new JTextField();
		txtAdresaExp.setBounds(101, 52, 86, 20);
		contentPane.add(txtAdresaExp);
		txtAdresaExp.setColumns(10);
		
		txtTelefonExp = new JTextField();
		txtTelefonExp.setBounds(101, 77, 86, 20);
		contentPane.add(txtTelefonExp);
		txtTelefonExp.setColumns(10);
		
		txtNumeDest = new JTextField();
		txtNumeDest.setBounds(101, 102, 86, 20);
		contentPane.add(txtNumeDest);
		txtNumeDest.setColumns(10);
		
		txtAdresaDest = new JTextField();
		txtAdresaDest.setBounds(101, 127, 86, 20);
		contentPane.add(txtAdresaDest);
		txtAdresaDest.setColumns(10);
		
		txtTelefonDest = new JTextField();
		txtTelefonDest.setBounds(101, 152, 86, 20);
		contentPane.add(txtTelefonDest);
		txtTelefonDest.setColumns(10);
		
		txtGreutate = new JTextField();
		txtGreutate.setBounds(101, 177, 86, 20);
		contentPane.add(txtGreutate);
		txtGreutate.setColumns(10);
		
		JComboBox comboTipColet = new JComboBox(TipColet.values());
		comboTipColet.setBounds(99, 201, 88, 22);
		contentPane.add(comboTipColet);
		
		//FUNCTIA CARE CAUTA O RUTA DUPA ADRESELE INTRODUSE
		JButton btnCautaRuta = new JButton("Cauta Ruta");
		btnCautaRuta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String NumeColet=txtNumeColet.getText();
				String NumeExpeditor=txtNumeExp.getText();
				String AdresaExpeditor=txtAdresaExp.getText();
				String TelefonExpeditor=txtTelefonExp.getText();
				String NumeDestinatar=txtNumeDest.getText();
				String AdresaDestinatar=txtAdresaDest.getText();
				String TelefonDestinatar=txtTelefonDest.getText();
				String Greutate=txtGreutate.getText();
				TipColet tip=(TipColet)comboTipColet.getSelectedItem();
				Colet colet=new Colet(NumeColet,new Client(NumeExpeditor,AdresaExpeditor,TelefonExpeditor),new Client(NumeDestinatar,AdresaDestinatar,TelefonDestinatar),Greutate,tip,"");
				Gson gson=new Gson();
				String json=gson.toJson(colet);
				Ruta r=new Ruta();
				r.update(json);
				r.setContentPane(r.getContentPane());
				r.setVisible(true);
				//dispose();
				
				
				
			}
		});
		btnCautaRuta.setBounds(98, 281, 124, 23);
		contentPane.add(btnCautaRuta);
		
		JLabel lblNewLabel_8 = new JLabel("Nume colet");
		lblNewLabel_8.setBounds(10, 5, 86, 14);
		contentPane.add(lblNewLabel_8);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnCancel.setBounds(305, 281, 124, 23);
		contentPane.add(btnCancel);
		
	
	}
}