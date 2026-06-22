package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class tg0 extends IOException {
    public static tg0 a() {
        return new tg0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
