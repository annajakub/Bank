package com.sda.bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Konto {

    private String nrKonta;
    private int login;
    private String haslo;
    private BigDecimal stanKonta;
    private boolean zalogowany;
    private List<Klient> klientList = new ArrayList<>();

    public Konto(List<Klient> klient, BigDecimal stanKonta) {
//        this.nrKonta = klient.getNrKonta();
//        this.login = klient.getLogin();
//        this.haslo = klient.getHaslo();
        this.klientList = klient;
        this.stanKonta = stanKonta;
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

    public BigDecimal getStanKonta() {
        return stanKonta;
    }

    public void zalogujSie(int loginPodanyPrzyObiekcie, String hasloPodanePrzyObiekcie) {

        for(Klient klient: klientList){

            if(hasloPodanePrzyObiekcie.equals(klient.getHaslo()) && klient.getLogin() == loginPodanyPrzyObiekcie){
                zalogowany = true;
                break;
            }
        }

    }

    public boolean isZalogowany() {
        return zalogowany;
    }

    public boolean zrobPrzelew(BigDecimal kwotaPrzelewu) {
        if ((isZalogowany()) && (kwotaPrzelewu.compareTo(getStanKonta()) <= 0)) {
            stanKonta = stanKonta.subtract(kwotaPrzelewu);
            System.out.println("Operacja się powiodła. Przelew został zrobiony.");
            return true;
        } else {
            System.out.println("Przepraszamy. Operacja nie powiodła się.");
            return false;
        }


    }
}