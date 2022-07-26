package Design;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import Clase.*;
import Clase.Graph.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Ruta extends JFrame {

	private JPanel contentPane;
	private JTextField txtDetaliiRuta;
	private JTextField txtPret;
	private JTextField txtTimp;
	private String datecolet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Ruta frame = new Ruta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//FUNCTIA CARE SCRIE IN FISIER
	public static void Serial(String file,String text) throws IOException
	{
		File fis=new File(file);
		PrintWriter ceva=new PrintWriter(new FileWriter(fis,true));
		ceva.println(text);
		ceva.close();
	}
	
	
	//FUNCTIA CARE PREIA DATELE DIN FRAME-UL PRECEDENT SI INSEREAZA IN TEXTBOXURILE RESPECTIVE
	public void update(String route)
	{
		datecolet=route;
		Gson gson=new Gson();
		Colet colet=gson.fromJson(route, Colet.class);
		Graf grafic = new Graf(true);
		grafic.CreateGraph(grafic);
		String expeditie=colet.getAdresaExpeditor();
		String destinatie=colet.getAdresaDestinatar();
		
		String CalcRuta=grafic.Dijkstra(expeditie.toString(), destinatie.toString());
		String[] splitter=CalcRuta.split(";");
		String ruta=splitter[0];
		TipColet tip=colet.getTip();
		String tipcolet=String.valueOf(tip);
		int pret=colet.CalcPret(splitter[1],tipcolet);
		txtPret.setText(Integer.toString(pret));		
		double timp=colet.CalcTimp(splitter[1], tipcolet);
		txtTimp.setText(Double.toString(timp));
		
		txtDetaliiRuta.setText(ruta);

	}
	

	
	/**
	 * Create the frame.
	 */
	public Ruta() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Detalii ruta:");
		lblNewLabel.setBounds(52, 42, 57, 14);
		contentPane.add(lblNewLabel);
		
		txtDetaliiRuta = new JTextField();
		txtDetaliiRuta.enable(false);
		txtDetaliiRuta.setBounds(140, 39, 449, 20);
		contentPane.add(txtDetaliiRuta);
		txtDetaliiRuta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pret Total:");
		lblNewLabel_1.setBounds(52, 92, 57, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPret = new JTextField();
		txtPret.enable(false);
		txtPret.setBounds(140, 89, 449, 20);
		contentPane.add(txtPret);
		txtPret.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirma comanda");
		btnNewButton.setBounds(119, 417, 148, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(439, 417, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		//FUNCTIA CARE CONFIRMA DATELE DESPRE COLET SI LE SCRIE IN FISIERELE "COLET.TXT" SI "RUTE.TXT"
		JButton btnConfirmareComanda = new JButton("Confirmare comanda");
		btnConfirmareComanda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Gson gson=new Gson();
				AWBGenerator  gen=new AWBGenerator();
				String AWB=gen.AWB();
				Colet colet=gson.fromJson(datecolet, Colet.class);
				colet.setAWB(AWB);
				System.out.println(colet.getAWB());
				String jsonColet=gson.toJson(colet);
				System.out.println(jsonColet);
				try {
					Serial("colet.txt",jsonColet);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String ruta=txtDetaliiRuta.getText();
				String pret=txtPret.getText();
				String timp=txtTimp.getText();
				DateColet date=new DateColet(AWB,ruta,pret,timp,StatusColet.valueOf("IN_TRANZIT_DIRECT"));
				String jsonDateColet=gson.toJson(date);
				try {
					Serial("rute.txt",jsonDateColet);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					JOptionPane.showMessageDialog(contentPane, "Datele despre colet au fost introduse corect!");
					dispose();				
			}
		});
		btnConfirmareComanda.setBounds(140, 158, 164, 23);
		contentPane.add(btnConfirmareComanda);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(425, 158, 164, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("Timp estimat:");
		lblNewLabel_2.setBounds(48, 67, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		txtTimp = new JTextField();
		txtTimp.enable(false);
		txtTimp.setBounds(140, 64, 449, 20);
		contentPane.add(txtTimp);
		txtTimp.setColumns(10);
	}
}
