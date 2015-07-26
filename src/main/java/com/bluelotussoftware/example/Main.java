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
package com.bluelotussoftware.example;

import com.bluelotussoftware.service.ServiceLocator;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 */
public class Main {

    public static void main(String[] args) {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        Object o = serviceLocator.get("java.lang.Object");
        System.out.println(o.toString());
        Object o1 = serviceLocator.get("java.lang.Object");
        System.out.println(o1.toString());

        Object o2 = serviceLocator.get("java.lang.Double");
        System.out.println(o2);
        Object o3 = serviceLocator.get("java.lang.Double");
        System.out.println(o3);
    }

}
