package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import defpackage.az1;
import defpackage.hg0;
import defpackage.q71;
import defpackage.qs1;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCheckedTextViewHelper {
    private ColorStateList mCheckMarkTintList = null;
    private PorterDuff.Mode mCheckMarkTintMode = null;
    private boolean mHasCheckMarkTint = false;
    private boolean mHasCheckMarkTintMode = false;
    private boolean mSkipNextApply;
    private final CheckedTextView mView;

    public AppCompatCheckedTextViewHelper(CheckedTextView checkedTextView) {
        this.mView = checkedTextView;
    }

    public void applyCheckMarkTint() {
        Drawable checkMarkDrawable = this.mView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.mHasCheckMarkTint || this.mHasCheckMarkTintMode) {
                Drawable drawableMutate = az1.L(checkMarkDrawable).mutate();
                if (this.mHasCheckMarkTint) {
                    drawableMutate.setTintList(this.mCheckMarkTintList);
                }
                if (this.mHasCheckMarkTintMode) {
                    drawableMutate.setTintMode(this.mCheckMarkTintMode);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.mView.getDrawableState());
                }
                this.mView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, q71.CheckedTextView, i, 0);
        CheckedTextView checkedTextView = this.mView;
        qs1.o(checkedTextView, checkedTextView.getContext(), q71.CheckedTextView, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i);
        try {
            if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CheckedTextView_checkMarkCompat) && (resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(q71.CheckedTextView_checkMarkCompat, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.mView;
                    checkedTextView2.setCheckMarkDrawable(hg0.o(checkedTextView2.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CheckedTextView_android_checkMark)) {
                        CheckedTextView checkedTextView3 = this.mView;
                        checkedTextView3.setCheckMarkDrawable(hg0.o(checkedTextView3.getContext(), resourceId));
                    }
                }
            } else if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CheckedTextView_android_checkMark) && (resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(q71.CheckedTextView_android_checkMark, 0)) != 0) {
                CheckedTextView checkedTextView32 = this.mView;
                checkedTextView32.setCheckMarkDrawable(hg0.o(checkedTextView32.getContext(), resourceId));
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CheckedTextView_checkMarkTint)) {
                this.mView.setCheckMarkTintList(tintTypedArrayObtainStyledAttributes.getColorStateList(q71.CheckedTextView_checkMarkTint));
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CheckedTextView_checkMarkTintMode)) {
                this.mView.setCheckMarkTintMode(DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(q71.CheckedTextView_checkMarkTintMode, -1), null));
            }
            tintTypedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            tintTypedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void onSetCheckMarkDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
        } else {
            this.mSkipNextApply = true;
            applyCheckMarkTint();
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        this.mCheckMarkTintList = colorStateList;
        this.mHasCheckMarkTint = true;
        applyCheckMarkTint();
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        this.mCheckMarkTintMode = mode;
        this.mHasCheckMarkTintMode = true;
        applyCheckMarkTint();
    }
}
