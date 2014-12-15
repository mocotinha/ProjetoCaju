package br.edu.ifpb.caju.model.table;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifpb.caju.model.Ata;


public class AtaTableModel extends AbstractTableModel {

	private static final int COL_ID = 0;
	private static final int COL_TEXTO = 1;
	
	private List<Ata> ata;
	
	public AtaTableModel(List<Ata> ata){
		this.ata = ata;
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int row, int column) {

		Ata valor = ata.get(row);
		if (column == COL_TEXTO) return valor.getTexto();
		
		
		return "";  
	}

	public Ata get(int row) {
		return ata.get(row);
	}

	

}
