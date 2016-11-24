package com.example.diego.gelinhomaria.modes;

import java.io.Serializable;

/**
 * Created by diego on 12/11/16.
 */

public class TiposGelinhos implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
