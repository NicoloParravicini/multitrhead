Server_socket.java


import java.io.*;
import java.net.*;
import java.util.*;

public class Server_socket extends Thread{
    
    
    
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    
    BufferedReader indDalClient;
    DataOutputStream outVersoClient;
    


    
public Socket attendi()
{
    
    try
    {
        
        System.out.println("Server partito ");
        
        server = new ServerSocket(7000);
        
        //attesa di un client+
        
        client = server.accept();
        
        server.close();
        
        indDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                
        outVersoClient = new DataOutputStream(client.getOutputStream());
        
        
        
    } catch(Exception e)
    {
        
        System.out.println(e.getMessage());
        
        System.out.println(" Errore durante creazione");
        
        
        System.exit(1);
        
    }
    
    return client;
    
    
} //fine metodo attendi
    

public void comunica()
{
    
    try
    {
        
        System.out.println("Ciao! Scrivi una frase e la trasformo in maiuscolo");
        
        stringaRicevuta = indDalClient.readLine();
        
        System.out.println("La frase digitata è: " + stringaRicevuta);
        
        stringaModificata = stringaRicevuta.toUpperCase();
        
        System.out.println("Invio della modifica della frase al client...");
        
        outVersoClient.writeBytes(stringaModificata + "\n");
        
        
        //dopo cio chiudo comunicazione col client
        
        System.out.println("Chiusura socket");
    
        
        client.close();
        
    } catch(Exception e)

    {
            System.out.println("errore");
            System.out.println(e.getMessage());

    }

    
    
    
}
    
    

    
} //fine classe