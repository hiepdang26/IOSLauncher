package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import defpackage.gs;

/* JADX INFO: loaded from: classes.dex */
public final class a implements gs {
    public final ParcelFileDescriptorRewinder$InternalRewinder g;

    public a(ParcelFileDescriptor parcelFileDescriptor) {
        this.g = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public final ParcelFileDescriptor a() {
        return this.g.rewind();
    }

    @Override // defpackage.gs
    public final void b() {
    }

    @Override // defpackage.gs
    public final Object r() {
        return this.g.rewind();
    }
}
