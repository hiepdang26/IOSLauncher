package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import defpackage.az1;
import defpackage.d51;
import defpackage.k51;
import defpackage.l61;
import defpackage.mt0;
import defpackage.p50;
import defpackage.qg0;
import defpackage.qs1;
import defpackage.r41;
import defpackage.rb1;
import defpackage.u51;
import defpackage.xt0;
import defpackage.yh;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends p50 implements xt0 {
    public static final int[] w = {R.attr.state_checked};
    public int m;
    public boolean n;
    public boolean o;
    public final CheckedTextView p;
    public FrameLayout q;
    public mt0 r;
    public ColorStateList s;
    public boolean t;
    public Drawable u;
    public final yh v;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        yh yhVar = new yh(this, 3);
        this.v = yhVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(l61.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(d51.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(u51.design_menu_item_text);
        this.p = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        qs1.p(checkedTextView, yhVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.q == null) {
                this.q = (FrameLayout) ((ViewStub) findViewById(u51.design_menu_item_action_area_stub)).inflate();
            }
            this.q.removeAllViews();
            this.q.addView(view);
        }
    }

    @Override // defpackage.xt0
    public final void a(mt0 mt0Var) {
        StateListDrawable stateListDrawable;
        this.r = mt0Var;
        int i = mt0Var.g;
        if (i > 0) {
            setId(i);
        }
        setVisibility(mt0Var.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(r41.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(w, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = qs1.a;
            setBackground(stateListDrawable);
        }
        setCheckable(mt0Var.isCheckable());
        setChecked(mt0Var.isChecked());
        setEnabled(mt0Var.isEnabled());
        setTitle(mt0Var.k);
        setIcon(mt0Var.getIcon());
        setActionView(mt0Var.getActionView());
        setContentDescription(mt0Var.w);
        TooltipCompat.setTooltipText(this, mt0Var.x);
        mt0 mt0Var2 = this.r;
        CharSequence charSequence = mt0Var2.k;
        CheckedTextView checkedTextView = this.p;
        if (charSequence == null && mt0Var2.getIcon() == null && this.r.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.q;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.q.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.q;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.q.setLayoutParams(layoutParams2);
        }
    }

    @Override // defpackage.xt0
    public mt0 getItemData() {
        return this.r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        mt0 mt0Var = this.r;
        if (mt0Var != null && mt0Var.isCheckable() && this.r.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, w);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.o != z) {
            this.o = z;
            this.v.h(this.p, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.p.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.t) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = az1.L(drawable).mutate();
                drawable.setTintList(this.s);
            }
            int i = this.m;
            drawable.setBounds(0, 0, i, i);
        } else if (this.n) {
            if (this.u == null) {
                Resources resources = getResources();
                int i2 = k51.navigation_empty_icon;
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = rb1.a;
                Drawable drawable2 = resources.getDrawable(i2, theme);
                this.u = drawable2;
                if (drawable2 != null) {
                    int i3 = this.m;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.u;
        }
        this.p.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.p.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.m = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.s = colorStateList;
        this.t = colorStateList != null;
        mt0 mt0Var = this.r;
        if (mt0Var != null) {
            setIcon(mt0Var.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.p.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.n = z;
    }

    public void setTextAppearance(int i) {
        qg0.K(this.p, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.p.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.p.setText(charSequence);
    }
}
