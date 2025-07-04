package com.example.System_gestion_LEXUS.Controller;


import com.example.System_gestion_LEXUS.Repository.ClientRepository;
import com.example.System_gestion_LEXUS.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*") // hadi bach ikun 3andi l'access mn l front

public class ClientController {
     @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{cin}")
    public ResponseEntity<Client> getClientByCin(@PathVariable String cin) {
        Optional<Client> client = clientRepository.findById(cin);
        return client.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }


    @PutMapping("/{cin}")
    public ResponseEntity<Client> updateClient(@PathVariable String cin, @RequestBody Client clientDetails) {
        Optional<Client> clientOptional = clientRepository.findById(cin);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setNom(clientDetails.getNom());
            client.setPrenom(clientDetails.getPrenom());
            client.setTelephone(clientDetails.getTelephone());
            client.setEmail(clientDetails.getEmail());
            return ResponseEntity.ok(clientRepository.save(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{cin}")
    public ResponseEntity<Void> deleteClient(@PathVariable String cin) {
        if (clientRepository.existsById(cin)) {
            clientRepository.deleteById(cin);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
