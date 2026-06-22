package defpackage;

import dalvik.system.PathClassLoader;

/* JADX INFO: loaded from: classes.dex */
public final class so extends PathClassLoader {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ so(String str, ClassLoader classLoader, int i) {
        super(str, classLoader);
        this.a = i;
    }

    @Override // java.lang.ClassLoader
    public Class loadClass(String str, boolean z) {
        switch (this.a) {
            case 1:
                if (!str.startsWith("java.") && !str.startsWith("android.")) {
                    try {
                        return findClass(str);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return super.loadClass(str, z);
            default:
                return super.loadClass(str, z);
        }
    }

    @Override // java.lang.ClassLoader
    public Class loadClass(String str) {
        switch (this.a) {
            case 0:
                if (Object.class.getName().equals(str)) {
                    return Object.class;
                }
                try {
                    return findClass(str);
                } catch (ClassNotFoundException unused) {
                    if (t.C().getName().equals(str)) {
                        return sb0.class;
                    }
                    if (t.D().getName().equals(str)) {
                        return ub0.class;
                    }
                    if (Class.class.getName().equals(str)) {
                        return rb0.class;
                    }
                    return super.loadClass(str);
                }
            default:
                return super.loadClass(str);
        }
    }
}
