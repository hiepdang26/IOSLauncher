package defpackage;

import android.util.SparseIntArray;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzapq;

/* JADX INFO: loaded from: classes.dex */
public final class b52 implements zzapl {
    public final Object g;
    public final Object h;

    public b52(String str, g52 g52Var) {
        this.g = str;
        this.h = g52Var;
    }

    @Override // com.google.android.gms.internal.ads.zzapl
    public void zza(zzapq zzapqVar) {
        k92.h("Failed to load URL: " + ((String) this.g) + "\n" + zzapqVar.toString());
        ((g52) this.h).zzc(null);
    }

    public b52() {
        da0 da0Var = da0.d;
        this.g = new SparseIntArray();
        this.h = da0Var;
    }
}
