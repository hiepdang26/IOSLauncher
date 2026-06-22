package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceScreen;

/* JADX INFO: loaded from: classes.dex */
public final class e31 {
    public final Context a;
    public long b = 0;
    public SharedPreferences c = null;
    public SharedPreferences.Editor d;
    public boolean e;
    public final String f;
    public PreferenceScreen g;
    public z21 h;
    public z21 i;
    public z21 j;

    public e31(Context context) {
        this.a = context;
        this.f = b(context);
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences(b(context), 0);
    }

    public static String b(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public final SharedPreferences.Editor c() {
        if (!this.e) {
            return e().edit();
        }
        if (this.d == null) {
            this.d = e().edit();
        }
        return this.d;
    }

    public final long d() {
        long j;
        synchronized (this) {
            j = this.b;
            this.b = 1 + j;
        }
        return j;
    }

    public final SharedPreferences e() {
        if (this.c == null) {
            this.c = this.a.getSharedPreferences(this.f, 0);
        }
        return this.c;
    }
}
