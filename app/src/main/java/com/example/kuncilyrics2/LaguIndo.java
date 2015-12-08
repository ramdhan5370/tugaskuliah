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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.example.kuncilyrics2.CordLaguIndo;
import com.example.kuncilyrics2.DBLaguIndo;
import com.example.kuncilyrics2.DefinisiLagu;

public class LaguIndo extends Activity implements TextWatcher, OnItemClickListener {
	
	private EditText carilaguindo;
	private ListView lvlaguindo;
	private DBLaguIndo dblindo;
	private ArrayAdapter<DefinisiLagu> adapterlaguindo;
	private List<DefinisiLagu> listLaguIndo;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lagu_indo);
		lvlaguindo = (ListView) findViewById(R.id.LV_LaguIndo);
		lvlaguindo.setEmptyView(findViewById(R.id.EmptyLaguIndo));
		carilaguindo = (EditText) findViewById(R.id.CariLaguIndo);
		
		dblindo = DBLaguIndo.getInstance(this);
		
		setDataLaguIndo();
		
		carilaguindo.addTextChangedListener(this);
		lvlaguindo.setOnItemClickListener(this);
	}
	
	private void setDataLaguIndo() {
		listLaguIndo = dblindo.getAllLaguIndo();
		adapterlaguindo = new ArrayAdapter<DefinisiLagu>(this, android.R.layout.simple_expandable_list_item_1, listLaguIndo);
		lvlaguindo.setAdapter(adapterlaguindo);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		// TODO Auto-generated method stub
		Bundle b = new Bundle();
		b.putString("judul", adapterlaguindo.getItem(position).getJudul());
		b.putString("cord", adapterlaguindo.getItem(position).getCord());
		
		Intent i = new Intent(this, CordLaguIndo.class);
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
		adapterlaguindo.getFilter().filter(s.toString());		
	}
}
