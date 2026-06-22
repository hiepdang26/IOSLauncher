package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class qf0 extends InputConnectionWrapper {
    public final /* synthetic */ o5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qf0(InputConnection inputConnection, o5 o5Var) {
        super(inputConnection, false);
        this.a = o5Var;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        ow1 ow1Var = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            ow1Var = new ow1(new sf0(inputContentInfo), 18);
        }
        if (this.a.c(ow1Var, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
