package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import defpackage.hs0;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgh {
    public static ParcelFileDescriptor zza(final InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
        final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorArrCreatePipe[1];
        zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgg
            @Override // java.lang.Runnable
            public final void run() {
                InputStream inputStream2 = inputStream;
                try {
                    try {
                        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor2);
                        try {
                            hs0.j(inputStream2, autoCloseOutputStream, false);
                            autoCloseOutputStream.close();
                            inputStream2.close();
                        } finally {
                        }
                    } finally {
                    }
                } catch (IOException unused) {
                }
            }
        });
        return parcelFileDescriptor;
    }
}
