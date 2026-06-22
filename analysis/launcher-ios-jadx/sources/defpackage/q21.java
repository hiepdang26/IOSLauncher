package defpackage;

import android.view.View;
import androidx.preference.Preference;

/* JADX INFO: loaded from: classes.dex */
public final class q21 implements View.OnClickListener {
    public final /* synthetic */ Preference g;

    public q21(Preference preference) {
        this.g = preference;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.g.r(view);
    }
}
