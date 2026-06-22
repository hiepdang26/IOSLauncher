package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.tc2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfll {
    private final Context zza;
    private final Executor zzb;
    private final tc2 zzc;
    private final zzfki zzd;

    public zzfll(Context context, Executor executor, tc2 tc2Var, zzfki zzfkiVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = tc2Var;
        this.zzd = zzfkiVar;
    }

    public final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    public final /* synthetic */ void zzb(String str, zzfkf zzfkfVar) {
        zzfju zzfjuVarZza = zzfjt.zza(this.zza, 14);
        zzfjuVarZza.zzi();
        zzfjuVarZza.zzg(this.zzc.zza(str));
        if (zzfkfVar == null) {
            this.zzd.zzb(zzfjuVarZza.zzm());
        } else {
            zzfkfVar.zza(zzfjuVarZza);
            zzfkfVar.zzh();
        }
    }

    public final void zzc(final String str, final zzfkf zzfkfVar) {
        if (zzfki.zza() && ((Boolean) zzbdl.zzd.zze()).booleanValue()) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzflk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb(str, zzfkfVar);
                }
            });
        } else {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzflj
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(str);
                }
            });
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), null);
        }
    }
}
