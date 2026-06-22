package defpackage;

import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcher6.leftpage.database.LeftPageWidgetDatabase_Impl;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rq implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ wq h;

    public /* synthetic */ rq(wq wqVar, int i) {
        this.g = i;
        this.h = wqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        View dragView;
        SlidingUpWidgetsAppStyle slidingUpWidgetsAppStyle;
        int i = 2;
        rh1 rh1Var = rh1.g;
        rh1 rh1Var2 = rh1.h;
        int i2 = 0;
        wq wqVar = this.h;
        switch (this.g) {
            case 0:
                ArrayList arrayList2 = wqVar.s;
                qm0 qm0Var = wqVar.t;
                qm0Var.getClass();
                lc1 lc1VarA = lc1.a(0, "SELECT * FROM leftpagewidget ORDER BY `order`");
                LeftPageWidgetDatabase_Impl leftPageWidgetDatabase_Impl = (LeftPageWidgetDatabase_Impl) qm0Var.a;
                leftPageWidgetDatabase_Impl.b();
                Cursor cursorL = leftPageWidgetDatabase_Impl.l(lc1VarA);
                try {
                    int iN = hg0.n(cursorL, "widgetId");
                    int iN2 = hg0.n(cursorL, "layoutId");
                    int iN3 = hg0.n(cursorL, "order");
                    int iN4 = hg0.n(cursorL, "size");
                    int iN5 = hg0.n(cursorL, "type");
                    ArrayList arrayList3 = new ArrayList(cursorL.getCount());
                    while (cursorL.moveToNext()) {
                        hm0 hm0Var = new hm0();
                        hm0Var.a = cursorL.getInt(iN);
                        hm0Var.b = cursorL.getInt(iN2);
                        hm0Var.c = cursorL.getInt(iN3);
                        hm0Var.d = cursorL.getInt(iN4);
                        hm0Var.e = cursorL.getInt(iN5);
                        arrayList3.add(hm0Var);
                        break;
                    }
                    cursorL.close();
                    lc1VarA.k();
                    arrayList2.addAll(arrayList3);
                    if (arrayList2.isEmpty()) {
                        try {
                            String string = wqVar.i.a.getString("list_choose_widget", null);
                            arrayList = string != null ? new ArrayList(Arrays.asList(TextUtils.split(string, "‚‗‚"))) : new ArrayList(Arrays.asList("widget_weather", "widget_battery", "widget_suggestion"));
                        } catch (Throwable unused) {
                            arrayList = new ArrayList(Arrays.asList("widget_weather", "widget_battery", "widget_suggestion"));
                        }
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj = arrayList.get(i3);
                            i3++;
                            String str = (String) obj;
                            str.getClass();
                            switch (str) {
                                case "widget_battery":
                                    wqVar.l(60);
                                    break;
                                case "widget_calendar":
                                    wqVar.l(40);
                                    break;
                                case "widget_suggestion":
                                    wqVar.l(71);
                                    break;
                                case "widget_weather":
                                    wqVar.l(11);
                                    break;
                                case "widget_favorite":
                                    wqVar.l(51);
                                    break;
                            }
                        }
                        arrayList.clear();
                        wqVar.i.i("list_choose_widget", arrayList);
                        break;
                    }
                    wqVar.post(new rq(wqVar, 4));
                    return;
                } catch (Throwable th) {
                    cursorL.close();
                    lc1VarA.k();
                    throw th;
                }
            case 1:
                wqVar.q.requestFocus();
                wqVar.q.setVisibility(0);
                wqVar.q.setPanelState(rh1Var);
                return;
            case 2:
                wqVar.p.requestFocus();
                return;
            case 3:
                break;
            case 4:
                wqVar.u.g.d(0, wqVar.s.size(), null);
                return;
            case 5:
                wqVar.p.requestFocus();
                wqVar.p.setVisibility(0);
                wqVar.p.setPanelState(rh1Var);
                wqVar.n();
                wqVar.o.setVisibility(8);
                wqVar.n.setVisibility(8);
                wqVar.p.post(new rq(wqVar, i));
                return;
            case 6:
                if (wqVar.q.isShown() && (slidingUpWidgetsAppStyle = wqVar.q) != null) {
                    slidingUpWidgetsAppStyle.postOnAnimation(new rq(wqVar, 7));
                }
                wqVar.p.clearFocus();
                wqVar.p.setVisibility(8);
                wqVar.p.setPanelStateInternal(rh1Var2);
                wqVar.p.f();
                SlidingUpWidgetsList slidingUpWidgetsList = wqVar.p;
                if (slidingUpWidgetsList == null || (dragView = slidingUpWidgetsList.getDragView()) == null) {
                    return;
                }
                dragView.setScaleX(1.0f);
                dragView.setScaleY(1.0f);
                return;
            default:
                wqVar.q.clearFocus();
                wqVar.q.setVisibility(8);
                wqVar.q.setPanelStateInternal(rh1Var2);
                wqVar.q.f();
                return;
        }
        while (true) {
            ArrayList arrayList4 = wqVar.s;
            try {
                if (i2 >= arrayList4.size()) {
                    return;
                }
                hm0 hm0Var2 = (hm0) arrayList4.get(i2);
                int iIndexOf = arrayList4.indexOf(hm0Var2);
                hm0Var2.c = iIndexOf;
                wqVar.t.g(hm0Var2.a, iIndexOf);
                i2++;
            } catch (Throwable th2) {
                th2.getMessage();
                return;
            }
        }
    }
}
