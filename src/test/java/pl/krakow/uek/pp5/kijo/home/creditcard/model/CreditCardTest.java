// przydatne linki
// http://junit.sourceforge.net/javadoc/org/junit/Assert.html

package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import org.junit.Assert;
import org.junit.Test;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.exceptions.CreditBelowMinimumException;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.exceptions.NotEnoughtMoneyException;

import java.math.BigDecimal;

public class CreditCardTest {
    public static final int NEW_CREDIT_LIMIT = 2000; // ustawienie limitu na 2000

    @Test // Tworzymy test aby sprawdzić, czy funkcja przypisania limitu do karty działa poprawnie
    public void itAllowAssignCreditToCard(){
        CreditCard card = new CreditCard("1245-1232"); // utworzenie nowej karty przy pomocy konstruktora i podanie numeru karty
        CreditCard creditCard = new CreditCard("1245-1232"); // tworzymy druga kartę

        card.assignLimit(BigDecimal.valueOf(NEW_CREDIT_LIMIT)); // uzycie motody assignLimit do wprowadzenia limitu na kartę
        creditCard.assignLimit(BigDecimal.valueOf(NEW_CREDIT_LIMIT)); // uzycie motody assignLimit do wprowadzenia limitu na kartę

        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(NEW_CREDIT_LIMIT))); // założenie że po uzyciu metody getlimit będzie się ona rownac z limitem ktory wczesniej ustalisimy
        Assert.assertTrue(creditCard.getLimit().equals(BigDecimal.valueOf(NEW_CREDIT_LIMIT))); // założenie że po uzyciu metody getlimit będzie się ona rownac z limitem ktory wczesniej ustalisimy
    }

    @Test // Tworzymy test aby sprawdzić, czy funkcja weryfikacji minimalnej wartości na karcie działa poprawnie
    public void itVerifyMinimumCreditValue(){
        CreditCard card = new CreditCard("1234-1234"); // Tworzymy nowa kartę za pomocą konstruktora

        try { // Tworzymy blok try/catch aby wyłapać mający wystąpić błąd
            card.assignLimit(BigDecimal.valueOf(50)); // Przypisujemy do karty wartość 50, czyli poniżej wymaganego limitu 100. Powinien nam wystąpić błąd CreditBelowMinimumException
            Assert.fail("Exception should be thrown"); // Sprawia, że program wyrzuca błąd oraz wiadomość "Exception should be thrown" "Fails a test with the given message."
        }   catch (CreditBelowMinimumException e) { // Błąd który ma zostać wyłapany
            Assert.assertTrue(true); // jeżeli błąd zostanie wyłapany, program działa poprawnie
        }
    }

    @Test // sprawdzamy co się stanie, jeśli przypiszemy karcie dokładnie 100 monet/ Powinno przejsc
    public void foo(){
        CreditCard card = new CreditCard("1234-1234"); // jak zawsze na początku tworzymy nowa karte
        card.assignLimit(BigDecimal.valueOf(100)); // przypisujemy karcie dokladnie 100 monet
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(100))); // "Asserts that a condition is true. If it isn't it throws an AssertionError without a message." Zakładamy że limit który
                                                                            // dostaniemy z gettera card.getLimit() będzie równy 100
    }

    @Test // sprawdzamy funkcję wypłacania pieniędzy z karty
    public void withdrawFromCard(){
        CreditCard card1 = new CreditCard("1234-1234"); // tworzymy nową kartę
        CreditCard card2 = new CreditCard("1234-1234"); // tworzymy nową kartę
        card1.assignLimit(BigDecimal.valueOf(1000)); // przypisujemy karcie 1000 monet
        card2.assignLimit(BigDecimal.valueOf(1000)); // przypisujemy karcie 1000 monet
        card1.withdraw(BigDecimal.valueOf(500)); // wypłacamy z karty 500 monet
        card2.withdraw(BigDecimal.valueOf(200)); // wypłacamy z karty 200 monet
        Assert.assertEquals(card1.currentBalance(), BigDecimal.valueOf(500)); // zakładamy, że currentBalance jest rowny 500 (1000 - 500 = 500)
        Assert.assertEquals(card2.currentBalance(),  BigDecimal.valueOf(800)); // zakładamy, że currentBalance jest rowny 500 (1000 - 200 = 800)
    }

    @Test(expected = NotEnoughtMoneyException.class) // sprawdzamy co sie stanie jesli chcemy wypłacić więcej monet niz mamy na saldzie .. Test sie powiedzie jeśli metoda wyrzuci nam ten konkretny błąd
    public void denyWithdrawBelowCurrentBalance(){
        CreditCard card = new CreditCard("1234-1234"); // tworzymy nową kartę
        card.assignLimit(BigDecimal.valueOf(1000)); //dopisujemy wartość do karty
        card.withdraw(BigDecimal.valueOf(600)); // odejmujemy z karty 600 monet - zostało 400
        card.withdraw(BigDecimal.valueOf(600)); // chcemy odjąc z karty 600 monet - na karcie jest 400, powinnien wyskoczyc blad
    }
}
