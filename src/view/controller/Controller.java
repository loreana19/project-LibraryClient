/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import client.communication.Communication;
import communication.Operations;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import domain.Author;
import domain.Authorship;
import domain.Book;
import domain.BookCopy;
import domain.BookGenre;
import domain.Librarian;
import domain.LoanNote;
import domain.LoanNoteItem;
import domain.Member;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LORA
 */
public class Controller {
    private static Controller instance;
    private Librarian currentLibrariran;
    
    private Controller(){
        
    }
    
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }

    public Librarian login(String username, String password)throws Exception {
         Librarian librarian=new Librarian();
         librarian.setUsername(username);
         librarian.setPassword(password);
         
         Request request=new Request(Operations.LOGIN, librarian);
         Response response=Communication.getInstance().login(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
                Librarian l=(Librarian) response.getResponse();
                return l;
            }else{
                throw response.getException();
         
         }
        
    }

    public void setCurrentLibrarian(Librarian lib) {
        this.currentLibrariran=lib;
    }

    public Librarian getCurrentLibrarian() {
        return currentLibrariran;
    }

    public List<BookGenre> getAllGenres() throws Exception {
         Request request=new Request(Operations.GET_ALL_BOOKGENRES, null);
         Response response=Communication.getInstance().getAllBooksGenres(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<BookGenre> bookGenres=(List<BookGenre>) response.getResponse();
             return bookGenres;
            }else{
                throw response.getException();
         
         }
    }

    public void addBook(Book book)throws Exception{
         Request request=new Request(Operations.ADD_BOOK, book);
         Response response=Communication.getInstance().addBook(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }  
    }

    public void addMember(Member member)throws Exception{
         Request request=new Request(Operations.ADD_MEMBER, member);
         Response response=Communication.getInstance().addMember(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }  
    }


 
    public void addBookCopy(BookCopy bc)throws Exception{
         Request request=new Request(Operations.ADD_BOOKCOPY, bc);
         Response response=Communication.getInstance().addBookCopy(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }     
    }

    public List<Book> getAllBooks() throws Exception{
         Request request=new Request(Operations.GET_BOOKS, null);
         Response response=Communication.getInstance().getAllBooks(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<Book> books=(List<Book>) response.getResponse();
             return books;
            }else{
                throw response.getException();
         
         }
    }

    public List<Member> getAllMembers() throws Exception{
         Request request=new Request(Operations.GET_ALL_MEMBERS, null);
         Response response=Communication.getInstance().getAllMembers(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<Member> members=(List<Member>) response.getResponse();
             return members;
            }else{
                throw response.getException();
         
         }   
    }

    public void removeMember(Member m) throws Exception{
         Request request=new Request(Operations.REMOVE_MEMBER, m);
         Response response=Communication.getInstance().removeMember(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }  
    }

    public void updateMember(Member m)throws Exception{
         Request request=new Request(Operations.UPDATE_MEMBER, m);
         Response response=Communication.getInstance().updateMember(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }      
    }

 

    public List<Author> getAuthors()throws Exception{
         Request request=new Request(Operations.GET_AUTHORS, null);
         Response response=Communication.getInstance().getAllAuthors(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<Author> authors=(List<Author>) response.getResponse();
             return authors;
            }else{
                throw response.getException();
         
         }   
    }

    public void addAuthorship(Authorship a)throws Exception{
         Request request=new Request(Operations.ADD_AUTHORSHIP, a);
         Response response=Communication.getInstance().addAuthorship(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }   
    }

    public void removeBook(Book b)throws Exception{
         Request request=new Request(Operations.REMOVE_BOOK, b);
         Response response=Communication.getInstance().removeBook(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }   
    }



    public List<Authorship> getAllAuthorships() throws Exception {
         Request request=new Request(Operations.GET_ALL_AUTHORSHIPS, null);
         Response response=Communication.getInstance().getAllAuthorships(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<Authorship> authorships=(List<Authorship>) response.getResponse();
             return authorships;
            }else{
                throw response.getException();
         
         }    
    }

    public List<LoanNote> getAllLN() throws Exception{
         Request request=new Request(Operations.GET_ALL_LN, null);
         Response response=Communication.getInstance().getAllLN(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<LoanNote> loanNotes=(List<LoanNote>) response.getResponse();
             return loanNotes;
            }else{
                throw response.getException();
         
         }     
    }

    public List<BookCopy> getAllBookCopies()throws Exception{
         Request request=new Request(Operations.GET_ALL_BOOKCOPIES, null);
         Response response=Communication.getInstance().getAllBookCopies(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<BookCopy> bc=(List<BookCopy>) response.getResponse();
             return bc;
            }else{
                throw response.getException();
         
         }      }



    public void addLoanNote(LoanNote ln)throws Exception{
         Request request=new Request(Operations.ADD_LOANNOTE, ln);
         Response response=Communication.getInstance().addLoanNote(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }  
    }

  

   /* public List<LoanNoteItem> getLNItems(Long loanNote)throws Exception{
         Request request=new Request(Operations.GET_LNItems, loanNote);
         Response response=Communication.getInstance().getLNItems(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<LoanNoteItem> lni=(List<LoanNoteItem>) response.getResponse();
             return lni;
            }else{
                throw response.getException();
         
             }
    }*/

    public void updateLoanNote(LoanNote ln)throws Exception{
         Request request=new Request(Operations.UPDATE_LN, ln);
         Response response=Communication.getInstance().updateLN(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
             }   
    }

    public List<Member> getMember(Member m) throws Exception{
        Request request=new Request(Operations.GET_MEMBER, m);
        Response response=Communication.getInstance().getMember(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<Member> list=(List<Member>)response.getResponse();
             return list;
         }else{
                throw response.getException();
         
         }   
         
    }

    public List<Book> getAllBooks(Book b) throws Exception{
        Request request=new Request(Operations.GET_ALL_BOOKS, b);
        Response response=Communication.getInstance().getBook(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) && response.getResponse()!=null){
             List<Book> list=(List<Book>)response.getResponse();
             return list;
         }else{
                throw response.getException();
         
         }   
    }

    public void editBC(BookCopy bc)throws Exception{
        Request request=new Request(Operations.EDIT_BOOKCOPY, bc);
        Response response=Communication.getInstance().editBookCopy(request);
         
         if(response.getResponseType().equals(ResponseType.SUCCESS) ){
             
            }else{
                throw response.getException();
         
         }   
    }
}
