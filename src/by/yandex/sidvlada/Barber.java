package by.yandex.sidvlada;

public class Barber implements Runnable {

    private BarberShop barberShop;

    public Barber(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        try {
            barberShop.setOpen(true);
            boolean isParfumeEmty = barberShop.isParfumeEmpty();
            while (!isParfumeEmty) {
                barberShop.makeHairDress();
                Thread.sleep(10000);
                isParfumeEmty = barberShop.isParfumeEmpty();
            }
            barberShop.setOpen(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}