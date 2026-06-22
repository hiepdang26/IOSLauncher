package defpackage;

import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.google.android.material.textfield.TextInputLayout;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcherios.searchview.SearchViewLayout;

/* JADX INFO: loaded from: classes.dex */
public final class j8 implements TextWatcher {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ j8(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.g) {
            case 1:
                jj jjVar = (jj) this.h;
                if (jjVar.a.getSuffixText() == null) {
                    jjVar.e(jj.d(jjVar));
                    break;
                }
                break;
            case 3:
                TextInputLayout textInputLayout = (TextInputLayout) this.h;
                textInputLayout.t(!textInputLayout.N0, false);
                if (textInputLayout.r) {
                    textInputLayout.m(editable.length());
                }
                if (textInputLayout.y) {
                    textInputLayout.u(editable.length());
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.g;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Object obj = this.h;
        switch (this.g) {
            case 0:
                l8 l8Var = (l8) obj;
                if (l8Var.t != null) {
                    l8Var.x.removeCallbacksAndMessages(null);
                    Message message = new Message();
                    message.obj = charSequence.toString();
                    l8Var.x.sendMessage(message);
                }
                break;
            case 1:
                break;
            case 2:
                int i4 = SearchViewLayout.C;
                SearchViewLayout searchViewLayout = (SearchViewLayout) obj;
                if (searchViewLayout.g == xe1.h && searchViewLayout.y != null && charSequence != null && charSequence.length() != i2) {
                    searchViewLayout.v.setVisibility(i3 > 0 ? 0 : 8);
                    searchViewLayout.y.removeCallbacksAndMessages(null);
                    Message message2 = new Message();
                    message2.obj = charSequence.toString();
                    searchViewLayout.y.sendMessage(message2);
                }
                if (!TextUtils.isEmpty(searchViewLayout.m.getText())) {
                    searchViewLayout.w(false);
                    searchViewLayout.u(true);
                } else {
                    searchViewLayout.u(false);
                    searchViewLayout.w(true);
                }
                break;
            case 3:
                break;
            default:
                WidgetsContainerView widgetsContainerView = (WidgetsContainerView) obj;
                widgetsContainerView.W.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
                widgetsContainerView.j(charSequence);
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(Editable editable) {
    }

    private final void d(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void e(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void f(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void g(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void h(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void i(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void j(int i, int i2, int i3, CharSequence charSequence) {
    }
}
