package com.zuh.downloadext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

import java.io.File;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    // https://spdocr.blob.core.windows.net/release/yolov4-tiny-416.tflite
    // https://spdocr.blob.core.windows.net/release/ch_ppocr_mobile_v2.0_rec_opt.nb

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * // Threads stuff
     */
    private Handler handler;
    private HandlerThread handlerThread;

    @Override
    public synchronized void onStart() {
        super.onStart();
    }

    @Override
    public synchronized void onResume() {
        super.onResume();

        handlerThread = new HandlerThread("inference");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        runInBackground(() -> {
            Downloader.Companion.testDownload(this);
        });
    }

    @Override
    public synchronized void onPause() {
        handlerThread.quit();
        try {
            handlerThread.join();
            handlerThread = null;
            handler = null;
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        super.onPause();
    }

    @Override
    public synchronized void onStop() {
        super.onStop();
    }

    @Override
    public synchronized void onDestroy() {
        super.onDestroy();
    }

    protected synchronized void runInBackground(final Runnable r) {
        if (handler != null) {
            handler.post(r);
        }
    }
}