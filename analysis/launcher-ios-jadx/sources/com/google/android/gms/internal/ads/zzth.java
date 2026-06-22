package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzth implements zzuk {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzur zzc = new zzur();
    private final zzrd zzd = new zzrd();
    private Looper zze;
    private zzcc zzf;
    private zznz zzg;

    @Override // com.google.android.gms.internal.ads.zzuk
    public /* synthetic */ zzcc zzM() {
        return null;
    }

    public final zznz zzb() {
        zznz zznzVar = this.zzg;
        zzdi.zzb(zznzVar);
        return zznzVar;
    }

    public final zzrd zzc(zzui zzuiVar) {
        return this.zzd.zza(0, zzuiVar);
    }

    public final zzrd zzd(int i, zzui zzuiVar) {
        return this.zzd.zza(0, zzuiVar);
    }

    public final zzur zze(zzui zzuiVar) {
        return this.zzc.zza(0, zzuiVar);
    }

    public final zzur zzf(int i, zzui zzuiVar) {
        return this.zzc.zza(0, zzuiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzg(Handler handler, zzre zzreVar) {
        this.zzd.zzb(handler, zzreVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzh(Handler handler, zzus zzusVar) {
        this.zzc.zzb(handler, zzusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzi(zzuj zzujVar) {
        boolean zIsEmpty = this.zzb.isEmpty();
        this.zzb.remove(zzujVar);
        if (zIsEmpty || !this.zzb.isEmpty()) {
            return;
        }
        zzj();
    }

    public void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzk(zzuj zzujVar) {
        this.zze.getClass();
        HashSet hashSet = this.zzb;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(zzujVar);
        if (zIsEmpty) {
            zzl();
        }
    }

    public void zzl() {
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzm(zzuj zzujVar, zzgu zzguVar, zznz zznzVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (looper != null && looper != looperMyLooper) {
            z = false;
        }
        zzdi.zzd(z);
        this.zzg = zznzVar;
        zzcc zzccVar = this.zzf;
        this.zza.add(zzujVar);
        if (this.zze == null) {
            this.zze = looperMyLooper;
            this.zzb.add(zzujVar);
            zzn(zzguVar);
        } else if (zzccVar != null) {
            zzk(zzujVar);
            zzujVar.zza(this, zzccVar);
        }
    }

    public abstract void zzn(zzgu zzguVar);

    public final void zzo(zzcc zzccVar) {
        this.zzf = zzccVar;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzuj) arrayList.get(i)).zza(this, zzccVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzp(zzuj zzujVar) {
        this.zza.remove(zzujVar);
        if (!this.zza.isEmpty()) {
            zzi(zzujVar);
            return;
        }
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzb.clear();
        zzq();
    }

    public abstract void zzq();

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzr(zzre zzreVar) {
        this.zzd.zzc(zzreVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzs(zzus zzusVar) {
        this.zzc.zzh(zzusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public /* synthetic */ void zzt(zzbc zzbcVar) {
        throw null;
    }

    public final boolean zzu() {
        return !this.zzb.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public /* synthetic */ boolean zzv() {
        return true;
    }
}
