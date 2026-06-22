package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes.dex */
final class zzpy {
    public static void zza(AudioTrack audioTrack, zzon zzonVar) {
        audioTrack.setPreferredDevice(zzonVar == null ? null : zzonVar.zza);
    }
}
