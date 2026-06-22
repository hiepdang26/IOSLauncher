package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.rc2;
import defpackage.u2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzffm {
    public static rc2 zza(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfem zzfemVar = (zzfem) it.next();
            if (zzfemVar.zzc) {
                arrayList.add(u2.i);
            } else {
                arrayList.add(new u2(zzfemVar.zza, zzfemVar.zzb));
            }
        }
        return new rc2(context, (u2[]) arrayList.toArray(new u2[arrayList.size()]));
    }

    public static zzfem zzb(rc2 rc2Var) {
        return rc2Var.o ? new zzfem(-3, 0, true) : new zzfem(rc2Var.k, rc2Var.h, false);
    }
}
