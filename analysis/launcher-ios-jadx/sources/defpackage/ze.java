package defpackage;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class ze implements gs, d01 {
    public final ByteBuffer g;

    public ze(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
    }

    @Override // defpackage.d01
    public void g(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.g) {
            this.g.position(0);
            messageDigest.update(this.g.putLong(l.longValue()).array());
        }
    }

    @Override // defpackage.gs
    public Object r() {
        ByteBuffer byteBuffer = this.g;
        byteBuffer.position(0);
        return byteBuffer;
    }

    public ze() {
        this.g = ByteBuffer.allocate(8);
    }

    @Override // defpackage.gs
    public void b() {
    }
}
