package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgxd extends zzgwd {
    private static final Logger zza = Logger.getLogger(zzgxd.class.getName());
    private static final boolean zzb = zzhaz.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgxe zze;

    private zzgxd() {
        throw null;
    }

    public static int zzA(zzgzj zzgzjVar, zzhae zzhaeVar) {
        int iZzaM = ((zzgvv) zzgzjVar).zzaM(zzhaeVar);
        return zzD(iZzaM) + iZzaM;
    }

    public static int zzB(int i) {
        return i > 4096 ? MotionScene.Transition.TransitionOnClick.JUMP_TO_START : i;
    }

    public static int zzC(String str) {
        int length;
        try {
            length = zzhbe.zze(str);
        } catch (zzhbd unused) {
            length = str.getBytes(zzgyl.zza).length;
        }
        return zzD(length) + length;
    }

    public static int zzD(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzE(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzgxd zzF(byte[] bArr, int i, int i2) {
        return new zzgwz(bArr, 0, i2);
    }

    @Deprecated
    public static int zzy(int i, zzgzj zzgzjVar, zzhae zzhaeVar) {
        int iZzD = zzD(i << 3);
        return ((zzgvv) zzgzjVar).zzaM(zzhaeVar) + iZzD + iZzD;
    }

    public static int zzz(zzgzj zzgzjVar) {
        int iZzaY = zzgzjVar.zzaY();
        return zzD(iZzaY) + iZzaY;
    }

    public final void zzG() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzH(String str, zzhbd zzhbdVar) throws zzgxa {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhbdVar);
        byte[] bytes = str.getBytes(zzgyl.zza);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgxa(e);
        }
    }

    public abstract void zzL();

    public abstract void zzM(byte b);

    public abstract void zzN(int i, boolean z);

    public abstract void zzO(int i, zzgwm zzgwmVar);

    @Override // com.google.android.gms.internal.ads.zzgwd
    public abstract void zza(byte[] bArr, int i, int i2);

    public abstract int zzb();

    public abstract void zzh(int i, int i2);

    public abstract void zzi(int i);

    public abstract void zzj(int i, long j);

    public abstract void zzk(long j);

    public abstract void zzl(int i, int i2);

    public abstract void zzm(int i);

    public abstract void zzn(int i, zzgzj zzgzjVar, zzhae zzhaeVar);

    public abstract void zzo(int i, zzgzj zzgzjVar);

    public abstract void zzp(int i, zzgwm zzgwmVar);

    public abstract void zzq(int i, String str);

    public abstract void zzs(int i, int i2);

    public abstract void zzt(int i, int i2);

    public abstract void zzu(int i);

    public abstract void zzv(int i, long j);

    public abstract void zzw(long j);

    public /* synthetic */ zzgxd(zzgxc zzgxcVar) {
    }
}
