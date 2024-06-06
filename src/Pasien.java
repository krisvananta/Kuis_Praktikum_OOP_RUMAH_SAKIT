import java.util.ArrayList;
import java.util.List;
public class Pasien extends orang{
    private String pekerjaan;
    private String domisili;
    private List<Antrian> antrianPasien;

    public Pasien(String nama, String tanggal_lahir, JENIS_KELAMIN jenis_kelamin, String pekerjaan, String domisili) {
        super(nama, tanggal_lahir, jenis_kelamin);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
        this.antrianPasien = new ArrayList<>();
    }

    public void periksa(RumahSakit rumahSakit) {
        if (!antrianPasien.isEmpty()) {
            Antrian antrian = antrianPasien.remove(0);
            rumahSakit.selesaikanAntrian(antrian);
            System.out.println(getNama() + " telah diperiksa oleh Dr. " + antrian.getDokter().getNama());
        } else {
            System.out.println(getNama() + " belum mendaftar untuk pemeriksaan.");
        }
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasiens) {
        Dokter dokter = rumahSakit.getDokterByName(namaDokter);
        if (dokter != null) {
            for (Antrian antrian : antrianPasien) {
                if (antrian.getDokter().equals(dokter)) {
                    System.out.println("Pasien dengan nama " + getNama() + " sudah terdaftar pada Dr. " + dokter.getNama());
                    return;
                }
            }

            String nomorAntrian = dokter.getNomorSTR() + "-" + (dokter.getAntrianPasien().size() + 1);
            Antrian antrian = new Antrian(nomorAntrian, getNama(), keluhan, dokter, tipePasiens);
            antrianPasien.add(antrian);
            rumahSakit.tambahAntrian(antrian);
            dokter.tambahAntrian(antrian);
            System.out.println(getNama() + " telah terdaftar untuk pemeriksaan dengan Dr. " + dokter.getNama());
        } else {
            System.out.println("Dokter dengan nama " + namaDokter + " tidak ditemukan di rumah sakit.");
        }
    }
}
