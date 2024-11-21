package Collection.Map_task.task1;

import java.util.HashMap;
import java.util.Map;

public class CityPopulationApp {
    private  Map<String, Integer> cityPopulationMap;

    public CityPopulationApp() {
        this.cityPopulationMap = new HashMap<>();
    }

    public void addCityPopulation( String cityName,  int population) {
        cityPopulationMap.put(cityName, population);
    }

}
