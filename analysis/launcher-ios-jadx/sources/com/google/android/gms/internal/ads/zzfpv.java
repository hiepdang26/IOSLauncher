package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import defpackage.hs0;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpv {
    private final zzaxl zza;
    private final File zzb;
    private final File zzc;
    private final File zzd;
    private byte[] zze;

    public zzfpv(zzaxl zzaxlVar, File file, File file2, File file3) {
        this.zza = zzaxlVar;
        this.zzb = file;
        this.zzc = file3;
        this.zzd = file2;
    }

    public final zzaxl zza() {
        return this.zza;
    }

    public final File zzb() {
        return this.zzc;
    }

    public final File zzc() {
        return this.zzb;
    }

    public final boolean zzd(long j) {
        return this.zza.zzc() - (System.currentTimeMillis() / 1000) < 3600;
    }

    public final byte[] zze() throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArrZzA;
        ArrayList arrayList;
        int iMin;
        FileInputStream fileInputStream2 = null;
        if (this.zze == null) {
            try {
                fileInputStream = new FileInputStream(this.zzd);
                try {
                    arrayList = new ArrayList();
                    iMin = MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
                } catch (IOException unused) {
                    hs0.h(fileInputStream);
                    bArrZzA = null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    hs0.h(fileInputStream2);
                    throw th;
                }
            } catch (IOException unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                byte[] bArr = new byte[iMin];
                int i = 0;
                while (i < iMin) {
                    int i2 = fileInputStream.read(bArr, i, iMin - i);
                    if (i2 == -1) {
                        break;
                    }
                    i += i2;
                }
                zzgwm zzgwmVarZzv = i == 0 ? null : zzgwm.zzv(bArr, 0, i);
                if (zzgwmVarZzv == null) {
                    break;
                }
                arrayList.add(zzgwmVarZzv);
                iMin = Math.min(iMin + iMin, 8192);
                this.zze = bArrZzA;
            }
            bArrZzA = zzgwm.zzu(arrayList).zzA();
            hs0.h(fileInputStream);
            this.zze = bArrZzA;
        }
        byte[] bArr2 = this.zze;
        if (bArr2 == null) {
            return null;
        }
        return Arrays.copyOf(bArr2, bArr2.length);
    }
}
