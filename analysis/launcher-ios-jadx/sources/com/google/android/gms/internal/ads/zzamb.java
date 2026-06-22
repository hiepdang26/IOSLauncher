package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzamb implements zzamf {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzej zzc = new zzej(new byte[7], 7);
    private final zzek zzd = new zzek(Arrays.copyOf(zza, 10));
    private final String zze;
    private final int zzf;
    private String zzg;
    private zzadp zzh;
    private zzadp zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private zzadp zzv;
    private long zzw;

    public zzamb(boolean z, String str, int i) {
        zzh();
        this.zzo = -1;
        this.zzp = -1;
        this.zzs = -9223372036854775807L;
        this.zzu = -9223372036854775807L;
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzn = false;
        zzh();
    }

    private final void zzh() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
    }

    private final void zzi() {
        this.zzj = 3;
        this.zzk = 0;
    }

    private final void zzj(zzadp zzadpVar, long j, int i, int i2) {
        this.zzj = 4;
        this.zzk = i;
        this.zzv = zzadpVar;
        this.zzw = j;
        this.zzt = i2;
    }

    private final boolean zzk(zzek zzekVar, byte[] bArr, int i) {
        int iMin = Math.min(zzekVar.zzb(), i - this.zzk);
        zzekVar.zzG(bArr, this.zzk, iMin);
        int i2 = this.zzk + iMin;
        this.zzk = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | 65280);
    }

    private static final boolean zzm(zzek zzekVar, byte[] bArr, int i) {
        if (zzekVar.zzb() < i) {
            return false;
        }
        zzekVar.zzG(bArr, 0, i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0275, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0276, code lost:
    
        r20.zzm = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x027a, code lost:
    
        if (r20.zzn != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x027c, code lost:
    
        r20.zzj = 1;
        r20.zzk = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0282, code lost:
    
        zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0285, code lost:
    
        r21.zzK(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0268, code lost:
    
        r20.zzq = (r14 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0271, code lost:
    
        if (1 == ((r14 & 1) ^ 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0273, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d1  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r21) {
        /*
            Method dump skipped, instruction units count: 737
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamb.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zzg = zzansVar.zzb();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 1);
        this.zzh = zzadpVarZzw;
        this.zzv = zzadpVarZzw;
        if (!this.zzb) {
            this.zzi = new zzacj();
            return;
        }
        zzansVar.zzc();
        zzadp zzadpVarZzw2 = zzacnVar.zzw(zzansVar.zza(), 5);
        this.zzi = zzadpVarZzw2;
        zzad zzadVar = new zzad();
        zzadVar.zzK(zzansVar.zzb());
        zzadVar.zzX("application/id3");
        zzadpVarZzw2.zzl(zzadVar.zzad());
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j, int i) {
        this.zzu = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzu = -9223372036854775807L;
        zzg();
    }
}
