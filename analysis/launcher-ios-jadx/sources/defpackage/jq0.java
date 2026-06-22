package defpackage;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final class jq0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int g;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.g) {
            case 0:
                if (dialogInterface != null) {
                    dialogInterface.cancel();
                }
                break;
            case 1:
                if (dialogInterface != null) {
                    dialogInterface.cancel();
                }
                break;
        }
    }

    private final void a(DialogInterface dialogInterface, int i) {
    }
}
