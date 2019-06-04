package by.yandex.sidvlada;

import java.util.ArrayList;
import java.util.List;

public class BarberShop {

    private boolean isOpen;
    private Boolean isBusy;

    private List<Integer> cash;
    private List<Parfume> parfumes;

    private String clientName;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
        System.out.println("BarberShop: " + (open ? "Open" : "Closed"));
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void addMoneyToCash(Integer integer) {
        if (cash == null) cash = new ArrayList<>();
        cash.add(integer);
    }

    public void addParfumes(List<Parfume> parfumeList) {
        if (parfumes == null) parfumes = new ArrayList<>();
        parfumes.addAll(parfumeList);
    }

    public Parfume takeParfume() {
        return parfumes.remove(0);
    }

    public boolean isParfumeEmpty() {
        return parfumes.isEmpty();
    }

    public synchronized void newClient() {

        try {
            String clientName = Thread.currentThread().getName();
            System.out.println("BarberShop: new client: " + clientName);

            while(this.clientName != null) {
                Thread.sleep(500);
                System.out.println("BarberShop: client " + clientName + " is waiting");
            }
            this.clientName = clientName;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void makeHairDress() {
        try {
            String barberName = Thread.currentThread().getName();
            while (clientName != null) {
                Parfume parfume = takeParfume();

                setBusy(true);
                System.out.println("BarberShop: " + barberName + " takes " + parfume);
                System.out.println("BarberShop: " + barberName + " is serving " + clientName);
                Thread.sleep(2000);

                setBusy(false);
                System.out.println("BarberShop: " + barberName + " finished " + clientName);
                this.clientName = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
