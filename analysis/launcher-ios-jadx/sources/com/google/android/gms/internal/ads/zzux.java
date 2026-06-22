package com.google.android.gms.internal.ads;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzux extends zztq {
    private static final zzbc zza;
    private final zzuk[] zzb;
    private final zzcc[] zzc;
    private final ArrayList zzd;
    private int zze = -1;
    private long[][] zzf = new long[0][];
    private zzuw zzg;
    private final zztt zzh;

    static {
        zzam zzamVar = new zzam();
        zzamVar.zza("MergingMediaSource");
        zza = zzamVar.zzc();
    }

    public zzux(boolean z, boolean z2, zztt zzttVar, zzuk... zzukVarArr) {
        this.zzb = zzukVarArr;
        this.zzh = zzttVar;
        this.zzd = new ArrayList(Arrays.asList(zzukVarArr));
        this.zzc = new zzcc[zzukVarArr.length];
        new HashMap();
        zzfyx.zzb(8).zzb(2).zza();
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final /* bridge */ /* synthetic */ void zzA(Object obj, zzuk zzukVar, zzcc zzccVar) {
        int iZzb;
        if (this.zzg != null) {
            return;
        }
        if (this.zze == -1) {
            iZzb = zzccVar.zzb();
            this.zze = iZzb;
        } else {
            int iZzb2 = zzccVar.zzb();
            int i = this.zze;
            if (iZzb2 != i) {
                this.zzg = new zzuw(0);
                return;
            }
            iZzb = i;
        }
        if (this.zzf.length == 0) {
            this.zzf = (long[][]) Array.newInstance((Class<?>) Long.TYPE, iZzb, this.zzc.length);
        }
        this.zzd.remove(zzukVar);
        this.zzc[((Integer) obj).intValue()] = zzccVar;
        if (this.zzd.isEmpty()) {
            zzo(this.zzc[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzG(zzug zzugVar) {
        zzuv zzuvVar = (zzuv) zzugVar;
        int i = 0;
        while (true) {
            zzuk[] zzukVarArr = this.zzb;
            if (i >= zzukVarArr.length) {
                return;
            }
            zzukVarArr[i].zzG(zzuvVar.zzn(i));
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final zzug zzI(zzui zzuiVar, zzyk zzykVar, long j) {
        zzcc[] zzccVarArr = this.zzc;
        int length = this.zzb.length;
        zzug[] zzugVarArr = new zzug[length];
        int iZza = zzccVarArr[0].zza(zzuiVar.zza);
        for (int i = 0; i < length; i++) {
            zzugVarArr[i] = this.zzb[i].zzI(zzuiVar.zza(this.zzc[i].zzf(iZza)), zzykVar, j - this.zzf[iZza][i]);
        }
        return new zzuv(this.zzh, this.zzf[iZza], zzugVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final zzbc zzJ() {
        zzuk[] zzukVarArr = this.zzb;
        return zzukVarArr.length > 0 ? zzukVarArr[0].zzJ() : zza;
    }

    @Override // com.google.android.gms.internal.ads.zztq, com.google.android.gms.internal.ads.zzth
    public final void zzn(zzgu zzguVar) {
        super.zzn(zzguVar);
        int i = 0;
        while (true) {
            zzuk[] zzukVarArr = this.zzb;
            if (i >= zzukVarArr.length) {
                return;
            }
            zzB(Integer.valueOf(i), zzukVarArr[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztq, com.google.android.gms.internal.ads.zzth
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zze = -1;
        this.zzg = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzth, com.google.android.gms.internal.ads.zzuk
    public final void zzt(zzbc zzbcVar) {
        this.zzb[0].zzt(zzbcVar);
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final /* bridge */ /* synthetic */ zzui zzy(Object obj, zzui zzuiVar) {
        if (((Integer) obj).intValue() == 0) {
            return zzuiVar;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zztq, com.google.android.gms.internal.ads.zzuk
    public final void zzz() throws zzuw {
        zzuw zzuwVar = this.zzg;
        if (zzuwVar != null) {
            throw zzuwVar;
        }
        super.zzz();
    }
}
