package defpackage;

import android.util.Base64;
import android.util.JsonWriter;
import android.view.View;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzbzt;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderIcon;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class xz1 implements c02, db, zzapl, nb2 {
    public final /* synthetic */ Object g;

    public /* synthetic */ xz1(Object obj) {
        this.g = obj;
    }

    @Override // defpackage.nb2
    public void a(JsonWriter jsonWriter) throws IOException {
        Object obj = ub2.b;
        jsonWriter.name("params").beginObject();
        byte[] bArr = (byte[]) this.g;
        int length = bArr.length;
        String strEncodeToString = Base64.encodeToString(bArr, 0);
        if (length < 10000) {
            jsonWriter.name("body").value(strEncodeToString);
        } else {
            String strA = ka2.a(strEncodeToString, "MD5");
            if (strA != null) {
                jsonWriter.name("bodydigest").value(strA);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    @Override // defpackage.c02
    public boolean h(qh0 qh0Var, View view, FolderIcon folderIcon) {
        if (!(view instanceof Folder)) {
            return false;
        }
        Folder folder = (Folder) view;
        return folder.getInfo() == ((w40) this.g) && folder.getInfo().y;
    }

    @Override // com.google.android.gms.internal.ads.zzapl
    public void zza(zzapq zzapqVar) {
        ((zzbzt) this.g).zzd(zzapqVar);
    }
}
