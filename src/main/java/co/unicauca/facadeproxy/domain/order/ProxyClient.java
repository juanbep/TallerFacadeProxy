/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.facadeproxy.domain.order;

import co.unicauca.facadeproxy.access.Factory;
import co.unicauca.facadeproxy.access.IOrderRepository;

/**
 *
 * @author Beca98
 */
public class ProxyClient {

    private IOrderService orderServicie;

    public ProxyClient(IOrderService orderService) {
        this.orderServicie = orderService;
    }

    public void CreateOrder() {
        IOrderRepository repo = Factory.getInstance().getRepository("default");
        orderServicie.save(repo);
    }
}
