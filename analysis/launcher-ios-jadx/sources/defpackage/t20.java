package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class t20 implements View.OnClickListener {
    public final /* synthetic */ u20 g;

    public t20(u20 u20Var) {
        this.g = u20Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u20 u20Var = this.g;
        y00 y00Var = u20Var.C;
        y00 y00Var2 = u20Var.C;
        Objects.toString((ArrayList) y00Var.p);
        try {
            ArrayList arrayList = (ArrayList) y00Var2.p;
            if (arrayList == null || arrayList.size() <= 0 || ((s20) ((ArrayList) y00Var2.p).get(u20Var.e())).c == null || ((s20) ((ArrayList) y00Var2.p).get(u20Var.e())).c.size() <= 0) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setFlags(268435456);
                ((Context) y00Var2.k).startActivity(intent);
            } else {
                Intent intent2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((String) ((s20) ((ArrayList) y00Var2.p).get(u20Var.e())).c.get(0))));
                intent2.setFlags(268435456);
                ((Context) y00Var2.k).startActivity(intent2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
