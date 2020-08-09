public class Client {
    private String name;
    private int number;

    public Client(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nNumber: " + number + "\n\n";
    }
}
