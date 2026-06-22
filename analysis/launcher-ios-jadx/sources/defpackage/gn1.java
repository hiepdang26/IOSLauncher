package defpackage;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public class gn1 extends e0 {
    public final TextInputLayout j;

    public gn1(TextInputLayout textInputLayout) {
        this.j = textInputLayout;
    }

    @Override // defpackage.e0
    public void d(View view, r0 r0Var) {
        View.AccessibilityDelegate accessibilityDelegate = this.g;
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.j;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z = textInputLayout.H0;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z2 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : "";
        aj1 aj1Var = textInputLayout.h;
        AppCompatTextView appCompatTextView = aj1Var.h;
        if (appCompatTextView.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(appCompatTextView);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(appCompatTextView);
            }
        } else if (Build.VERSION.SDK_INT >= 22) {
            accessibilityNodeInfo.setTraversalAfter(aj1Var.j);
        }
        if (!zIsEmpty) {
            r0Var.m(text);
        } else if (!TextUtils.isEmpty(string)) {
            r0Var.m(string);
            if (!z && placeholderText != null) {
                r0Var.m(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            r0Var.m(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                r0Var.l(string);
            } else {
                if (!zIsEmpty) {
                    string = ((Object) text) + ", " + string;
                }
                r0Var.m(string);
            }
            if (i >= 26) {
                accessibilityNodeInfo.setShowingHintText(zIsEmpty);
            } else {
                r0Var.h(4, zIsEmpty);
            }
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z2) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        AppCompatTextView appCompatTextView2 = textInputLayout.q.r;
        if (appCompatTextView2 != null) {
            accessibilityNodeInfo.setLabelFor(appCompatTextView2);
        }
    }
}
