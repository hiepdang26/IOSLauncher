package defpackage;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class ae0 extends u3 {
    public final t j;
    public final AppCompatEditText k;
    public int l;

    public ae0(t tVar) {
        super(tVar, 0);
        this.j = tVar;
        View viewInflate = LayoutInflater.from(getContext()).inflate(m61.ios_alert_dialog, (ViewGroup) null);
        this.k = (AppCompatEditText) viewInflate.findViewById(v51.widget_change_label_edit_text);
        viewInflate.findViewById(v51.widget_change_label_confirm).setOnClickListener(new g7(this, 6));
        s3 s3Var = this.i;
        s3Var.g = viewInflate;
        s3Var.h = false;
    }

    @Override // defpackage.u3, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }
}
