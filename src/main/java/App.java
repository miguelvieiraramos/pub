import javax.swing.*;

public class App {
    public static void main(String[] args) {
        GsonClient<Client> gsonClient = new GsonClient<>();
        Pub pub = new Pub(gsonClient);

        int flag = 0;
        int menu;
        String name;
        int number;
        while (flag == 0) {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - Add new client\n2 - Remove client\n3 - List clients\n0 - Leave"));
            switch (menu) {
                case 1:
                    name = JOptionPane.showInputDialog("Name: ");
                    number = Integer.parseInt(JOptionPane.showInputDialog("Number: "));
                    Client newClient = new Client(name, number);
                    if (pub.addClient(newClient)) {
                        JOptionPane.showMessageDialog(null, "Client was added.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Client already existis.");
                    }
                    break;
                case 2:
                    name = JOptionPane.showInputDialog("Name: ");
                    number = Integer.parseInt(JOptionPane.showInputDialog("Number: "));
                    Client removedClient = new Client(name, number);
                    if (pub.removeClient(removedClient)) {
                        JOptionPane.showMessageDialog(null, "Client removed.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Client does not exist.");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, pub.listClients());
                    break;
                case 0:
                    flag = 1;
                    break;
            }
        }
    }
}
