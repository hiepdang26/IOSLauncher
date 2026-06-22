package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class zzeo implements zzds {
    private Message zza;

    private zzeo() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzds
    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        this.zza = null;
        zzep.zzl(this);
    }

    public final zzeo zzb(Message message, zzep zzepVar) {
        this.zza = message;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        this.zza = null;
        zzep.zzl(this);
        return zSendMessageAtFrontOfQueue;
    }

    public /* synthetic */ zzeo(zzen zzenVar) {
    }
}
