import java.util.ArrayList;
import java.util.List;

public class Dokter extends orang{
    private String nomorSTR;
    private String spesialis;
    private List<Antrian> antrianPasien;

    public Dokter(String nama, String tanggal_lahir, JENIS_KELAMIN jenis_kelamin, String nomorSTR, String spesialis) {
        super(nama, tanggal_lahir, jenis_kelamin);
        this.nomorSTR = nomorSTR;
        this.spesialis = spesialis;
        this.antrianPasien = new ArrayList<>();
    }

    public String getNomorSTR() {
        return nomorSTR;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public List<Antrian> getAntrianPasien() {
        return antrianPasien;
    }

    public void tambahAntrian(Antrian antrian) {
        antrianPasien.add(antrian);
    }

    public void hapusAntrian(Antrian antrian) {
        antrianPasien.remove(antrian);
    }

    public void daftar(RumahSakit rumahSakit) {
        rumahSakit.tambahDokter(this);
    }
}
