package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import defpackage.do0;
import defpackage.ib2;
import defpackage.rc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzeof implements zzevo {
    private final zzevo zza;
    private final zzffg zzb;
    private final Context zzc;
    private final zzbze zzd;

    public zzeof(zzeqg zzeqgVar, zzffg zzffgVar, Context context, zzbze zzbzeVar) {
        this.zza = zzeqgVar;
        this.zzb = zzffgVar;
        this.zzc = context;
        this.zzd = zzbzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 7;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return zzgcj.zzm(this.zza.zzb(), new zzful() { // from class: com.google.android.gms.internal.ads.zzeoe
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zzc((zzevx) obj);
            }
        }, zzbzo.zzf);
    }

    public final /* synthetic */ zzeog zzc(zzevx zzevxVar) {
        String str;
        boolean z;
        String strA;
        float f;
        int i;
        int i2;
        DisplayMetrics displayMetrics;
        rc2 rc2Var = this.zzb.zze;
        rc2[] rc2VarArr = rc2Var.m;
        if (rc2VarArr == null) {
            str = rc2Var.g;
            z = rc2Var.o;
        } else {
            String str2 = null;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (rc2 rc2Var2 : rc2VarArr) {
                boolean z5 = rc2Var2.o;
                if (!z5 && !z3) {
                    str2 = rc2Var2.g;
                    z3 = true;
                }
                if (z5) {
                    if (!z4) {
                        z2 = true;
                    }
                    z4 = true;
                }
                if (z3 && z4) {
                    break;
                }
            }
            str = str2;
            z = z2;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            strA = null;
            f = 0.0f;
            i = 0;
            i2 = 0;
        } else {
            zzbze zzbzeVar = this.zzd;
            float f2 = displayMetrics.density;
            int i3 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
            f = f2;
            i = i3;
            strA = ((ib2) zzbzeVar.zzi()).A();
        }
        StringBuilder sb = new StringBuilder();
        rc2[] rc2VarArr2 = rc2Var.m;
        if (rc2VarArr2 != null) {
            boolean z6 = false;
            for (rc2 rc2Var3 : rc2VarArr2) {
                if (rc2Var3.o) {
                    z6 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i4 = -1;
                    int i5 = rc2Var3.k;
                    if (i5 != -1) {
                        i4 = i5;
                    } else if (f != 0.0f) {
                        i4 = (int) (rc2Var3.l / f);
                    }
                    sb.append(i4);
                    sb.append("x");
                    int i6 = -2;
                    int i7 = rc2Var3.h;
                    if (i7 != -2) {
                        i6 = i7;
                    } else if (f != 0.0f) {
                        i6 = (int) (rc2Var3.i / f);
                    }
                    sb.append(i6);
                }
            }
            if (z6) {
                if (sb.length() != 0) {
                    sb.insert(0, "|");
                }
                sb.insert(0, "320x50");
            }
        }
        return new zzeog(rc2Var, str, z, sb.toString(), f, i, i2, strA, this.zzb.zzq);
    }
}
