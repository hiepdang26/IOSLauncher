package defpackage;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Toast;
import com.luutinhit.launcher6.DeleteDropTarget;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.editscreen.SlidingUpCustomizeColorIconStyle;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcher6.leftpage.widgets.PhotoWidget_2x2;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.view.SlidingUpWidgetsCellAppStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g7 implements View.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ g7(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intentMakeRestartActivityTask;
        rh1 rh1Var = rh1.h;
        Object obj = this.h;
        switch (this.g) {
            case 0:
                h7 h7Var = (h7) obj;
                i7 i7Var = h7Var.B;
                Objects.toString(i7Var.l);
                try {
                    ArrayList arrayList = i7Var.l;
                    Context context = i7Var.j;
                    if (arrayList == null || arrayList.size() <= 0 || ((gh0) i7Var.l.get(h7Var.e())).c == null) {
                        Intent intent = new Intent("android.intent.action.DIAL");
                        intent.setFlags(268435456);
                        context.startActivity(intent);
                    } else {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(((gh0) i7Var.l.get(h7Var.e())).c);
                        if (componentNameUnflattenFromString != null && (intentMakeRestartActivityTask = Intent.makeRestartActivityTask(componentNameUnflattenFromString)) != null) {
                            context.startActivity(intentMakeRestartActivityTask);
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            case 1:
                e8 e8Var = (e8) ((b8) obj).n;
                if (e8Var != null) {
                    e8Var.a();
                }
                break;
            case 2:
                l8 l8Var = (l8) obj;
                if (!l8Var.r) {
                    l8Var.transitionToEnd();
                } else {
                    l8Var.transitionToStart();
                }
                break;
            case 3:
                ((ce0) obj).onClick(view);
                break;
            case 4:
                ((mj0) obj).onClick(view);
                break;
            case 5:
                x00 x00Var = (x00) obj;
                y00 y00Var = x00Var.D;
                try {
                    List list = y00Var.p;
                    if (list != null) {
                        int i = ((w00) list.get(x00Var.e())).a;
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        Uri.Builder builderBuildUpon = CalendarContract.Events.CONTENT_URI.buildUpon();
                        builderBuildUpon.appendPath(Long.toString(i));
                        intent2.setData(builderBuildUpon.build());
                        intent2.setFlags(268435456);
                        ((Context) y00Var.k).startActivity(intent2);
                    }
                } catch (Throwable unused) {
                    Context context2 = (Context) y00Var.k;
                    Toast.makeText(context2, context2.getString(w61.application_not_found), 1).show();
                    return;
                }
                break;
            case 6:
                ae0 ae0Var = (ae0) obj;
                Workspace workspace = ae0Var.j.getWorkspace();
                int i2 = ae0Var.l;
                workspace.getClass();
                pk0 pk0Var = (pk0) workspace.B0(new cx(i2));
                if (pk0Var != null) {
                    pk0Var.setLabel(ae0Var.k.getText());
                }
                ae0Var.dismiss();
                break;
            case 7:
                pk0 pk0Var2 = (pk0) obj;
                pk0Var2.getClass();
                try {
                    Object tag = pk0Var2.getTag();
                    Objects.toString(tag);
                    if (tag instanceof qk0) {
                        qk0 qk0Var = (qk0) tag;
                        if (t.getAppInfoFlags(tag) == null) {
                            int i3 = qk0Var.h;
                            if (i3 == 1 || i3 == 4 || i3 == 5) {
                                DeleteDropTarget.u(pk0Var2.j, qk0Var, pk0Var2);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
                break;
            case 8:
                wq wqVar = ((mm0) obj).l;
                if (wqVar != null && !wqVar.w) {
                    wqVar.o.setVisibility(0);
                    wqVar.n.setVisibility(0);
                    wqVar.o();
                    break;
                }
                break;
            case 9:
                Context context3 = ((PhotoWidget_2x2) obj).k;
                if (context3 instanceof t) {
                    if (!ar1.j) {
                        e42.p((t) context3);
                    } else {
                        e42.o((t) context3);
                    }
                }
                break;
            case 10:
                AlertDialog alertDialog = ((za1) obj).b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                break;
            case 11:
                int i4 = SlidingUpCustomizeColorIconStyle.b0;
                ((SlidingUpCustomizeColorIconStyle) obj).setPanelState(rh1Var);
                break;
            case 12:
                int i5 = SlidingUpWidgetsAppStyle.W;
                ((SlidingUpWidgetsAppStyle) obj).setPanelState(rh1Var);
                break;
            case 13:
                int i6 = SlidingUpWidgetsCellAppStyle.W;
                ((SlidingUpWidgetsCellAppStyle) obj).setPanelState(rh1Var);
                break;
            default:
                int i7 = SlidingUpWidgetsList.a0;
                ((SlidingUpWidgetsList) obj).setPanelState(rh1Var);
                break;
        }
    }
}
