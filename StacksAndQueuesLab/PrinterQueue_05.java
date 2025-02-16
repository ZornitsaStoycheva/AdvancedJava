package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String printer = scanner.nextLine();
        while (!printer.equals("print")) {

            if(printer.equals("cancel")) {
                if(queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", queue.poll());
                }
            } else {
                queue.offer(printer);
            }
            printer = scanner.nextLine();
        }
        for (String printerQueue : queue) {
            System.out.println(printerQueue);
        }
    }
}
