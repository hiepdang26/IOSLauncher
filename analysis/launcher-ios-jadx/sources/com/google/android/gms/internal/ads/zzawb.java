package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzawb extends zzaxd {
    public zzawb(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2) {
        super(zzavpVar, "d7YRusR2mxxBt1bBYjK2gXVvJl/MfqFw2IiZZVeFOFqksQBErGXLOKgf56kYtWpK", "q4VBjxb/Ij/RcUKEcmQK+TpC64QFNLpq6sfIawaWN1g=", zzaroVar, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() throws InvocationTargetException {
        int i = 1;
        this.zzd.zzaa(3);
        try {
            boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
            zzaro zzaroVar = this.zzd;
            if (true == zBooleanValue) {
                i = 2;
            }
            zzaroVar.zzaa(i);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
