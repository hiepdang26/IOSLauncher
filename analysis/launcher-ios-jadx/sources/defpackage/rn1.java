package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* JADX INFO: loaded from: classes.dex */
public final class rn1 implements tn1, mu0, gq1 {
    public static final String[] h = {"_data"};
    public final ContentResolver g;

    public /* synthetic */ rn1(ContentResolver contentResolver) {
        this.g = contentResolver;
    }

    @Override // defpackage.tn1
    public Cursor a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return this.g.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, h, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
    }

    @Override // defpackage.gq1
    public cs h(Uri uri) {
        return new i9(this.g, uri, 0);
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        return new hq1(this);
    }
}
