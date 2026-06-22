package defpackage;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class h21 extends ByteArrayOutputStream implements AutoCloseable {
    public final se g;

    public h21(se seVar, int i) {
        this.g = seVar;
        ((ByteArrayOutputStream) this).buf = seVar.a(Math.max(i, MotionScene.Transition.TransitionOnClick.JUMP_TO_END));
    }

    public final void a(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        int i3 = (i2 + i) * 2;
        se seVar = this.g;
        byte[] bArrA = seVar.a(i3);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrA, 0, ((ByteArrayOutputStream) this).count);
        seVar.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.g.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.g.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
