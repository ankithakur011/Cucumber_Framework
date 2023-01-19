package org.digital.testautomation.generic;

import org.digital.testautomation.manager.BrowserManager;
import io.cucumber.java.After;

public class Hooks {
	
	@After(order = 0)
	public void quitBrowser() {
		BrowserManager.getDriver().quit();
	}

}
