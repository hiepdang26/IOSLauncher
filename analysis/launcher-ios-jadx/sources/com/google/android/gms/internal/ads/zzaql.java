package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzaql extends ByteArrayOutputStream implements AutoCloseable {
    private final zzapy zza;

    public zzaql(zzapy zzapyVar, int i) {
        this.zza = zzapyVar;
        ((ByteArrayOutputStream) this).buf = zzapyVar.zzb(Math.max(i, MotionScene.Transition.TransitionOnClick.JUMP_TO_END));
    }

    private final void zza(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        int i3 = i2 + i;
        byte[] bArrZzb = this.zza.zzb(i3 + i3);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrZzb, 0, ((ByteArrayOutputStream) this).count);
        this.zza.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrZzb;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zza(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        zza(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zza(i2);
        super.write(bArr, i, i2);
    }
}
