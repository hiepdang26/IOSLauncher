package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzkk {
    private final zzln zzc;
    private final zzdt zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzkh zzh;
    private zzkh zzi;
    private zzkh zzj;
    private int zzk;
    private Object zzl;
    private long zzm;
    private zzig zzn;
    private final zzjp zzp;
    private final zzca zza = new zzca();
    private final zzcb zzb = new zzcb();
    private List zzo = new ArrayList();

    public zzkk(zzln zzlnVar, zzdt zzdtVar, zzjp zzjpVar, zzig zzigVar) {
        this.zzc = zzlnVar;
        this.zzd = zzdtVar;
        this.zzp = zzjpVar;
        this.zzn = zzigVar;
    }

    private final zzki zzA(zzcc zzccVar, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        long jMax = j;
        zzccVar.zzn(obj, this.zza);
        int iZzc = this.zza.zzc(jMax);
        if (iZzc != -1) {
            this.zza.zzm(iZzc);
        }
        if (iZzc == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(iZzc);
        }
        zzui zzuiVar = new zzui(obj, j3, iZzc);
        boolean zZzG = zzG(zzuiVar);
        boolean zZzE = zzE(zzccVar, zzuiVar);
        boolean zZzD = zzD(zzccVar, zzuiVar, zZzG);
        if (iZzc != -1) {
            this.zza.zzn(iZzc);
        }
        if (iZzc != -1) {
            this.zza.zzi(iZzc);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j5 = 0;
            j6 = 0;
        } else {
            j5 = j4;
            j6 = this.zza.zzd;
        }
        if (j6 != -9223372036854775807L && jMax >= j6) {
            jMax = Math.max(0L, j6 - 1);
        }
        return new zzki(zzuiVar, jMax, j2, j5, j6, false, zZzG, zZzE, zZzD);
    }

    private static zzui zzB(zzcc zzccVar, Object obj, long j, long j2, zzcb zzcbVar, zzca zzcaVar) {
        zzccVar.zzn(obj, zzcaVar);
        zzccVar.zze(zzcaVar.zzc, zzcbVar, 0L);
        zzccVar.zza(obj);
        zzcaVar.zzb();
        zzccVar.zzn(obj, zzcaVar);
        int iZzd = zzcaVar.zzd(j);
        return iZzd == -1 ? new zzui(obj, j2, zzcaVar.zzc(j)) : new zzui(obj, iZzd, zzcaVar.zze(iZzd), j2);
    }

    private final void zzC() {
        final zzfxo zzfxoVar = new zzfxo();
        for (zzkh zzkhVarZzg = this.zzh; zzkhVarZzg != null; zzkhVarZzg = zzkhVarZzg.zzg()) {
            zzfxoVar.zzf(zzkhVarZzg.zzf.zza);
        }
        zzkh zzkhVar = this.zzi;
        final zzui zzuiVar = zzkhVar == null ? null : zzkhVar.zzf.zza;
        this.zzd.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzk(zzfxoVar, zzuiVar);
            }
        });
    }

    private final boolean zzD(zzcc zzccVar, zzui zzuiVar, boolean z) {
        int iZza = zzccVar.zza(zzuiVar.zza);
        return !zzccVar.zze(zzccVar.zzd(iZza, this.zza, false).zzc, this.zzb, 0L).zzi && zzccVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg) == -1 && z;
    }

    private final boolean zzE(zzcc zzccVar, zzui zzuiVar) {
        if (zzG(zzuiVar)) {
            return zzccVar.zze(zzccVar.zzn(zzuiVar.zza, this.zza).zzc, this.zzb, 0L).zzo == zzccVar.zza(zzuiVar.zza);
        }
        return false;
    }

    private final boolean zzF(zzcc zzccVar) {
        zzcc zzccVar2;
        zzkh zzkhVarZzg = this.zzh;
        if (zzkhVarZzg == null) {
            return true;
        }
        int iZza = zzccVar.zza(zzkhVarZzg.zzb);
        while (true) {
            zzccVar2 = zzccVar;
            iZza = zzccVar2.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzkhVarZzg.getClass();
                if (zzkhVarZzg.zzg() == null || zzkhVarZzg.zzf.zzg) {
                    break;
                }
                zzkhVarZzg = zzkhVarZzg.zzg();
            }
            zzkh zzkhVarZzg2 = zzkhVarZzg.zzg();
            if (iZza == -1 || zzkhVarZzg2 == null || zzccVar2.zza(zzkhVarZzg2.zzb) != iZza) {
                break;
            }
            zzkhVarZzg = zzkhVarZzg2;
            zzccVar = zzccVar2;
        }
        boolean zZzq = zzq(zzkhVarZzg);
        zzkhVarZzg.zzf = zzh(zzccVar2, zzkhVarZzg.zzf);
        return !zZzq;
    }

    private static final boolean zzG(zzui zzuiVar) {
        return !zzuiVar.zzb() && zzuiVar.zze == -1;
    }

    public static boolean zzo(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    private final long zzv(zzcc zzccVar, Object obj, int i) {
        zzccVar.zzn(obj, this.zza);
        this.zza.zzi(i);
        this.zza.zzk(i);
        return 0L;
    }

    private final long zzw(Object obj) {
        for (int i = 0; i < this.zzo.size(); i++) {
            zzkh zzkhVar = (zzkh) this.zzo.get(i);
            if (zzkhVar.zzb.equals(obj)) {
                return zzkhVar.zzf.zza.zzd;
            }
        }
        return -1L;
    }

    private final zzki zzx(zzcc zzccVar, zzkh zzkhVar, long j) {
        zzcc zzccVar2;
        Object obj;
        long j2;
        zzki zzkiVar = zzkhVar.zzf;
        long jZze = (zzkhVar.zze() + zzkiVar.zze) - j;
        if (!zzkiVar.zzg) {
            zzui zzuiVar = zzkiVar.zza;
            zzccVar.zzn(zzuiVar.zza, this.zza);
            if (!zzuiVar.zzb()) {
                int i = zzuiVar.zze;
                if (i != -1) {
                    this.zza.zzm(i);
                }
                zzca zzcaVar = this.zza;
                int i2 = zzuiVar.zze;
                int iZze = zzcaVar.zze(i2);
                zzcaVar.zzn(i2);
                if (iZze != this.zza.zza(zzuiVar.zze)) {
                    return zzz(zzccVar, zzuiVar.zza, zzuiVar.zze, iZze, zzkiVar.zze, zzuiVar.zzd);
                }
                zzv(zzccVar, zzuiVar.zza, zzuiVar.zze);
                return zzA(zzccVar, zzuiVar.zza, 0L, zzkiVar.zze, zzuiVar.zzd);
            }
            int i3 = zzuiVar.zzb;
            if (this.zza.zza(i3) == -1) {
                return null;
            }
            int iZzf = this.zza.zzf(i3, zzuiVar.zzc);
            if (iZzf < 0) {
                return zzz(zzccVar, zzuiVar.zza, i3, iZzf, zzkiVar.zzc, zzuiVar.zzd);
            }
            long jLongValue = zzkiVar.zzc;
            if (jLongValue == -9223372036854775807L) {
                zzcb zzcbVar = this.zzb;
                zzca zzcaVar2 = this.zza;
                Pair pairZzm = zzccVar.zzm(zzcbVar, zzcaVar2, zzcaVar2.zzc, -9223372036854775807L, Math.max(0L, jZze));
                zzccVar2 = zzccVar;
                if (pairZzm == null) {
                    return null;
                }
                jLongValue = ((Long) pairZzm.second).longValue();
            } else {
                zzccVar2 = zzccVar;
            }
            zzv(zzccVar2, zzuiVar.zza, zzuiVar.zzb);
            return zzA(zzccVar, zzuiVar.zza, Math.max(0L, jLongValue), zzkiVar.zzc, zzuiVar.zzd);
        }
        long j3 = 0;
        int iZzi = zzccVar.zzi(zzccVar.zza(zzkiVar.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
        if (iZzi == -1) {
            return null;
        }
        int i4 = zzccVar.zzd(iZzi, this.zza, true).zzc;
        Object obj2 = this.zza.zzb;
        obj2.getClass();
        long j4 = zzkiVar.zza.zzd;
        if (zzccVar.zze(i4, this.zzb, 0L).zzn == iZzi) {
            Pair pairZzm2 = zzccVar.zzm(this.zzb, this.zza, i4, -9223372036854775807L, Math.max(0L, jZze));
            if (pairZzm2 == null) {
                return null;
            }
            Object obj3 = pairZzm2.first;
            long jLongValue2 = ((Long) pairZzm2.second).longValue();
            zzkh zzkhVarZzg = zzkhVar.zzg();
            if (zzkhVarZzg == null || !zzkhVarZzg.zzb.equals(obj3)) {
                long jZzw = zzw(obj3);
                if (jZzw == -1) {
                    jZzw = this.zze;
                    this.zze = 1 + jZzw;
                }
                j4 = jZzw;
            } else {
                j4 = zzkhVarZzg.zzf.zza.zzd;
            }
            obj = obj3;
            j2 = jLongValue2;
            j3 = -9223372036854775807L;
        } else {
            obj = obj2;
            j2 = 0;
        }
        zzui zzuiVarZzB = zzB(zzccVar, obj, j2, j4, this.zzb, this.zza);
        if (j3 != -9223372036854775807L && zzkiVar.zzc != -9223372036854775807L) {
            zzccVar.zzn(zzkiVar.zza.zza, this.zza).zzb();
            this.zza.zzg();
        }
        return zzy(zzccVar, zzuiVarZzB, j3, j2);
    }

    private final zzki zzy(zzcc zzccVar, zzui zzuiVar, long j, long j2) {
        zzccVar.zzn(zzuiVar.zza, this.zza);
        return zzuiVar.zzb() ? zzz(zzccVar, zzuiVar.zza, zzuiVar.zzb, zzuiVar.zzc, j, zzuiVar.zzd) : zzA(zzccVar, zzuiVar.zza, j2, j, zzuiVar.zzd);
    }

    private final zzki zzz(zzcc zzccVar, Object obj, int i, int i2, long j, long j2) {
        zzui zzuiVar = new zzui(obj, i, i2, j2);
        Object obj2 = zzuiVar.zza;
        long jZzh = zzccVar.zzn(obj2, this.zza).zzh(zzuiVar.zzb, zzuiVar.zzc);
        if (i2 == this.zza.zze(i)) {
            this.zza.zzj();
        }
        this.zza.zzn(zzuiVar.zzb);
        long jMax = 0;
        if (jZzh != -9223372036854775807L && jZzh <= 0) {
            jMax = Math.max(0L, (-1) + jZzh);
        }
        return new zzki(zzuiVar, jMax, j, -9223372036854775807L, jZzh, false, false, false, false);
    }

    public final zzkh zza() {
        zzkh zzkhVar = this.zzh;
        if (zzkhVar == null) {
            return null;
        }
        if (zzkhVar == this.zzi) {
            this.zzi = zzkhVar.zzg();
        }
        zzkhVar.zzn();
        int i = this.zzk - 1;
        this.zzk = i;
        if (i == 0) {
            this.zzj = null;
            zzkh zzkhVar2 = this.zzh;
            this.zzl = zzkhVar2.zzb;
            this.zzm = zzkhVar2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzC();
        return this.zzh;
    }

    public final zzkh zzb() {
        zzkh zzkhVar = this.zzi;
        zzdi.zzb(zzkhVar);
        this.zzi = zzkhVar.zzg();
        zzC();
        zzkh zzkhVar2 = this.zzi;
        zzdi.zzb(zzkhVar2);
        return zzkhVar2;
    }

    public final zzkh zzc(zzki zzkiVar) {
        zzkh zzkhVarZzd;
        zzkh zzkhVar = this.zzj;
        long jZze = zzkhVar == null ? 1000000000000L : (zzkhVar.zze() + zzkhVar.zzf.zze) - zzkiVar.zzb;
        int i = 0;
        while (true) {
            if (i >= this.zzo.size()) {
                zzkhVarZzd = null;
                break;
            }
            zzki zzkiVar2 = ((zzkh) this.zzo.get(i)).zzf;
            if (zzo(zzkiVar2.zze, zzkiVar.zze) && zzkiVar2.zzb == zzkiVar.zzb && zzkiVar2.zza.equals(zzkiVar.zza)) {
                zzkhVarZzd = (zzkh) this.zzo.remove(i);
                break;
            }
            i++;
        }
        if (zzkhVarZzd == null) {
            zzkhVarZzd = zzjx.zzd(this.zzp.zza, zzkiVar, jZze);
        } else {
            zzkhVarZzd.zzf = zzkiVar;
            zzkhVarZzd.zzp(jZze);
        }
        zzkh zzkhVar2 = this.zzj;
        if (zzkhVar2 != null) {
            zzkhVar2.zzo(zzkhVarZzd);
        } else {
            this.zzh = zzkhVarZzd;
            this.zzi = zzkhVarZzd;
        }
        this.zzl = null;
        this.zzj = zzkhVarZzd;
        this.zzk++;
        zzC();
        return zzkhVarZzd;
    }

    public final zzkh zzd() {
        return this.zzj;
    }

    public final zzkh zze() {
        return this.zzh;
    }

    public final zzkh zzf() {
        return this.zzi;
    }

    public final zzki zzg(long j, zzkx zzkxVar) {
        zzkh zzkhVar = this.zzj;
        return zzkhVar == null ? zzy(zzkxVar.zza, zzkxVar.zzb, zzkxVar.zzc, zzkxVar.zzr) : zzx(zzkxVar.zza, zzkhVar, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzki zzh(com.google.android.gms.internal.ads.zzcc r16, com.google.android.gms.internal.ads.zzki r17) {
        /*
            r15 = this;
            r1 = r16
            r2 = r17
            com.google.android.gms.internal.ads.zzui r3 = r2.zza
            boolean r12 = zzG(r3)
            boolean r13 = r15.zzE(r1, r3)
            boolean r14 = r15.zzD(r1, r3, r12)
            com.google.android.gms.internal.ads.zzui r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzca r5 = r15.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L2d
            int r1 = r3.zze
            if (r1 != r4) goto L2f
        L2d:
            r9 = r7
            goto L35
        L2f:
            com.google.android.gms.internal.ads.zzca r9 = r15.zza
            r9.zzi(r1)
            r9 = r5
        L35:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L48
            com.google.android.gms.internal.ads.zzca r1 = r15.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzh(r5, r6)
        L45:
            r7 = r9
            r9 = r5
            goto L54
        L48:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L4f
            r7 = r5
            r9 = r7
            goto L54
        L4f:
            com.google.android.gms.internal.ads.zzca r1 = r15.zza
            long r5 = r1.zzd
            goto L45
        L54:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L62
            com.google.android.gms.internal.ads.zzca r1 = r15.zza
            int r4 = r3.zzb
            r1.zzn(r4)
            goto L6b
        L62:
            int r1 = r3.zze
            if (r1 == r4) goto L6b
            com.google.android.gms.internal.ads.zzca r4 = r15.zza
            r4.zzn(r1)
        L6b:
            com.google.android.gms.internal.ads.zzki r1 = new com.google.android.gms.internal.ads.zzki
            r5 = r3
            long r3 = r2.zzb
            r16 = r1
            long r0 = r2.zzc
            r11 = 0
            r2 = r5
            r5 = r0
            r1 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkk.zzh(com.google.android.gms.internal.ads.zzcc, com.google.android.gms.internal.ads.zzki):com.google.android.gms.internal.ads.zzki");
    }

    public final zzui zzi(zzcc zzccVar, Object obj, long j) {
        long jZzw;
        int iZza;
        int i = zzccVar.zzn(obj, this.zza).zzc;
        Object obj2 = this.zzl;
        if (obj2 == null || (iZza = zzccVar.zza(obj2)) == -1 || zzccVar.zzd(iZza, this.zza, false).zzc != i) {
            zzkh zzkhVarZzg = this.zzh;
            while (true) {
                if (zzkhVarZzg == null) {
                    zzkh zzkhVarZzg2 = this.zzh;
                    while (true) {
                        if (zzkhVarZzg2 != null) {
                            int iZza2 = zzccVar.zza(zzkhVarZzg2.zzb);
                            if (iZza2 != -1 && zzccVar.zzd(iZza2, this.zza, false).zzc == i) {
                                jZzw = zzkhVarZzg2.zzf.zza.zzd;
                                break;
                            }
                            zzkhVarZzg2 = zzkhVarZzg2.zzg();
                        } else {
                            jZzw = zzw(obj);
                            if (jZzw == -1) {
                                jZzw = this.zze;
                                this.zze = 1 + jZzw;
                                if (this.zzh == null) {
                                    this.zzl = obj;
                                    this.zzm = jZzw;
                                }
                            }
                        }
                    }
                } else {
                    if (zzkhVarZzg.zzb.equals(obj)) {
                        jZzw = zzkhVarZzg.zzf.zza.zzd;
                        break;
                    }
                    zzkhVarZzg = zzkhVarZzg.zzg();
                }
            }
        } else {
            jZzw = this.zzm;
        }
        zzccVar.zzn(obj, this.zza);
        zzccVar.zze(this.zza.zzc, this.zzb, 0L);
        int iZza3 = zzccVar.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcb zzcbVar = this.zzb;
            if (iZza3 < zzcbVar.zzn) {
                return zzB(zzccVar, obj3, j, jZzw, zzcbVar, this.zza);
            }
            zzccVar.zzd(iZza3, this.zza, true);
            this.zza.zzb();
            zzca zzcaVar = this.zza;
            if (zzcaVar.zzd(zzcaVar.zzd) != -1) {
                obj3 = this.zza.zzb;
                obj3.getClass();
            }
            iZza3--;
        }
    }

    public final void zzj() {
        if (this.zzk == 0) {
            return;
        }
        zzkh zzkhVarZzg = this.zzh;
        zzdi.zzb(zzkhVarZzg);
        this.zzl = zzkhVarZzg.zzb;
        this.zzm = zzkhVarZzg.zzf.zza.zzd;
        while (zzkhVarZzg != null) {
            zzkhVarZzg.zzn();
            zzkhVarZzg = zzkhVarZzg.zzg();
        }
        this.zzh = null;
        this.zzj = null;
        this.zzi = null;
        this.zzk = 0;
        zzC();
    }

    public final /* synthetic */ void zzk(zzfxo zzfxoVar, zzui zzuiVar) {
        this.zzc.zzS(zzfxoVar.zzi(), zzuiVar);
    }

    public final void zzl(long j) {
        zzkh zzkhVar = this.zzj;
        if (zzkhVar != null) {
            zzkhVar.zzm(j);
        }
    }

    public final void zzm() {
        if (this.zzo.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.zzo.size(); i++) {
            ((zzkh) this.zzo.get(i)).zzn();
        }
        this.zzo = arrayList;
    }

    public final void zzn(zzcc zzccVar, zzig zzigVar) {
        this.zzn = zzigVar;
        long j = zzigVar.zzb;
        zzm();
    }

    public final boolean zzp(zzug zzugVar) {
        zzkh zzkhVar = this.zzj;
        return zzkhVar != null && zzkhVar.zza == zzugVar;
    }

    public final boolean zzq(zzkh zzkhVar) {
        zzdi.zzb(zzkhVar);
        boolean z = false;
        if (zzkhVar.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzkhVar;
        while (zzkhVar.zzg() != null) {
            zzkhVar = zzkhVar.zzg();
            zzkhVar.getClass();
            if (zzkhVar == this.zzi) {
                this.zzi = this.zzh;
                z = true;
            }
            zzkhVar.zzn();
            this.zzk--;
        }
        zzkh zzkhVar2 = this.zzj;
        zzkhVar2.getClass();
        zzkhVar2.zzo(null);
        zzC();
        return z;
    }

    public final boolean zzr() {
        zzkh zzkhVar = this.zzj;
        if (zzkhVar != null) {
            return !zzkhVar.zzf.zzi && zzkhVar.zzr() && this.zzj.zzf.zze != -9223372036854775807L && this.zzk < 100;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzs(com.google.android.gms.internal.ads.zzcc r17, long r18, long r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzkh r2 = r0.zzh
            r3 = 0
        L7:
            r4 = 1
            if (r2 == 0) goto L94
            com.google.android.gms.internal.ads.zzki r5 = r2.zzf
            r6 = 0
            if (r3 != 0) goto L16
            com.google.android.gms.internal.ads.zzki r3 = r0.zzh(r1, r5)
            r7 = r18
            goto L39
        L16:
            r7 = r18
            com.google.android.gms.internal.ads.zzki r9 = r0.zzx(r1, r3, r7)
            if (r9 != 0) goto L26
            boolean r1 = r0.zzq(r3)
            if (r1 != 0) goto L25
            return r4
        L25:
            return r6
        L26:
            long r10 = r5.zzb
            long r12 = r9.zzb
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 != 0) goto L8c
            com.google.android.gms.internal.ads.zzui r10 = r5.zza
            com.google.android.gms.internal.ads.zzui r11 = r9.zza
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L8c
            r3 = r9
        L39:
            long r9 = r5.zzc
            com.google.android.gms.internal.ads.zzki r9 = r3.zza(r9)
            r2.zzf = r9
            long r9 = r5.zze
            long r11 = r3.zze
            boolean r5 = zzo(r9, r11)
            if (r5 != 0) goto L83
            r2.zzq()
            long r7 = r3.zze
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L5f
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L64
        L5f:
            long r9 = r2.zze()
            long r7 = r7 + r9
        L64:
            com.google.android.gms.internal.ads.zzkh r1 = r0.zzi
            if (r2 != r1) goto L78
            com.google.android.gms.internal.ads.zzki r1 = r2.zzf
            boolean r1 = r1.zzf
            r9 = -9223372036854775808
            int r1 = (r20 > r9 ? 1 : (r20 == r9 ? 0 : -1))
            if (r1 == 0) goto L76
            int r1 = (r20 > r7 ? 1 : (r20 == r7 ? 0 : -1))
            if (r1 < 0) goto L78
        L76:
            r1 = 1
            goto L79
        L78:
            r1 = 0
        L79:
            boolean r2 = r0.zzq(r2)
            if (r2 != 0) goto L82
            if (r1 != 0) goto L82
            return r4
        L82:
            return r6
        L83:
            com.google.android.gms.internal.ads.zzkh r3 = r2.zzg()
            r15 = r3
            r3 = r2
            r2 = r15
            goto L7
        L8c:
            boolean r1 = r0.zzq(r3)
            if (r1 != 0) goto L93
            return r4
        L93:
            return r6
        L94:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkk.zzs(com.google.android.gms.internal.ads.zzcc, long, long):boolean");
    }

    public final boolean zzt(zzcc zzccVar, int i) {
        this.zzf = i;
        return zzF(zzccVar);
    }

    public final boolean zzu(zzcc zzccVar, boolean z) {
        this.zzg = z;
        return zzF(zzccVar);
    }
}
