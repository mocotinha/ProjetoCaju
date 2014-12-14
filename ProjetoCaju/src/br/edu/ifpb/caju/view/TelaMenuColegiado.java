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



@SuppressWarnings("serial")
public class TelaMenuColegiado extends JFrame{
	
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 **/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuColegiado frame = new TelaMenuColegiado();
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
	
	public TelaMenuColegiado() {
		setTitle("Colegiado Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnColegiado = new JMenu("Colegiado");
		menuBar.add(mnColegiado);
		
		JMenuItem mntmCadastrarColegiado = new JMenuItem("Cadastrar Colegiado");
		mntmCadastrarColegiado.addActionListener(new CadastrarColegiadoListener());
		mnColegiado.add(mntmCadastrarColegiado);
		
		JMenuItem mntmListarColegiado = new JMenuItem("Listar Colegiado");
		mntmListarColegiado.addActionListener(new ListaColegiadoListener());
		mnColegiado.add(mntmListarColegiado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private TelaMenuColegiado classe(){
		return this;
	}
	
	private class CadastrarColegiadoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastraColegiado tcc = new TelaCadastraColegiado(classe());
			tcc.setVisible(true);
		}
	}
	
	private class ListaColegiadoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaListaColegiado tlc = new TelaListaColegiado(classe());
			tlc.setVisible(true);
			
		}
		
	}

}
