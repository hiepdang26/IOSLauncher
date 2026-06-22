package com.luutinhit.launcher6.leftpage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.leftpage.adapter.WrapStaggeredGridLayoutManager;
import com.luutinhit.launcher6.t;
import defpackage.cx1;
import defpackage.g7;
import defpackage.ix1;
import defpackage.k7;
import defpackage.l51;
import defpackage.sh1;
import defpackage.v51;
import defpackage.w61;
import defpackage.wh1;
import defpackage.yh1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpWidgetsList extends sh1 {
    public static final /* synthetic */ int a0 = 0;
    public final t P;
    public yh1 Q;
    public RecyclerView R;
    public final ArrayList S;
    public final int T;
    public boolean U;
    public LinearLayoutRound V;
    public wh1 W;

    public SlidingUpWidgetsList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = new ArrayList();
        t tVar = (t) context;
        this.P = tVar;
        this.T = tVar.getDeviceProfile().C;
        this.U = tVar.isDarkMode;
    }

    @Override // defpackage.sh1, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.R = (RecyclerView) findViewById(v51.left_page_widgets_lists);
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(v51.widgets_content_list);
        this.V = linearLayoutRound;
        linearLayoutRound.setDarkModeBackgroundColor(this.U ? -14935012 : -2565928);
        findViewById(v51.out_side_widgets_list).setOnClickListener(new g7(this, 14));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.R.getLayoutParams();
        int i = this.T;
        double d = i;
        double d2 = 0.68d * d;
        int i2 = (int) d2;
        layoutParams.rightMargin = i2;
        layoutParams.leftMargin = i2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById(v51.search_box).getLayoutParams();
        int i3 = (int) (d2 + d);
        layoutParams2.rightMargin = i3;
        layoutParams2.leftMargin = i3;
        ArrayList arrayList = new ArrayList();
        int i4 = l51.sample_weather_widget_square;
        t tVar = this.P;
        arrayList.add(new ix1(tVar.getDrawable(i4), 10));
        arrayList.add(new ix1(tVar.getDrawable(l51.sample_weather_widget), 11));
        cx1 cx1Var = new cx1(tVar.getDrawable(l51.sample_weather_widget), tVar.getString(w61.weather), 1, arrayList);
        ArrayList arrayList2 = this.S;
        arrayList2.add(cx1Var);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new ix1(tVar.getDrawable(l51.sample_battery_widget), 60));
        arrayList2.add(new cx1(tVar.getDrawable(l51.sample_battery_widget), tVar.getString(w61.battery), 0, arrayList3));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new ix1(tVar.getDrawable(l51.sample_photo_widget), 30));
        arrayList2.add(new cx1(tVar.getDrawable(l51.sample_photo_widget), tVar.getString(w61.picture), 0, arrayList4));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new ix1(tVar.getDrawable(l51.sample_app_suggestions), 71));
        arrayList2.add(new cx1(tVar.getDrawable(l51.sample_app_suggestions), tVar.getString(w61.suggestions), 1, arrayList5));
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new ix1(tVar.getDrawable(l51.sample_contact_favorite), 51));
        arrayList2.add(new cx1(tVar.getDrawable(l51.sample_contact_favorite), tVar.getString(w61.favorites), 1, arrayList6));
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(new ix1(tVar.getDrawable(l51.sample_calendar_widget), 40));
        arrayList2.add(new cx1(tVar.getDrawable(l51.sample_calendar_widget), tVar.getString(w61.calendar), 0, arrayList7));
        this.Q = new yh1(arrayList2, this.U);
        WrapStaggeredGridLayoutManager wrapStaggeredGridLayoutManager = new WrapStaggeredGridLayoutManager();
        this.R.k(new k7(i, 2));
        this.R.setLayoutManager(wrapStaggeredGridLayoutManager);
        this.R.setAdapter(this.Q);
        this.Q.l = this;
    }

    public void setDarkMode(boolean z) {
        this.U = z;
        LinearLayoutRound linearLayoutRound = this.V;
        if (linearLayoutRound != null) {
            linearLayoutRound.setDarkModeBackgroundColor(z ? -14935012 : -2565928);
        }
        yh1 yh1Var = this.Q;
        if (yh1Var != null) {
            yh1Var.k = z;
        }
    }

    public void setOnItemClickListener(wh1 wh1Var) {
        this.W = wh1Var;
    }
}
