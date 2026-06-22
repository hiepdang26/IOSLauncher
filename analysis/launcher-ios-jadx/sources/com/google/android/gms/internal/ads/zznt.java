package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class zznt implements zznx {
    public static final zzfvk zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zznr
        @Override // com.google.android.gms.internal.ads.zzfvk
        public final Object zza() {
            return zznt.zzn();
        }
    };
    private static final Random zzb = new Random();
    private final zzcb zzc;
    private final zzca zzd;
    private final HashMap zze;
    private zznw zzf;
    private zzcc zzg;
    private String zzh;
    private long zzi;

    public zznt() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzl() {
        zzns zznsVar = (zzns) this.zze.get(this.zzh);
        return (zznsVar == null || zznsVar.zzd == -1) ? this.zzi + 1 : zznsVar.zzd;
    }

    private final zzns zzm(int i, zzui zzuiVar) {
        long j = Long.MAX_VALUE;
        zzns zznsVar = null;
        for (zzns zznsVar2 : this.zze.values()) {
            zznsVar2.zzg(i, zzuiVar);
            if (zznsVar2.zzj(i, zzuiVar)) {
                long j2 = zznsVar2.zzd;
                if (j2 == -1 || j2 < j) {
                    zznsVar = zznsVar2;
                    j = j2;
                } else if (j2 == j) {
                    int i2 = zzet.zza;
                    if (zznsVar.zze != null && zznsVar2.zze != null) {
                        zznsVar = zznsVar2;
                    }
                }
            }
        }
        if (zznsVar != null) {
            return zznsVar;
        }
        String strZzn = zzn();
        zzns zznsVar3 = new zzns(this, strZzn, i, zzuiVar);
        this.zze.put(strZzn, zznsVar3);
        return zznsVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzns zznsVar) {
        if (zznsVar.zzd != -1) {
            this.zzi = zznsVar.zzd;
        }
        this.zzh = null;
    }

    private final void zzp(zzlo zzloVar) {
        if (zzloVar.zzb.zzo()) {
            String str = this.zzh;
            if (str != null) {
                zzns zznsVar = (zzns) this.zze.get(str);
                zznsVar.getClass();
                zzo(zznsVar);
                return;
            }
            return;
        }
        zzns zznsVar2 = (zzns) this.zze.get(this.zzh);
        zzns zznsVarZzm = zzm(zzloVar.zzc, zzloVar.zzd);
        this.zzh = zznsVarZzm.zzb;
        zzi(zzloVar);
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar == null || !zzuiVar.zzb()) {
            return;
        }
        if (zznsVar2 != null) {
            if (zznsVar2.zzd == zzuiVar.zzd && zznsVar2.zze != null && zznsVar2.zze.zzb == zzloVar.zzd.zzb && zznsVar2.zze.zzc == zzloVar.zzd.zzc) {
                return;
            }
        }
        zzui zzuiVar2 = zzloVar.zzd;
        String unused = zzm(zzloVar.zzc, new zzui(zzuiVar2.zza, zzuiVar2.zzd)).zzb;
        String unused2 = zznsVarZzm.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized String zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized String zzf(zzcc zzccVar, zzui zzuiVar) {
        return zzm(zzccVar.zzn(zzuiVar.zza, this.zzd).zzc, zzuiVar).zzb;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized void zzg(zzlo zzloVar) {
        zznw zznwVar;
        try {
            String str = this.zzh;
            if (str != null) {
                zzns zznsVar = (zzns) this.zze.get(str);
                if (zznsVar == null) {
                    throw null;
                }
                zzo(zznsVar);
            }
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzns zznsVar2 = (zzns) it.next();
                it.remove();
                if (zznsVar2.zzf && (zznwVar = this.zzf) != null) {
                    zznwVar.zzd(zzloVar, zznsVar2.zzb, false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final void zzh(zznw zznwVar) {
        this.zzf = zznwVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:21:0x003f, B:23:0x004b, B:24:0x0051, B:26:0x0056, B:28:0x005c, B:30:0x0073, B:31:0x009b, B:33:0x00a1, B:34:0x00a7, B:36:0x00b3, B:38:0x00b9, B:44:0x00ca), top: B:47:0x0001 }] */
    @Override // com.google.android.gms.internal.ads.zznx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzi(com.google.android.gms.internal.ads.zzlo r10) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznt.zzi(com.google.android.gms.internal.ads.zzlo):void");
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized void zzj(zzlo zzloVar, int i) {
        try {
            if (this.zzf == null) {
                throw null;
            }
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzns zznsVar = (zzns) it.next();
                if (zznsVar.zzk(zzloVar)) {
                    it.remove();
                    if (zznsVar.zzf) {
                        boolean zEquals = zznsVar.zzb.equals(this.zzh);
                        boolean z = false;
                        if (i == 0 && zEquals && zznsVar.zzg) {
                            z = true;
                        }
                        if (zEquals) {
                            zzo(zznsVar);
                        }
                        this.zzf.zzd(zzloVar, zznsVar.zzb, z);
                    }
                }
            }
            zzp(zzloVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized void zzk(zzlo zzloVar) {
        try {
            if (this.zzf == null) {
                throw null;
            }
            zzcc zzccVar = this.zzg;
            this.zzg = zzloVar.zzb;
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzns zznsVar = (zzns) it.next();
                if (!zznsVar.zzl(zzccVar, this.zzg) || zznsVar.zzk(zzloVar)) {
                    it.remove();
                    if (zznsVar.zzf) {
                        if (zznsVar.zzb.equals(this.zzh)) {
                            zzo(zznsVar);
                        }
                        this.zzf.zzd(zzloVar, zznsVar.zzb, false);
                    }
                }
            }
            zzp(zzloVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public zznt(zzfvk zzfvkVar) {
        this.zzc = new zzcb();
        this.zzd = new zzca();
        this.zze = new HashMap();
        this.zzg = zzcc.zza;
        this.zzi = -1L;
    }
}
