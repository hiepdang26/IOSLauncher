package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaiq implements zzack, zzadi {
    private zzagr zzA;
    private final zzajy zza;
    private final int zzb;
    private final zzek zzc;
    private final zzek zzd;
    private final zzek zze;
    private final zzek zzf;
    private final ArrayDeque zzg;
    private final zzaiu zzh;
    private final List zzi;
    private zzfxr zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;
    private zzek zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private zzacn zzu;
    private zzaip[] zzv;
    private long[][] zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    @Deprecated
    public zzaiq() {
        this(zzajy.zza, 16);
    }

    private static int zzk(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzl(zzaiz zzaizVar, long j) {
        int iZza = zzaizVar.zza(j);
        return iZza == -1 ? zzaizVar.zzb(j) : iZza;
    }

    private static long zzm(zzaiz zzaizVar, long j, long j2) {
        int iZzl = zzl(zzaizVar, j);
        return iZzl == -1 ? j2 : Math.min(zzaizVar.zzc[iZzl], j2);
    }

    private final void zzn() {
        this.zzk = 0;
        this.zzn = 0;
    }

    private final void zzo(long j) {
        zzbk zzbkVar;
        long j2;
        int i;
        List list;
        zzacy zzacyVar;
        zzbk zzbkVar2;
        int i2;
        int i3;
        while (!this.zzg.isEmpty() && ((zzahv) this.zzg.peek()).zza == j) {
            zzahv zzahvVar = (zzahv) this.zzg.pop();
            if (zzahvVar.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                int i4 = this.zzz;
                zzacy zzacyVar2 = new zzacy();
                zzahw zzahwVarZzb = zzahvVar.zzb(1969517665);
                if (zzahwVarZzb != null) {
                    zzbk zzbkVarZzb = zzaif.zzb(zzahwVarZzb);
                    zzacyVar2.zzb(zzbkVarZzb);
                    zzbkVar = zzbkVarZzb;
                } else {
                    zzbkVar = null;
                }
                zzahv zzahvVarZza = zzahvVar.zza(1835365473);
                zzbk zzbkVarZza = zzahvVarZza != null ? zzaif.zza(zzahvVarZza) : null;
                zzahw zzahwVarZzb2 = zzahvVar.zzb(1836476516);
                zzahwVarZzb2.getClass();
                boolean z = i4 == 1;
                zzbk zzbkVar3 = zzbkVar;
                zzbk zzbkVar4 = new zzbk(-9223372036854775807L, zzaif.zzc(zzahwVarZzb2.zza));
                zzacy zzacyVar3 = zzacyVar2;
                zzbk zzbkVar5 = zzbkVarZza;
                List listZzd = zzaif.zzd(zzahvVar, zzacyVar3, -9223372036854775807L, null, 1 == (this.zzb & 1), z, new zzful() { // from class: com.google.android.gms.internal.ads.zzaio
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        return (zzaiw) obj;
                    }
                });
                long jMax = -9223372036854775807L;
                long j3 = -9223372036854775807L;
                int i5 = 0;
                int size = -1;
                int i6 = 0;
                while (true) {
                    j2 = 0;
                    if (i5 >= listZzd.size()) {
                        break;
                    }
                    zzaiz zzaizVar = (zzaiz) listZzd.get(i5);
                    if (zzaizVar.zzb == 0) {
                        list = listZzd;
                        zzacyVar = zzacyVar3;
                        i = i6;
                        zzbkVar2 = zzbkVar5;
                    } else {
                        zzaiw zzaiwVar = zzaizVar.zza;
                        long j4 = zzaiwVar.zze;
                        if (j4 == j3) {
                            j4 = zzaizVar.zzh;
                        }
                        jMax = Math.max(jMax, j4);
                        i = i6 + 1;
                        zzaip zzaipVar = new zzaip(zzaiwVar, zzaizVar, this.zzu.zzw(i6, zzaiwVar.zzb));
                        int i7 = "audio/true-hd".equals(zzaiwVar.zzf.zzm) ? zzaizVar.zze * 16 : zzaizVar.zze + 30;
                        zzad zzadVarZzb = zzaiwVar.zzf.zzb();
                        zzadVarZzb.zzP(i7);
                        if (zzaiwVar.zzb == 2) {
                            if ((this.zzb & 8) != 0) {
                                zzadVarZzb.zzV(zzaiwVar.zzf.zzf | (size == -1 ? 1 : 2));
                            }
                            if (j4 > 0 && (i3 = zzaizVar.zzb) > 0) {
                                zzadVarZzb.zzH(i3 / (j4 / 1000000.0f));
                            }
                        }
                        if (zzaiwVar.zzb == 1 && zzacyVar3.zza()) {
                            zzadVarZzb.zzF(zzacyVar3.zza);
                            zzadVarZzb.zzG(zzacyVar3.zzb);
                        }
                        int i8 = zzaiwVar.zzb;
                        zzbk[] zzbkVarArr = {this.zzi.isEmpty() ? null : new zzbk(this.zzi), zzbkVar3, zzbkVar4};
                        list = listZzd;
                        zzacyVar = zzacyVar3;
                        zzbk zzbkVar6 = new zzbk(j3, new zzbj[0]);
                        zzbkVar2 = zzbkVar5;
                        if (zzbkVar2 != null) {
                            for (int i9 = 0; i9 < zzbkVar2.zza(); i9 = i2 + 1) {
                                zzbj zzbjVarZzb = zzbkVar2.zzb(i9);
                                if (zzbjVarZzb instanceof zzex) {
                                    zzex zzexVar = (zzex) zzbjVarZzb;
                                    i2 = i9;
                                    if (!zzexVar.zza.equals("com.android.capture.fps")) {
                                        zzbkVar6 = zzbkVar6.zzc(zzexVar);
                                    } else if (i8 == 2) {
                                        zzbkVar6 = zzbkVar6.zzc(zzexVar);
                                    }
                                } else {
                                    i2 = i9;
                                }
                            }
                        }
                        for (int i10 = 0; i10 < 3; i10++) {
                            zzbkVar6 = zzbkVar6.zzd(zzbkVarArr[i10]);
                        }
                        if (zzbkVar6.zza() > 0) {
                            zzadVarZzb.zzQ(zzbkVar6);
                        }
                        zzaipVar.zzc.zzl(zzadVarZzb.zzad());
                        if (zzaiwVar.zzb == 2 && size == -1) {
                            size = arrayList.size();
                        }
                        arrayList.add(zzaipVar);
                    }
                    i5++;
                    zzbkVar5 = zzbkVar2;
                    i6 = i;
                    listZzd = list;
                    zzacyVar3 = zzacyVar;
                    j3 = -9223372036854775807L;
                }
                this.zzx = size;
                this.zzy = jMax;
                zzaip[] zzaipVarArr = (zzaip[]) arrayList.toArray(new zzaip[0]);
                this.zzv = zzaipVarArr;
                int length = zzaipVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i11 = 0; i11 < zzaipVarArr.length; i11++) {
                    jArr[i11] = new long[zzaipVarArr[i11].zzb.zzb];
                    jArr2[i11] = zzaipVarArr[i11].zzb.zzf[0];
                }
                int i12 = 0;
                while (i12 < zzaipVarArr.length) {
                    long j5 = Long.MAX_VALUE;
                    int i13 = -1;
                    for (int i14 = 0; i14 < zzaipVarArr.length; i14++) {
                        if (!zArr[i14]) {
                            long j6 = jArr2[i14];
                            if (j6 <= j5) {
                                i13 = i14;
                                j5 = j6;
                            }
                        }
                    }
                    int i15 = iArr[i13];
                    long[] jArr3 = jArr[i13];
                    jArr3[i15] = j2;
                    zzaiz zzaizVar2 = zzaipVarArr[i13].zzb;
                    j2 += (long) zzaizVar2.zzd[i15];
                    int i16 = i15 + 1;
                    iArr[i13] = i16;
                    if (i16 < jArr3.length) {
                        jArr2[i13] = zzaizVar2.zzf[i16];
                    } else {
                        zArr[i13] = true;
                        i12++;
                    }
                }
                this.zzw = jArr;
                this.zzu.zzD();
                this.zzu.zzO(this);
                this.zzg.clear();
                this.zzk = 2;
            } else if (!this.zzg.isEmpty()) {
                ((zzahv) this.zzg.peek()).zzc(zzahvVar);
            }
        }
        if (this.zzk != 2) {
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzy;
    }

    /* JADX WARN: Removed duplicated region for block: B:283:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r36, com.google.android.gms.internal.ads.zzadf r37) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiq.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        if ((this.zzb & 16) == 0) {
            zzacnVar = new zzakc(zzacnVar, this.zza);
        }
        this.zzu = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        long j2;
        long j3;
        int iZzb;
        zzaip[] zzaipVarArr = this.zzv;
        if (zzaipVarArr.length == 0) {
            zzadj zzadjVar = zzadj.zza;
            return new zzadg(zzadjVar, zzadjVar);
        }
        int i = this.zzx;
        long jZzm = -1;
        if (i != -1) {
            zzaiz zzaizVar = zzaipVarArr[i].zzb;
            int iZzl = zzl(zzaizVar, j);
            if (iZzl == -1) {
                zzadj zzadjVar2 = zzadj.zza;
                return new zzadg(zzadjVar2, zzadjVar2);
            }
            long j4 = zzaizVar.zzf[iZzl];
            j2 = zzaizVar.zzc[iZzl];
            if (j4 >= j || iZzl >= zzaizVar.zzb - 1 || (iZzb = zzaizVar.zzb(j)) == -1 || iZzb == iZzl) {
                j3 = -9223372036854775807L;
            } else {
                j3 = zzaizVar.zzf[iZzb];
                jZzm = zzaizVar.zzc[iZzb];
            }
            j = j4;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            zzaip[] zzaipVarArr2 = this.zzv;
            if (i2 >= zzaipVarArr2.length) {
                break;
            }
            if (i2 != this.zzx) {
                zzaiz zzaizVar2 = zzaipVarArr2[i2].zzb;
                long jZzm2 = zzm(zzaizVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    jZzm = zzm(zzaizVar2, j3, jZzm);
                }
                j2 = jZzm2;
            }
            i2++;
        }
        zzadj zzadjVar3 = new zzadj(j, j2);
        return j3 == -9223372036854775807L ? new zzadg(zzadjVar3, zzadjVar3) : new zzadg(zzadjVar3, new zzadj(j3, jZzm));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        this.zzg.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        if (j == 0) {
            if (this.zzk != 3) {
                zzn();
                return;
            } else {
                this.zzh.zzb();
                this.zzi.clear();
                return;
            }
        }
        for (zzaip zzaipVar : this.zzv) {
            zzaiz zzaizVar = zzaipVar.zzb;
            int iZza = zzaizVar.zza(j2);
            if (iZza == -1) {
                iZza = zzaizVar.zzb(j2);
            }
            zzaipVar.zze = iZza;
            zzadq zzadqVar = zzaipVar.zzd;
            if (zzadqVar != null) {
                zzadqVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) {
        zzadm zzadmVarZzb = zzaiv.zzb(zzaclVar, (this.zzb & 2) != 0);
        this.zzj = zzadmVarZzb != null ? zzfxr.zzn(zzadmVarZzb) : zzfxr.zzm();
        return zzadmVarZzb == null;
    }

    public zzaiq(zzajy zzajyVar, int i) {
        this.zza = zzajyVar;
        this.zzb = i;
        this.zzj = zzfxr.zzm();
        this.zzk = (i & 4) != 0 ? 3 : 0;
        this.zzh = new zzaiu();
        this.zzi = new ArrayList();
        this.zzf = new zzek(16);
        this.zzg = new ArrayDeque();
        this.zzc = new zzek(zzfh.zza);
        this.zzd = new zzek(4);
        this.zze = new zzek();
        this.zzp = -1;
        this.zzu = zzacn.zza;
        this.zzv = new zzaip[0];
    }
}
