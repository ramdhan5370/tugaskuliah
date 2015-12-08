package com.example.kuncilyrics2;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import com.example.kuncilyrics2.MenuTabs;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button lanjutkan = (Button) findViewById(R.id.MainLanjutkan);
        Button keluar = (Button) findViewById(R.id.MainKeluar);
        
        lanjutkan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanjutkan();
			}
		});
        
        keluar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				keluar();
			}
		});
    }
    
    public void lanjutkan() {
    	Intent i = new Intent(this, MenuTabs.class);
    	startActivity(i);
    }
    
    public void keluar() {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Apakah Anda ingin Keluar ?").setCancelable(false).setPositiveButton("Ya",new DialogInterface.OnClickListener() {
						
			@Override
			public void onClick(DialogInterface dialog, int id) {
				// TODO Auto-generated method stub
				MainActivity.this.finish();
			}
		}).setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int id) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		}).show();
    }
}
