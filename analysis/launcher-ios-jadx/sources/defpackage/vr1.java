package defpackage;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.MediaDrmResetException;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class vr1 {
    public static /* bridge */ /* synthetic */ boolean A(Throwable th) {
        return th instanceof MediaDrmResetException;
    }

    public static /* bridge */ /* synthetic */ AudioDeviceInfo d(Object obj) {
        return (AudioDeviceInfo) obj;
    }

    public static /* synthetic */ AudioTrack.Builder e() {
        return new AudioTrack.Builder();
    }

    public static /* synthetic */ void n() {
    }
}
