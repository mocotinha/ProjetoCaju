package br.edu.ifpb.caju.model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifpb.caju.model.Membro;
import br.edu.ifpb.caju.model.Presidente;


public class MembroTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;  
	private static final int COL_EMAIL = 2;  
	private static final int COL_TELFONE = 3;
	private static final int COL_TIPO = 4;
	
	private List<Membro> valores;
	
	

	public MembroTableModel(List<Membro> valores) {
		this.valores = valores;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return valores.size();
	}
	
	public String getColumnName(int column) {  
        
        if (column == COL_ID) return "ID";  
        if (column == COL_NOME) return "Nome";
        if (column == COL_EMAIL) return "Email";
        if (column == COL_TELFONE) return "TELEFONE";
        if(column == COL_TIPO) return "Tipo";
       
        return "";   
    }  

	//@Override
	public Object getValueAt(int row, int column) {  
        
		Membro membro = valores.get(row);  
        if (column == COL_ID) return membro.getId();  
        else if (column == COL_NOME) return membro.getNome();
        else if (column == COL_EMAIL) return membro.getEmail();
        else if (column == COL_TELFONE) return membro.getTelefone();
        else if (column == COL_TIPO){
        	if(membro instanceof Presidente){
        		return "Presidente";
        	}else{
        		return "Membro";
        	}
        	
        }
   
        
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
	 
	 public Membro get(int row) {  
         return valores.get(row);  
     }

}
