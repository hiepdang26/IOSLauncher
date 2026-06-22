package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.tb2;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzfjt {
    public static zzfju zza(Context context, int i) {
        boolean zBooleanValue;
        if (zzfki.zza()) {
            int i2 = i - 2;
            if (i2 != 20 && i2 != 21) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbdl.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbdl.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbdl.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) zzbdl.zze.zze()).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfjw(context, i);
            }
        }
        return new zzfky();
    }

    public static zzfju zzb(Context context, int i, int i2, tb2 tb2Var) {
        zzfju zzfjuVarZza = zza(context, i);
        if (zzfjuVarZza instanceof zzfjw) {
            zzfjuVarZza.zzi();
            zzfjuVarZza.zzn(i2);
            zzfjuVarZza.zzf(wd.L(tb2Var.s));
            String str = tb2Var.v;
            if (zzfke.zze(str)) {
                zzfjuVarZza.zze(str);
            }
        }
        return zzfjuVarZza;
    }
}
