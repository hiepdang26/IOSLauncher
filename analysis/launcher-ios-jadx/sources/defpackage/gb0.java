package defpackage;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class gb0 {
    public static final boolean e;
    public static final boolean f;
    public static final File g;
    public static volatile gb0 h;
    public int b;
    public boolean c = true;
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final int a = 20000;

    static {
        int i = Build.VERSION.SDK_INT;
        e = i < 29;
        f = i >= 28;
        g = new File("/proc/self/fd");
    }

    public static gb0 a() {
        if (h == null) {
            synchronized (gb0.class) {
                try {
                    if (h == null) {
                        h = new gb0();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT == 28) {
            Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
            while (it.hasNext()) {
                if (Build.MODEL.startsWith((String) it.next())) {
                    return 500;
                }
            }
        }
        return this.a;
    }

    public final boolean c(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        if (!z) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (!f) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (e && !this.d.get()) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (z2) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (i < 0 || i2 < 0) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        synchronized (this) {
            try {
                int i3 = this.b + 1;
                this.b = i3;
                if (i3 >= 50) {
                    this.b = 0;
                    boolean z4 = ((long) g.list().length) < ((long) b());
                    this.c = z4;
                    if (!z4) {
                        Log.isLoggable("Downsampler", 5);
                    }
                }
                z3 = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z3) {
            return true;
        }
        Log.isLoggable("HardwareConfig", 2);
        return false;
    }
}
