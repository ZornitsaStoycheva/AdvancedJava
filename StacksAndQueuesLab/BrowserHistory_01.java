package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String history = scanner.nextLine();

        ArrayDeque<String> historyBrowser = new ArrayDeque<>();

        String browser = null;

        while (!history.equals("Home")) {
            if(history.equals("back")) {
                if(historyBrowser.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    browser = historyBrowser.pop();
                }
            } else {
                if(browser != null) {
                    historyBrowser.push(browser);
                }
                browser = history;
                System.out.println(browser);
            }

            history = scanner.nextLine();
        }

    }
}
