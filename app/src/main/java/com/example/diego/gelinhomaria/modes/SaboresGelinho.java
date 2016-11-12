package com.example.diego.gelinhomaria.modes;

import java.math.BigDecimal;

/**
 * Created by diego on 12/11/16.
 */

public class SaboresGelinho {

    private Long id;
    private String sabor;
    private TiposGelinhos tipo_gelinho;
    private Integer qtd;
    private BigDecimal valor_uni;
    private BigDecimal valor_total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public TiposGelinhos getTipo_gelinho() {
        return tipo_gelinho;
    }

    public void setTipo_gelinho(TiposGelinhos tipo_gelinho) {
        this.tipo_gelinho = tipo_gelinho;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getValor_uni() {
        return valor_uni;
    }

    public void setValor_uni(BigDecimal valor_uni) {
        this.valor_uni = valor_uni;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }
}
