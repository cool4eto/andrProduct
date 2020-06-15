package com.example.products3.async;

import android.os.AsyncTask;

import androidx.fragment.app.FragmentManager;

public class LoadAsync extends AsyncTask<Integer,Void,Void> {
    ProgressFragment fragment;
    FragmentManager fragmentManager;
    ProgressFinishListener listener;

    public LoadAsync(FragmentManager fragmentManager, ProgressFinishListener listener) {
        this.fragmentManager = fragmentManager;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        fragment=ProgressFragment.newInstance();
        fragment.setCancelable(false);
        fragment.show(fragmentManager,"dunno");
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int secs=integers[0];
        for(int i=secs;i>0;i--)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        fragment.dismiss();
    }
}
