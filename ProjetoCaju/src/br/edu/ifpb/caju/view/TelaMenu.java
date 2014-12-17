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
		mntmListarModelo.addActionListener(new ListaModeloListener());
		mnModelo.add(mntmListarModelo);
		
		JMenuItem mntmGerarAtaDa = new JMenuItem("Gerar Ata da Reuni\u00E3o");
		mnModelo.add(mntmGerarAtaDa);
		
		JMenuItem mntmGerarPautaDa = new JMenuItem("Gerar Pauta da Reuni\u00E3o");
		mnModelo.add(mntmGerarPautaDa);
		
		JMenu mnMembro = new JMenu("Membro");
		menuBar.add(mnMembro);
		
		JMenuItem mntmCadastrarMembro = new JMenuItem("Cadastrar Membro");
		mnMembro.add(mntmCadastrarMembro);
		
		JMenuItem mntmListarMembro = new JMenuItem("Listar Membro");
		mnMembro.add(mntmListarMembro);
		
		JMenuItem mntmDefinirMembroPresidente = new JMenuItem("Definir Membro Presidente");
		mnMembro.add(mntmDefinirMembroPresidente);
		
		JMenu mnColegiado = new JMenu("Colegiado");
		menuBar.add(mnColegiado);
		
		JMenuItem mntmAgendaDoColegiado = new JMenuItem("Agenda do Colegiado");
		mnColegiado.add(mntmAgendaDoColegiado);
		
		JMenuItem mntmCadastrarColegiado = new JMenuItem("Cadastrar Colegiado");
		mnColegiado.add(mntmCadastrarColegiado);
		
	
		
		JMenuItem mntmListarColegiados = new JMenuItem("Listar Colegiados");
		mnColegiado.add(mntmListarColegiados);
		
		JMenu mnProcesso = new JMenu("Processo");
		menuBar.add(mnProcesso);
		
		JMenuItem mntmVotarEmProcesso = new JMenuItem("Votar em Processo");
		mnProcesso.add(mntmVotarEmProcesso);
		
		JMenuItem mntmAlocarProcessoA = new JMenuItem("Alocar Processo a Reuni\u00E3o");
		mnProcesso.add(mntmAlocarProcessoA);
		
		JMenuItem mntmCadastroDeProcesso = new JMenuItem("Cadastro de Processo");
		mnProcesso.add(mntmCadastroDeProcesso);
		
		JMenuItem mntmEdioDeProcesso = new JMenuItem("Edi\u00E7\u00E3o de Processo");
		mnProcesso.add(mntmEdioDeProcesso);
		
		JMenuItem mntmListaDeProcessos = new JMenuItem("Lista de Processos");
		mnProcesso.add(mntmListaDeProcessos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private TelaMenu classe(){
		return this;
	}
	
	private class CadastrarReuniaoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastraReuniao tcr;
			try {
				tcr = new TelaCadastraReuniao(classe());
				tcr.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}
	
	private class ListaModeloListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaListaModelo tlm = new TelaListaModelo(classe());
			tlm.setVisible(true);
			
		}
		
	}

}
