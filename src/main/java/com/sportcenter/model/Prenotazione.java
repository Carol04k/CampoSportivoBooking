package com.sportcenter.model;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prenotazione {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime dataOra;
    private String stato;

    @ManyToOne
    @JoinColumn(name = "Utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "CampoSportivo_id")
    private CampoSportivo campoSportivo;

    public CampoSportivo getCampoSportivo() {
        return campoSportivo;
    }

    public void setCampoSportivo(CampoSportivo campoSportivo) {
        this.campoSportivo = campoSportivo;
    }
    
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Utente getUtente() {
        return utente;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }


}
