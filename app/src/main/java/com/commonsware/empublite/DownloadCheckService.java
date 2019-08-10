package com.commonsware.empublite;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DownloadCheckService extends IntentService {
    private static final String OUR_BOOK_DATE = "20120418";

    public DownloadCheckService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }



   private String getUpdateUrl() throws IOException {
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("https://commonsware.com")
               .addConverterFactory(GsonConverterFactory.create())
               .build();

       BookUpdateInterface updateInterface = retrofit.create(BookUpdateInterface.class);
       BookUpdateInfo info = updateInterface.update().execute().body();
       if ( info.updatedOn.compareTo(OUR_BOOK_DATE) > 0){
           return info.updateUrl;
       }

       return null;
   }
}
