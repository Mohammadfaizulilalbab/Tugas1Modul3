package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class RestaurantOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar menu restoran
        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Ayam Bakar", 25000));
        menu.add(new MenuItem("Es Teh", 5000));
        menu.add(new MenuItem("Jus Jeruk", 7000));

        // Menampilkan menu
        System.out.println("==== Selamat Datang di Restoran ====");
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d. %s - Rp %.2f\n", i + 1, menu.get(i).getName(), menu.get(i).getPrice());
        }

        Receipt receipt = new Receipt();

        // Pengguna menambahkan item ke pesanan
        while (true) {
            System.out.print("Pilih nomor menu (0 untuk selesai): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= menu.size()) {
                MenuItem selectedMenuItem = menu.get(choice - 1);
                System.out.print("Masukkan jumlah: ");
                int quantity = scanner.nextInt();
                receipt.addOrderItem(new OrderItem(selectedMenuItem, quantity));
                System.out.println("Item ditambahkan ke pesanan.");
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        // Menampilkan nota pesanan
        receipt.printReceipt();
        scanner.close();
    }
}
