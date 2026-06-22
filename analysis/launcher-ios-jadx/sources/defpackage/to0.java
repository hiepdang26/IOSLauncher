package defpackage;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public final class to0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ wo0 h;

    public /* synthetic */ to0(wo0 wo0Var, int i) {
        this.g = i;
        this.h = wo0Var;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.g) {
            case 0:
                wo0 wo0Var = this.h;
                wo0Var.a0.putBoolean("power_saver", z);
                wo0Var.a0.apply();
                break;
            default:
                wo0 wo0Var2 = this.h;
                wo0Var2.a0.putBoolean("scroll", z);
                wo0Var2.a0.apply();
                break;
        }
    }
}
