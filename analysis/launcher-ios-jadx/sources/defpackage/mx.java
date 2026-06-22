package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.preference.DropDownPreference;

/* JADX INFO: loaded from: classes.dex */
public final class mx implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ DropDownPreference g;

    public mx(DropDownPreference dropDownPreference) {
        this.g = dropDownPreference;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i >= 0) {
            DropDownPreference dropDownPreference = this.g;
            String string = dropDownPreference.Z[i].toString();
            if (string.equals(dropDownPreference.a0)) {
                return;
            }
            dropDownPreference.getClass();
            dropDownPreference.x(string);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
