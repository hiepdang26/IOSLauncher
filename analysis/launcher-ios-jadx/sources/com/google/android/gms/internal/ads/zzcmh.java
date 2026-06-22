package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.hd2;
import defpackage.k80;
import defpackage.n42;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzcmh implements zzcly {
    private final zzeer zza;

    public zzcmh(zzeer zzeerVar) {
        this.zza = zzeerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcly
    public final void zza(Map map) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzjz)).booleanValue()) {
            zzgcj.zzf(zzgca.zzu(this.zza.zza(true)), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcmg
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final do0 zza(Object obj) {
                    Throwable th = (Throwable) obj;
                    if (((Boolean) n42.d.c.zza(zzbbw.zzjA)).booleanValue()) {
                        hd2.B.g.zzx(th, "GetTopicsApiWithRecordObservationActionHandlerUnsampled");
                    } else {
                        hd2.B.g.zzv(th, "GetTopicsApiWithRecordObservationActionHandler");
                    }
                    return zzgcj.zzh(new k80(zzfxr.zzm()));
                }
            }, zzbzo.zza);
        }
    }
}
