package com.example.kuncilyrics2;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.example.kuncilyrics2.DefinisiLagu;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBLaguIndo extends SQLiteAssetHelper {
	
	private static final String DB = "laguband";
	private static final int VER = 1;
	private static final String TABEL_LINDO = "tb_lagubaru";
	public static final String ID = "_id";
	public static final String JUDUL = "judul";
	public static final String CORD = "cord";
	private static DBLaguIndo dbInstance;
	private static SQLiteDatabase db;
	
	private DBLaguIndo(Context context) {
		super(context,"laguband", null, 1);
	}
	
	public static DBLaguIndo getInstance(Context context) {
		if(dbInstance == null) {
			dbInstance = new DBLaguIndo(context);
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
	
	public List<DefinisiLagu> getAllLaguIndo() {
		List<DefinisiLagu> listLaguBaru = new ArrayList<DefinisiLagu>();
		Cursor cursor = db.query(TABEL_LINDO, new String[] { ID, ID, JUDUL, CORD }, null, null, null, null, CORD);
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
			cursor = db.query(TABEL_LINDO, new String[] { ID, JUDUL, CORD }, null, null, null, null, null, "10");
		}
		else {
			cursor = db.query(TABEL_LINDO, new String[] { ID, JUDUL, CORD }, CORD + " like '" +query+ "%'", null, null, null, null);
		}
		return cursor;
	}
}

