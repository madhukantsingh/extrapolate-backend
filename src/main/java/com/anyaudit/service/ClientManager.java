package com.anyaudit.service;

import com.anyaudit.models.Client;
import com.anyaudit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class    ClientManager {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    public ClientManager(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client) {
        com.anyaudit.models.Client c = new com.anyaudit.models.Client();
        c.setId(client.getId());
        c.setName(client.getName());
        c.setPhoneNo(client.getPhoneNo());
        c.setEmail(client.getEmail());
        c.setFileNo(client.getFileNo());
        c.setFramework(client.getFramework());
        c.setCreatedBy(client.getCreatedBy());
//        c.setUpdatedBy(client.getUpdatedBy());
//        c.setCreatedDate(client.getCreatedDate());
        com.anyaudit.models.Client savedClient = clientRepository.save(c);
        Client saved = new Client();
        saved.setId(savedClient.getId());
        saved.setName(savedClient.getName());
        saved.setPhoneNo(savedClient.getPhoneNo());
        saved.setEmail(savedClient.getEmail());
        saved.setFileNo(savedClient.getFileNo());
        saved.setFramework(savedClient.getFramework());
        saved.setCreatedBy(savedClient.getCreatedBy());
        saved.setUpdatedBy(savedClient.getUpdatedBy());
        saved.setCreatedDate(savedClient.getCreatedDate());
        return saved;
    }

    public List<Client> getAllClients() {
        List<com.anyaudit.models.Client> assignments = clientRepository.findAll();
        List<Client> result = new ArrayList<>();
        for (com.anyaudit.models.Client c : assignments) {
            Client assignment = new Client();
            assignment.setId(c.getId());
            assignment.setName(c.getName());
            assignment.setPhoneNo(c.getPhoneNo());
            assignment.setEmail(c.getEmail());
            assignment.setFileNo(c.getFileNo());
            assignment.setFramework(c.getFramework());
            assignment.setCreatedBy(c.getCreatedBy());
            assignment.setUpdatedBy(c.getUpdatedBy());
            assignment.setCreatedDate(c.getCreatedDate());
            assignment.setUpdatedDate(c.getUpdatedDate());
            assignment.setFramework(c.getFramework());

            result.add(assignment);
        }
        return result;
    }

    public Client getClientById(long clientId) {
        com.anyaudit.models.Client c = clientRepository.findById(clientId).orElse(null);
        if (c == null) {
            return null;
        }
        Client client = new Client();
        client.setId(c.getId());
        client.setName(c.getName());
        client.setPhoneNo(c.getPhoneNo());
        client.setEmail(c.getEmail());
        client.setFileNo(c.getFileNo());
        client.setFramework(c.getFramework());
        client.setCreatedBy(c.getCreatedBy());
        client.setUpdatedBy(c.getUpdatedBy());
        return client;
    }


    public Client updateClient(Client client) {
        com.anyaudit.models.Client c = clientRepository.findById(client.getId()).orElse(null);
        if (c == null) {
            return null;
        }
        c.setName(client.getName());
        c.setPhoneNo(client.getPhoneNo());
        c.setEmail(client.getEmail());
        c.setFileNo(client.getFileNo());
        c.setFramework(client.getFramework());
        com.anyaudit.models.Client savedClient = clientRepository.save(c);
        return savedClient;
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


    public List<Object[]> findNameAndId() {
        return clientRepository.findNameAndId();
    }
}
