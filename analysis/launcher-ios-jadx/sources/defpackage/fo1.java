package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class fo1 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[Bitmap.Config.values().length];
        try {
            iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[Bitmap.Config.ALPHA_8.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        a = iArr;
    }
}
