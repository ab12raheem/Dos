package com.example.catalog.Repo;

import com.example.catalog.Model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepo extends JpaRepository<Catalog,Integer> {
    List<Catalog> findAllByTopic(String topicName);
}
