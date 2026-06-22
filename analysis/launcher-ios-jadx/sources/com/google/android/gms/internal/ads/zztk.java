package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zztk implements zzuy {
    private final zzacp zza;
    private zzack zzb;
    private zzacl zzc;

    public zztk(zzacp zzacpVar) {
        this.zza = zzacpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final int zza(zzadf zzadfVar) {
        zzack zzackVar = this.zzb;
        zzackVar.getClass();
        zzacl zzaclVar = this.zzc;
        zzaclVar.getClass();
        return zzackVar.zzb(zzaclVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final long zzb() {
        zzacl zzaclVar = this.zzc;
        if (zzaclVar != null) {
            return zzaclVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final void zzc() {
        zzack zzackVar = this.zzb;
        if (zzackVar == null) {
            return;
        }
        zzack zzackVarZzc = zzackVar.zzc();
        if (zzackVarZzc instanceof zzahp) {
            ((zzahp) zzackVarZzc).zza();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    @Override // com.google.android.gms.internal.ads.zzuy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(com.google.android.gms.internal.ads.zzp r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzacn r15) throws com.google.android.gms.internal.ads.zzwj {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzaby r1 = new com.google.android.gms.internal.ads.zzaby
            r2 = r8
            r3 = r11
            r5 = r13
            r1.<init>(r2, r3, r5)
            r7.zzc = r1
            com.google.android.gms.internal.ads.zzack r8 = r7.zzb
            if (r8 == 0) goto Lf
            return
        Lf:
            com.google.android.gms.internal.ads.zzacp r8 = r7.zza
            com.google.android.gms.internal.ads.zzack[] r8 = r8.zza(r9, r10)
            int r10 = r8.length
            com.google.android.gms.internal.ads.zzfxo r11 = com.google.android.gms.internal.ads.zzfxr.zzi(r10)
            r12 = 1
            r13 = 0
            if (r10 != r12) goto L23
            r8 = r8[r13]
            r7.zzb = r8
            goto L82
        L23:
            r14 = 0
        L24:
            if (r14 >= r10) goto L7e
            r0 = r8[r14]
            boolean r2 = r0.zzj(r1)     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L3a
            if (r2 == 0) goto L3c
            r7.zzb = r0     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L3a
            com.google.android.gms.internal.ads.zzdi.zzf(r12)
            r1.zzj()
            goto L7e
        L37:
            r0 = move-exception
            r8 = r0
            goto L59
        L3a:
            goto L6e
        L3c:
            java.util.List r0 = r0.zzd()     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L3a
            r11.zzh(r0)     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L3a
            com.google.android.gms.internal.ads.zzack r0 = r7.zzb
            if (r0 != 0) goto L4f
            long r5 = r1.zzf()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L51
        L4f:
            r0 = 1
            goto L52
        L51:
            r0 = 0
        L52:
            com.google.android.gms.internal.ads.zzdi.zzf(r0)
            r1.zzj()
            goto L7b
        L59:
            com.google.android.gms.internal.ads.zzack r9 = r7.zzb
            if (r9 != 0) goto L67
            long r9 = r1.zzf()
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 != 0) goto L66
            goto L67
        L66:
            r12 = 0
        L67:
            com.google.android.gms.internal.ads.zzdi.zzf(r12)
            r1.zzj()
            throw r8
        L6e:
            com.google.android.gms.internal.ads.zzack r0 = r7.zzb
            if (r0 != 0) goto L4f
            long r5 = r1.zzf()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L51
            goto L4f
        L7b:
            int r14 = r14 + 1
            goto L24
        L7e:
            com.google.android.gms.internal.ads.zzack r10 = r7.zzb
            if (r10 == 0) goto L88
        L82:
            com.google.android.gms.internal.ads.zzack r8 = r7.zzb
            r8.zze(r15)
            return
        L88:
            com.google.android.gms.internal.ads.zzwj r10 = new com.google.android.gms.internal.ads.zzwj
            com.google.android.gms.internal.ads.zzfxr r8 = com.google.android.gms.internal.ads.zzfxr.zzl(r8)
            com.google.android.gms.internal.ads.zztj r12 = new com.google.android.gms.internal.ads.zztj
            r12.<init>()
            java.util.List r8 = com.google.android.gms.internal.ads.zzfyh.zzb(r8, r12)
            java.util.Iterator r8 = r8.iterator()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = ", "
            com.google.android.gms.internal.ads.zzfum.zzc(r12, r8, r13)
            java.lang.String r8 = r12.toString()
            java.lang.String r12 = "None of the available extractors ("
            java.lang.String r13 = ") could read the stream."
            java.lang.String r8 = defpackage.uo.t(r12, r8, r13)
            com.google.android.gms.internal.ads.zzfxr r11 = r11.zzi()
            r10.<init>(r8, r9, r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztk.zzd(com.google.android.gms.internal.ads.zzp, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzacn):void");
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final void zze() {
        zzack zzackVar = this.zzb;
        if (zzackVar != null) {
            zzackVar.zzf();
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final void zzf(long j, long j2) {
        zzack zzackVar = this.zzb;
        zzackVar.getClass();
        zzackVar.zzi(j, j2);
    }
}
