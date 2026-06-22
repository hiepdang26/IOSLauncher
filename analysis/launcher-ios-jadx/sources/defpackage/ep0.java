package defpackage;

import android.app.job.JobInfo;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.LocaleList;
import android.view.PointerIcon;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ep0 {
    public static /* synthetic */ JobInfo.TriggerContentUri c(Uri uri, int i) {
        return new JobInfo.TriggerContentUri(uri, i);
    }

    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern f() {
        return new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public static /* bridge */ /* synthetic */ LocaleList i(Object obj) {
        return (LocaleList) obj;
    }

    public static /* bridge */ /* synthetic */ PointerIcon j(Object obj) {
        return (PointerIcon) obj;
    }

    public static /* bridge */ /* synthetic */ Class k() {
        return Optional.class;
    }

    public static /* synthetic */ void o() {
    }
}
