/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagesite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBCategoryThreadMessageRecentPostsSiteTest extends BaseTestCase {
	public void testViewMBCategoryThreadMessageRecentPostsSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard");
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.type("//input[@class='search-input']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Forums"),
			selenium.getText("//nav/ul/li[contains(.,'Forums')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Forums')]/a/span",
			RuntimeVariables.replace("Forums"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Recent Posts",
			RuntimeVariables.replace("Recent Posts"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread Message Subject"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//td[3]/a"));
		assertTrue(selenium.isVisible("//td[4]/a"));
		assertTrue(selenium.isPartialText("//td[5]/a", "By: Joe Bloggs"));
		selenium.clickAt("//td[1]/a",
			RuntimeVariables.replace("MB Category Thread Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread Message Subject"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("\u00ab Back to MB Category Name"),
			selenium.getText("//a[@id='_19_TabsBack']"));
		assertEquals(RuntimeVariables.replace("Threads [ Previous | Next ]"),
			selenium.getText("//div[@class='thread-navigation']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread Message Subject"),
			selenium.getText("//div[@class='subject']/a"));
		assertEquals(RuntimeVariables.replace("MB Category Thread Message Body"),
			selenium.getText("//div[@class='thread-body']"));
		assertEquals(RuntimeVariables.replace("0 (0 Votes)"),
			selenium.getText("//div[contains(@id,'ratingThumbContent')]/div"));
	}
}