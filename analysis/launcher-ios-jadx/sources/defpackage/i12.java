package defpackage;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
public final class i12 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Intent h;
    public final /* synthetic */ Object i;

    public /* synthetic */ i12(Intent intent, Object obj, int i) {
        this.g = i;
        this.h = intent;
        this.i = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [bn0, java.lang.Object] */
    public final void a() {
        switch (this.g) {
            case 0:
                Intent intent = this.h;
                if (intent != null) {
                    ((GoogleApiActivity) this.i).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.h;
                if (intent2 != null) {
                    this.i.startActivityForResult(intent2, 2);
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (ActivityNotFoundException unused) {
            Build.FINGERPRINT.contains("generic");
        } finally {
            dialogInterface.dismiss();
        }
    }
}
