package ru.te.spring.entity;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String name;
    private BigDecimal cost;

    public Product(int id, String name, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id)
                .append(") наименование='").append(name).append('\'')
                .append(", цена=").append(cost).append(" руб.");

        return sb.toString();
    }
}