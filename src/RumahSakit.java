import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RumahSakit {
    private String nama;
    private String alamat;
    private String noTelepon;
    private List<Dokter> listDokter;
    private List<Antrian> listAntrianPasien;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.listDokter = new ArrayList<>();
        this.listAntrianPasien = new ArrayList<>();
    }

    public void cekAntrianPasien() {
        if (listAntrianPasien.isEmpty()) {
            for (Dokter dokter : listDokter) {
                System.out.println("DR. " + dokter.getNama());
                System.out.println("ANTRIAN KOSONG");
                System.out.println("==============");
            }
        } else {
            Map<Dokter, List<Antrian>> antrianPerDokter = new HashMap<>();
            // Kelompokkan antrian berdasarkan dokter
            for (Antrian antrian : listAntrianPasien) {
                Dokter dokter = antrian.getDokter();
                if (!antrianPerDokter.containsKey(dokter)) {
                    antrianPerDokter.put(dokter, new ArrayList<>());
                }
                antrianPerDokter.get(dokter).add(antrian);
            }

            System.out.println("ANTRIAN RUMAH SAKIT SAAT INI");
            System.out.println("=============================");

            for (Map.Entry<Dokter, List<Antrian>> entry : antrianPerDokter.entrySet()) {
                Dokter dokter = entry.getKey();
                System.out.println("DR. " + dokter.getNama());
                List<Antrian> antrianDokter = entry.getValue();
                for (Antrian antrian : antrianDokter) {
                    System.out.println("ID ANTRIAN: " + antrian.getNomorAntrian() + ", Atas nama: " + antrian.getNamaPendaftar());
                }
                System.out.println("=============================");
            }
        }
    }

    public void cekListDokter() {
        if (listDokter.isEmpty()) {
            System.out.println("Tidak ada dokter tersedia saat ini.");
        } else {
            System.out.println("List dokter yang tersedia:");
            for (Dokter dokter : listDokter) {
                System.out.println("Dr. " + dokter.getNama() + " - Spesialis: " + dokter.getSpesialis());
            }
        }
    }

    public void tambahDokter(Dokter dokter) {
        if (!listDokter.contains(dokter)) {
            listDokter.add(dokter);
            System.out.println("Dokter " + dokter.getNama() + " telah ditambahkan ke list dokter.");
        } else {
            System.out.println("Dokter " + dokter.getNama() + " sudah terdaftar.");
        }
    }

    public Dokter getDokterByName(String namaDokter) {
        for (Dokter dokter : listDokter) {
            if (dokter.getNama().equalsIgnoreCase(namaDokter)) {
                return dokter;
            }
        }
        return null;
    }

    public void tambahAntrian(Antrian antrian) {
        listAntrianPasien.add(antrian);
    }

    public void selesaikanAntrian(Antrian antrian) {
        listAntrianPasien.remove(antrian);
        antrian.getDokter().hapusAntrian(antrian);
    }
}
