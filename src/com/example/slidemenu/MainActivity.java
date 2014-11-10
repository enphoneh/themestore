package com.example.slidemenu;

import com.enphoneh.ViewManager.SlideMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {

	private SlideMenu mMenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);		
		mMenu = (SlideMenu) findViewById(R.id.id_menu);
	}
	public void toggleMenu(View view)
	{
		mMenu.toggle();
	}
}
