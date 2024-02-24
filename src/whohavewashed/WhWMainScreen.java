package whohavewashed;

import java.awt.EventQueue;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class WhWMainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhWMainScreen frame = new WhWMainScreen();
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
	public WhWMainScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WhWMainScreen.class.getResource("/img/whw.png")));
		setResizable(false);
		setTitle("WhoHaveWashed?");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WhWMainScreen.class.getResource("/img/Bacground.png")));
		lblNewLabel.setBounds(0, 0, 434, 214);
		contentPane.add(lblNewLabel);
		
		JButton btnRegister = new JButton("Registrar");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				WhWRegister whw = new WhWRegister();
				
				WhWMainScreen.this.dispose();
				whw.setVisible(true);
			
			}
		});
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setIcon(new ImageIcon(WhWMainScreen.class.getResource("/img/diskette.png")));
		btnRegister.setPressedIcon(new ImageIcon(WhWMainScreen.class.getResource("/img/diskette.png")));
		btnRegister.setRolloverIcon(new ImageIcon(WhWMainScreen.class.getResource("/img/diskette2.png")));
		btnRegister.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnRegister.setBounds(41, 225, 140, 50);
		contentPane.add(btnRegister);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				WhWShowScreen showScreen = new WhWShowScreen();
				WhWMainScreen.this.dispose();
				showScreen.setVisible(true);
			
			}
		});
		btnAcessar.setBackground(Color.WHITE);
		btnAcessar.setIcon(new ImageIcon(WhWMainScreen.class.getResource("/img/cartao-de-acesso.png")));
		btnAcessar.setPressedIcon(new ImageIcon(WhWMainScreen.class.getResource("/img/cartao-de-acesso.png")));
		btnAcessar.setRolloverIcon(new ImageIcon(WhWMainScreen.class.getResource("/img/cartao-de-acesso2.png")));
		btnAcessar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnAcessar.setBounds(252, 225, 140, 50);
		contentPane.add(btnAcessar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(WhWMainScreen.class.getResource("/img/whw.png")));
		lblNewLabel_1.setBounds(191, 225, 51, 50);
		contentPane.add(lblNewLabel_1);
	}
}
