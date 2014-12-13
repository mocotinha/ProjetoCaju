package br.edu.ifpb.caju.model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifpb.caju.model.Colegiado;

public class ColegiadoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private static final int COL_ID = 0;  //alterar
	private static final int COL_ATRIBUTO = 1;  
	
	private List<Colegiado> valores;
	
	

	public ColegiadoTableModel(List<Colegiado> valores) {
		this.valores = valores;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return valores.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
