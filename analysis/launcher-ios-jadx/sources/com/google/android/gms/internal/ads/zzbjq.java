package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbjq implements zzbix {
    private final Context zza;

    public zzbjq(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (!map.containsKey("text") || TextUtils.isEmpty((CharSequence) map.get("text"))) {
            return;
        }
        k92.a("Opening Share Sheet with text: ".concat(String.valueOf((String) map.get("text"))));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", (String) map.get("text"));
        if (map.containsKey("title")) {
            intent.putExtra("android.intent.extra.TITLE", (String) map.get("title"));
        }
        try {
            cd2 cd2Var = hd2.B.c;
            cd2.p(this.zza, intent);
        } catch (RuntimeException e) {
            k92.j(5);
            hd2.B.g.zzw(e, "ShareSheetGmsgHandler.onGmsg");
        }
    }
}
