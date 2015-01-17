package br.edu.ifpb.caju.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.ifpb.caju.controller.Sistema;

@SuppressWarnings("serial")
public class TelaCadastraMembro extends JDialog {
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField telefoneField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastraMembro dialog = new TelaCadastraMembro(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastraMembro(TelaMenu tela) {
		super(tela,"Cadastrar Membro", true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		nomeField = new JTextField();
		nomeField.setBounds(96, 25, 225, 20);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(96, 56, 225, 20);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		
		telefoneField = new JTextField();
		telefoneField.setBounds(96, 87, 117, 20);
		getContentPane().add(telefoneField);
		telefoneField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(40, 28, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 59, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(40, 90, 46, 14);
		getContentPane().add(lblTelefone);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new CadastrarListener());
		btnNewButton.setBounds(40, 210, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ConcluidoListener());
		btnConcluir.setBounds(267, 210, 89, 23);
		getContentPane().add(btnConcluir);

	}
	
	private TelaCadastraMembro classe(){
		return this;
	}
	
	private class CadastrarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				Sistema sys = new Sistema();
				sys.cadastraMembro(nomeField.getText().trim(), emailField.getText().trim(), telefoneField.getText().trim());
				JOptionPane.showMessageDialog(classe(), "Membro Cadastrado com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao cadastrar o Membro!");
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
