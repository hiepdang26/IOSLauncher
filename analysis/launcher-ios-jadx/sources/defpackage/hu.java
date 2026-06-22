package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class hu extends f {
    public final /* synthetic */ int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hu(yo yoVar, boolean z, int i) {
        super(yoVar, z);
        this.j = i;
    }

    @Override // defpackage.xi0
    public boolean A(Throwable th) throws IllegalAccessException, InvocationTargetException {
        switch (this.j) {
            case 1:
                os.h(this.i, th);
                return true;
            default:
                return super.A(th);
        }
    }
}
