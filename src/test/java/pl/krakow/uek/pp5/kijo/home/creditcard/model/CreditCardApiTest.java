package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import org.junit.Assert;
import org.junit.Test;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.exceptions.CreditBelowLimitException;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class CreditCardTest {

    public static final int LIMIT = 2000;

    @Test
    public void itAllowAssignCreditToCard() {
        //Arrange / Given
        CreditCard card = new CreditCard("1234-5678");
        //Act / When
        card.assignLimit(BigDecimal.valueOf(LIMIT));
        //Assert / Then
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(LIMIT)));
    }

    @Test
    public void creditBelowGeneralLimitIsNotPossible() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act

        //Assert
        try {
            card.assignLimit(BigDecimal.valueOf(50));
            Assert.fail("exception should be thrown");
        } catch (CreditBelowLimitException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void withdrawFromCard(){
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");
        card1.assignLimit(BigDecimal.valueOf(1000));
        card2.assignLimit(BigDecimal.valueOf(1000));
        card1.withdraw(BigDecimal.valueOf(500));
        card2.withdraw(BigDecimal.valueOf(100));
        Assert.assertEquals(BigDecimal.valueOf(500),card1.getCurrentBalance());
        Assert.assertEquals(BigDecimal.valueOf(900),card2.getCurrentBalance());
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void denyWithdrawBelowBalance() {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(600));
        card.withdraw(BigDecimal.valueOf(600));
    }
}