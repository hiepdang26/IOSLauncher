package defpackage;

import android.view.View;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.util.TextViewCustomFont;

/* JADX INFO: loaded from: classes.dex */
public final class p8 extends m91 {
    public final TextViewCustomFont A;
    public final BubbleTextView B;
    public final /* synthetic */ q8 C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p8(q8 q8Var, View view) {
        super(view);
        this.C = q8Var;
        this.A = (TextViewCustomFont) view.findViewById(v51.text);
        this.B = (BubbleTextView) view.findViewById(v51.icon);
    }
}
