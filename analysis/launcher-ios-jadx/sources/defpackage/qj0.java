package defpackage;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.view.View;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class qj0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ qk0 h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;

    public /* synthetic */ qj0(Object obj, Object obj2, Object obj3, qk0 qk0Var, int i) {
        this.g = i;
        this.k = obj;
        this.i = obj2;
        this.j = obj3;
        this.h = qk0Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        qk0 qk0Var = this.h;
        Object obj = this.j;
        Object obj2 = this.k;
        Object obj3 = this.i;
        switch (this.g) {
            case 0:
                ((t) obj2).startActivitySafely((x11) obj3, rl0.m((String) obj), qk0Var);
                break;
            default:
                int iIntValue = ((Integer) ((ArrayList) obj3).get(i)).intValue();
                dk0 dk0Var = (dk0) obj2;
                View view = (View) obj;
                zg zgVar = (zg) view.getLayoutParams();
                CellLayout cellLayout = (CellLayout) view.getParent().getParent();
                cellLayout.w(view);
                if (iIntValue == w61.action_increase_width) {
                    if ((view.getLayoutDirection() == 1 && cellLayout.u(qk0Var.k - 1, qk0Var.l, 1, qk0Var.n)) || !cellLayout.u(qk0Var.k + qk0Var.m, qk0Var.l, 1, qk0Var.n)) {
                        zgVar.a--;
                        qk0Var.k--;
                    }
                    zgVar.f++;
                    qk0Var.m++;
                } else if (iIntValue == w61.action_decrease_width) {
                    zgVar.f--;
                    qk0Var.m--;
                } else if (iIntValue == w61.action_increase_height) {
                    if (!cellLayout.u(qk0Var.k, qk0Var.l + qk0Var.n, qk0Var.m, 1)) {
                        zgVar.b--;
                        qk0Var.l--;
                    }
                    zgVar.g++;
                    qk0Var.n++;
                } else if (iIntValue == w61.action_decrease_height) {
                    zgVar.g--;
                    qk0Var.n--;
                }
                cellLayout.v(view);
                Rect rect = new Rect();
                int i2 = qk0Var.m;
                int i3 = qk0Var.n;
                t tVar = dk0Var.h;
                r7.a(tVar, i2, i3, rect);
                ((pk0) view).updateAppWidgetSize(null, rect.left, rect.top, rect.right, rect.bottom);
                view.requestLayout();
                rl0.E(tVar, qk0Var);
                tVar.getDragLayer().announceForAccessibility(tVar.getString(w61.widget_resized, Integer.valueOf(qk0Var.m), Integer.valueOf(qk0Var.n)));
                dialogInterface.dismiss();
                break;
        }
    }
}
