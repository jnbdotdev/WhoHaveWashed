package whohavewashed;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import connection.ConnectionWHW;
import models.WhWTableModel;
import whwnit.WhWNIT;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class WhWShowScreen extends JFrame {
	
	ConnectionWHW conecta =  new ConnectionWHW();
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtPesquisa;
	private JTextField txtCod;

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
					WhWShowScreen frame = new WhWShowScreen();
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
	public String dtW(String data) throws SQLException {
		
		String dia = conecta.rs.getString("dia").substring(8,10);
		String mes = conecta.rs.getString("dia").substring(5,7);
		String ano = conecta.rs.getString("dia").substring(0,4);
		String dtW = dia+"/"+mes+"/"+ano;
		
		return dtW;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WhWShowScreen() {
		conecta.conexao();
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(WhWShowScreen.class.getResource("/img/whw.png")));
		setTitle("WhoHaveWashed?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbxPesquisa = new JComboBox();
		cbxPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Cod","Dia", "Pessoa", "Refei\u00E7\u00E3o", "Lou\u00E7a", "Outros"}));
		cbxPesquisa.setBackground(Color.WHITE);
		cbxPesquisa.setBounds(453, 331, 95, 33);
		contentPane.add(cbxPesquisa);
		
		JLabel lblNewLabel = new JLabel("Registros");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(9, 21, 581, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				WhWMainScreen whwms = new WhWMainScreen();
				WhWShowScreen.this.dispose();
				whwms.setVisible(true);
			
			}
		});
		btnBack.setIcon(new ImageIcon(WhWShowScreen.class.getResource("/img/left.png")));
		btnBack.setRolloverIcon(new ImageIcon(WhWRegister.class.getResource("/img/left (1).png")));
		btnBack.setPressedIcon(new ImageIcon(WhWRegister.class.getResource("/img/left.png")));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setBorder(null);
		btnBack.setBounds(4, 17, 40, 40);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 581, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setGridColor(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indice = table.getSelectedRow();
				txtCod.setText(table.getValueAt(indice, 0).toString());
				int colunaW = table.getSelectedColumn();
				if(colunaW == 4) {
					int choice = JOptionPane.showConfirmDialog(null,"Deseja detalhes sobre este campo?");
					if(choice == 0) {
						String LouW  = table.getValueAt(indice, 4).toString();
						JOptionPane.showMessageDialog(null,LouW,"Louça: ", JOptionPane.DEFAULT_OPTION);
					}
				}
				if(colunaW == 5) {
					int choice = JOptionPane.showConfirmDialog(null,"Deseja detalhes sobre este campo?");
					if(choice == 0) {
						String OuW  = table.getValueAt(indice, 5).toString();
						JOptionPane.showMessageDialog(null,OuW, "Outros: ",JOptionPane.DEFAULT_OPTION);
					}
				}
			}
		});

		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		@SuppressWarnings("unused")
		String itemS = cbxPesquisa.getSelectedItem().toString();
		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				if(e.getKeyCode() == KeyEvent.VK_ENTER ){	
					String itemS = cbxPesquisa.getSelectedItem().toString();
					if(itemS == "Cod") {
					preencherTabela("select * from WhW where cod like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Dia") {
					preencherTabela("select * from WhW where dia like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Pessoa") {
					preencherTabela("select * from WhW where pessoa like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Refeição") {
					preencherTabela("select * from WhW where refeicao like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Louça") {
					preencherTabela("select * from WhW where louca like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Outros") {
					preencherTabela("select * from WhW where outros like '%"+txtPesquisa.getText()+"%'");
					}
					
				}
			
			}
		});
		txtPesquisa.setBounds(102, 331, 442, 33);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pesquisar: ");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 331, 82, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir permanentemente?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(resposta == 0) {
					WhWNIT whwNIT = new WhWNIT();
					whwNIT.excluirPorCodigo(Integer.parseInt(txtCod.getText()));
				}
				preencherTabela("select * from WhW");
			
			}
		});
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setIcon(new ImageIcon(WhWShowScreen.class.getResource("/img/icons8-delete-file-30.png")));
		btnExcluir.setRolloverIcon(new ImageIcon(WhWShowScreen.class.getResource("/img/icons8-delete-file-30 (1).png")));
		btnExcluir.setPressedIcon(new ImageIcon(WhWShowScreen.class.getResource("/img/icons8-delete-file-30.png")));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBounds(558, 35, 33, 33);
		contentPane.add(btnExcluir);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String itemS = cbxPesquisa.getSelectedItem().toString();
				if(itemS == "Cod") {
					preencherTabela("select * from WhW where cod like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Dia") {
					preencherTabela("select * from WhW where dia like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Pessoa") {
					preencherTabela("select * from WhW where pessoa like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Refeição") {
					preencherTabela("select * from WhW where refeicao like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Louça") {
					preencherTabela("select * from WhW where louca like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Outros") {
					preencherTabela("select * from WhW where outros like '%"+txtPesquisa.getText()+"%'");
					}
			
				/*
			for(int i=0;i<table.getRowCount();i++)
				
				try {
					String pesquisa = "select * from animes where nome like '"+ textField.getText()+"%'";
					conecta.executaSQL(pesquisa);
					if(conecta.rs.first()) {
						
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
			}
		});
		btnPesquisar.setIcon(new ImageIcon(WhWShowScreen.class.getResource("/img/icons8-search-23.png")));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setBounds(557, 331, 33, 33);
		contentPane.add(btnPesquisar);
		
		txtCod = new JTextField();
		txtCod.setBounds(558, 6, 33, 25);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		preencherTabela("select * from WhW");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public void preencherTabela(String Sql) {
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"Cod","Dia","Pessoa","Refeição","Louça","Outros"};
		
		conecta.executaSQL(Sql);
		try {
			if(conecta.rs.next() == true) {
				try {
					conecta.rs.first();
					do {
						dados.add(new Object[] {
								conecta.rs.getInt("cod"),
								dtW(conecta.rs.getString("dia")),
								conecta.rs.getString("pessoa"),
								conecta.rs.getString("refeicao"),
								conecta.rs.getString("louca"),
								conecta.rs.getString("outros")});
					}while(conecta.rs.next());
				}catch  (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao preencher tabela");
				}
			}
		}catch (HeadlessException | SQLException e) {
				
			e.printStackTrace();
		}
		WhWTableModel tableModel = new WhWTableModel(dados, colunas);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(0).setResizable(true);
	
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setResizable(true);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(2).setResizable(true);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setResizable(true);
		
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setResizable(true);
		
		table.getColumnModel().getColumn(5).setPreferredWidth(123);
		table.getColumnModel().getColumn(5).setResizable(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JTable table = ((JTableHeader) evt.getSource()).getTable();
				TableColumnModel tableColumnModel = table.getColumnModel();
				int colunaCabecalho = tableColumnModel.getColumnIndexAtX(evt.getX());
				if (colunaCabecalho == 0) {
					preencherTabela("select * from WhW order by cod asc");
					if(colunaCabecalho == 0 && evt.getClickCount() == 2) {
						preencherTabela2("select * from WhW order by cod desc");
					}
				}else if (colunaCabecalho == 1) {
					preencherTabela("select * from WhW order by dia asc");
					if(colunaCabecalho == 1 && evt.getClickCount() == 2) {
						preencherTabela2("select * from WhW order by dia desc");
					}
				}else if (colunaCabecalho == 2) {
					preencherTabela("select * from WhW order by pessoa asc");
					if(colunaCabecalho == 2 && evt.getClickCount() == 2) {
						preencherTabela2("select * from WhW order by pessoa desc");
					}
				}else if (colunaCabecalho == 3) {
					preencherTabela("select * from WhW order by refeicao asc");
					if(colunaCabecalho == 3 && evt.getClickCount() == 2) {
						preencherTabela2("select * from WhW order by refeicao desc");
					}
				}else if (colunaCabecalho == 4) {
					preencherTabela("select * from WhW order by louca asc");
					if(colunaCabecalho == 4 && evt.getClickCount() == 2) {
						preencherTabela2("select * from WhW order by louca desc");
					}
				}else if (colunaCabecalho == 5) {
					preencherTabela("select * from WhW order by outros asc");
					if(colunaCabecalho == 5 && evt.getClickCount() == 2) {
						preencherTabela2("select * from WhW order by outros desc");
					}
				}
			}
		});
		}
	@SuppressWarnings({ "rawtypes", "unchecked", "unused", "static-access" })
	public void preencherTabela2(String Sql) {
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"Cod","Data","Pessoa","Refeição","Louça","Outros"};
		
		conecta.executaSQL(Sql);
		try {
			if(conecta.rs.next() == true) {
				try {
					conecta.rs.first();
					do {
						dados.add(new Object[] {
								conecta.rs.getInt("cod"),
								dtW(conecta.rs.getString("dia")),
								conecta.rs.getString("pessoa"),
								conecta.rs.getString("refeicao"),
								conecta.rs.getString("louca"),
								conecta.rs.getString("outros")});
					}while(conecta.rs.next());
				}catch  (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao preencher tabela");
				}
			}
		}catch (HeadlessException | SQLException e) {
				
			e.printStackTrace();
		}
		WhWTableModel tableModel = new WhWTableModel(dados, colunas);
		table.setModel(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JTableHeader tableHeader = table.getTableHeader();
	}
}
