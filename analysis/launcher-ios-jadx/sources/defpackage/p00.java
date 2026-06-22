package defpackage;

import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class p00 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ThreadMode.values().length];
        a = iArr;
        try {
            iArr[ThreadMode.POSTING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[ThreadMode.MAIN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[ThreadMode.BACKGROUND.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[ThreadMode.ASYNC.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
