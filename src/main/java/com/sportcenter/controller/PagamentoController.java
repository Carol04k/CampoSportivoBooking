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

import com.sportcenter.model.Pagamento;
import com.sportcenter.repository.PagamentoRepository;
import com.sportcenter.service.PagamentoService;




@RequestMapping("/api/pagamento")
@RestController
public class PagamentoController{
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping()
    public List<Pagamento> getAllPagamento() {
        return pagamentoRepository.findAll();
    }

    @PostMapping()
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
    

    @DeleteMapping ("/{id}")
    public Pagamento deletePagamento(@PathVariable long id){
        pagamentoRepository.deleteById(id);
                return null;
    }    

    @GetMapping("/{id}")
    public Pagamento getPagamentoById(@PathVariable Long id){
        return pagamentoRepository.findById(id).get();
    }

    /*@PostMapping("/{utenteId}/songs")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long playlistId, @RequestBody AddSongRequest request) {
        Playlist updatePlaylist = playlistService.addSongToPlaylist(playlistId, request.getSongId());
        return ResponseEntity.ok(updatePlaylist);
    }*/
}

