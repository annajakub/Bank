package com.sda.bank;

import com.sda.bank.model.Klient;
import com.sda.bank.model.Konto;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.withinPercentage;

@RunWith(DataProviderRunner.class)
public class KontoTest {

    @DataProvider
    public static Object[][] dataProviderKonto() {

        Klient klient = new Klient("9999 9999 9999 9999", "Anna",
                "Jakubowska", "Staszica", 23444,
                "haslo#");
        Klient klient2 = new Klient("5555 5555 5555 5555", "Anna",
                "Jakubowska", "Klonowa", 55765,
                "haslo2");
        Klient klient3 = new Klient("99999999999935353453", "Ewa",
                "Jankowska", "Sienkiewicza", 65477,
                "Haslo%%");

        return new Object[][]{
                {klient, new BigDecimal("999"), new BigDecimal("444"),23444, "haslo#", true},
                {klient2, new BigDecimal("1000"), new BigDecimal("2000"), 55765, "haslo2", false},
                {klient3, new BigDecimal("0"), new BigDecimal("10"), 65477, "Haslo%%", false},
                {klient3, new BigDecimal("100"), new BigDecimal("10"), 65477, "ZleHaslo", false},
        };
    }

    @Test
    @UseDataProvider("dataProviderKonto")
    public void checkingAccount(Klient k,BigDecimal stanKontaDlaTestu, BigDecimal kwotaPrzelewu, int login,
                                String haslo, boolean expectedResult){

        //Given

       List<Klient> lista = new LinkedList<Klient>();
       lista.add(k);

        Konto konto = new Konto ( lista, stanKontaDlaTestu);
        //When
        konto.zalogujSie(login, haslo);
        boolean result = konto.zrobPrzelew(kwotaPrzelewu);

        //Then
       Assertions.assertThat(result).isEqualTo(expectedResult);

    }
}