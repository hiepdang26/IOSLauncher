package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import defpackage.d62;
import defpackage.g82;
import defpackage.gy0;
import defpackage.he0;
import defpackage.i72;
import defpackage.k72;
import defpackage.l82;
import defpackage.m72;
import defpackage.n82;
import defpackage.r92;
import defpackage.u72;
import defpackage.x6;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class zzbob extends zzcge {
    private final x6 zza;

    public zzbob(x6 x6Var) {
        this.zza = x6Var;
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final int zzb(String str) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new n82(r92Var, str, d62Var, 1));
        Integer num = (Integer) d62.s(d62Var.q(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final long zzc() {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new g82(r92Var, d62Var, 2));
        Long l = (Long) d62.s(d62Var.q(500L), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long jNanoTime = System.nanoTime();
        r92Var.b.getClass();
        long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
        int i = r92Var.e + 1;
        r92Var.e = i;
        return jNextLong + ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final Bundle zzd(Bundle bundle) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new n82(r92Var, bundle, d62Var, 0));
        return d62Var.q(5000L);
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final String zze() {
        return this.zza.a.g;
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final String zzf() {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new g82(r92Var, d62Var, 1));
        return (String) d62.s(d62Var.q(50L), String.class);
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final String zzg() {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new g82(r92Var, d62Var, 4));
        return (String) d62.s(d62Var.q(500L), String.class);
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final String zzh() {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new g82(r92Var, d62Var, 3));
        return (String) d62.s(d62Var.q(500L), String.class);
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final String zzi() {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new g82(r92Var, d62Var, 0));
        return (String) d62.s(d62Var.q(500L), String.class);
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final List zzj(String str, String str2) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new m72(r92Var, str, str2, d62Var, 0));
        List list = (List) d62.s(d62Var.q(5000L), List.class);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final Map zzk(String str, String str2, boolean z) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        d62 d62Var = new d62();
        r92Var.b(new l82(r92Var, str, str2, z, d62Var));
        Bundle bundleQ = d62Var.q(5000L);
        if (bundleQ == null || bundleQ.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(bundleQ.size());
        for (String str3 : bundleQ.keySet()) {
            Object obj = bundleQ.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzl(String str) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new u72(r92Var, str, 0));
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzm(String str, String str2, Bundle bundle) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new k72(r92Var, str, str2, bundle, 0));
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzn(String str) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new u72(r92Var, str, 1));
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzo(String str, String str2, Bundle bundle) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new k72(r92Var, str, str2, bundle, 1));
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzp(Bundle bundle) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new n82(r92Var, bundle, new d62(), 0));
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzq(Bundle bundle) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new i72(r92Var, bundle, 0));
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzr(Bundle bundle) {
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new i72(r92Var, bundle, 1));
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzs(he0 he0Var, String str, String str2) {
        Activity activity = he0Var != null ? (Activity) gy0.r(he0Var) : null;
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new m72(r92Var, activity, str, str2));
    }

    @Override // com.google.android.gms.internal.ads.zzcgf
    public final void zzt(String str, String str2, he0 he0Var) {
        Object objR = he0Var != null ? gy0.r(he0Var) : null;
        r92 r92Var = this.zza.a;
        r92Var.getClass();
        r92Var.b(new m72(r92Var, str, str2, objR, 3));
    }
}
