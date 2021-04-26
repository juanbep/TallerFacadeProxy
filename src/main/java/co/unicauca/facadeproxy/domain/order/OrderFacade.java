/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.facadeproxy.domain.order;

import co.unicauca.facadeproxy.access.IOrderRepository;

/**
 *
 * @author Luis Tabares
 */
public class OrderFacade implements IOrderService {

    private Order order;

    public OrderFacade() {

    }

    public void createOrder(Customer customer) {
        this.order = new Order(customer);
    }

    public void addDish(Dish dish, int amount) {
        this.order.addDish(dish, amount);
    }

    public void changeState(State state) {
        this.order.setState(state);
    }

    public void cancelOrder() {
        this.order.setState(State.CANCELLED);
    }

    public int calculateTotal() {
        return this.order.calculateTotal();
    }

    public Order getOrder() {
        return this.order;
    }

    public int totalDishes() {
        return this.order.getDetails().size();
    }

    @Override
    public void save(IOrderRepository repo) {
        repo.createOrder(order);
    }
}
