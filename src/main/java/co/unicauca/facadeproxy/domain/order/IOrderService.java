/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.facadeproxy.domain.order;

import co.unicauca.facadeproxy.access.IOrderRepository;

/**
 *
 * @author Beca98
 */
public interface IOrderService {

    public void save(IOrderRepository repo);

}
