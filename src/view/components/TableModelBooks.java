/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import domain.Book;
import domain.BookGenre;
import domain.Librarian;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LORA
 */
public class TableModelBooks extends AbstractTableModel{
    private final List<Book> books;
    private final String[] columnNames=new String[]{"ID","Naziv","Žanr"};

    public TableModelBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
         if(books!=null){
            return books.size();
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
        Book b=books.get(rowIndex);
        
        switch(columnIndex){
            case 0: return b.getBookID();
            case 1: return b.getName();
            case 2:return b.getBookGenre().getName();
            
            default: return null;
        }
    }
    
    public void addBook(long id, String name, BookGenre bg, Librarian lib){
        Book book=new Book();
        book.setBookID(id);
        book.setName(name);
        book.setBookGenre(bg);
        book.setLibrarian(lib);
        
        fireTableRowsInserted(books.size()-1, books.size()-1);
    }
    
    public void removeBook(int row){
        books.remove(row);
        fireTableDataChanged();
    }

    public Book getBook(int row) {
        return books.get(row);
    }
    
    
    
}
