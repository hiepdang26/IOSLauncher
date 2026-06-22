package com.luutinhit.launcher6;

import android.content.Context;
import android.content.Intent;
import defpackage.qt;

/* JADX INFO: loaded from: classes.dex */
public final class a extends qt {
    public final /* synthetic */ CommonAppTypeParser o;

    /* JADX WARN: Illegal instructions before constructor call */
    public a(CommonAppTypeParser commonAppTypeParser) {
        this.o = commonAppTypeParser;
        Context context = commonAppTypeParser.mContext;
        super(context, null, commonAppTypeParser, context.getResources(), commonAppTypeParser.mResId, "resolve");
    }

    @Override // defpackage.y9
    public final long a(String str, Intent intent, int i) {
        if (i == 0) {
            CommonAppTypeParser commonAppTypeParser = this.o;
            commonAppTypeParser.parsedIntent = intent;
            commonAppTypeParser.parsedTitle = str;
        }
        return super.a(str, intent, i);
    }
}
