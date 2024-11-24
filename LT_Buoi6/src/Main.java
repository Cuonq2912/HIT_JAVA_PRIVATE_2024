import model.Car;
import model.VinCar;
import service.ICarService;
import service.impl.ICarServiceImpl;
import java.util.ArrayList;
import java.util.List;
import static common.Sort.*;

public class Main {
    public static void main(String[] args) {
        Car c1 = new VinCar();
        List<VinCar> carList = new ArrayList<>();
        ICarService carService = new ICarServiceImpl();
        VinCar c = new VinCar("001", 100, 2, "Lux-A");
        carService.addCar(c);
        if(carService.addCar(c) == true){
            System.out.println("Success");
        }
        BubbleSort();

        carService.displayCar();
    }
}



// phan biet abstract va interface
//interface chi chua nhung phuong thuc truu tuong(trừu tượng 100%), đảm bảo cho chương trình
//                                        tuân thủ hoàn toàn theo tính trừu tượng của oop
//abstract class la bán truu tuong (trừu tượng 50%), co chua truu tuong và (hoặc) tường minh
//                 ko thể khởi tạo instant từ ab class


// 4 tc : linh hoat, giam thieu ma nguan, co ghe ap dung code
// MVC : model view controller

//btvn:
//map: hash map
//tree: tree map
//set: tree set