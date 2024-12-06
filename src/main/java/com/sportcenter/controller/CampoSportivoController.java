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

import com.sportcenter.model.CampoSportivo;
import com.sportcenter.repository.CampoSportivoRepository;
import com.sportcenter.service.CampoSportivoService;




@RequestMapping("/api/campo")
@RestController
public class CampoSportivoController{
    @Autowired
    private CampoSportivoRepository campoSportivoRepository;

    @Autowired
    private CampoSportivoService campoSportivoService;

    @GetMapping()
    public List<CampoSportivo> getAllCampoSportivo() {
        return campoSportivoRepository.findAll();
    }

    @PostMapping()
    public CampoSportivo createCampoSportivo(@RequestBody CampoSportivo campoSportivo) {
        return campoSportivoRepository.save(campoSportivo);
    }
    

    @DeleteMapping ("/{id}")
    public CampoSportivo deleteCampoSportivo(@PathVariable long id){
        campoSportivoRepository.deleteById(id);
                return null;
    }    

    @GetMapping("/{id}")
    public CampoSportivo getCampoSportivoById(@PathVariable Long id){
        return campoSportivoRepository.findById(id).get();
    }

    /*@PostMapping("/{utenteId}/songs")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long playlistId, @RequestBody AddSongRequest request) {
        Playlist updatePlaylist = playlistService.addSongToPlaylist(playlistId, request.getSongId());
        return ResponseEntity.ok(updatePlaylist);
    }*/
}
