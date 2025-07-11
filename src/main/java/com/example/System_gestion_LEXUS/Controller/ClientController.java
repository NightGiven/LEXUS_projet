package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.Client;
import com.example.System_gestion_LEXUS.Services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{cin}")
    public ResponseEntity<Client> getClientByCin(@PathVariable String cin) {
        return clientService.getClientByCin(cin)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/{cin}")
    public ResponseEntity<Client> updateClient(@PathVariable String cin, @RequestBody Client client) {
        Client updated = clientService.updateClient(cin, client);
        if (updated != null) return ResponseEntity.ok(updated);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cin}")
    public ResponseEntity<Void> deleteClient(@PathVariable String cin) {
        clientService.deleteClient(cin);
        return ResponseEntity.noContent().build();
    }
}
