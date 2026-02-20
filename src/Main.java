import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your choice (0 for encryption, 1 for decryption):");
        String choice = sc.nextLine();
        switch (choice) {
            case "0":
                System.out.println("Please enter the string to be encrypted");
                System.out.println(encrypt(sc.next()));
                break;
            case "1":
                System.out.println("Please enter your encrypted string:");
                System.out.println(decrypt(sc.next()));
                break;
            default:
                System.out.println("Invalid choice. Exiting program now.");
                break;
        }

    }

    public static String encrypt(String text){
        StringBuilder encryptedString = new StringBuilder();
        Random rand = new Random();
        int seed = rand.nextInt(100);
        //appends 0 to pad it out properly if needed
        if(seed == 0){
            encryptedString.append("000");
        }else if(seed < 10){
            encryptedString.append("00");
        }else if(seed < 100){
            encryptedString.append("0");
        }
        encryptedString.append(seed);
        for(char character : text.toCharArray()){
            encryptedString.append((char)(character + seed));
        }
        return encryptedString.toString();
    }

    public static String decrypt(String text){
        StringBuilder decryptedString = new StringBuilder();
        int seed = Integer.parseInt(text.substring(0, 3));
        char[] chars = text.toCharArray();
        for(int i = 3; i < text.length(); i++){
            decryptedString.append((char)(chars[i] - seed));
        }
        return decryptedString.toString();
    }
}