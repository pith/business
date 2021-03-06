/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.internal;


import io.nuun.kernel.spi.Concern;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author epo.jemba@ext.mpsa.com
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Concern(name="seed-business-concern", priority= Concern.Priority.NORMAL,order=100)
public @interface BusinessConcern {

}
