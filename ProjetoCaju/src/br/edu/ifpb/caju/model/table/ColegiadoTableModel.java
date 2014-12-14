package br.edu.ifpb.caju.model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifpb.caju.model.Colegiado;


public class ColegiadoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private static final int COL_ID = 0;
	private static final int COL_DATAINI = 1;  
	private static final int COL_DATAFIM = 2;  
	private static final int COL_ATIVO = 3;  
	
	private List<Colegiado> valores;
	
	

	public ColegiadoTableModel(List<Colegiado> valores) {
		this.valores = valores;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return valores.size();
	}
	
	public String getColumnName(int column) {  
        
        if (column == COL_ID) return "ID";  
        if (column == COL_DATAINI) return "DataIni";
        if (column == COL_DATAFIM) return "DataFim";
        if (column == COL_ATIVO) return "Ativo";
       
        return "";   
    }  

	//@Override
	public Object getValueAt(int row, int column) {  
        
		Colegiado coleg = valores.get(row);  
        if (column == COL_ID) return coleg.getId();  
        else if (column == COL_DATAINI) return coleg.getDataIni();
        else if (column == COL_DATAFIM) return coleg.getDataFim();
        else if (column == COL_ATIVO) return coleg.isAtivo();
        
        return "";  
    }
	
	//Verificar e implementar.
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {} //Metodo se permitir que se altere as celulas
	 
	 public Class<?> getColumnClass(int columnIndex) {   
         return String.class;  
     }
	 
	 public boolean isCellEditable(int rowIndex, int columnIndex) {    
         return false;  
     }
	 
	 public Colegiado get(int row) {  
         return valores.get(row);  
     }

}
