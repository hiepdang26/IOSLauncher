package com.google.android.gms.internal.ads;

import android.net.Uri;
import defpackage.hd2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import defpackage.uo;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdb extends zzccv implements zzgu {
    private String zzd;
    private final zzcbj zze;
    private boolean zzf;
    private final zzcda zzg;
    private final zzccg zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk;
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcdb(zzcbk zzcbkVar, zzcbj zzcbjVar) {
        super(zzcbkVar);
        this.zze = zzcbjVar;
        this.zzg = new zzcda();
        this.zzh = new zzccg();
        this.zzk = new Object();
        this.zzl = (String) zzfus.zzd(zzcbkVar != null ? zzcbkVar.zzr() : null).zzb("");
        this.zzm = zzcbkVar != null ? zzcbkVar.zzf() : 0;
    }

    public static final String zzm(String str) {
        return "cache:".concat(String.valueOf(ka2.a(str, "MD5")));
    }

    private final void zzv() {
        int iZza = (int) this.zzg.zza();
        int iZza2 = (int) this.zzh.zza(this.zzi);
        int iPosition = this.zzi.position();
        int iRound = Math.round((iPosition / iZza) * iZza2);
        int iZzs = zzcbb.zzs();
        int iZzu = zzcbb.zzu();
        String str = this.zzd;
        zzn(str, zzm(str), iPosition, iZza, iRound, iZza2, iRound > 0, iZzs, iZzu);
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zza(zzfs zzfsVar, zzfy zzfyVar, boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzb(zzfs zzfsVar, zzfy zzfyVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzc(zzfs zzfsVar, zzfy zzfyVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzd(zzfs zzfsVar, zzfy zzfyVar, boolean z) {
        if (zzfsVar instanceof zzgg) {
            this.zzg.zzb((zzgg) zzfsVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzf() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final ByteBuffer zzk() {
        synchronized (this.zzk) {
            try {
                ByteBuffer byteBuffer = this.zzi;
                if (byteBuffer != null && !this.zzj) {
                    byteBuffer.flip();
                    this.zzj = true;
                }
                this.zzf = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.zzi;
    }

    public final boolean zzl() {
        return this.zzn;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:? -> B:23:0x00d3). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzt(String str) throws Throwable {
        String str2;
        zzfs zzfsVarZza;
        long jCurrentTimeMillis;
        long jLongValue;
        long jLongValue2;
        int i;
        byte[] bArr;
        long j;
        this.zzd = str;
        String str3 = "error";
        String strZzm = zzm(str);
        int i2 = 0;
        try {
            zzgb zzgbVar = new zzgb();
            zzgbVar.zzf(this.zzb);
            zzgbVar.zzc(this.zze.zzd);
            zzgbVar.zzd(this.zze.zze);
            zzgbVar.zzb(true);
            zzgbVar.zze(this);
            zzfsVarZza = zzgbVar.zza();
            if (this.zze.zzi) {
                zzfsVarZza = new zzcce(this.zza, zzfsVarZza, this.zzl, this.zzm, null, null);
            }
            zzfsVarZza.zzb(new zzfy(Uri.parse(str), 0L, -1L, null));
            zzcbk zzcbkVar = (zzcbk) this.zzc.get();
            if (zzcbkVar != null) {
                zzcbkVar.zzt(strZzm, this);
            }
            hd2.B.j.getClass();
            jCurrentTimeMillis = System.currentTimeMillis();
            zzbbn zzbbnVar = zzbbw.zzs;
            n42 n42Var = n42.d;
            jLongValue = ((Long) n42Var.c.zza(zzbbnVar)).longValue();
            jLongValue2 = ((Long) n42Var.c.zza(zzbbw.zzr)).longValue();
            this.zzi = ByteBuffer.allocate(this.zze.zzc);
            i = 8192;
            bArr = new byte[8192];
            j = jCurrentTimeMillis;
        } catch (Exception e) {
            e = e;
            str2 = str3;
        }
        while (true) {
            int iZza = zzfsVarZza.zza(bArr, i2, Math.min(this.zzi.remaining(), i));
            if (iZza == -1) {
                this.zzn = true;
                zzj(str, strZzm, (int) this.zzh.zza(this.zzi));
                return true;
            }
            synchronized (this.zzk) {
                try {
                    if (this.zzf) {
                        str2 = str3;
                    } else {
                        str2 = str3;
                        str3 = null;
                        try {
                            this.zzi.put(bArr, 0, iZza);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    try {
                        if (this.zzi.remaining() <= 0) {
                            zzv();
                            return true;
                        }
                        try {
                            if (this.zzf) {
                                throw new IOException("Precache abort at " + this.zzi.limit() + " bytes");
                            }
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            if (jCurrentTimeMillis2 - j >= jLongValue) {
                                zzv();
                                j = jCurrentTimeMillis2;
                            }
                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000 * jLongValue2) {
                                throw new IOException("Timeout exceeded. Limit: " + jLongValue2 + " sec");
                            }
                            str3 = str2;
                            i = 8192;
                            i2 = 0;
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str3 = str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
            str3 = str2;
            String strI = uo.i(e.getClass().getCanonicalName(), ":", e.getMessage());
            k92.h("Failed to preload url " + str + " Exception: " + strI);
            zzg(str, strZzm, str3, strI);
            return false;
        }
    }
}
