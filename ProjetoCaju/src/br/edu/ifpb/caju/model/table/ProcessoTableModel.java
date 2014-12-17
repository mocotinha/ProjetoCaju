package br.edu.ifpb.caju.model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifpb.caju.model.Processo;


public class ProcessoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private static final int COL_CODPROCESSO = 0;
	private static final int COL_MATREQUERENTE = 1;  
	private static final int COL_REQUERENTE = 2;  
	private static final int COL_DATADOC = 3;
	private static final int COL_ASSUNTO = 4;
	private static final int COL_PERIODO = 5;
	
	private List<Processo> valores;
	
	

	public ProcessoTableModel(List<Processo> valores) {
		this.valores = valores;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return valores.size();
	}
	
	public String getColumnName(int column) {  
        
        if (column == COL_CODPROCESSO) return "Codigo Processo";  
        if (column == COL_MATREQUERENTE) return "Matricula";
        if (column == COL_REQUERENTE) return "Requerente";
        if (column == COL_DATADOC) return "Data Processo";
        if(column == COL_ASSUNTO) return "Assunto";
        if(column == COL_PERIODO) return "Periodo";
       
        return "";   
    }  

	//@Override
	public Object getValueAt(int row, int column) {  
        
		Processo processo = valores.get(row);  
        if (column == COL_CODPROCESSO) return processo.getIdProcesso();  
        else if (column == COL_MATREQUERENTE) return processo.getMatRequerente();
        else if (column == COL_REQUERENTE) return processo.getNomeRequerente();
        else if (column == COL_DATADOC) return processo.getDataDoc();
        else if (column == COL_ASSUNTO) return processo.getAssunto();
        else if(column == COL_PERIODO) return processo.getPeriodo();
        	
        
   
        
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
	 
	 public Processo get(int row) {  
         return valores.get(row);  
     }

}
