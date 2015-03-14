package com.gzfgeh.fragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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
    	private Button loadButton, signButton;
    	private EditText userName,passWord;
    	private String userNameString, passWordString;

		public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
            loadButton = (Button) getActivity().findViewById(R.id.login_button);
            signButton = (Button) getActivity().findViewById(R.id.signin_button);
            userName = (EditText) getActivity().findViewById(R.id.username);
            passWord = (EditText) getActivity().findViewById(R.id.password);
            loadButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					userNameString = userName.getText().toString().trim();
	    	    	passWordString = passWord.getText().toString().trim();
	    	    	
	    			if (userNameString == " " || userNameString == null 
	    					|| passWordString == " " || passWordString == null){
	    				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    				builder.setMessage(R.string.login_warning);
	    				builder.show();
	    			}else{
	    				
	    			}
				}
			});
		}
        
        
//        public void onLoaderClick (View view){
//        	FragmentTransaction ft = getFragmentManager().beginTransaction();
//        	switch (view.getId()) {
//    		case R.id.login_button:
//    			userNameString = userName.getText().toString().trim();
//    	    	passWordString = passWord.getText().toString().trim();
//    	    	
//    			if (userNameString == null || passWordString == null){
//    				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//    				builder.setMessage(R.string.login_warning);
//    				builder.show();
//    			}else{
//    				
//    			}
//    				
//    			break;
//    			
//    		case R.id.signin_button:
////    			if (sign == null){
////    				sign = new SignFragment();
////    				ft.add(sign, "sign");
////    			}
//    			ft.hide(this);
//    			ft.addToBackStack(null);
//    			ft.commit();
//    			break;
//    			
//    		default:
//    			break;
//    		}
//        }
        
    }

}
