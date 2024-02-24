package whohavewashed;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import whwnit.WhWNIT;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class WhWRegister extends JFrame {

	private JPanel contentPane;
	private JTextField txtData;
	private JTextField txtOutraPessoa;
	@SuppressWarnings("rawtypes")
	private JComboBox txtRefeicao;
	private JTextField txtTipo;
	private JTextField txtTamanho;
	public JTextArea txtAreaLouca = new JTextArea();
	public JLabel lblCopiado = new JLabel("");
	public JTextArea txtAreaOutros = new JTextArea();
	public JLabel lblCopiado2 = new JLabel("");
	
	public String dtLouca(String data) {
		
		String dia = txtData.getText().substring(0,2);
		String mes = txtData.getText().substring(3,5);
		String ano = txtData.getText().substring(6);
		String dtLouca = ano+"-"+mes+"-"+dia;
		System.out.println(dtLouca);
		
		return dtLouca;
	}

	/**
	 * Launch the application.
	 */
	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
			mask.setPlaceholderCharacter('_');
		}catch(java.text.ParseException ex) {
			System.err.println(ex);
		}
		return mask;
	}
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
					WhWRegister frame = new WhWRegister();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WhWRegister() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(WhWRegister.class.getResource("/img/whw.png")));
		setTitle("WhoHaveWashed?");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 536);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Date dataT = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		String dataHj = formatador.format(dataT);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtAreaLouca.setText("");
			
			}
		});
		
		JButton btnCopy2 = new JButton("");
		btnCopy2.setIcon(new ImageIcon(WhWRegister.class.getResource("/img/copy2.png")));
		btnCopy2.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/copy.png")));
		btnCopy2.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/copy2.png")));
		btnCopy2.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnCopy2.setContentAreaFilled(false);
		btnCopy2.setBorderPainted(false);
		btnCopy2.setBorder(null);
		btnCopy2.setBackground(Color.WHITE);
		btnCopy2.setBounds(669, 204, 35, 35);
		contentPane.add(btnCopy2);
		
		btnCopy2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
		txtAreaLouca.selectAll();
		txtAreaLouca.copy();				
		lblCopiado.setText("Copiado!");
			}
		});
		
		JButton btnCopy = new JButton("");
		btnCopy.setIcon(new ImageIcon(WhWRegister.class.getResource("/img/copy2.png")));
		btnCopy.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/copy.png")));
		btnCopy.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/copy2.png")));
		btnCopy.setBorderPainted(false);
		btnCopy.setBorder(null);
		btnCopy.setContentAreaFilled(false);
		btnCopy.setBackground(Color.WHITE);
		btnCopy.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnCopy.setBounds(670, 449, 33, 35);
		contentPane.add(btnCopy);
		btnCopy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtAreaOutros.selectAll();
				txtAreaOutros.copy();
				lblCopiado2.setText("Copiado!");
			}
		});
		btnLimpar.setIcon(new ImageIcon(WhWRegister.class.getResource("/img/rubber32.png")));
		btnLimpar.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/brubber.png")));
		btnLimpar.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/rubber32.png")));
		btnLimpar.setBorderPainted(false);
		btnLimpar.setBorder(null);
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(666, 163, 35, 35);
		contentPane.add(btnLimpar);
		
		JButton btnLimpar2 = new JButton("");
		btnLimpar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtAreaOutros.setText("");
			
			}
		});
		btnLimpar2.setIcon(new ImageIcon(WhWRegister.class.getResource("/img/rubber32.png")));
		btnLimpar2.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/brubber.png")));
		btnLimpar2.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/rubber32.png")));
		btnLimpar2.setContentAreaFilled(false);
		btnLimpar2.setBorderPainted(false);
		btnLimpar2.setBorder(null);
		btnLimpar2.setBackground(Color.WHITE);
		btnLimpar2.setBounds(666, 409, 35, 35);
		contentPane.add(btnLimpar2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(444, 281, 260, 205);
		contentPane.add(scrollPane);
		
		
		txtAreaOutros.setLineWrap(true);
		txtAreaOutros.setWrapStyleWord(true);
		scrollPane.setViewportView(txtAreaOutros);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(442, 36, 262, 205);
		contentPane.add(scrollPane_1);
		
		
		txtAreaLouca.setLineWrap(true);
		txtAreaLouca.setWrapStyleWord(true);
		scrollPane_1.setViewportView(txtAreaLouca);	
		
		
		lblCopiado.setForeground(Color.GREEN);
		lblCopiado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCopiado.setBounds(646, 11, 57, 14);
		contentPane.add(lblCopiado);
		
		
		lblCopiado2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCopiado2.setForeground(Color.GREEN);
		lblCopiado2.setBounds(646, 256, 57, 14);
		contentPane.add(lblCopiado2);	
		
		JLabel lblNewLabel = new JLabel("Dia:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 62, 35, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPessoa = new JLabel("Pessoa:");
		lblPessoa.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblPessoa.setBounds(137, 62, 57, 20);
		contentPane.add(lblPessoa);
		
		JLabel lblRefeio = new JLabel("Refei\u00E7\u00E3o:");
		lblRefeio.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblRefeio.setBounds(10, 126, 78, 20);
		contentPane.add(lblRefeio);
		
		txtData = new JFormattedTextField((setMascara("**/**/****")));
		txtData.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtData.setBounds(10, 89, 97, 26);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtOutraPessoa = new JTextField();
		txtOutraPessoa.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtOutraPessoa.setColumns(10);
		txtOutraPessoa.setBounds(137, 155, 291, 31);
		contentPane.add(txtOutraPessoa);
		
		txtRefeicao = new JComboBox();
		txtRefeicao.setBackground(Color.WHITE);
		txtRefeicao.setModel(new DefaultComboBoxModel(new String[] {"Caf\u00E9 da Manh\u00E3", "Almo\u00E7o", "Caf\u00E9 da Tarde", "Janta"}));
		txtRefeicao.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtRefeicao.setBounds(10, 157, 117, 29);
		contentPane.add(txtRefeicao);
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JCheckBox btnJulie = new JCheckBox("Julie");
		buttonGroup.add(btnJulie);
		btnJulie.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(btnJulie.isSelected() == true && btnJulie.isSelected()) {
					
					buttonGroup.clearSelection();
				}
			}
		});
		btnJulie.setBounds(331, 62, 97, 23);
		contentPane.add(btnJulie);
		
		JCheckBox btnMae = new JCheckBox("M\u00E3e");
		buttonGroup.add(btnMae);
		btnMae.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(btnMae.isSelected() == true && btnMae.isSelected()) {
					
					buttonGroup.clearSelection();
				}
			}
		});
		btnMae.setBounds(200, 95, 97, 23);
		contentPane.add(btnMae);
		
		JCheckBox btnPaulino = new JCheckBox("Paulino");
		buttonGroup.add(btnPaulino);
		btnPaulino.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(btnPaulino.isSelected() == true && btnPaulino.isSelected()) {
					
					buttonGroup.clearSelection();
				}
			}
		});
		btnPaulino.setBounds(331, 95, 97, 23);
		contentPane.add(btnPaulino);
		
		JCheckBox btnJames = new JCheckBox("James");
		buttonGroup.add(btnJames);
		btnJames.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(btnJames.isSelected() == true) {
					
					buttonGroup.clearSelection();
				}
			}
		  
		});		
		
		btnJames.setBounds(200, 62, 97, 23);
		contentPane.add(btnJames);
		
		JLabel lblNewLabel_3_1 = new JLabel("Outra Pessoa:");
		lblNewLabel_3_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(138, 126, 111, 20);
		contentPane.add(lblNewLabel_3_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(235, 244, 254));
		panel.setBounds(0, 227, 434, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cboxTipo = new JComboBox();
		cboxTipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		cboxTipo.setBackground(new Color(255, 255, 255));
		cboxTipo.setBounds(10, 35, 149, 30);
		panel.add(cboxTipo);
		cboxTipo.setModel(new DefaultComboBoxModel(new String[] {"---", "Copo", "Panela", "Pote", "Prato", "Talher", "Jarra"}));
		
		JLabel lblLoua = new JLabel("Tipo:");
		lblLoua.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoua.setBounds(10, 11, 149, 20);
		panel.add(lblLoua);
		lblLoua.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		txtTipo = new JTextField();
		txtTipo.setBounds(10, 159, 149, 29);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		
		
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setHorizontalAlignment(SwingConstants.CENTER);
		lblTamanho.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblTamanho.setBounds(182, 11, 114, 20);
		panel.add(lblTamanho);
		
		JComboBox cboxTamanho = new JComboBox();
		cboxTamanho.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		cboxTamanho.setModel(new DefaultComboBoxModel(new String[] {"---", "Pequeno", "M\u00E9dio", "Grande", "Enorme"}));
		cboxTamanho.setBackground(Color.WHITE);
		cboxTamanho.setBounds(182, 35, 114, 30);
		panel.add(cboxTamanho);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidade.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblQuantidade.setBounds(320, 11, 104, 20);
		panel.add(lblQuantidade);
		
		JSpinner spnQnt = new JSpinner();
		spnQnt.setBounds(320, 35, 104, 30);
		panel.add(spnQnt);
		
		JSpinner spnQnt2 = new JSpinner();
		spnQnt2.setBounds(320, 158, 104, 30);
		panel.add(spnQnt2);					
		
		txtTamanho = new JTextField();
		txtTamanho.setColumns(10);
		txtTamanho.setBounds(182, 159, 114, 29);
		panel.add(txtTamanho);
		

		JLabel lblLoua_2 = new JLabel("Tipo:");
		lblLoua_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoua_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblLoua_2.setBounds(10, 128, 149, 20);
		panel.add(lblLoua_2);
		
		JLabel lblTamanho_1 = new JLabel("Tamanho:");
		lblTamanho_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTamanho_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblTamanho_1.setBounds(182, 128, 114, 20);
		panel.add(lblTamanho_1);
		
		JLabel lblQuantidade_1 = new JLabel("Quantidade:");
		lblQuantidade_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidade_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblQuantidade_1.setBounds(320, 127, 104, 20);
		panel.add(lblQuantidade_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(225, 244, 254));
		panel_1_1.setBounds(0, 87, 434, 30);
		panel.add(panel_1_1);
		
		JLabel lblLoua_1 = new JLabel("Outro:");
		lblLoua_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblLoua_1.setBounds(200, 4, 45, 20);
		panel_1_1.add(lblLoua_1);
		
		JButton btnTransOu = new JButton("");
		btnTransOu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String outrosW;
				String qtdW2 = spnQnt2.getValue().toString();
				outrosW = qtdW2 + " " + txtTipo.getText() + "(s)" + " " + txtTamanho.getText() + "(s)";
				txtAreaOutros.append("\n"+outrosW);
			}
		});
		btnTransOu.setIcon(new ImageIcon(WhWRegister.class.getResource("/img/right-arrow (1).png")));
		btnTransOu.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/right-arrow.png")));
		btnTransOu.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/right-arrow (1).png")));
		btnTransOu.setBackground(new Color(225, 244, 254));
		btnTransOu.setBounds(404, 0, 30, 30);
		panel_1_1.add(btnTransOu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(225, 244, 254));
		panel_1.setBounds(0, 197, 434, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnTransLou = new JButton("");
		btnTransLou.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String qtdW = spnQnt.getValue().toString();
				String tipoW = cboxTipo.getSelectedItem().toString();
				String tamanhoW = cboxTamanho.getSelectedItem().toString();
				String loucaW;
				loucaW = qtdW + " " + tipoW + "(s)" + " " + tamanhoW + "(s)";
				
				txtAreaLouca.append("\n"+loucaW);
			
			}
		});
		btnTransLou.setIcon(new ImageIcon(WhWRegister.class.getResource("/img/right-arrow (1).png")));
		btnTransLou.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/right-arrow.png")));
		btnTransLou.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/right-arrow (1).png")));
		btnTransLou.setBackground(new Color(225, 244, 254));
		btnTransLou.setBounds(404, 0, 30, 30);
		panel_1.add(btnTransLou);
		

		
		//====================================================
		



		//====================================================
		JLabel lblNewLabel_1 = new JLabel("Lou\u00E7a");
		lblNewLabel_1.setBounds(0, 0, 434, 30);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				WhWMainScreen whwms = new WhWMainScreen();
				WhWRegister.this.dispose();
				whwms.setVisible(true);
			
			}
		});
		btnBack.setBounds(10, 11, 40, 40);
		contentPane.add(btnBack);
		btnBack.setIcon(new ImageIcon(WhWRegister.class.getResource("/img/left.png")));
		btnBack.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/left (1).png")));
		btnBack.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/left.png")));
		btnBack.setBorderPainted(false);
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		
		JLabel lblNewLabel_2 = new JLabel("Novo Registro");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 414, 40);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSalvar = new JButton("      Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				int escolha = JOptionPane.showConfirmDialog(null,"Deseja salvar?");
				if(escolha == 0) {
				
				String pessoaW="";
				if(btnJames.isSelected() == true) {
					pessoaW = "James";
				}else if(btnJulie.isSelected() == true) {
					pessoaW = "Julie";
				}else if(btnMae.isSelected() == true) {
					pessoaW = "Mãe";
				}else if(btnPaulino.isSelected() == true) {
					pessoaW = "Paulino";
				}
				String loucaFinal = txtAreaLouca.getText();
				String outrosFinal = txtAreaOutros.getText();
				String refeicaoFinal = txtRefeicao.getSelectedItem().toString();
				String dataFinal = dtLouca(null);
				String pessoaFinal;
				if(txtOutraPessoa.getText().isEmpty()) {
					pessoaFinal = pessoaW;
				}else {
					pessoaFinal = pessoaW + " & " + txtOutraPessoa.getText();
				}
				
				System.out.println("Dia: "+dataFinal);
				System.out.println("Pessoa: "+pessoaFinal);
				System.out.println("Refeição: "+refeicaoFinal);
				System.out.println("Louça: "+loucaFinal);
				if(!txtAreaOutros.getText().isEmpty()){
				System.out.println("Outros: "+outrosFinal);
				}
				
				WhW whw =  new WhW();
				WhWNIT whwNIT = new WhWNIT();
				
				whw.setDia(dataFinal);
				whw.setPessoa(pessoaFinal);
				whw.setRefeicao(refeicaoFinal);
				whw.setLouca(loucaFinal);
				if(!txtAreaOutros.getText().isEmpty()){
				whw.setOutros(outrosFinal);
				}
				whwNIT.create(whw);
				JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
				}
			}
		});
		btnSalvar.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvar.setIcon(new ImageIcon(WhWRegister.class.getResource("/img/diskette.png")));
		btnSalvar.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/diskette2.png")));
		btnSalvar.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/diskette.png")));
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnSalvar.setBounds(121, 212, 190, 52);
		panel.add(btnSalvar);
		
		JLabel lblNewLabel_3 = new JLabel("Lou\u00E7as:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(444, 0, 260, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("Outros:");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(444, 246, 260, 35);
		contentPane.add(lblNewLabel_3_2);
		
		JButton btnNewButton = new JButton("Hoje");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtData.setText(dataHj);
			
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(41, 62, 66, 23);
		contentPane.add(btnNewButton);
	}
}
