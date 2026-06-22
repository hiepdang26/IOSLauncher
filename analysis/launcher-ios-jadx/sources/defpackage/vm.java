package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class vm extends dm0 {
    public final String g;
    public final t h;
    public ValueAnimator i;
    public int j;

    public vm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = "BlurConstraintLayoutWidget";
        this.h = (t) context;
        o();
    }

    public final boolean o() {
        try {
            return this.h.isDarkMode;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void setTextAndBackgroundColor(ViewGroup viewGroup) {
        if (!o()) {
            ar1.A(viewGroup, -16777216);
            viewGroup.setBackgroundColor(getResources().getColor(x41.folder_color));
            return;
        }
        viewGroup.setBackgroundColor(getResources().getColor(x41.folder_color_dark));
        ar1.A(viewGroup, -1);
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(v51.more_icon);
        if (appCompatImageView != null) {
            az1.F(appCompatImageView, ColorStateList.valueOf(-2130706433));
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
    }

    public final void u(View view, boolean z) {
        int i;
        view.measure(-1, -2);
        int measuredHeight = view.getMeasuredHeight();
        int i2 = 0;
        if (z) {
            view.setVisibility(0);
            this.j = 1;
            i = measuredHeight;
        } else {
            this.j = 0;
            i2 = measuredHeight;
            i = 0;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, i);
        this.i = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new tm(this, view, measuredHeight));
        this.i.addListener(new um(this, view, 0));
        this.i.setDuration((int) ((measuredHeight * 2.6f) / getResources().getDisplayMetrics().density));
        this.i.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        this.i.start();
    }
}
