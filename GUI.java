package view;


import java.awt.EventQueue;import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.GerenteGeral;
import model.Visitante;
import model.Jogador;
import model.Partida;
import model.Time;
import model.Torcedor;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
/*@author Elizio e Noel
 * Classe que emplementa a interface grafica
 */
public class GUI extends JFrame {
	GerenteGeral gerente = new GerenteGeral();
	private JPanel contentPane;
	private JTextField loginIni;
	private JPasswordField SenhaIni;
	private JTextField nomeCad;
	private JTextField loginCad;
	private JPasswordField senhaCad;
	private JPasswordField rSenhaCad;
	private JTextField timeCad;
	private JTextField nomeJogador;
	private JPasswordField senhaAtualEditar;
	private JTextField nomeEditar;
	private JPasswordField senhaEditar;
	private JPasswordField reSenhaEditar;

	/**
	 * Aplica鈬o do launch
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 348);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		gerente.getGerentecamp().getTabela().setPartidas(gerente.carregarPartidas());
		gerente.getGerentecamp().setTimesCadastrados(gerente.carregarTimes());
		System.out.println(gerente.getGerentecamp().getTimesCadastrados().size());
		gerente.getGerenteCad().setUsuarios(gerente.carregarTorcedor());
				
		JPanel telaLogin = new JPanel();
		contentPane.add(telaLogin, "name_16481570292567");
		telaLogin.setLayout(null); 
		
		loginIni = new JTextField();
		loginIni.setBounds(83, 25, 259, 20);
		telaLogin.add(loginIni);
		loginIni.setColumns(10);
		
		SenhaIni = new JPasswordField();
		SenhaIni.setBounds(83, 67, 259, 20);
		telaLogin.add(SenhaIni);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(83, 55, 46, 14);
		telaLogin.add(lblSenha);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(83, 11, 46, 14);
		telaLogin.add(lblLogin);
		
		JPanel tPosLoginTorcedor = new JPanel();
		contentPane.add(tPosLoginTorcedor, "name_16727782338164");
		tPosLoginTorcedor.setLayout(null);
		
		JLabel lbMostraNome = new JLabel("");
		lbMostraNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMostraNome.setForeground(new Color(255, 255, 255));
		lbMostraNome.setBounds(55, 11, 211, 14);
		tPosLoginTorcedor.add(lbMostraNome);
		
		JLabel lbMostraTime = new JLabel("");
		lbMostraTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMostraTime.setForeground(new Color(255, 255, 255));
		lbMostraTime.setBounds(55, 36, 145, 14);
		tPosLoginTorcedor.add(lbMostraTime);
		
		JList listEscalacao = new JList();
		listEscalacao.setBounds(10, 61, 225, 180);
		tPosLoginTorcedor.add(listEscalacao);
		
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setForeground(new Color(0, 0, 102));
		btnLogar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gerente.logar(loginIni.getText(), SenhaIni.getText())){
					listEscalacao.setVisible(false);
					telaLogin.setVisible(false);
					tPosLoginTorcedor.setVisible(true);
					//System.out.println(gerente.getGerentecamp().getTimesCadastrados().get(0).getEscalacao().size());
					//gerente.getGerenteLog().setUsuarioLogado(gerente.getGerenteCad().getUsuarios().get(gerente.getGerenteCad().buscarLogin(loginIni.getText())));
					//((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).setTime(gerente.getGerentecamp().getTimesCadastrados().get(gerente.getGerentecamp().buscarTimeNome(gerente.getGerenteCad().getUsuarios().get(gerente.getGerenteCad().buscarLogin(loginIni.getText())).getTime().getNome())));
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
					lbMostraNome.setText(gerente.getGerenteLog().getUsuarioLogado().getNome());
					lbMostraTime.setText(((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getNome());
					
				}else{
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos verifique os dados e tente novamente.");
				}
			}
		});
		btnLogar.setBounds(235, 189, 114, 23);
		telaLogin.add(btnLogar);
		
		JPanel tCadastro = new JPanel();
		contentPane.add(tCadastro, "name_20491227597697");
		tCadastro.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(0, 0, 102));
		btnCadastrar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaLogin.setVisible(false);
				tCadastro.setVisible(true);
				nomeCad.setText("");
				loginCad.setText("");
				senhaCad.setText("");
				rSenhaCad.setText("");
				timeCad.setText("");
			}
		});
		btnCadastrar.setBounds(161, 266, 114, 23);
		telaLogin.add(btnCadastrar);
		
		JPanel tPosLoginVisitante = new JPanel();
		contentPane.add(tPosLoginVisitante, "name_17960238342232");
		tPosLoginVisitante.setLayout(null);
		
		JLabel mPontos = new JLabel("");
		mPontos.setForeground(new Color(255, 255, 255));
		mPontos.setBounds(10, 56, 201, 14);
		tPosLoginVisitante.add(mPontos);
		
		JLabel mVitorias = new JLabel("");
		mVitorias.setForeground(new Color(255, 255, 255));
		mVitorias.setBounds(10, 81, 196, 14);
		tPosLoginVisitante.add(mVitorias);
		
		JLabel mEmpates = new JLabel("");
		mEmpates.setForeground(new Color(255, 255, 255));
		mEmpates.setBounds(10, 106, 196, 14);
		tPosLoginVisitante.add(mEmpates);
		
		JLabel mDerrotas = new JLabel("");
		mDerrotas.setForeground(new Color(255, 255, 255));
		mDerrotas.setBounds(10, 131, 196, 14);
		tPosLoginVisitante.add(mDerrotas);
		JComboBox timesVisitante = new JComboBox();
		timesVisitante.setModel(new DefaultComboBoxModel(new String[] {"Escolha"}));
		timesVisitante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		timesVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(timesVisitante.getSelectedIndex()>0){
					int[] resultado = gerente.gerarScore(gerente.getGerentecamp().getTimesCadastrados().get(timesVisitante.getSelectedIndex()-1).getNome());
					mPontos.setText("Pontos: "+Integer.toString(resultado[0]*3+resultado[2]));
					mVitorias.setText("Vitorias: "+Integer.toString(resultado[0]));
					mEmpates.setText("Empates: "+Integer.toString(resultado[1]));
					mDerrotas.setText("Derrotas: "+Integer.toString(resultado[2]));
				}else{
					mPontos.setText("");
					mVitorias.setText("");
					mEmpates.setText("");
					mDerrotas.setText("");
				}
			}
		});
		
		
		timesVisitante.setBounds(116, 23, 196, 20);
		tPosLoginVisitante.add(timesVisitante);
		
		JButton btnVisitaRapida = new JButton("Visita Rapida");
		btnVisitaRapida.setForeground(new Color(0, 0, 102));
		btnVisitaRapida.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnVisitaRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timesVisitante.setSelectedIndex(0);
				gerente.getGerenteLog().setUsuarioLogado(new Visitante());
				String[] listCombo = new String[gerente.getGerentecamp().getTimesCadastrados().size()+1];
				listCombo[0] = "Escolha um time";
				for (int i=0;i<gerente.getGerentecamp().getTimesCadastrados().size();i++){
					listCombo[i+1] = gerente.getGerentecamp().getTimesCadastrados().get(i).getNome();
				}
				timesVisitante.setModel(new javax.swing.DefaultComboBoxModel(listCombo));				
				telaLogin.setVisible(false);
				tPosLoginVisitante.setVisible(true);
				
			}
		});
		btnVisitaRapida.setBounds(100, 189, 114, 23);
		telaLogin.add(btnVisitaRapida);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		label.setIcon(new ImageIcon("C:\\Users\\Anael\\workspace\\SisTimeUltimateGUI\\brasileiro.jpg"));
		label.setBounds(0, 0, 432, 300);
		telaLogin.add(label);
		
		
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(10, 11, 46, 14);
		tPosLoginTorcedor.add(lblNome);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTime.setForeground(new Color(255, 255, 255));
		lblTime.setBounds(10, 36, 46, 14);
		tPosLoginTorcedor.add(lblTime);
		
		JLabel mPontoTorcedor = new JLabel("");
		mPontoTorcedor.setForeground(new Color(255, 255, 255));
		mPontoTorcedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		mPontoTorcedor.setBounds(10, 67, 173, 14);
		tPosLoginTorcedor.add(mPontoTorcedor);
		
		JLabel mVitoriasTorcedor = new JLabel("");
		mVitoriasTorcedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		mVitoriasTorcedor.setForeground(new Color(255, 255, 255));
		mVitoriasTorcedor.setBounds(10, 90, 190, 14);
		tPosLoginTorcedor.add(mVitoriasTorcedor);
		
		JLabel mEmpatesTorcedor = new JLabel("");
		mEmpatesTorcedor.setForeground(new Color(255, 255, 255));
		mEmpatesTorcedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		mEmpatesTorcedor.setBounds(10, 109, 190, 14);
		tPosLoginTorcedor.add(mEmpatesTorcedor);
		
		JLabel mDerrotasTorcedor = new JLabel("");
		mDerrotasTorcedor.setForeground(new Color(255, 255, 255));
		mDerrotasTorcedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		mDerrotasTorcedor.setBounds(10, 131, 173, 14);
		tPosLoginTorcedor.add(mDerrotasTorcedor);
			
		JButton btnVerTabela = new JButton("Ver Tabela");
		btnVerTabela.setForeground(new Color(0, 0, 102));
		btnVerTabela.setBackground(new Color(255, 255, 255));
		btnVerTabela.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnVerTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listEscalacao.setVisible(true);
				mPontoTorcedor.setVisible(false);
				mVitoriasTorcedor.setVisible(false);
				mEmpatesTorcedor.setVisible(false);
				mDerrotasTorcedor.setVisible(false);
				/*Partida[] listCombo = new Partida[gerente.getGerentecamp().getTabela().getPartidas().size()];
				String[] tabelaMostrar = new String[gerente.getGerentecamp().getTabela().getPartidas().size()];
				for (int i=0;i<gerente.getGerentecamp().getTabela().getPartidas().size();i++){
					tabelaMostrar[i] = ((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getNome()+
							"  "+ gerente.getGerentecamp().getTabela().getPartidas().get(i).getGols_casa()+
							" x "+ gerente.getGerentecamp().getTabela().getPartidas().get(i).getGols_visitante()+gerente.getGerentecamp().getTabela().getPartidas().get(i).getTime_visitante().getNome();
				}*/
				String[] tabelaMostrar = gerente.imprimeTabela(((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getNome());
				listEscalacao.setModel(new javax.swing.DefaultComboBoxModel(tabelaMostrar));
			}
		});
		btnVerTabela.setBounds(295, 7, 138, 23);
		tPosLoginTorcedor.add(btnVerTabela);
		
		
		
		JButton btnStatusDoTime = new JButton("Status do time");
		btnStatusDoTime.setForeground(new Color(0, 0, 102));
		btnStatusDoTime.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnStatusDoTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listEscalacao.setVisible(false);
				mPontoTorcedor.setVisible(true);
				mVitoriasTorcedor.setVisible(true);
				mEmpatesTorcedor.setVisible(true);
				mDerrotasTorcedor.setVisible(true);
				int[] resultado = gerente.gerarScore(((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getNome());
				mPontoTorcedor.setText("Pontos: "+Integer.toString(resultado[0]*3+resultado[1]));
				mVitoriasTorcedor.setText("Vitórias: "+Integer.toString(resultado[0]));
				mEmpatesTorcedor.setText("Empates: "+Integer.toString(resultado[1]));
				mDerrotasTorcedor.setText("Derrotas: "+Integer.toString(resultado[2]));	
			}
		});
		btnStatusDoTime.setBounds(295, 41, 138, 23);
		tPosLoginTorcedor.add(btnStatusDoTime);
		
		JButton btnEscalacao = new JButton("Escala\u00E7\u00E3o");
		btnEscalacao.setForeground(new Color(0, 0, 102));
		btnEscalacao.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEscalacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				try{
					listEscalacao.setVisible(true);
					mPontoTorcedor.setVisible(false);
					mVitoriasTorcedor.setVisible(false);
					mEmpatesTorcedor.setVisible(false);
					mDerrotasTorcedor.setVisible(false);
					String[] listCombo = new String[((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().size()];
					for (int i=0;i<((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().size();i++){
						listCombo[i] ="Nome: "+ ((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().get(i).getNome()+
								"  Numero: "+((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().get(i).getNumero()+
								"  Posi鈬o: "+((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().get(i).getPosicao();
					}
					listEscalacao.setModel(new javax.swing.DefaultComboBoxModel(listCombo));
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Ainda n縊 exitem jogadores escalados");
				}
				}
				
		});
		btnEscalacao.setBounds(295, 75, 138, 23);
		tPosLoginTorcedor.add(btnEscalacao);
		
		JButton btnDeslogar = new JButton("Deslogar");
		btnDeslogar.setForeground(new Color(0, 0, 102));
		btnDeslogar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerente.deslogar();
				loginIni.setText("");
				SenhaIni.setText("");
				tPosLoginTorcedor.setVisible(false);
				telaLogin.setVisible(true);
			}
		});
		btnDeslogar.setBounds(317, 246, 89, 23);
		tPosLoginTorcedor.add(btnDeslogar);
		
		JPanel tCadJogador = new JPanel();
		contentPane.add(tCadJogador, "name_19411132309950");
		tCadJogador.setLayout(null);
		
		JButton btnAdicionarJogador_1 = new JButton("Adicionar jogador");
		btnAdicionarJogador_1.setForeground(new Color(0, 0, 102));
		btnAdicionarJogador_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAdicionarJogador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tPosLoginTorcedor.setVisible(false);
				tCadJogador.setVisible(true);
			}
		});
		btnAdicionarJogador_1.setBounds(295, 109, 138, 23);
		tPosLoginTorcedor.add(btnAdicionarJogador_1);
		
		JButton btnAdicionarPartida_1 = new JButton("Adicionar partida");
		btnAdicionarPartida_1.setForeground(new Color(0, 0, 102));
		btnAdicionarPartida_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAdicionarPartida_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time timeAdversario = new Time(JOptionPane.showInputDialog("Qual time jogou contra o seu? "));
				int golsSeuTime = Integer.parseInt(JOptionPane.showInputDialog("Quantos gols seu time fez? "));
				int golsTimeAdversario = Integer.parseInt(JOptionPane.showInputDialog("Quantos gols o time adversario fez? "));
				gerente.getGerentecamp().getTabela().adicionarPartida(new Partida(((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime(),
						timeAdversario, golsSeuTime, golsTimeAdversario));
				gerente.salvarPartidas(gerente.getGerentecamp().getTabela().getPartidas());
			}
		});
		btnAdicionarPartida_1.setBounds(295, 147, 138, 23);
		tPosLoginTorcedor.add(btnAdicionarPartida_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Nome", "Senha"}));
		comboBox.setBounds(10, 27, 171, 20);

		JPanel tEditar = new JPanel();
		contentPane.add(tEditar, "name_12763442294435");
		tEditar.setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(0, 0, 102));
		btnSalvar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 1){
					if(senhaAtualEditar.getText().equals(gerente.getGerenteLog().getUsuarioLogado().getSenha())){
						gerente.getGerenteLog().getUsuarioLogado().setNome(nomeEditar.getText());
						lbMostraNome.setText(gerente.getGerenteLog().getUsuarioLogado().getNome());
						tEditar.setVisible(false);
						tPosLoginTorcedor.setVisible(true);
						JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
					}else{
						JOptionPane.showMessageDialog(null, "Senha incorreta");
					}
				}else if(comboBox.getSelectedIndex() == 2){
					if(senhaAtualEditar.getText().equals(gerente.getGerenteLog().getUsuarioLogado().getSenha())){
						if(senhaEditar.getText().equals(reSenhaEditar.getText())){
							gerente.getGerenteLog().getUsuarioLogado().setSenha(senhaEditar.getText());
							tEditar.setVisible(false);
							tPosLoginTorcedor.setVisible(true);
							JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
						}else{
							JOptionPane.showMessageDialog(null, "Senhas não combinam");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Senha incorreta");
					}
				}
				
			}
		});
		btnSalvar.setBounds(169, 242, 89, 23);
		tEditar.add(btnSalvar);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.setForeground(new Color(0, 0, 102));
		btnCancelar_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tEditar.setVisible(false);
				tPosLoginTorcedor.setVisible(true);
			}
		});
		btnCancelar_1.setBounds(169, 276, 89, 23);
		tEditar.add(btnCancelar_1);
		
		JLabel lblDigiteSuaSenhaEditar = new JLabel("Digite sua senha atual");
		lblDigiteSuaSenhaEditar.setForeground(new Color(255, 255, 255));
		lblDigiteSuaSenhaEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteSuaSenhaEditar.setBounds(10, 58, 136, 14);
		tEditar.add(lblDigiteSuaSenhaEditar);
		
		JLabel lblDigiteONovoEditar = new JLabel("Digite o novo nome");
		lblDigiteONovoEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteONovoEditar.setForeground(new Color(255, 255, 255));
		lblDigiteONovoEditar.setBounds(10, 118, 171, 14);
		tEditar.add(lblDigiteONovoEditar);
		
		JLabel lblRepitaASenhaEditar = new JLabel("Repita a senha");
		lblRepitaASenhaEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRepitaASenhaEditar.setForeground(new Color(255, 255, 255));
		lblRepitaASenhaEditar.setBounds(10, 164, 119, 14);
		tEditar.add(lblRepitaASenhaEditar);
				
		JButton btnEditarPerfil = new JButton("Editar perfil");
		btnEditarPerfil.setForeground(new Color(0, 0, 102));
		btnEditarPerfil.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeEditar.setText("");
				nomeEditar.setVisible(false);
				senhaEditar.setText("");
				senhaAtualEditar.setVisible(false);
				senhaAtualEditar.setText("");
				senhaEditar.setVisible(false);
				senhaEditar.setText("");
				reSenhaEditar.setVisible(false);
				reSenhaEditar.setText("");
				lblDigiteONovoEditar.setVisible(false);
				lblDigiteSuaSenhaEditar.setVisible(false);
				lblRepitaASenhaEditar.setVisible(false);
				tPosLoginTorcedor.setVisible(false);
				tEditar.setVisible(true);
			}
		});
		btnEditarPerfil.setBounds(295, 181, 138, 23);
		tPosLoginTorcedor.add(btnEditarPerfil);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Anael\\workspace\\SisTimeUltimateGUI\\cb.png"));
		label_1.setBounds(0, 0, 433, 300);
		tPosLoginTorcedor.add(label_1);
			
		JLabel lblQualInformaoDeseja = new JLabel("Alterar");
		lblQualInformaoDeseja.setForeground(new Color(255, 255, 255));
		lblQualInformaoDeseja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQualInformaoDeseja.setBounds(10, 11, 227, 14);
		tEditar.add(lblQualInformaoDeseja);
		
		senhaAtualEditar = new JPasswordField();
		senhaAtualEditar.setBounds(10, 83, 171, 20);
		tEditar.add(senhaAtualEditar);
		
		nomeEditar = new JTextField();
		nomeEditar.setBounds(10, 133, 171, 20);
		tEditar.add(nomeEditar);
		nomeEditar.setColumns(10);
		
		senhaEditar = new JPasswordField();
		senhaEditar.setBounds(10, 133, 171, 20);
		tEditar.add(senhaEditar);
		
		reSenhaEditar = new JPasswordField();
		reSenhaEditar.setBounds(10, 186, 171, 20);
		tEditar.add(reSenhaEditar);
		
		tEditar.add(comboBox);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\Anael\\workspace\\SisTimeUltimateGUI\\Tela Edi\u00E7\u00E3o.jpg"));
		label_5.setBounds(0, 0, 432, 300);
		tEditar.add(label_5);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0){
					nomeEditar.setVisible(false);
					senhaAtualEditar.setVisible(false);
					senhaEditar.setVisible(false);
					reSenhaEditar.setVisible(false);
					lblDigiteONovoEditar.setVisible(false);
					lblDigiteSuaSenhaEditar.setVisible(false);
					lblRepitaASenhaEditar.setVisible(false);
				}else if(comboBox.getSelectedIndex() == 1){
					senhaEditar.setVisible(false);
					reSenhaEditar.setVisible(false);
					lblRepitaASenhaEditar.setVisible(false);
					lblDigiteSuaSenhaEditar.setVisible(true);
					lblDigiteONovoEditar.setText("Digite o novo nome");
					lblDigiteONovoEditar.setVisible(true);
					senhaAtualEditar.setVisible(true);
					nomeEditar.setVisible(true);
				}else if(comboBox.getSelectedIndex() == 2){
					nomeEditar.setVisible(false);
					lblDigiteSuaSenhaEditar.setVisible(true);
					lblDigiteONovoEditar.setText("Digite sua nova senha");
					lblDigiteONovoEditar.setVisible(true);
					lblRepitaASenhaEditar.setVisible(true);
					senhaAtualEditar.setVisible(true);
					senhaEditar.setVisible(true);
					reSenhaEditar.setVisible(true);
				}
			}
		});
		
		
		JButton btnDeslogar_1 = new JButton("Voltar");
		btnDeslogar_1.setForeground(new Color(0, 0, 102));
		btnDeslogar_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnDeslogar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tPosLoginVisitante.setVisible(false);
				telaLogin.setVisible(true);
				reSenhaEditar.setText("");
				senhaEditar.setText("");
				senhaAtualEditar.setText("");
				nomeEditar.setText("");
			}
		});
		btnDeslogar_1.setBounds(178, 249, 89, 23);
		tPosLoginVisitante.add(btnDeslogar_1);
		
		JLabel lblEscolhaUmTime = new JLabel("Escolha um time");
		lblEscolhaUmTime.setForeground(new Color(255, 255, 255));
		lblEscolhaUmTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaUmTime.setBounds(116, 11, 124, 14);
		tPosLoginVisitante.add(lblEscolhaUmTime);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Anael\\workspace\\SisTimeUltimateGUI\\cb.png"));
		label_2.setBounds(0, 0, 432, 300);
		tPosLoginVisitante.add(label_2);
		
		JLabel lblNome_2 = new JLabel("Nome");
		lblNome_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome_2.setForeground(new Color(255, 255, 255));
		lblNome_2.setBounds(80, 11, 46, 14);
		tCadastro.add(lblNome_2);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin_1.setForeground(new Color(255, 255, 255));
		lblLogin_1.setBounds(80, 56, 46, 14);
		tCadastro.add(lblLogin_1);
		
		JLabel lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha_1.setForeground(new Color(255, 255, 255));
		lblSenha_1.setBounds(80, 105, 46, 14);
		tCadastro.add(lblSenha_1);
		
		JLabel lblRepetirASenha = new JLabel("Repetir a senha");
		lblRepetirASenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRepetirASenha.setForeground(new Color(255, 255, 255));
		lblRepetirASenha.setBounds(80, 163, 99, 14);
		tCadastro.add(lblRepetirASenha);
		
		loginCad = new JTextField();
		loginCad.setBounds(80, 70, 236, 20);
		tCadastro.add(loginCad);
		loginCad.setColumns(10);
		
		nomeCad = new JTextField();
		nomeCad.setBounds(80, 25, 236, 20);
		tCadastro.add(nomeCad);
		nomeCad.setColumns(10);
		
		senhaCad = new JPasswordField();
		senhaCad.setBounds(80, 119, 236, 20);
		tCadastro.add(senhaCad);
		
		rSenhaCad = new JPasswordField();
		rSenhaCad.setBounds(80, 179, 236, 20);
		tCadastro.add(rSenhaCad);
		
		timeCad = new JTextField();
		timeCad.setBounds(80, 223, 236, 20);
		tCadastro.add(timeCad);
		timeCad.setColumns(10);
		
		JButton btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.setForeground(new Color(0, 0, 102));
		btnCadastrar_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(senhaCad.getText().equals(rSenhaCad.getText()) && senhaCad.getText().length() > 0){
					Torcedor user = new Torcedor(nomeCad.getText(), loginCad.getText(), senhaCad.getText(),new Time(timeCad.getText()));
					gerente.cadastrarUsuario(user);
					gerente.salvarTorcedor(gerente.getGerenteCad().getUsuarios());
					gerente.cadastrarTime(user.getTime());
					gerente.salvarTimes(gerente.getGerentecamp().getTimesCadastrados());
					//gerente.getGerenteArq().salvartim(gerente.getGerentecamp().getTimesCadastrados());
					JOptionPane.showMessageDialog(null, "Usuario cadastrado");
					tCadastro.setVisible(false);
					telaLogin.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "As senhas n縊 batem ou os campos est縊 vazios por favor verifique e tente novamente.");
				}
				
				
			}
		});
		btnCadastrar_1.setBounds(150, 245, 124, 25);
		tCadastro.add(btnCadastrar_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(0, 0, 102));
		btnVoltar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tCadastro.setVisible(false);
				telaLogin.setVisible(true);
				
			}
		});
		btnVoltar.setBounds(165, 275, 89, 25);
		tCadastro.add(btnVoltar);
		
		JLabel lblNomeDoTime = new JLabel("Time");
		lblNomeDoTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeDoTime.setForeground(new Color(255, 255, 255));
		lblNomeDoTime.setBounds(80, 210, 152, 14);
		tCadastro.add(lblNomeDoTime);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Anael\\workspace\\SisTimeUltimateGUI\\camp.jpg"));
		label_4.setBounds(0, 0, 432, 300);
		tCadastro.add(label_4);
		
		
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome_1.setForeground(new Color(255, 255, 255));
		lblNome_1.setBounds(10, 11, 46, 14);
		tCadJogador.add(lblNome_1);
		
		nomeJogador = new JTextField();
		nomeJogador.setBounds(10, 28, 162, 20);
		tCadJogador.add(nomeJogador);
		nomeJogador.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setForeground(new Color(255, 255, 255));
		lblNumero.setBounds(10, 52, 46, 14);
		tCadJogador.add(lblNumero);
		
		JComboBox numeroJogador = new JComboBox();
		numeroJogador.setModel(new DefaultComboBoxModel(new String[] {"N\u00FAmero", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"}));
		numeroJogador.setBounds(10, 77, 162, 20);
		tCadJogador.add(numeroJogador);
		
		JLabel lblPosio = new JLabel("Posi\u00E7\u00E3o");
		lblPosio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPosio.setForeground(new Color(255, 255, 255));
		lblPosio.setBounds(10, 108, 46, 14);
		tCadJogador.add(lblPosio);
		
		JComboBox posicaoJogador = new JComboBox();
		posicaoJogador.setModel(new DefaultComboBoxModel(new String[] {"Escolha uma posi\u00E7\u00E3o", "Goleiro", "Zagueiro", "Lateral Esquerdo", "Lateral Direito", "Volante", "Meio Campo", "Atacante", "Centroavante"}));
		posicaoJogador.setBounds(10, 123, 162, 20);
		tCadJogador.add(posicaoJogador);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAdicionar.setForeground(new Color(0, 0, 102));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numeroJogador.getSelectedIndex() > 0 || posicaoJogador.getSelectedIndex() > 0){
					if(gerente.adicionarJogador(new Jogador(nomeJogador.getText(),numeroJogador.getSelectedItem().toString(),posicaoJogador.getSelectedItem().toString()), (Torcedor) gerente.getGerenteLog().getUsuarioLogado())){
						JOptionPane.showMessageDialog(null, "Jogador escalado com susesso");
						nomeJogador.setText("");
						numeroJogador.setSelectedIndex(0);
						posicaoJogador.setSelectedIndex(0);
						tCadJogador.setVisible(false);
						tPosLoginTorcedor.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "Jogador ja esta cadastrado");
					}
				}
				
			}
		});
		btnAdicionar.setBounds(321, 266, 89, 23);
		tCadJogador.add(btnAdicionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnCancelar.setForeground(new Color(0, 0, 102));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tCadJogador.setVisible(false);
				tPosLoginTorcedor.setVisible(true);
			}
		});
		btnCancelar.setBounds(222, 266, 89, 23);
		tCadJogador.add(btnCancelar);		
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Anael\\workspace\\SisTimeUltimateGUI\\escala\u00E7\u00E3o.jpg"));
		label_3.setBounds(0, 0, 432, 300);
		tCadJogador.add(label_3);
		
	
	}
}
