package br.edu.ifpb.caju.view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import br.edu.ifpb.caju.controller.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class TelaCadastroProcesso extends JDialog {
	private JTextField nomeField;
	private JTextField matriculaField;
	private JTextField periodoField;
	private JTextField assuntoField;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProcesso dialog = new TelaCadastroProcesso();
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
	public TelaCadastroProcesso() {
		setTitle("Processo");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		nomeField = new JTextField();
		nomeField.setBounds(89, 57, 270, 20);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		matriculaField = new JTextField();
		matriculaField.setBounds(88, 88, 108, 20);
		getContentPane().add(matriculaField);
		matriculaField.setColumns(10);
		
		periodoField = new JTextField();
		periodoField.setBounds(88, 124, 108, 20);
		getContentPane().add(periodoField);
		periodoField.setColumns(10);
		
		assuntoField = new JTextField();
		assuntoField.setBounds(89, 186, 270, 20);
		getContentPane().add(assuntoField);
		assuntoField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(17, 60, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(17, 91, 61, 14);
		getContentPane().add(lblMatricula);
		
		JLabel lblData = new JLabel("Periodo");
		lblData.setBounds(17, 127, 46, 14);
		getContentPane().add(lblData);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(17, 158, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAssunto = new JLabel("Assunto");
		lblAssunto.setBounds(17, 189, 46, 14);
		getContentPane().add(lblAssunto);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ConcluidoListener());
		btnConcluir.setBounds(254, 217, 89, 23);
		getContentPane().add(btnConcluir);
		
		JButton btnCancelar = new JButton("Cadastrar");
		btnCancelar.addActionListener(new CadastrarListener());
		btnCancelar.setBounds(27, 217, 89, 23);
		getContentPane().add(btnCancelar);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(88, 155, 108, 20);
		getContentPane().add(dateChooser);
		
		JLabel lblMatriculaTemQue = new JLabel("*Matricula tem que ser em Inteiro");
		lblMatriculaTemQue.setBounds(206, 91, 206, 14);
		getContentPane().add(lblMatriculaTemQue);

	}
	private TelaCadastroProcesso classe(){
		return this;
	}
	
	private class CadastrarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				Sistema sys = new Sistema();
				sys.cadastraProcesso(nomeField.getText().trim(), matriculaField.getText().trim(), periodoField.getText().trim(), dateChooser.getDate(), assuntoField.getText().trim());
				JOptionPane.showMessageDialog(classe(), "Processo Cadastrado com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao cadastrar o Processo!");
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
