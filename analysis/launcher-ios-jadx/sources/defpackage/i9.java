package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class i9 extends j9 {
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i9(ContentResolver contentResolver, Uri uri, int i) {
        super(1, uri, contentResolver);
        this.k = i;
    }

    @Override // defpackage.cs
    public final Class a() {
        switch (this.k) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // defpackage.j9
    public final void g(Object obj) throws IOException {
        switch (this.k) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((ParcelFileDescriptor) obj).close();
                break;
        }
    }

    @Override // defpackage.j9
    public final Object i(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        switch (this.k) {
            case 0:
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    return assetFileDescriptorOpenAssetFileDescriptor;
                }
                throw new FileNotFoundException(k31.l(uri, "FileDescriptor is null for: "));
            default:
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(uri, "r");
                if (assetFileDescriptorOpenAssetFileDescriptor2 != null) {
                    return assetFileDescriptorOpenAssetFileDescriptor2.getParcelFileDescriptor();
                }
                throw new FileNotFoundException(k31.l(uri, "FileDescriptor is null for: "));
        }
    }
}
