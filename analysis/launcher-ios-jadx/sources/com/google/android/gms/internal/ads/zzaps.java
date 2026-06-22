package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzaps {
    public static final boolean zza = zzapt.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    public final void finalize() {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzapt.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzapr(str, j, SystemClock.elapsedRealtime()));
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    public final synchronized void zzb(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            monitor-enter(r10)
            r10.zzc = r2     // Catch: java.lang.Throwable -> L7d
            java.util.List r3 = r10.zzb     // Catch: java.lang.Throwable -> L7d
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L7d
            r4 = 0
            if (r3 != 0) goto L12
            r8 = r4
            goto L2d
        L12:
            java.util.List r3 = r10.zzb     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L7d
            com.google.android.gms.internal.ads.zzapr r3 = (com.google.android.gms.internal.ads.zzapr) r3     // Catch: java.lang.Throwable -> L7d
            long r6 = r3.zzc     // Catch: java.lang.Throwable -> L7d
            java.util.List r3 = r10.zzb     // Catch: java.lang.Throwable -> L7d
            int r8 = r3.size()     // Catch: java.lang.Throwable -> L7d
            int r8 = r8 + (-1)
            java.lang.Object r3 = r3.get(r8)     // Catch: java.lang.Throwable -> L7d
            com.google.android.gms.internal.ads.zzapr r3 = (com.google.android.gms.internal.ads.zzapr) r3     // Catch: java.lang.Throwable -> L7d
            long r8 = r3.zzc     // Catch: java.lang.Throwable -> L7d
            long r8 = r8 - r6
        L2d:
            int r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r3 > 0) goto L32
            goto L7f
        L32:
            java.util.List r3 = r10.zzb     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L7d
            com.google.android.gms.internal.ads.zzapr r3 = (com.google.android.gms.internal.ads.zzapr) r3     // Catch: java.lang.Throwable -> L7d
            long r3 = r3.zzc     // Catch: java.lang.Throwable -> L7d
            java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L7d
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L7d
            r6[r1] = r5     // Catch: java.lang.Throwable -> L7d
            r6[r2] = r11     // Catch: java.lang.Throwable -> L7d
            java.lang.String r11 = "(%-4d ms) %s"
            com.google.android.gms.internal.ads.zzapt.zza(r11, r6)     // Catch: java.lang.Throwable -> L7d
            java.util.List r11 = r10.zzb     // Catch: java.lang.Throwable -> L7d
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> L7d
        L51:
            boolean r5 = r11.hasNext()     // Catch: java.lang.Throwable -> L7d
            if (r5 == 0) goto L7f
            java.lang.Object r5 = r11.next()     // Catch: java.lang.Throwable -> L7d
            com.google.android.gms.internal.ads.zzapr r5 = (com.google.android.gms.internal.ads.zzapr) r5     // Catch: java.lang.Throwable -> L7d
            long r6 = r5.zzc     // Catch: java.lang.Throwable -> L7d
            long r3 = r6 - r3
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L7d
            long r8 = r5.zzb     // Catch: java.lang.Throwable -> L7d
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r5 = r5.zza     // Catch: java.lang.Throwable -> L7d
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L7d
            r8[r1] = r3     // Catch: java.lang.Throwable -> L7d
            r8[r2] = r4     // Catch: java.lang.Throwable -> L7d
            r8[r0] = r5     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = "(+%-4d) [%2d] %s"
            com.google.android.gms.internal.ads.zzapt.zza(r3, r8)     // Catch: java.lang.Throwable -> L7d
            r3 = r6
            goto L51
        L7d:
            r11 = move-exception
            goto L81
        L7f:
            monitor-exit(r10)
            return
        L81:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7d
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaps.zzb(java.lang.String):void");
    }
}
