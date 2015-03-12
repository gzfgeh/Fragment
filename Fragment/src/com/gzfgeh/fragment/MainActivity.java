package com.gzfgeh.fragment;


import com.gzfgeh.login.SignFragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private SignFragment sign;
	private PlaceholderFragment placeholderFragment;
	
	private EditText userName,passWord;
	private EditText signUserName,signPassWord;
	private Button loadButton, signButton, nextSignButton;
	private String userNameString, passWordString;
	private String signUserNameString,signPassWordString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.login_user_input);
        passWord = (EditText) findViewById(R.id.login_password_input);
        signUserName = (EditText) findViewById(R.id.sign_user_input);
        signPassWord = (EditText) findViewById(R.id.sign_password_input);
        
        loadButton = (Button) findViewById(R.id.login_button);
        signButton = (Button) findViewById(R.id.signin_button);
        nextSignButton = (Button) findViewById(R.id.next_signin_button);
        
        if (savedInstanceState == null) {
        	placeholderFragment = new PlaceholderFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, placeholderFragment)
                    .commit();
        }
        
    }
    
    public void onLoaderClick (View view){
    	
    	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    	
    	switch (view.getId()) {
		case R.id.login_button:
			userNameString = userName.getText().toString().trim();
	    	passWordString = passWord.getText().toString().trim();
	    	
			if (userNameString == null || passWordString == null){
				new AlertDialog.Builder(this).
				setMessage("账号或者密码不能为空").show();
			}else{
				
			}
				
			break;
			
		case R.id.signin_button:
			if (sign == null){
				sign = new SignFragment();
				ft.add(sign, "sign");
			}
			ft.hide(placeholderFragment);
			ft.addToBackStack(null);
			ft.commit();
			break;
			
		case R.id.next_signin_button:
			signUserNameString = signUserName.getText().toString().trim();
	    	signPassWordString = signPassWord.getText().toString().trim();
	    	
	    	if (signUserNameString == null || signPassWordString == null){
				new AlertDialog.Builder(this).
				setMessage("账号或者密码不能为空").show();
			}else{
				
			}
			break;
			
		default:
			break;
		}
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            return rootView;
        }
        
    }

}
