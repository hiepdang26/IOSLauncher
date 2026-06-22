package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class rj0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int g = 0;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ rj0(o32 o32Var, String str) {
        this.h = o32Var;
        this.i = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.g) {
            case 0:
                ((t) this.i).startAppShortcutOrInfoActivity((View) this.h);
                break;
            default:
                o32 o32Var = (o32) this.h;
                o32Var.getClass();
                cd2 cd2Var = hd2.B.c;
                cd2.p(o32Var.a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", (String) this.i), "Share via"));
                break;
        }
    }

    public rj0(t tVar, View view) {
        this.i = tVar;
        this.h = view;
    }
}
