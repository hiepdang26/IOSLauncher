package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import defpackage.b71;
import defpackage.f71;
import defpackage.mn1;
import defpackage.q41;
import defpackage.tr0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TextInputEditText extends AppCompatEditText {
    public final Rect g;
    public boolean h;

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputEditText(Context context, AttributeSet attributeSet) {
        int i = q41.editTextStyle;
        super(tr0.a(context, attributeSet, i, 0), attributeSet, i);
        this.g = new Rect();
        int[] iArr = f71.TextInputEditText;
        int i2 = b71.Widget_Design_TextInputEditText;
        mn1.a(context, attributeSet, i, i2);
        mn1.b(context, attributeSet, iArr, i, i2, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        setTextInputLayoutFocusedRectEnabled(typedArrayObtainStyledAttributes.getBoolean(f71.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !this.h || rect == null) {
            return;
        }
        Rect rect2 = this.g;
        textInputLayout.getFocusedRect(rect2);
        rect.bottom = rect2.bottom;
    }

    @Override // android.view.View
    public final boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !this.h) ? super.getGlobalVisibleRect(rect, point) : textInputLayout.getGlobalVisibleRect(rect, point);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.K) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.K && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
            return;
        }
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        String string = "";
        String string2 = !TextUtils.isEmpty(hint) ? hint.toString() : "";
        if (!zIsEmpty) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) text);
            if (!TextUtils.isEmpty(string2)) {
                string = ", " + string2;
            }
            sb.append(string);
            string = sb.toString();
        } else if (!TextUtils.isEmpty(string2)) {
            string = string2;
        }
        accessibilityNodeInfo.setText(string);
    }

    @Override // android.view.View
    public final boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !this.h || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        int height = textInputLayout.getHeight() - getHeight();
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom + height;
        Rect rect2 = this.g;
        rect2.set(i, i2, i3, i4);
        return super.requestRectangleOnScreen(rect2);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.h = z;
    }
}
