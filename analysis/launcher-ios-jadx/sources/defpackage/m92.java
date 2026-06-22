package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzgcu;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class m92 {
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;
    public final zzdsp d;
    public final zzgcu e;

    public m92(Context context, zzdsp zzdspVar, zzgcu zzgcuVar) {
        this.c = context;
        this.d = zzdspVar;
        this.e = zzgcuVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x0027, B:12:0x002b, B:15:0x0034, B:17:0x0038, B:21:0x0053, B:25:0x005d, B:28:0x007f, B:29:0x0083, B:31:0x0089, B:20:0x0047, B:14:0x002f), top: B:37:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a(final boolean r10, defpackage.ab2 r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.HashMap r0 = r9.a     // Catch: java.lang.Throwable -> L45
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> L45
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L45
            ab2 r0 = (defpackage.ab2) r0     // Catch: java.lang.Throwable -> L45
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L2f
            hd2 r4 = defpackage.hd2.B     // Catch: java.lang.Throwable -> L45
            us r4 = r4.j     // Catch: java.lang.Throwable -> L45
            r4.getClass()     // Catch: java.lang.Throwable -> L45
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L45
            long r6 = r0.c     // Catch: java.lang.Throwable -> L45
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 > 0) goto L24
            r4 = 1
            goto L25
        L24:
            r4 = 0
        L25:
            if (r4 != 0) goto L2f
            e41 r0 = r0.a     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L2f
            e41 r0 = r11.a     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L34
        L2f:
            java.util.HashMap r0 = r9.a     // Catch: java.lang.Throwable -> L45
            r0.put(r1, r11)     // Catch: java.lang.Throwable -> L45
        L34:
            e41 r0 = r11.a     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L47
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zziY     // Catch: java.lang.Throwable -> L45
            n42 r4 = defpackage.n42.d     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.internal.ads.zzbbu r4 = r4.c     // Catch: java.lang.Throwable -> L45
            java.lang.Object r0 = r4.zza(r0)     // Catch: java.lang.Throwable -> L45
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L45
            goto L53
        L45:
            r10 = move-exception
            goto L95
        L47:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zziZ     // Catch: java.lang.Throwable -> L45
            n42 r4 = defpackage.n42.d     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.internal.ads.zzbbu r4 = r4.c     // Catch: java.lang.Throwable -> L45
            java.lang.Object r0 = r4.zza(r0)     // Catch: java.lang.Throwable -> L45
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L45
        L53:
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L45
            e41 r4 = r11.a     // Catch: java.lang.Throwable -> L45
            if (r4 != 0) goto L5c
            goto L5d
        L5c:
            r3 = 0
        L5d:
            java.util.concurrent.ScheduledExecutorService r4 = com.google.android.gms.internal.ads.zzbzo.zzd     // Catch: java.lang.Throwable -> L45
            a42 r5 = new a42     // Catch: java.lang.Throwable -> L45
            r5.<init>()     // Catch: java.lang.Throwable -> L45
            long r6 = (long) r0     // Catch: java.lang.Throwable -> L45
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L45
            r4.schedule(r5, r6, r10)     // Catch: java.lang.Throwable -> L45
            java.util.HashMap r10 = r9.b     // Catch: java.lang.Throwable -> L45
            java.lang.Object r10 = r10.get(r1)     // Catch: java.lang.Throwable -> L45
            java.util.List r10 = (java.util.List) r10     // Catch: java.lang.Throwable -> L45
            java.util.HashMap r0 = r9.b     // Catch: java.lang.Throwable -> L45
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L45
            r3.<init>()     // Catch: java.lang.Throwable -> L45
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L45
            if (r10 != 0) goto L7f
            goto L93
        L7f:
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> L45
        L83:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L93
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Throwable -> L45
            android.util.Pair r0 = (android.util.Pair) r0     // Catch: java.lang.Throwable -> L45
            r9.d(r11, r0, r2)     // Catch: java.lang.Throwable -> L45
            goto L83
        L93:
            monitor-exit(r9)
            return
        L95:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L45
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m92.a(boolean, ab2):void");
    }

    public final synchronized void b(Object obj, f41 f41Var) {
        hd2.B.j.getClass();
        zzbzo.zze.execute(new xm(this, obj, new Pair(f41Var, Long.valueOf(System.currentTimeMillis())), 12));
    }

    public final void c(boolean z) {
        HashMap map = this.b;
        Boolean boolValueOf = Boolean.valueOf(z);
        if (map.containsKey(boolValueOf)) {
            return;
        }
        map.put(boolValueOf, new ArrayList());
        this.e.submit(new eh1(this, z, 2));
    }

    public final void d(ab2 ab2Var, Pair pair, boolean z) {
        ab2Var.e.set(true);
        e41 e41Var = ab2Var.a;
        if (e41Var != null) {
            ((f41) pair.first).onSuccess(e41Var);
        } else {
            ((f41) pair.first).onFailure(ab2Var.b);
        }
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair("ad_format", "BANNER");
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", "true");
        hd2.B.j.getClass();
        wd.P(this.d, "sgpcr", pair2, pair3, pair4, pair5, new Pair("lat_ms", Long.toString(System.currentTimeMillis() - ((Long) pair.second).longValue())), new Pair("sgpc_h", Boolean.toString(z)), new Pair("sgpc_rs", Boolean.toString(e41Var != null)));
    }

    public final synchronized void e(boolean z, boolean z2) {
        Throwable th;
        int i;
        try {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("query_info_type", "requester_type_6");
                bundle.putBoolean("accept_3p_cookie", z);
                HashMap map = this.a;
                Boolean boolValueOf = Boolean.valueOf(z);
                ab2 ab2Var = (ab2) map.get(boolValueOf);
                if (!z2 || ab2Var == null) {
                    i = 0;
                } else {
                    try {
                        i = ab2Var.d + 1;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                ab2 ab2Var2 = (ab2) this.a.get(boolValueOf);
                la2 la2Var = new la2(this, z, i, ab2Var2 == null ? null : Boolean.valueOf(ab2Var2.e.get()), this.d);
                nx0 nx0Var = new nx0(2);
                nx0Var.q(bundle);
                s2 s2Var = new s2(nx0Var);
                if (((Boolean) n42.d.c.zza(zzbbw.zzkg)).booleanValue()) {
                    this.e.submit(new f22(this, s2Var, la2Var, 2));
                } else {
                    e41.a(this.c, s2Var, la2Var);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
