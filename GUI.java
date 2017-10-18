package view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.GerenteGeral;
import model.Visitante;
import model.Jogador;
import model.Partida;
import model.Time;
import model.Torcedor;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

/**@author Elizio e Nael
 * Classe que implementa a interface gráfica
 **/
public class GUI extends JFrame{
	
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

	/**
	 * Aplicação do launch
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
	 */
	public GUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		/*gerente.getGerentecamp().setTimesCadastrados(gerente.carregarTimes());
		System.out.println(gerente.getGerentecamp().getTimesCadastrados().get(0).getNome());*/
		
		JPanel telaLogin = new JPanel();
		contentPane.add(telaLogin, "name_16481570292567");
		telaLogin.setLayout(null);
		
		loginIni = new JTextField();
		loginIni.setBounds(75, 85, 259, 20);
		telaLogin.add(loginIni);
		loginIni.setColumns(10);
		
		SenhaIni = new JPasswordField();
		SenhaIni.setBounds(75, 134, 259, 20);
		telaLogin.add(SenhaIni);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(73, 116, 46, 14);
		telaLogin.add(lblSenha);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(75, 66, 46, 14);
		telaLogin.add(lblLogin);
		
		JPanel tPosLoginTorcedor = new JPanel();
		contentPane.add(tPosLoginTorcedor, "name_16727782338164");
		tPosLoginTorcedor.setLayout(null);
		
		JLabel lbMostraNome = new JLabel("");
		lbMostraNome.setBounds(55, 11, 211, 14);
		tPosLoginTorcedor.add(lbMostraNome);
		
		JLabel lbMostraTime = new JLabel("");
		lbMostraTime.setBounds(55, 36, 145, 14);
		tPosLoginTorcedor.add(lbMostraTime);
		
