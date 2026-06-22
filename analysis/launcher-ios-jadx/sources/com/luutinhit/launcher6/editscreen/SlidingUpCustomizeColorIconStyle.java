package com.luutinhit.launcher6.editscreen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.luutinhit.launcher6.FastBitmapDrawable;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcherios.customui.ColorSeekBar;
import defpackage.ar1;
import defpackage.bo1;
import defpackage.fg0;
import defpackage.g7;
import defpackage.k8;
import defpackage.l51;
import defpackage.nh1;
import defpackage.rb1;
import defpackage.sh1;
import defpackage.v51;
import defpackage.vq;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpCustomizeColorIconStyle extends sh1 implements fg0, RadioGroup.OnCheckedChangeListener {
    public static final /* synthetic */ int b0 = 0;
    public final t P;
    public RadioGroup Q;
    public AppCompatRadioButton R;
    public ColorSeekBar S;
    public ConstraintLayoutRound T;
    public int U;
    public int V;
    public final bo1 W;
    public final Rect a0;

    public SlidingUpCustomizeColorIconStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = 1;
        this.a0 = new Rect();
        t tVar = (t) context;
        this.P = tVar;
        this.W = tVar.getTinyDB();
    }

    public static /* synthetic */ void j(SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle, Bitmap bitmap, int i) {
        slidingUpCustomizeColorIconStyle.W.f(i, "color_tinted_app");
        slidingUpCustomizeColorIconStyle.U = i;
        if (bitmap != null) {
            slidingUpCustomizeColorIconStyle.R.getBackground().setColorFilter(FastBitmapDrawable.b(i, bitmap));
            slidingUpCustomizeColorIconStyle.R.postInvalidate();
        }
        slidingUpCustomizeColorIconStyle.setTintedCurrentWorkspaceColor(i);
    }

    private void setTintedCurrentWorkspaceColor(int i) {
        t tVar = this.P;
        if (tVar.getWorkspace() != null) {
            tVar.getWorkspace().getCurrentCellLayout().getShortcutsAndWidgets().m(i);
            tVar.getHotseat().getShortcutsAndWidgets().m(i);
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == v51.icon_tinted_app) {
            if (this.V != 2) {
                this.V = 2;
                this.T.animate().translationY(0.0f).setDuration(268L).setInterpolator(new DecelerateInterpolator()).start();
                setTintedCurrentWorkspaceColor(this.U);
            }
        } else if (i == v51.icon_light_app) {
            if (this.V != 1) {
                this.V = 1;
                postOnAnimation(new nh1(this, 0));
            }
        } else if (i == v51.icon_dark_app && this.V != 0) {
            this.V = 0;
            this.U = 0;
            setTintedCurrentWorkspaceColor(0);
        }
        this.W.f(this.V, "color_icon_style");
    }

    @Override // defpackage.sh1, android.view.View
    public final void onFinishInflate() {
        int i = 1;
        super.onFinishInflate();
        this.R = (AppCompatRadioButton) findViewById(v51.icon_tinted_app);
        this.S = (ColorSeekBar) findViewById(v51.color_seekbar_tinted_app);
        Resources resources = getResources();
        int i2 = l51.new_weather_icon_dark_rounded;
        Resources.Theme theme = this.P.getTheme();
        ThreadLocal threadLocal = rb1.a;
        Bitmap bitmapK = ar1.k(resources.getDrawable(i2, theme));
        this.Q = (RadioGroup) findViewById(v51.icon_selected_style);
        this.T = (ConstraintLayoutRound) findViewById(v51.customize_color_icon_style_content);
        this.S.setOnColorChangeListener(new k8(this, bitmapK, 5));
        int i3 = this.W.a.getInt("color_icon_style", 1);
        this.V = i3;
        this.Q.check(i3 == 1 ? v51.icon_light_app : i3 == 0 ? v51.icon_dark_app : v51.icon_tinted_app);
        this.Q.setOnCheckedChangeListener(this);
        a(new vq(this, i));
        findViewById(v51.out_side_customize_color_icon_style).setOnClickListener(new g7(this, 11));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 8 || this.V == 1) {
            return;
        }
        postOnAnimation(new nh1(this, 1));
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.a0;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        setPadding(0, 0, 0, 0);
    }
}
