package defpackage;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.wallpaper.livewallpaper.MyViewPager;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class mq0 extends w50 {
    public MyViewPager Z;

    @Override // defpackage.w50
    public final void H() {
        this.J = true;
        r00.b().i(this);
    }

    @Override // defpackage.w50
    public final void I() {
        this.J = true;
        r00.b().k(this);
    }

    @jk1(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(oo0 oo0Var) {
        throw null;
    }

    @Override // defpackage.w50
    public final View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Z = (MyViewPager) layoutInflater.inflate(m61.fragment_main, viewGroup, false);
        this.Z.setAdapter(new lq0(o()));
        TypedValue.applyDimension(1, 16.0f, s().getDisplayMetrics());
        return this.Z;
    }
}
