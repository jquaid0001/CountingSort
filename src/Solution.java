import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        // Init a List and populate with 100 Integers of 0 value
        List<Integer> freqArr = IntStream.of(new int[100])
                .boxed()
                .collect(Collectors.toList());

        // Find the max in arr
        int maxValInArr = arr.stream()
                .max(Comparator.naturalOrder())

        // Loop over 0..maxValInArr in freqArr and get count of each in arr
        for (int i = 0; i <= maxValInArr; i++) {
            int finalI = i;
            freqArr.set(i, Math.toIntExact(arr.stream()
                    .filter(x -> Objects.equals(x, finalI))
                    .count()));
        }

        return freqArr;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.countingSort(arr);

        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
