package br.edu.ifpb.caju.model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifpb.caju.model.Modelo;


public class ModeloTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;  
	private static final int COL_ATRIBUTO = 1;  


 
    
    private List<Modelo> valores;
    
    public ModeloTableModel(List<Modelo> valores) {  
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
	
	public String getColumnName(int column) {  
        
        if (column == COL_ID) return "ID";  
        if (column == COL_ATRIBUTO) return "Atributo";
 
        
        
        return "";   
    }  

	 public Object getValueAt(int row, int column) {  
          
		 Modelo mod = valores.get(row);  
         if (column == COL_ID) return mod.getId();  
         else if (column == COL_ATRIBUTO) return mod.getAtributo();
         
      
         return "";  
     }
	 
	 public void setValueAt(Object aValue, int rowIndex, int columnIndex) {} //Metodo se permitir que se altere as celulas
	 
	 public Class<?> getColumnClass(int columnIndex) {   
         return String.class;  
     }
	 
	 public boolean isCellEditable(int rowIndex, int columnIndex) {    
         return false;  
     }
	 
	 public Modelo get(int row) {  
         return valores.get(row);  
     }

}
