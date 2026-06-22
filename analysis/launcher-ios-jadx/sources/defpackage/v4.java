package defpackage;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class v4 implements bj0 {
    public final int b;
    public final bj0 c;

    public v4(int i, bj0 bj0Var) {
        this.b = i;
        this.c = bj0Var;
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (obj instanceof v4) {
            v4 v4Var = (v4) obj;
            if (this.b == v4Var.b && this.c.equals(v4Var.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return vq1.h(this.b, this.c);
    }
}
