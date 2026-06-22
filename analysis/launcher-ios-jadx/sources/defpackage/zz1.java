package defpackage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.luutinhit.launcher6.Workspace;

/* JADX INFO: loaded from: classes.dex */
public final class zz1 implements Runnable {
    public final /* synthetic */ int g = 0;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;

    public zz1(String str, Context context, boolean z, boolean z2) {
        this.j = context;
        this.k = str;
        this.h = z;
        this.i = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                ((Workspace) this.k).W0(this.h, (Runnable) this.j, 0, this.i);
                break;
            default:
                cd2 cd2Var = hd2.B.c;
                AlertDialog.Builder builderI = cd2.i((Context) this.j);
                builderI.setMessage((String) this.k);
                if (this.h) {
                    builderI.setTitle("Error");
                } else {
                    builderI.setTitle("Info");
                }
                if (this.i) {
                    builderI.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
                } else {
                    builderI.setPositiveButton("Learn More", new yn0(this, 4));
                    builderI.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
                }
                builderI.create().show();
                break;
        }
    }

    public zz1(Workspace workspace, boolean z, Runnable runnable, boolean z2) {
        this.k = workspace;
        this.h = z;
        this.j = runnable;
        this.i = z2;
    }
}
