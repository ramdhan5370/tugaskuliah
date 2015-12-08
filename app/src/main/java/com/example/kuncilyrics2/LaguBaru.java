package com.example.kuncilyrics2;


import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.example.kuncilyrics2.CordLaguBaru;
import com.example.kuncilyrics2.DBLaguBaru;
import com.example.kuncilyrics2.DefinisiLagu;


public class LaguBaru extends Activity implements TextWatcher, OnItemClickListener {
	
	private EditText carilagubaru;
	private ListView lvlagubaru;
	private DBLaguBaru dblbaru;
	private ArrayAdapter<DefinisiLagu> adapterlagubaru;
	private List<DefinisiLagu> listLaguBaru;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lagu_baru);
		lvlagubaru = (ListView) findViewById(R.id.LV_LaguBaru);
		lvlagubaru.setEmptyView(findViewById(R.id.EmptyLaguBaru));
		carilagubaru = (EditText) findViewById(R.id.CariLaguBaru);
		
		dblbaru = DBLaguBaru.getInstance(this);
		
		setDataLaguBaru();
		
		carilagubaru.addTextChangedListener(this);
		lvlagubaru.setOnItemClickListener(this);
	}
	
	private void setDataLaguBaru() {
		listLaguBaru = dblbaru.getAllLaguBaru();
		adapterlagubaru = new ArrayAdapter<DefinisiLagu>(this, android.R.layout.simple_expandable_list_item_1, listLaguBaru);
		lvlagubaru.setAdapter(adapterlagubaru);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		// TODO Auto-generated method stub
		Bundle b = new Bundle();
		b.putString("judul", adapterlagubaru.getItem(position).getJudul());
		b.putString("cord", adapterlagubaru.getItem(position).getCord());
		
		Intent i = new Intent(this, CordLaguBaru.class);
		i.putExtras(b);
		startActivity(i);
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		adapterlagubaru.getFilter().filter(s.toString());		
	}
}

