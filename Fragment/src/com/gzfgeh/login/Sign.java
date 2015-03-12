package com.gzfgeh.login;

import com.gzfgeh.fragment.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class Sign extends Fragment {
	private String userNameString,passwordString;
	private SharedPreferencesData sp;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.signin, container,false);
		EditText userName = (EditText) view.findViewById(R.id.sign_user_input);
		EditText password = (EditText) view.findViewById(R.id.sign_password_input);
		userNameString = userName.getText().toString();
		passwordString = password.getText().toString();
		
		return view;
	}
	
	public void signOnLoaderClick(View view){
		if (userNameString == null || passwordString == null)
			Toast.makeText(getActivity(), "²»ÄÜÎª¿Õ", Toast.LENGTH_SHORT).show();
		else {
			SharedPreferences sharedPreferences = getActivity().getSharedPreferences("password", Context.MODE_PRIVATE);
			Editor editor = sharedPreferences.edit();
			editor.putString("name", userNameString);
			editor.putString("password", passwordString);
			editor.commit();
			
			
			Bundle bundle = new Bundle();
			bundle.putString("Status", "OK");
			this.setArguments(bundle);
			getFragmentManager().beginTransaction().hide(this).commit();
		}
	}
}
