package br.edu.ifpb.caju.model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifpb.caju.model.Reuniao;


@SuppressWarnings("serial")
public class ReuniaoTableModel extends AbstractTableModel{

	
	private static final int COL_ID = 0;  
	private static final int COL_DATA_AGENDA = 1;  


 
    
    private List<Reuniao> valores;
    
    public ReuniaoTableModel(List<Reuniao> valores) {  
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
        if (column == COL_DATA_AGENDA) return "Data Agenda";
 
        
        
        return "";   
    }  

	 public Object getValueAt(int row, int column) {  
          
		 Reuniao mod = valores.get(row);  
         if (column == COL_ID) return mod.getId();  
         else if (column == COL_DATA_AGENDA) return mod.getDataAgenda();
         
      
         return "";  
     }
	 
	 public void setValueAt(Object aValue, int rowIndex, int columnIndex) {} //Metodo se permitir que se altere as celulas
	 
	 public Class<?> getColumnClass(int columnIndex) {   
         return String.class;  
     }
	 
	 public boolean isCellEditable(int rowIndex, int columnIndex) {    
         return false;  
     }
	 
	 public Reuniao get(int row) {  
         return valores.get(row);  
     }

}
