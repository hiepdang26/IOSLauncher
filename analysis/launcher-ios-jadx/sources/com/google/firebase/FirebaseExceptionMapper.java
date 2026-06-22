package com.google.firebase;

import com.google.android.gms.common.api.Status;
import defpackage.n90;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseExceptionMapper {
    public final Exception getException(Status status) {
        int i = status.g;
        int i2 = status.g;
        String strP = status.h;
        if (i == 8) {
            if (strP == null) {
                strP = n90.p(i2);
            }
            return new FirebaseException(strP);
        }
        if (strP == null) {
            strP = n90.p(i2);
        }
        return new FirebaseApiNotAvailableException(strP);
    }
}
