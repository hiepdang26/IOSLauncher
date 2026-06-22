package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import defpackage.mz;
import defpackage.q71;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiTextHelper {
    private final mz mEmojiTextViewHelper;
    private final TextView mView;

    public AppCompatEmojiTextHelper(TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new mz(textView);
    }

    public InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return this.mEmojiTextViewHelper.a.j(inputFilterArr);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.a.l();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, q71.AppCompatTextView, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(q71.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(q71.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setAllCaps(boolean z) {
        this.mEmojiTextViewHelper.a.p(z);
    }

    public void setEnabled(boolean z) {
        this.mEmojiTextViewHelper.a.q(z);
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
        return this.mEmojiTextViewHelper.a.t(transformationMethod);
    }
}
