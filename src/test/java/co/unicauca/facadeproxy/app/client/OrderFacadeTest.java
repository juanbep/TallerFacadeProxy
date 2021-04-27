package co.unicauca.facadeproxy.app.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.unicauca.facadeproxy.domain.order.Customer;
import co.unicauca.facadeproxy.domain.order.Dish;
import co.unicauca.facadeproxy.domain.order.OrderFacade;
import co.unicauca.facadeproxy.domain.order.State;

/*
 * Copyright (C) 2021 Luis Tabares
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
/**
 * Clase que permite testear OrderFacade
 *
 * @author Luis Tabares
 */
public class OrderFacadeTest {

	 @Test
	    public void testCreateOrder() {
	        OrderFacade facade = new OrderFacade();
	        facade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 BarrioCaldas", "3115677899", "Popayán"));
	        facade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
	        facade.addDish(new Dish(2, "Hamburguesa sencilla ", 4000), 3);
	        facade.addDish(new Dish(3, "Jugo hit ", 1000), 2);
	        assertEquals("Hamburguesa vegetariana",
	        facade.getOrder().getDetails().get(0).getDish().getName());
	        assertEquals(State.NEW, facade.getOrder().getState());
	        facade.changeState(State.FINALIZED);
	        assertEquals(State.FINALIZED, facade.getOrder().getState());
	        assertEquals(3, facade.totalDishes());
	        assertEquals(24000, facade.calculateTotal());
	        facade.cancelOrder();
	        facade.changeState(State.CANCELLED);
	    }

    
}
