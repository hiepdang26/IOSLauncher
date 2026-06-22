package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.SharedPreferences;
import android.content.pm.LauncherApps;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class z30 extends LinearLayoutRound implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final /* synthetic */ int O = 0;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public LauncherApps G;
    public LinearLayout.LayoutParams H;
    public LinearLayout.LayoutParams I;
    public pg1 J;
    public pg1 K;
    public pg1 L;
    public View M;
    public y30 N;
    public t x;
    public bo1 y;
    public View z;

    public static void b(z30 z30Var) {
        int i = 2;
        z30Var.getClass();
        r30 r30Var = new r30(z30Var, 2);
        ObjectAnimator objectAnimatorD = ik0.d(z30Var, PropertyValuesHolder.ofFloat(Key.ALPHA, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
        objectAnimatorD.setDuration(230L);
        boolean z = ar1.m;
        if (z) {
            objectAnimatorD.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
        }
        if (z) {
            z30Var.setLayerType(2, null);
        }
        objectAnimatorD.addListener(new um(z30Var, r30Var, i));
        objectAnimatorD.start();
    }

    public final void c() {
        boolean z = this.F;
        t tVar = this.x;
        pg1 pg1Var = new pg1(tVar, z, false);
        this.L = pg1Var;
        pg1Var.setId(v51.about_shortcut);
        this.L.setText(w61.info_target_label);
        this.L.setIcon(l51.ic_about);
        this.L.setOnClickListener(new s30(this));
        View view = this.L;
        ViewGroup.LayoutParams layoutParams = this.H;
        addView(view, 0, layoutParams);
        pg1 pg1Var2 = new pg1(tVar, this.F, false);
        this.K = pg1Var2;
        pg1Var2.setId(v51.hidden_shortcut);
        this.K.setText(w61.hidden_apps);
        this.K.setIcon(l51.ic_hidden_path);
        this.K.setOnClickListener(new t30(this));
        addView(this.K, 1, layoutParams);
        pg1 pg1Var3 = new pg1(tVar, this.F, false);
        this.J = pg1Var3;
        pg1Var3.setId(v51.edit_home_screen);
        this.J.setText(w61.edit_home_screen);
        this.J.setIcon(l51.ic_rearrange_apps);
        this.J.setOnClickListener(new u30(this));
        addView(this.J, 2, layoutParams);
        this.C = tVar.getDeviceProfile().b();
        this.D = tVar.getDeviceProfile().a();
        int i = tVar.getDeviceProfile().D;
        this.A = i;
        this.B = i / 6;
        pg1 pg1Var4 = new pg1(tVar, this.F, true);
        pg1Var4.setId(v51.delete_app);
        pg1Var4.setText(w61.delete_app);
        pg1Var4.setIcon(l51.ic_trash);
        pg1Var4.setOnClickListener(new v30(this));
        addView(pg1Var4, 3, layoutParams);
    }

    public final void d() {
        try {
            y30 y30Var = this.N;
            if (y30Var != null) {
                y30Var.onCloseFloatingMenu(this.z);
            }
            ObjectAnimator objectAnimatorD = ik0.d(this, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.3f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.3f));
            if (ar1.m) {
                objectAnimatorD.setInterpolator(new PathInterpolator(0.33f, 0.89f, 0.55f, 1.0f));
            }
            objectAnimatorD.addListener(new be(this, 6));
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
        this.F = zA;
        setDarkModeBackgroundColor(zA ? -1726211044 : -1713447202);
        this.M.setBackgroundColor(this.F ? -1726211044 : -1717921126);
        this.L.setDarkMode(this.F);
        this.K.setDarkMode(this.F);
        this.J.setDarkMode(this.F);
    }

    public void setOnListenerFloatingMenu(y30 y30Var) {
        this.N = y30Var;
    }
}
