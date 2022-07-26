package Design;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JButton;


//FRAME-UL CARE AFISEAZA PRETUL ACTUALIZAT DUPA PRELUNGIRE
public class Prelungire extends JFrame {

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
					Prelungire frame = new Prelungire();
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
	public Prelungire() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(133, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pret total");
		lblNewLabel.setBounds(31, 67, 78, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cash");
		btnNewButton.setBounds(31, 117, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Card");
		btnNewButton_1.setBounds(130, 117, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
