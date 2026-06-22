package defpackage;

import com.google.android.gms.internal.ads.zzapd;
import com.google.android.gms.internal.ads.zzaph;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzaqe;
import com.google.android.gms.internal.ads.zzbzt;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j52 extends zzaph {
    public final zzbzt g;
    public final ub2 h;

    public j52(String str, zzbzt zzbztVar) {
        super(0, str, new xz1(zzbztVar));
        this.g = zzbztVar;
        ub2 ub2Var = new ub2();
        this.h = ub2Var;
        if (ub2.c()) {
            ub2Var.d("onNetworkRequest", new ol1(str, "GET", (Map) null, (byte[]) null));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzapn zzh(zzapd zzapdVar) {
        return zzapn.zzb(zzapdVar, zzaqe.zzb(zzapdVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zzo(Object obj) {
        zzapd zzapdVar = (zzapd) obj;
        Map map = zzapdVar.zzc;
        int i = zzapdVar.zza;
        ub2 ub2Var = this.h;
        ub2Var.getClass();
        if (ub2.c()) {
            ub2Var.d("onNetworkResponse", new t3(i, map));
            if (i < 200 || i >= 300) {
                ub2Var.d("onNetworkRequestError", new wg1(null, 3));
            }
        }
        byte[] bArr = zzapdVar.zzb;
        if (ub2.c() && bArr != null) {
            ub2Var.d("onNetworkResponseBody", new xz1(bArr));
        }
        this.g.zzc(zzapdVar);
    }
}
