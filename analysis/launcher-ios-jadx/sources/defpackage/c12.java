package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class c12 extends t12 {
    public final Context a;
    public final /* synthetic */ da0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c12(da0 da0Var, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.b = da0Var;
        this.a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        int i = ea0.a;
        da0 da0Var = this.b;
        Context context = this.a;
        int iC = da0Var.c(context, i);
        int i2 = ja0.c;
        if (iC == 1 || iC == 2 || iC == 3 || iC == 9) {
            Intent intentB = da0Var.b(context, "n", iC);
            da0Var.g(context, iC, intentB == null ? null : PendingIntent.getActivity(context, 0, intentB, a82.a | 134217728));
        }
    }
}
