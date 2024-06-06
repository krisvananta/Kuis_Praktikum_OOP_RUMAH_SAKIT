public class Antrian {
    public enum tipePasiens{
        MANDIRI,
        BPJS
    }

    private String nomorAntrian;
    private String namaPendaftar;
    private String keluhan;
    private Dokter dokter;
    private tipePasiens tipePasien;

    public Antrian(String nomorAntrian, String namaPendaftar, String keluhan, Dokter dokter, tipePasiens tipePasien) {
        this.nomorAntrian = nomorAntrian;
        this.namaPendaftar = namaPendaftar;
        this.keluhan = keluhan;
        this.dokter = dokter;
        this.tipePasien = tipePasien;
    }

    public String getNomorAntrian() {
        return nomorAntrian;
    }

    public String getNamaPendaftar() {
        return namaPendaftar;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public tipePasiens getTipePasien() {
        return tipePasien;
    }

    @Override
    public String toString() {
        return "Antrian{" +
                "nomorAntrian='" + nomorAntrian + '\'' +
                ", namaPendaftar='" + namaPendaftar + '\'' +
                ", keluhan='" + keluhan + '\'' +
                ", dokter=" + dokter.getNama() +
                ", tipePasien=" + tipePasien +
                '}';
    }
}
