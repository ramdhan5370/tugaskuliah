package com.example.kuncilyrics2;


import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.example.kuncilyrics2.DefinisiLagu;

public class DBLaguBaru extends SQLiteAssetHelper {
	
	private static final String DB = "lagubaru";
	private static final int VER = 1;
	private static final String TABEL_LBARU = "tb_laguband";
	
	public static final String ID = "_id";
	public static final String JUDUL = "judul";
	public static final String CORD = "cord";
	
	private static DBLaguBaru dbInstance;
	private static SQLiteDatabase db;
	
	private DBLaguBaru(Context context) {
		super(context, "lagubaru", null, 1);
	}
	
	public static DBLaguBaru getInstance(Context context) {
		if(dbInstance == null) {
			dbInstance = new DBLaguBaru(context);
			db = dbInstance.getWritableDatabase();
		}
		return dbInstance;
	}
	
	public synchronized void close() {
		super.close();
		if(dbInstance != null) {
			dbInstance.close();
		}
	}
	
	public List<DefinisiLagu> getAllLaguBaru() {
		List<DefinisiLagu> listLaguBaru = new ArrayList<DefinisiLagu>();
		Cursor cursor = db.query(TABEL_LBARU, new String[] { ID, ID, JUDUL, CORD }, null, null, null, null, CORD);
		if(cursor.getCount() >= 1) {
			cursor.moveToFirst();
			do {
				DefinisiLagu lagu = new DefinisiLagu();
				lagu.setJudul(cursor.getString(cursor.getColumnIndexOrThrow(JUDUL)));
				lagu.setCord(cursor.getString(cursor.getColumnIndexOrThrow(CORD)));
				listLaguBaru.add(lagu);
			}
			while(cursor.moveToNext());
		}
		return listLaguBaru;
	}
	
	public Cursor getCordByJudul(String query) {
		Cursor cursor = null;
		if(TextUtils.isEmpty(query)) {
			cursor = db.query(TABEL_LBARU, new String[] { ID, JUDUL, CORD }, null, null, null, null, null, "10");
		}
		else {
			cursor = db.query(TABEL_LBARU, new String[] { ID, JUDUL, CORD }, CORD + " like '" +query+ "%'", null, null, null, null);
		}
		return cursor;
	}
}
