/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.assembler.fixtures;


import org.seedstack.business.api.interfaces.assembler.BaseAssembler;

public class MyAssembler extends BaseAssembler<MyAggregateRoot, MyUnrestrictedDto> {

    @Override
    protected void doAssembleDtoFromAggregate(MyUnrestrictedDto targetDto, MyAggregateRoot sourceEntity) {
        targetDto.setNom(sourceEntity.getLastName() + ", " + sourceEntity.getFirstName());
        targetDto.setAge(sourceEntity.getAge());
        targetDto.setAddresse(sourceEntity.getAddress());
    }

    @Override
    public void doMergeAggregateWithDto(MyAggregateRoot targetEntity, MyUnrestrictedDto sourceDto) {
        String[] split = sourceDto.getNom().split(",");
        targetEntity.setFirstName(split[1].trim());
        targetEntity.setLastName(split[0].trim());
        targetEntity.setAge(sourceDto.getAge());
        targetEntity.setAddress(sourceDto.getAddresse());
    }
}