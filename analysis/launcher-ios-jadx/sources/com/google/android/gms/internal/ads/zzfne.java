package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzfne {
    private static UiModeManager zza;

    public static zzflw zza() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzflw.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? zzflw.OTHER : zzflw.CTV : zzflw.MOBILE;
    }

    public static void zzb(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
