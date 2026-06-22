package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public final class zzffy {
    private final Pattern zza;

    public zzffy() {
        Pattern patternCompile;
        try {
            patternCompile = Pattern.compile((String) n42.d.c.zza(zzbbw.zzgi));
        } catch (PatternSyntaxException unused) {
            patternCompile = null;
        }
        this.zza = patternCompile;
    }

    public final String zza(String str) {
        Pattern pattern = this.zza;
        if (pattern == null || str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
