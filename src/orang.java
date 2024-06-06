public class orang{
    private String nama;
    private String tanggal_lahir;
    private JENIS_KELAMIN jenis_kelamin;

    public enum JENIS_KELAMIN {
        LAKI_LAKI,
        PEREMPUAN
    }

    public orang(String nama, String tanggal_lahir, JENIS_KELAMIN jenis_kelamin) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggalLahir() {
        return tanggal_lahir;
    }

    public JENIS_KELAMIN getJenisKelamin() {
        return jenis_kelamin;
    }
}

