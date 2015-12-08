package com.example.kuncilyrics2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Context;

public class CordLaguBaru extends Activity {
	
	private TextView txtjudul, txtcord;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cord);
		txtjudul = (TextView) findViewById(R.id.Judul);
		txtcord = (TextView) findViewById(R.id.Cord);
		
		Bundle b = getIntent().getExtras();
		if(b != null) {
			txtjudul.setText(b.getString("judul"));
			txtcord.setText(b.getString("cord"));
		}
	}
}

