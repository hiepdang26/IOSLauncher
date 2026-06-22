package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzevu implements zzevo {
    private final Context zza;
    private final zzgcu zzb;

    public zzevu(Context context, zzgcu zzgcuVar) {
        this.zza = context;
        this.zzb = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 59;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return ((Boolean) zzbdk.zzb.zze()).booleanValue() ? this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzevt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        }) : zzgcj.zzh(null);
    }

    public final /* synthetic */ zzevv zzc() {
        Context context = this.zza;
        return new zzevv(zzbbg.zzb(context), zzbbg.zza(context));
    }
}
