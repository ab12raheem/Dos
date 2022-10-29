package com.example.catalog.Controller;

import com.example.catalog.Model.Catalog;
import com.example.catalog.Service.CatalogService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping(path = "api/v1/catalog")
@CrossOrigin(origins = "http://localhost:8091")
public class CatalogController {
    private final CatalogService catalogService;
    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("getAll")
    public List<Catalog> getAllCatalogs() {
        return catalogService.getAllCatalogs();
    }

    @GetMapping("findByTopic/{topicName}")
    public List<Catalog> findByTopicName (@PathVariable String topicName) {
        return catalogService.findByTopic(topicName);
    }
    @GetMapping("findById/{id}")
    public Catalog  getById(@PathVariable Integer id) {
        return catalogService.findById(id);
    }
    @GetMapping("buyBookById/{id}")
    public HashMap<String,String> buyBook(@PathVariable Integer id) throws JSONException {
       return catalogService.BuyBook(id);
    }
}
