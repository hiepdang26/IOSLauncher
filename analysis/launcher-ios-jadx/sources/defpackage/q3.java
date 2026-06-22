package defpackage;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.preference.PreferenceScreen;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class q3 extends Handler {
    public final /* synthetic */ int a = 0;
    public Object b;

    public /* synthetic */ q3() {
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (this.a) {
            case 0:
                int i = message.what;
                if (i == -3 || i == -2 || i == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.b).get(), message.what);
                    break;
                } else if (i == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    break;
                }
                break;
            default:
                if (message.what == 1) {
                    z21 z21Var = (z21) this.b;
                    PreferenceScreen preferenceScreen = z21Var.a0.g;
                    if (preferenceScreen != null) {
                        z21Var.b0.setAdapter(new c31(preferenceScreen));
                        preferenceScreen.i();
                    }
                    break;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q3(z21 z21Var, Looper looper) {
        super(looper);
        this.b = z21Var;
    }
}
