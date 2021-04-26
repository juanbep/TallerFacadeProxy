/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.facadeproxy.domain.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Tabares
 */
public class Order {

    private int despatch;
    private Customer customer;
    private LocalDate date;
    private State state;
    private List<Item> details;

    public Order() {
    }

    public Order(int despatch, Customer customer, LocalDate date) {
        this.despatch = despatch;
        this.customer = customer;
        this.date = date;
        this.state = State.NEW;
        this.details = new ArrayList<>();
    }

    public Order(Customer customer) {
        this.customer = customer;
        this.state = State.NEW;
        this.details = new ArrayList<>();
    }

    public int getDespatch() {
        return this.despatch;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public State getState() {
        return this.state;
    }

    public List<Item> getDetails() {
        return this.details;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setDetails(ArrayList<Item> details) {
        this.details = details;
    }

    public void addDish(Dish dish, int amount) {
        Item item = new Item(dish, amount);
        details.add(item);
    }

    public int calculateTotal() {
        int total = 0;
        for (Item item : details) {
            total += item.getDish().getPrice() * item.getAmount();
        }
        return total;
    }
}
