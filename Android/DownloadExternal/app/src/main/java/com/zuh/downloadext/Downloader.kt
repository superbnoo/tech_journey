package com.zuh.downloadext

import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.net.URL

class Downloader {
    companion object {
        fun testDownload(context: Context) {
            Log.d("vatran", "conheocon testDownload");
            // open file to write
            val dirs = ContextCompat.getExternalFilesDirs(context, null)
            if (dirs.isEmpty()) return
            val directory = File(dirs[if (dirs.size > 1) 1 else 0].absolutePath)
            val file = File(directory, "ch_ppocr_mobile_v2.0_rec_opt.nb")
            if (file.exists()) {
                file.delete()
            }

            val url = "https://spdocr.blob.core.windows.net/release/ch_ppocr_mobile_v2.0_rec_opt.nb"
            URL(url).openStream().use { input ->
                FileOutputStream(file).use { output ->
                    input.copyTo(output)
                    Log.d("vatran", "conheocon downloaded")
                }
            }
        }
    }
}