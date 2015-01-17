package br.edu.ifpb.caju.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setTitle("Colegiado - IFPB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnModelo = new JMenu("Reuni\u00E3o");
		menuBar.add(mnModelo);
		
		JMenuItem mntmCadastrarModelo = new JMenuItem("Cadastrar Reuni\u00E3o");
		mntmCadastrarModelo.addActionListener(new CadastrarReuniaoListener());
		mnModelo.add(mntmCadastrarModelo);
		
		JMenuItem mntmListarModelo = new JMenuItem("Listar Reuni\u00F5es");
		mntmListarModelo.addActionListener(new ListaReunioesListener());
		mnModelo.add(mntmListarModelo);
		
		JMenuItem mntmGerarAtaDa = new JMenuItem("Gerar Ata da Reuni\u00E3o");
		mntmGerarAtaDa.addActionListener(new GeraAtaReuniaoListener());
		mnModelo.add(mntmGerarAtaDa);
		
		JMenuItem mntmGerarPautaDa = new JMenuItem("Gerar Pauta da Reuni\u00E3o");
		mntmGerarPautaDa.addActionListener(new GeraPautaReuniaoListener());
		mnModelo.add(mntmGerarPautaDa);
		
		JMenu mnMembro = new JMenu("Membro");
		menuBar.add(mnMembro);
		
		JMenuItem mntmCadastrarMembro = new JMenuItem("Cadastrar Membro");
		mntmCadastrarMembro.addActionListener(new CadastraMembroListener());
		mnMembro.add(mntmCadastrarMembro);
		
		JMenuItem mntmListarMembro = new JMenuItem("Listar Membro");
		mntmListarMembro.addActionListener(new ListarMembroListener());
		mnMembro.add(mntmListarMembro);
		
		
		
		JMenu mnColegiado = new JMenu("Colegiado");
		menuBar.add(mnColegiado);
		
		JMenuItem mntmAgendaDoColegiado = new JMenuItem("Agenda do Colegiado");
		mntmAgendaDoColegiado.addActionListener(new AgendaColegiadoListener());
		mnColegiado.add(mntmAgendaDoColegiado);
		
		JMenuItem mntmCadastrarColegiado = new JMenuItem("Cadastrar Colegiado");
		mntmCadastrarColegiado.addActionListener(new CadastrarColegiadoListener());
		mnColegiado.add(mntmCadastrarColegiado);
		
	
		
		JMenuItem mntmListarColegiados = new JMenuItem("Listar Colegiados");
		mntmListarColegiados.addActionListener(new ListarColegiadosListener());
		mnColegiado.add(mntmListarColegiados);
		
		JMenuItem mntmCadastrarPreidenteColegiado = new JMenuItem("Cadastrar Presidente do Colegiado");
		mntmCadastrarPreidenteColegiado.addActionListener(new CadastraPresidenteListener());
		mnColegiado.add(mntmCadastrarPreidenteColegiado);
		
		JMenu mnProcesso = new JMenu("Processo");
		menuBar.add(mnProcesso);
		
		JMenuItem mntmVotarEmProcesso = new JMenuItem("Votar em Processo");
		mntmVotarEmProcesso.addActionListener(new VotarListener());
		mnProcesso.add(mntmVotarEmProcesso);
		
		JMenuItem mntmAlocarProcessoA = new JMenuItem("Alocar Processo a Reuni\u00E3o");
		mntmAlocarProcessoA.addActionListener(new AlocaListener());
		mnProcesso.add(mntmAlocarProcessoA);
		
		JMenuItem mntmCadastroDeProcesso = new JMenuItem("Cadastro de Processo");
		mntmCadastroDeProcesso.addActionListener(new CadastroProcessoListener());
		mnProcesso.add(mntmCadastroDeProcesso);
		
		JMenuItem mntmEdioDeProcesso = new JMenuItem("Edi\u00E7\u00E3o de Processo");
		mntmEdioDeProcesso.addActionListener(new EdicaoProcessoListener());
		mnProcesso.add(mntmEdioDeProcesso);
		
		JMenuItem mntmListaDeProcessos = new JMenuItem("Lista de Processos");
		mntmListaDeProcessos.addActionListener(new ListaProcessosListener());
		mnProcesso.add(mntmListaDeProcessos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private TelaMenu classe(){
		return this;
	}
	
	private class ListaProcessosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaListaProcesso tlp = new TelaListaProcesso(classe());
			tlp.setVisible(true);
			
		}
		
	}
	private class CadastroProcessoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastroProcesso tcp = new TelaCadastroProcesso();
			tcp.setVisible(true);
			
		}
		
	}
	
	private class EdicaoProcessoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Falta Implementar - editaProcesso(Processo processo);
			JOptionPane.showMessageDialog(classe(), "Falta Implementar a Tela, Metodo: editaProcesso(Processo processo	); em SistemaProcesso");
			
		}
		
	}
	
	private class AlocaListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Falta Implementar - alocarProcessoAReunião(Processo p, Reuniao r);
			JOptionPane.showMessageDialog(classe(), "Falta Implementar a Tela, Metodo: alocarProcessoAReunião(Processo p, Reuniao r); em Sistema");
			
			
		}
		
	}
	
	private class ListarColegiadosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaListaColegiado tlc = new TelaListaColegiado(classe());
			tlc.setVisible(true);
			
		}
		
	}
	
	private class CadastrarColegiadoListener implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastraColegiado tcc = new TelaCadastraColegiado(classe());
			tcc.setVisible(true);
		}
		
	}
	private class VotarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Falta Implementar -votarEmProcesso(Voto v, Processo p);
			JOptionPane.showMessageDialog(classe(), "Falta Implementar a Tela, Metodo: votarEmProcesso(Voto v, Processo p); em Sistema");
			
			
		}
		
	}
	
	private class CadastraPresidenteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Falta Implementar - cadastrarPresidente(Membro membro, String login, String senha);
			JOptionPane.showMessageDialog(classe(), "Falta Implementar a Tela, Metodo: cadastrarPresidente(Membro membro, String login, String senha); em Sistema ");
						
		}
		
	}
	
	private class AgendaColegiadoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Falta Implementar - consultarAgendaDoColegiado(Colegiado c)
			JOptionPane.showMessageDialog(classe(), "Falta Implementar a Tela, Metodo: consultarAgendaDoColegiado(Colegiado c) em Sistema ");
			
		}
		
	}
	
	private class CadastraMembroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TelaCadastraMembro telaCadastraMembro = new TelaCadastraMembro(classe());
			telaCadastraMembro.setVisible(true);
		}
	}
	
	private class ListarMembroListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaListaMembro tlm = new TelaListaMembro(classe());
			tlm.setVisible(true);
			
		}
		
	}
	
	private class GeraPautaReuniaoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Falta Implementar - gerarPautaDeReuniao(Reuniao r);
			JOptionPane.showMessageDialog(classe(), "Falta Implementar a Tela, Metodo: gerarPautaDeReuniao(Reuniao r); em Sistema ");
			
		}
		
	}
	
	private class GeraAtaReuniaoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Falta Implementar - gerarAtaDeReuniao(Reuniao r);
			JOptionPane.showMessageDialog(classe(), "Falta Implementar a Tela, Metodo: gerarAtaDeReuniao(Reuniao r); em Sistema ");
			
		}
		
	}
	
	private class CadastrarReuniaoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastraReuniao tcr;
			try {
				tcr = new TelaCadastraReuniao(classe());
				tcr.setVisible(true);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			
		}
		
	}
	
	private class ListaReunioesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaListaReuniao tlr = new TelaListaReuniao();
			tlr.setVisible(true);
			
		}
		
	}
	

}
