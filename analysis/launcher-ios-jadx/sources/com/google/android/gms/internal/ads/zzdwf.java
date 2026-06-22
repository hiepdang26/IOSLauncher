package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import defpackage.c7;
import defpackage.cc1;
import defpackage.cd2;
import defpackage.dc1;
import defpackage.fc1;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.he0;
import defpackage.kz0;
import defpackage.n42;
import defpackage.nx0;
import defpackage.og0;
import defpackage.p82;
import defpackage.rv0;
import defpackage.s2;
import defpackage.u82;
import defpackage.v2;
import defpackage.wb1;
import defpackage.xo0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwf extends p82 {
    final Map zza;
    private final Context zzb;
    private final WeakReference zzc;
    private final zzdvt zzd;
    private final zzgcu zze;
    private zzdvi zzf;

    public zzdwf(Context context, WeakReference weakReference, zzdvt zzdvtVar, zzdwg zzdwgVar, zzgcu zzgcuVar) {
        super("com.google.android.gms.ads.internal.client.IOutOfContextTester");
        this.zza = new HashMap();
        this.zzb = context;
        this.zzc = weakReference;
        this.zzd = zzdvtVar;
        this.zze = zzgcuVar;
    }

    private final Context zzj() {
        Context context = (Context) this.zzc.get();
        return context == null ? this.zzb : context;
    }

    private static s2 zzk() {
        Bundle bundle = new Bundle();
        bundle.putString("request_origin", "inspector_ooct");
        nx0 nx0Var = new nx0(2);
        nx0Var.q(bundle);
        return new s2(nx0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzl(Object obj) {
        wb1 responseInfo;
        u82 u82Var;
        if (obj instanceof xo0) {
            responseInfo = ((xo0) obj).e;
        } else if (obj instanceof c7) {
            responseInfo = ((c7) obj).getResponseInfo();
        } else if (obj instanceof og0) {
            responseInfo = ((og0) obj).getResponseInfo();
        } else if (obj instanceof dc1) {
            responseInfo = ((dc1) obj).getResponseInfo();
        } else if (obj instanceof fc1) {
            responseInfo = ((fc1) obj).getResponseInfo();
        } else if (obj instanceof v2) {
            responseInfo = ((v2) obj).getResponseInfo();
        } else {
            if (!(obj instanceof rv0)) {
                return "";
            }
            responseInfo = ((rv0) obj).getResponseInfo();
        }
        if (responseInfo == null || (u82Var = responseInfo.a) == null) {
            return "";
        }
        try {
            return u82Var.zzh();
        } catch (RemoteException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzm(String str, String str2) {
        try {
            zzgcj.zzr(this.zzf.zzb(str), new zzdwd(this, str2), this.zze);
        } catch (NullPointerException e) {
            hd2.B.g.zzw(e, "OutOfContextTester.setAdAsOutOfContext");
            this.zzd.zzk(str2);
        }
    }

    private final synchronized void zzn(String str, String str2) {
        try {
            zzgcj.zzr(this.zzf.zzb(str), new zzdwe(this, str2), this.zze);
        } catch (NullPointerException e) {
            hd2.B.g.zzw(e, "OutOfContextTester.setAdAsShown");
            this.zzd.zzk(str2);
        }
    }

    @Override // defpackage.q82
    public final void zze(String str, he0 he0Var, he0 he0Var2) {
        Context context = (Context) gy0.r(he0Var);
        ViewGroup viewGroup = (ViewGroup) gy0.r(he0Var2);
        if (context == null || viewGroup == null) {
            return;
        }
        Object obj = this.zza.get(str);
        if (obj != null) {
            this.zza.remove(str);
        }
        if (obj instanceof v2) {
            zzdwg.zza(context, viewGroup, (v2) obj);
        } else if (obj instanceof rv0) {
            zzdwg.zzb(context, viewGroup, (rv0) obj);
        }
    }

    public final void zzf(zzdvi zzdviVar) {
        this.zzf = zzdviVar;
    }

    public final synchronized void zzg(String str, Object obj, String str2) {
        this.zza.put(str, obj);
        zzm(zzl(obj), str2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzh(final java.lang.String r8, java.lang.String r9, final java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwf.zzh(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final synchronized void zzi(String str, String str2) {
        Object obj;
        try {
            Activity activityZzg = this.zzd.zzg();
            if (activityZzg != null && (obj = this.zza.get(str)) != null) {
                zzbbn zzbbnVar = zzbbw.zziz;
                n42 n42Var = n42.d;
                if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() || (obj instanceof c7) || (obj instanceof og0) || (obj instanceof dc1) || (obj instanceof fc1)) {
                    this.zza.remove(str);
                }
                zzn(zzl(obj), str2);
                if (obj instanceof c7) {
                    ((c7) obj).show(activityZzg);
                    return;
                }
                if (obj instanceof og0) {
                    ((og0) obj).show(activityZzg);
                    return;
                }
                if (obj instanceof dc1) {
                    ((dc1) obj).show(activityZzg, new kz0() { // from class: com.google.android.gms.internal.ads.zzdvv
                        @Override // defpackage.kz0
                        public final void onUserEarnedReward(cc1 cc1Var) {
                        }
                    });
                    return;
                }
                if (obj instanceof fc1) {
                    ((fc1) obj).show(activityZzg, new kz0() { // from class: com.google.android.gms.internal.ads.zzdvw
                        @Override // defpackage.kz0
                        public final void onUserEarnedReward(cc1 cc1Var) {
                        }
                    });
                    return;
                }
                if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && ((obj instanceof v2) || (obj instanceof rv0))) {
                    Intent intent = new Intent();
                    Context contextZzj = zzj();
                    intent.setClassName(contextZzj, "com.google.android.gms.ads.OutOfContextTestingActivity");
                    intent.putExtra("adUnit", str);
                    cd2 cd2Var = hd2.B.c;
                    cd2.p(contextZzj, intent);
                }
            }
        } finally {
        }
    }
}
