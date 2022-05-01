/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import domain.Librarian;
import domain.LoanNote;
import domain.LoanNoteItem;
import domain.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LORA
 */
public class TableModelLN extends AbstractTableModel{

    private final List<LoanNote> ln;
    private final String[] columnNames=new String[]{"ID", "Datum", "Ime i prezime člana"};

    public TableModelLN(List<LoanNote> ln) {
        this.ln = ln;
    }
     
    @Override
    public int getRowCount() {
        if(ln!=null){
            return ln.size();
        }
        return 0;     }

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
         LoanNote loanNote=ln.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        switch(columnIndex){
            case 0: return loanNote.getLoanNote();
            case 1: return sdf.format(loanNote.getDate());
            case 2: return loanNote.getMember().getFirstName()+" "+loanNote.getMember().getLastName();
           
            
            default: return null;
        }
    }
    
    public void addLN(long id, Date date, Librarian lib, Member member, List<LoanNoteItem> loanNoteItems){
        LoanNote loanNote=new LoanNote();
        loanNote.setLoanNote(id);
        loanNote.setDate(date);
        loanNote.setLibrarian(lib);
        loanNote.setMember(member);
        loanNote.setListOfLoanNoteItems(loanNoteItems);
        
        fireTableRowsInserted(ln.size()-1, ln.size()-1);

    }
    public void removeLN(int row){
        ln.remove(row);
        fireTableDataChanged();
    }

    public List<LoanNote> getLn() {
        return ln;
    }

    public LoanNote getLN(int row) {
        return ln.get(row);
    }
    
}
