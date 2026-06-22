package com.luutinhit.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import defpackage.f4;
import defpackage.k31;
import defpackage.lw;
import defpackage.um;
import defpackage.v51;
import defpackage.xw;

/* JADX INFO: loaded from: classes.dex */
public class SearchDropTargetBar extends FrameLayout implements lw {
    public static final DecelerateInterpolator p = new DecelerateInterpolator(0.6f);
    public static final DecelerateInterpolator q = new DecelerateInterpolator(1.5f);
    public static final AccelerateInterpolator r = new AccelerateInterpolator();
    public static final int s = 175;
    public AnimatorSet g;
    public int h;
    public View i;
    public View j;
    public boolean k;
    public boolean l;
    public ButtonDropTarget m;
    public ButtonDropTarget n;
    public ButtonDropTarget o;

    public SearchDropTargetBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.h = 3;
        this.k = false;
        this.l = false;
    }

    public final void a(View view, float f, TimeInterpolator timeInterpolator) {
        if (Float.compare(view.getAlpha(), f) != 0) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, f);
            objectAnimatorOfFloat.setInterpolator(timeInterpolator);
            objectAnimatorOfFloat.addListener(new um(this, view));
            this.g.play(objectAnimatorOfFloat);
        }
    }

    public final void b(int i, int i2) {
        if (this.h != i) {
            this.h = i;
            this.l = ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled();
            AnimatorSet animatorSet = this.g;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.g = null;
            }
            this.g = null;
            TimeInterpolator timeInterpolator = r;
            if (i2 > 0) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.g = animatorSet2;
                animatorSet2.setDuration(i2);
                a(this.j, k31.f(this.h), timeInterpolator);
            } else {
                this.j.setAlpha(k31.f(this.h));
                f4.a(this.j, this.l);
            }
            if (this.i != null) {
                ((t) getContext()).getDeviceProfile().getClass();
                int i3 = this.h;
                float f = 0.0f;
                if (i3 != 1) {
                    if (i3 == 2) {
                        f = -1.0f;
                    } else if (i3 != 3 && i3 != 4) {
                        throw null;
                    }
                }
                float measuredHeight = f * getMeasuredHeight();
                if (i2 > 0) {
                    int iCompare = Float.compare(this.i.getTranslationY(), measuredHeight);
                    View view = this.i;
                    float fG = k31.g(this.h);
                    if (iCompare != 0) {
                        timeInterpolator = iCompare < 0 ? p : q;
                    }
                    a(view, fG, timeInterpolator);
                    if (iCompare != 0) {
                        this.g.play(ObjectAnimator.ofFloat(this.i, (Property<View, Float>) View.TRANSLATION_Y, measuredHeight));
                    }
                } else {
                    this.i.setTranslationY(measuredHeight);
                    this.i.setAlpha(k31.g(this.h));
                    f4.a(this.i, this.l);
                }
            }
            if (i2 > 0) {
                this.g.start();
            }
        }
    }

    public Rect getSearchBarBounds() {
        View view = this.i;
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        int i = iArr[0];
        rect.left = i;
        rect.top = iArr[1];
        rect.right = this.i.getWidth() + i;
        rect.bottom = this.i.getHeight() + iArr[1];
        return rect;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View viewFindViewById = findViewById(v51.drag_target_bar);
        this.j = viewFindViewById;
        this.m = (ButtonDropTarget) viewFindViewById.findViewById(v51.info_target_text);
        this.n = (ButtonDropTarget) this.j.findViewById(v51.delete_target_text);
        this.o = (ButtonDropTarget) this.j.findViewById(v51.uninstall_target_text);
        this.m.setSearchDropTargetBar(this);
        this.n.setSearchDropTargetBar(this);
        this.o.setSearchDropTargetBar(this);
        this.j.setAlpha(0.0f);
        f4.a(this.j, this.l);
    }

    @Override // defpackage.lw
    public final void s(xw xwVar, Object obj) {
        b(4, s);
    }

    public void setQsbSearchBar(View view) {
        this.i = view;
    }

    @Override // defpackage.lw
    public final void t() {
        if (this.k) {
            this.k = false;
        } else {
            b(3, s);
        }
    }
}
