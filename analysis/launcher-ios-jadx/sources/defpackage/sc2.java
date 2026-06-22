package defpackage;

import android.media.MediaCodecInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class sc2 {
    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint a() {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60);
    }

    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint b(int i, int i2, int i3) {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(i, i2, i3);
    }

    public static /* bridge */ /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint c(Object obj) {
        return (MediaCodecInfo.VideoCapabilities.PerformancePoint) obj;
    }

    public static /* synthetic */ void e() {
    }
}
