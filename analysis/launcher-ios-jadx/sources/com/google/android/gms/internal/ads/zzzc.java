package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class zzzc {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzyy
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((zzzb) obj).zza - ((zzzb) obj2).zza;
        }
    };
    private static final Comparator zzb = new Comparator() { // from class: com.google.android.gms.internal.ads.zzyz
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((zzzb) obj).zzc, ((zzzb) obj2).zzc);
        }
    };
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzzb[] zzd = new zzzb[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzzc(int i) {
    }

    public final float zza(float f) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = this.zzg;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            float f3 = 0.5f * f2;
            zzzb zzzbVar = (zzzb) this.zzc.get(i2);
            i += zzzbVar.zzb;
            if (i >= f3) {
                return zzzbVar.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        return ((zzzb) this.zzc.get(r6.size() - 1)).zzc;
    }

    public final void zzb(int i, float f) {
        zzzb zzzbVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzzb[] zzzbVarArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzzbVar = zzzbVarArr[i3];
        } else {
            zzzbVar = new zzzb(null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzzbVar.zza = i4;
        zzzbVar.zzb = i;
        zzzbVar.zzc = f;
        this.zzc.add(zzzbVar);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 <= 2000) {
                return;
            }
            int i6 = i5 - 2000;
            zzzb zzzbVar2 = (zzzb) this.zzc.get(0);
            int i7 = zzzbVar2.zzb;
            if (i7 <= i6) {
                this.zzg -= i7;
                this.zzc.remove(0);
                int i8 = this.zzh;
                if (i8 < 5) {
                    zzzb[] zzzbVarArr2 = this.zzd;
                    this.zzh = i8 + 1;
                    zzzbVarArr2[i8] = zzzbVar2;
                }
            } else {
                zzzbVar2.zzb = i7 - i6;
                this.zzg -= i6;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
