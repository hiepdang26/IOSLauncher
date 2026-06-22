package defpackage;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzdsp;

/* JADX INFO: loaded from: classes.dex */
public final class la2 extends f41 {
    public final m92 a;
    public final zzdsp b;
    public final boolean c;
    public final int d;
    public final long e;
    public final Boolean f;

    public la2(m92 m92Var, boolean z, int i, Boolean bool, zzdsp zzdspVar) {
        this.a = m92Var;
        this.c = z;
        this.d = i;
        this.f = bool;
        this.b = zzdspVar;
        hd2.B.j.getClass();
        this.e = System.currentTimeMillis();
    }

    public static long a() {
        hd2.B.j.getClass();
        return ((Long) n42.d.c.zza(zzbbw.zziX)).longValue() + System.currentTimeMillis();
    }

    @Override // defpackage.f41
    public final void onFailure(String str) {
        Pair pair = new Pair("sgf_reason", str);
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair("ad_format", "BANNER");
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", "true");
        hd2.B.j.getClass();
        Pair pair6 = new Pair("lat_ms", Long.toString(System.currentTimeMillis() - this.e));
        Pair pair7 = new Pair("sgpc_rn", Integer.toString(this.d));
        Pair pair8 = new Pair("sgpc_lsu", String.valueOf(this.f));
        boolean z = this.c;
        wd.P(this.b, "sgpcf", pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, new Pair("tpc", true != z ? "0" : "1"));
        this.a.a(z, new ab2(null, str, a(), this.d));
    }

    @Override // defpackage.f41
    public final void onSuccess(e41 e41Var) {
        Pair pair = new Pair("se", "query_g");
        Pair pair2 = new Pair("ad_format", "BANNER");
        Pair pair3 = new Pair("rtype", Integer.toString(6));
        Pair pair4 = new Pair("scar", "true");
        hd2.B.j.getClass();
        Pair pair5 = new Pair("lat_ms", Long.toString(System.currentTimeMillis() - this.e));
        Pair pair6 = new Pair("sgpc_rn", Integer.toString(this.d));
        Pair pair7 = new Pair("sgpc_lsu", String.valueOf(this.f));
        boolean z = this.c;
        wd.P(this.b, "sgpcs", pair, pair2, pair3, pair4, pair5, pair6, pair7, new Pair("tpc", true != z ? "0" : "1"));
        this.a.a(z, new ab2(e41Var, "", a(), this.d));
    }
}
