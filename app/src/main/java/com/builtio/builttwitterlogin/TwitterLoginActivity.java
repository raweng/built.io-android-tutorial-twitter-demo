package com.builtio.builttwitterlogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.raweng.built.Built;
import com.raweng.built.BuiltApplication;
import com.raweng.built.BuiltError;
import com.raweng.built.BuiltUser;
import com.raweng.built.userInterface.BuiltUILoginController;
import com.raweng.built.utilities.BuiltUtil;

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
public class TwitterLoginActivity extends BuiltUILoginController{

    private BuiltApplication builtApplication;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        /*
         * Intialising built application
         */

        try {
            builtApplication = Built.application(this ,"YOUR_APP_API_KEY");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
		 *  Checking user session is present on disc 
		 */
		if(builtApplication.getCurrentUser() != null){
			Intent detailIntent = new Intent(TwitterLoginActivity.this, UserDetails.class);
			startActivity(detailIntent);
			finish();
		}
		
		/*
		 *User can customize layout from outside.
		 */
		emailEditText.setVisibility(View.INVISIBLE);
		passwordEditText.setVisibility(View.INVISIBLE);
		
		loginButton.setVisibility(View.GONE);
		googleLoginButton.setVisibility(View.GONE);
		signUpButton.setVisibility(View.INVISIBLE);
		forgetPasswordImageView.setVisibility(View.GONE);
		
		signUpInfoTextView.setVisibility(View.INVISIBLE);
		
		twitterLoginButton.setGravity(Gravity.CENTER);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		try {
			
			int left  = BuiltUtil.convertToPixel(TwitterLoginActivity.this, 40);
			int right = BuiltUtil.convertToPixel(TwitterLoginActivity.this, 40);
			
			params.leftMargin  = left;
			params.rightMargin = right;
			
			twitterLoginButton.setLayoutParams(params);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		/*
		 * For login with twitter user need to set consumer key and consumer secret. 
		 */
		setUpTwitter("qhxtnOdQfkgYGEakodSkAA", "GXsQwo1CNMjE5XiCcaptPMVpaTPIv0x00rmOvZT3wkc");
		
		ProgressDialog dialog = new ProgressDialog(TwitterLoginActivity.this);
		dialog.setCancelable(false);
		
		/*
		 * Setting progress dialog while login.
		 */
		setProgressDialog(dialog);
		
	}
	
	@Override
	public void loginSuccess(BuiltUser user) {
		
		/*
		 * Saving user session is present on disc 
		 */
		Intent detailIntent = new Intent(TwitterLoginActivity.this, UserDetails.class);
		startActivity(detailIntent);
		finish();
		
	}

	@Override
	public void loginError(BuiltError error) {
		
		/*
		 * login failed
		 * the message, code and details of the error
		 */
		Toast.makeText(TwitterLoginActivity.this, "Error :"+ error.getErrorMessage(), Toast.LENGTH_SHORT).show();
	}

}