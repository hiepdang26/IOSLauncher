package com.luutinhit.launcher6.leftpage;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager2.widget.ViewPager2;
import com.luutinhit.launcher6.editscreen.FrameLayoutRound;
import com.luutinhit.launcher6.t;
import defpackage.e51;
import defpackage.fg0;
import defpackage.g7;
import defpackage.ix1;
import defpackage.o5;
import defpackage.rq;
import defpackage.sh1;
import defpackage.th1;
import defpackage.u7;
import defpackage.uh1;
import defpackage.v51;
import defpackage.wq;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpWidgetsAppStyle extends sh1 implements View.OnClickListener, fg0 {
    public static final /* synthetic */ int W = 0;
    public final t P;
    public u7 Q;
    public ViewPager2 R;
    public boolean S;
    public FrameLayoutRound T;
    public final Rect U;
    public uh1 V;

    public SlidingUpWidgetsAppStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = new Rect();
        t tVar = (t) context;
        this.P = tVar;
        this.S = tVar.isDarkMode;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        uh1 uh1Var;
        int currentItem = this.R.getCurrentItem();
        ArrayList arrayList = this.Q.k;
        ix1 ix1Var = arrayList != null ? (ix1) arrayList.get(currentItem) : null;
        if (ix1Var == null || (uh1Var = this.V) == null) {
            return;
        }
        wq wqVar = (wq) ((o5) uh1Var).h;
        wqVar.o();
        wqVar.l(ix1Var.b);
        SlidingUpWidgetsAppStyle slidingUpWidgetsAppStyle = wqVar.q;
        if (slidingUpWidgetsAppStyle != null) {
            slidingUpWidgetsAppStyle.postOnAnimation(new rq(wqVar, 7));
        }
        SlidingUpWidgetsList slidingUpWidgetsList = wqVar.p;
        if (slidingUpWidgetsList != null) {
            slidingUpWidgetsList.postOnAnimation(new rq(wqVar, 6));
        }
        wqVar.o.setVisibility(0);
        wqVar.n.setVisibility(0);
    }

    @Override // defpackage.sh1, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        FrameLayoutRound frameLayoutRound = (FrameLayoutRound) findViewById(v51.widgets_content);
        this.T = frameLayoutRound;
        frameLayoutRound.setDarkModeBackgroundColor(this.S ? -14935012 : -2565928);
        ((AppCompatButton) findViewById(v51.add_button_widgets_app_style)).setOnClickListener(this);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(v51.view_pager_widgets_app_style);
        this.R = viewPager2;
        viewPager2.setOffscreenPageLimit(3);
        t tVar = this.P;
        this.R.setPageTransformer(new th1(tVar.getResources().getDimensionPixelOffset(e51.sliding_up_widgets_app_style_page_offset), tVar.getResources().getDimensionPixelOffset(e51.sliding_up_widgets_app_style_page_margin)));
        findViewById(v51.out_side_widgets_app_style).setOnClickListener(new g7(this, 12));
    }

    public void setDarkMode(boolean z) {
        this.S = z;
        FrameLayoutRound frameLayoutRound = this.T;
        if (frameLayoutRound != null) {
            frameLayoutRound.setDarkModeBackgroundColor(z ? -14935012 : -2565928);
        }
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.U;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        setPadding(0, 0, 0, 0);
    }

    public void setOnAddWidgetButtonClickListener(uh1 uh1Var) {
        this.V = uh1Var;
    }

    public void setWidgetsAppStyleList(ArrayList<ix1> arrayList) {
        u7 u7Var = new u7(1);
        u7Var.k = arrayList;
        this.Q = u7Var;
        this.R.setAdapter(u7Var);
    }
}
