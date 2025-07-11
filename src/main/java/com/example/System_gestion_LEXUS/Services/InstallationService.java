package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Entities.Installation;
import com.example.System_gestion_LEXUS.Repository.InstallationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstallationService {

    @Autowired
    private InstallationRepository installationRepository;

    public List<Installation> getAllInstallations() {
        return installationRepository.findAll();
    }

    public Optional<Installation> getInstallationById(Long id) {
        return installationRepository.findById(id);
    }

    public Installation saveInstallation(Installation installation) {
        return installationRepository.save(installation);
    }

    public void deleteInstallation(Long id) {
        installationRepository.deleteById(id);
    }
}