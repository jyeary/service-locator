/*
 * Copyright 2015 Blue Lotus Software, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * $Id$
 */
package com.bluelotussoftware.service;

import com.bluelotussoftware.service.spi.InitialContext;
import java.util.ServiceLoader;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class ServiceLocator {

    private static ServiceLocator serviceLocator;
    private final ServiceLoader serviceLoader;
    private static final Cache cache;
    private static InitialContext initialContext;

    static {
        cache = new Cache();
    }

    private ServiceLocator() {
        /* This example defaults to using the first InitialContext that it finds.
         * You can make this more sophisticated by examing the multiple contexts.
         */
        serviceLoader = ServiceLoader.load(InitialContext.class);
        initialContext = (InitialContext) serviceLoader.iterator().next();
    }

    public static synchronized ServiceLocator getInstance() {
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator();
        }
        return serviceLocator;
    }

    public static Object get(String jndiName) {
        Object service;

        if (initialContext == null) {
            throw new ContextNotInitializedException("The context must be initialized before calling get()");
        }

        service = cache.get(jndiName);

        if (service != null) {
            return service;
        }

        /* This example defaults to using the first InitialContext that it finds.
         * You can make this more sophisticated by examing the multiple contexts from the 
         * service loader to see if any of the provided contexts loaded by the SPI can resolve the lookup.
         */
        service = initialContext.lookup(jndiName);
        if (service != null) {
            cache.add(service);

        }
        return service;
    }

}
