package defpackage;

import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;

/* JADX INFO: loaded from: classes.dex */
public final class zq extends b70 {
    public LinearLayoutRound k;
    public TextView l;
    public TextView m;
    public AppCompatButton n;
    public AppCompatButton o;
    public AppCompatButton p;
    public boolean q;

    public final void a() {
        if (getParent() == null) {
            return;
        }
        animate().withLayer().alpha(0.0f).setDuration(168L).withEndAction(new r1(this, 9)).start();
    }

    public void setOnDismissListener(yq yqVar) {
    }
}
