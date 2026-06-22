package defpackage;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class ki0 implements li0 {
    public final Intent a;
    public final int b;
    public final /* synthetic */ qi0 c;

    public ki0(qi0 qi0Var, Intent intent, int i) {
        this.c = qi0Var;
        this.a = intent;
        this.b = i;
    }

    @Override // defpackage.li0
    public final void a() {
        this.c.stopSelf(this.b);
    }

    @Override // defpackage.li0
    public final Intent getIntent() {
        return this.a;
    }
}
