package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbyb {
    static zzbyb zza;

    public static synchronized zzbyb zzd(Context context) {
        try {
            zzbyb zzbybVar = zza;
            if (zzbybVar != null) {
                return zzbybVar;
            }
            Context applicationContext = context.getApplicationContext();
            zzbbw.zza(applicationContext);
            hd2 hd2Var = hd2.B;
            ib2 ib2Var = (ib2) hd2Var.g.zzi();
            ib2Var.D(applicationContext);
            zzbxt zzbxtVar = new zzbxt(null);
            zzbxtVar.zzb(applicationContext);
            zzbxtVar.zzc(hd2Var.j);
            zzbxtVar.zza(ib2Var);
            zzbxtVar.zzd(hd2Var.x);
            zzbyb zzbybVarZze = zzbxtVar.zze();
            zza = zzbybVarZze;
            zzbybVarZze.zza().zza();
            zzbyf zzbyfVarZzc = zza.zzc();
            zzbbn zzbbnVar = zzbbw.zzal;
            n42 n42Var = n42.d;
            if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                HashMap mapH = cd2.H((String) n42Var.c.zza(zzbbw.zzam));
                Iterator it = mapH.keySet().iterator();
                while (it.hasNext()) {
                    zzbyfVarZzc.zzc((String) it.next());
                }
                zzbyfVarZzc.zzd(new zzbyd(zzbyfVarZzc, mapH));
            }
            return zza;
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract zzbxm zza();

    public abstract zzbxq zzb();

    public abstract zzbyf zzc();
}
