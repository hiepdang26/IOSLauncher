package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class nw1 {
    public final String a;
    public final int b;

    public nw1(String str) {
        this.a = str;
        this.b = 0;
    }

    public nw1(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.a = null;
        this.b = 1;
    }
}
