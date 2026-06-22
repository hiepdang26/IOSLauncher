package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l9 implements lu0 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ l9(Object obj, Object obj2, int i) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // defpackage.lu0
    public final boolean a(Object obj) {
        switch (this.a) {
            case 0:
                Uri uri = (Uri) obj;
                if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
                }
                break;
            case 1:
                break;
            case 2:
                ArrayList arrayList = (ArrayList) this.c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    if (((lu0) obj2).a(obj)) {
                        break;
                    }
                }
                break;
            case 3:
                break;
            default:
                Uri uri2 = (Uri) obj;
                if (!"android.resource".equals(uri2.getScheme()) || !((Context) this.c).getPackageName().equals(uri2.getAuthority())) {
                }
                break;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, lv] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Object, k9] */
    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        ku0 ku0VarB;
        Uri uri;
        switch (this.a) {
            case 0:
                Uri uri2 = (Uri) obj;
                return new ku0(new fy0(uri2), this.b.m((AssetManager) this.c, uri2.toString().substring(22)));
            case 1:
                Integer num = (Integer) obj;
                Resources.Theme theme = (Resources.Theme) g01Var.c(kb1.b);
                return new ku0(new fy0(num), new kv(theme, theme != null ? theme.getResources() : ((Context) this.c).getResources(), this.b, num.intValue()));
            case 2:
                ArrayList arrayList = (ArrayList) this.c;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                bj0 bj0Var = null;
                for (int i3 = 0; i3 < size; i3++) {
                    lu0 lu0Var = (lu0) arrayList.get(i3);
                    if (lu0Var.a(obj) && (ku0VarB = lu0Var.b(obj, i, i2, g01Var)) != null) {
                        arrayList2.add(ku0VarB.c);
                        bj0Var = ku0VarB.a;
                    }
                }
                if (arrayList2.isEmpty() || bj0Var == null) {
                    return null;
                }
                return new ku0(bj0Var, new av0(arrayList2, (wb2) this.b));
            case 3:
                Integer num2 = (Integer) obj;
                Resources resources = (Resources) this.b;
                try {
                    uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num2.intValue()) + '/' + resources.getResourceTypeName(num2.intValue()) + '/' + resources.getResourceEntryName(num2.intValue()));
                    break;
                } catch (Resources.NotFoundException unused) {
                    Log.isLoggable("ResourceLoader", 5);
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((lu0) this.c).b(uri, i, i2, g01Var);
            default:
                Uri uri3 = (Uri) obj;
                List<String> pathSegments = uri3.getPathSegments();
                int size2 = pathSegments.size();
                lu0 lu0Var2 = (lu0) this.b;
                ku0 ku0VarB2 = null;
                if (size2 == 1) {
                    try {
                        int i4 = Integer.parseInt(uri3.getPathSegments().get(0));
                        if (i4 != 0) {
                            ku0VarB2 = lu0Var2.b(Integer.valueOf(i4), i, i2, g01Var);
                        } else if (Log.isLoggable("ResourceUriLoader", 5)) {
                            uri3.toString();
                        }
                        return ku0VarB2;
                    } catch (NumberFormatException unused2) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return ku0VarB2;
                        }
                        Objects.toString(uri3);
                        return ku0VarB2;
                    }
                }
                if (pathSegments.size() != 2) {
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    uri3.toString();
                    return null;
                }
                List<String> pathSegments2 = uri3.getPathSegments();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                Context context = (Context) this.c;
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier != 0) {
                    return lu0Var2.b(Integer.valueOf(identifier), i, i2, g01Var);
                }
                if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                }
                uri3.toString();
                return null;
        }
    }

    public String toString() {
        switch (this.a) {
            case 2:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.c).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public l9(Resources resources, lu0 lu0Var) {
        this.a = 3;
        this.b = resources;
        this.c = lu0Var;
    }

    public l9(Context context, lv lvVar) {
        this.a = 1;
        this.c = context.getApplicationContext();
        this.b = lvVar;
    }

    public l9(Context context, lu0 lu0Var) {
        this.a = 4;
        this.c = context.getApplicationContext();
        this.b = lu0Var;
    }
}
