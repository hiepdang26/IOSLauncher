package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class sj extends IOException {
    public sj(String str, int i, IOException iOException) {
        super(str + ", status code: " + i, iOException);
    }

    public sj(int i, int i2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
    }
}
