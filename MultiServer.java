MultiServer.java

public class MultiServer {

    public void start()
    {

        try{

            ServerSocket serversocket= new ServerSocket(7000);

            for(;;)
            {

                System.out.pritnln("Server in attesa...");
                Socket socket = serversocket.accept();
                System.out.println("Server socket " + socket);
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();       


            }

        }catch(Exception e)
        {

            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza delk server");
            System.exit(1);


        }



    }


}
