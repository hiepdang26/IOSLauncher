package com.google.android.gms.internal.ads;

import androidx.profileinstaller.ProfileVerifier;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzyk {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzyd[] zzd = new zzyd[100];

    public zzyk(boolean z, int i) {
    }

    public final synchronized int zza() {
        return this.zzb * ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST;
    }

    public final synchronized zzyd zzb() {
        zzyd zzydVar;
        try {
            this.zzb++;
            int i = this.zzc;
            if (i > 0) {
                zzyd[] zzydVarArr = this.zzd;
                int i2 = i - 1;
                this.zzc = i2;
                zzydVar = zzydVarArr[i2];
                if (zzydVar == null) {
                    throw null;
                }
                zzydVarArr[i2] = null;
            } else {
                zzydVar = new zzyd(new byte[ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST], 0);
                int i3 = this.zzb;
                zzyd[] zzydVarArr2 = this.zzd;
                int length = zzydVarArr2.length;
                if (i3 > length) {
                    this.zzd = (zzyd[]) Arrays.copyOf(zzydVarArr2, length + length);
                    return zzydVar;
                }
            }
            return zzydVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc(zzyd zzydVar) {
        zzyd[] zzydVarArr = this.zzd;
        int i = this.zzc;
        this.zzc = i + 1;
        zzydVarArr[i] = zzydVar;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(zzye zzyeVar) {
        while (zzyeVar != null) {
            try {
                zzyd[] zzydVarArr = this.zzd;
                int i = this.zzc;
                this.zzc = i + 1;
                zzydVarArr[i] = zzyeVar.zzc();
                this.zzb--;
                zzyeVar = zzyeVar.zzd();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zza;
        this.zza = i;
        if (i < i2) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i = this.zza;
        int i2 = zzet.zza;
        int iMax = Math.max(0, ((i + 65535) / ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) - this.zzb);
        int i3 = this.zzc;
        if (iMax >= i3) {
            return;
        }
        Arrays.fill(this.zzd, iMax, i3, (Object) null);
        this.zzc = iMax;
    }
}
