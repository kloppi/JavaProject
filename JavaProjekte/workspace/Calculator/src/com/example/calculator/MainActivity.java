package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button plus, minus;
	EditText ergebnis;
	int count;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		plus = (Button) findViewById(R.id.bPlus);
		minus = (Button) findViewById(R.id.bMinus);
		ergebnis = (EditText) findViewById(R.id.twErgebnis);
		count = 0;
		plus.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
			count +=2;
			ergebnis.setText("Plus 2 ergab "+ count);
				
			}
		});
		
		minus.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
			count--;
			ergebnis.setText("Minus ergab " + count);
			}
			
		});
		
	}
}
