package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoy {
    private final Executor zza;

    public zzaoy(Handler handler) {
        this.zza = new zzaow(this, handler);
    }

    public final void zza(zzaph zzaphVar, zzapq zzapqVar) {
        zzaphVar.zzm("post-error");
        ((zzaow) this.zza).zza.post(new zzaox(zzaphVar, zzapn.zza(zzapqVar), null));
    }

    public final void zzb(zzaph zzaphVar, zzapn zzapnVar, Runnable runnable) {
        zzaphVar.zzq();
        zzaphVar.zzm("post-response");
        ((zzaow) this.zza).zza.post(new zzaox(zzaphVar, zzapnVar, runnable));
    }
}
