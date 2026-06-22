package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.luutinhit.launcherios.MainActivity;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class yn0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ yn0(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.g) {
            case 0:
                zn0 zn0Var = (zn0) this.h;
                zn0Var.v0 = i;
                zn0Var.u0 = -1;
                dialogInterface.dismiss();
                break;
            case 1:
                MainActivity mainActivity = (MainActivity) this.h;
                try {
                    mainActivity.sendBroadcast(new Intent("com.luutinhit.launcherios.ACTION_FORCE_RELOAD_LAUNCHER"));
                    mainActivity.finish();
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            case 2:
                ((AtomicInteger) this.h).set(i);
                break;
            case 3:
                ((o32) this.h).b();
                break;
            default:
                cd2 cd2Var = hd2.B.c;
                cd2.q(Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"), (Context) ((zz1) this.h).j);
                break;
        }
    }
}
