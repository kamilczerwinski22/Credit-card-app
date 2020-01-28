package pl.krakow.uek.pp5.kijo.home.creditcard.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.CreditCardFacade;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.WithdrawCommand;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.dto.CardBlanceDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CreditCardReportingController {

    CreditCardFacade api;

    @Autowired
    public CreditCardReportingController(CreditCardFacade api) {
        this.api = api;
    }

    // http://localhost:8080/api/cards/balances


    @GetMapping("/balances")
    public List<CardBlanceDto> cardsBalances() {

        return Arrays.asList(
                new CardBlanceDto("1111-1111", BigDecimal.valueOf(223000)),
                new CardBlanceDto("2233-2222", BigDecimal.valueOf(2500)),
                new CardBlanceDto("1234-2223", BigDecimal.valueOf(1000))
                new CardBlanceDto("1234-1234", BigDecimal.valueOf(2100))
        );
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody WithdrawCommand command) {
        api.withdraw(command);
    }
}
