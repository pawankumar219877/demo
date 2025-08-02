import com.example.demo.model.SortingModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[]  arg){
//        Collections.sort(liveFeedModelList,
//                (o1, o2) -> o1.getBuyPriority().compareTo(o2.getBuyPriority()));


        List<SortingModel> sortingModelList = new ArrayList<>();
        sortingModelList.add(new SortingModel("pawan",42l));
        sortingModelList.add(new SortingModel("pawan",14l));
        sortingModelList.add(new SortingModel("pawan",54l));
        sortingModelList.add(new SortingModel("pawan",4l));
Collections.sort(sortingModelList, (o1,o2)->o2.getRollNo().compareTo(o1.getRollNo()));

//System.out.println(sortingModelList);
    }
}
