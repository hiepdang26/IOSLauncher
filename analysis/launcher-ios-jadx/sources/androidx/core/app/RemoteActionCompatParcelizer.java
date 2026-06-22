package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.pr1;
import defpackage.qr1;
import defpackage.rr1;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(pr1 pr1Var) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        rr1 rr1VarH = remoteActionCompat.a;
        boolean z = true;
        if (pr1Var.e(1)) {
            rr1VarH = pr1Var.h();
        }
        remoteActionCompat.a = (IconCompat) rr1VarH;
        CharSequence charSequence = remoteActionCompat.b;
        if (pr1Var.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((qr1) pr1Var).e);
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (pr1Var.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((qr1) pr1Var).e);
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.d = (PendingIntent) pr1Var.g(remoteActionCompat.d, 4);
        boolean z2 = remoteActionCompat.e;
        if (pr1Var.e(5)) {
            z2 = ((qr1) pr1Var).e.readInt() != 0;
        }
        remoteActionCompat.e = z2;
        boolean z3 = remoteActionCompat.f;
        if (!pr1Var.e(6)) {
            z = z3;
        } else if (((qr1) pr1Var).e.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, pr1 pr1Var) {
        pr1Var.getClass();
        IconCompat iconCompat = remoteActionCompat.a;
        pr1Var.i(1);
        pr1Var.k(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        pr1Var.i(2);
        Parcel parcel = ((qr1) pr1Var).e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.c;
        pr1Var.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.d;
        pr1Var.i(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z = remoteActionCompat.e;
        pr1Var.i(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f;
        pr1Var.i(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
