/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.communication;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Book;
import java.net.Socket;


/**
 *
 * @author LORA
 */
public class Communication {
    private static Communication instance;
    private Socket socket;
   // Sender sender;
   // Receiver receiver;
    //ThreadClosedSocket thread;
    
    
    
    private Communication()throws Exception{
       // socket = new Socket("localhost", 9000);
     //   thread = new ThreadClosedSocket(socket);
       // startThread();
       // sender = new Sender(socket);
       // receiver = new Receiver(socket);
    }
    public static Communication getInstance()throws Exception{
        if(instance == null){
            instance=new Communication();
        }
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public Response login(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("Login request is sent");
        return (Response) new Receiver(socket).receive();        
    }


    public Response getAllBooksGenres(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetAllBookGenres request is sent");
        return (Response) new Receiver(socket).receive();  
    }

    
    public Response addBook(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("AddBook request is sent");
        return (Response) new Receiver(socket).receive();   
    }

    public Response addMember(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("AddMember request is sent");
        return (Response) new Receiver(socket).receive(); 
    }

    public Response getMemberID(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetMaxMemberID request is sent");
        return (Response) new Receiver(socket).receive();  
    }

    public Response addAuthor(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("AddAuthor request is sent");
        return (Response) new Receiver(socket).receive();    }

    public Response getAuthor(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetAuthor request is sent");
        return (Response) new Receiver(socket).receive();      }

    public Response addBookCopy(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("AddBookCopy request is sent");
        return (Response) new Receiver(socket).receive();  
    }

    public Response getAllBooks(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetAllBooks request is sent");
        return (Response) new Receiver(socket).receive();      }

    public Response getAllMembers(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetAllMembers request is sent");
        return (Response) new Receiver(socket).receive();      }

    public Response removeMember(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("RemoveMember request is sent");
        return (Response) new Receiver(socket).receive();  
    }

    public Response updateMember(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("UpdateMember request is sent");
        return (Response) new Receiver(socket).receive();      }

    public Response getMembers(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetMembers request is sent");
        return (Response) new Receiver(socket).receive();      }

    public Response getAllAuthors(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetAllAuthors request is sent");
        return (Response) new Receiver(socket).receive(); 
    }

    public Response addAuthorship(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("AddAuthorship request is sent");
        return (Response) new Receiver(socket).receive();     
    }

    public Response removeBook(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("RemoveBook request is sent");
        return (Response) new Receiver(socket).receive();    
    }

    public Response getAllAuthorships(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetAllAuthorships request is sent");
        return (Response) new Receiver(socket).receive();    
    }

    public Response getAllLN(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetAllLN request is sent");
        return (Response) new Receiver(socket).receive();     }

    public Response getAllBookCopies(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("GetAllBookCopies request is sent");
        return (Response) new Receiver(socket).receive();
    }


    public Response getMaxLNIID(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetMaxLoanNoteItemID request is sent");
        return (Response) new Receiver(socket).receive();       }

    public Response getMaxLoanNoteID(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetMaxLoanNoteID request is sent");
        return (Response) new Receiver(socket).receive();      }

    public Response addLoanNote(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("AddLoanNote request is sent");
        return (Response) new Receiver(socket).receive();    }

    public Response getAllLNItems(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetAllLNItems request is sent");
        return (Response) new Receiver(socket).receive();  
    }

    public Response getLNItems(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetLNItems request is sent");
        return (Response) new Receiver(socket).receive();      }

    public Response updateLN(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("UpdateLN request is sent");
        return (Response) new Receiver(socket).receive();     }

    public Response getMember(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetMember request is sent");
        return (Response) new Receiver(socket).receive();    }

    public Response getBook(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("GetBook request is sent");
        return (Response) new Receiver(socket).receive();      }

    public Response editBookCopy(Request request)throws Exception{
        new Sender(socket).send(request);
        System.out.println("EditBookCopy request is sent");
        return (Response) new Receiver(socket).receive();      }

   

    public Socket getSocket() {
        return socket;
    }
    
}
