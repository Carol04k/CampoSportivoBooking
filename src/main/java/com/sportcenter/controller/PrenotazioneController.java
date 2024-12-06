package com.sportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportcenter.dto.PrenotazioneRequest;
import com.sportcenter.model.Prenotazione;
import com.sportcenter.repository.PrenotazioneRepository;
import com.sportcenter.service.PrenotazioneService;




@RequestMapping("/api/prenotazione")
@RestController
public class PrenotazioneController{
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping()
    public List<Prenotazione> getAllPrenotazione() {
        return prenotazioneRepository.findAll();
    }

    @PostMapping()
    public Prenotazione create(@RequestBody PrenotazioneRequest prenotazione) {
        return prenotazioneService.create(prenotazione);
    }
    

    @DeleteMapping ("/{id}")
    public Prenotazione deletePrenotazione(@PathVariable long id){
        prenotazioneRepository.deleteById(id);
                return null;
    }    

    @GetMapping("/{id}")
    public Prenotazione getPrenotazioneById(@PathVariable Long id){
        return prenotazioneRepository.findById(id).get();
    }

    /*@PostMapping("/{utenteId}/songs")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long playlistId, @RequestBody AddSongRequest request) {
        Playlist updatePlaylist = playlistService.addSongToPlaylist(playlistId, request.getSongId());
        return ResponseEntity.ok(updatePlaylist);
    }*/
}
