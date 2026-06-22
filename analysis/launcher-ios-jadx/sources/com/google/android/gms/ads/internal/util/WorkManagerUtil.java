package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import defpackage.bg;
import defpackage.c22;
import defpackage.cz1;
import defpackage.gy0;
import defpackage.he0;
import defpackage.jl1;
import defpackage.k92;
import defpackage.lz1;
import defpackage.nn;
import defpackage.qm0;
import defpackage.r52;
import defpackage.rl;
import defpackage.wb2;
import defpackage.wj;
import defpackage.wr;
import defpackage.xz;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class WorkManagerUtil extends zzaxn implements r52 {
    public WorkManagerUtil() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    public static void f(Context context) {
        try {
            cz1.P(context.getApplicationContext(), new rl(new jl1(12)));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            he0 he0VarQ = gy0.q(parcel.readStrongBinder());
            String string = parcel.readString();
            String string2 = parcel.readString();
            zzaxo.zzc(parcel);
            boolean zZzf = zzf(he0VarQ, string, string2);
            parcel2.writeNoException();
            parcel2.writeInt(zZzf ? 1 : 0);
        } else if (i == 2) {
            he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zze(he0VarQ2);
            parcel2.writeNoException();
        } else {
            if (i != 3) {
                return false;
            }
            he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
            c22 c22Var = (c22) zzaxo.zza(parcel, c22.CREATOR);
            zzaxo.zzc(parcel);
            boolean zZzg = zzg(he0VarQ3, c22Var);
            parcel2.writeNoException();
            parcel2.writeInt(zZzg ? 1 : 0);
        }
        return true;
    }

    @Override // defpackage.r52
    public final void zze(he0 he0Var) {
        Context context = (Context) gy0.r(he0Var);
        f(context);
        try {
            cz1 cz1VarO = cz1.O(context);
            ((qm0) cz1VarO.k).e(new bg(cz1VarO, 0));
            nn nnVar = new nn(2, false, false, false, false, -1L, -1L, Build.VERSION.SDK_INT >= 24 ? wj.B(new LinkedHashSet()) : xz.g);
            wb2 wb2Var = new wb2(OfflinePingSender.class);
            ((lz1) wb2Var.i).j = nnVar;
            ((LinkedHashSet) wb2Var.j).add("offline_ping_sender_work");
            cz1VarO.o(wb2Var.k());
        } catch (IllegalStateException unused) {
            k92.j(5);
        }
    }

    @Override // defpackage.r52
    public final boolean zzf(he0 he0Var, String str, String str2) {
        return zzg(he0Var, new c22(str, str2, ""));
    }

    @Override // defpackage.r52
    public final boolean zzg(he0 he0Var, c22 c22Var) throws Throwable {
        Context context = (Context) gy0.r(he0Var);
        f(context);
        nn nnVar = new nn(2, false, false, false, false, -1L, -1L, Build.VERSION.SDK_INT >= 24 ? wj.B(new LinkedHashSet()) : xz.g);
        HashMap map = new HashMap();
        map.put("uri", c22Var.g);
        map.put("gws_query_id", c22Var.h);
        map.put("image_url", c22Var.i);
        wr wrVar = new wr(map);
        wr.c(wrVar);
        wb2 wb2Var = new wb2(OfflineNotificationPoster.class);
        lz1 lz1Var = (lz1) wb2Var.i;
        lz1Var.j = nnVar;
        lz1Var.e = wrVar;
        ((LinkedHashSet) wb2Var.j).add("offline_notification_work");
        try {
            cz1.O(context).o(wb2Var.k());
            return true;
        } catch (IllegalStateException unused) {
            k92.j(5);
            return false;
        }
    }
}
