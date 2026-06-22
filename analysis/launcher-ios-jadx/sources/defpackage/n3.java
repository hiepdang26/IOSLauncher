package defpackage;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes.dex */
public final class n3 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ s3 g;
    public final /* synthetic */ p3 h;

    public n3(p3 p3Var, s3 s3Var) {
        this.h = p3Var;
        this.g = s3Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        p3 p3Var = this.h;
        DialogInterface.OnClickListener onClickListener = p3Var.s;
        s3 s3Var = this.g;
        onClickListener.onClick(s3Var.b, i);
        if (p3Var.w) {
            return;
        }
        s3Var.b.dismiss();
    }
}
