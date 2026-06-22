package defpackage;

import android.os.Message;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class j3 implements View.OnClickListener {
    public final /* synthetic */ s3 g;

    public j3(s3 s3Var) {
        this.g = s3Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        s3 s3Var = this.g;
        Message messageObtain = (view != s3Var.i || (message3 = s3Var.k) == null) ? (view != s3Var.l || (message2 = s3Var.n) == null) ? (view != s3Var.o || (message = s3Var.q) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
        if (messageObtain != null) {
            messageObtain.sendToTarget();
        }
        s3Var.F.obtainMessage(1, s3Var.b).sendToTarget();
    }
}
