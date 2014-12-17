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

import br.edu.ifpb.caju.controller.SistemaColegiado;

import br.edu.ifpb.caju.model.Colegiado;



@SuppressWarnings("serial")
public class TelaCadastraColegiado extends JDialog{
	
	private final JPanel contentPanel = new JPanel();
	private JTextField dataIni;
	private JTextField dataFim;
	private JTextField ativo;
	private Colegiado colegiado;
	
	/**
	 * Launch the application.
	 **/
	
	public static void main(String[] args) {
		try {
			TelaCadastraColegiado dialog = new TelaCadastraColegiado(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 **/
	
	public TelaCadastraColegiado(TelaMenuColegiado tela,Colegiado colegiado){//verificar tipos
		super(tela,"Cadastro de Colegiado",true);
		this.colegiado = colegiado;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 262);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		//Falta ver os outros atributos
		//--
		JLabel lbldataIni = new JLabel("DataIni:");
		lbldataIni.setBounds(32, 33, 71, 14);
		contentPanel.add(lbldataIni);
		
		dataIni = new JTextField();//this.colegiado.getDataIni()
		dataIni.setBounds(91, 30, 257, 20);
		contentPanel.add(dataIni);
		dataIni.setColumns(10);
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
	
	public TelaCadastraColegiado(JFrame tela) { //verificar tipos
		super(tela,"Cadastro de Colegiado",true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 262);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		//Falta ver os outros atributos
		
		JLabel lbldataIni = new JLabel("DataIni:");
		lbldataIni.setBounds(32, 33, 71, 14);
		contentPanel.add(lbldataIni);
		
		dataIni = new JTextField();//this.colegiado.getDataIni()
		dataIni.setBounds(91, 30, 257, 20);
		contentPanel.add(dataIni);
		dataIni.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(24, 225, 98, 26);
		btnCadastrar.addActionListener(new CadastrarListener());
		contentPanel.add(btnCadastrar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(277, 225, 98, 26);
		btnConcluir.addActionListener(new ConcluidoListener());
		contentPanel.add(btnConcluir);
		
	}
	
	public TelaCadastraColegiado classe() {
		return this;
	}
	
	private class AtualizarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				SistemaColegiado sys = new SistemaColegiado(); //verificar tipos
			/*	colegiado.setDataIni(dataIni.getText());
				colegiado.setDataFim(dataFim.getText());
				colegiado.setAtivo(ativo.getText());*/
				sys.editaColegiado(colegiado);
				JOptionPane.showMessageDialog(classe(), "Colegiado Atualizado com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao Atualizar o Colegiado!");
			}
			
		}
		
	}
	
	private class CadastrarListener implements ActionListener{//verificar tipos.

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				SistemaColegiado sys = new SistemaColegiado();
//				sys.cadastraColegiado(dataIni.getText(),dataFim.getText(),ativo.getText());
				JOptionPane.showMessageDialog(classe(), "Colegiado Cadastrado com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao cadastrar o Colegiado!");
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
