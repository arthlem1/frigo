package com.arthuretboris.app.frigo;

import android.graphics.Bitmap;
import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;

/**
 * Created by Arthur on 31/01/16.
 */
public class TessOCr {
    private TessBaseAPI mTess;

    public TessOCr() {
        mTess = new TessBaseAPI();
        String datapath = Environment.getExternalStorageDirectory() + "/frigo/";
        String language = "fra+eng";
        File dir = new File(datapath + "tessdata/");
        if (!dir.exists())
            dir.mkdirs();
        mTess.init(datapath, language);
    }

    public String getOCRResult(Bitmap bitmap) {

        mTess.setImage(bitmap);
        String result = mTess.getUTF8Text();

        return result;
    }

    public void onDestroy() {
        if (mTess != null)
            mTess.end();
    }


}
