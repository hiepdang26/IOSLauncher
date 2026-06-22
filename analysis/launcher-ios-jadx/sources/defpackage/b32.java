package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class b32 implements IInterface {
    public final IBinder g;
    public final String h;

    public b32(IBinder iBinder, String str) {
        this.g = iBinder;
        this.h = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.g;
    }
}
