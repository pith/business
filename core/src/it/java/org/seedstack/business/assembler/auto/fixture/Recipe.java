/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.assembler.auto.fixture;

import org.seedstack.business.api.interfaces.assembler.DtoOf;

/**
* @author pierre.thirouin@ext.mpsa.com (Pierre Thirouin)
*/
@DtoOf({Order.class, Customer.class})
public class Recipe {
    String customerFirstName;
    String customerLastName;
    String billingStreet;
    String billingCity;

    public Recipe() {
    }

    public Recipe(String customerFirstName, String customerLastName, String billingStreet, String billingCity) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.billingStreet = billingStreet;
        this.billingCity = billingCity;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }
}
