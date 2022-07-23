package com.ssu.vaapi.gates.controller;

import com.ssu.vaapi.gates.dto.ClientDto;
import com.ssu.vaapi.gates.service.ClientService;
import com.ssu.vaapi.persistence.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/api/user")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    // TODO: Make proper exception handling instead of 500 code
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<Client> registerClient(String username, String password)
            throws ExecutionException, InterruptedException, TimeoutException {
        return service.addClient(new ClientDto(username, password));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getClient(@PathVariable long id) {
        // TODO: Return client with given id;
        return String.format("Returning user with %s userId", id);
    }
}
