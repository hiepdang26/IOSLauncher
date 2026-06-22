package defpackage;

import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzgbp;
import com.google.android.gms.internal.ads.zzgcf;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class w22 implements zzgcf, zzgbp {
    public final /* synthetic */ y22 g;

    public /* synthetic */ w22(y22 y22Var) {
        this.g = y22Var;
    }

    @Override // com.google.android.gms.internal.ads.zzgbp
    public do0 zza() {
        y22 y22Var = this.g;
        return y22Var.f(y22Var.h, null, "BANNER", null, null, new Bundle()).zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public void zzb(Object obj) {
        k92.d("Initialized webview successfully for SDKCore.");
        if (((Boolean) n42.d.c.zza(zzbbw.zziO)).booleanValue()) {
            y22 y22Var = this.g;
            wd.P(y22Var.q, "sgs", new Pair("se", "query_g"), new Pair("ad_format", "BANNER"), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("sgi_rn", Integer.toString(y22Var.I.get())));
            y22Var.H.set(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public void zza(Throwable th) {
        hd2.B.g.zzw(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        y22 y22Var = this.g;
        zzdsp zzdspVar = y22Var.q;
        Pair pair = new Pair("sgf_reason", th.getMessage());
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair("ad_format", "BANNER");
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", "true");
        AtomicInteger atomicInteger = y22Var.I;
        wd.P(zzdspVar, "sgf", pair, pair2, pair3, pair4, pair5, new Pair("sgi_rn", Integer.toString(atomicInteger.get())));
        k92.f();
        zzbbn zzbbnVar = zzbbw.zziO;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() || y22Var.H.get() || atomicInteger.getAndIncrement() >= ((Integer) n42Var.c.zza(zzbbw.zziP)).intValue()) {
            return;
        }
        y22Var.q();
    }
}
