package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzbbc;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class zzahj implements zzack {
    private static final byte[] zza = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final UUID zze;
    private static final Map zzf;
    private long zzA;
    private long zzB;
    private zzahi zzC;
    private boolean zzD;
    private int zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private long zzJ;
    private zzeb zzK;
    private zzeb zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private long zzP;
    private long zzQ;
    private int zzR;
    private int zzS;
    private int[] zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private long zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private int zzag;
    private byte zzah;
    private boolean zzai;
    private zzacn zzaj;
    private final zzahf zzg;
    private final zzahl zzh;
    private final SparseArray zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final zzajy zzl;
    private final zzek zzm;
    private final zzek zzn;
    private final zzek zzo;
    private final zzek zzp;
    private final zzek zzq;
    private final zzek zzr;
    private final zzek zzs;
    private final zzek zzt;
    private final zzek zzu;
    private final zzek zzv;
    private ByteBuffer zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i = zzet.zza;
        zzb = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfuj.zzc);
        zzc = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zzd = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zze = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public zzahj() {
        this(new zzahd(), 2, zzajy.zza);
    }

    private static int[] zzA(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    private final int zzq(zzacl zzaclVar, zzahi zzahiVar, int i, boolean z) throws zzbo, EOFException, InterruptedIOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzahiVar.zzb)) {
            zzy(zzaclVar, zza, i);
            int i3 = this.zzab;
            zzx();
            return i3;
        }
        if ("S_TEXT/ASS".equals(zzahiVar.zzb)) {
            zzy(zzaclVar, zzc, i);
            int i4 = this.zzab;
            zzx();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(zzahiVar.zzb)) {
            zzy(zzaclVar, zzd, i);
            int i5 = this.zzab;
            zzx();
            return i5;
        }
        zzadp zzadpVar = zzahiVar.zzW;
        if (!this.zzad) {
            if (zzahiVar.zzg) {
                this.zzW &= -1073741825;
                if (!this.zzae) {
                    ((zzaby) zzaclVar).zzn(this.zzo.zzM(), 0, 1, false);
                    this.zzaa++;
                    if ((this.zzo.zzM()[0] & 128) == 128) {
                        throw zzbo.zza("Extension bit is set in signal byte", null);
                    }
                    this.zzah = this.zzo.zzM()[0];
                    this.zzae = true;
                }
                byte b = this.zzah;
                if ((b & 1) == 1) {
                    int i6 = b & 2;
                    this.zzW |= 1073741824;
                    if (!this.zzai) {
                        ((zzaby) zzaclVar).zzn(this.zzt.zzM(), 0, 8, false);
                        this.zzaa += 8;
                        this.zzai = true;
                        this.zzo.zzM()[0] = (byte) ((i6 != 2 ? 0 : 128) | 8);
                        this.zzo.zzK(0);
                        zzadpVar.zzr(this.zzo, 1, 1);
                        this.zzab++;
                        this.zzt.zzK(0);
                        zzadpVar.zzr(this.zzt, 8, 1);
                        this.zzab += 8;
                    }
                    if (i6 == 2) {
                        if (!this.zzaf) {
                            ((zzaby) zzaclVar).zzn(this.zzo.zzM(), 0, 1, false);
                            this.zzaa++;
                            this.zzo.zzK(0);
                            this.zzag = this.zzo.zzm();
                            this.zzaf = true;
                        }
                        int i7 = this.zzag * 4;
                        this.zzo.zzH(i7);
                        ((zzaby) zzaclVar).zzn(this.zzo.zzM(), 0, i7, false);
                        this.zzaa += i7;
                        int i8 = (this.zzag >> 1) + 1;
                        int i9 = (i8 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzw;
                        if (byteBuffer == null || byteBuffer.capacity() < i9) {
                            this.zzw = ByteBuffer.allocate(i9);
                        }
                        this.zzw.position(0);
                        this.zzw.putShort((short) i8);
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            i2 = this.zzag;
                            if (i10 >= i2) {
                                break;
                            }
                            int iZzp = this.zzo.zzp();
                            int i12 = iZzp - i11;
                            if (i10 % 2 == 0) {
                                this.zzw.putShort((short) i12);
                            } else {
                                this.zzw.putInt(i12);
                            }
                            i10++;
                            i11 = iZzp;
                        }
                        int i13 = (i - this.zzaa) - i11;
                        if ((i2 & 1) == 1) {
                            this.zzw.putInt(i13);
                        } else {
                            this.zzw.putShort((short) i13);
                            this.zzw.putInt(0);
                        }
                        this.zzu.zzI(this.zzw.array(), i9);
                        zzadpVar.zzr(this.zzu, i9, 1);
                        this.zzab += i9;
                    }
                }
            } else {
                byte[] bArr = zzahiVar.zzh;
                if (bArr != null) {
                    this.zzr.zzI(bArr, bArr.length);
                }
            }
            if (!"A_OPUS".equals(zzahiVar.zzb) ? zzahiVar.zzf > 0 : z) {
                this.zzW |= 268435456;
                this.zzv.zzH(0);
                int iZze = (this.zzr.zze() + i) - this.zzaa;
                this.zzo.zzH(4);
                this.zzo.zzM()[0] = (byte) ((iZze >> 24) & 255);
                this.zzo.zzM()[1] = (byte) ((iZze >> 16) & 255);
                this.zzo.zzM()[2] = (byte) ((iZze >> 8) & 255);
                this.zzo.zzM()[3] = (byte) (iZze & 255);
                zzadpVar.zzr(this.zzo, 4, 2);
                this.zzab += 4;
            }
            this.zzad = true;
        }
        int iZze2 = this.zzr.zze() + i;
        if (!"V_MPEG4/ISO/AVC".equals(zzahiVar.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzahiVar.zzb)) {
            if (zzahiVar.zzT != null) {
                zzdi.zzf(this.zzr.zze() == 0);
                zzahiVar.zzT.zzd(zzaclVar);
            }
            while (true) {
                int i14 = this.zzaa;
                if (i14 >= iZze2) {
                    break;
                }
                int iZzr = zzr(zzaclVar, zzadpVar, iZze2 - i14);
                this.zzaa += iZzr;
                this.zzab += iZzr;
            }
        } else {
            byte[] bArrZzM = this.zzn.zzM();
            bArrZzM[0] = 0;
            bArrZzM[1] = 0;
            bArrZzM[2] = 0;
            int i15 = zzahiVar.zzX;
            int i16 = 4 - i15;
            while (this.zzaa < iZze2) {
                int i17 = this.zzac;
                if (i17 == 0) {
                    int iMin = Math.min(i15, this.zzr.zzb());
                    ((zzaby) zzaclVar).zzn(bArrZzM, i16 + iMin, i15 - iMin, false);
                    if (iMin > 0) {
                        this.zzr.zzG(bArrZzM, i16, iMin);
                    }
                    this.zzaa += i15;
                    this.zzn.zzK(0);
                    this.zzac = this.zzn.zzp();
                    this.zzm.zzK(0);
                    zzadpVar.zzq(this.zzm, 4);
                    this.zzab += 4;
                } else {
                    int iZzr2 = zzr(zzaclVar, zzadpVar, i17);
                    this.zzaa += iZzr2;
                    this.zzab += iZzr2;
                    this.zzac -= iZzr2;
                }
            }
        }
        if ("A_VORBIS".equals(zzahiVar.zzb)) {
            this.zzp.zzK(0);
            zzadpVar.zzq(this.zzp, 4);
            this.zzab += 4;
        }
        int i18 = this.zzab;
        zzx();
        return i18;
    }

    private final int zzr(zzacl zzaclVar, zzadp zzadpVar, int i) {
        int iZzb = this.zzr.zzb();
        if (iZzb <= 0) {
            return zzadpVar.zzf(zzaclVar, i, false);
        }
        int iMin = Math.min(i, iZzb);
        zzadpVar.zzq(this.zzr, iMin);
        return iMin;
    }

    private final long zzs(long j) throws zzbo {
        long j2 = this.zzz;
        if (j2 != -9223372036854775807L) {
            return zzet.zzt(j, j2, 1000L, RoundingMode.FLOOR);
        }
        throw zzbo.zza("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private final void zzt(int i) throws zzbo {
        if (this.zzK == null || this.zzL == null) {
            throw zzbo.zza("Element " + i + " must be in a Cues", null);
        }
    }

    private final void zzu(int i) throws zzbo {
        if (this.zzC != null) {
            return;
        }
        throw zzbo.zza("Element " + i + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e0 A[EDGE_INSN: B:62:0x00e0->B:51:0x00e0 BREAK  A[LOOP:0: B:45:0x00c5->B:50:0x00dd], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzv(com.google.android.gms.internal.ads.zzahi r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahj.zzv(com.google.android.gms.internal.ads.zzahi, long, int, int, int):void");
    }

    private final void zzw(zzacl zzaclVar, int i) throws EOFException, InterruptedIOException {
        if (this.zzo.zze() >= i) {
            return;
        }
        if (this.zzo.zzc() < i) {
            zzek zzekVar = this.zzo;
            int iZzc = zzekVar.zzc();
            zzekVar.zzE(Math.max(iZzc + iZzc, i));
        }
        zzek zzekVar2 = this.zzo;
        ((zzaby) zzaclVar).zzn(zzekVar2.zzM(), zzekVar2.zze(), i - zzekVar2.zze(), false);
        this.zzo.zzJ(i);
    }

    private final void zzx() {
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = 0;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = false;
        this.zzag = 0;
        this.zzah = (byte) 0;
        this.zzai = false;
        this.zzr.zzH(0);
    }

    private final void zzy(zzacl zzaclVar, byte[] bArr, int i) throws EOFException, InterruptedIOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.zzs.zzc() < i2) {
            zzek zzekVar = this.zzs;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2 + i);
            zzekVar.zzI(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzs.zzM(), 0, length);
        }
        ((zzaby) zzaclVar).zzn(this.zzs.zzM(), length, i, false);
        this.zzs.zzK(0);
        this.zzs.zzJ(i2);
    }

    private static byte[] zzz(long j, String str, long j2) {
        zzdi.zzd(j != -9223372036854775807L);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer numValueOf = Integer.valueOf(i);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer numValueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        String str2 = String.format(locale, str, numValueOf, numValueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2)));
        int i4 = zzet.zza;
        return str2.getBytes(zzfuj.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) {
        this.zzN = false;
        while (!this.zzN) {
            if (!this.zzg.zzc(zzaclVar)) {
                for (int i = 0; i < this.zzi.size(); i++) {
                    zzahi zzahiVar = (zzahi) this.zzi.valueAt(i);
                    zzahiVar.zzW.getClass();
                    zzadq zzadqVar = zzahiVar.zzT;
                    if (zzadqVar != null) {
                        zzadqVar.zza(zzahiVar.zzW, zzahiVar.zzi);
                    }
                }
                return -1;
            }
            long jZzf = zzaclVar.zzf();
            if (this.zzG) {
                this.zzI = jZzf;
                zzadfVar.zza = this.zzH;
                this.zzG = false;
                return 1;
            }
            if (this.zzD) {
                long j = this.zzI;
                if (j != -1) {
                    zzadfVar.zza = j;
                    this.zzI = -1L;
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzaj = zzacnVar;
        if (this.zzk) {
            zzacnVar = new zzakc(zzacnVar, this.zzl);
        }
        this.zzaj = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    public final void zzh(int i, int i2, zzacl zzaclVar) {
        char c;
        char c2;
        long j;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        int i8 = 0;
        if (i7 != 161 && i7 != 163) {
            if (i7 == 165) {
                if (this.zzO != 2) {
                    return;
                }
                zzahi zzahiVar = (zzahi) this.zzi.get(this.zzU);
                if (this.zzX != 4 || !"V_VP9".equals(zzahiVar.zzb)) {
                    ((zzaby) zzaclVar).zzo(i2, false);
                    return;
                }
                this.zzv.zzH(i2);
                ((zzaby) zzaclVar).zzn(this.zzv.zzM(), 0, i2, false);
                return;
            }
            if (i7 == 16877) {
                zzu(i);
                zzahi zzahiVar2 = this.zzC;
                if (zzahiVar2.zzY != 1685485123 && zzahiVar2.zzY != 1685480259) {
                    ((zzaby) zzaclVar).zzo(i2, false);
                    return;
                }
                byte[] bArr = new byte[i2];
                zzahiVar2.zzN = bArr;
                ((zzaby) zzaclVar).zzn(bArr, 0, i2, false);
                return;
            }
            if (i7 == 16981) {
                zzu(i);
                byte[] bArr2 = new byte[i2];
                this.zzC.zzh = bArr2;
                ((zzaby) zzaclVar).zzn(bArr2, 0, i2, false);
                return;
            }
            if (i7 == 18402) {
                byte[] bArr3 = new byte[i2];
                ((zzaby) zzaclVar).zzn(bArr3, 0, i2, false);
                zzu(i);
                this.zzC.zzi = new zzado(1, bArr3, 0, 0);
                return;
            }
            if (i7 == 21419) {
                Arrays.fill(this.zzq.zzM(), (byte) 0);
                ((zzaby) zzaclVar).zzn(this.zzq.zzM(), 4 - i2, i2, false);
                this.zzq.zzK(0);
                this.zzE = (int) this.zzq.zzu();
                return;
            }
            if (i7 == 25506) {
                zzu(i);
                byte[] bArr4 = new byte[i2];
                this.zzC.zzj = bArr4;
                ((zzaby) zzaclVar).zzn(bArr4, 0, i2, false);
                return;
            }
            if (i7 != 30322) {
                throw zzbo.zza("Unexpected id: " + i7, null);
            }
            zzu(i);
            byte[] bArr5 = new byte[i2];
            this.zzC.zzv = bArr5;
            ((zzaby) zzaclVar).zzn(bArr5, 0, i2, false);
            return;
        }
        int i9 = 8;
        if (this.zzO == 0) {
            this.zzU = (int) this.zzh.zzd(zzaclVar, false, true, 8);
            this.zzV = this.zzh.zza();
            this.zzQ = -9223372036854775807L;
            this.zzO = 1;
            this.zzo.zzH(0);
        }
        zzahi zzahiVar3 = (zzahi) this.zzi.get(this.zzU);
        if (zzahiVar3 == null) {
            ((zzaby) zzaclVar).zzo(i2 - this.zzV, false);
            this.zzO = 0;
            return;
        }
        zzahiVar3.zzW.getClass();
        if (this.zzO == 1) {
            zzw(zzaclVar, 3);
            int i10 = (this.zzo.zzM()[2] & 6) >> 1;
            if (i10 == 0) {
                this.zzS = 1;
                int[] iArrZzA = zzA(this.zzT, 1);
                this.zzT = iArrZzA;
                iArrZzA[0] = (i2 - this.zzV) - 3;
            } else {
                zzw(zzaclVar, 4);
                int i11 = (this.zzo.zzM()[3] & 255) + 1;
                this.zzS = i11;
                int[] iArrZzA2 = zzA(this.zzT, i11);
                this.zzT = iArrZzA2;
                if (i10 == 2) {
                    int i12 = (i2 - this.zzV) - 4;
                    int i13 = this.zzS;
                    Arrays.fill(iArrZzA2, 0, i13, i12 / i13);
                } else {
                    if (i10 != 1) {
                        if (i10 != 3) {
                            throw zzbo.zza("Unexpected lacing value: 2", null);
                        }
                        int i14 = 4;
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            int i17 = this.zzS - 1;
                            if (i15 >= i17) {
                                c = 1;
                                c2 = 0;
                                this.zzT[i17] = ((i2 - this.zzV) - i14) - i16;
                                break;
                            }
                            this.zzT[i15] = i8;
                            int i18 = i14 + 1;
                            zzw(zzaclVar, i18);
                            if (this.zzo.zzM()[i14] == 0) {
                                throw zzbo.zza("No valid varint length mask found", null);
                            }
                            int i19 = 0;
                            while (true) {
                                if (i19 >= i9) {
                                    j = 0;
                                    break;
                                }
                                int i20 = 1 << (7 - i19);
                                if ((this.zzo.zzM()[i14] & i20) != 0) {
                                    i18 += i19;
                                    zzw(zzaclVar, i18);
                                    j = this.zzo.zzM()[i14] & 255 & (~i20);
                                    for (int i21 = i14 + 1; i21 < i18; i21++) {
                                        j = (j << 8) | ((long) (this.zzo.zzM()[i21] & 255));
                                    }
                                    if (i15 > 0) {
                                        j -= (1 << ((i19 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i19++;
                                    i9 = 8;
                                }
                            }
                            i14 = i18;
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int[] iArr = this.zzT;
                            int i22 = (int) j;
                            if (i15 != 0) {
                                i22 += iArr[i15 - 1];
                            }
                            iArr[i15] = i22;
                            i16 += i22;
                            i15++;
                            i8 = 0;
                            i9 = 8;
                        }
                        throw zzbo.zza("EBML lacing sample size out of range.", null);
                    }
                    int i23 = 0;
                    int i24 = 4;
                    int i25 = 0;
                    while (true) {
                        i3 = this.zzS - 1;
                        if (i23 >= i3) {
                            break;
                        }
                        this.zzT[i23] = 0;
                        while (true) {
                            i4 = i24 + 1;
                            zzw(zzaclVar, i4);
                            int i26 = this.zzo.zzM()[i24] & 255;
                            int[] iArr2 = this.zzT;
                            i5 = iArr2[i23] + i26;
                            iArr2[i23] = i5;
                            if (i26 != 255) {
                                break;
                            } else {
                                i24 = i4;
                            }
                        }
                        i25 += i5;
                        i23++;
                        i24 = i4;
                    }
                    this.zzT[i3] = ((i2 - this.zzV) - i24) - i25;
                }
            }
            c = 1;
            c2 = 0;
            this.zzP = this.zzJ + zzs((this.zzo.zzM()[c2] << 8) | (this.zzo.zzM()[c] & 255));
            if (zzahiVar3.zzd == 2) {
                i6 = 1;
                this.zzW = i6;
                this.zzO = 2;
                this.zzR = 0;
            } else {
                if (i7 == 163) {
                    if ((this.zzo.zzM()[2] & 128) == 128) {
                        i7 = 163;
                        i6 = 1;
                        this.zzW = i6;
                        this.zzO = 2;
                        this.zzR = 0;
                    } else {
                        i7 = 163;
                    }
                }
                i6 = 0;
                this.zzW = i6;
                this.zzO = 2;
                this.zzR = 0;
            }
        }
        if (i7 == 163) {
            while (true) {
                int i27 = this.zzR;
                if (i27 >= this.zzS) {
                    this.zzO = 0;
                    return;
                }
                int iZzq = zzq(zzaclVar, zzahiVar3, this.zzT[i27], false);
                zzahi zzahiVar4 = zzahiVar3;
                zzv(zzahiVar4, this.zzP + ((long) ((this.zzR * zzahiVar3.zze) / zzbbc.zzq.zzf)), this.zzW, iZzq, 0);
                this.zzR++;
                zzahiVar3 = zzahiVar4;
            }
        } else {
            while (true) {
                int i28 = this.zzR;
                if (i28 >= this.zzS) {
                    return;
                }
                int[] iArr3 = this.zzT;
                iArr3[i28] = zzq(zzaclVar, zzahiVar3, iArr3[i28], true);
                this.zzR++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        this.zzJ = -9223372036854775807L;
        this.zzO = 0;
        this.zzg.zzb();
        this.zzh.zze();
        zzx();
        for (int i = 0; i < this.zzi.size(); i++) {
            zzadq zzadqVar = ((zzahi) this.zzi.valueAt(i)).zzT;
            if (zzadqVar != null) {
                zzadqVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) {
        return new zzahk().zza(zzaclVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0318  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzk(int r22) {
        /*
            Method dump skipped, instruction units count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahj.zzk(int):void");
    }

    public final void zzl(int i, double d) {
        if (i == 181) {
            zzu(i);
            this.zzC.zzQ = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzA = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                zzu(i);
                this.zzC.zzD = (float) d;
                break;
            case 21970:
                zzu(i);
                this.zzC.zzE = (float) d;
                break;
            case 21971:
                zzu(i);
                this.zzC.zzF = (float) d;
                break;
            case 21972:
                zzu(i);
                this.zzC.zzG = (float) d;
                break;
            case 21973:
                zzu(i);
                this.zzC.zzH = (float) d;
                break;
            case 21974:
                zzu(i);
                this.zzC.zzI = (float) d;
                break;
            case 21975:
                zzu(i);
                this.zzC.zzJ = (float) d;
                break;
            case 21976:
                zzu(i);
                this.zzC.zzK = (float) d;
                break;
            case 21977:
                zzu(i);
                this.zzC.zzL = (float) d;
                break;
            case 21978:
                zzu(i);
                this.zzC.zzM = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        zzu(i);
                        this.zzC.zzs = (float) d;
                        break;
                    case 30324:
                        zzu(i);
                        this.zzC.zzt = (float) d;
                        break;
                    case 30325:
                        zzu(i);
                        this.zzC.zzu = (float) d;
                        break;
                }
                break;
        }
    }

    public final void zzm(int i, long j) {
        boolean z;
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw zzbo.zza("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw zzbo.zza("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                zzu(i);
                this.zzC.zzd = (int) j;
                return;
            case 136:
                z = j == 1;
                zzu(i);
                this.zzC.zzV = z;
                return;
            case 155:
                this.zzQ = zzs(j);
                return;
            case 159:
                zzu(i);
                this.zzC.zzO = (int) j;
                return;
            case 176:
                zzu(i);
                this.zzC.zzl = (int) j;
                return;
            case 179:
                zzt(i);
                this.zzK.zzc(zzs(j));
                return;
            case 186:
                zzu(i);
                this.zzC.zzm = (int) j;
                return;
            case 215:
                zzu(i);
                this.zzC.zzc = (int) j;
                return;
            case 231:
                this.zzJ = zzs(j);
                return;
            case 238:
                this.zzX = (int) j;
                return;
            case 241:
                if (this.zzM) {
                    return;
                }
                zzt(i);
                this.zzL.zzc(j);
                this.zzM = true;
                return;
            case 251:
                this.zzY = true;
                return;
            case 16871:
                zzu(i);
                this.zzC.zzY = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw zzbo.zza("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw zzbo.zza("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw zzbo.zza("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw zzbo.zza("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw zzbo.zza("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.zzF = j + this.zzy;
                return;
            case 21432:
                int i2 = (int) j;
                zzu(i);
                if (i2 == 0) {
                    this.zzC.zzw = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzC.zzw = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzC.zzw = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzC.zzw = 3;
                    return;
                }
            case 21680:
                zzu(i);
                this.zzC.zzo = (int) j;
                return;
            case 21682:
                zzu(i);
                this.zzC.zzq = (int) j;
                return;
            case 21690:
                zzu(i);
                this.zzC.zzp = (int) j;
                return;
            case 21930:
                z = j == 1;
                zzu(i);
                this.zzC.zzU = z;
                return;
            case 21938:
                zzu(i);
                zzahi zzahiVar = this.zzC;
                zzahiVar.zzx = true;
                zzahiVar.zzn = (int) j;
                return;
            case 21998:
                zzu(i);
                this.zzC.zzf = (int) j;
                return;
            case 22186:
                zzu(i);
                this.zzC.zzR = j;
                return;
            case 22203:
                zzu(i);
                this.zzC.zzS = j;
                return;
            case 25188:
                zzu(i);
                this.zzC.zzP = (int) j;
                return;
            case 30114:
                this.zzZ = j;
                return;
            case 30321:
                int i3 = (int) j;
                zzu(i);
                if (i3 == 0) {
                    this.zzC.zzr = 0;
                    return;
                }
                if (i3 == 1) {
                    this.zzC.zzr = 1;
                    return;
                } else if (i3 == 2) {
                    this.zzC.zzr = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.zzC.zzr = 3;
                    return;
                }
            case 2352003:
                zzu(i);
                this.zzC.zze = (int) j;
                return;
            case 2807729:
                this.zzz = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i4 = (int) j;
                        zzu(i);
                        if (i4 == 1) {
                            this.zzC.zzA = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.zzC.zzA = 1;
                            return;
                        }
                    case 21946:
                        zzu(i);
                        int iZzb = zzo.zzb((int) j);
                        if (iZzb != -1) {
                            this.zzC.zzz = iZzb;
                            return;
                        }
                        return;
                    case 21947:
                        zzu(i);
                        this.zzC.zzx = true;
                        int iZza = zzo.zza((int) j);
                        if (iZza != -1) {
                            this.zzC.zzy = iZza;
                            return;
                        }
                        return;
                    case 21948:
                        zzu(i);
                        this.zzC.zzB = (int) j;
                        return;
                    case 21949:
                        zzu(i);
                        this.zzC.zzC = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    public final void zzn(int i, long j, long j2) {
        zzdi.zzb(this.zzaj);
        if (i == 160) {
            this.zzY = false;
            this.zzZ = 0L;
            return;
        }
        if (i == 174) {
            this.zzC = new zzahi();
            return;
        }
        if (i == 187) {
            this.zzM = false;
            return;
        }
        if (i == 19899) {
            this.zzE = -1;
            this.zzF = -1L;
            return;
        }
        if (i == 20533) {
            zzu(i);
            this.zzC.zzg = true;
            return;
        }
        if (i == 21968) {
            zzu(i);
            this.zzC.zzx = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.zzy;
            if (j3 != -1 && j3 != j) {
                throw zzbo.zza("Multiple Segment elements not supported", null);
            }
            this.zzy = j;
            this.zzx = j2;
            return;
        }
        if (i == 475249515) {
            this.zzK = new zzeb(32);
            this.zzL = new zzeb(32);
        } else if (i == 524531317 && !this.zzD) {
            if (this.zzj && this.zzH != -1) {
                this.zzG = true;
            } else {
                this.zzaj.zzO(new zzadh(this.zzB, 0L));
                this.zzD = true;
            }
        }
    }

    public final void zzo(int i, String str) {
        if (i == 134) {
            zzu(i);
            this.zzC.zzb = str;
            return;
        }
        if (i == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            throw zzbo.zza("DocType " + str + " not supported", null);
        }
        if (i == 21358) {
            zzu(i);
            this.zzC.zza = str;
        } else {
            if (i != 2274716) {
                return;
            }
            zzu(i);
            this.zzC.zzZ = str;
        }
    }

    public zzahj(zzahf zzahfVar, int i, zzajy zzajyVar) {
        this.zzy = -1L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzH = -1L;
        this.zzI = -1L;
        this.zzJ = -9223372036854775807L;
        this.zzg = zzahfVar;
        zzahfVar.zza(new zzahh(this, null));
        this.zzl = zzajyVar;
        this.zzj = 1 == ((i & 1) ^ 1);
        this.zzk = (i & 2) == 0;
        this.zzh = new zzahl();
        this.zzi = new SparseArray();
        this.zzo = new zzek(4);
        this.zzp = new zzek(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzq = new zzek(4);
        this.zzm = new zzek(zzfh.zza);
        this.zzn = new zzek(4);
        this.zzr = new zzek();
        this.zzs = new zzek();
        this.zzt = new zzek(8);
        this.zzu = new zzek();
        this.zzv = new zzek();
        this.zzT = new int[1];
    }

    public zzahj(zzajy zzajyVar, int i) {
        this(new zzahd(), 0, zzajyVar);
    }
}
