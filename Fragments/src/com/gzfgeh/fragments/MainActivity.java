package com.gzfgeh.fragments;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.R.integer;
import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener, OnPageChangeListener {
	private View textLayout, soundsLayout, photoLayout, movieLayout;
	private TextView textView, soundsView, photoView, movieView;
	private TextView titleText;
	private TextFragment textFragment;
	private SoundsFragment soundsFragment;
	private PhotoFragment photoFragment;
	private MovieFragment movieFragment;
	private FragmentManager fragmentManager;
	private ViewPager viewPager;
	private FragmentPagerAdapter fragmentPagerAdapter;
	private List<Fragment> fragments = new ArrayList<Fragment>();
	private ImageView cursorView;
	private int cursorWidth;
	private int currentIndex;
	private int cursorOffset;
	private int pageOffset;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState == null) {
            initViews();
            fragmentManager = getSupportFragmentManager();
            fragmentPagerAdapter = new FragmentPagerAdapter(fragmentManager) {
				
				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return fragments.size();
				}
				
				@Override
				public Fragment getItem(int position) {
					// TODO Auto-generated method stub
					return fragments.get(position);
				}
			};
            
			viewPager.setAdapter(fragmentPagerAdapter);
			viewPager.setOnPageChangeListener(this);
        }
    }
    
	@SuppressLint("ResourceAsColor") private void resetSelected(){
		textView.setTextColor(R.color.bottom_bg);
		soundsView.setTextColor(R.color.bottom_bg);
		photoView.setTextColor(R.color.bottom_bg);
		movieView.setTextColor(R.color.bottom_bg);
	}

	private void initViews() {
		// TODO Auto-generated method stub
		textLayout = findViewById(R.id.text_layout);
		soundsLayout = findViewById(R.id.sounds_layout);
		photoLayout = findViewById(R.id.photo_layout);
		movieLayout = findViewById(R.id.movie_layout);
		textLayout.setOnClickListener(this);
		soundsLayout.setOnClickListener(this);
		photoLayout.setOnClickListener(this);
		movieLayout.setOnClickListener(this);
		textView = (TextView) findViewById(R.id.text_msg);
		soundsView = (TextView) findViewById(R.id.sounds_msg);
		photoView = (TextView) findViewById(R.id.photo_msg);
		movieView = (TextView) findViewById(R.id.movie_msg);
		titleText = (TextView) findViewById(R.id.title_text);
		cursorView = (ImageView) findViewById(R.id.cursor);
		viewPager = (ViewPager) findViewById(R.id.container);
		textFragment = new TextFragment();
		soundsFragment = new SoundsFragment();
		photoFragment = new PhotoFragment();
		movieFragment = new MovieFragment();
		fragments.add(textFragment);
		fragments.add(photoFragment);
		fragments.add(soundsFragment);
		fragments.add(movieFragment);
		
		cursorWidth = BitmapFactory.decodeResource(getResources(), R.drawable.cursor).getWidth();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;
		cursorOffset = (screenWidth/4 - cursorWidth) / 2;
		Matrix matrix = new Matrix();
		matrix.postTranslate(cursorOffset, 0);
		cursorView.setImageMatrix(matrix);
		pageOffset = cursorOffset * 2 + cursorWidth;
		
		titleText.setText(R.string.text);
		textView.setTextColor(getResources().getColor(R.color.title_bg));
		
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.text_layout:
			viewPager.setCurrentItem(0);
			break;

		case R.id.photo_layout:
			viewPager.setCurrentItem(1);
			break;
			
		case R.id.sounds_layout:
			viewPager.setCurrentItem(2);
			break;
			
		case R.id.movie_layout:
			viewPager.setCurrentItem(3);
			break;
			
		default:
			break;
		}
	}


	@Override
	public void onPageScrollStateChanged(int position) {
		
	}


	@Override
	public void onPageScrolled(int currentPage, float percentage, int offsetPix) {
		
	}


	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		cursorViewAnimation(position);
		resetSelected();
		
		switch (position) {
		case 0:
			titleText.setText(R.string.text);
			textView.setTextColor(getResources().getColor(R.color.title_bg));
			break;
			
		case 1:
			titleText.setText(R.string.photo);
			photoView.setTextColor(getResources().getColor(R.color.title_bg));
			break;
			
		case 2:
			titleText.setText(R.string.sounds);
			soundsView.setTextColor(getResources().getColor(R.color.title_bg));
			break;
		case 3:
			titleText.setText(R.string.movie);
			movieView.setTextColor(getResources().getColor(R.color.title_bg));
			break;
		}
	}

	private void cursorViewAnimation(int position) {
		Animation animation = new TranslateAnimation(currentIndex * pageOffset, position * pageOffset, 0, 0);
		currentIndex = position;
		animation.setFillAfter(true);
		animation.setDuration(200);
		cursorView.startAnimation(animation);
	}
}
