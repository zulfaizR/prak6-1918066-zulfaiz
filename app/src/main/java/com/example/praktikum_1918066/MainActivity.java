package com.example.praktikum_1918066;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        findViewById(R.id.button).setOnClickListener(new
                                                             View.OnClickListener() {
                                                                 @Override
                                                                 public void onClick(View view) {
                                                                     WorkManager.getInstance().enqueueUniqueWork(
                                                                             "Notifikasi", ExistingWorkPolicy.REPLACE, request);
                                                                 }
                                                             });
    }

}