package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {
    public static final int LIMIT = 2000; // ustawienie limitu na 2000

    @Test
    public void itAllowAssignCreditToCard(){
        CreditCard card = new CreditCard("1245-1232"); // utworzenie nowej karty przy pomocy konstruktora i podanie numeru karty
        card.assignLimit(BigDecimal.valueOf(LIMIT)); // uzycie motody assignLimit do wprowadzenia limitu na kartę
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(LIMIT))); // założenie że po uzyciu metody getlimit będzie się ona rownac z limitem ktory wczesniej sutalisimy
    }
}
