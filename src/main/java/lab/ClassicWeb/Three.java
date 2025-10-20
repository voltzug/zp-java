package lab.ClassicWeb;

import base.Context;

public class Three extends Context {
    @Override
    protected void execute() {
        Server server = new Server();
        server.start();

        Client client = new Client();
        client.connectTo();
    }
}
