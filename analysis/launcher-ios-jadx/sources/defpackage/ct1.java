package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class ct1 {
    public final LinkedHashMap a = new LinkedHashMap();

    public final void a() {
        for (at1 at1Var : this.a.values()) {
            HashMap map = at1Var.a;
            if (map != null) {
                synchronized (map) {
                    try {
                        for (Object obj : at1Var.a.values()) {
                            if (obj instanceof Closeable) {
                                try {
                                    ((Closeable) obj).close();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = at1Var.b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        for (Closeable closeable : at1Var.b) {
                            if (uo.r(closeable)) {
                                try {
                                    closeable.close();
                                } catch (IOException e2) {
                                    throw new RuntimeException(e2);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            at1Var.a();
        }
        this.a.clear();
    }
}
