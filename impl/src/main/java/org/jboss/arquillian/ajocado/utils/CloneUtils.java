/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.arquillian.ajocado.utils;

import java.lang.reflect.Method;

/**
 * Provides functionality for cloning objects.
 * 
 * @author lfryc
 * 
 */
public final class CloneUtils {

    private CloneUtils() {
    }

    /**
     * Clones the cloneable object without need to check for exceptions.
     * 
     * @param <T>
     *            the cloneable object type
     * @param objectToClone
     *            object to clone
     * @return the clone of object
     */
    @SuppressWarnings("unchecked")
    public static <T extends Cloneable> T clone(T objectToClone) {
        if (!(objectToClone instanceof Cloneable)) {
            throw new IllegalArgumentException("objectToClone have to be instance of Cloneable");
        }
        T clone;
        try {
            Method method = objectToClone.getClass().getMethod("clone");
            clone = (T) method.invoke(objectToClone);
        } catch (Exception e) {
            throw new IllegalStateException("Unexpected exception during cloning of "
                + objectToClone.getClass().getName(), e);
        }
        return (T) clone;
    }
}
