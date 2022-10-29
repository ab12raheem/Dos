package com.example.catalog.Service;

import com.example.catalog.Model.Catalog;
import com.example.catalog.Repo.CatalogRepo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CatalogService {
    private final CatalogRepo catalogRepo;

    @Autowired
    public CatalogService(CatalogRepo catalogRepo) {
        this.catalogRepo = catalogRepo;
    }

    public List<Catalog> getAllCatalogs() {
        return catalogRepo.findAll();
    }

    public List<Catalog> findByTopic(String topicName) {
        List <Catalog> catalogs = catalogRepo.findAllByTopic(topicName);
        if (catalogs.isEmpty()) {
            throw new IllegalStateException("there is no such catalog with topic name: "+topicName);
        }
        return catalogs;
    }

    public Catalog findById(Integer id) {
        Optional <Catalog> catalog = catalogRepo.findById(id);
        if(!catalog.isPresent()) {
            throw new IllegalStateException("there is no such catalog with id: "+id);
        }
        return catalog.get();
    }
    @Transactional
    public HashMap<String,String> BuyBook(Integer id) throws JSONException {
        HashMap<String,String> response = new HashMap<>();
        Optional <Catalog> catalogOptional = catalogRepo.findById(id);
        if(!catalogOptional.isPresent()) {
            response.put("status","failed");
            response.put("message","there is no Book with id:" +id+"");
            return response;
        }
        Catalog catalog = catalogOptional.get();
        if(catalog.getNumberOfBox() < 1) {
            response.put("status","failed");
            response.put("message","there is no enough quantity");
            return response;
        }
        catalog.setNumberOfBox(catalog.getNumberOfBox()-1);
        catalogRepo.save(catalog);
        response.put("status","success");
        response.put("message","purchased succesfully");
        return response;
    }
}
