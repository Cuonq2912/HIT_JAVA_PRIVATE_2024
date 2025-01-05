public class DoubleCheckLocking {
    private static volatile DoubleCheckLocking instance;

    private DoubleCheckLocking(){};

    private static DoubleCheckLocking getInstance(){
        if(instance == null){
            synchronized (DoubleCheckLocking.class){
                if(instance == null){
                    instance = new DoubleCheckLocking();
                }
            }
        }
        return instance;
    }
}

//Từ khóa volatile được sử dụng để khai báo một biến có thể được truy cập bởi nhiều luồng.
//Từ khóa synchronized được sử dụng để đồng bộ hóa truy cập tới một khối mã hoặc một phương thức, nhằm ngăn nhiều luồng truy cập đồng thời vào các tài nguyên dùng chung.
//Khi một luồng truy cập vào mã synchronized, các luồng khác sẽ bị chặn cho đến khi luồng hiện tại hoàn tất công việc.

