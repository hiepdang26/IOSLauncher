package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TooltipCompat;
import defpackage.ft0;
import defpackage.gt0;
import defpackage.h1;
import defpackage.i1;
import defpackage.mt0;
import defpackage.q71;
import defpackage.xt0;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements xt0, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    public mt0 g;
    public CharSequence h;
    public Drawable i;
    public ft0 j;
    public h1 k;
    public i1 l;
    public boolean m;
    public boolean n;
    public final int o;
    public int p;
    public final int q;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.m = b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q71.ActionMenuItemView, 0, 0);
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(q71.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.p = -1;
        setSaveEnabled(false);
    }

    @Override // defpackage.xt0
    public final void a(mt0 mt0Var) {
        this.g = mt0Var;
        setIcon(mt0Var.getIcon());
        setTitle(mt0Var.getTitleCondensed());
        setId(mt0Var.g);
        setVisibility(mt0Var.isVisible() ? 0 : 8);
        setEnabled(mt0Var.isEnabled());
        if (mt0Var.hasSubMenu() && this.k == null) {
            this.k = new h1(this);
        }
    }

    public final boolean b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    public final void c() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.h);
        if (this.i != null && ((this.g.E & 4) != 4 || (!this.m && !this.n))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.h : null);
        CharSequence charSequence = this.g.w;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z3 ? null : this.g.k);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.g.x;
        if (TextUtils.isEmpty(charSequence2)) {
            TooltipCompat.setTooltipText(this, z3 ? null : this.g.k);
        } else {
            TooltipCompat.setTooltipText(this, charSequence2);
        }
    }

    @Override // defpackage.xt0
    public mt0 getItemData() {
        return this.g;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public final boolean needsDividerAfter() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public final boolean needsDividerBefore() {
        return !TextUtils.isEmpty(getText()) && this.g.getIcon() == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ft0 ft0Var = this.j;
        if (ft0Var != null) {
            ft0Var.invokeItem(this.g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.m = b();
        c();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i3 = this.p) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.o;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i4) : i4;
        if (mode != 1073741824 && i4 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (!zIsEmpty || this.i == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        h1 h1Var;
        if (this.g.hasSubMenu() && (h1Var = this.k) != null && h1Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.n != z) {
            this.n = z;
            mt0 mt0Var = this.g;
            if (mt0Var != null) {
                gt0 gt0Var = mt0Var.t;
                gt0Var.q = true;
                gt0Var.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.i = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.q;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        c();
    }

    public void setItemInvoker(ft0 ft0Var) {
        this.j = ft0Var;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.p = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(i1 i1Var) {
        this.l = i1Var;
    }

    public void setTitle(CharSequence charSequence) {
        this.h = charSequence;
        c();
    }
}
