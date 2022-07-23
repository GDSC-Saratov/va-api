package com.ssu.vaapi.gates.service.impl;

import com.google.common.hash.Hashing;
import com.ssu.vaapi.gates.dto.ClientDto;
import com.ssu.vaapi.gates.service.ClientService;
import com.ssu.vaapi.persistence.entities.Client;
import com.ssu.vaapi.persistence.repositories.impl.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@Service
@ComponentScan(basePackages = "com.ssu")
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompletableFuture<Client> addClient(ClientDto clientDto) {
        String encPassword = Hashing.sha512()
                .hashString(clientDto.getPassword(), StandardCharsets.UTF_8)
                .toString();

        Client client = Client.builder()
                .username(clientDto.getUsername())
                .password(encPassword)
                .build();

        return CompletableFuture.supplyAsync(() -> repository.addUser(client));
    }
}
