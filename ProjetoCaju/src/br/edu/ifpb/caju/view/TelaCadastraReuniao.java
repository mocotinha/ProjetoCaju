package br.edu.ifpb.caju.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.edu.ifpb.caju.controller.Sistema;
import br.edu.ifpb.caju.model.Reuniao;

@SuppressWarnings("serial")
public class TelaCadastraReuniao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	@SuppressWarnings("unused")
	private Reuniao modelo;
	private JFormattedTextField atributo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastraModelo dialog = new TelaCadastraModelo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 * @wbp.parser.constructor
	 */
	
	public TelaCadastraReuniao(TelaMenu tela,Reuniao modelo) throws ParseException{
		super(tela,"Cadastro de Modelo",true);
		setTitle("Cadastro de Reuni\u00E3o");
		this.modelo = modelo;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 262);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblAtributo = new JLabel("Data da Reuni\u00E3o:");
		lblAtributo.setBounds(32, 33, 87, 14);
		contentPanel.add(lblAtributo);
		
		atributo = new JFormattedTextField(new MaskFormatter("##/##/####"));
		atributo.setText(modelo.getDataAgenda().toString());
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
	
	
	public TelaCadastraReuniao(TelaMenu tela) throws ParseException {
		super(tela,"Cadastro de Modelo",true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 262);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblAtributo = new JLabel("Data da Reuni\u00E3o:");
		lblAtributo.setBounds(32, 33, 71, 14);
		contentPanel.add(lblAtributo);
		
		atributo = new JFormattedTextField(new MaskFormatter("##/##/####"));
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
	
	private TelaCadastraReuniao classe(){
		return this;
	}
	
	private class AtualizarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
//				SistemaModelo sys = new SistemaModelo();
//				modelo.setAtributo(atributo.getText());
//				sys.editaModelo(modelo);TODO
				JOptionPane.showMessageDialog(classe(), "Reunião Atualizado com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao Atualizar a Reunião!");
			}
			
		}
		
	}
	
	private class CadastrarListener implements ActionListener{

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				Sistema sys = new Sistema();
				String [] valores = atributo.getText().split("/");
				sys.cadastraReuniao(new Date(Integer.parseInt(valores[2]), Integer.parseInt(valores[1]),Integer.parseInt(valores[0])));
				JOptionPane.showMessageDialog(classe(), "Reunião Cadastrada com Sucesso!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(classe(), "Erro ao cadastrar o Reunião!");
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
