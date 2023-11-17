import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reserva bookingInstance = new Reserva();
        File archivo = new File("bookings.xml");
        Vector<Reserva> reservas = new Vector<>();

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Ingresar location number");
            System.out.println("2. Mostrar datos de la reserva");
            System.out.println("3. Mostrar todas las reservas hechas");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el location number: ");
                    String locationNumber = scanner.next();
                    bookingInstance = new Reserva();
                    bookingInstance.refreshData(archivo, locationNumber);
                    reservas.add(bookingInstance);
                    break;
                case 2:
                    bookingInstance.printBookingData();
                    break;
                case 3:
                    System.out.println("Mostrando todas las reservas:");
                    for (int i = 0; i < reservas.size(); i++) {
                        System.out.println("Reserva: " + (i + 1) + ":");
                        reservas.get(i).printBookingData();
                    }
                    break;
                case 4:
                    System.out.println("Cerrando");
                    break;
                default:
                    System.out.println("Fuera de parametro");
                    break;
            }

        } while (opcion != 3);

        scanner.close();
    }
}