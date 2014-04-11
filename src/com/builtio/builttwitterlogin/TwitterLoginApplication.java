package com.builtio.builttwitterlogin;

import com.raweng.built.Built;

import android.app.Application;

/**
 * This is built.io android tutorial.
 * 
 * Short introduction of some classes with some methods.
 * Contain classes: 
 * 1. BuiltUILoginController
 * 2. BuiltUser
 * 
 * For quick start with built.io refer "http://docs.built.io/quickstart/index.html#android"
 * 
 * @author raw engineering, Inc
 *
 */
public class TwitterLoginApplication extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
		
		/*
		 * Initialize the application for a project using built.io Application credentials "Application Api Key" 
		 * and "Application UID".
		 * 
		 */
		try {
			Built.initializeWithApiKey(TwitterLoginApplication.this, "YOUR_APP_API_KEY", "YOUR_APP_UID");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}