package tests.test14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public Integer[] getArrayFollowed4(Integer[] inArray) {
        List<Integer> resultArray = new ArrayList<>();
        for (int i = inArray.length - 1; i >= 0; i--) {
            if (inArray[i] == 4) {
                Collections.reverse(resultArray);
                return resultArray.toArray(new Integer[0]);
            }
            resultArray.add(inArray[i]);
        }
        throw new RuntimeException();
    }

    public Boolean isOnly4and1(int[] array) {
        boolean is4 = false;
        boolean is1 = false;
        for (int item : array) {
            if (item != 1 && item != 4) {
                return false;
            }
            is1 |= item == 1;
            is4 |= item == 4;
        }
        return is1 && is4;
    }
}
