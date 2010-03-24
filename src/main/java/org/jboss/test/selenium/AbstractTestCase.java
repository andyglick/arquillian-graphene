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
package org.jboss.test.selenium;

import org.jboss.test.selenium.framework.AjaxSelenium;
import org.jboss.test.selenium.waiting.SeleniumWaiting;
import org.jboss.test.selenium.waiting.Wait;
import org.jboss.test.selenium.waiting.ajax.*;
import org.jboss.test.selenium.waiting.conditions.*;
import org.jboss.test.selenium.waiting.retrievers.*;

public abstract class AbstractTestCase {
    
    protected AjaxSelenium selenium;

    protected SeleniumWaiting waitModel = Wait.interval(500).timeout(30000);
    protected AjaxWaiting waitGui = Wait.interval(100).timeout(5000);
    
    protected ElementPresent elementPresent = ElementPresent.getInstance();
    protected TextEquals textEquals = TextEquals.getInstance();

    protected TextRetriever retrieveText = TextRetriever.getInstance();
    protected AttributeRetriever retrieveAttribute = AttributeRetriever.getInstance();
}
