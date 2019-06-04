package by.yandex.sidvlada;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BarberShop barberShop = new BarberShop();

        List<Parfume> initialParfumes = List.of(
                new Parfume("p1"),
                new Parfume("p2"),
                new Parfume("p3"));

        barberShop.addParfumes(initialParfumes);

        Barber barber = new Barber(barberShop);
        Thread barberThread = new Thread(barber);
        barberThread.start();


        for (int i = 1; i <= 3; i++) {
            Client client1 = new Client();
            client1.setBarberShop(barberShop);
            new Thread(client1, "Client" + i).start();
        }
    }
}
