package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzkw {
    private final zznz zza;
    private final zzkv zze;
    private final zzln zzh;
    private final zzdt zzi;
    private boolean zzj;
    private zzgu zzk;
    private zzwa zzl = new zzwa(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzkw(zzkv zzkvVar, zzln zzlnVar, zzdt zzdtVar, zznz zznzVar) {
        this.zza = zznzVar;
        this.zze = zzkvVar;
        this.zzh = zzlnVar;
        this.zzi = zzdtVar;
    }

    private final void zzr(int i, int i2) {
        while (i < this.zzb.size()) {
            ((zzku) this.zzb.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzs(zzku zzkuVar) {
        zzkt zzktVar = (zzkt) this.zzf.get(zzkuVar);
        if (zzktVar != null) {
            zzktVar.zza.zzi(zzktVar.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzku zzkuVar = (zzku) it.next();
            if (zzkuVar.zzc.isEmpty()) {
                zzs(zzkuVar);
                it.remove();
            }
        }
    }

    private final void zzu(zzku zzkuVar) {
        if (zzkuVar.zze && zzkuVar.zzc.isEmpty()) {
            zzkt zzktVar = (zzkt) this.zzf.remove(zzkuVar);
            zzktVar.getClass();
            zzktVar.zza.zzp(zzktVar.zzb);
            zzktVar.zza.zzs(zzktVar.zzc);
            zzktVar.zza.zzr(zzktVar.zzc);
            this.zzg.remove(zzkuVar);
        }
    }

    private final void zzv(zzku zzkuVar) {
        zzud zzudVar = zzkuVar.zza;
        zzuj zzujVar = new zzuj() { // from class: com.google.android.gms.internal.ads.zzkm
            @Override // com.google.android.gms.internal.ads.zzuj
            public final void zza(zzuk zzukVar, zzcc zzccVar) {
                this.zza.zzf(zzukVar, zzccVar);
            }
        };
        zzks zzksVar = new zzks(this, zzkuVar);
        this.zzf.put(zzkuVar, new zzkt(zzudVar, zzujVar, zzksVar));
        zzudVar.zzh(new Handler(zzet.zzy(), null), zzksVar);
        zzudVar.zzg(new Handler(zzet.zzy(), null), zzksVar);
        zzudVar.zzm(zzujVar, this.zzk, this.zza);
    }

    private final void zzw(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            zzku zzkuVar = (zzku) this.zzb.remove(i2);
            this.zzd.remove(zzkuVar.zzb);
            zzr(i2, -zzkuVar.zza.zzC().zzc());
            zzkuVar.zze = true;
            if (this.zzj) {
                zzu(zzkuVar);
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcc zzb() {
        if (this.zzb.isEmpty()) {
            return zzcc.zza;
        }
        int iZzc = 0;
        for (int i = 0; i < this.zzb.size(); i++) {
            zzku zzkuVar = (zzku) this.zzb.get(i);
            zzkuVar.zzd = iZzc;
            iZzc += zzkuVar.zza.zzC().zzc();
        }
        return new zzlc(this.zzb, this.zzl);
    }

    public final zzcc zzc(int i, int i2, List list) {
        zzdi.zzd(i >= 0 && i <= i2 && i2 <= zza());
        zzdi.zzd(list.size() == i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzku) this.zzb.get(i3)).zza.zzt((zzbc) list.get(i3 - i));
        }
        return zzb();
    }

    public final /* synthetic */ void zzf(zzuk zzukVar, zzcc zzccVar) {
        this.zze.zzg();
    }

    public final void zzg(zzgu zzguVar) {
        zzdi.zzf(!this.zzj);
        this.zzk = zzguVar;
        for (int i = 0; i < this.zzb.size(); i++) {
            zzku zzkuVar = (zzku) this.zzb.get(i);
            zzv(zzkuVar);
            this.zzg.add(zzkuVar);
        }
        this.zzj = true;
    }

    public final void zzh() {
        for (zzkt zzktVar : this.zzf.values()) {
            try {
                zzktVar.zza.zzp(zzktVar.zzb);
            } catch (RuntimeException e) {
                zzea.zzd("MediaSourceList", "Failed to release child source.", e);
            }
            zzktVar.zza.zzs(zzktVar.zzc);
            zzktVar.zza.zzr(zzktVar.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzug zzugVar) {
        zzku zzkuVar = (zzku) this.zzc.remove(zzugVar);
        zzkuVar.getClass();
        zzkuVar.zza.zzG(zzugVar);
        zzkuVar.zzc.remove(((zzua) zzugVar).zza);
        if (!this.zzc.isEmpty()) {
            zzt();
        }
        zzu(zzkuVar);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzcc zzk(int i, List list, zzwa zzwaVar) {
        if (!list.isEmpty()) {
            this.zzl = zzwaVar;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzku zzkuVar = (zzku) list.get(i2 - i);
                if (i2 > 0) {
                    zzku zzkuVar2 = (zzku) this.zzb.get(i2 - 1);
                    zzkuVar.zzc(zzkuVar2.zza.zzC().zzc() + zzkuVar2.zzd);
                } else {
                    zzkuVar.zzc(0);
                }
                zzr(i2, zzkuVar.zza.zzC().zzc());
                this.zzb.add(i2, zzkuVar);
                this.zzd.put(zzkuVar.zzb, zzkuVar);
                if (this.zzj) {
                    zzv(zzkuVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzkuVar);
                    } else {
                        zzs(zzkuVar);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcc zzl(int i, int i2, int i3, zzwa zzwaVar) {
        zzdi.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzcc zzm(int i, int i2, zzwa zzwaVar) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzdi.zzd(z);
        this.zzl = zzwaVar;
        zzw(i, i2);
        return zzb();
    }

    public final zzcc zzn(List list, zzwa zzwaVar) {
        zzw(0, this.zzb.size());
        return zzk(this.zzb.size(), list, zzwaVar);
    }

    public final zzcc zzo(zzwa zzwaVar) {
        int iZza = zza();
        if (zzwaVar.zzc() != iZza) {
            zzwaVar = zzwaVar.zzf().zzg(0, iZza);
        }
        this.zzl = zzwaVar;
        return zzb();
    }

    public final zzug zzp(zzui zzuiVar, zzyk zzykVar, long j) {
        int i = zzlc.zzb;
        Object obj = zzuiVar.zza;
        Object obj2 = ((Pair) obj).first;
        zzui zzuiVarZza = zzuiVar.zza(((Pair) obj).second);
        zzku zzkuVar = (zzku) this.zzd.get(obj2);
        zzkuVar.getClass();
        this.zzg.add(zzkuVar);
        zzkt zzktVar = (zzkt) this.zzf.get(zzkuVar);
        if (zzktVar != null) {
            zzktVar.zza.zzk(zzktVar.zzb);
        }
        zzkuVar.zzc.add(zzuiVarZza);
        zzua zzuaVarZzI = zzkuVar.zza.zzI(zzuiVarZza, zzykVar, j);
        this.zzc.put(zzuaVarZzI, zzkuVar);
        zzt();
        return zzuaVarZzI;
    }

    public final zzwa zzq() {
        return this.zzl;
    }
}
