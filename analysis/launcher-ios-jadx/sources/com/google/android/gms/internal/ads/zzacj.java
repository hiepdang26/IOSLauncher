package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.io.EOFException;

/* JADX INFO: loaded from: classes.dex */
public final class zzacj implements zzadp {
    private final byte[] zza = new byte[MotionScene.Transition.TransitionOnClick.JUMP_TO_START];

    @Override // com.google.android.gms.internal.ads.zzadp
    public final /* synthetic */ int zzf(zzp zzpVar, int i, boolean z) {
        return zzadn.zza(this, zzpVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final int zzg(zzp zzpVar, int i, boolean z, int i2) throws EOFException {
        int iZza = zzpVar.zza(this.zza, 0, Math.min(MotionScene.Transition.TransitionOnClick.JUMP_TO_START, i));
        if (iZza != -1) {
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzl(zzaf zzafVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final /* synthetic */ void zzq(zzek zzekVar, int i) {
        zzadn.zzb(this, zzekVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzr(zzek zzekVar, int i, int i2) {
        zzekVar.zzL(i);
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzs(long j, int i, int i2, int i3, zzado zzadoVar) {
    }
}
