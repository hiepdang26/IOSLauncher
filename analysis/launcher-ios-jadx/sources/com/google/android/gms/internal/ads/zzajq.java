package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzajq extends zzajo {
    private zzajp zza;
    private int zzb;
    private boolean zzc;
    private zzadu zzd;
    private zzads zze;

    @Override // com.google.android.gms.internal.ads.zzajo
    public final long zza(zzek zzekVar) {
        if ((zzekVar.zzM()[0] & 1) == 1) {
            return -1L;
        }
        byte b = zzekVar.zzM()[0];
        zzajp zzajpVar = this.zza;
        zzdi.zzb(zzajpVar);
        int i = !zzajpVar.zzd[(b >> 1) & (255 >>> (8 - zzajpVar.zze))].zza ? zzajpVar.zza.zze : zzajpVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzekVar.zzc() < zzekVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzekVar.zzM(), zzekVar.zze() + 4);
            zzekVar.zzI(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzekVar.zzJ(zzekVar.zze() + 4);
        }
        long j = i2;
        byte[] bArrZzM = zzekVar.zzM();
        bArrZzM[zzekVar.zze() - 4] = (byte) (j & 255);
        bArrZzM[zzekVar.zze() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzM[zzekVar.zze() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzM[zzekVar.zze() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final boolean zzc(zzek zzekVar, long j, zzajl zzajlVar) throws zzbo {
        zzajp zzajpVar;
        int i;
        int iZzb;
        int i2;
        int[] iArr;
        if (this.zza != null) {
            zzajlVar.zza.getClass();
            return false;
        }
        zzadu zzaduVar = this.zzd;
        int i3 = 1;
        if (zzaduVar == null) {
            zzadv.zzd(1, zzekVar, false);
            int iZzj = zzekVar.zzj();
            int iZzm = zzekVar.zzm();
            int iZzj2 = zzekVar.zzj();
            int iZzi = zzekVar.zzi();
            int i4 = iZzi <= 0 ? -1 : iZzi;
            int iZzi2 = zzekVar.zzi();
            int i5 = iZzi2 <= 0 ? -1 : iZzi2;
            int iZzi3 = zzekVar.zzi();
            int i6 = iZzi3 <= 0 ? -1 : iZzi3;
            int iZzm2 = zzekVar.zzm();
            this.zzd = new zzadu(iZzj, iZzm, iZzj2, i4, i5, i6, (int) Math.pow(2.0d, iZzm2 & 15), (int) Math.pow(2.0d, (iZzm2 & 240) >> 4), 1 == (zzekVar.zzm() & 1), Arrays.copyOf(zzekVar.zzM(), zzekVar.zze()));
        } else {
            zzads zzadsVar = this.zze;
            if (zzadsVar == null) {
                this.zze = zzadv.zzc(zzekVar, true, true);
            } else {
                byte[] bArr = new byte[zzekVar.zze()];
                System.arraycopy(zzekVar.zzM(), 0, bArr, 0, zzekVar.zze());
                int i7 = zzaduVar.zza;
                int i8 = 5;
                zzadv.zzd(5, zzekVar, false);
                int iZzm3 = zzekVar.zzm() + 1;
                zzadr zzadrVar = new zzadr(zzekVar.zzM());
                zzadrVar.zzc(zzekVar.zzd() * 8);
                int i9 = 0;
                while (true) {
                    int i10 = 2;
                    int i11 = 16;
                    if (i9 >= iZzm3) {
                        int i12 = 1;
                        int i13 = 6;
                        int iZzb2 = zzadrVar.zzb(6) + 1;
                        for (int i14 = 0; i14 < iZzb2; i14++) {
                            if (zzadrVar.zzb(16) != 0) {
                                throw zzbo.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int iZzb3 = zzadrVar.zzb(6) + 1;
                        int i15 = 0;
                        while (true) {
                            int i16 = 3;
                            if (i15 < iZzb3) {
                                int iZzb4 = zzadrVar.zzb(i11);
                                if (iZzb4 == 0) {
                                    int i17 = 8;
                                    zzadrVar.zzc(8);
                                    zzadrVar.zzc(16);
                                    zzadrVar.zzc(16);
                                    zzadrVar.zzc(6);
                                    zzadrVar.zzc(8);
                                    int iZzb5 = zzadrVar.zzb(4) + 1;
                                    int i18 = 0;
                                    while (i18 < iZzb5) {
                                        zzadrVar.zzc(i17);
                                        i18++;
                                        i17 = 8;
                                    }
                                } else {
                                    if (iZzb4 != i12) {
                                        throw zzbo.zza("floor type greater than 1 not decodable: " + iZzb4, null);
                                    }
                                    int iZzb6 = zzadrVar.zzb(5);
                                    int[] iArr2 = new int[iZzb6];
                                    int i19 = -1;
                                    for (int i20 = 0; i20 < iZzb6; i20++) {
                                        int iZzb7 = zzadrVar.zzb(4);
                                        iArr2[i20] = iZzb7;
                                        if (iZzb7 > i19) {
                                            i19 = iZzb7;
                                        }
                                    }
                                    int i21 = i19 + 1;
                                    int[] iArr3 = new int[i21];
                                    int i22 = 0;
                                    while (i22 < i21) {
                                        int i23 = 1;
                                        iArr3[i22] = zzadrVar.zzb(i16) + 1;
                                        int iZzb8 = zzadrVar.zzb(2);
                                        if (iZzb8 > 0) {
                                            i2 = 8;
                                            zzadrVar.zzc(8);
                                        } else {
                                            i2 = 8;
                                        }
                                        int i24 = i21;
                                        int i25 = 0;
                                        while (true) {
                                            int i26 = i23 << iZzb8;
                                            iArr = iArr2;
                                            if (i25 < i26) {
                                                zzadrVar.zzc(i2);
                                                i25++;
                                                iArr2 = iArr;
                                                i2 = 8;
                                                i23 = 1;
                                            }
                                        }
                                        i22++;
                                        iArr2 = iArr;
                                        i21 = i24;
                                        i16 = 3;
                                    }
                                    int[] iArr4 = iArr2;
                                    zzadrVar.zzc(2);
                                    int iZzb9 = zzadrVar.zzb(4);
                                    int i27 = 0;
                                    int i28 = 0;
                                    for (int i29 = 0; i29 < iZzb6; i29++) {
                                        i27 += iArr3[iArr4[i29]];
                                        while (i28 < i27) {
                                            zzadrVar.zzc(iZzb9);
                                            i28++;
                                        }
                                    }
                                }
                                i15++;
                                i13 = 6;
                                i11 = 16;
                                i12 = 1;
                            } else {
                                int i30 = 1;
                                int iZzb10 = zzadrVar.zzb(i13) + 1;
                                int i31 = 0;
                                while (i31 < iZzb10) {
                                    if (zzadrVar.zzb(16) > 2) {
                                        throw zzbo.zza("residueType greater than 2 is not decodable", null);
                                    }
                                    zzadrVar.zzc(24);
                                    zzadrVar.zzc(24);
                                    zzadrVar.zzc(24);
                                    int iZzb11 = zzadrVar.zzb(i13) + i30;
                                    int i32 = 8;
                                    zzadrVar.zzc(8);
                                    int[] iArr5 = new int[iZzb11];
                                    for (int i33 = 0; i33 < iZzb11; i33++) {
                                        iArr5[i33] = ((zzadrVar.zzd() ? zzadrVar.zzb(5) : 0) * 8) + zzadrVar.zzb(3);
                                    }
                                    int i34 = 0;
                                    while (i34 < iZzb11) {
                                        int i35 = 0;
                                        while (i35 < i32) {
                                            if ((iArr5[i34] & (1 << i35)) != 0) {
                                                zzadrVar.zzc(i32);
                                            }
                                            i35++;
                                            i32 = 8;
                                        }
                                        i34++;
                                        i32 = 8;
                                    }
                                    i31++;
                                    i13 = 6;
                                    i30 = 1;
                                }
                                int iZzb12 = zzadrVar.zzb(i13) + 1;
                                for (int i36 = 0; i36 < iZzb12; i36++) {
                                    int iZzb13 = zzadrVar.zzb(16);
                                    if (iZzb13 != 0) {
                                        zzea.zzc("VorbisUtil", "mapping type other than 0 not supported: " + iZzb13);
                                    } else {
                                        if (zzadrVar.zzd()) {
                                            i = 1;
                                            iZzb = zzadrVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzadrVar.zzd()) {
                                            int iZzb14 = zzadrVar.zzb(8) + i;
                                            for (int i37 = 0; i37 < iZzb14; i37++) {
                                                int i38 = i7 - 1;
                                                zzadrVar.zzc(zzadv.zza(i38));
                                                zzadrVar.zzc(zzadv.zza(i38));
                                            }
                                        }
                                        if (zzadrVar.zzb(2) != 0) {
                                            throw zzbo.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i39 = 0; i39 < i7; i39++) {
                                                zzadrVar.zzc(4);
                                            }
                                        }
                                        for (int i40 = 0; i40 < iZzb; i40++) {
                                            zzadrVar.zzc(8);
                                            zzadrVar.zzc(8);
                                            zzadrVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb15 = zzadrVar.zzb(6);
                                int i41 = iZzb15 + 1;
                                zzadt[] zzadtVarArr = new zzadt[i41];
                                for (int i42 = 0; i42 < i41; i42++) {
                                    zzadtVarArr[i42] = new zzadt(zzadrVar.zzd(), zzadrVar.zzb(16), zzadrVar.zzb(16), zzadrVar.zzb(8));
                                }
                                if (!zzadrVar.zzd()) {
                                    throw zzbo.zza("framing bit after modes not set as expected", null);
                                }
                                zzajpVar = new zzajp(zzaduVar, zzadsVar, bArr, zzadtVarArr, zzadv.zza(iZzb15));
                            }
                        }
                    } else {
                        if (zzadrVar.zzb(24) != 5653314) {
                            throw zzbo.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzadrVar.zza(), null);
                        }
                        int iZzb16 = zzadrVar.zzb(16);
                        int iZzb17 = zzadrVar.zzb(24);
                        if (zzadrVar.zzd()) {
                            zzadrVar.zzc(i8);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzadrVar.zzb(zzadv.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZzd = zzadrVar.zzd();
                            for (int i43 = 0; i43 < iZzb17; i43++) {
                                if (!zZzd) {
                                    zzadrVar.zzc(i8);
                                } else if (zzadrVar.zzd()) {
                                    zzadrVar.zzc(i8);
                                }
                            }
                        }
                        int iZzb19 = zzadrVar.zzb(4);
                        if (iZzb19 > 2) {
                            throw zzbo.zza("lookup type greater than 2 not decodable: " + iZzb19, null);
                        }
                        if (iZzb19 != i3) {
                            if (iZzb19 == 2) {
                            }
                            i9++;
                            i8 = 5;
                            i3 = 1;
                        } else {
                            i10 = iZzb19;
                        }
                        zzadrVar.zzc(32);
                        zzadrVar.zzc(32);
                        int iZzb20 = zzadrVar.zzb(4) + i3;
                        zzadrVar.zzc(i3);
                        zzadrVar.zzc((int) ((i10 == i3 ? iZzb16 != 0 ? (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16))) : 0L : ((long) iZzb16) * ((long) iZzb17)) * ((long) iZzb20)));
                        i9++;
                        i8 = 5;
                        i3 = 1;
                    }
                }
            }
        }
        zzajpVar = null;
        this.zza = zzajpVar;
        if (zzajpVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzadu zzaduVar2 = zzajpVar.zza;
        arrayList.add(zzaduVar2.zzg);
        arrayList.add(zzajpVar.zzc);
        zzbk zzbkVarZzb = zzadv.zzb(zzfxr.zzl(zzajpVar.zzb.zza));
        zzad zzadVar = new zzad();
        zzadVar.zzX("audio/vorbis");
        zzadVar.zzx(zzaduVar2.zzd);
        zzadVar.zzS(zzaduVar2.zzc);
        zzadVar.zzy(zzaduVar2.zza);
        zzadVar.zzY(zzaduVar2.zzb);
        zzadVar.zzL(arrayList);
        zzadVar.zzQ(zzbkVarZzb);
        zzajlVar.zza = zzadVar.zzad();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void zzi(long j) {
        super.zzi(j);
        this.zzc = j != 0;
        zzadu zzaduVar = this.zzd;
        this.zzb = zzaduVar != null ? zzaduVar.zze : 0;
    }
}
