package enumTest;

import java.util.ArrayList;
import java.util.List;

public class EnumUtilsDemo {
    public static void main(String[] args) {
        List<String> seaconList = new ArrayList<>();
        for (Season value : Season.values()) {
            String season = value.getSeason();
            seaconList.add(season);
        }
        System.out.println(seaconList);
    }
}

