package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import defpackage.az1;
import defpackage.b71;
import defpackage.f71;
import defpackage.hs1;
import defpackage.mn1;
import defpackage.np1;
import defpackage.q41;
import defpackage.qs1;
import defpackage.rr0;
import defpackage.tr0;
import defpackage.y4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final int l = b71.Widget_MaterialComponents_Toolbar;
    public static final ImageView.ScaleType[] m = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer g;
    public boolean h;
    public boolean i;
    public ImageView.ScaleType j;
    public Boolean k;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        int i = q41.toolbarStyle;
        int i2 = l;
        super(tr0.a(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayD = mn1.d(context2, attributeSet, f71.MaterialToolbar, i, i2, new int[0]);
        if (typedArrayD.hasValue(f71.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(typedArrayD.getColor(f71.MaterialToolbar_navigationIconTint, -1));
        }
        this.h = typedArrayD.getBoolean(f71.MaterialToolbar_titleCentered, false);
        this.i = typedArrayD.getBoolean(f71.MaterialToolbar_subtitleCentered, false);
        int i3 = typedArrayD.getInt(f71.MaterialToolbar_logoScaleType, -1);
        if (i3 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = m;
            if (i3 < scaleTypeArr.length) {
                this.j = scaleTypeArr[i3];
            }
        }
        if (typedArrayD.hasValue(f71.MaterialToolbar_logoAdjustViewBounds)) {
            this.k = Boolean.valueOf(typedArrayD.getBoolean(f71.MaterialToolbar_logoAdjustViewBounds, false));
        }
        typedArrayD.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            rr0 rr0Var = new rr0();
            rr0Var.k(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            rr0Var.i(context2);
            WeakHashMap weakHashMap = qs1.a;
            rr0Var.j(hs1.e(this));
            setBackground(rr0Var);
        }
    }

    public final void a(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i2 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i2, textView.getBottom());
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.j;
    }

    public Integer getNavigationIconTint() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof rr0) {
            az1.H(this, (rr0) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        ImageView imageView2 = null;
        if (this.h || this.i) {
            ArrayList arrayListR = np1.r(this, getTitle());
            boolean zIsEmpty = arrayListR.isEmpty();
            y4 y4Var = np1.e;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListR, y4Var);
            ArrayList arrayListR2 = np1.r(this, getSubtitle());
            TextView textView2 = arrayListR2.isEmpty() ? null : (TextView) Collections.max(arrayListR2, y4Var);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i6 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i7 = 0; i7 < getChildCount(); i7++) {
                    View childAt = getChildAt(i7);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i6 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i6 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.h && textView != null) {
                    a(textView, pair);
                }
                if (this.i && textView2 != null) {
                    a(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i5 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i5);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i5++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.k;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.j;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof rr0) {
            ((rr0) background).j(f);
        }
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.k;
        if (bool == null || bool.booleanValue() != z) {
            this.k = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.j != scaleType) {
            this.j = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.g != null) {
            drawable = az1.L(drawable.mutate());
            drawable.setTint(this.g.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.g = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.i != z) {
            this.i = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.h != z) {
            this.h = z;
            requestLayout();
        }
    }
}
