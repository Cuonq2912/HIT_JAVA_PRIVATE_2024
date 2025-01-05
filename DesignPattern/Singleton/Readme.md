# Singleton
## Khái niệm
- Là một trong nhóm Creational, nó sẽ đảm bảo duy nhất một thể thiện được tạo, hay còn có thể giải thích là xuyên suốt quá trình hoạt
  động của ứng dụng chỉ có duy nhất một đối tượng được tạo ra từ một class.
## Được sử dụng trong những trường hợp nào?
- Vì class dùng Singleton chỉ tồn tại 1 Instance nên nó thường được dùng cho các trường hợp giải quyết các bài toán cần truy cập vào các ứng dụng như: Shared resource, Logger, Configuration, Caching, Thread pool, …
- Một số design pattern khác cũng sử dụng Singleton để triển khai: Abstract Factory, Builder, Prototype, Facade,…
## Nguyên tắc để tạo lên một Singleton
- Hàm tạo hay còn gọi là constructor có thể truy cập với private tức chỉ có thể truy xuất trong nội bộ của class.
- Thể hiện của nó được đặt dạng ' private static final variable' để đảm bảo biến chỉ được khởi tạo trong class.
- có một method 'public static' để trả về thể hiện được đề cập bên trên.
## Có những cách tạo ra Singleton theo từng trường hợp sử dụng
- Trên thực tế chúng ta có rất nhiều cách để tạo ra một Singleton tuy nhiên những mẫu chính và thường gặp gồm 4 trường hợp sau : Eager initialization, Lazy Initialization, Thread Safe, Double Check Locking.
  - Eager Initialization: Khi ứng dụng luôn cần instance từ đầu. 
  - Lazy Initialization: Khi instance không được sử dụng thường xuyên. _VD: connect DB_
  - Thread Safe Singleton: Khi ứng dụng có khả năng chạy đa luồng nhưng không yêu cầu hiệu năng cao. _VD: ghi lại log để theo dõi hđộng_
  - Double Check Locking: Khi ứng dụng cần tối ưu hiệu năng trong môi trường đa luồng.