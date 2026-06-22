package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public interface aa {
    public static final boolean a;

    static {
        a = Build.VERSION.SDK_INT >= 27;
    }
}
