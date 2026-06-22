package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class ci extends hi0 implements bi {
    public final xi0 k;

    public ci(xi0 xi0Var) {
        this.k = xi0Var;
    }

    @Override // defpackage.bi
    public final boolean e(Throwable th) {
        return l().s(th);
    }

    @Override // defpackage.o70
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
        m((Throwable) obj);
        return zp1.a;
    }

    @Override // defpackage.ti0
    public final void m(Throwable th) throws IllegalAccessException, InvocationTargetException {
        this.k.m(l());
    }
}
