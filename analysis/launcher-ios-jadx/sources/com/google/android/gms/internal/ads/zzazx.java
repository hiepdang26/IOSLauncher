package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.b7;
import defpackage.e92;
import defpackage.k92;
import defpackage.lc2;
import defpackage.pd2;
import defpackage.rc2;
import defpackage.s32;
import defpackage.v52;
import defpackage.x32;
import defpackage.z22;

/* JADX INFO: loaded from: classes.dex */
public final class zzazx {
    private v52 zza;
    private final Context zzb;
    private final String zzc;
    private final e92 zzd;
    private final int zze;
    private final b7 zzf;
    private final zzboi zzg = new zzboi();
    private final lc2 zzh = lc2.a;

    public zzazx(Context context, String str, e92 e92Var, int i, b7 b7Var) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = e92Var;
        this.zze = i;
        this.zzf = b7Var;
    }

    public final void zza() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            rc2 rc2VarA = rc2.a();
            s32 s32Var = x32.f.b;
            Context context = this.zzb;
            String str = this.zzc;
            zzboi zzboiVar = this.zzg;
            s32Var.getClass();
            v52 v52Var = (v52) new z22(s32Var, context, rc2VarA, str, zzboiVar).d(context, false);
            this.zza = v52Var;
            if (v52Var != null) {
                int i = this.zze;
                if (i != 3) {
                    v52Var.zzI(new pd2(i));
                }
                this.zzd.k = jCurrentTimeMillis;
                this.zza.zzH(new zzazk(this.zzf, this.zzc));
                v52 v52Var2 = this.zza;
                lc2 lc2Var = this.zzh;
                Context context2 = this.zzb;
                e92 e92Var = this.zzd;
                lc2Var.getClass();
                v52Var2.zzab(lc2.a(context2, e92Var));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
