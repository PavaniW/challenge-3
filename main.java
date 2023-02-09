import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class main {

  public static void main(String[] args) {
    int[] array = new int[]{47, 84, 75, 21, 14, 14, 79};

    // Sort the array
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }

    // Find the median
    int median;
    if (array.length % 2 == 0) {
      median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
    } else {
      median = array[array.length / 2];
    }

    // Find the highest value
    int highestValue = array[array.length - 1];

    // Find the mode
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      if (frequencyMap.containsKey(num)) {
        frequencyMap.put(num, frequencyMap.get(num) + 1);
      } else {
        frequencyMap.put(num, 1);
      }
    }
    int mode = 0;
    int maxFrequency = 0;
    for (int key : frequencyMap.keySet()) {
      int frequency = frequencyMap.get(key);
      if (frequency > maxFrequency) {
        mode = key;
        maxFrequency = frequency;
      }
    }

    // Find the prime numbers
    List<Integer> primeNumbers = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      boolean isPrime = true;
      if (num <= 1) {
        isPrime = false;
      } else {
        for (int j = 2; j < num; j++) {
          if (num % j == 0) {
            isPrime = false;
            break;
          }
        }
      }
      if (isPrime) {
        primeNumbers.add(num);
      }
    }

    System.out.println("Sorted array: ");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println("\nMedian: " + median);
    System.out.println("Highest value: " + highestValue);
    System.out.println("Mode: " + mode);
    System.out.println("Prime numbers: " + primeNumbers);
  }
}
