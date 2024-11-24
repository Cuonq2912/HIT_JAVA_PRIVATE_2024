package service.impl;

import model.VinCar;
import service.ICarService;

import java.util.ArrayList;
import java.util.List;

public class ICarServiceImpl implements ICarService {

    List<VinCar> carList = new ArrayList<>();
    public ICarServiceImpl(){
        this.carList = new ArrayList<>();
    }

    @Override
    public void displayCar() {
        for (VinCar c : carList){
            c.display();
        }
    }

    @Override
    public boolean addCar(VinCar c) {
        carList.add(c);
        return true;
    }

    @Override
    public boolean deleteCar(String id) {
        for (VinCar c : carList){
            if(c.getId().equals(id)){
                carList.remove(c);
            }
        }
        return true;
    }
}
