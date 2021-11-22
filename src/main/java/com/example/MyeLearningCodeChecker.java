import java.util.ArrayList;
import java.util.Arrays;

//first use NumChecker

public class MyeLearningCodeChecker {

    public boolean checkForCode(ArrayList<String> fileName) {

        if (fileName.get(0).length() == 17 && fileName.get(0).contains("-")) {

            ArrayList<String> codesList = new ArrayList<String>(Arrays.asList(fileName.get(0).split("-")));

            if (codesList.get(0).length() == 10 && codesList.get(1).length() == 6) {
                return true;
            }
        }
        return false;
    }

}