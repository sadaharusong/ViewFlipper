package com.example.viewflipper;

import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	private ViewFlipper flipper;
	private int[] resID = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4};
	private float startX;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		flipper = (ViewFlipper)findViewById(R.id.flipper);
		flipper.addView(getImageView(R.drawable.p1));
		flipper.addView(getImageView(R.drawable.p2));
		flipper.addView(getImageView(R.drawable.p3));
		flipper.addView(getImageView(R.drawable.p4));
		flipper.setBackgroundColor(color.black);
		//动态导入的方式为ViewFlipper加入子View
		/*for(int i = 0 ; i < 0 ; i++)
		{
			flipper.addView(getImageView(resID[i]));
		}*/
		//flipper.setInAnimation(this,R.anim.left_in);
		//flipper.setInAnimation(this, R.anim.right_out);
		//flipper.setFlipInterval(3000);
		//flipper.startFlipping();
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			startX = event.getX();
			break;
		
		case MotionEvent.ACTION_MOVE:
			if(event.getX() - startX > 100)
			{
				flipper.setInAnimation(this, R.anim.left_in);
				flipper.setOutAnimation(this, R.anim.letf_out);
				flipper.showPrevious();//显示前一页
			}
			if (startX - event.getX() > 100)
			{
				flipper.setInAnimation(this, R.anim.right_in);
				flipper.setOutAnimation(this, R.anim.right_out);
				flipper.showNext();//显示后一页
			}
			break;
		case MotionEvent.ACTION_UP:
			break;
		
		
		}
		
		return super.onTouchEvent(event);
	}
	private ImageView getImageView(int resID)
	{
		ImageView image = new ImageView(this);
		image.setBackgroundResource(resID);
		return image;
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
