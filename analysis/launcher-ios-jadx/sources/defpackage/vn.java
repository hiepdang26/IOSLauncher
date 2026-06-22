package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class vn implements un, wn {
    public final /* synthetic */ int g = 0;
    public ClipData h;
    public int i;
    public int j;
    public Uri k;
    public Bundle l;

    public /* synthetic */ vn() {
    }

    @Override // defpackage.wn
    public ClipData b() {
        return this.h;
    }

    @Override // defpackage.un
    public xn g() {
        return new xn(new vn(this));
    }

    @Override // defpackage.un
    public void k(Bundle bundle) {
        this.l = bundle;
    }

    @Override // defpackage.wn
    public int l() {
        return this.j;
    }

    @Override // defpackage.wn
    public ContentInfo o() {
        return null;
    }

    @Override // defpackage.wn
    public int q() {
        return this.i;
    }

    public String toString() {
        String str;
        switch (this.g) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.h.getDescription());
                sb.append(", source=");
                int i = this.i;
                sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i2 = this.j;
                sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                Uri uri = this.k;
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return uo.k(sb, this.l != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    @Override // defpackage.un
    public void v(Uri uri) {
        this.k = uri;
    }

    @Override // defpackage.un
    public void y(int i) {
        this.j = i;
    }

    public vn(vn vnVar) {
        ClipData clipData = vnVar.h;
        clipData.getClass();
        this.h = clipData;
        int i = vnVar.i;
        if (i < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.i = i;
        int i2 = vnVar.j;
        if ((i2 & 1) == i2) {
            this.j = i2;
            this.k = vnVar.k;
            this.l = vnVar.l;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }
}
