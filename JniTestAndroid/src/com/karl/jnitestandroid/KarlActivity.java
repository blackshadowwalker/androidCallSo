package com.karl.jnitestandroid;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.lpr.JniTestAndroid;

public class KarlActivity extends Activity {

	private JniTestAndroid jni = new JniTestAndroid();
	private Button bt;
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_karl);
		
		textView = (TextView)findViewById(R.id.textView);  
		bt = (Button) findViewById(R.id.button1);  
		bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				String str="中国北京123ABC";
				byte data[] =  jni.recognition(str.getBytes());
				String text = new String(data); //new String(data, "GB2312");
				textView.setText(text);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.karl, menu);
		return true;
	}

}
