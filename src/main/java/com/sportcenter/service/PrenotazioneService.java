package com.sportcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportcenter.dto.PrenotazioneRequest;
import com.sportcenter.model.CampoSportivo;
import com.sportcenter.model.Prenotazione;
import com.sportcenter.model.Utente;
import com.sportcenter.repository.CampoSportivoRepository;
import com.sportcenter.repository.PrenotazioneRepository;
import com.sportcenter.repository.UtenteRepository;





@Service
public class PrenotazioneService {

    @Autowired
    private CampoSportivoRepository campoSportivoRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione create(PrenotazioneRequest request){
        Prenotazione prenotazioneToSave = new Prenotazione();
        prenotazioneToSave.setDataOra(request.getDataOra());
        prenotazioneToSave.setStato(request.getStato());

        Utente utente = utenteRepository.findById(request.getUtenteId()).get();

        prenotazioneToSave.setUtente(utente);

        CampoSportivo campoSportivo = campoSportivoRepository.findById(request.getCampoSportivoId()).get();
        
        prenotazioneToSave.setCampoSportivo(campoSportivo);

        return prenotazioneRepository.save(prenotazioneToSave);
    }
}
