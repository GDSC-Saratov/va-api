package com.ssu.vaapi.gates.service;

import com.ssu.vaapi.gates.dto.ClientDto;
import com.ssu.vaapi.persistence.entities.Client;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface ClientService {

    CompletableFuture<Client> addClient(ClientDto dto)
            throws ExecutionException, InterruptedException, TimeoutException;

}
