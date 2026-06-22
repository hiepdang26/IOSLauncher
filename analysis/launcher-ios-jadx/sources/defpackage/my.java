package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.SharedPreferences;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class my extends LinearLayoutRound implements SharedPreferences.OnSharedPreferenceChangeListener {
    public int A;
    public int B;
    public int C;
    public boolean D;
    public pg1 E;
    public pg1 F;
    public ly G;
    public t x;
    public bo1 y;
    public int z;

    public final void b() {
        try {
            ly lyVar = this.G;
            if (lyVar != null) {
                lyVar.onCloseEditMenu();
            }
            ObjectAnimator objectAnimatorD = ik0.d(this, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.3f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.3f));
            if (ar1.m) {
                objectAnimatorD.setInterpolator(new PathInterpolator(0.33f, 0.89f, 0.55f, 1.0f));
            }
            objectAnimatorD.addListener(new be(this, 3));
            objectAnimatorD.setDuration(getResources().getInteger(g61.config_folderCollapseDuration));
            setLayerType(2, null);
            objectAnimatorD.start();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        bo1 bo1Var;
        if (str == null || !str.equals("dark_mode") || (bo1Var = this.y) == null) {
            return;
        }
        boolean zA = bo1Var.a("dark_mode");
        this.D = zA;
        setBackground(zA);
        this.E.setDarkMode(this.D);
        this.F.setDarkMode(this.D);
    }

    public void setBackground(boolean z) {
        setDarkModeBackgroundColor(z ? -98821092 : -84478218);
    }

    public void setOnListenerEditMenu(ly lyVar) {
        this.G = lyVar;
    }
}
