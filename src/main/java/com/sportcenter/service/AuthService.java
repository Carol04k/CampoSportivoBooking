
package com.sportcenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sportcenter.dto.AuthRequest;
import com.sportcenter.dto.RegisterUserRequest;
import com.sportcenter.model.Ruolo;
import com.sportcenter.model.Utente;
import com.sportcenter.repository.RuoloRepository;
import com.sportcenter.repository.UtenteRepository;

@Service
public class AuthService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RuoloRepository ruoloRepository;

    public void register(Utente utente) {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        
    }

    public String login(AuthRequest authRequest) {
        // Validazione dell'utente e generazione del token JWT (da implementare)
        return "token_jwt";
    }

    public void register(RegisterUserRequest registerUserRequest) {
        Utente nuovoUtente = new Utente();

        nuovoUtente.setUsername(registerUserRequest.getUsername());
        nuovoUtente.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        nuovoUtente.setEmail(registerUserRequest.getEmail());
        
        Ruolo ruolo = ruoloRepository.findByRuolo(registerUserRequest.getRuolo()).get();

        nuovoUtente.getRuolo().add(ruolo);
        
        

        utenteRepository.save(nuovoUtente);
    }
}
