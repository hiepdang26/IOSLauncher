package defpackage;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.luutinhit.launcherios.searchview.SearchViewLayout;

/* JADX INFO: loaded from: classes.dex */
public final class ve1 implements TextView.OnEditorActionListener {
    public final /* synthetic */ SearchViewLayout g;

    public ve1(SearchViewLayout searchViewLayout) {
        this.g = searchViewLayout;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2 = SearchViewLayout.C;
        SearchViewLayout searchViewLayout = this.g;
        InputMethodManager inputMethodManager = searchViewLayout.z;
        if (inputMethodManager == null) {
            return true;
        }
        inputMethodManager.hideSoftInputFromWindow(searchViewLayout.getWindowToken(), 0);
        return true;
    }
}
