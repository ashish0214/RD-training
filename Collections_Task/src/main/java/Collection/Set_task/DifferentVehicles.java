package Collection.Set_task;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DifferentVehicles {
    private Set<String> vehiclesType;

    public DifferentVehicles(Set<String> vehiclesType) {
        this.vehiclesType = vehiclesType;
    }

    public Set<String> getVehiclesType() {
        return vehiclesType;
    }

    public void setVehiclesType(Set<String> vehiclesType) {
        this.vehiclesType = vehiclesType;
    }

    public DifferentVehicles(){
        this.vehiclesType=new HashSet<>();
    }

    public void addingVehicleType(String type){
        vehiclesType.add(type);
    }
    public void removeVehicleType(String type){
        vehiclesType.remove(type);
    }
    public void checkAllVehicleType(){
        Iterator iterate=vehiclesType.iterator();
        while (iterate.hasNext()){
            System.out.println(iterate.next());
        }
    }
    public boolean doesVehicleTypeExists(String type){
        return vehiclesType.contains(type);
    }
}
