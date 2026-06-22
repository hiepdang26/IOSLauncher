package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.view.Display;

/* JADX INFO: loaded from: classes.dex */
final class zzaaj implements DisplayManager.DisplayListener {
    final /* synthetic */ zzaal zza;
    private final DisplayManager zzb;

    public zzaaj(zzaal zzaalVar, DisplayManager displayManager) {
        this.zza = zzaalVar;
        this.zzb = displayManager;
    }

    private final Display zzc() {
        return this.zzb.getDisplay(0);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        if (i == 0) {
            zzaal.zzb(this.zza, zzc());
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzet.zzx(null));
        zzaal.zzb(this.zza, zzc());
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }
}
