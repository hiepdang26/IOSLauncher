package defpackage;

import android.os.Handler;
import android.os.Message;
import com.luutinhit.launcherios.notification.NotificationListener;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class by0 implements Handler.Callback {
    public final /* synthetic */ int g;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.g) {
            case 0:
                tx0 tx0Var = NotificationListener.j;
                if (tx0Var != null && message != null) {
                    Object obj = message.obj;
                    if (obj == null) {
                        tx0Var.a(null);
                    } else {
                        tx0Var.a((List) obj);
                    }
                    break;
                }
                break;
            default:
                if (message.what == 1) {
                    ((eb1) message.obj).recycle();
                }
                break;
        }
        return true;
    }
}
