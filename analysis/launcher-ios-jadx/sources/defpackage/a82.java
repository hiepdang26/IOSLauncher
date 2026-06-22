package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class a82 {
    public static final int a;

    static {
        a = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
    }
}
