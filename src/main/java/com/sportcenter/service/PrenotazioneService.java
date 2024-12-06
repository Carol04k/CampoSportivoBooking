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
        //logica necessaria per 
        // 1. recuperare l'utente dal repository UtenteRepository
        Utente utente = utenteRepository.findById(request.getUtenteId()).get();
        //2. recuperare il campoSportivo dal repository CampoSportivoRepository
        CampoSportivo campoSportivo = campoSportivoRepository.findById(request.getCampoSportivoId()).get();
        // 3. settare i valori a un oggetto Prenotazione (da costruire)
        Prenotazione prenotazioneToSave = new Prenotazione();

        prenotazioneToSave.setDataOra(request.getDataOra());
        prenotazioneToSave.setStato(request.getStato());
        prenotazioneToSave.setUtente(utente);
        prenotazioneToSave.setCampoSportivo(campoSportivo);

        // 4. salvare
        prenotazioneToSave = prenotazioneRepository.save(prenotazioneToSave);

        return prenotazioneToSave;
    }
}
