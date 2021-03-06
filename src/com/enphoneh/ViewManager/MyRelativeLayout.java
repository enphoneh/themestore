package com.enphoneh.ViewManager;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MyRelativeLayout extends RelativeLayout {

	public MyRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();  
		Log.i("relative--dispatch",String.valueOf(action));
		switch(action)
		{
		case MotionEvent.ACTION_DOWN:
			this.setBackgroundColor(Color.parseColor("#d3d3d3"));
			break;
		case MotionEvent.ACTION_UP:
			this.setBackgroundColor(Color.parseColor("#1ab3eb"));
			break;
		case MotionEvent.ACTION_OUTSIDE:
			this.setBackgroundColor(Color.parseColor("#1ab3eb"));
			break;
		case MotionEvent.ACTION_CANCEL:
			this.setBackgroundColor(Color.parseColor("#1ab3eb"));
			break;
		}
		return true;
	}

}
