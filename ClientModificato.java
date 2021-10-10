ClientModificato.java

public class ClientModificato{

    public void comunica() {

for(;;){

    try{

            System.out.println("Inserisci la stringa da mandare al server");
            stringaUtenteDigitata = inputTastiera.readline();

            System.out.println("invio della stringa al server e attendo...");
            outPutVersoServer.writeBytes(stringaUtenteDigitata + '\n');

            stringaRicevutaServer = indDalClient.readline();
            System.out.println("risposta dal server " + '\n' + stringaRicevutaServer);
            
            if(stringaUtenteDigitata.equals("FINE"))
            {

                System.out.println("termino elaborazione e chiudo il socket");
                mySocket.close();
                break;


            }


    }catch(Exception e)
    {

        System.out.println(e.getMessage());
        System.out.println("ERRORE DURANTE LA COMUNICAZIONE");
        System.exit(1);
    }



}


    


}

public Socket connetti()
{

    System.out.println("Client partito");

    try{

        inputTastiera = new BufferedReader(new InputStreamReader(System.in));

        mySocket = new Socket(nomeServer, portaServer);

        outPutVersoServer = new DataOutputStream(mySocket.getOutputStream());
        inputDalServer = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));


    }catch(UnknownHostException e){

        System.out.println("Host sconosciuto");


    }catch(Exception e)
    {

        System.out.println(e.getMessage());
        System.out.println("errore durante la connessione");
        System.exit(1);

    }


return mySocket;


}


} //fine classe 

