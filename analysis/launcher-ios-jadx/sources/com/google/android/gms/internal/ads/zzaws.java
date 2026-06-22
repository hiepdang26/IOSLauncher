package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzaws extends zzaxd {
    public zzaws(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2) {
        super(zzavpVar, "0njjbCFUq6vJ1UgnErUI7KEtLgZLN7V9IJ5yZ3QtzXmjMaTjzKInpeDNakYTgh0P", "C8NIMy/t/HZjKrbJt0Xe/Cv+czK1jvEhHHQsIVfXSJE=", zzaroVar, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        int i = 1;
        try {
            boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
            zzaro zzaroVar = this.zzd;
            if (true == zBooleanValue) {
                i = 2;
            }
            zzaroVar.zzaf(i);
        } catch (InvocationTargetException unused) {
            this.zzd.zzaf(3);
        }
    }
}
