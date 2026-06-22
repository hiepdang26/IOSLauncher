package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class pb2 extends kb2 {
    public final byte[] i;

    public pb2(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.i = bArr;
    }

    @Override // defpackage.kb2
    public final byte[] r() {
        return this.i;
    }
}
