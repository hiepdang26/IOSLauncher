package defpackage;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class px1 extends m81 {
    public final t j;
    public final LayoutInflater k;
    public qx1 l;
    public gx1 m;
    public final WidgetsContainerView n;
    public final WidgetsContainerView o;
    public boolean p;
    public boolean q;
    public final WidgetsContainerView r;
    public boolean[] s;

    public px1(Context context, WidgetsContainerView widgetsContainerView, WidgetsContainerView widgetsContainerView2, WidgetsContainerView widgetsContainerView3, t tVar) {
        this.k = LayoutInflater.from(context);
        this.r = widgetsContainerView3;
        this.n = widgetsContainerView;
        this.o = widgetsContainerView2;
        this.j = tVar;
        Resources resources = tVar.getResources();
        xu deviceProfile = tVar.getDeviceProfile();
        if (deviceProfile.c || deviceProfile.b) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Rect rect = ar1.a;
            Math.round(TypedValue.applyDimension(1, 56.0f, displayMetrics));
        }
    }

    @Override // defpackage.m81
    public final int c() {
        qx1 qx1Var = this.l;
        if (qx1Var == null) {
            return 0;
        }
        qx1Var.b.size();
        return this.l.b.size();
    }

    @Override // defpackage.m81
    public final long d(int i) {
        return i;
    }

    @Override // defpackage.m81
    public final int e(int i) {
        return (this.l.b.size() == this.l.a.size() && i == 0) ? 1 : 2;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        WidgetsContainerView widgetsContainerView = this.o;
        WidgetsContainerView widgetsContainerView2 = this.n;
        t tVar = this.j;
        try {
            final int iE = m91Var.e();
            this.p = true;
            ArrayList arrayList = this.l.b;
            s01 s01Var = (iE >= arrayList.size() || iE < 0) ? null : (s01) arrayList.get(iE);
            qx1 qx1Var = this.l;
            final ArrayList arrayList2 = (ArrayList) qx1Var.d.get(qx1Var.b.get(iE));
            arrayList2.size();
            int iE2 = e(iE);
            if (iE2 == 1) {
                dm0 dm0Var = ((nx1) m91Var).A;
                dm0Var.setOnClickListener(widgetsContainerView2);
                dm0Var.setOnLongClickListener(widgetsContainerView);
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                dm0 dm0Var2 = ((nx1) m91Var).B;
                dm0Var2.setOnClickListener(widgetsContainerView2);
                dm0Var2.setOnLongClickListener(widgetsContainerView);
                arrayList3.add(dm0Var2);
                arrayList4.add(((nx1) m91Var).E);
                dm0 dm0Var3 = ((nx1) m91Var).C;
                dm0Var3.setOnClickListener(widgetsContainerView2);
                dm0Var3.setOnLongClickListener(widgetsContainerView);
                arrayList3.add(dm0Var3);
                arrayList4.add(((nx1) m91Var).F);
                if (this.m == null) {
                    this.m = jk0.a().c;
                }
                if (this.m == null) {
                    return;
                }
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    rk0 rk0Var = (rk0) arrayList2.get(i2);
                    w11 w11Var = new w11(tVar, rk0Var);
                    rk0Var.toString();
                    ComponentName componentName = ((AppWidgetProviderInfo) rk0Var).provider;
                    if (componentName == null || !componentName.getClassName().contains("WeatherAppWidgetProvider")) {
                        ComponentName componentName2 = ((AppWidgetProviderInfo) rk0Var).provider;
                        if (componentName2 == null || !componentName2.getClassName().contains("BatteryWidgetProvider")) {
                            ComponentName componentName3 = ((AppWidgetProviderInfo) rk0Var).provider;
                            if (componentName3 != null && componentName3.getClassName().contains("PictureAppWidgetProvider")) {
                                dm0Var3.setTag(w11Var);
                                dm0Var3.setVisibility(0);
                                ((nx1) m91Var).F.setText(m7.f(tVar).j(rk0Var));
                                ((nx1) m91Var).F.setTextColor(this.q ? -1 : -16777216);
                            }
                        } else {
                            dm0Var2.setTag(w11Var);
                            dm0Var2.setVisibility(0);
                            ((nx1) m91Var).E.setText(m7.f(tVar).j(rk0Var));
                            ((nx1) m91Var).E.setTextColor(this.q ? -1 : -16777216);
                        }
                    } else {
                        dm0Var.setTag(w11Var);
                        dm0Var.setVisibility(0);
                        ((nx1) m91Var).D.setText(m7.f(tVar).j(rk0Var));
                        ((nx1) m91Var).D.setTextColor(this.q ? -1 : -16777216);
                    }
                }
            } else if (iE2 == 2) {
                m91Var.g.setOnClickListener(new View.OnClickListener() { // from class: ox1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i3 = iE;
                        ArrayList arrayList5 = arrayList2;
                        px1 px1Var = this.g;
                        px1Var.getClass();
                        try {
                            boolean z = px1Var.s[i3];
                            if (!px1Var.p) {
                                px1Var.g(i3);
                            }
                            px1Var.s[i3] = !r2[i3];
                            WidgetsContainerView widgetsContainerView3 = px1Var.r;
                            if (widgetsContainerView3 != null) {
                                t tVar2 = widgetsContainerView3.P;
                                Objects.toString(tVar2.mWidgetsAppStyle);
                                tVar2.mWidgetsAppStyle.j(arrayList5, widgetsContainerView3, widgetsContainerView3);
                                tVar2.mWidgetsAppStyle.post(new mx1(widgetsContainerView3, 0));
                            }
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                    }
                });
                boolean z = this.s[iE];
                ((rx1) m91Var).B.n(s01Var);
                String str = s01Var.z;
                ((rx1) m91Var).C.setText(s01Var.u);
                ((rx1) m91Var).C.setTextColor(this.q ? -1 : -16777216);
            }
            this.p = false;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = this.k;
        if (i != 1) {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(m61.widgets_list_row_view, viewGroup, false);
            rx1 rx1Var = new rx1(viewGroup2);
            rx1Var.A = viewGroup2;
            BubbleTextView bubbleTextView = (BubbleTextView) viewGroup2.findViewById(v51.section);
            rx1Var.B = bubbleTextView;
            bubbleTextView.getName().setVisibility(8);
            rx1Var.C = (TextViewCustomFont) viewGroup2.findViewById(v51.widget_app_name);
            return rx1Var;
        }
        View viewInflate = layoutInflater.inflate(m61.widgets_full_row_view, viewGroup, false);
        nx1 nx1Var = new nx1(viewInflate);
        nx1Var.A = (dm0) viewInflate.findViewById(v51.widget_full_preview_item);
        nx1Var.B = (dm0) viewInflate.findViewById(v51.widget_square_preview_item_1);
        nx1Var.C = (dm0) viewInflate.findViewById(v51.widget_square_preview_item_2);
        nx1Var.D = (TextViewCustomFont) viewInflate.findViewById(v51.widget_full_preview_text);
        nx1Var.E = (TextViewCustomFont) viewInflate.findViewById(v51.widget_square_preview_text_1);
        nx1Var.F = (TextViewCustomFont) viewInflate.findViewById(v51.widget_square_preview_text_2);
        return nx1Var;
    }

    @Override // defpackage.m81
    public final void n(m91 m91Var) {
    }
}
