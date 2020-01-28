package pl.krakow.uek.pp5.kijo.home.creditcard.model.dto;

import java.math.BigDecimal;

public class CardBlanceDto {
    private String number;
    private BigDecimal saldo;

    public CardBlanceDto(String number, BigDecimal saldo) {
        this.number = number;
        this.saldo = saldo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}