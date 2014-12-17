package br.edu.ifpb.caju.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.ifpb.caju.controller.SistemaModelo;
import br.edu.ifpb.caju.model.table.ModeloTableModel;

@SuppressWarnings("serial")
public class TelaListaModelo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	private SistemaModelo sys = new SistemaModelo();
	private TelaMenu tela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaListaModelo dialog = new TelaListaModelo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaListaModelo(TelaMenu tela) {
		super(tela,"Lista Modelos",true);
		this.tela = tela;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar:");
		lblNewLabel.setBounds(10, 25, 46, 14);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(66, 22, 254, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(330, 19, 98, 26);
		btnBuscar.addActionListener(new BuscarListener());
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 50, 408, 162);
		contentPanel.add(scrollPane);
		
		table = new JTable(new ModeloTableModel(sys.getAllModelos()));
		scrollPane.setViewportView(table);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(30, 223, 98, 26);
		btnEditar.addActionListener(new EditarListener());
		contentPanel.add(btnEditar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(300, 223, 98, 26);
		btnConcluir.addActionListener(new ConcluirListener());
		contentPanel.add(btnConcluir);
		
	}
	

	
	private class BuscarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			table.setModel(new ModeloTableModel(sys.getModeloPorAtributo(textField.getText())));
			
		}
		
	}
	
	private class EditarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastraModelo tcm = new TelaCadastraModelo(tela,((ModeloTableModel)table.getModel()).get(table.getSelectedRow()));
			tcm.setVisible(true);
			table.setModel(new ModeloTableModel(sys.getAllModelos()));
			
		}
		
	}
	
	private class ConcluirListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
		
	}
}
