package com.commonsware.empublite;

public class BookLoadedEvent {
    private BookContents contents = null;



    public BookContents getBook() {
        return contents;
    }
    public BookLoadedEvent(BookContents contents){
        this.contents = contents;
    }
}
