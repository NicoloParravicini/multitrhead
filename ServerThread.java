ServerThread.java


public ServerThread extends Thread {

    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    
    BufferedReader indDalClient;
    DataOutputStream outVersoClient;
    
public ServerThread (Socket socket)
{

    this.client = socket;


}

public void run()
{

    try{
        comunica();


    }catch(Exception e)
    {

e.printStackTrace(System.out);

    }


} //fine metodo run


public void comunica() throws Exception
{

    indDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
    outPutVersoServer = new DataOutputStream(client.getOutputStream());

    for(;;)
    {

        stringaRicevuta = indDalClient.readline();

        if(stringaRicevuta == null || stringaRicevuta.equals("FINE"))

        {

            outVersoClient.writeBytes(stringaRicevuta + "server in chiusura..." + '\n');
            System.out.println("Stampa sul server in chiusura: " + stringaRicevuta);
            break;
            
        }else{

            outPutVersoClient.close();
            indDalClient.close();
            System.out.println("Chiusura socket" + client);
            client.close();

        }



    }




}

} //fine classe thread