package lab.ClassicWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {
    ArrayList strumienieWyjsciowe;

    public class ClientServant implements Runnable {
        BufferedReader czytelnik;
        Socket gniazdo;

        public ClientServant(Socket gniazdo) {
            try {
                this.gniazdo = gniazdo;
                InputStreamReader reader = new InputStreamReader(gniazdo.getInputStream());
                czytelnik = new BufferedReader(reader);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            String wiadomosc;
            try {
                while ((wiadomosc = czytelnik.readLine()) != null) {
                    System.out.println("Odczytano: " + wiadomosc);
                    broadcastMessage(wiadomosc);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void start() {
        strumienieWyjsciowe = new ArrayList();
        try {
            ServerSocket gniazdoSerwera = new ServerSocket(2025);
            while (true) {
                Socket gniazdoKlienta = gniazdoSerwera.accept();
                PrintWriter pisarz = new PrintWriter(gniazdoKlienta.getOutputStream());
                strumienieWyjsciowe.add(pisarz);
                Thread watekKlienta = new Thread(new ClientServant(gniazdoKlienta));
                watekKlienta.start();
                System.out.println("Nawiązano połączenie!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        Iterator it = strumienieWyjsciowe.iterator();
        while (it.hasNext()) {
            try {
                PrintWriter pisarz = (PrintWriter) it.next();
                pisarz.println(message);
                pisarz.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
