package com.enphoneh.ViewManager;

import com.enphoneh.utils.ScreenUtils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class SlideMenu extends HorizontalScrollView  {

	/** 
     * 屏幕宽度 
     */  
    private int mScreenWidth;  
    /** 
     * dp 
     */  
    private int mMenuRightPadding = 200;  
    /** 
     * 菜单的宽度 
     */  
    private int mMenuWidth;  
    private int mHalfMenuWidth;  
    private boolean isOpen = false;
    private boolean once=false;  
    private int mOnLayout = 0;
	
	public SlideMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		mScreenWidth = ScreenUtils.getScreenWidth(context);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		 /** 
         * 显示的设置一个宽度 
         */  
        if (!once)  
        {  
            LinearLayout wrapper = (LinearLayout) getChildAt(0);  
            ViewGroup menu = (ViewGroup) wrapper.getChildAt(0);  
            ViewGroup content = (ViewGroup) wrapper.getChildAt(1);  
            // dp to px  
            mMenuRightPadding = (int) TypedValue.applyDimension(  
                    TypedValue.COMPLEX_UNIT_DIP, mMenuRightPadding, content  
                            .getResources().getDisplayMetrics());  
  
            mMenuWidth = mScreenWidth*2/5;  
            mHalfMenuWidth = mMenuWidth / 2;  
            menu.getLayoutParams().width = mScreenWidth*2/5;  
            content.getLayoutParams().width = mScreenWidth;  
        } 
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		if (changed)  
        {  
            // 将菜单隐藏  
			if(mOnLayout < 2){
				 this.scrollTo(mMenuWidth, 0);  
		            once = true;  
			}  else;        
        } 
		else{
			if(mOnLayout < 2){
				this.scrollTo(mMenuWidth, 0);  
			}else;		 
		}
		mOnLayout++;
		super.onLayout(changed, l, t, r, b);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		int action = ev.getAction();  
		Log.i("slidemenu--touch",String.valueOf(action));
        switch (action)  
        {  
        // Up时，进行判断，如果显示区域大于菜单宽度一半则完全显示，否则隐藏       
        case MotionEvent.ACTION_UP:  
            int scrollX = getScrollX();  
            if (scrollX > mHalfMenuWidth)  {
                this.smoothScrollTo(mMenuWidth, 0);  
            	isOpen = false;
            }
            else  {
                this.smoothScrollTo(0, 0);  
                isOpen = true;
            }
            return false;
        }  
        return super.onTouchEvent(ev);
	}
	
	
	
	/**
	 * 打开菜单
	 */
	public void openMenu()
	{
		if (isOpen)
			return;
		this.smoothScrollTo(0, 0);
		isOpen = true;
	}
	/**
	 * 关闭菜单
	 */
	public void closeMenu()
	{
		if (isOpen)
		{
			this.smoothScrollTo(mMenuWidth, 0);
			isOpen = false;
		}
	}

	/**
	 * 切换菜单状态
	 */
	public void toggle()
	{
		if (isOpen)
		{
			closeMenu();
		} else
		{
			openMenu();
		}
	}
}
