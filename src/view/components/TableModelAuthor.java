/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import domain.Author;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LORA
 */
public class TableModelAuthor extends AbstractTableModel{

    private final List<Author> authors;
    private final String[] columnNames=new String[]{"ID","Ime","Prezime"};

    public TableModelAuthor() {
        authors=new ArrayList<>();
    }     
    
    @Override
    public int getRowCount() {
        if(authors!=null){
        return authors.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Author author=authors.get(rowIndex);
        switch(columnIndex){
            case 0: return author.getAuthorID();
            case 1: return author.getFirstName();
            case 2:return author.getLastName();
            
            default: return null;
        }
    }
    public  void addAuthor(Author a){
        if(!authors.contains(a)){ 
        authors.add(a);
        fireTableDataChanged();
    }else{
            JOptionPane.showMessageDialog(null, "Autor "+a+" je vec izabran");
        }
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public boolean isAuhor(Author a) {
        for (Author author : authors) {
            if(author.equals(a))
                return true;
        }
        return false;
    }

    public void refreshTable() {
        authors.removeAll(authors);
        fireTableDataChanged();
    }

    
    
}
