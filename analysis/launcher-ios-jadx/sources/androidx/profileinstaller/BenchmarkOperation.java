package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class BenchmarkOperation {

    public static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        public static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }
    }

    public static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        public static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    private BenchmarkOperation() {
    }

    public static boolean deleteFilesRecursively(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = deleteFilesRecursively(file2) && z;
        }
        return z;
    }

    public static void dropShaderCache(Context context, ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        int i = Build.VERSION.SDK_INT;
        if (deleteFilesRecursively(i >= 34 ? Api24ContextHelper.createDeviceProtectedStorageContext(context).getCacheDir() : i >= 24 ? Api21ContextHelper.getCodeCacheDir(Api24ContextHelper.createDeviceProtectedStorageContext(context)) : i == 23 ? Api21ContextHelper.getCodeCacheDir(context) : context.getCacheDir())) {
            resultDiagnostics.onResultReceived(14, null);
        } else {
            resultDiagnostics.onResultReceived(15, null);
        }
    }
}
