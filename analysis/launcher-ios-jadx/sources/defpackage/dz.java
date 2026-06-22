package defpackage;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class dz extends InputConnectionWrapper {
    public final EditText a;
    public final iy b;

    public dz(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        iy iyVar = new iy();
        super(inputConnection, false);
        this.a = editText;
        this.b = iyVar;
        if (zy.j != null) {
            zy zyVarA = zy.a();
            if (zyVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            vy vyVar = zyVarA.e;
            vyVar.getClass();
            Bundle bundle = editorInfo.extras;
            cu0 cu0Var = (cu0) vyVar.c.a;
            int iA = cu0Var.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) cu0Var.j).getInt(iA + cu0Var.g) : 0);
            Bundle bundle2 = editorInfo.extras;
            vyVar.a.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        Editable editableText = this.a.getEditableText();
        this.b.getClass();
        return iy.u(this, editableText, i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        Editable editableText = this.a.getEditableText();
        this.b.getClass();
        return iy.u(this, editableText, i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }
}
