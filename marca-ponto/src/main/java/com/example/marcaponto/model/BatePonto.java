package com.example.marcaponto.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ponto")
public class BatePonto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", nullable = false)
    private Usuario usuario;

    @Column(name = "nome", nullable = false)
    private Date date;

    @Column(name = "nome", nullable = false)
    private Date hour;

    @Column(name = "nome", nullable = false)
    private String tipoBatida;

    public BatePonto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String getTipoBatida() {
        return tipoBatida;
    }

    public void setTipoBatida(String tipoBatida) {
        this.tipoBatida = tipoBatida;
    }
}
