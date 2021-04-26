/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.facadeproxy.access;

import co.unicauca.facadeproxy.domain.order.Order;

/**
 *
 * @author Luis Tabares
 */
public interface IOrderRepository {

    public void createOrder(Order order);
}
