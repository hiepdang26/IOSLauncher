package defpackage;

import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class zn implements w90 {
    public final Object g;
    public volatile Object h;

    public /* synthetic */ zn(Object obj) {
        this.g = obj;
    }

    public pv a() {
        if (((pv) this.h) == null) {
            synchronized (this) {
                try {
                    if (((pv) this.h) == null) {
                        File cacheDir = ((wb) ((nx0) this.g).h).a.getCacheDir();
                        xv xvVar = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            xvVar = new xv(file);
                        }
                        this.h = xvVar;
                    }
                    if (((pv) this.h) == null) {
                        this.h = new ka0(14);
                    }
                } finally {
                }
            }
        }
        return (pv) this.h;
    }

    @Override // defpackage.w90
    public Object get() {
        if (this.h == null) {
            synchronized (this) {
                try {
                    if (this.h == null) {
                        Object obj = ((w90) this.g).get();
                        n90.h(obj, "Argument must not be null");
                        this.h = obj;
                    }
                } finally {
                }
            }
        }
        return this.h;
    }

    public zn() {
        this.g = new CopyOnWriteArraySet();
    }
}
