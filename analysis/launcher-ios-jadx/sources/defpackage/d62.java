package defpackage;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class d62 extends b12 {
    public final AtomicReference h;
    public boolean i;

    public d62() {
        super(2);
        attachInterface(this, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
        this.h = new AtomicReference();
    }

    public static final Object s(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        return cls.cast(obj);
    }

    public final Bundle q(long j) {
        Bundle bundle;
        synchronized (this.h) {
            if (!this.i) {
                try {
                    this.h.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.h.get();
        }
        return bundle;
    }

    public final void r(Bundle bundle) {
        synchronized (this.h) {
            try {
                try {
                    this.h.set(bundle);
                    this.i = true;
                } finally {
                    this.h.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
