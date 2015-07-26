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
package com.bluelotussoftware.service.spi;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public interface InitialContext {

    /**
     * Create a new instance of the requested class.
     *
     * @param clazzName The {@link Class#getCanonicalName()} of the class to
     * created, or found.
     * @return An instance of the class whose name is provided, or {@code null}
     * if it can not be created, or found.
     */
    Object lookup(String clazzName);

}
