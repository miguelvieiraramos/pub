import java.util.ArrayList;
import java.util.List;

public class Pub {
    private SerializerInterface<Client> serializer;
    private List<Client> clients = new ArrayList<>();


    public Pub(SerializerInterface serializer) {
        this.serializer = serializer;
        List<Client> storedClients = serializer.read("clients.json", Client.class);
        if (storedClients != null) {
            this.clients = storedClients;
        }
    }

    public boolean addClient (Client newClient) {
        if (this.clients.size() == 0) {
            this.storeClient(newClient);
            return true;
        } else {
            if (this.findClient(newClient) >= 0) {
                return false;
            } else {
                this.storeClient(newClient);
                return true;
            }
        }
    }

    public String listClients () {
        String clientList = "";
        for (Client client: this.clients) {
            clientList += client.toString();
        }
        return clientList;
    }

    private void storeClient (Client newClient) {
        this.clients.add(newClient);
        serializer.write(clients, "clients.json");
    }

    public boolean removeClient (Client removedClient) {
        int clientPosition = findClient(removedClient);
        if (clientPosition >= 0) {
            clients.remove(clientPosition);
            serializer.write(clients, "clients.json");
            return true;
        }
        return false;
    }

    private int findClient (Client auxClient) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getName().toLowerCase().equals(auxClient.getName().toLowerCase()) &&
                    clients.get(i).getNumber() == auxClient.getNumber()) {
                return i;
            }
        }
        return -1;
    }
}
