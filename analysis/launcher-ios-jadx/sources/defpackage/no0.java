package defpackage;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes.dex */
public class no0 extends w50 {
    @Override // defpackage.w50
    public final void B() {
        this.J = true;
    }

    @Override // defpackage.w50
    public final View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(m61.fragment_about, viewGroup, false);
        Toolbar toolbar = (Toolbar) viewInflate.findViewById(v51.toolbar);
        toolbar.setNavigationIcon(s().getDrawable(l51.ic_back));
        toolbar.setNavigationOnClickListener(new mo0(this));
        TextView textView = (TextView) viewInflate.findViewById(v51.textView);
        textView.setText(new SpannableString(Html.fromHtml(s().getString(w61.about))));
        textView.setMovementMethod(new LinkMovementMethod());
        return viewInflate;
    }
}
