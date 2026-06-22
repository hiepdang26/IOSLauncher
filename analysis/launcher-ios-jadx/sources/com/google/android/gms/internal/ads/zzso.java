package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzso extends zzhm {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private long zzG;
    private int zzH;
    private int zzI;
    private ByteBuffer zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private long zzW;
    private long zzX;
    private boolean zzY;
    private boolean zzZ;
    protected zzhn zza;
    private boolean zzaa;
    private zzsn zzab;
    private long zzac;
    private boolean zzad;
    private zzrj zzae;
    private zzrj zzaf;
    private final zzsa zzc;
    private final zzsq zzd;
    private final float zze;
    private final zzhd zzf;
    private final zzhd zzg;
    private final zzhd zzh;
    private final zzrx zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzqw zzl;
    private zzaf zzm;
    private zzaf zzn;
    private zzld zzo;
    private MediaCrypto zzp;
    private float zzq;
    private zzsc zzr;
    private zzaf zzs;
    private MediaFormat zzt;
    private boolean zzu;
    private float zzv;
    private ArrayDeque zzw;
    private zzsk zzx;
    private zzsf zzy;
    private int zzz;

    public zzso(int i, zzsa zzsaVar, zzsq zzsqVar, boolean z, float f) {
        super(i);
        this.zzc = zzsaVar;
        this.zzd = zzsqVar;
        this.zze = f;
        this.zzf = new zzhd(0, 0);
        this.zzg = new zzhd(0, 0);
        this.zzh = new zzhd(2, 0);
        zzrx zzrxVar = new zzrx();
        this.zzi = zzrxVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzq = 1.0f;
        this.zzk = new ArrayDeque();
        this.zzab = zzsn.zza;
        zzrxVar.zzi(0);
        zzrxVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzqw();
        this.zzv = -1.0f;
        this.zzz = 0;
        this.zzQ = 0;
        this.zzH = -1;
        this.zzI = -1;
        this.zzG = -9223372036854775807L;
        this.zzW = -9223372036854775807L;
        this.zzX = -9223372036854775807L;
        this.zzac = -9223372036854775807L;
        this.zzR = 0;
        this.zzS = 0;
        this.zza = new zzhn();
    }

    public static boolean zzaN(zzaf zzafVar) {
        return zzafVar.zzG == 0;
    }

    private final void zzaO() {
        this.zzH = -1;
        this.zzg.zzc = null;
    }

    private final void zzaP() {
        this.zzI = -1;
        this.zzJ = null;
    }

    private final void zzaQ(zzsn zzsnVar) {
        this.zzab = zzsnVar;
        if (zzsnVar.zzd != -9223372036854775807L) {
            this.zzad = true;
        }
    }

    private final void zzaR() {
        zzrj zzrjVar = this.zzaf;
        zzrjVar.getClass();
        this.zzae = zzrjVar;
        this.zzR = 0;
        this.zzS = 0;
    }

    private final boolean zzaS() {
        if (this.zzT) {
            this.zzR = 1;
            if (this.zzB) {
                this.zzS = 3;
                return false;
            }
            this.zzS = 2;
        } else {
            zzaR();
        }
        return true;
    }

    private final boolean zzaT() throws zzhw {
        zzsc zzscVar = this.zzr;
        if (zzscVar == null || this.zzR == 2 || this.zzY) {
            return false;
        }
        if (this.zzH < 0) {
            int iZza = zzscVar.zza();
            this.zzH = iZza;
            if (iZza < 0) {
                return false;
            }
            this.zzg.zzc = zzscVar.zzf(iZza);
            this.zzg.zzb();
        }
        if (this.zzR == 1) {
            if (!this.zzF) {
                this.zzU = true;
                zzscVar.zzj(this.zzH, 0, 0, 0L, 4);
                zzaO();
            }
            this.zzR = 2;
            return false;
        }
        if (this.zzD) {
            this.zzD = false;
            ByteBuffer byteBuffer = this.zzg.zzc;
            byteBuffer.getClass();
            byteBuffer.put(zzb);
            zzscVar.zzj(this.zzH, 0, 38, 0L, 0);
            zzaO();
            this.zzT = true;
            return true;
        }
        if (this.zzQ == 1) {
            int i = 0;
            while (true) {
                zzaf zzafVar = this.zzs;
                zzafVar.getClass();
                if (i >= zzafVar.zzo.size()) {
                    break;
                }
                byte[] bArr = (byte[]) this.zzs.zzo.get(i);
                ByteBuffer byteBuffer2 = this.zzg.zzc;
                byteBuffer2.getClass();
                byteBuffer2.put(bArr);
                i++;
            }
            this.zzQ = 2;
        }
        ByteBuffer byteBuffer3 = this.zzg.zzc;
        byteBuffer3.getClass();
        int iPosition = byteBuffer3.position();
        zzjz zzjzVarZzcY = zzcY();
        try {
            int iZzcW = zzcW(zzjzVarZzcY, this.zzg, 0);
            if (iZzcW == -3) {
                if (zzQ()) {
                    this.zzX = this.zzW;
                }
                return false;
            }
            if (iZzcW == -5) {
                if (this.zzQ == 2) {
                    this.zzg.zzb();
                    this.zzQ = 1;
                }
                zzac(zzjzVarZzcY);
                return true;
            }
            zzhd zzhdVar = this.zzg;
            if (zzhdVar.zzf()) {
                this.zzX = this.zzW;
                if (this.zzQ == 2) {
                    zzhdVar.zzb();
                    this.zzQ = 1;
                }
                this.zzY = true;
                if (!this.zzT) {
                    zzao();
                    return false;
                }
                try {
                    if (!this.zzF) {
                        this.zzU = true;
                        zzscVar.zzj(this.zzH, 0, 0, 0L, 4);
                        zzaO();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw zzi(e, this.zzm, false, zzet.zzj(e.getErrorCode()));
                }
            }
            if (!this.zzT && !zzhdVar.zzg()) {
                zzhdVar.zzb();
                if (this.zzQ == 2) {
                    this.zzQ = 1;
                }
                return true;
            }
            boolean zZzk = zzhdVar.zzk();
            if (zZzk) {
                zzhdVar.zzb.zzb(iPosition);
            }
            long j = this.zzg.zze;
            if (this.zzaa) {
                if (this.zzk.isEmpty()) {
                    zzeq zzeqVar = this.zzab.zze;
                    zzaf zzafVar2 = this.zzm;
                    zzafVar2.getClass();
                    zzeqVar.zzd(j, zzafVar2);
                } else {
                    zzeq zzeqVar2 = ((zzsn) this.zzk.peekLast()).zze;
                    zzaf zzafVar3 = this.zzm;
                    zzafVar3.getClass();
                    zzeqVar2.zzd(j, zzafVar3);
                }
                this.zzaa = false;
            }
            long jMax = Math.max(this.zzW, j);
            this.zzW = jMax;
            if (zzQ() || this.zzg.zzh()) {
                this.zzX = jMax;
            }
            this.zzg.zzj();
            zzhd zzhdVar2 = this.zzg;
            if (zzhdVar2.zze()) {
                zzaj(zzhdVar2);
            }
            zzaD(this.zzg);
            zzat(this.zzg);
            try {
                if (zZzk) {
                    zzscVar.zzk(this.zzH, 0, this.zzg.zzb, j, 0);
                } else {
                    int i2 = this.zzH;
                    ByteBuffer byteBuffer4 = this.zzg.zzc;
                    if (byteBuffer4 == null) {
                        throw null;
                    }
                    zzscVar.zzj(i2, 0, byteBuffer4.limit(), j, 0);
                }
                zzaO();
                this.zzT = true;
                this.zzQ = 0;
                this.zza.zzc++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw zzi(e2, this.zzm, false, zzet.zzj(e2.getErrorCode()));
            }
        } catch (zzhc e3) {
            zzak(e3);
            zzaW(0);
            zzah();
            return true;
        }
    }

    private final boolean zzaU() {
        return this.zzI >= 0;
    }

    private final boolean zzaV(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzaf zzafVar = this.zzn;
        return (zzafVar != null && Objects.equals(zzafVar.zzm, "audio/opus") && zzade.zzf(j, j2)) ? false : true;
    }

    private final boolean zzaW(int i) {
        zzhd zzhdVar = this.zzf;
        zzjz zzjzVarZzcY = zzcY();
        zzhdVar.zzb();
        int iZzcW = zzcW(zzjzVarZzcY, this.zzf, i | 4);
        if (iZzcW == -5) {
            zzac(zzjzVarZzcY);
            return true;
        }
        if (iZzcW != -4 || !this.zzf.zzf()) {
            return false;
        }
        this.zzY = true;
        zzao();
        return false;
    }

    private final boolean zzaX(zzaf zzafVar) {
        if (zzet.zza >= 23 && this.zzr != null && this.zzS != 3 && zzcV() != 0) {
            float f = this.zzq;
            zzafVar.getClass();
            float fZzZ = zzZ(f, zzafVar, zzT());
            float f2 = this.zzv;
            if (f2 != fZzZ) {
                if (fZzZ == -1.0f) {
                    zzae();
                    return false;
                }
                if (f2 != -1.0f || fZzZ > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzZ);
                    zzsc zzscVar = this.zzr;
                    zzscVar.getClass();
                    zzscVar.zzp(bundle);
                    this.zzv = fZzZ;
                }
            }
        }
        return true;
    }

    private final void zzad() {
        this.zzO = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzN = false;
        this.zzM = false;
        this.zzl.zzb();
    }

    private final void zzae() {
        if (this.zzT) {
            this.zzR = 1;
            this.zzS = 3;
        } else {
            zzaF();
            zzaB();
        }
    }

    private final void zzah() {
        try {
            zzsc zzscVar = this.zzr;
            zzdi.zzb(zzscVar);
            zzscVar.zzi();
        } finally {
            zzaG();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x030c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzai(com.google.android.gms.internal.ads.zzsf r19, android.media.MediaCrypto r20) {
        /*
            Method dump skipped, instruction units count: 1013
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zzai(com.google.android.gms.internal.ads.zzsf, android.media.MediaCrypto):void");
    }

    private final void zzao() {
        int i = this.zzS;
        if (i == 1) {
            zzah();
            return;
        }
        if (i == 2) {
            zzah();
            zzaR();
        } else if (i != 3) {
            this.zzZ = true;
            zzaq();
        } else {
            zzaF();
            zzaB();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public void zzC() {
        try {
            zzad();
            zzaF();
        } finally {
            this.zzaf = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r4 >= r0) goto L14;
     */
    @Override // com.google.android.gms.internal.ads.zzhm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzF(com.google.android.gms.internal.ads.zzaf[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzui r18) {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzsn r13 = r12.zzab
            long r0 = r13.zzd
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L1e
            com.google.android.gms.internal.ads.zzsn r4 = new com.google.android.gms.internal.ads.zzsn
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r14
            r9 = r16
            r4.<init>(r5, r7, r9)
            r12.zzaQ(r4)
            return
        L1e:
            java.util.ArrayDeque r13 = r12.zzk
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L52
            long r0 = r12.zzW
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L36
            long r4 = r12.zzac
            int r13 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r13 == 0) goto L52
            int r13 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r13 < 0) goto L52
        L36:
            com.google.android.gms.internal.ads.zzsn r5 = new com.google.android.gms.internal.ads.zzsn
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaQ(r5)
            com.google.android.gms.internal.ads.zzsn r13 = r12.zzab
            long r0 = r13.zzd
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L51
            r12.zzap()
        L51:
            return
        L52:
            java.util.ArrayDeque r13 = r12.zzk
            com.google.android.gms.internal.ads.zzsn r5 = new com.google.android.gms.internal.ads.zzsn
            long r6 = r12.zzW
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r13.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zzF(com.google.android.gms.internal.ads.zzaf[], long, long, com.google.android.gms.internal.ads.zzui):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzle
    public void zzM(float f, float f2) {
        this.zzq = f2;
        zzaX(this.zzs);
    }

    /* JADX WARN: Code restructure failed: missing block: B:205:0x032e, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0330, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        throw r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01cb A[Catch: IllegalStateException -> 0x000b, TryCatch #9 {IllegalStateException -> 0x000b, blocks: (B:3:0x0003, B:5:0x0007, B:9:0x0010, B:11:0x0015, B:13:0x001b, B:34:0x0083, B:116:0x01e0, B:41:0x0097, B:45:0x009f, B:47:0x00a3, B:49:0x00ab, B:53:0x00bb, B:54:0x00ca, B:58:0x00db, B:60:0x00e1, B:106:0x01c3, B:108:0x01cb, B:109:0x01ce, B:111:0x01d6, B:113:0x01da, B:61:0x00e7, B:63:0x00ef, B:64:0x00f7, B:66:0x0107, B:69:0x0111, B:72:0x0117, B:74:0x011b, B:76:0x0125, B:78:0x012f, B:80:0x0141, B:81:0x014f, B:82:0x0150, B:83:0x0158, B:84:0x0159, B:86:0x0162, B:88:0x016a, B:90:0x0172, B:91:0x0179, B:93:0x0187, B:95:0x018d, B:96:0x0193, B:97:0x0194, B:102:0x01b3, B:104:0x01bd, B:100:0x019d, B:68:0x010f, B:105:0x01c0, B:119:0x01eb, B:126:0x0206, B:128:0x020a, B:140:0x022e, B:142:0x0234, B:144:0x023c, B:146:0x0246, B:148:0x024e, B:149:0x0251, B:150:0x0256, B:151:0x0257, B:154:0x025c, B:156:0x0260, B:158:0x0264, B:159:0x0268, B:161:0x026c, B:162:0x0272, B:164:0x0278, B:166:0x027e, B:167:0x0282, B:169:0x028c, B:170:0x029f, B:174:0x02ae, B:176:0x02bb, B:180:0x02c6, B:182:0x02d8, B:184:0x02dc, B:186:0x02e0, B:188:0x02ec, B:193:0x02f7, B:195:0x02fb, B:196:0x0305, B:189:0x02ef, B:191:0x02f3, B:132:0x0215, B:134:0x021c, B:136:0x0223, B:130:0x020e), top: B:276:0x0003, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x033a A[Catch: IllegalStateException -> 0x033e, TryCatch #0 {IllegalStateException -> 0x033e, blocks: (B:224:0x0382, B:226:0x0388, B:220:0x0367, B:222:0x0379, B:208:0x0333, B:210:0x033a, B:216:0x034a, B:218:0x035c, B:227:0x038d, B:229:0x0390, B:230:0x0391), top: B:259:0x01ef }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:302:? A[LOOP:1: B:224:0x0382->B:302:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8  */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.media.MediaFormat, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzso] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v32, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v37 */
    @Override // com.google.android.gms.internal.ads.zzle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zzV(long r19, long r21) {
        /*
            Method dump skipped, instruction units count: 1011
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zzV(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public boolean zzW() {
        return this.zzZ;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public boolean zzX() {
        if (this.zzm == null) {
            return false;
        }
        if (zzS() || zzaU()) {
            return true;
        }
        if (this.zzG == -9223372036854775807L) {
            return false;
        }
        zzh();
        return SystemClock.elapsedRealtime() < this.zzG;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final int zzY(zzaf zzafVar) throws zzhw {
        try {
            return zzaa(this.zzd, zzafVar);
        } catch (zzsw e) {
            throw zzi(e, zzafVar, false, 4002);
        }
    }

    public float zzZ(float f, zzaf zzafVar, zzaf[] zzafVarArr) {
        throw null;
    }

    public final zzsf zzaA() {
        return this.zzy;
    }

    public final void zzaB() {
        zzaf zzafVar;
        if (this.zzr != null || this.zzM || (zzafVar = this.zzm) == null) {
            return;
        }
        if (zzaL(zzafVar)) {
            zzad();
            String str = zzafVar.zzm;
            if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                this.zzi.zzn(32);
            } else {
                this.zzi.zzn(1);
            }
            this.zzM = true;
            return;
        }
        zzrj zzrjVar = this.zzaf;
        this.zzae = zzrjVar;
        if (zzrjVar != null) {
            zzdi.zzf(true);
            zzrj zzrjVar2 = this.zzae;
            boolean z = zzrk.zza;
            zzrjVar2.zza();
        }
        try {
            if (this.zzae != null) {
                zzdi.zzb(zzafVar.zzm);
            }
            zzaf zzafVar2 = this.zzm;
            if (zzafVar2 == null) {
                throw null;
            }
            if (this.zzw == null) {
                try {
                    List listZzag = zzag(this.zzd, zzafVar2, false);
                    listZzag.isEmpty();
                    this.zzw = new ArrayDeque();
                    if (!listZzag.isEmpty()) {
                        this.zzw.add((zzsf) listZzag.get(0));
                    }
                    this.zzx = null;
                } catch (zzsw e) {
                    throw new zzsk(zzafVar2, (Throwable) e, false, -49998);
                }
            }
            if (this.zzw.isEmpty()) {
                throw new zzsk(zzafVar2, (Throwable) null, false, -49999);
            }
            ArrayDeque arrayDeque = this.zzw;
            if (arrayDeque == null) {
                throw null;
            }
            zzsf zzsfVar = (zzsf) arrayDeque.peekFirst();
            while (this.zzr == null) {
                zzsf zzsfVar2 = (zzsf) arrayDeque.peekFirst();
                if (zzsfVar2 == null) {
                    throw null;
                }
                if (!zzaM(zzsfVar2)) {
                    return;
                }
                try {
                    zzai(zzsfVar2, null);
                } catch (Exception e2) {
                    if (zzsfVar2 != zzsfVar) {
                        throw e2;
                    }
                    try {
                        zzea.zzf("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                        Thread.sleep(50L);
                        zzai(zzsfVar2, null);
                    } catch (Exception e3) {
                        zzea.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zzsfVar2.zza), e3);
                        arrayDeque.removeFirst();
                        zzsk zzskVar = new zzsk(zzafVar2, (Throwable) e3, false, zzsfVar2);
                        zzak(zzskVar);
                        zzsk zzskVar2 = this.zzx;
                        if (zzskVar2 == null) {
                            this.zzx = zzskVar;
                        } else {
                            this.zzx = zzsk.zza(zzskVar2, zzskVar);
                        }
                        if (arrayDeque.isEmpty()) {
                            throw this.zzx;
                        }
                    }
                }
            }
            this.zzw = null;
        } catch (zzsk e4) {
            throw zzi(e4, zzafVar, false, 4001);
        }
    }

    public void zzaC(long j) {
        this.zzac = j;
        while (!this.zzk.isEmpty() && j >= ((zzsn) this.zzk.peek()).zzb) {
            zzsn zzsnVar = (zzsn) this.zzk.poll();
            zzsnVar.getClass();
            zzaQ(zzsnVar);
            zzap();
        }
    }

    public void zzaD(zzhd zzhdVar) {
    }

    public void zzaE(zzaf zzafVar) {
    }

    public final void zzaF() {
        try {
            zzsc zzscVar = this.zzr;
            if (zzscVar != null) {
                zzscVar.zzl();
                this.zza.zzb++;
                zzsf zzsfVar = this.zzy;
                if (zzsfVar == null) {
                    throw null;
                }
                zzam(zzsfVar.zza);
            }
            this.zzr = null;
            this.zzp = null;
            this.zzae = null;
            zzaH();
        } catch (Throwable th) {
            this.zzr = null;
            this.zzp = null;
            this.zzae = null;
            zzaH();
            throw th;
        }
    }

    public void zzaG() {
        zzaO();
        zzaP();
        this.zzG = -9223372036854775807L;
        this.zzU = false;
        this.zzT = false;
        this.zzD = false;
        this.zzE = false;
        this.zzK = false;
        this.zzL = false;
        this.zzW = -9223372036854775807L;
        this.zzX = -9223372036854775807L;
        this.zzac = -9223372036854775807L;
        this.zzR = 0;
        this.zzS = 0;
        this.zzQ = this.zzP ? 1 : 0;
    }

    public final void zzaH() {
        zzaG();
        this.zzw = null;
        this.zzy = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = false;
        this.zzV = false;
        this.zzv = -1.0f;
        this.zzz = 0;
        this.zzA = false;
        this.zzB = false;
        this.zzC = false;
        this.zzF = false;
        this.zzP = false;
        this.zzQ = 0;
    }

    public final boolean zzaI() {
        boolean zZzaJ = zzaJ();
        if (zZzaJ) {
            zzaB();
        }
        return zZzaJ;
    }

    public final boolean zzaJ() {
        if (this.zzr == null) {
            return false;
        }
        int i = this.zzS;
        if (i == 3 || ((this.zzA && !this.zzV) || (this.zzB && this.zzU))) {
            zzaF();
            return true;
        }
        if (i == 2) {
            int i2 = zzet.zza;
            zzdi.zzf(i2 >= 23);
            if (i2 >= 23) {
                try {
                    zzaR();
                } catch (zzhw e) {
                    zzea.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzaF();
                    return true;
                }
            }
        }
        zzah();
        return false;
    }

    public final boolean zzaK() {
        return this.zzM;
    }

    public final boolean zzaL(zzaf zzafVar) {
        return this.zzaf == null && zzas(zzafVar);
    }

    public boolean zzaM(zzsf zzsfVar) {
        return true;
    }

    public abstract int zzaa(zzsq zzsqVar, zzaf zzafVar);

    public zzho zzab(zzsf zzsfVar, zzaf zzafVar, zzaf zzafVar2) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.ads.zzho zzac(com.google.android.gms.internal.ads.zzjz r12) {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zzac(com.google.android.gms.internal.ads.zzjz):com.google.android.gms.internal.ads.zzho");
    }

    public abstract zzrz zzaf(zzsf zzsfVar, zzaf zzafVar, MediaCrypto mediaCrypto, float f);

    public abstract List zzag(zzsq zzsqVar, zzaf zzafVar, boolean z);

    public void zzaj(zzhd zzhdVar) {
        throw null;
    }

    public void zzak(Exception exc) {
        throw null;
    }

    public void zzal(String str, zzrz zzrzVar, long j, long j2) {
        throw null;
    }

    public void zzam(String str) {
        throw null;
    }

    public void zzan(zzaf zzafVar, MediaFormat mediaFormat) {
        throw null;
    }

    public void zzap() {
    }

    public void zzaq() {
    }

    public abstract boolean zzar(long j, long j2, zzsc zzscVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzafVar);

    public boolean zzas(zzaf zzafVar) {
        return false;
    }

    public int zzat(zzhd zzhdVar) {
        return 0;
    }

    public final long zzau() {
        return this.zzab.zzd;
    }

    public final long zzav() {
        return this.zzab.zzc;
    }

    public final zzld zzax() {
        return this.zzo;
    }

    public final zzsc zzay() {
        return this.zzr;
    }

    public zzse zzaz(Throwable th, zzsf zzsfVar) {
        return new zzse(th, zzsfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzlh
    public final int zze() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzkz
    public void zzt(int i, Object obj) {
        if (i == 11) {
            this.zzo = (zzld) obj;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public void zzw() {
        this.zzm = null;
        zzaQ(zzsn.zza);
        this.zzk.clear();
        zzaJ();
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public void zzx(boolean z, boolean z2) {
        this.zza = new zzhn();
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public void zzz(long j, boolean z) {
        this.zzY = false;
        this.zzZ = false;
        if (this.zzM) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzN = false;
            this.zzl.zzb();
        } else {
            zzaI();
        }
        zzeq zzeqVar = this.zzab.zze;
        if (zzeqVar.zza() > 0) {
            this.zzaa = true;
        }
        zzeqVar.zze();
        this.zzk.clear();
    }
}
