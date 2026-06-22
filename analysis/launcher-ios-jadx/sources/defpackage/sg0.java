package defpackage;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class sg0 extends w50 {
    @Override // defpackage.w50
    public final void J(View view, Bundle bundle) {
        view.getRootView().setBackgroundColor(Color.argb(153, 35, 35, 35));
    }

    @Override // defpackage.w50
    public final View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(m61.fragment_introduction, viewGroup, false);
        ((Button) viewInflate.findViewById(v51.activate_button)).setOnClickListener(new rg0(this));
        return viewInflate;
    }
}
