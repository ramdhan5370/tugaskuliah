package com.example.kuncilyrics2;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

public class LoadingSpleshScreen extends AsyncTask<String, Integer, Integer> {
	public interface LoadingTaskFinishedListener {
		void onTaskFinished();
	}
	
	private final ProgressBar pb;
	private final LoadingTaskFinishedListener finish;
	
	public LoadingSpleshScreen(ProgressBar pb, LoadingTaskFinishedListener finish) {
		this.pb = pb;
		this.finish = finish;
	}
	
	protected Integer doInBackground(String... params) {
		Log.i("Lalala","Lilili" +params[0]);
		if(resourcesDontAlreadyExist()) {
			downloadResources();
		}
		return 1234;
	}
	
	private boolean resourcesDontAlreadyExist () {
		return true;
	}
	
	private void downloadResources() {
		int count = 10;
		for(int i = 0; i < count; i++) {
			int progress = (int)((i / (float) count) *100);
			publishProgress(progress);
			try {
				Thread.sleep(100);
			} catch(InterruptedException ignore) {
				
			}
		}
	}
	
	protected void onProgressUpdate(Integer... v) {
		super.onProgressUpdate(v);
		pb.setProgress(v[0]);
	}
	
	protected void onPostExecute(Integer r) {
		super.onPostExecute(r);
		finish.onTaskFinished();
	}
}

