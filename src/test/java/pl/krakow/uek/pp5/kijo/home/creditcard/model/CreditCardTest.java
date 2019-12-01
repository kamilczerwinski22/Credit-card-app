// przydatne linki
// http://junit.sourceforge.net/javadoc/org/junit/Assert.html

package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import org.junit.Assert;
import org.junit.Test;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.exceptions.CreditBelowMinimumException;

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
}
