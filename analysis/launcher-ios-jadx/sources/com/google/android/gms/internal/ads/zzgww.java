package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgww {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzgwx zzc;

    public /* synthetic */ zzgww(zzgwv zzgwvVar) {
    }

    public static int zzD(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static int zzE(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw zzgyn.zzi();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw zzgyn.zzi();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw zzgyn.zze();
    }

    public static long zzF(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzgww zzG(InputStream inputStream, int i) {
        if (inputStream != null) {
            return new zzgws(inputStream, MotionScene.Transition.TransitionOnClick.JUMP_TO_START, null);
        }
        byte[] bArr = zzgyl.zzb;
        int length = bArr.length;
        return zzH(bArr, 0, 0, false);
    }

    public static zzgww zzH(byte[] bArr, int i, int i2, boolean z) {
        zzgwo zzgwoVar = new zzgwo(bArr, i, i2, z, null);
        try {
            zzgwoVar.zzd(i2);
            return zzgwoVar;
        } catch (zzgyn e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract boolean zzA();

    public abstract boolean zzB();

    public abstract double zza();

    public abstract float zzb();

    public abstract int zzc();

    public abstract int zzd(int i);

    public abstract int zze();

    public abstract int zzf();

    public abstract int zzg();

    public abstract int zzj();

    public abstract int zzk();

    public abstract int zzl();

    public abstract int zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract long zzs();

    public abstract long zzt();

    public abstract long zzu();

    public abstract zzgwm zzv();

    public abstract String zzw();

    public abstract String zzx();

    public abstract void zzy(int i);

    public abstract void zzz(int i);
}
