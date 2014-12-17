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
		setTitle("Modelo Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnModelo = new JMenu("Modelo");
		menuBar.add(mnModelo);
		
		JMenuItem mntmCadastrarModelo = new JMenuItem("Cadastrar Modelo");
		mntmCadastrarModelo.addActionListener(new CadastrarModeloListener());
		mnModelo.add(mntmCadastrarModelo);
		
		JMenuItem mntmListarModelo = new JMenuItem("Listar Modelo");
		mntmListarModelo.addActionListener(new ListaModeloListener());
		mnModelo.add(mntmListarModelo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private TelaMenu classe(){
		return this;
	}
	
	private class CadastrarModeloListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastraModelo tcm = new TelaCadastraModelo(classe());
			tcm.setVisible(true);
			
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
