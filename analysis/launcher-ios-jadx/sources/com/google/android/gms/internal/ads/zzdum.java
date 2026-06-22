package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.hd2;

/* JADX INFO: loaded from: classes.dex */
final class zzdum extends zzbky {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfju zzd;
    final /* synthetic */ zzbzt zze;
    final /* synthetic */ zzdun zzf;

    public zzdum(zzdun zzdunVar, Object obj, String str, long j, zzfju zzfjuVar, zzbzt zzbztVar) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfjuVar;
        this.zze = zzbztVar;
        this.zzf = zzdunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkz
    public final void zze(String str) {
        synchronized (this.zza) {
            zzdun zzdunVar = this.zzf;
            String str2 = this.zzb;
            hd2.B.j.getClass();
            zzdunVar.zzv(str2, false, str, (int) (SystemClock.elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, "error");
            this.zzf.zzo.zzb(this.zzb, "error");
            zzfki zzfkiVar = this.zzf.zzp;
            zzfju zzfjuVar = this.zzd;
            zzfjuVar.zzc(str);
            zzfjuVar.zzg(false);
            zzfkiVar.zzb(zzfjuVar.zzm());
            this.zze.zzc(Boolean.FALSE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkz
    public final void zzf() {
        synchronized (this.zza) {
            zzdun zzdunVar = this.zzf;
            String str = this.zzb;
            hd2.B.j.getClass();
            zzdunVar.zzv(str, true, "", (int) (SystemClock.elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfki zzfkiVar = this.zzf.zzp;
            zzfju zzfjuVar = this.zzd;
            zzfjuVar.zzg(true);
            zzfkiVar.zzb(zzfjuVar.zzm());
            this.zze.zzc(Boolean.TRUE);
        }
    }
}
