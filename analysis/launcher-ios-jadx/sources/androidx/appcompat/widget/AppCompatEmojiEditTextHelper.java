package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import defpackage.bz;
import defpackage.dz;
import defpackage.gz;
import defpackage.nz;
import defpackage.oz;
import defpackage.q11;
import defpackage.q71;
import defpackage.qg0;
import defpackage.zy;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {
    private final bz mEmojiEditTextHelper;
    private final EditText mView;

    public AppCompatEmojiEditTextHelper(EditText editText) {
        this.mView = editText;
        this.mEmojiEditTextHelper = new bz(editText);
    }

    public KeyListener getKeyListener(KeyListener keyListener) {
        if (!isEmojiCapableKeyListener(keyListener)) {
            return keyListener;
        }
        this.mEmojiEditTextHelper.a.getClass();
        if (keyListener instanceof gz) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return new gz(keyListener);
    }

    public boolean isEmojiCapableKeyListener(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public boolean isEnabled() {
        return ((oz) this.mEmojiEditTextHelper.a.i).i;
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

    public InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        bz bzVar = this.mEmojiEditTextHelper;
        if (inputConnection == null) {
            bzVar.getClass();
            return null;
        }
        q11 q11Var = bzVar.a;
        q11Var.getClass();
        return inputConnection instanceof dz ? inputConnection : new dz((EditText) q11Var.h, inputConnection, editorInfo);
    }

    public void setEnabled(boolean z) {
        oz ozVar = (oz) this.mEmojiEditTextHelper.a.i;
        if (ozVar.i != z) {
            if (ozVar.h != null) {
                zy zyVarA = zy.a();
                nz nzVar = ozVar.h;
                zyVarA.getClass();
                qg0.j(nzVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = zyVarA.a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    zyVarA.b.remove(nzVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            ozVar.i = z;
            if (z) {
                oz.a(ozVar.g, zy.a().b());
            }
        }
    }
}
