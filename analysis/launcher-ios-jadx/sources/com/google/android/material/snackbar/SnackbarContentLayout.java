package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.d51;
import defpackage.qs1;
import defpackage.u51;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {
    public TextView g;
    public Button h;
    public int i;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.g.getPaddingTop() == i2 && this.g.getPaddingBottom() == i3) {
            return z;
        }
        TextView textView = this.g;
        WeakHashMap weakHashMap = qs1.a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i2, textView.getPaddingEnd(), i3);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i2, textView.getPaddingRight(), i3);
        return true;
    }

    public Button getActionView() {
        return this.h;
    }

    public TextView getMessageView() {
        return this.g;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.g = (TextView) findViewById(u51.snackbar_text);
        this.h = (Button) findViewById(u51.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d51.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d51.design_snackbar_padding_vertical);
        boolean z = this.g.getLayout().getLineCount() > 1;
        if (!z || this.i <= 0 || this.h.getMeasuredWidth() <= this.i) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMaxInlineActionWidth(int i) {
        this.i = i;
    }
}
