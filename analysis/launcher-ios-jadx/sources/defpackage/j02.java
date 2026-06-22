package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class j02 {
    public static final j02 b;
    public f1 a;

    static {
        j02 j02Var = new j02();
        j02Var.a = null;
        b = j02Var;
    }

    public static f1 a(Context context) {
        f1 f1Var;
        j02 j02Var = b;
        synchronized (j02Var) {
            try {
                if (j02Var.a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    j02Var.a = new f1(context, 3);
                }
                f1Var = j02Var.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return f1Var;
    }
}
