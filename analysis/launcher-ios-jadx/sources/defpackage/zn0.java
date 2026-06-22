package defpackage;

import android.os.Bundle;
import androidx.preference.ListPreference;

/* JADX INFO: loaded from: classes.dex */
public class zn0 extends x21 {
    public int v0;
    public CharSequence[] w0;
    public CharSequence[] x0;

    @Override // defpackage.x21, defpackage.ev, defpackage.w50
    public final void G(Bundle bundle) {
        super.G(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.v0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.w0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.x0);
    }

    @Override // defpackage.x21
    public final void X(boolean z) {
        int i;
        if (!z || (i = this.v0) < 0) {
            return;
        }
        String string = this.x0[i].toString();
        ListPreference listPreference = (ListPreference) V();
        listPreference.getClass();
        listPreference.x(string);
    }

    @Override // defpackage.x21
    public final void Y(t3 t3Var) {
        CharSequence[] charSequenceArr = this.w0;
        int i = this.v0;
        yn0 yn0Var = new yn0(this, 0);
        p3 p3Var = (p3) t3Var.h;
        p3Var.q = charSequenceArr;
        p3Var.s = yn0Var;
        p3Var.x = i;
        p3Var.w = true;
        p3Var.g = null;
        p3Var.h = null;
    }

    @Override // defpackage.x21, defpackage.ev, defpackage.w50
    public final void y(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.y(bundle);
        if (bundle != null) {
            this.v0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.w0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.x0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) V();
        if (listPreference.Y == null || (charSequenceArr = listPreference.Z) == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.v0 = listPreference.w(listPreference.a0);
        this.w0 = listPreference.Y;
        this.x0 = charSequenceArr;
    }
}
