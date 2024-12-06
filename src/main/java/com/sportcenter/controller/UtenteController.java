package com.sportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportcenter.dto.PrenotazioneRequest;
import com.sportcenter.model.Prenotazione;
import com.sportcenter.model.Utente;
import com.sportcenter.repository.UtenteRepository;
import com.sportcenter.service.PrenotazioneService;
import com.sportcenter.service.UtenteService;




@RequestMapping("/api/utente")
@RestController
public class UtenteController{
    @Autowired
    private UtenteRepository UtenteRepository;

    @Autowired
    private UtenteService UtenteService;

    @GetMapping()
    public List<Utente> getAllUtente() {
        return UtenteRepository.findAll();
    }

    @PostMapping()
    public Utente createUtente(@RequestBody Utente utente) {
        return UtenteRepository.save(utente);
    }
    

    @DeleteMapping ("/{id}")
    public Utente deleteUtente(@PathVariable long id){
        UtenteRepository.deleteById(id);
                return null;
    }    

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable Long id){
        return UtenteRepository.findById(id).get();
    }

    /*@PostMapping("/{utenteId}/prenotazione")
    public ResponseEntity<Utente> addUtenteToPrenotazione(@PathVariable Long prenotazioneId, @RequestBody PrenotazioneRequest request) {
        Prenotazione updatePrenotazione = PrenotazioneService.addUtenteToPrenotazione(playlistId, request.getSongId());
        return ResponseEntity.ok(updatePlaylist);
    }*/
}
