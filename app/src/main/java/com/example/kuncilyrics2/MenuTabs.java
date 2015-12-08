package com.example.kuncilyrics2;

import android.app.TabActivity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.widget.TabHost;
import com.example.kuncilyrics2.LaguBaru;
import com.example.kuncilyrics2.LaguIndo;

public class MenuTabs extends TabActivity {
	
	private static final String LAGUBARU = "Lagu Baru";
	private static final String LAGUINDO = "Lagu Indo";
	
	
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		this.setContentView(R.layout.menu_tab);
		
		TabHost tabHost = this.getTabHost();
		
		TabHost.TabSpec tabSpec = tabHost.newTabSpec("Lagu Baru");
		tabSpec.setIndicator((CharSequence)"Lagu Baru");
		tabSpec.setContent(new Intent((Context)this,(Class)LaguBaru.class));
		
		TabHost.TabSpec tabSpec2= tabHost.newTabSpec("Lagu Indo");
		tabSpec2.setIndicator((CharSequence)"Lagu Indo");
		tabSpec2.setContent(new Intent((Context)this,(Class)LaguIndo.class));

		tabHost.addTab(tabSpec);
		tabHost.addTab(tabSpec2);
				
		tabHost.setCurrentTab(0);
	}
}
