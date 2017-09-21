package com.sda.bank;

import com.sda.bank.model.Klient;
import com.sda.bank.model.Konto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    public static void main(String[] args) {

        List<Klient> klientList = new ArrayList<>();

        Klient klient = new Klient("5467891211135353453", "Anna",
                "Jakubowska", "Staszica", 6456564,
                "Haslo3355##");

        Klient klient2 = new Klient("5555555535353453", "Hnna",
                "Kowalska", "Mickiewicz", 33442211,
                "Haslo435324");

        Klient klient3 = new Klient("99999999999935353453", "Ewa",
                "Jankowska", "Sienkiewicza", 432165477,
                "Haslo%%43534");

        klientList.add(klient);
        klientList.add(klient2);
        klientList.add(klient3);

        Konto konto = new Konto(klientList, new BigDecimal(10000));



        konto.zalogujSie(3344221, klient2.getHaslo());
        konto.zrobPrzelew(new BigDecimal(25));
        System.out.println("Bieżący stan konta wynosi:" + konto.getStanKonta());

    }

}
