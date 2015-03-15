package com.gzfgeh.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	private View textLayout, soundsLayout, photoLayout, movieLayout;
	private TextFragment textFragment;
	private SoundsFragment soundsFragment;
	private PhotoFragment photoFragment;
	private MovieFragment movieFragment;
	private FragmentManager fragmentManager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState == null) {
            initViews();
            fragmentManager = getSupportFragmentManager();
            selectFragmentNum(0);
        }
    }


    @SuppressLint({ "CommitTransaction", "ResourceAsColor" }) private void selectFragmentNum(int i) {
		// TODO Auto-generated method stub
		FragmentTransaction ft = fragmentManager.beginTransaction();
		hideAllFragments(ft);
		
		switch (i) {
		case 0:
			textLayout.setBackgroundColor(R.color.title_bg);
			if (textFragment == null){
				textFragment = new TextFragment();
				ft.add(R.id.container, textFragment);
			}else{
				ft.show(textFragment);
			}
			break;
			
		case 1:
			photoLayout.setBackgroundColor(R.color.title_bg);
			if (photoFragment == null){
				photoFragment = new PhotoFragment();
				ft.add(R.id.container, photoFragment);
			}else{
				ft.show(photoFragment);
			}
			break;
			
		case 2:
			soundsLayout.setBackgroundColor(R.color.title_bg);
			if (soundsFragment == null){
				soundsFragment = new SoundsFragment();
				ft.add(R.id.container, soundsFragment);
			}else{
				ft.show(soundsFragment);
			}
			break;
		case 3:
			movieLayout.setBackgroundColor(R.color.title_bg);
			if (movieFragment == null){
				movieFragment = new MovieFragment();
				ft.add(R.id.container, movieFragment);
			}else{
				ft.show(movieFragment);
			}
			break;
		default:
			break;
		}
		ft.commit();
	}


	@SuppressLint("ResourceAsColor") private void hideAllFragments(FragmentTransaction ft) {
		// TODO Auto-generated method stub
		if (textFragment != null)
			ft.hide(textFragment);
		
		if (soundsFragment != null)
			ft.hide(soundsFragment);
		
		if (photoFragment != null)
			ft.hide(photoFragment);
		
		if (movieFragment != null)
			ft.hide(movieFragment);
		
		textLayout.setBackgroundColor(R.color.bottom_bg);
		soundsLayout.setBackgroundColor(R.color.bottom_bg);
		photoLayout.setBackgroundColor(R.color.bottom_bg);
		movieLayout.setBackgroundColor(R.color.bottom_bg);
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

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.text_layout:
			selectFragmentNum(0);
			break;

		case R.id.photo_layout:
			selectFragmentNum(1);
			break;
			
		case R.id.sounds_layout:
			selectFragmentNum(2);
			break;
			
		case R.id.movie_layout:
			selectFragmentNum(3);
			break;
			
		default:
			break;
		}
	}
}
