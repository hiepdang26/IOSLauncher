package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class sf0 implements tf0 {
    public final InputContentInfo g;

    public sf0(Object obj) {
        this.g = (InputContentInfo) obj;
    }

    @Override // defpackage.tf0
    public final Object c() {
        return this.g;
    }

    @Override // defpackage.tf0
    public final Uri d() {
        return this.g.getContentUri();
    }

    @Override // defpackage.tf0
    public final void e() {
        this.g.requestPermission();
    }

    @Override // defpackage.tf0
    public final Uri g() {
        return this.g.getLinkUri();
    }

    @Override // defpackage.tf0
    public final ClipDescription getDescription() {
        return this.g.getDescription();
    }

    public sf0(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.g = new InputContentInfo(uri, clipDescription, uri2);
    }
}
