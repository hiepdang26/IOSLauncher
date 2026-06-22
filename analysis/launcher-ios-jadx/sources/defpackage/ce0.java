package defpackage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ce0 implements View.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ ce0(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.g) {
            case 0:
                ((IOSLauncher) this.h).lambda$showAppsLibrarySettingsGuide$9((u3) this.i, view);
                break;
            case 1:
                t.c((t) this.h, (Pair) this.i);
                break;
            case 2:
                Intent intent = (Intent) this.i;
                za1 za1Var = (za1) this.h;
                Context context = za1Var.a;
                try {
                    AlertDialog alertDialog = za1Var.b;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                    intent.setFlags(276856832);
                    context.startActivity(intent);
                } catch (Exception unused) {
                    za1.b(context);
                    return;
                }
                break;
            default:
                SlidingUpWidgetsList slidingUpWidgetsList = ((yh1) this.h).l;
                if (slidingUpWidgetsList != null) {
                    int iE = ((xh1) this.i).e();
                    wh1 wh1Var = slidingUpWidgetsList.W;
                    if (wh1Var != null) {
                        wq wqVar = (wq) wh1Var;
                        wqVar.q.setWidgetsAppStyleList(((cx1) slidingUpWidgetsList.S.get(iE)).c);
                        wqVar.q.post(new rq(wqVar, 1));
                    }
                }
                break;
        }
    }
}
