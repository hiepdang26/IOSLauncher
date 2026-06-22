package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.yb2;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class zzdfs {
    private final zzdgx zza;
    private final zzcej zzb;

    public zzdfs(zzdgx zzdgxVar, zzcej zzcejVar) {
        this.zza = zzdgxVar;
        this.zzb = zzcejVar;
    }

    public static final zzdei zzh(zzfjr zzfjrVar) {
        return new zzdei(zzfjrVar, zzbzo.zzf);
    }

    public static final zzdei zzi(zzdhc zzdhcVar) {
        return new zzdei(zzdhcVar, zzbzo.zzf);
    }

    public final View zza() {
        zzcej zzcejVar = this.zzb;
        if (zzcejVar == null) {
            return null;
        }
        return zzcejVar.zzG();
    }

    public final View zzb() {
        zzcej zzcejVar = this.zzb;
        if (zzcejVar != null) {
            return zzcejVar.zzG();
        }
        return null;
    }

    public final zzcej zzc() {
        return this.zzb;
    }

    public final zzdei zzd(Executor executor) {
        final zzcej zzcejVar = this.zzb;
        return new zzdei(new zzdbg() { // from class: com.google.android.gms.internal.ads.zzdfr
            @Override // com.google.android.gms.internal.ads.zzdbg
            public final void zza() {
                yb2 yb2VarZzL;
                zzcej zzcejVar2 = zzcejVar;
                if (zzcejVar2 == null || (yb2VarZzL = zzcejVar2.zzL()) == null) {
                    return;
                }
                yb2VarZzL.zzb();
            }
        }, executor);
    }

    public final zzdgx zze() {
        return this.zza;
    }

    public Set zzf(zzcvn zzcvnVar) {
        return Collections.singleton(new zzdei(zzcvnVar, zzbzo.zzf));
    }

    public Set zzg(zzcvn zzcvnVar) {
        return Collections.singleton(new zzdei(zzcvnVar, zzbzo.zzf));
    }
}
