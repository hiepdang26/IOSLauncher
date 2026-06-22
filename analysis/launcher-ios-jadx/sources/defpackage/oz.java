package defpackage;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final class oz implements TextWatcher {
    public final EditText g;
    public nz h;
    public boolean i = true;

    public oz(EditText editText) {
        this.g = editText;
    }

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            zy zyVarA = zy.a();
            if (editableText == null) {
                length = 0;
            } else {
                zyVarA.getClass();
                length = editableText.length();
            }
            zyVarA.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText = this.g;
        if (editText.isInEditMode() || !this.i || zy.j == null || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = zy.a().b();
        if (iB != 0) {
            if (iB == 1) {
                zy.a().e((Spannable) charSequence, i, i3 + i);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        zy zyVarA = zy.a();
        if (this.h == null) {
            this.h = new nz(editText);
        }
        zyVarA.f(this.h);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
