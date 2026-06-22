package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ej {
    public final /* synthetic */ int a;
    public final /* synthetic */ c00 b;

    public /* synthetic */ ej(c00 c00Var, int i) {
        this.a = i;
        this.b = c00Var;
    }

    public final void a(TextInputLayout textInputLayout) {
        int i = 0;
        c00 c00Var = this.b;
        switch (this.a) {
            case 0:
                EditText editText = textInputLayout.getEditText();
                jj jjVar = (jj) c00Var;
                textInputLayout.setEndIconVisible(jj.d(jjVar));
                v3 v3Var = jjVar.f;
                editText.setOnFocusChangeListener(v3Var);
                jjVar.c.setOnFocusChangeListener(v3Var);
                j8 j8Var = jjVar.e;
                editText.removeTextChangedListener(j8Var);
                editText.addTextChangedListener(j8Var);
                return;
            case 1:
                EditText editText2 = textInputLayout.getEditText();
                if (!(editText2 instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText2;
                ux uxVar = (ux) c00Var;
                int boxBackgroundMode = uxVar.a.getBoxBackgroundMode();
                if (boxBackgroundMode == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(uxVar.p);
                } else if (boxBackgroundMode == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(uxVar.o);
                }
                uxVar.e(autoCompleteTextView);
                autoCompleteTextView.setOnTouchListener(new tx(uxVar, autoCompleteTextView, i));
                autoCompleteTextView.setOnFocusChangeListener(uxVar.f);
                autoCompleteTextView.setOnDismissListener(new px(uxVar));
                autoCompleteTextView.setThreshold(0);
                qx qxVar = uxVar.e;
                autoCompleteTextView.removeTextChangedListener(qxVar);
                autoCompleteTextView.addTextChangedListener(qxVar);
                textInputLayout.setEndIconCheckable(true);
                textInputLayout.setErrorIconDrawable((Drawable) null);
                if (autoCompleteTextView.getKeyListener() == null && uxVar.q.isTouchExplorationEnabled()) {
                    CheckableImageButton checkableImageButton = uxVar.c;
                    WeakHashMap weakHashMap = qs1.a;
                    checkableImageButton.setImportantForAccessibility(2);
                }
                textInputLayout.setTextInputAccessibilityDelegate(uxVar.g);
                textInputLayout.setEndIconVisible(true);
                return;
            default:
                EditText editText3 = textInputLayout.getEditText();
                s11 s11Var = (s11) c00Var;
                s11Var.c.setChecked(true ^ s11.d(s11Var));
                qx qxVar2 = s11Var.e;
                editText3.removeTextChangedListener(qxVar2);
                editText3.addTextChangedListener(qxVar2);
                return;
        }
    }
}
