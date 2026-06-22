package defpackage;

import com.google.android.gms.internal.ads.zzdfc;
import com.google.android.gms.internal.ads.zzdsf;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class ac2 implements zzdfc {
    public final zzdsf g;
    public final vb2 h;
    public final String i;

    public ac2(zzdsf zzdsfVar, vb2 vb2Var, String str) {
        this.g = zzdsfVar;
        this.h = vb2Var;
        this.i = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zze(v32 v32Var) {
        if (v32Var == null) {
            return;
        }
        vb2 vb2Var = this.h;
        String str = this.i;
        zzdsf zzdsfVar = this.g;
        String str2 = v32Var.b;
        synchronized (vb2Var) {
            hd2.B.j.getClass();
            vb2Var.e.put(str, new ob2(Long.valueOf(System.currentTimeMillis()), str2, new HashSet()));
            vb2Var.g();
            vb2Var.e(zzdsfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zzf(String str) {
    }
}
