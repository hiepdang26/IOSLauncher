package com.google.android.renderscript;

import android.graphics.Bitmap;
import defpackage.hs0;
import defpackage.qg0;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public final class Toolkit {
    public static final Toolkit a;
    public static final long b;

    static {
        Toolkit toolkit = new Toolkit();
        a = toolkit;
        System.loadLibrary("renderscript-toolkit");
        b = toolkit.createNative();
    }

    private final native long createNative();

    private final native void nativeBlurBitmap(long j, Bitmap bitmap, Bitmap bitmap2, int i, Range2d range2d);

    public final Bitmap a(int i, Bitmap bitmap) {
        qg0.l(bitmap, "inputBitmap");
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2 && bitmap.getConfig() != Bitmap.Config.ALPHA_8) {
            throw new IllegalArgumentException(("RenderScript Toolkit. blur supports only ARGB_8888 and ALPHA_8 bitmaps. " + bitmap.getConfig() + " provided.").toString());
        }
        if (hs0.c(bitmap) * bitmap.getWidth() != bitmap.getRowBytes()) {
            throw new IllegalArgumentException(("RenderScript Toolkit blur. Only bitmaps with rowSize equal to the width * vectorSize are currently supported. Provided were rowBytes=" + bitmap.getRowBytes() + ", width={" + bitmap.getWidth() + ", and vectorSize=" + hs0.c(bitmap) + '.').toString());
        }
        if (1 > i || i >= 26) {
            throw new IllegalArgumentException(uo.d(i, "RenderScript Toolkit blur. The radius should be between 1 and 25. ", " provided.").toString());
        }
        bitmap.getWidth();
        bitmap.getHeight();
        Bitmap.Config config3 = bitmap.getConfig();
        if (config3 != null) {
            config2 = config3;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config2);
        nativeBlurBitmap(b, bitmap, bitmapCreateBitmap, i, null);
        return bitmapCreateBitmap;
    }
}
