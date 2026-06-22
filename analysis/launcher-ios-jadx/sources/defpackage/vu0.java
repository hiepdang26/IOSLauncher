package defpackage;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes.dex */
public final class vu0 implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
