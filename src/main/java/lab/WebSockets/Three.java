package lab.WebSockets;

import base.Context;

public class Three extends Context {
    @Override
    protected void execute() {
        Server server = new Server();
        Thread watekServera = new Thread(server);
        watekServera.start();

        Client client1 = new Client("K1");
        client1.execute();

        Client client2 = new Client("K2");
        client2.execute();
    }
}
