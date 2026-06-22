package defpackage;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.util.TextViewCustomFont;

/* JADX INFO: loaded from: classes.dex */
public final class rg extends m91 {
    public final TextViewCustomFont A;
    public final AppCompatImageView B;
    public final TextViewCustomFont C;
    public final /* synthetic */ sg D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rg(sg sgVar, View view) {
        super(view);
        this.D = sgVar;
        this.A = (TextViewCustomFont) view.findViewById(v51.label);
        this.B = (AppCompatImageView) view.findViewById(v51.icon_app);
        this.C = (TextViewCustomFont) view.findViewById(v51.apps_category);
    }
}
