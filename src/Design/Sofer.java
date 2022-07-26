package Design;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;

//FRAME-UL IN CARE SOFERUL ACTUALIZEAZA LOCATIA CURENTA A COLETULUI RESPECTIV
public class Sofer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Sofer frame = new Sofer();
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
	public Sofer() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(25, 10, 589, 176);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Locatie Curenta:");
		lblNewLabel.setBounds(10, 198, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Status comanda");
		lblNewLabel_1.setBounds(10, 223, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 194, 104, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(106, 220, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Actualizare locatie");
		btnNewButton.setBounds(169, 247, 138, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.setBounds(333, 247, 138, 23);
		contentPane.add(btnNewButton_1);
	}
}
