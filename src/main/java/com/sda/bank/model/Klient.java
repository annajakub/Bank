package com.sda.bank.model;

public class Klient {
    private String nrKonta;
    private String imie;
    private String nazwisko;
    private String adres;
    private int login;
    private String haslo;


    public Klient(String nrKonta, String imie, String nazwisko, String adres, int login, String haslo) {
        this.nrKonta = nrKonta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.login = login;
        this.haslo = haslo;
    }

    public String getNrKonta() {
        return nrKonta;
    }

    public int getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }


    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

}
