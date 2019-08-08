package com.commonsware.empublite;


import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment {
    private static final String KEY_POSITION = "position";
    private EditText editor = null;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

        if (TextUtils.isEmpty(editor.getText())){
            DatabaseHelper db = DatabaseHelper.getInstance(getActivity());
            db.loadNote(getPosition());
        }
    }

    public NoteFragment() {
        // Required empty public constructor
    }

    static NoteFragment newInstance(int position){
        NoteFragment frag = new NoteFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.editor, container, false);
        editor = (EditText) result.findViewById(R.id.editor);
        return result;
    }

    private int getPosition(){
        return getArguments().getInt(KEY_POSITION, -1);
    }


    @Override
    public void onStop(){
        DatabaseHelper.getInstance(getActivity())
        .updateNote( getPosition(), editor.getText().toString());

        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNoteLoaded(NoteLoadedEvent event){
        if (event.getPosition() == getPosition()){
            editor.setText(event.getProse());
        }
    }

}
