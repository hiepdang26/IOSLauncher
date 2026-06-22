package com.bumptech.glide.load;

import defpackage.ze0;

/* JADX INFO: loaded from: classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(0),
    JPEG(1),
    RAW(2),
    PNG_A(3),
    PNG(4),
    WEBP_A(5),
    WEBP(6),
    ANIMATED_WEBP(7),
    AVIF(8),
    ANIMATED_AVIF(9),
    UNKNOWN(10);

    public final boolean g;

    ImageHeaderParser$ImageType(int i) {
        this.g = z;
    }

    public boolean hasAlpha() {
        return this.g;
    }

    public boolean isWebp() {
        int i = ze0.a[ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
