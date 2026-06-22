package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzlc extends zzhe {
    public static final /* synthetic */ int zzb = 0;
    private final int zzc;
    private final int zzd;
    private final int[] zze;
    private final int[] zzf;
    private final zzcc[] zzg;
    private final Object[] zzh;
    private final HashMap zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzlc(Collection collection, zzwa zzwaVar) {
        zzcc[] zzccVarArr = new zzcc[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            zzccVarArr[i2] = ((zzkl) it.next()).zza();
            i2++;
        }
        Object[] objArr = new Object[collection.size()];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            objArr[i] = ((zzkl) it2.next()).zzb();
            i++;
        }
        this(zzccVarArr, objArr, zzwaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final int zzp(Object obj) {
        Integer num = (Integer) this.zzi.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final int zzq(int i) {
        return zzet.zzb(this.zze, i + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final int zzr(int i) {
        return zzet.zzb(this.zzf, i + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final int zzs(int i) {
        return this.zze[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final int zzt(int i) {
        return this.zzf[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final zzcc zzu(int i) {
        return this.zzg[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final Object zzv(int i) {
        return this.zzh[i];
    }

    public final List zzw() {
        return Arrays.asList(this.zzg);
    }

    public final zzlc zzx(zzwa zzwaVar) {
        zzcc[] zzccVarArr = new zzcc[this.zzg.length];
        int i = 0;
        while (true) {
            zzcc[] zzccVarArr2 = this.zzg;
            if (i >= zzccVarArr2.length) {
                return new zzlc(zzccVarArr, this.zzh, zzwaVar);
            }
            zzccVarArr[i] = new zzlb(this, zzccVarArr2[i]);
            i++;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzlc(zzcc[] zzccVarArr, Object[] objArr, zzwa zzwaVar) {
        super(false, zzwaVar);
        int i = 0;
        this.zzg = zzccVarArr;
        int length = zzccVarArr.length;
        this.zze = new int[length];
        this.zzf = new int[length];
        this.zzh = objArr;
        this.zzi = new HashMap();
        int iZzc = 0;
        int iZzb = 0;
        int i2 = 0;
        while (i < zzccVarArr.length) {
            zzcc zzccVar = zzccVarArr[i];
            this.zzg[i2] = zzccVar;
            this.zzf[i2] = iZzc;
            this.zze[i2] = iZzb;
            iZzc += zzccVar.zzc();
            iZzb += this.zzg[i2].zzb();
            this.zzi.put(objArr[i2], Integer.valueOf(i2));
            i++;
            i2++;
        }
        this.zzc = iZzc;
        this.zzd = iZzb;
    }
}
