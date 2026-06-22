package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes.dex */
public final class l6 extends n6 {
    public final /* synthetic */ int i = 0;
    public final /* synthetic */ q6 j;
    public final Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l6(q6 q6Var, wb2 wb2Var) {
        super(q6Var);
        this.j = q6Var;
        this.k = wb2Var;
    }

    @Override // defpackage.n6
    public final IntentFilter e() {
        switch (this.i) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    @Override // defpackage.n6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f() {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l6.f():int");
    }

    @Override // defpackage.n6
    public final void h() {
        switch (this.i) {
            case 0:
                this.j.h(true);
                break;
            default:
                this.j.h(true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l6(q6 q6Var, Context context) {
        super(q6Var);
        this.j = q6Var;
        this.k = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
