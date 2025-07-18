package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Repository.ClientRepository;
import com.example.System_gestion_LEXUS.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientByCin(String cin) {
        return clientRepository.findById(cin);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(String cin, Client updatedClient) {
        return clientRepository.findById(cin).map(existing -> {
            existing.setNom(updatedClient.getNom());
            existing.setPrenom(updatedClient.getPrenom());
            existing.setTelephone(updatedClient.getTelephone());
            existing.setEmail(updatedClient.getEmail());
            return clientRepository.save(existing);
        }).orElse(null);
    }

    public void deleteClient(String cin) {
        clientRepository.deleteById(cin);
    }
}

