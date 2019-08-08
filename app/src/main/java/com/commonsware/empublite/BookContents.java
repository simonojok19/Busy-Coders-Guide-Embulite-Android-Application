package com.commonsware.empublite;

import java.util.List;

public class BookContents {

    static class Chapter {
        String file;
        String title;
    }


    List<BookContents.Chapter> chapters;

    int getChapterCount() {
        return chapters.size();
    }



    String getChapterTitle(int position){
        return chapters.get(position).title;
    }

    String getChapterFile(int position){
        return chapters.get(position).file;
    }

}
