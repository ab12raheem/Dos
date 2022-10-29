package com.example.catalog.Model;

import javax.persistence.*;

@Entity
@Table(name = "catalog" , schema = "public")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String topic;
    private Integer numberOfBox;
    private Double cost;

    public Catalog() {
    }

    public Catalog(String name, String topic, Integer numberOfBox, Double cost) {
        this.name = name;
        this.topic = topic;
        this.numberOfBox = numberOfBox;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getNumberOfBox() {
        return numberOfBox;
    }

    public void setNumberOfBox(Integer numberOfBox) {
        this.numberOfBox = numberOfBox;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", numberOfBox=" + numberOfBox +
                ", cost=" + cost +
                '}';
    }
}
