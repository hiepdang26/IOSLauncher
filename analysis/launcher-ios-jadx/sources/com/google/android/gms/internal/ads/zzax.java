package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzax {
    public final Uri zza;
    public final String zzb;
    public final zzas zzc;
    public final zzal zzd;
    public final List zze;
    public final String zzf;
    public final zzfxr zzg;
    public final Object zzh;
    public final long zzi;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ zzax(Uri uri, String str, zzas zzasVar, zzal zzalVar, List list, String str2, zzfxr zzfxrVar, Object obj, long j, zzaw zzawVar) {
        this.zza = uri;
        int i = zzbn.zza;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzfxrVar;
        zzfxo zzfxoVar = new zzfxo();
        if (zzfxrVar.size() > 0) {
            throw null;
        }
        zzfxoVar.zzi();
        this.zzh = null;
        this.zzi = -9223372036854775807L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzax)) {
            return false;
        }
        zzax zzaxVar = (zzax) obj;
        return this.zza.equals(zzaxVar.zza) && zzet.zzG(null, null) && zzet.zzG(null, null) && zzet.zzG(null, null) && this.zze.equals(zzaxVar.zze) && zzet.zzG(null, null) && this.zzg.equals(zzaxVar.zzg) && zzet.zzG(null, null) && zzet.zzG(-9223372036854775807L, -9223372036854775807L);
    }

    public final int hashCode() {
        return (int) ((((long) ((this.zzg.hashCode() + ((this.zze.hashCode() + (this.zza.hashCode() * 923521)) * 961)) * 31)) * 31) - Long.MAX_VALUE);
    }
}
