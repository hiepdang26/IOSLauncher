package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class zzhen implements Iterator, Closeable, zzaqv, AutoCloseable {
    private static final zzaqu zza = new zzhem("eof ");
    protected zzaqr zzb;
    protected zzheo zzc;
    zzaqu zzd = null;
    long zze = 0;
    long zzf = 0;
    private final List zzg = new ArrayList();

    static {
        zzheu.zzb(zzhen.class);
    }

    public void close() {
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzaqu zzaquVar = this.zzd;
        if (zzaquVar == zza) {
            return false;
        }
        if (zzaquVar != null) {
            return true;
        }
        try {
            this.zzd = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzd = zza;
            return false;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzg.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzaqu) this.zzg.get(i)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzaqu next() {
        zzaqu zzaquVarZzb;
        zzaqu zzaquVar = this.zzd;
        if (zzaquVar != null && zzaquVar != zza) {
            this.zzd = null;
            return zzaquVar;
        }
        zzheo zzheoVar = this.zzc;
        if (zzheoVar == null || this.zze >= this.zzf) {
            this.zzd = zza;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzheoVar) {
                this.zzc.zze(this.zze);
                zzaquVarZzb = this.zzb.zzb(this.zzc, this);
                this.zze = this.zzc.zzb();
            }
            return zzaquVarZzb;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public final List zzd() {
        return (this.zzc == null || this.zzd == zza) ? this.zzg : new zzhet(this.zzg, this);
    }

    public final void zze(zzheo zzheoVar, long j, zzaqr zzaqrVar) {
        this.zzc = zzheoVar;
        this.zze = zzheoVar.zzb();
        zzheoVar.zze(zzheoVar.zzb() + j);
        this.zzf = zzheoVar.zzb();
        this.zzb = zzaqrVar;
    }
}
