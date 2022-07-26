package Design;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import Clase.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;


//FRAME-UL IN CARE POTI VIZUALIZA TOATE COLETELE DIN SISTEM
public class Depozit extends JFrame {
	private JPanel contentPane;
	private String user;
	private JButton btnVizualizareColet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Depozit frame = new Depozit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public void update(String str)
	{
		user=str;
	}
	
	
	public Depozit() {

		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//FUNCTIA CARE INSEREAZA IN JList DATELE DIN FISIERUL COLET.TXT
		DefaultListModel listModel=new DefaultListModel();
		JList list = new JList(listModel);
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLACK);
		/*list.setBounds(10, 11, 941, 241);
		contentPane.add(list);*/
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				listModel.clear();
				Gson gson=new Gson();
			try {
				BufferedReader buff=new BufferedReader(new FileReader("colet.txt"));
				String line;
				
				while((line=buff.readLine())!=null)
				{
					Colet colet=gson.fromJson(line, Colet.class);
					listModel.addElement(colet);			
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int lastindex=listModel.getSize()-1;
			if(lastindex>=0)
			list.ensureIndexIsVisible(lastindex);
			revalidate();
			}
		});
		
		
		//FUNCTIA CARE TE TRIMITE IN FRAME-UL "ADAUGARE"
		JButton btnAdaugareColet = new JButton("Adaugare colet");
		btnAdaugareColet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Adaugare a=new Adaugare();
					a.update(user);
					a.setContentPane(a.getContentPane());
					a.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdaugareColet.setBounds(10, 329, 269, 23);
		contentPane.add(btnAdaugareColet);
		
		
		//FUNCTIA CARE TE LASA SA VIZUALIZEZI UN COLET
		btnVizualizareColet = new JButton("Vizualizare colet");
		btnVizualizareColet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				if(list.isSelectionEmpty())
					JOptionPane.showMessageDialog(contentPane, "Nu ati ales un colet");
				else {
				String datecolet=list.getModel().getElementAt(list.getSelectedIndex()).toString();
				Gson gson=new Gson();
				String jsonDateColet=gson.toJson(datecolet);
				System.out.println(jsonDateColet);
				VizualizareColet viz=new VizualizareColet();
				viz.update(jsonDateColet);
				viz.setContentPane(viz.getContentPane());
				viz.setVisible(true);
				
				}
				
			}
		});
		btnVizualizareColet.setBounds(351, 329, 269, 23);
		contentPane.add(btnVizualizareColet);
		
		//FUNCTIA CARE TE TRIMITE LA FRAME-UL "VIZUALIZARE COLET"
		JButton btnDelogare = new JButton("Delogare");
		btnDelogare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login log=new Login();
				log.setContentPane(log.getContentPane());
				log.setVisible(true);
				dispose();
			}
		});
		btnDelogare.setBounds(682, 329, 269, 23);
		contentPane.add(btnDelogare);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 11, 941, 241);
		contentPane.add(scrollPane);
	}
}