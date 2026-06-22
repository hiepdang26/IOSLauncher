package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageButton;
import defpackage.qs1;
import defpackage.r41;
import defpackage.yh;
import defpackage.zh;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    public static final int[] j = {R.attr.state_checked};
    public boolean g;
    public boolean h;
    public boolean i;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r41.imageButtonStyle);
        this.h = true;
        this.i = true;
        qs1.p(this, new yh(this, 0));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.g;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.g ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), j) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof zh)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        zh zhVar = (zh) parcelable;
        super.onRestoreInstanceState(zhVar.getSuperState());
        setChecked(zhVar.g);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        zh zhVar = new zh(super.onSaveInstanceState());
        zhVar.g = this.g;
        return zhVar;
    }

    public void setCheckable(boolean z) {
        if (this.h != z) {
            this.h = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.h || this.g == z) {
            return;
        }
        this.g = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.i = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.i) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.g);
    }
}
