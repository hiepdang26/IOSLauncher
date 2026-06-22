package defpackage;

import android.net.Uri;
import android.view.InputEvent;

/* JADX INFO: loaded from: classes.dex */
public final class cs0 extends zk1 implements s70 {
    public int h;
    public final /* synthetic */ es0 i;
    public final /* synthetic */ Uri j;
    public final /* synthetic */ InputEvent k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cs0(es0 es0Var, Uri uri, InputEvent inputEvent, eo eoVar) {
        super(2, eoVar);
        this.i = es0Var;
        this.j = uri;
        this.k = inputEvent;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        return new cs0(this.i, this.j, this.k, eoVar);
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((cs0) create((gp) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        hp hpVar = hp.g;
        int i = this.h;
        if (i == 0) {
            np1.I(obj);
            as0 as0Var = this.i.a;
            this.h = 1;
            if (as0Var.c(this.j, this.k, this) == hpVar) {
                return hpVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            np1.I(obj);
        }
        return zp1.a;
    }
}
