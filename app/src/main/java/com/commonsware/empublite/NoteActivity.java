package com.commonsware.empublite;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class NoteActivity extends Activity implements NoteFragment.Contract {
    public static final String EXTRA_POSITION = "position";
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getFragmentManager().findFragmentById(android.R.id.content) == null){
            int position = getIntent().getIntExtra(EXTRA_POSITION, -1);
            if ( position >= 0 ){
                Fragment f = NoteFragment.newInstance(position);
                getFragmentManager().beginTransaction()
                        .add(android.R.id.content, f)
                        .commit();
            }
        }
        Log.d(TAG, "NoteFragment Created and started");
    }

    @Override
    public void closeNotes(){
        finish();;
    }
}
