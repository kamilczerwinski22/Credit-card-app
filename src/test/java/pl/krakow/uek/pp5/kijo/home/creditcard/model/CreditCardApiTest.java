package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardApiTest { // Test do fasady
    public static final BigDecimal WITHDRAW_VALUE = BigDecimal.valueOf(500); // stała zmienna stanowiąca ilość wyplacanych monet - 500
    public static final String CREDIT_CARD_NUMBER = "1234-5632"; // stała zmienna stanowiąca numer karty
    public static final int INITIAL_LIMIT = 1000; // stała zmienna stanowiąca limit jaki bedziemy zawsze przypisaywac karcie
    private InMemoryCCStorage inMemoryCCStorage; // zmienna do klasy przechowywujacej karty ??
    private CreditCardFacade api; // zmienna do odnoszenia sie do fasady ??

    @Test // test do wypłaty z karty
    public void withdrawFromCard(){
        thereIsCCStorage(); // funkcja zajmujaca się sprawdzeniem że utworzony jest obiekt do przechowywania danych o kartach ??
        thereIsCreditCard(); // funckja zajmuje sie potwierdzeniem, że istnieje karta na ktorej mozna przeprowadzac testy
        thereIsCCApi(); // funkcja zajmuje sei potwierdzeniem ze jest fasada ??

        api.withdrawFromCard(CREDIT_CARD_NUMBER, WITHDRAW_VALUE); // przypisanie na obiekcie fasady do funckcji wypłaty numeru karty oraz wartosci wypłacanych monet ??

        currentBalanceForCCEquals(CREDIT_CARD_NUMBER, BigDecimal.valueOf(500)); //
    }

    private void thereIsCCStorage() {
        inMemoryCCStorage = new InMemoryCCStorage(); // tworzymy pamięc dla kart przy uzyćiu wczesniej zadeklarowanej zmiennej ??
    }

    private void thereIsCreditCard() {
        CreditCard card = new CreditCard(CREDIT_CARD_NUMBER); // tworzymy nową kartę z danymi stałej CRECREDIT_CARD_NUMBER
        card.assignLimit(BigDecimal.valueOf(INITIAL_LIMIT)); // przypisujemy naszej karcie ilośc monet podaną we wcześniej zadeklarowanej stałej INITIAL_LIMIT

        inMemoryCCStorage.add(card); // dodajemy kartę do naszej pamięci ??
    }

    private void thereIsCCApi() {
        api = new CreditCardFacade(); // zo naszej zmiennej api o typie CreditCardFacade przypisujemy obiekt CreditCardFacade
    }

    private void currentBalanceForCCEquals(String creditCardNumber, BigDecimal expectedBalance) { // funkcja do sprawdzania obecnego stanu konta
        CreditCard loaded = inMemoryCCStorage.load(creditCardNumber); // załadowana z pamięci karta ??

        Assert.assertTrue(expectedBalance, loaded.currentBalance()); // zakładamy, że balans który powinien być na karcie, to ten który jest spodziewany
    }
}
