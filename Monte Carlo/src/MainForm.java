import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.apache.commons.math3.util.Precision;

import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame
{	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIzaberiteJednuOd;
	private JLabel lblBrojVrijednosti;
	private JLabel lblBrojDecimala;
	private JLabel lblUpozorenje;
	private JLabel lblUpozorenje2;
	private JLabel lblBrojPi;
	private JLabel lblIzracunatoPi;
	private JLabel lblRacunanje;
	private JLabel lblPoruka;
	private JLabel lblBrojGenerisanihSlucajnih;
	private JLabel lblBrojVrijednostiUnutar;
	private JLabel lblVrijemeRacunanja;
	private Choice choiceDecimale;
	private JButton btnNewButton;
	private JTextField txtBrojVrijednosti;
	private JTextField txtIzracunatoPi;
	private JTextField txtTacnoPi;
	private JTextField txtUkupanBrojVrijednosti;
	private JTextField txtVrijednostiUnutarKruga;
	
	public MainForm()
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
		
		lblIzaberiteJednuOd = new JLabel("Izaberite jednu od opcija:");
		lblIzaberiteJednuOd.setBounds(10, 11, 265, 14);
		lblIzaberiteJednuOd.setForeground(new Color(204, 204, 204));
		lblIzaberiteJednuOd.setFont(new Font("Footlight MT Light", Font.BOLD, 18));
		contentPane.add(lblIzaberiteJednuOd);
		
		lblBrojVrijednosti = new JLabel("1) Broj slucajno generisanih vrijednosti");
		lblBrojVrijednosti.setBounds(10, 50, 291, 14);
		lblBrojVrijednosti.setForeground(new Color(204, 204, 204));
		lblBrojVrijednosti.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		contentPane.add(lblBrojVrijednosti);
		
		lblBrojDecimala = new JLabel("2) Broj decimala");
		lblBrojDecimala.setForeground(new Color(204, 204, 204));
		lblBrojDecimala.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		lblBrojDecimala.setBounds(10, 86, 291, 14);
		contentPane.add(lblBrojDecimala);
		
		txtBrojVrijednosti = new JTextField();
		txtBrojVrijednosti.setBounds(307, 44, 108, 20);
		contentPane.add(txtBrojVrijednosti);
		
		choiceDecimale = new Choice();
		choiceDecimale.setBounds(307, 80, 108, 20);
		choiceDecimale.add("");
		choiceDecimale.add("1");
		choiceDecimale.add("2");
		choiceDecimale.add("3");
		choiceDecimale.add("4");
		choiceDecimale.add("5");
		choiceDecimale.add("6");
		choiceDecimale.add("7");
		choiceDecimale.add("8");
		choiceDecimale.add("9");
		choiceDecimale.add("10");
		contentPane.add(choiceDecimale);
		
		lblUpozorenje = new JLabel("* Mozete izabrati samo jednu opciju!");
		lblUpozorenje.setForeground(new Color(204, 204, 204));
		lblUpozorenje.setFont(new Font("Footlight MT Light", Font.BOLD, 12));
		lblUpozorenje.setBounds(142, 120, 241, 14);
		lblUpozorenje.setVisible(false);
		contentPane.add(lblUpozorenje);
		
		lblUpozorenje2 = new JLabel("* Pogresan unos!");
		lblUpozorenje2.setForeground(new Color(204, 204, 204));
		lblUpozorenje2.setFont(new Font("Footlight MT Light", Font.BOLD, 12));
		lblUpozorenje2.setBounds(425, 45, 150, 14);
		lblUpozorenje2.setVisible(false);
		contentPane.add(lblUpozorenje2);
		
		lblRacunanje = new JLabel("Racunanje...");
		lblRacunanje.setForeground(new Color(204, 204, 204));
		lblRacunanje.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		lblRacunanje.setBounds(10, 165, 291, 14);
		lblRacunanje.setVisible(false);
		contentPane.add(lblRacunanje);
		
		lblPoruka = new JLabel("Molimo Vas da sacekate :)");
		lblPoruka.setForeground(new Color(204, 204, 204));
		lblPoruka.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		lblPoruka.setBounds(10, 190, 291, 14);
		lblPoruka.setVisible(false);
		contentPane.add(lblPoruka);
		
		btnNewButton = new JButton("IZRACUNAJ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblUpozorenje.setVisible(false);
				lblUpozorenje2.setVisible(false);
				
				String brojDecimala = choiceDecimale.getSelectedItem();
				String brojVrijednosti = txtBrojVrijednosti.getText();
				
				if(!brojDecimala.contentEquals("") && !brojVrijednosti.contentEquals(""))
				{
					lblUpozorenje.setVisible(true);
				}
				else if(!brojDecimala.contentEquals(""))
				{
					lblRacunanje.setVisible(true);
					lblPoruka.setVisible(true);
					btnNewButton.setEnabled(false);
					
					int brDecimala = Integer.parseInt(brojDecimala);
					
					new Thread(() -> 
					{
						Simulacija mc = new Simulacija(brDecimala);
						
						SwingUtilities.invokeLater(() -> 
						{
							ispisiRezultat(mc);
						});
					}).start();
				}
				else if(!brojVrijednosti.contentEquals(""))
				{	
					if(!HelpMethods.provjeriBrojVrijednosti(brojVrijednosti))
					{
						lblUpozorenje2.setVisible(true);
					}
					else 
					{
						lblRacunanje.setVisible(true);
						lblPoruka.setVisible(true);
						btnNewButton.setEnabled(false);
						
						long brVrijednosti = Long.parseLong(brojVrijednosti);
					
						new Thread(() -> 
						{
							Simulacija mc = new Simulacija(brVrijednosti);
						
							SwingUtilities.invokeLater(() -> 
							{
								ispisiRezultat(mc);
							});
						}).start();
					}
				}
				
			}
		});
		btnNewButton.setForeground(new Color(31, 0, 51));
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBounds(10, 119, 122, 23);
		contentPane.add(btnNewButton);
		
		lblBrojPi = new JLabel("Tacna vrijednost broja PI");
		lblBrojPi.setForeground(new Color(204, 204, 204));
		lblBrojPi.setFont(new Font("Footlight MT Light", Font.BOLD, 16));
		lblBrojPi.setBounds(10, 264, 291, 14);
		lblBrojPi.setVisible(false);
		contentPane.add(lblBrojPi);
		
		lblIzracunatoPi = new JLabel("Izracunata vrijednost broja PI");
		lblIzracunatoPi.setForeground(new Color(204, 204, 204));
		lblIzracunatoPi.setFont(new Font("Footlight MT Light", Font.BOLD, 16));
		lblIzracunatoPi.setBounds(10, 229, 291, 14);
		lblIzracunatoPi.setVisible(false);
		contentPane.add(lblIzracunatoPi);
		
		lblBrojGenerisanihSlucajnih = new JLabel("Broj generisanih slucajnih vrijednosti");
		lblBrojGenerisanihSlucajnih.setForeground(new Color(204, 204, 204));
		lblBrojGenerisanihSlucajnih.setFont(new Font("Footlight MT Light", Font.BOLD, 16));
		lblBrojGenerisanihSlucajnih.setBounds(10, 300, 291, 14);
		lblBrojGenerisanihSlucajnih.setVisible(false);
		contentPane.add(lblBrojGenerisanihSlucajnih);
		
		lblBrojVrijednostiUnutar = new JLabel("Broj vrijednosti unutar kruga");
		lblBrojVrijednostiUnutar.setForeground(new Color(204, 204, 204));
		lblBrojVrijednostiUnutar.setFont(new Font("Footlight MT Light", Font.BOLD, 16));
		lblBrojVrijednostiUnutar.setBounds(10, 336, 291, 14);
		lblBrojVrijednostiUnutar.setVisible(false);
		contentPane.add(lblBrojVrijednostiUnutar);
		
		txtIzracunatoPi = new JTextField();
		txtIzracunatoPi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIzracunatoPi.setBounds(307, 223, 297, 23);
		txtIzracunatoPi.setEditable(false);
		txtIzracunatoPi.setVisible(false);
		contentPane.add(txtIzracunatoPi);
		
		txtTacnoPi = new JTextField();
		txtTacnoPi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTacnoPi.setBounds(307, 258, 297, 23);
		txtTacnoPi.setVisible(false);
		txtTacnoPi.setEditable(false);
		contentPane.add(txtTacnoPi);
		
		txtUkupanBrojVrijednosti = new JTextField();
		txtUkupanBrojVrijednosti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUkupanBrojVrijednosti.setBounds(307, 294, 297, 23);
		txtUkupanBrojVrijednosti.setVisible(false);
		txtUkupanBrojVrijednosti.setEditable(false);
		contentPane.add(txtUkupanBrojVrijednosti);
		
		txtVrijednostiUnutarKruga = new JTextField();
		txtVrijednostiUnutarKruga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVrijednostiUnutarKruga.setBounds(307, 330, 297, 23);
		txtVrijednostiUnutarKruga.setVisible(false);
		txtVrijednostiUnutarKruga.setEditable(false);
		contentPane.add(txtVrijednostiUnutarKruga);
		
		lblVrijemeRacunanja = new JLabel("");
		lblVrijemeRacunanja.setForeground(new Color(204, 204, 204));
		lblVrijemeRacunanja.setFont(new Font("Footlight MT Light", Font.PLAIN, 12));
		lblVrijemeRacunanja.setBounds(10, 150, 600, 14);
		lblVrijemeRacunanja.setVisible(false);
		contentPane.add(lblVrijemeRacunanja);
	}
	
	private void ispisiRezultat(Simulacija mc)
	{	
		lblRacunanje.setVisible(false);
		lblPoruka.setVisible(false);
		btnNewButton.setEnabled(true);
		
		lblBrojPi.setVisible(true);
		lblIzracunatoPi.setVisible(true);
		lblBrojGenerisanihSlucajnih.setVisible(true);
		lblBrojVrijednostiUnutar.setVisible(true);
		
		txtIzracunatoPi.setText(String.valueOf(Precision.round(mc.getPiIzracunato(), mc.getBrojDecimala())));
		txtIzracunatoPi.setVisible(true);
		
		txtTacnoPi.setText(String.valueOf(Precision.round(Math.PI, mc.getBrojDecimala())));
		txtTacnoPi.setVisible(true);
		
		txtUkupanBrojVrijednosti.setText(String.valueOf(mc.getUkupanBrojVrijednosti()));
		txtUkupanBrojVrijednosti.setVisible(true);
		
		txtVrijednostiUnutarKruga.setText(String.valueOf(mc.GetBrojVrijednostiUnutarKruga()));
		txtVrijednostiUnutarKruga.setVisible(true);
		
		lblVrijemeRacunanja.setText("Vrijeme racunanja: " + mc.getVrijemeRacunanja() + "ns = " + (double) mc.getVrijemeRacunanja() / 1_000_000 + "ms");
		lblVrijemeRacunanja.setVisible(true);
	}
}
