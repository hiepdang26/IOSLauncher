package com.google.android.gms.internal.ads;

import android.net.Uri;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcde extends zzccv implements zzcba {
    public static final /* synthetic */ int zzd = 0;
    private zzcbb zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzccn zzi;
    private long zzj;
    private long zzk;

    public zzcde(zzcbk zzcbkVar, zzcbj zzcbjVar) {
        super(zzcbkVar);
        zzcdw zzcdwVar = new zzcdw(zzcbkVar.getContext(), zzcbjVar, (zzcbk) this.zzc.get(), null);
        k92.g("ExoPlayerAdapter initialized.");
        this.zze = zzcdwVar;
        zzcdwVar.zzL(this);
    }

    public static final String zzc(String str) {
        return "cache:".concat(String.valueOf(ka2.a(str, "MD5")));
    }

    private static String zzd(String str, Exception exc) {
        return str + "/" + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzx(long j) {
        cd2.l.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb();
            }
        }, j);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void release() {
        zzcbb zzcbbVar = this.zze;
        if (zzcbbVar != null) {
            zzcbbVar.zzL(null);
            this.zze.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzD(int i, int i2) {
    }

    public final zzcbb zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcbb zzcbbVar = this.zze;
        this.zze = null;
        return zzcbbVar;
    }

    public final void zzb() {
        n42 n42Var;
        long jLongValue;
        long jIntValue;
        boolean zBooleanValue;
        n42 n42Var2;
        long j;
        long j2;
        long j3;
        String strZzc = zzc(this.zzf);
        try {
            zzbbn zzbbnVar = zzbbw.zzr;
            n42Var = n42.d;
            jLongValue = ((Long) n42Var.c.zza(zzbbnVar)).longValue() * 1000;
            jIntValue = ((Integer) n42Var.c.zza(zzbbw.zzq)).intValue();
            zBooleanValue = ((Boolean) n42Var.c.zza(zzbbw.zzbG)).booleanValue();
        } catch (Exception e) {
            k92.h("Failed to preload url " + this.zzf + " Exception: " + e.getMessage());
            hd2.B.g.zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(this.zzf, strZzc, "error", zzd("error", e));
        }
        synchronized (this) {
            try {
                hd2.B.j.getClass();
                if (System.currentTimeMillis() - this.zzj > jLongValue) {
                    throw new IOException("Timeout reached. Limit: " + jLongValue + " ms");
                }
                if (this.zzg) {
                    throw new IOException("Abort requested before buffering finished. ");
                }
                if (!this.zzh) {
                    if (!this.zze.zzV()) {
                        throw new IOException("ExoPlayer was released during preloading.");
                    }
                    long jZzz = this.zze.zzz();
                    if (jZzz > 0) {
                        long jZzv = this.zze.zzv();
                        if (jZzv != this.zzk) {
                            boolean z = jZzv > 0;
                            String str = this.zzf;
                            long jZzA = zBooleanValue ? this.zze.zzA() : -1L;
                            j3 = jZzv;
                            j = jIntValue;
                            boolean z2 = z;
                            n42Var2 = n42Var;
                            j2 = jZzz;
                            zzo(str, strZzc, j3, j2, z2, jZzA, zBooleanValue ? this.zze.zzx() : -1L, zBooleanValue ? this.zze.zzB() : -1L, zzcbb.zzs(), zzcbb.zzu());
                            this.zzk = j3;
                        } else {
                            n42Var2 = n42Var;
                            j = jIntValue;
                            j2 = jZzz;
                            j3 = jZzv;
                        }
                        if (j3 >= j2) {
                            zzj(this.zzf, strZzc, j2);
                        } else if (this.zze.zzw() >= j && j3 > 0) {
                        }
                    } else {
                        n42Var2 = n42Var;
                    }
                    zzx(((Long) n42Var2.c.zza(zzbbw.zzs)).longValue());
                    return;
                }
                hd2.B.z.zzc(this.zzi);
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzi(final boolean z, final long j) {
        final zzcbk zzcbkVar = (zzcbk) this.zzc.get();
        if (zzcbkVar != null) {
            zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdc
                @Override // java.lang.Runnable
                public final void run() {
                    zzcbkVar.zzv(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzk(String str, Exception exc) {
        k92.j(5);
        hd2.B.g.zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzl(String str, Exception exc) {
        k92.j(5);
        hd2.B.g.zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzm(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzp(int i) {
        this.zze.zzJ(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzq(int i) {
        this.zze.zzK(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzr(int i) {
        this.zze.zzM(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzs(int i) {
        this.zze.zzN(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzu(String str, String[] strArr) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        boolean z;
        this.zzf = str;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcbk zzcbkVar = (zzcbk) this.zzc.get();
            if (zzcbkVar != null) {
                zzcbkVar.zzt(strZzc, this);
            }
            hd2.B.j.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzbbn zzbbnVar = zzbbw.zzs;
            n42 n42Var = n42.d;
            long jLongValue = ((Long) n42Var.c.zza(zzbbnVar)).longValue();
            long jLongValue2 = ((Long) n42Var.c.zza(zzbbw.zzr)).longValue() * 1000;
            long jIntValue = ((Integer) n42Var.c.zza(zzbbw.zzq)).intValue();
            boolean zBooleanValue = ((Boolean) n42Var.c.zza(zzbbw.zzbG)).booleanValue();
            long j8 = -1;
            while (true) {
                synchronized (this) {
                    try {
                        if (System.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                            throw new IOException("Timeout reached. Limit: " + jLongValue2 + " ms");
                        }
                        if (this.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (this.zzh) {
                            return true;
                        }
                        if (!this.zze.zzV()) {
                            throw new IOException("ExoPlayer was released during preloading.");
                        }
                        long jZzz = this.zze.zzz();
                        if (jZzz > 0) {
                            long jZzv = this.zze.zzv();
                            if (jZzv != j8) {
                                if (jZzv > 0) {
                                    j7 = jLongValue2;
                                    z = true;
                                } else {
                                    j7 = jLongValue2;
                                    z = false;
                                }
                                j6 = jZzv;
                                long jZzA = zBooleanValue ? this.zze.zzA() : -1L;
                                j2 = jIntValue;
                                j4 = jLongValue;
                                j = j7;
                                j5 = jZzz;
                                zzo(str, strZzc, j6, j5, z, jZzA, zBooleanValue ? this.zze.zzx() : -1L, zBooleanValue ? this.zze.zzB() : -1L, zzcbb.zzs(), zzcbb.zzu());
                                j8 = j6;
                            } else {
                                j4 = jLongValue;
                                j = jLongValue2;
                                j2 = jIntValue;
                                j5 = jZzz;
                                j6 = jZzv;
                            }
                            if (j6 >= j5) {
                                zzj(str, strZzc, j5);
                                return true;
                            }
                            if (this.zze.zzw() >= j2 && j6 > 0) {
                                return true;
                            }
                            j3 = j4;
                        } else {
                            j = jLongValue2;
                            j2 = jIntValue;
                            j3 = jLongValue;
                        }
                        try {
                            wait(j3);
                        } catch (InterruptedException unused) {
                            throw new IOException("Wait interrupted.");
                        }
                    } finally {
                    }
                }
                jLongValue = j3;
                jIntValue = j2;
                jLongValue2 = j;
            }
        } catch (Exception e) {
            k92.h("Failed to preload url " + str + " Exception: " + e.getMessage());
            hd2.B.g.zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, strZzc, "error", zzd("error", e));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzv() {
        k92.h("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzw(String str, String[] strArr, zzccn zzccnVar) {
        this.zzf = str;
        this.zzi = zzccnVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcbk zzcbkVar = (zzcbk) this.zzc.get();
            if (zzcbkVar != null) {
                zzcbkVar.zzt(strZzc, this);
            }
            hd2.B.j.getClass();
            this.zzj = System.currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e) {
            k92.h("Failed to preload url " + str + " Exception: " + e.getMessage());
            hd2.B.g.zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, strZzc, "error", zzd("error", e));
            return false;
        }
    }
}
