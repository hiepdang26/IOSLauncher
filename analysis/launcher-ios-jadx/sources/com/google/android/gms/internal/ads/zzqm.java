package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes.dex */
final class zzqm extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzqn zza;

    public zzqm(zzqn zzqnVar, zzqp zzqpVar) {
        this.zza = zzqnVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        audioTrack.equals(this.zza.zza.zzt);
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onPresentationEnded(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zza.zza.zzt)) {
            this.zza.zza.zzQ = true;
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        audioTrack.equals(this.zza.zza.zzt);
    }
}
