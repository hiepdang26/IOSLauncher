package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import defpackage.de;
import defpackage.df;
import defpackage.fe;
import defpackage.ks0;
import defpackage.la1;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, la1> {
    private static final ks0 MEDIA_TYPE = ks0.a("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    @Override // retrofit2.Converter
    public la1 convert(T t) throws IOException {
        fe feVar = new fe();
        JsonWriter jsonWriterNewJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(new de(feVar), UTF_8));
        this.adapter.write(jsonWriterNewJsonWriter, t);
        jsonWriterNewJsonWriter.close();
        return la1.create(MEDIA_TYPE, new df(feVar.j()));
    }
}
