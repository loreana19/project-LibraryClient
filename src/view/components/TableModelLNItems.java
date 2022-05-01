/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import domain.BookCopy;
import domain.LoanNote;
import domain.LoanNoteItem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LORA
 */
public class TableModelLNItems extends AbstractTableModel{

    private  final List<LoanNoteItem> loanNoteItems;
    private final String[] columnNames=new String[]{ "Primerak knjige", "Datum od","Datum do"};

    public TableModelLNItems() {
        loanNoteItems=new ArrayList<>();
        
    }

    public TableModelLNItems(List<LoanNoteItem> loanNoteItems) {
        this.loanNoteItems = loanNoteItems;
        fireTableDataChanged();
    }
    
    
    
    @Override
    public int getRowCount() {
        if(loanNoteItems!=null){
            return loanNoteItems.size();
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
        LoanNoteItem lnItem=loanNoteItems.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            //case 0: return lnItem.getLoanNoteItemID();
            case 0: return lnItem.getBookCopy().getBook().getName()+" "+ lnItem.getBookCopy().getPublicationYear();
            case 1: return sdf.format(lnItem.getDateFrom());
            case 2: return sdf.format(lnItem.getDateTo());
            
            default: return null;
        }
    }
    public void addLNItem(long id,BookCopy bookCopy, Date dateFrom, Date dateTo){
        LoanNoteItem lnItem=new LoanNoteItem();
        lnItem.setLoanNoteItemID(0l);
        lnItem.setBookCopy(bookCopy);
        lnItem.setDateFrom(dateFrom);
        lnItem.setDateTo(dateTo);

        loanNoteItems.add(lnItem);

        fireTableRowsInserted(loanNoteItems.size()-1, loanNoteItems.size()-1);
    }
    public void removeLNItem(int row){
        loanNoteItems.remove(row);
        fireTableDataChanged();
    }
    public void editLNItem(LoanNoteItem lnItem, int row){
        
    }

    public List<LoanNoteItem> getLoanNoteItems() {
        return loanNoteItems;
    }

    public LoanNoteItem getLoanNoteItems(int row) {
        return loanNoteItems.get(row);
    }


    public void refreshTable() {
        loanNoteItems.removeAll(loanNoteItems);
    }

    public void fillTableLNI(List<LoanNoteItem> listOfLoanNoteItems) {
        for (LoanNoteItem lni : listOfLoanNoteItems) {
            loanNoteItems.add(lni);
        }
        fireTableDataChanged();
    }

    public void editLNI(LoanNoteItem lni) {
        for (LoanNoteItem i : loanNoteItems) {
            if(i.getLoanNoteItemID().equals(lni.getLoanNoteID())){
                i.setBookCopy(lni.getBookCopy());
                i.setDateFrom(lni.getDateFrom());
                i.setDateTo(lni.getDateTo());
                fireTableDataChanged();
                return;
            }
        }
    }
}
