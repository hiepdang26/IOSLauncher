package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.a41;
import defpackage.a52;
import defpackage.k52;
import defpackage.p2;
import defpackage.p52;
import defpackage.rc2;
import defpackage.y62;

/* JADX INFO: loaded from: classes.dex */
public final class zzeln extends p52 {
    final zzffe zza;
    final zzdjk zzb;
    private final Context zzc;
    private final zzcgj zzd;
    private a52 zze;

    public zzeln(zzcgj zzcgjVar, Context context, String str) {
        zzffe zzffeVar = new zzffe();
        this.zza = zzffeVar;
        this.zzb = new zzdjk();
        this.zzd = zzcgjVar;
        zzffeVar.zzt(str);
        this.zzc = context;
    }

    @Override // defpackage.q52
    public final k52 zze() {
        zzdjm zzdjmVarZzg = this.zzb.zzg();
        this.zza.zzE(zzdjmVarZzg.zzi());
        this.zza.zzF(zzdjmVarZzg.zzh());
        zzffe zzffeVar = this.zza;
        if (zzffeVar.zzh() == null) {
            zzffeVar.zzs(rc2.b());
        }
        return new zzelo(this.zzc, this.zzd, this.zza, zzdjmVarZzg, this.zze);
    }

    @Override // defpackage.q52
    public final void zzf(zzbgb zzbgbVar) {
        this.zzb.zza(zzbgbVar);
    }

    @Override // defpackage.q52
    public final void zzg(zzbge zzbgeVar) {
        this.zzb.zzb(zzbgeVar);
    }

    @Override // defpackage.q52
    public final void zzh(String str, zzbgk zzbgkVar, zzbgh zzbghVar) {
        this.zzb.zzc(str, zzbgkVar, zzbghVar);
    }

    @Override // defpackage.q52
    public final void zzi(zzblq zzblqVar) {
        this.zzb.zzd(zzblqVar);
    }

    @Override // defpackage.q52
    public final void zzj(zzbgo zzbgoVar, rc2 rc2Var) {
        this.zzb.zze(zzbgoVar);
        this.zza.zzs(rc2Var);
    }

    @Override // defpackage.q52
    public final void zzk(zzbgr zzbgrVar) {
        this.zzb.zzf(zzbgrVar);
    }

    @Override // defpackage.q52
    public final void zzl(a52 a52Var) {
        this.zze = a52Var;
    }

    @Override // defpackage.q52
    public final void zzm(p2 p2Var) {
        this.zza.zzr(p2Var);
    }

    @Override // defpackage.q52
    public final void zzn(zzblh zzblhVar) {
        this.zza.zzw(zzblhVar);
    }

    @Override // defpackage.q52
    public final void zzo(zzbes zzbesVar) {
        this.zza.zzD(zzbesVar);
    }

    @Override // defpackage.q52
    public final void zzp(a41 a41Var) {
        this.zza.zzG(a41Var);
    }

    @Override // defpackage.q52
    public final void zzq(y62 y62Var) {
        this.zza.zzV(y62Var);
    }
}
