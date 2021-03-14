package PBO;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    class Node {
        String data;
        Node prev, next;

        public Node(String data){
            this.data = data;
        }
    }

    private String data;

    Node head = new Node(data);

    public void push(String data) {
        Node newData = new Node(data);
        if (head == null) {
            head = newData;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newData;
    }

    public void showData() {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            System.out.print(cur.data + " > ");
        }
    }

    public int length() {
        int total = 0;
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            total++;
        }
        return total;
    }

    public void deleteAtIndex(int index) {
        if (index > length()) {
            System.out.println("index tidak ada");
            prompEnterKey();
        }
        Node cur = head;
        int curIndex = 0;
        while (cur != null) {
            Node lastNode = cur;
            cur = cur.next;
            if (curIndex == index) {
                lastNode.next = cur.next;
                return;
            }
            curIndex++;
        }
    }

    public void prompEnterKey() {
        System.out.println("press ENTER to continue");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Main sll = new Main();
        Scanner userInput = new Scanner(System.in);
        boolean keepRunnning = true;

        while (keepRunnning) {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("==============MAIN MENU==============\n");
            System.out.print("DLL --> ");
            sll.showData();
            System.out.println("\n");
            System.out.println("=====================================");
            System.out.println("\n1. tambah data depan");
            System.out.println("2. tambah data belakang (not fix)");
            System.out.println("3. delete data");
            System.out.println("4. panjang data");
            System.out.println("0. Exit");
            System.out.print("choose --> ");
            String choose = userInput.next();
            switch (choose) {
                case "1" :
                    System.out.print("Data --> ");
                    String data = userInput.next();
                    sll.push(data);
                    break;
//                case "2" :
//                    System.out.println("Data --> ");
//                    data = userInput.next();
//                    sll.prepend(data);
//                    break;
                case "3" :
                    if (sll.length() == 0) {
                        System.out.println("List masih kosong");
                        sll.prompEnterKey();
                        break;
                    }else{
                        System.out.print("index --> ");
                        int index = userInput.nextInt();
                        sll.deleteAtIndex(index);
                        break;
                    }
                case "4" :
                    System.out.println("Panjang data --> " + sll.length());
                    sll.prompEnterKey();
                    break;
                case "0" :
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    keepRunnning = false;
            }
        }

    }
}
