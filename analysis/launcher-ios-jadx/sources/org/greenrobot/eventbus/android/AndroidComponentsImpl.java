package org.greenrobot.eventbus.android;

import defpackage.e42;
import defpackage.ka0;

/* JADX INFO: loaded from: classes.dex */
public class AndroidComponentsImpl {
    public static final AndroidComponentsImpl c;
    public final ka0 a;
    public final ka0 b;

    static {
        AndroidComponentsImpl androidComponentsImpl = null;
        if (e42.e()) {
            try {
                androidComponentsImpl = (AndroidComponentsImpl) AndroidComponentsImpl.class.getConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
        }
        c = androidComponentsImpl;
    }

    public AndroidComponentsImpl() {
        ka0 ka0Var = new ka0(7);
        ka0 ka0Var2 = new ka0(13);
        this.a = ka0Var;
        this.b = ka0Var2;
    }
}
