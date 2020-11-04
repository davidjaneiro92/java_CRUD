package br.com.exemplo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.com.exemplo.model.Leitor;
import br.com.exeplo.dao.LeitorDAO;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblCodigoDoLeitor;
	private JLabel lblNomeDoLeitor;
	private JLabel lblCodigoDoLeitor_2;
	private JLabel lblMenssagem;
	private JTextField txtCodLeitor;
	private JTextField txtNomeLeitor;
	private JComboBox boxTipoLeitor;
	private JButton btnNovo;
	private JButton bbtnSalvar;
	private JButton btnAlterar;
	private JButton btnCunsultar;
	private JButton btnExcluir;
	private JButton btnListar;
	private TextArea txtLista;
	private Leitor leitor;
	private LeitorDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\images.jpg"));
		setTitle("Manuten\u00E7\u00E3o Leitor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoDoLeitor = new JLabel("Codigo do leitor");
		lblCodigoDoLeitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoDoLeitor.setBounds(10, 22, 89, 14);
		contentPane.add(lblCodigoDoLeitor);
		
		lblNomeDoLeitor = new JLabel("Nome do leitor");
		lblNomeDoLeitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeDoLeitor.setBounds(10, 59, 89, 14);
		contentPane.add(lblNomeDoLeitor);
		
		lblCodigoDoLeitor_2 = new JLabel("Tipo do leitor");
		lblCodigoDoLeitor_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoDoLeitor_2.setBounds(10, 97, 89, 14);
		contentPane.add(lblCodigoDoLeitor_2);
		
		lblMenssagem = new JLabel("");
		lblMenssagem.setBorder(new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.darkShadow"), null, UIManager.getColor("Button.light"), null));
		lblMenssagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMenssagem.setBounds(10, 389, 584, 25);
		contentPane.add(lblMenssagem);
		
		txtCodLeitor = new JTextField();
		txtCodLeitor.setBounds(109, 22, 480, 20);
		contentPane.add(txtCodLeitor);
		txtCodLeitor.setColumns(10);
		
		txtNomeLeitor = new JTextField();
		txtNomeLeitor.setColumns(10);
		txtNomeLeitor.setBounds(109, 59, 480, 20);
		contentPane.add(txtNomeLeitor);
		
		boxTipoLeitor = new JComboBox();
		boxTipoLeitor.setModel(new DefaultComboBoxModel(new String[] {"Selecionar uma Op\u00E7\u00E3o", "Aluno ", "Professor", "Adiminitradivo"}));
		boxTipoLeitor.setBounds(109, 97, 480, 20);
		contentPane.add(boxTipoLeitor);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		//------------NOVO============================		
				txtCodLeitor.setText(null);
				txtNomeLeitor.setText(null);
				txtLista.setText(" ");
				boxTipoLeitor.setSelectedIndex(0);
				lblMenssagem.setText(null);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovo.setBounds(10, 159, 89, 23);
		contentPane.add(btnNovo);
		
		bbtnSalvar = new JButton("Salvar");
		bbtnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//-------Salvar==================
				try {
				//criei o objeto leitor para pegar os dado da tela
				leitor = new Leitor();
				leitor.setCodLeitoe(Integer.parseInt(txtCodLeitor.getText()));
				leitor.setNomeLeitor(txtNomeLeitor.getText());
				leitor.setTipoLeitor((String) boxTipoLeitor.getSelectedItem());
				//aqui ele vai abri a conexão
				dao = new LeitorDAO();
				
				dao.salvar(leitor);
				lblMenssagem.setText("Salvo Com Sucesso.");
				}catch(Exception e0) {
					lblMenssagem.setText("Erro ao Gravar"+e0.getMessage());
				}
			}
		});
		bbtnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		bbtnSalvar.setBounds(109, 159, 89, 23);
		contentPane.add(bbtnSalvar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//======alteração=========
				try {
					//criei o objeto leitor para pegar os dado da tela
					leitor = new Leitor();
					leitor.setCodLeitoe(Integer.parseInt(txtCodLeitor.getText()));
					leitor.setNomeLeitor(txtNomeLeitor.getText());
					leitor.setTipoLeitor((String) boxTipoLeitor.getSelectedItem());
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.alterar(leitor);
					lblMenssagem.setText("Alterado Com Sucesso.");
					}catch(Exception e0) {
						lblMenssagem.setText("Erro ao alterar"+e0.getMessage());
					}
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(307, 159, 89, 23);
		contentPane.add(btnAlterar);
		
		btnCunsultar = new JButton("Cunsultar");
		btnCunsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//===========consultar==========================
				try {
					
					dao = new LeitorDAO();
					leitor = dao.consultar(Integer.parseInt(txtCodLeitor.getText()));
					txtNomeLeitor.setText(leitor.getNomeLeitor());
					
					String tipo = leitor.getTipoLeitor();
					
					if(tipo.equals("Aluno")) {
						boxTipoLeitor.setSelectedIndex(1);
						
					}else if(tipo.equals("Professor")) {
						boxTipoLeitor.setSelectedIndex(2);
						
					}else {
						boxTipoLeitor.setSelectedIndex(3);
				
					}
					}catch(Exception e0) {
						lblMenssagem.setText("Erro ao Listar "+e0.getMessage());
					}
			}
		});
		btnCunsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCunsultar.setBounds(208, 159, 89, 23);
		contentPane.add(btnCunsultar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==============Excluir=====================
				try {
					
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.excluir(Integer.parseInt(txtCodLeitor.getText()));
					
					lblMenssagem.setText("Excluido Com Sucesso.");
					}catch(Exception e0) {
						lblMenssagem.setText("Erro ao Excluir "+e0.getMessage());
					}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBounds(406, 159, 89, 23);
		contentPane.add(btnExcluir);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=======listar===========
				try {
				ArrayList<Leitor> lista = new ArrayList<Leitor>();
				dao = new LeitorDAO();
				lista = dao.listarTodos();
				for(Leitor leitor : lista) {
					txtLista.append("Código do Leitor... "+leitor.getCodLeitoe()+"\n");
					txtLista.append("Nome do Leitor..... "+leitor.getNomeLeitor()+"\n");
					txtLista.append("Tipo do Leitor..... "+leitor.getTipoLeitor()+"\n\n");
				}
				}catch(Exception e0) {
					lblMenssagem.setText("Erro ao Listar "+e0.getMessage());
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.setBounds(505, 159, 89, 23);
		contentPane.add(btnListar);
		
		txtLista = new TextArea();
		txtLista.setBounds(10, 191, 579, 192);
		contentPane.add(txtLista);
	}
}
