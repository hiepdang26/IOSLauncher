package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxs;
import com.google.android.gms.internal.ads.zzgxy;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzgxs<MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> extends zzgvu<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    public zzgxs(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzcf()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
    }

    private MessageType zza() {
        return (MessageType) this.zzb.zzbj();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzgzt.zza().zzb(messagetype.getClass()).zzg(messagetype, messagetype2);
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    public /* bridge */ /* synthetic */ zzgvu zzaD(zzgvv zzgvvVar) {
        zzbi((zzgxy) zzgvvVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    /* JADX INFO: renamed from: zzaK */
    public /* bridge */ /* synthetic */ zzgvu zzaW(zzgww zzgwwVar, zzgxi zzgxiVar) throws IOException {
        zzbk(zzgwwVar, zzgxiVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    /* JADX INFO: renamed from: zzaN */
    public /* bridge */ /* synthetic */ zzgvu zzaZ(byte[] bArr, int i, int i2) throws zzgyn {
        zzbl(bArr, i, i2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    /* JADX INFO: renamed from: zzaO */
    public /* bridge */ /* synthetic */ zzgvu zzba(byte[] bArr, int i, int i2, zzgxi zzgxiVar) throws zzgyn {
        zzbm(bArr, i, i2, zzgxiVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    public /* bridge */ /* synthetic */ zzgzi zzaW(zzgww zzgwwVar, zzgxi zzgxiVar) throws IOException {
        zzbk(zzgwwVar, zzgxiVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    public /* bridge */ /* synthetic */ zzgzi zzaZ(byte[] bArr, int i, int i2) throws zzgyn {
        zzbl(bArr, i, i2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    public /* bridge */ /* synthetic */ zzgzi zzba(byte[] bArr, int i, int i2, zzgxi zzgxiVar) throws zzgyn {
        zzbm(bArr, i, i2, zzgxiVar);
        return this;
    }

    public final BuilderType zzbg() {
        if (this.zzb.zzcf()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    /* JADX INFO: renamed from: zzbh, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public BuilderType zzaP() {
        BuilderType buildertype = (BuilderType) zzbt().zzcZ();
        buildertype.zza = (MessageType) zzbs();
        return buildertype;
    }

    public BuilderType zzbi(MessageType messagetype) {
        zzbj(messagetype);
        return this;
    }

    public BuilderType zzbj(MessageType messagetype) {
        if (zzbt().equals(messagetype)) {
            return this;
        }
        zzbu();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbk(zzgww zzgwwVar, zzgxi zzgxiVar) throws IOException {
        zzbu();
        try {
            zzgzt.zza().zzb(this.zza.getClass()).zzh(this.zza, zzgwx.zzq(zzgwwVar), zzgxiVar);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    public BuilderType zzbl(byte[] bArr, int i, int i2) throws zzgyn {
        int i3 = zzgxi.zzb;
        int i4 = zzgzt.zza;
        zzbm(bArr, i, i2, zzgxi.zza);
        return this;
    }

    public BuilderType zzbm(byte[] bArr, int i, int i2, zzgxi zzgxiVar) throws zzgyn {
        zzbu();
        try {
            zzgzt.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, i, i + i2, new zzgwa(zzgxiVar));
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzgyn.zzi();
        }
    }

    /* JADX INFO: renamed from: zzbn, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbr() {
        MessageType messagetype = (MessageType) zzbs();
        if (messagetype.zzbw()) {
            return messagetype;
        }
        throw zzgvu.zzbb(messagetype);
    }

    @Override // com.google.android.gms.internal.ads.zzgzi
    /* JADX INFO: renamed from: zzbo, reason: merged with bridge method [inline-methods] */
    public MessageType zzbs() {
        if (!this.zza.zzcf()) {
            return this.zza;
        }
        this.zza.zzbW();
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgzk
    /* JADX INFO: renamed from: zzbp, reason: merged with bridge method [inline-methods] */
    public MessageType zzbt() {
        return this.zzb;
    }

    public /* bridge */ /* synthetic */ zzgzi zzbq() {
        zzbg();
        return this;
    }

    public final void zzbu() {
        if (this.zza.zzcf()) {
            return;
        }
        zzbv();
    }

    public void zzbv() {
        MessageType messagetype = (MessageType) zza();
        zzb(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.ads.zzgzk
    public final boolean zzbw() {
        return zzgxy.zzce(this.zza, false);
    }
}
