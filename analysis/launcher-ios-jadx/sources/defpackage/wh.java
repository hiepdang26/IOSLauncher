package defpackage;

import android.widget.CompoundButton;
import androidx.preference.CheckBoxPreference;
import androidx.preference.SwitchPreference;
import androidx.preference.SwitchPreferenceCompat;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes.dex */
public final class wh implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ wh(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.g) {
            case 0:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.h;
                checkBoxPreference.getClass();
                checkBoxPreference.w(z);
                break;
            case 1:
                Chip chip = (Chip) this.h;
                kr0 kr0Var = chip.l;
                if (kr0Var != null) {
                    nx0 nx0Var = (nx0) kr0Var;
                    nx0Var.getClass();
                    xh xhVar = (xh) nx0Var.h;
                    if (!z ? xhVar.e(chip, xhVar.b) : xhVar.a(chip)) {
                        xhVar.d();
                    }
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.k;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                }
                break;
            case 2:
                SwitchPreference switchPreference = (SwitchPreference) this.h;
                switchPreference.getClass();
                switchPreference.w(z);
                break;
            default:
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) this.h;
                switchPreferenceCompat.getClass();
                switchPreferenceCompat.w(z);
                break;
        }
    }
}
