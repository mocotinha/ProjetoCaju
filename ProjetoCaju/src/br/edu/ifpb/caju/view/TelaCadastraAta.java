package br.edu.ifpb.caju.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.ifpb.caju.controller.SistemaAta;
import br.edu.ifpb.caju.model.Ata;

public class TelaCadastraAta extends JDialog{
	
	private final JPanel contentPanel = new JPanel();
	private JTextField texto;
	private Ata ata;
	
	/**
	 * Launch the application.
	 **/
	
	public static void main(String[] args) {
		try {
			TelaCadastraAta dialog = new TelaCadastraAta(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 **/
	
	public TelaCadastraAta(TelaMenuAta tela,Ata ata){//verificar tipos
		super(tela,"Cadastro de Ata",true);
		this.ata = ata;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 262);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		//Falta editar a visualização
		//--
		JLabel lbldataIni = new JLabel("Ata:");
		lbldataIni.setBounds(32, 33, 71, 14);
		contentPanel.add(lbldataIni);
		

		//---
		JButton btnCadastrar = new JButton("Atualizar");
		btnCadastrar.setBounds(24, 225, 98, 26);
		btnCadastrar.addActionListener(new AtualizarListener());
		contentPanel.add(btnCadastrar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(277, 225, 98, 26);
		btnConcluir.addActionListener(new ConcluidoListener());
		contentPanel.add(btnConcluir);
	}
	
	public TelaCadastraAta(JFrame tela) { //verificar tipos
		super(tela,"Cadastro de Ata",true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 262);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		//Falta ver os outros atributos
	

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(24, 225, 98, 26);
		btnCadastrar.addActionListener(new CadastrarListener());
		contentPanel.add(btnCadastrar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(277, 225, 98, 26);
		btnConcluir.addActionListener(new ConcluidoListener());
		contentPanel.add(btnConcluir);
		
	}
	

	public TelaCadastraAta classe() {
		return this;
	}
	
	private class AtualizarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				SistemaAta sys = new SistemaAta(); //verificar tipos
				ata.setTexto((Long) null);//corrigir
				sys.editaAta(ata);
				JOptionPane.showMessageDialog(classe(), "Ata Atualizada com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao Atualizar a Ata!");
			}
			
		}
		
	}
	
	private class CadastrarListener implements ActionListener{//verificar tipos.

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				SistemaAta sys = new SistemaAta();
				//sys.cadastraAta(texto.getText()); //trabalhar com long
				JOptionPane.showMessageDialog(classe(), "Ata Cadastrado com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao cadastrar o Ata!");
			}
			
			
		}
		
	}
	private class ConcluidoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		
	}
	
}
