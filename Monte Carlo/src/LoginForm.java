import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPerformanseRaunarskihSistema;
	private JLabel lblTatjanaTomic;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	public LoginForm() 
	{
		initialize();
	}
	
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("MONTE CARLO SIMULACIJA");
		lblNewLabel.setForeground(new Color(204, 204, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Footlight MT Light", Font.BOLD, 40));
		lblNewLabel.setBounds(40, 49, 550, 44);
		contentPane.add(lblNewLabel);
		
		lblPerformanseRaunarskihSistema = new JLabel("PERFORMANSE RACUNARSKIH SISTEMA");
		lblPerformanseRaunarskihSistema.setForeground(new Color(204, 204, 204));
		lblPerformanseRaunarskihSistema.setFont(new Font("Footlight MT Light", Font.BOLD, 22));
		lblPerformanseRaunarskihSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerformanseRaunarskihSistema.setBounds(60, 119, 514, 58);
		contentPane.add(lblPerformanseRaunarskihSistema);

		lblTatjanaTomic = new JLabel("Tatjana Tomic 1182/16");
		lblTatjanaTomic.setForeground(new Color(204, 204, 204));
		lblTatjanaTomic.setHorizontalAlignment(SwingConstants.CENTER);
		lblTatjanaTomic.setFont(new Font("Footlight MT Light", Font.BOLD, 20));
		lblTatjanaTomic.setBounds(60, 172, 514, 33);
		contentPane.add(lblTatjanaTomic);

		btnNewButton = new JButton("START");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressedStart();
			}
		});
		btnNewButton.setForeground(new Color(31, 0, 51));
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.setBounds(257, 258, 118, 44);
		contentPane.add(btnNewButton);
	}
	
	private void mousePressedStart() {
		MainForm mf = new MainForm();
		mf.setVisible(true);
		this.dispose();
	}
}
