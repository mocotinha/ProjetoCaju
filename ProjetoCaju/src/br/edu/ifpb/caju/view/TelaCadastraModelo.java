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

import br.edu.ifpb.caju.controller.SistemaModelo;
import br.edu.ifpb.caju.model.Modelo;

@SuppressWarnings("serial")
public class TelaCadastraModelo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField atributo;
	private Modelo modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastraReuniao dialog = new TelaCadastraReuniao(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	
	public TelaCadastraModelo(TelaMenu tela,Modelo modelo){
		super(tela,"Cadastro de Modelo",true);
		this.modelo = modelo;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 262);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblAtributo = new JLabel("Atributo:");
		lblAtributo.setBounds(32, 33, 71, 14);
		contentPanel.add(lblAtributo);
		
		atributo = new JTextField(this.modelo.getAtributo());
		atributo.setBounds(91, 30, 257, 20);
		contentPanel.add(atributo);
		atributo.setColumns(10);
		
		JButton btnCadastrar = new JButton("Atualizar");
		btnCadastrar.setBounds(24, 225, 98, 26);
		btnCadastrar.addActionListener(new AtualizarListener());
		contentPanel.add(btnCadastrar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(277, 225, 98, 26);
		btnConcluir.addActionListener(new ConcluidoListener());
		contentPanel.add(btnConcluir);
	}
	
	
	public TelaCadastraModelo(JFrame tela) {
		super(tela,"Cadastro de Modelo",true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 262);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblAtributo = new JLabel("Atributo:");
		lblAtributo.setBounds(32, 33, 71, 14);
		contentPanel.add(lblAtributo);
		
		atributo = new JTextField();
		atributo.setBounds(91, 30, 257, 20);
		contentPanel.add(atributo);
		atributo.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(24, 225, 98, 26);
		btnCadastrar.addActionListener(new CadastrarListener());
		contentPanel.add(btnCadastrar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(277, 225, 98, 26);
		btnConcluir.addActionListener(new ConcluidoListener());
		contentPanel.add(btnConcluir);
		
	}
	
	private TelaCadastraModelo classe(){
		return this;
	}
	
	private class AtualizarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				SistemaModelo sys = new SistemaModelo();
				modelo.setAtributo(atributo.getText());
				sys.editaModelo(modelo);
				JOptionPane.showMessageDialog(classe(), "Modelo Atualizado com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao Atualizar o Modelo!");
			}
			
		}
		
	}
	
	private class CadastrarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				SistemaModelo sys = new SistemaModelo();
				sys.cadastraModelo(atributo.getText());
				JOptionPane.showMessageDialog(classe(), "Modelo Cadastrado com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao cadastrar o Modelo!");
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
