package lab.WebSockets;

import base.Context;

public class Three extends Context {
    @Override
    protected void execute() {
        Server server = new Server();
        Thread watekServera = new Thread(server);
        watekServera.start();

        Client client1 = new Client();
        client1.connectToServer();

        Client client2 = new Client();
        client2.connectToServer();
    }
}
