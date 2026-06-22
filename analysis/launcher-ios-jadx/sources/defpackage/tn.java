package defpackage;

import android.content.ClipData;
import android.content.pm.ApkChecksum;
import android.view.ContentInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class tn {
    public static /* bridge */ /* synthetic */ ApkChecksum e(Object obj) {
        return (ApkChecksum) obj;
    }

    public static /* synthetic */ ContentInfo.Builder j(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    public static /* bridge */ /* synthetic */ ContentInfo l(Object obj) {
        return (ContentInfo) obj;
    }
}
