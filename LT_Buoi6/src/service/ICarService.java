package service;

import model.VinCar;

public interface ICarService {
    public void displayCar();
    public boolean addCar(VinCar c);
    public boolean deleteCar(String id);
}
