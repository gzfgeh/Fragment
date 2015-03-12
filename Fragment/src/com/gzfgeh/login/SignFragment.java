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

public class SignFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.signin, container,false);
		return view;
	}
	
//	public void signOnLoaderClick(View view){
//		userNameString = userName.getText().toString();
//		passWordString = passWord.getText().toString();
//		
//		if (userNameString == null || passWordString == null)
//			Toast.makeText(getActivity(), "²»ÄÜÎª¿Õ", Toast.LENGTH_SHORT).show();
//		else {
//			SharedPreferences sharedPreferences = getActivity().getSharedPreferences("password", Context.MODE_PRIVATE);
//			Editor editor = sharedPreferences.edit();
//			editor.putString("name", userNameString);
//			editor.putString("password", passWordString);
//			editor.commit();
//			
//			
//			Bundle bundle = new Bundle();
//			bundle.putString("Status", "OK");
//			this.setArguments(bundle);
//			getFragmentManager().beginTransaction().hide(this).commit();
//		}
//	}
}
