package defpackage;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class rx extends gn1 {
    public final /* synthetic */ ux k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx(ux uxVar, TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.k = uxVar;
    }

    @Override // defpackage.gn1, defpackage.e0
    public final void d(View view, r0 r0Var) {
        super.d(view, r0Var);
        if (!ux.h(this.k.a.getEditText())) {
            r0Var.i(Spinner.class.getName());
        }
        if (Build.VERSION.SDK_INT >= 26 ? r0Var.a.isShowingHintText() : r0Var.e(4)) {
            r0Var.l(null);
        }
    }

    @Override // defpackage.e0
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        ux uxVar = this.k;
        EditText editText = uxVar.a.getEditText();
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        if (accessibilityEvent.getEventType() == 1 && uxVar.q.isEnabled() && !ux.h(uxVar.a.getEditText())) {
            ux.d(uxVar, autoCompleteTextView);
            uxVar.l = true;
            uxVar.n = System.currentTimeMillis();
        }
    }
}
