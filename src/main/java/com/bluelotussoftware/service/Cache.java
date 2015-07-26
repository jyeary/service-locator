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

import java.util.ArrayList;
import java.util.List;

/**
 * A typed implementation of a cache. The implementation accepts classes based
 * on the canonical name using {@link Class#getCanonicalName()}.
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public final class Cache<T> {

    /**
     * Internal list of objects to be cached.
     */
    private final List<T> cache;

    /**
     * Default constructor.
     */
    public Cache() {
        cache = new ArrayList<>();
    }

    /**
     * Fetches the {@code Class} whose name is provided using the
     * {@link Class#getCanonicalName()}
     *
     * @param clazzName The name of the class to look for in the cache.
     * @return The named class instance, or {@code null} if it can not be found
     * in the cache.
     */
    public T get(final String clazzName) {

        for (T t : cache) {
            if (t.getClass().getCanonicalName().equalsIgnoreCase(clazzName)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Adds a {@code Class} to the cache.
     *
     * @param t The object to be added to the cache.
     * <p>
     * <strong>Note:</strong> only one instance of a given {@code Class} can bed
     * added to the cache. Duplicate classed will be ignored.</p>
     */
    public void add(final T t) {
        boolean exists = false;

        for (T o : cache) {
            if (o.getClass().getCanonicalName().equalsIgnoreCase(t.getClass().getCanonicalName())) {
                exists = true;
            }
        }
        if (!exists) {
            cache.add(t);
        }
    }
}
