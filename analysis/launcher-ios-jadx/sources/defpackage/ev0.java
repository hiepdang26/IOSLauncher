package defpackage;

import android.os.Bundle;
import androidx.preference.MultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ev0 extends x21 {
    public final HashSet v0 = new HashSet();
    public boolean w0;
    public CharSequence[] x0;
    public CharSequence[] y0;

    @Override // defpackage.x21, defpackage.ev, defpackage.w50
    public final void G(Bundle bundle) {
        super.G(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.v0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.w0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.x0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.y0);
    }

    @Override // defpackage.x21
    public final void X(boolean z) {
        if (z && this.w0) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) V();
            multiSelectListPreference.getClass();
            multiSelectListPreference.w(this.v0);
        }
        this.w0 = false;
    }

    @Override // defpackage.x21
    public final void Y(t3 t3Var) {
        int length = this.y0.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.v0.contains(this.y0[i].toString());
        }
        CharSequence[] charSequenceArr = this.x0;
        dv0 dv0Var = new dv0(this);
        p3 p3Var = (p3) t3Var.h;
        p3Var.q = charSequenceArr;
        p3Var.y = dv0Var;
        p3Var.u = zArr;
        p3Var.v = true;
    }

    @Override // defpackage.x21, defpackage.ev, defpackage.w50
    public final void y(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.y(bundle);
        HashSet hashSet = this.v0;
        if (bundle != null) {
            hashSet.clear();
            hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.w0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.x0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.y0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) V();
        if (multiSelectListPreference.Y == null || (charSequenceArr = multiSelectListPreference.Z) == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        hashSet.clear();
        hashSet.addAll(multiSelectListPreference.a0);
        this.w0 = false;
        this.x0 = multiSelectListPreference.Y;
        this.y0 = charSequenceArr;
    }
}
