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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignFragment extends Fragment {
	private Button nextSignButton;
	private EditText signUserName,signPassWord;
	private String signUserNameString,signPassWordString;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.signin, container,false);
		signUserName = (EditText) view.findViewById(R.id.sign_user_input);
        signPassWord = (EditText) view.findViewById(R.id.sign_password_input);
        nextSignButton = (Button) view.findViewById(R.id.next_signin_button);
		return view;
	}
	
	public void signOnLoaderClick(View view){
		signUserNameString = signUserName.getText().toString();
		signPassWordString = signPassWord.getText().toString();
		
		if (signUserNameString == null || signPassWordString == null)
			Toast.makeText(getActivity(), "²»ÄÜÎª¿Õ", Toast.LENGTH_SHORT).show();
		else {
			SharedPreferences sharedPreferences = getActivity().getSharedPreferences("password", Context.MODE_PRIVATE);
			Editor editor = sharedPreferences.edit();
			editor.putString("name", signUserNameString);
			editor.putString("password", signPassWordString);
			editor.commit();
			
			
			Bundle bundle = new Bundle();
			bundle.putString("Status", "OK");
			this.setArguments(bundle);
			getFragmentManager().beginTransaction().hide(this).commit();
		}
	}
}
