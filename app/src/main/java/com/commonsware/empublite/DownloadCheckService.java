package com.commonsware.empublite;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;


public class DownloadCheckService extends IntentService {

    public DownloadCheckService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
