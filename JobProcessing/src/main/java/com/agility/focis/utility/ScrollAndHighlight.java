package com.agility.focis.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

public class ScrollAndHighlight extends BaseTest{

	public static void scrolltoElement(WebElement ScrolltoThisElement) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", ScrolltoThisElement);
		highlightElement(ScrolltoThisElement);
		}
	
	public static void highlightElement(WebElement element) {
        
		try {
			
			for (int i = 0; i < 5; i++) {
				JavascriptExecutor js = (JavascriptExecutor)BaseTest.getDriver();
				js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 5px solid red;');",
						element);
			}
		} catch (Exception e) {

			
			System.err.println("Unable to Highlight Element");
			
		}
	}

        }


