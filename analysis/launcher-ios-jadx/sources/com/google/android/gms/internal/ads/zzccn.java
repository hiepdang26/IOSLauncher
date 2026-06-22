package com.google.android.gms.internal.ads;

import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.j42;
import defpackage.n42;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzccn extends j42 {
    final zzcbk zza;
    final zzccv zzb;
    private final String zzc;
    private final String[] zzd;

    public zzccn(zzcbk zzcbkVar, zzccv zzccvVar, String str, String[] strArr) {
        this.zza = zzcbkVar;
        this.zzb = zzccvVar;
        this.zzc = str;
        this.zzd = strArr;
        hd2.B.z.zzb(this);
    }

    @Override // defpackage.j42
    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            cd2.l.post(new zzccm(this));
        }
    }

    @Override // defpackage.j42
    public final do0 zzb() {
        return (((Boolean) n42.d.c.zza(zzbbw.zzbM)).booleanValue() && (this.zzb instanceof zzcde)) ? zzbzo.zze.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzccl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        }) : super.zzb();
    }

    public final /* synthetic */ Boolean zzd() {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
