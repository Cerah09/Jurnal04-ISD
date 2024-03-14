import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class Tugas {
    String mataKuliah;
    String namaTugas;
    String deadline;

    public Tugas(String mataKuliah, String namaTugas, String deadline) {
        this.mataKuliah = mataKuliah;
        this.namaTugas = namaTugas;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Mata Kuliah: " + mataKuliah + ", Nama Tugas: " + namaTugas + ", Deadline: " + deadline;
    }
}

public class ToDoList {
    private static LinkedList<Tugas> listTugas = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Hapus Tugas");
            System.out.println("3. Cetak List Tugas dari Awal");
            System.out.println("4. Cetak List Tugas dari Akhir");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahTugas(scanner);
                    break;
                case 2:
                    hapusTugas(scanner);
                    break;
                case 3:
                    cetakListDariAwal();
                    break;
                case 4:
                    cetakListDariAkhir();
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }

    private static void tambahTugas(Scanner scanner) {
        System.out.print("Masukkan Mata Kuliah: ");
        String mataKuliah = scanner.next();
        System.out.print("Masukkan Nama Tugas: ");
        String namaTugas = scanner.next();
        System.out.print("Masukkan Deadline Tugas: ");
        String deadline = scanner.next();

        Tugas tugas = new Tugas(mataKuliah, namaTugas, deadline);
        listTugas.addFirst(tugas);
    }

    private static void hapusTugas(Scanner scanner) {
        if (listTugas.isEmpty()) {
            System.out.println("List tugas kosong.");
            return;
        }

        System.out.println("Pilih cara penghapusan:");
        System.out.println("1. Hapus dari Awal");
        System.out.println("2. Hapus dari Akhir");
        System.out.println("3. Hapus berdasarkan Mata Kuliah");
        System.out.println("4. Hapus berdasarkan Nama Tugas");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                listTugas.removeFirst();
                break;
            case 2:
                listTugas.removeLast();
                break;
            case 3:
                hapusBerdasarkanMataKuliah(scanner);
                break;
            case 4:
                hapusBerdasarkanNamaTugas(scanner);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static void hapusBerdasarkanMataKuliah(Scanner scanner) {
        System.out.print("Masukkan Mata Kuliah yang ingin dihapus: ");
        String mataKuliah = scanner.next();

        ListIterator<Tugas> iterator = listTugas.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().mataKuliah.equals(mataKuliah)) {
                iterator.remove();
            }
        }
    }

    private static void hapusBerdasarkanNamaTugas(Scanner scanner) {
        System.out.print("Masukkan Nama Tugas yang ingin dihapus: ");
        String namaTugas = scanner.next();

        ListIterator<Tugas> iterator = listTugas.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().namaTugas.equals(namaTugas)) {
                iterator.remove();
            }
        }
    }

    private static void cetakListDariAwal() {
        System.out.println("List Tugas dari Awal:");
        for (Tugas tugas : listTugas) {
            System.out.println(tugas);
        }
    }

    private static void cetakListDariAkhir() {
        System.out.println("List Tugas dari Akhir:");
        ListIterator<Tugas> iterator = listTugas.listIterator(listTugas.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
