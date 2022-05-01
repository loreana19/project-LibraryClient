/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.communication.Communication;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.form.Login;

/**
 *
 * @author LORA
 */
public class Client {
    public static void main(String[] args) {
        Client client =new Client();
        try {
            client.connect();
            System.out.println("Client is connected");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void connect() throws Exception {
        Socket socket=new Socket("127.0.0.1", 9000);
        System.out.println("Client is connected");
        Communication.getInstance().setSocket(socket);
        new Login().setVisible(true);
    }
}
