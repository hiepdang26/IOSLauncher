package defpackage;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class jb2 extends LinkedHashMap {
    public final /* synthetic */ vb2 g;

    public jb2(vb2 vb2Var) {
        this.g = vb2Var;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        synchronized (this.g) {
            try {
                int size = size();
                vb2 vb2Var = this.g;
                if (size <= vb2Var.a) {
                    return false;
                }
                vb2Var.f.add(new Pair((String) entry.getKey(), ((ob2) entry.getValue()).b));
                return size() > this.g.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
