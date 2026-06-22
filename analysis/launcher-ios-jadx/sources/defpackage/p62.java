package defpackage;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class p62 implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final String g;
    public final /* synthetic */ s62 h;

    public p62(s62 s62Var, String str) {
        this.h = s62Var;
        this.g = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.h) {
            try {
                ArrayList arrayList = this.h.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    String str2 = this.g;
                    HashMap map = ((c62) obj).a;
                    if (map.containsKey(str2) && ((Set) map.get(str2)).contains(str)) {
                        ((ib2) hd2.B.g.zzi()).h(false);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
