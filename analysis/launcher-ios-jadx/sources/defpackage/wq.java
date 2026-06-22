package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcher6.leftpage.adapter.WrapStaggeredGridLayoutManager;
import com.luutinhit.launcher6.leftpage.database.LeftPageWidgetDatabase;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class wq extends ConstraintLayout implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, wh1 {
    public final t g;
    public final IOSLauncher h;
    public final bo1 i;
    public final mf0 j;
    public final int k;
    public final FrameLayout l;
    public final RealTimeBlurView m;
    public final AppCompatButton n;
    public final AppCompatButton o;
    public final SlidingUpWidgetsList p;
    public final SlidingUpWidgetsAppStyle q;
    public final BouncyRecyclerView r;
    public final ArrayList s;
    public final qm0 t;
    public final mm0 u;
    public final PathInterpolator v;
    public boolean w;
    public final fz1 x;

    public wq(IOSLauncher iOSLauncher) {
        super(iOSLauncher, null, 0);
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        this.v = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        this.w = false;
        this.x = new fz1(this, 9);
        LayoutInflater.from(iOSLauncher).inflate(m61.layout_custom_content, (ViewGroup) this, true);
        this.h = iOSLauncher;
        this.g = iOSLauncher;
        bo1 tinyDB = iOSLauncher.getTinyDB();
        this.i = tinyDB;
        tinyDB.j(this);
        setX(0.0f);
        setY(0.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        this.k = this.g.getDeviceProfile().C;
        IOSLauncher iOSLauncher2 = this.h;
        mf0 mf0Var = new mf0(iOSLauncher2, null);
        mf0Var.setTypeface(Typeface.createFromAsset(iOSLauncher2.getAssets(), "fonts/SFProTextLight.otf"));
        mf0Var.setGravity(17);
        mf0Var.setClickable(true);
        mf0Var.setFocusable(true);
        mf0Var.setLinksClickable(true);
        mf0Var.setLinkTextColor(-16776961);
        mf0Var.setAutoLinkMask(1);
        mf0Var.setText(w61.weather_infomation_provided);
        mf0Var.setTextColor(-1);
        mf0Var.setTextSize(2, 11.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dimensionPixelSize = mf0Var.getResources().getDimensionPixelSize(e51.info_provided_margin);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.topMargin = dimensionPixelSize;
        mf0Var.setLayoutParams(layoutParams);
        mf0Var.setOnClickListener(new lf0(iOSLauncher2));
        this.j = mf0Var;
        this.r = (BouncyRecyclerView) findViewById(v51.recycler_view_list_widget);
        this.q = (SlidingUpWidgetsAppStyle) findViewById(v51.left_page_sliding_up_widgets_app_style);
        SlidingUpWidgetsList slidingUpWidgetsList = (SlidingUpWidgetsList) findViewById(v51.left_page_sliding_up_widgets_list);
        this.p = slidingUpWidgetsList;
        slidingUpWidgetsList.setOnItemClickListener(this);
        this.l = (FrameLayout) findViewById(v51.layout_list_widget_left_page);
        this.m = (RealTimeBlurView) findViewById(v51.realtime_blur_search_box_custom_content);
        this.o = (AppCompatButton) findViewById(v51.add_widgets_done);
        this.n = (AppCompatButton) findViewById(v51.add_widgets);
        this.m.setBlurredView(this.l);
        this.r.l(new hb(this, 2));
        this.r.setOnOverPullListener(new mc1(this, 8));
        Context applicationContext = this.g.getApplicationContext();
        if (LeftPageWidgetDatabase.l == null) {
            jc1 jc1VarM = az1.m(applicationContext, LeftPageWidgetDatabase.class, "Room-database");
            jc1VarM.l = false;
            jc1VarM.m = true;
            LeftPageWidgetDatabase.l = (LeftPageWidgetDatabase) jc1VarM.b();
        }
        this.t = LeftPageWidgetDatabase.l.p();
        mm0 mm0Var = new mm0(this, arrayList);
        this.u = mm0Var;
        mm0Var.l = this;
        WrapStaggeredGridLayoutManager wrapStaggeredGridLayoutManager = new WrapStaggeredGridLayoutManager();
        wrapStaggeredGridLayoutManager.c(null);
        if (2 != wrapStaggeredGridLayoutManager.C) {
            wrapStaggeredGridLayoutManager.C = 2;
            wrapStaggeredGridLayoutManager.p0();
        }
        this.r.setLayoutManager(wrapStaggeredGridLayoutManager);
        this.r.setAdapter((td) this.u);
        new Thread(new rq(this, 0)).start();
    }

    public xj0 getCallBack() {
        return this.x;
    }

    public final void l(int i) {
        hm0 hm0Var = new hm0();
        ArrayList arrayList = this.s;
        hm0Var.c = arrayList.size() + 1;
        hm0Var.e = i;
        arrayList.add(hm0Var);
        new Thread(new sq(this, hm0Var, 2)).start();
    }

    public final void n() {
        if (this.u != null) {
            this.w = false;
            for (int i = 0; i < this.r.getChildCount(); i++) {
                View childAt = this.r.getChildAt(i);
                if (childAt != null && this.u != null) {
                    m91 m91VarP = this.r.P(childAt);
                    if (m91VarP instanceof lm0) {
                        ((lm0) m91VarP).v();
                    }
                }
            }
            this.r.setLongPressDragEnabled(false);
        }
    }

    public final void o() {
        if (this.u != null) {
            this.w = true;
            for (int i = 0; i < this.r.getChildCount(); i++) {
                View childAt = this.r.getChildAt(i);
                if (childAt != null && this.u != null) {
                    m91 m91VarP = this.r.P(childAt);
                    if (m91VarP instanceof lm0) {
                        ((lm0) m91VarP).w();
                    }
                }
            }
            this.r.setLongPressDragEnabled(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        final int i = 0;
        this.o.setOnClickListener(new View.OnClickListener(this) { // from class: tq
            public final /* synthetic */ wq h;

            {
                this.h = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        wq wqVar = this.h;
                        wqVar.o.setVisibility(8);
                        wqVar.n.setVisibility(8);
                        wqVar.n();
                        SlidingUpWidgetsList slidingUpWidgetsList = wqVar.p;
                        if (slidingUpWidgetsList != null) {
                            slidingUpWidgetsList.postOnAnimation(new rq(wqVar, 6));
                        }
                        break;
                    default:
                        wq wqVar2 = this.h;
                        wqVar2.p.postOnAnimation(new rq(wqVar2, 5));
                        break;
                }
            }
        });
        final int i2 = 1;
        this.n.setOnClickListener(new View.OnClickListener(this) { // from class: tq
            public final /* synthetic */ wq h;

            {
                this.h = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        wq wqVar = this.h;
                        wqVar.o.setVisibility(8);
                        wqVar.n.setVisibility(8);
                        wqVar.n();
                        SlidingUpWidgetsList slidingUpWidgetsList = wqVar.p;
                        if (slidingUpWidgetsList != null) {
                            slidingUpWidgetsList.postOnAnimation(new rq(wqVar, 6));
                        }
                        break;
                    default:
                        wq wqVar2 = this.h;
                        wqVar2.p.postOnAnimation(new rq(wqVar2, 5));
                        break;
                }
            }
        });
        int i3 = 0;
        this.q.a(new uq(this, i3));
        this.p.a(new vq(this, i3));
        this.q.setOnAddWidgetButtonClickListener(new o5(this, 3));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null || str == null || !str.equals("icon_text_color")) {
            return;
        }
        this.j.setTextColor(sharedPreferences.getInt(str, -1));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        t tVar = this.g;
        int i5 = tVar.screenHeight;
        xu xuVar = tVar.mDeviceProfile;
        int i6 = ((xuVar.i + xuVar.I) - xuVar.D) - xuVar.F;
        int paddingBottom = this.r.getPaddingBottom();
        ((ViewGroup.MarginLayoutParams) ((nm) this.l.getLayoutParams())).height = this.g.screenHeight;
        ((ViewGroup.MarginLayoutParams) ((nm) this.p.getLayoutParams())).height = this.g.screenHeight;
        ((ViewGroup.MarginLayoutParams) ((nm) this.q.getLayoutParams())).height = this.g.screenHeight;
        BouncyRecyclerView bouncyRecyclerView = this.r;
        int i7 = this.k;
        bouncyRecyclerView.setPadding(i7, i6 - i7, i7, paddingBottom);
        nm nmVar = (nm) this.n.getLayoutParams();
        nm nmVar2 = (nm) this.o.getLayoutParams();
        int i8 = this.g.getDeviceProfile().i;
        ((ViewGroup.MarginLayoutParams) nmVar2).topMargin = i8;
        ((ViewGroup.MarginLayoutParams) nmVar).topMargin = i8;
        ((ViewGroup.MarginLayoutParams) ((nm) this.m.getLayoutParams())).height = paddingBottom;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void setDarkMode(boolean z) {
        this.p.setDarkMode(z);
        this.q.setDarkMode(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
