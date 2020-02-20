package com.example.marcaponto.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pontos")
public class BatePonto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "usuario", nullable = false)
    private String usuarioId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "tipoBatida", nullable = false)
    private String tipoBatida;

    public BatePonto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getDate() {
        return date;
    }

    public String getTipoBatida() {
        return tipoBatida;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTipoBatida(String tipoBatida) {
        this.tipoBatida = tipoBatida;
    }
}
