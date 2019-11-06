import com.sda.statics.Client;

public class MainStatics {

    public static void main(String[] args) {
        //accesez de pe tip de data
        System.out.println("Numar de ordine inainte de creare obiecte: ");
        System.out.println(Client.nrOrdine);

        //creez primul obiect
        Client client1 = new Client("Ana");
        System.out.println("Numar de ordine dupa creare obiecte: ");
        System.out.println(Client.nrOrdine);

        //creez al doilea obiect
        Client client2 = new Client("Radu");
        System.out.println("Numar de ordine dupa creare obiecte: ");
        System.out.println(Client.nrOrdine);

        Client.cresteNrOrdine();
        Client.cresteNrOrdine();
        Client.cresteNrOrdine();
        Client.cresteNrOrdine();

        System.out.println(Client.nrOrdine);
    }
}
