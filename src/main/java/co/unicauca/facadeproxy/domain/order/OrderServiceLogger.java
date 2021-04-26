/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.facadeproxy.domain.order;

import co.unicauca.facadeproxy.access.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Luis Tabares
 */
public class OrderServiceLogger implements IOrderService {

    private OrderFacade orderFacade;
    private Logger logger;

    public OrderServiceLogger() {
    }

    public OrderServiceLogger(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
        logger = LoggerFactory.getLogger(OrderServiceLogger.class);
    }

    @Override
    public void save(IOrderRepository repo) {
        repo.createOrder(orderFacade.getOrder());
        String message = "Pedido guardado en la base de datos";
        logger.info(message);
    }

}
