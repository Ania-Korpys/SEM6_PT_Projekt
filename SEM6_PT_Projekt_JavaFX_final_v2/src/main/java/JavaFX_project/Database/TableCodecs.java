package JavaFX_project.Database;

public class TableCodecs {

    private int codec_id;               // id_kodeka
    private String codec_name;          // nazwa_kodeka
    private String frequency_range;     // zakres_czestotliwosci
    private float max_kbps_bitrate;     // maks_przeplywnosc_kbps
    private float frame_ms;             // ramka_ms
    private int max_bits_per_frame;     // maks_ilosc_bitow_na_ramke
    private float algorithmic_delay_ms; // opoznienie_algorytmiczne_ms
    private String compression_type;    // typ_kompresji
    private float mips;                 // maks_mips
    private float mos;                  // mos

    public TableCodecs() {
    }

    public TableCodecs(int codec_id, String codec_name, String frequency_range, float max_kbps_bitrate, float frame_ms, int max_bits_per_frame, float algorithmic_delay_ms, String compression_type, float mips, float mos) {
        this.codec_id = codec_id;
        this.codec_name = codec_name;
        this.frequency_range = frequency_range;
        this.max_kbps_bitrate = max_kbps_bitrate;
        this.frame_ms = frame_ms;
        this.max_bits_per_frame = max_bits_per_frame;
        this.algorithmic_delay_ms = algorithmic_delay_ms;
        this.compression_type = compression_type;
        this.mips = mips;
        this.mos = mos;
    }

    public int getCodec_id() {
        return codec_id;
    }

    public void setCodec_id(int codec_id) {
        this.codec_id = codec_id;
    }

    public String getCodec_name() {
        return codec_name;
    }

    public void setCodec_name(String codec_name) {
        this.codec_name = codec_name;
    }

    public String getFrequency_range() {
        return frequency_range;
    }

    public void setFrequency_range(String frequency_range) {
        this.frequency_range = frequency_range;
    }

    public float getMax_kbps_bitrate() {
        return max_kbps_bitrate;
    }

    public void setMax_kbps_bitrate(float max_kbps_bitrate) {
        this.max_kbps_bitrate = max_kbps_bitrate;
    }

    public float getFrame_ms() {
        return frame_ms;
    }

    public void setFrame_ms(float frame_ms) {
        this.frame_ms = frame_ms;
    }

    public int getMax_bits_per_frame() {
        return max_bits_per_frame;
    }

    public void setMax_bits_per_frame(int max_bits_per_frame) {
        this.max_bits_per_frame = max_bits_per_frame;
    }

    public float getAlgorithmic_delay_ms() {
        return algorithmic_delay_ms;
    }

    public void setAlgorithmic_delay_ms(float algorithmic_delay_ms) {
        this.algorithmic_delay_ms = algorithmic_delay_ms;
    }

    public String getCompression_type() {
        return compression_type;
    }

    public void setCompression_type(String compression_type) {
        this.compression_type = compression_type;
    }

    public float getMips() {
        return mips;
    }

    public void setMips(float mips) {
        this.mips = mips;
    }

    public float getMos() {
        return mos;
    }

    public void setMos(float mos) {
        this.mos = mos;
    }

    /*@Override
    public String toString() {
        return "{" + "id_kodeka=" + codec_id + ", nazwa_kodeka=" + codec_name + ", zakres_czestotliwosci=" + frequency_range
                + ", maks_przeplywnosc_kbps=" + max_kbps_bitrate + ", ramka_ms=" + frame_ms
                + ", maks_ilosc_bitow_na_ramke=" + max_bits_per_frame + ", opoznienie_algorytmiczne_ms=" + algorithmic_delay_ms
                + ", typ_kompresji=" + compression_type + ", maks_mips=" + mips + ", mos=" + mos + '}';
    }*/

    @Override
    public String toString() {
        return "{\n " + '"' + "id_kodeka" + '"' + ':' + '"' + codec_id + '"' +
                ",\n    " + '"' + "nazwa_kodeka" + '"' + ':' + '"' + codec_name + '"' +
                ",\n    " + '"' + "zakres_czestotliwosci" + '"' + ':' + '"' + frequency_range + '"' +
                ",\n    " + '"' + "maks_przeplywnosc_kbps" + '"' + ':' + '"' + max_kbps_bitrate + '"' +
                ",\n    " + '"' + "ramka_ms" + '"' + ':' + '"' + frame_ms + '"' +
                ",\n    " + '"' + "maks_ilosc_bitow_na_ramke" + '"' + ':' + '"' + max_bits_per_frame + '"' +
                ",\n    " + '"' + "opoznienie_algorytmiczne_ms" + '"' + ':' + '"' + algorithmic_delay_ms + '"' +
                ",\n    " + '"' + "typ_kompresji" + '"' + ':' + '"' + compression_type + '"' +
                ",\n    " + '"' + "maks_mips" + '"' + ':' + '"' + mips + '"' +
                ",\n    " + '"' + "mos" + '"' + ':' + '"' + mos + '"' + "\n}";
    }
}
