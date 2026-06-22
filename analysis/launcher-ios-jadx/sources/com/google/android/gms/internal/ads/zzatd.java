package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzatd {
    static boolean zza = false;
    public static final /* synthetic */ int zzc = 0;
    private static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();
    static final CountDownLatch zzb = new CountDownLatch(1);

    public static String zza(byte[] bArr, String str) {
        byte[] bArrZzg;
        Vector vectorZzb = zzb(bArr, 255);
        if (vectorZzb == null || vectorZzb.isEmpty()) {
            bArrZzg = zzg(zzf(MotionScene.Transition.TransitionOnClick.JUMP_TO_START).zzaV(), str, true);
        } else {
            zzasv zzasvVarZza = zzasw.zza();
            int size = vectorZzb.size();
            for (int i = 0; i < size; i++) {
                zzasvVarZza.zza(zzgwm.zzv(zzg((byte[]) vectorZzb.get(i), str, false), 0, MotionScene.Transition.TransitionOnClick.JUMP_TO_END));
            }
            byte[] bArrZze = zze(bArr);
            zzgwm zzgwmVar = zzgwm.zzb;
            zzasvVarZza.zzb(zzgwm.zzv(bArrZze, 0, bArrZze.length));
            bArrZzg = ((zzasw) zzasvVarZza.zzbr()).zzaV();
        }
        return zzasz.zza(bArrZzg, true);
    }

    public static Vector zzb(byte[] bArr, int i) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i2 = length + 254;
        Vector vector = new Vector();
        for (int i3 = 0; i3 < i2 / 255; i3++) {
            int i4 = i3 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i4 > 255) {
                    length2 = i4 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i4, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static void zzd() {
        synchronized (zzf) {
            try {
                if (!zza) {
                    zza = true;
                    new Thread(new zzatc(null)).start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static byte[] zze(byte[] bArr) {
        byte[] bArrDigest;
        MessageDigest messageDigest;
        synchronized (zze) {
            try {
                zzd();
                MessageDigest messageDigest2 = null;
                try {
                    if (zzb.await(2L, TimeUnit.SECONDS) && (messageDigest = zzd) != null) {
                        messageDigest2 = messageDigest;
                    }
                } catch (InterruptedException unused) {
                }
                if (messageDigest2 == null) {
                    throw new NoSuchAlgorithmException("Cannot compute hash");
                }
                messageDigest2.reset();
                messageDigest2.update(bArr);
                bArrDigest = zzd.digest();
            } finally {
            }
        }
        return bArrDigest;
    }

    public static zzasj zzf(int i) {
        zzaro zzaroVarZza = zzasj.zza();
        zzaroVarZza.zzD(4096L);
        return (zzasj) zzaroVarZza.zzbr();
    }

    private static byte[] zzg(byte[] bArr, String str, boolean z) {
        byte[] bArrArray;
        int length = bArr.length;
        int i = true != z ? 255 : 239;
        if (length > i) {
            bArr = zzf(MotionScene.Transition.TransitionOnClick.JUMP_TO_START).zzaV();
        }
        int i2 = i + 1;
        int length2 = bArr.length;
        byte b = (byte) length2;
        if (length2 < i) {
            byte[] bArr2 = new byte[i - length2];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i2).put(b).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i2).put(b).put(bArr).array();
        }
        if (z) {
            bArrArray = ByteBuffer.allocate(MotionScene.Transition.TransitionOnClick.JUMP_TO_END).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[MotionScene.Transition.TransitionOnClick.JUMP_TO_END];
        zzate[] zzateVarArr = new zzaud().zzcG;
        int length3 = zzateVarArr.length;
        for (int i3 = 0; i3 < 12; i3++) {
            zzateVarArr[i3].zza(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzasx(str.getBytes("UTF-8")).zza(bArr3);
        }
        return bArr3;
    }
}
