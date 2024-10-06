import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        arraySumOfElements();
        arrayFindLargestElement();
        guessAWord();
        System.out.println();
    }

    public static void arraySumOfElements() {
        int rows = 5;
        int result = 0;
        int[] array = new int[rows];

        Random random = new Random();

        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            result+=array[i];
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println("Сумма элементов массива: " + result);
    }

    public static void arrayFindLargestElement() {
        int rows = 6;
        int maxElement;
        int[] array = new int[rows];

        Random random = new Random();

        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }

        maxElement = array[0];

        for(int i = 0; i < array.length; i++) {
            if (array[i] > maxElement)
                maxElement = array[i];
        }
        System.out.println();

        System.out.println("Самый большой элемент массива: " + maxElement);
    }

    public static void guessAWord() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String guessedWord;
        String maskedWord = "";
        boolean isGuessed = false;

        list.add("word");
        list.add("memes");
        list.add("detected");

        guessedWord = list.get(random.nextInt(list.size()));
        System.out.println("Загаданное слово: " + guessedWord);

        for(int i = 0; i < guessedWord.length(); i++) {
            maskedWord += "#";
        }

        System.out.println(maskedWord);

        while(!isGuessed) {
            char userInput = scanner.next().charAt(0);

            for(int i = 0; i < guessedWord.length(); i++) {
                if(userInput == guessedWord.charAt(i)) {
                    maskedWord = maskedWord.substring(0, i) + userInput + maskedWord.substring(i + 1);
                }
            }

            System.out.println(maskedWord);
            if(maskedWord.equals(guessedWord)) {
                System.out.println("Угадано");
                isGuessed = true;
            }
        }
    }
}