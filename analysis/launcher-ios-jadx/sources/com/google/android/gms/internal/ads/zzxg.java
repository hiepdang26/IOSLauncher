package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzxg extends zzch {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private final SparseArray zzh;
    private final SparseBooleanArray zzi;

    @Deprecated
    public zzxg() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    private final void zzx() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    public final zzxg zzp(int i, boolean z) {
        if (this.zzi.get(i) == z) {
            return this;
        }
        if (z) {
            this.zzi.put(i, true);
            return this;
        }
        this.zzi.delete(i);
        return this;
    }

    public zzxg(Context context) {
        zze(context);
        Point pointZzv = zzet.zzv(context);
        zzf(pointZzv.x, pointZzv.y, true);
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    public /* synthetic */ zzxg(zzxi zzxiVar, zzxf zzxfVar) {
        super(zzxiVar);
        this.zza = zzxiVar.zzC;
        this.zzb = zzxiVar.zzE;
        this.zzc = zzxiVar.zzG;
        this.zzd = zzxiVar.zzL;
        this.zze = zzxiVar.zzM;
        this.zzf = zzxiVar.zzN;
        this.zzg = zzxiVar.zzP;
        SparseArray sparseArray = zzxiVar.zzR;
        SparseArray sparseArray2 = new SparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
        }
        this.zzh = sparseArray2;
        this.zzi = zzxiVar.zzS.clone();
    }
}
