package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.nj;
import defpackage.us;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsn implements zzfjm {
    private final zzdsf zzb;
    private final nj zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdsn(zzdsf zzdsfVar, Set set, nj njVar) {
        this.zzb = zzdsfVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdsm zzdsmVar = (zzdsm) it.next();
            this.zzd.put(zzdsmVar.zzc, zzdsmVar);
        }
        this.zzc = njVar;
    }

    private final void zze(zzfjf zzfjfVar, boolean z) {
        zzfjf zzfjfVar2 = ((zzdsm) this.zzd.get(zzfjfVar)).zzb;
        if (this.zza.containsKey(zzfjfVar2)) {
            String str = true != z ? "f." : "s.";
            nj njVar = this.zzc;
            Map map = this.zza;
            ((us) njVar).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - ((Long) map.get(zzfjfVar2)).longValue();
            this.zzb.zzb().put("label.".concat(((zzdsm) this.zzd.get(zzfjfVar)).zza), str.concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzd(zzfjf zzfjfVar, String str) {
        if (this.zza.containsKey(zzfjfVar)) {
            nj njVar = this.zzc;
            Map map = this.zza;
            ((us) njVar).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - ((Long) map.get(zzfjfVar)).longValue();
            zzdsf zzdsfVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdsfVar.zzb().put("task.".concat(strValueOf), "s.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfjfVar)) {
            zze(zzfjfVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdC(zzfjf zzfjfVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdD(zzfjf zzfjfVar, String str, Throwable th) {
        if (this.zza.containsKey(zzfjfVar)) {
            nj njVar = this.zzc;
            Map map = this.zza;
            ((us) njVar).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - ((Long) map.get(zzfjfVar)).longValue();
            zzdsf zzdsfVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdsfVar.zzb().put("task.".concat(strValueOf), "f.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfjfVar)) {
            zze(zzfjfVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdE(zzfjf zzfjfVar, String str) {
        ((us) this.zzc).getClass();
        this.zza.put(zzfjfVar, Long.valueOf(SystemClock.elapsedRealtime()));
    }
}
