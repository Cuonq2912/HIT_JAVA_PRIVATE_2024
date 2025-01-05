public class ThreadSafe {
    private static volatile ThreadSafe instance;

    private ThreadSafe(){}

    //trong 1 thoi diem chi co 1 luồng lay duoc ra instance
    private static synchronized ThreadSafe getInstance(){
        if (instance == null) {
            instance = new ThreadSafe();
        }
        return instance;
    }
}
