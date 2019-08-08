package com.commonsware.empublite;

public class NoteLoadedEvent {
    int position;
    String prose;

    NoteLoadedEvent(int position, String prose){
        this.position = position;
        this.prose = prose;
    }


    public String getProse() {
        return prose;
    }


    public int getPosition(){
        return position;
    }
}
