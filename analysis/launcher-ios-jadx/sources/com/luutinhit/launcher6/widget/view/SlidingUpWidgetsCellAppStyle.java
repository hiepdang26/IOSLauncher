package com.luutinhit.launcher6.widget.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;
import com.luutinhit.launcher6.editscreen.ConstraintLayoutRound;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import defpackage.co0;
import defpackage.fg0;
import defpackage.g7;
import defpackage.gx1;
import defpackage.jk0;
import defpackage.m7;
import defpackage.o5;
import defpackage.rk0;
import defpackage.sh1;
import defpackage.v11;
import defpackage.v51;
import defpackage.vh1;
import defpackage.w11;
import defpackage.xg0;
import defpackage.zw1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpWidgetsCellAppStyle extends sh1 implements View.OnClickListener, fg0 {
    public static final /* synthetic */ int W = 0;
    public final t P;
    public ViewPager Q;
    public final Rect R;
    public gx1 S;
    public boolean T;
    public ConstraintLayoutRound U;
    public vh1 V;

    public SlidingUpWidgetsCellAppStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.R = new Rect();
        t tVar = (t) context;
        this.P = tVar;
        this.T = tVar.isDarkMode;
    }

    private gx1 getWidgetPreviewLoader() {
        if (this.S == null) {
            this.S = jk0.a().c;
        }
        return this.S;
    }

    public final void j(ArrayList arrayList, WidgetsContainerView widgetsContainerView, WidgetsContainerView widgetsContainerView2) {
        char c = 0;
        if (getWidgetPreviewLoader() == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            t tVar = this.P;
            zw1 zw1Var = new zw1(tVar);
            zw1Var.setOnClickListener(widgetsContainerView);
            zw1Var.setOnLongClickListener(widgetsContainerView2);
            boolean z = arrayList.get(i) instanceof rk0;
            String str = zw1Var.m;
            if (z) {
                rk0 rk0Var = (rk0) arrayList.get(i);
                zw1Var.setTag(new w11(tVar, rk0Var));
                gx1 gx1Var = this.S;
                xg0 xg0Var = jk0.a().e;
                zw1Var.n = rk0Var;
                zw1Var.k.setText(m7.f(zw1Var.getContext()).j(rk0Var));
                int iMin = Math.min(rk0Var.g, xg0Var.d);
                int iMin2 = Math.min(rk0Var.h, xg0Var.c);
                TextView textView = zw1Var.l;
                Integer numValueOf = Integer.valueOf(iMin);
                Integer numValueOf2 = Integer.valueOf(iMin2);
                Object[] objArr = new Object[2];
                objArr[c] = numValueOf;
                objArr[1] = numValueOf2;
                textView.setText(String.format(str, objArr));
                zw1Var.o = gx1Var;
            } else {
                if (arrayList.get(i) instanceof ResolveInfo) {
                    ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i);
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    v11 v11Var = new v11();
                    v11Var.y = activityInfo;
                    v11Var.x = new ComponentName(activityInfo.packageName, activityInfo.name);
                    v11Var.h = 1;
                    zw1Var.setTag(v11Var);
                    PackageManager packageManager = tVar.getPackageManager();
                    gx1 gx1Var2 = this.S;
                    zw1Var.n = resolveInfo;
                    zw1Var.k.setText(resolveInfo.loadLabel(packageManager));
                    zw1Var.l.setText(String.format(str, 1, 1));
                    zw1Var.o = gx1Var2;
                }
                zw1Var.a();
                c = 0;
                zw1Var.setVisibility(0);
                arrayList2.add(zw1Var);
            }
            zw1Var.a();
            c = 0;
            zw1Var.setVisibility(0);
            arrayList2.add(zw1Var);
        }
        this.Q.setAdapter(new co0(arrayList2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        vh1 vh1Var = this.V;
        if (vh1Var != null) {
            o5 o5Var = (o5) vh1Var;
            o5Var.getClass();
            ((WidgetsContainerView) o5Var.h).k();
        }
    }

    @Override // defpackage.sh1, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        ConstraintLayoutRound constraintLayoutRound = (ConstraintLayoutRound) findViewById(v51.widgets_content);
        this.U = constraintLayoutRound;
        constraintLayoutRound.setDarkModeBackgroundColor(this.T ? -14935012 : -2565928);
        ((AppCompatButton) findViewById(v51.add_button_widgets_app_style)).setOnClickListener(this);
        this.Q = (ViewPager) findViewById(v51.view_pager_widgets_scroll_container);
        findViewById(v51.out_side_widgets_app_style).setOnClickListener(new g7(this, 13));
    }

    public void setDarkMode(boolean z) {
        this.T = z;
        ConstraintLayoutRound constraintLayoutRound = this.U;
        if (constraintLayoutRound != null) {
            constraintLayoutRound.setDarkModeBackgroundColor(z ? -14935012 : -2565928);
        }
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.R;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        setPadding(0, 0, 0, 0);
    }

    public void setOnAddWidgetButtonClickListener(vh1 vh1Var) {
        this.V = vh1Var;
    }
}
