package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnm implements zzbix {
    private final zzbgh zza;
    private final zzdoa zzb;
    private final zzhew zzc;

    public zzdnm(zzdjm zzdjmVar, zzdjb zzdjbVar, zzdoa zzdoaVar, zzhew zzhewVar) {
        this.zza = zzdjmVar.zzc(zzdjbVar.zzA());
        this.zzb = zzdoaVar;
        this.zzc = zzhewVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        try {
            this.zza.zze((zzbfx) this.zzc.zzb(), (String) map.get("asset"));
        } catch (RemoteException unused) {
            k92.j(5);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzl("/nativeAdCustomClick", this);
    }
}
