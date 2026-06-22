package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class s62 {
    public final HashMap a = new HashMap();
    public final ArrayList b = new ArrayList();
    public final Context c;

    public s62(Context context) {
        this.c = context;
    }

    public final void a() {
        zzbbn zzbbnVar = zzbbw.zzjz;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            cd2 cd2Var = hd2.B.c;
            HashMap mapH = cd2.H((String) n42Var.c.zza(zzbbw.zzjE));
            for (String str : mapH.keySet()) {
                synchronized (this) {
                    try {
                        if (!this.a.containsKey(str)) {
                            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.c) : this.c.getSharedPreferences(str, 0);
                            p62 p62Var = new p62(this, str);
                            this.a.put(str, p62Var);
                            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(p62Var);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            b(new c62(mapH));
        }
    }

    public final synchronized void b(c62 c62Var) {
        this.b.add(c62Var);
    }
}
