package com.example.banque_service;

import com.example.banque_service.entities.Compte;
import com.example.banque_service.entities.TypeCompte;
import com.example.banque_service.repositories.CompteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphApplication.class, args);
    }

    // Création de 3 comptes au démarrage
    @Bean
    public org.springframework.boot.CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, 9000.0, TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 1000.0, TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 40000.0, TypeCompte.COURANT));

            System.out.println("=== Comptes ajoutés avec succès ===");
        };
    }
}