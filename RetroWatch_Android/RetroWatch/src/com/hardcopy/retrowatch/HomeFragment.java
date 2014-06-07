package com.hardcopy.retrowatch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

@SuppressLint("ValidFragment") 
public class HomeFragment extends Fragment implements OnClickListener{
	private final RetroWatchActivity mRetroWatchActivity;
	EditText message_text;
	
	public HomeFragment(RetroWatchActivity mRetroWatchActivity) {
		this.mRetroWatchActivity = mRetroWatchActivity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		
		rootView.findViewById(R.id.send_message).setOnClickListener(this);
		rootView.findViewById(R.id.call_on).setOnClickListener(this);
		
		message_text = (EditText)rootView.findViewById(R.id.send_content);
		
		return rootView;
	}
	
	@Override
	public void onClick(View view) {
		switch(view.getId()){
		case R.id.send_message:
			String message = message_text.getText().toString();
			System.out.println(String.format("=====  send_message  %s======", message));
			mRetroWatchActivity.sendMessage(message);
			break;
		case R.id.call_on:
			System.out.println(String.format("=====  call_on  ======"));
			mRetroWatchActivity.sendCallState();
			break;
		}
	}
}
