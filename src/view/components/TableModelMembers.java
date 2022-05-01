/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import domain.Librarian;
import domain.Member;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LORA
 */
public class TableModelMembers extends AbstractTableModel{

    private final List<Member> members;
    private final String[] columnNames=new String[]{"ID","Ime","Prezime","Kontakt"};

    public TableModelMembers(List<Member> members) {
        this.members = members;
    }
    
    @Override
    public int getRowCount() {
          if(members!=null){
            return members.size();
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
        Member member=members.get(rowIndex);
        
        switch(columnIndex){
            case 0: return member.getMemberID();
            case 1: return member.getFirstName();
            case 2: return member.getLastName();
            case 3:return  member.getContact();
            
            default: return null;
        }
    }
    
    public void addMember(long id, String firstName, String lastName, String contact, Librarian lib){
        Member member=new Member();
        member.setMemberID(id);
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setContact(contact);
        member.setLibrarian(lib);
        
        fireTableRowsInserted(members.size()-1, members.size()-1);
    }
    public void removeMember(int row){
        members.remove(row);
        fireTableDataChanged();
    }

    public Member getMember(int row) {
        return members.get(row);
    }

    public void deleteMember(Member m) {
        members.remove(m);
        fireTableDataChanged();
                
    }
}
