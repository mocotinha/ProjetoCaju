package br.edu.ifpb.caju.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaMenuAta extends JFrame{
	
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 **/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuAta frame = new TelaMenuAta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 **/
	public TelaMenuAta() {
		setTitle("Ata Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAta = new JMenu("Ata");
		menuBar.add(mnAta);
		
		JMenuItem mntmCadastrarColegiado = new JMenuItem("Cadastrar Ata");
		mntmCadastrarColegiado.addActionListener(new CadastrarAtaListener());
		mnAta.add(mntmCadastrarColegiado);
		
		JMenuItem mntmListarColegiado = new JMenuItem("Listar Ata");
		mntmListarColegiado.addActionListener(new ListaAtaListener());
		mnAta.add(mntmListarColegiado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private TelaMenuAta classe(){
		return this;
	}
	
	private class CadastrarAtaListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastraAta tca = new TelaCadastraAta(classe());
			tca.setVisible(true);
		}
	}
	
	private class ListaAtaListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaListaAta tla = new TelaListaAta(classe());
			tla.setVisible(true);
			
		}
		
	}
	
}