		JList listEscalacao = new JList();
		listEscalacao.setBounds(10, 61, 256, 180);
		tPosLoginTorcedor.add(listEscalacao);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gerente.logar(loginIni.getText(), SenhaIni.getText())){
					/*gerente.getGerentecamp().getTabela().setPartidas(gerente.carregarPartidas());*/
					listEscalacao.setVisible(false);
					telaLogin.setVisible(false);
					tPosLoginTorcedor.setVisible(true);
					gerente.getGerenteLog().setTimeUsando(((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime());
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
					lbMostraNome.setText(gerente.getGerenteLog().getUsuarioLogado().getNome());
					lbMostraTime.setText(((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getNome());
					
				}else{
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos verifique os dados e tente novamente.");
				}
			}
		});
		btnLogar.setBounds(199, 172, 114, 23);
		telaLogin.add(btnLogar);
		
		JPanel tCadastro = new JPanel();
		contentPane.add(tCadastro, "name_20491227597697");
		tCadastro.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
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
		btnCadastrar.setBounds(199, 206, 114, 23);
		telaLogin.add(btnCadastrar);
		
		JPanel tPosLoginVisitante = new JPanel();
		contentPane.add(tPosLoginVisitante, "name_17960238342232");
		tPosLoginVisitante.setLayout(null);
		
		JLabel mPontos = new JLabel("");
		mPontos.setBounds(10, 56, 201, 14);
		tPosLoginVisitante.add(mPontos);
		
		JLabel mVitorias = new JLabel("");
		mVitorias.setBounds(10, 81, 196, 14);
		tPosLoginVisitante.add(mVitorias);
		
		JLabel mEmpates = new JLabel("");
		mEmpates.setBounds(10, 106, 196, 14);
		tPosLoginVisitante.add(mEmpates);
		
		JLabel mDerrotas = new JLabel("");
		mDerrotas.setBounds(10, 131, 196, 14);
		tPosLoginVisitante.add(mDerrotas);
		
		JComboBox timesVisitante = new JComboBox();
		timesVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(timesVisitante.getSelectedIndex()>0){
					int[] resultado = gerente.gerarScore(gerente.getGerenteCamp().getTimesCadastrados().get(timesVisitante.getSelectedIndex()-1).getNome());
					mPontos.setText(Integer.toString(resultado[0]*3+resultado[2]));
					mVitorias.setText("Vitorias: "+Integer.toString(resultado[0]));
					mEmpates.setText("Empates"+Integer.toString(resultado[1]));
					mDerrotas.setText("Derrotas"+Integer.toString(resultado[2]));
				}else{
					mPontos.setText("");
					mVitorias.setText("");
					mEmpates.setText("");
					mDerrotas.setText("");
				}
			}
		});
		timesVisitante.setBounds(10, 25, 196, 20);
		tPosLoginVisitante.add(timesVisitante);
		
		JButton btnVisitaRapida = new JButton("Visita Rapida");
		btnVisitaRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gerente.getGerenteLog().setUsuarioLogado(new Visitante());
				String[] listCombo = new String[gerente.getGerenteCamp().getTimesCadastrados().size()+1];
				listCombo[0] = "Escolha um time";
				for (int i=0;i<gerente.getGerenteCamp().getTimesCadastrados().size();i++){
					listCombo[i+1] = gerente.getGerenteCamp().getTimesCadastrados().get(i).getNome();
				}
				timesVisitante.setModel(new javax.swing.DefaultComboBoxModel(listCombo));				
				telaLogin.setVisible(false);
				tPosLoginVisitante.setVisible(true);
				
			}
		});
		btnVisitaRapida.setBounds(55, 172, 134, 23);
		telaLogin.add(btnVisitaRapida);
		
		
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 11, 46, 14);
		tPosLoginTorcedor.add(lblNome);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(10, 36, 46, 14);
		tPosLoginTorcedor.add(lblTime);
		
		JLabel mPontoTorcedor = new JLabel("");
		mPontoTorcedor.setBounds(10, 67, 173, 14);
		tPosLoginTorcedor.add(mPontoTorcedor);
		
		JLabel mVitoriasTorcedor = new JLabel("");
		mVitoriasTorcedor.setBounds(10, 90, 190, 14);
		tPosLoginTorcedor.add(mVitoriasTorcedor);
		
		JLabel mEmpatesTorcedor = new JLabel("");
		mEmpatesTorcedor.setBounds(10, 109, 190, 14);
		tPosLoginTorcedor.add(mEmpatesTorcedor);
		
		JLabel mDerrotasTorcedor = new JLabel("");
		mDerrotasTorcedor.setBounds(10, 131, 173, 14);
		tPosLoginTorcedor.add(mDerrotasTorcedor);
			
		JButton btnVerTabela = new JButton("Ver Tabela");
		btnVerTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listEscalacao.setVisible(true);
				mPontoTorcedor.setVisible(false);
				mVitoriasTorcedor.setVisible(false);
				mEmpatesTorcedor.setVisible(false);
				mDerrotasTorcedor.setVisible(false);
				Partida[] listCombo = new Partida[gerente.getGerenteCamp().getTabela().getPartidas().size()];
				String[] tabelaMostrar = new String[gerente.getGerenteCamp().getTabela().getPartidas().size()];
				for (int i=0;i<gerente.getGerenteCamp().getTabela().getPartidas().size();i++){
					tabelaMostrar[i] = ((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getNome()+
							"  "+ gerente.getGerenteCamp().getTabela().getPartidas().get(i).getGols_casa()+
							" x "+ gerente.getGerenteCamp().getTabela().getPartidas().get(i).getGols_visitante()+gerente.getGerenteCamp().getTabela().getPartidas().get(i).getTime_visitante().getNome();
				}
				listEscalacao.setModel(new javax.swing.DefaultComboBoxModel(tabelaMostrar));
			}
		});
		btnVerTabela.setBounds(276, 7, 138, 23);
		tPosLoginTorcedor.add(btnVerTabela);
		
		
		
		JButton btnStatusDoTime = new JButton("Status do time");
		btnStatusDoTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listEscalacao.setVisible(false);
				mPontoTorcedor.setVisible(true);
				mVitoriasTorcedor.setVisible(true);
				mEmpatesTorcedor.setVisible(true);
				mDerrotasTorcedor.setVisible(true);
				int[] resultado = gerente.gerarScore(((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getNome());
				mPontoTorcedor.setText(Integer.toString(resultado[0]*3+resultado[1]));
				mVitoriasTorcedor.setText("Vitorias: "+Integer.toString(resultado[0]));
				mEmpatesTorcedor.setText("Empates: "+Integer.toString(resultado[1]));
				mDerrotasTorcedor.setText("Derrotas: "+Integer.toString(resultado[2]));	
			}
		});
		btnStatusDoTime.setBounds(276, 32, 138, 23);
		tPosLoginTorcedor.add(btnStatusDoTime);
		
		JButton btnEscalacao = new JButton("Escalacao");
		btnEscalacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				try{
					listEscalacao.setVisible(true);
					mPontoTorcedor.setVisible(false);
					mVitoriasTorcedor.setVisible(false);
					mEmpatesTorcedor.setVisible(false);
					mDerrotasTorcedor.setVisible(false);
					String[] listCombo = new String[((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().size()];
					listCombo[0] = "Escolha um time";
					for (int i=0;i<((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().size();i++){
						listCombo[i] ="Nome: "+ ((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().get(i).getNome()+
								"  Numero: "+((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().get(i).getNumero()+
								"  Posição: "+((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime().getEscalacao().get(i).getPosicao();
					}
					listEscalacao.setModel(new javax.swing.DefaultComboBoxModel(listCombo));
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Ainda não exitem jogadores escalados");
				}
				}
				
		});
		btnEscalacao.setBounds(276, 58, 138, 23);
		tPosLoginTorcedor.add(btnEscalacao);
		
		JButton btnDeslogar = new JButton("Deslogar");
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*gerente.salvarTimes(gerente.getGerentecamp().getTimesCadastrados());*/
				loginIni.setText("");
				SenhaIni.setText("");
				tPosLoginTorcedor.setVisible(false);
				telaLogin.setVisible(true);
			}
		});
		btnDeslogar.setBounds(325, 218, 89, 23);
		tPosLoginTorcedor.add(btnDeslogar);
		
		JPanel tCadJogador = new JPanel();
		contentPane.add(tCadJogador, "name_19411132309950");
		tCadJogador.setLayout(null);
		
		JButton btnAdicionarJogador_1 = new JButton("Adicionar jogador");
		btnAdicionarJogador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tPosLoginTorcedor.setVisible(false);
				tCadJogador.setVisible(true);
			}
		});
		btnAdicionarJogador_1.setBounds(276, 90, 138, 23);
		tPosLoginTorcedor.add(btnAdicionarJogador_1);
		
		JButton btnAdicionarPartida_1 = new JButton("Adicionar partida");
		btnAdicionarPartida_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time timeAdversario = new Time(JOptionPane.showInputDialog("Qual time jogou contra o seu? "));
				int golsSeuTime = Integer.parseInt(JOptionPane.showInputDialog("Quantos gols seu time fez? "));
				int golsTimeAdversario = Integer.parseInt(JOptionPane.showInputDialog("Quantos gols o time adversario fez? "));
				gerente.getGerenteCamp().getTabela().adicionarPartida(new Partida(((Torcedor) gerente.getGerenteLog().getUsuarioLogado()).getTime(),
						timeAdversario, golsSeuTime, golsTimeAdversario));
				/*gerente.salvarPartidas(gerente.getGerentecamp().getTabela().getPartidas());*/
			}
		});
		btnAdicionarPartida_1.setBounds(276, 122, 138, 23);
		tPosLoginTorcedor.add(btnAdicionarPartida_1);
			
		JButton btnDeslogar_1 = new JButton("Deslogar");
		btnDeslogar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tPosLoginVisitante.setVisible(false);
				telaLogin.setVisible(true);
			}
		});
		btnDeslogar_1.setBounds(325, 218, 89, 23);
		tPosLoginVisitante.add(btnDeslogar_1);
		
		JLabel lblEscolhaUmTime = new JLabel("Escolha um time");
		lblEscolhaUmTime.setBounds(10, 11, 82, 14);
		tPosLoginVisitante.add(lblEscolhaUmTime);
		
		JLabel lblNome_2 = new JLabel("Nome");
		lblNome_2.setBounds(10, 11, 46, 14);
		tCadastro.add(lblNome_2);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setBounds(10, 50, 46, 14);
		tCadastro.add(lblLogin_1);
		
		JLabel lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setBounds(10, 87, 46, 14);
		tCadastro.add(lblSenha_1);
		
		JLabel lblRepetirASenha = new JLabel("Repetir a senha");
		lblRepetirASenha.setBounds(10, 122, 99, 14);
		tCadastro.add(lblRepetirASenha);
		
		loginCad = new JTextField();
		loginCad.setBounds(10, 64, 236, 20);
		tCadastro.add(loginCad);
		loginCad.setColumns(10);
		
		nomeCad = new JTextField();
		nomeCad.setBounds(10, 23, 236, 20);
		tCadastro.add(nomeCad);
		nomeCad.setColumns(10);
		
		senhaCad = new JPasswordField();
		senhaCad.setBounds(10, 101, 236, 20);
		tCadastro.add(senhaCad);
		
		rSenhaCad = new JPasswordField();
		rSenhaCad.setBounds(10, 136, 236, 20);
		tCadastro.add(rSenhaCad);
		
		timeCad = new JTextField();
		timeCad.setBounds(10, 182, 233, 20);
		tCadastro.add(timeCad);
		timeCad.setColumns(10);
		
		JButton btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(senhaCad.getText().equals(rSenhaCad.getText()) && senhaCad.getText().length() > 0){
					Torcedor user = new Torcedor(nomeCad.getText(), loginCad.getText(), senhaCad.getText(),new Time(timeCad.getText()));
					gerente.cadastrarUsuario(user);
					JOptionPane.showMessageDialog(null, "Usuario cadastrado");
					tCadastro.setVisible(false);
					telaLogin.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "As senhas não batem ou os campos estão vazios por favor verifique e tente novamente.");
				}
				
				
			}
		});
		btnCadastrar_1.setBounds(306, 182, 108, 59);
		tCadastro.add(btnCadastrar_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tCadastro.setVisible(false);
				telaLogin.setVisible(true);
				
			}
		});
		btnVoltar.setBounds(10, 218, 89, 23);
		tCadastro.add(btnVoltar);
		
		JLabel lblNomeDoTime = new JLabel("Time");
		lblNomeDoTime.setBounds(10, 167, 152, 14);
		tCadastro.add(lblNomeDoTime);
		
		
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 11, 46, 14);
		tCadJogador.add(lblNome_1);
		
		nomeJogador = new JTextField();
		nomeJogador.setBounds(10, 28, 258, 20);
		tCadJogador.add(nomeJogador);
		nomeJogador.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 52, 46, 14);
		tCadJogador.add(lblNumero);
		
		JComboBox numeroJogador = new JComboBox();
		numeroJogador.setModel(new DefaultComboBoxModel(new String[] {"Numero", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"}));
		numeroJogador.setBounds(10, 77, 62, 20);
		tCadJogador.add(numeroJogador);
		
		JLabel lblPosio = new JLabel("Posi\u00E7\u00E3o");
		lblPosio.setBounds(10, 108, 46, 14);
		tCadJogador.add(lblPosio);
		
		JComboBox posicaoJogador = new JComboBox();
		posicaoJogador.setModel(new DefaultComboBoxModel(new String[] {"Escolha uma posi\u00E7\u00E3o", "Atacante", "Zagueiro", "Goleiro", "Lateral esquerdo", "Lateral Direito", "Volante", "Centro Avante"}));
		posicaoJogador.setBounds(10, 123, 152, 20);
		tCadJogador.add(posicaoJogador);
		
		JButton btnAdicionar = new JButton("Adicionar");
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
		btnAdicionar.setBounds(325, 218, 89, 23);
		tCadJogador.add(btnAdicionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tCadJogador.setVisible(false);
				tPosLoginTorcedor.setVisible(true);
			}
		});
		btnCancelar.setBounds(226, 218, 89, 23);
		tCadJogador.add(btnCancelar);
	}
	

}
