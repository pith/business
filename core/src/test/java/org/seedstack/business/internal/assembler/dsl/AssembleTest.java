/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.internal.assembler.dsl;

import com.google.common.collect.Lists;
import com.google.inject.name.Names;
import org.javatuples.Pair;
import org.seedstack.business.api.domain.BaseAggregateRoot;

import org.seedstack.business.api.interfaces.assembler.FluentAssembler;
import org.seedstack.business.api.interfaces.assembler.dsl.AggregateNotFoundException;
import org.seedstack.business.api.Tuples;

import java.util.List;


/**
 * @author pierre.thirouin@ext.mpsa.com (Pierre Thirouin)
 */
public class AssembleTest {

    private OrderDto orderDto = new OrderDto();
    private Order myOrder = new Order();
    private Order myOrder2 = new Order();
    private Customer customer = new Customer();
    private Customer customer2 = new Customer();
    private Order order = new Order();
    private Order order2 = new Order();
    private List<Object> dtos = Lists.newArrayList(orderDto, myOrder);
    private List<Order> orders = Lists.newArrayList(myOrder, myOrder);

    private FluentAssembler fluently;

    public void testMergeToAggregateInstance() {

        // dto to aggregate
        fluently.merge(orderDto).into(myOrder);

        fluently.merge(orderDto).into(myOrder, myOrder2);

        // list of dtos to list of aggregates
        fluently.merge(dtos).into(orders);
    }

    public void testMergeToAggregateClass() {
        // from factory
        order = fluently.merge(orderDto).into(Order.class).fromFactory();

        // list of dto to tuple of aggregates
        Pair<Order, Customer> orderCustomerPair = fluently.merge(orderDto).into(Order.class, Customer.class).fromFactory();

        // from repo or fail
        try {
            order = fluently.merge(orderDto).into(Order.class).fromRepository().orFail();
        } catch (AggregateNotFoundException e) {
            e.printStackTrace();
        }

        // from repo or fact
        order = fluently.merge(orderDto).into(Order.class).fromRepository().orFromFactory();
    }

    public void testAssemble() {
        // aggregate to dto
        OrderDto orderDto1 = fluently.assemble(myOrder).with(Names.named("MyQualifier")).to(OrderDto.class);

        // tuple of aggregate to dto
        orderDto1 = fluently.assembleTuple(Tuples.create(Order.class, Customer.class)).to(OrderDto.class);

        List<OrderDto> orderDtos = fluently.assembleTuple(
                Lists.newArrayList(Tuples.create(order, customer), Tuples.create(order2, customer2))
        ).to(OrderDto.class);
    }

    static class OrderDto {
    }

    static class Order extends BaseAggregateRoot<String> {
        String entityId;

        @Override
        public String getEntityId() {
            return entityId;
        }
    }

    static class Customer extends BaseAggregateRoot<String> {
        String entityId;

        @Override
        public String getEntityId() {
            return entityId;
        }
    }
}
