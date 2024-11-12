import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
//        Interact.books.add(new Book(01, "Cấu trúc dữ liệu và Giải thuật", "Nguyễn Văn X", 2000, "Tổng quan về ctdl & gt", 100000));
//        Interact.books.add(new Book(02, "Lập trình Java cơ bản", "Trần Thị Y", 2015, "Giới thiệu ngôn ngữ lập trình Java", 150000));
//        Interact.books.add(new Book(03, "Kỹ thuật lập trình C++", "Nguyễn Thị A", 2018, "Hướng dẫn lập trình từ cơ bản đến nâng cao trong C++", 200000));
//        Interact.books.add(new Book(04, "Cơ sở dữ liệu", "Lê Văn B", 2012, "Tổng quan về cơ sở dữ liệu và SQL", 175000));
//        Interact.books.add(new Book(05, "Hệ điều hành", "Hoàng Văn C", 2010, "Cấu trúc và hoạt động của các hệ điều hành phổ biến", 180000));
//        Interact.books.add(new Book(06, "Mạng máy tính", "Phạm Văn D", 2013, "Các nguyên lý cơ bản và mô hình mạng máy tính", 160000));
        Interact.books.add(new Book(07, "Lập trình Python", new Author("Cuong", 20), 2024, "Introduce about python", 1350000));
        while(true){
            System.out.println("\n---------------------------Menu------------------------------");
            int choice;
            do{
                System.out.println("0. Thoát");
                System.out.println("1. Thêm sách mới");
                System.out.println("2. Chỉnh sửa thông tin sách");
                System.out.println("3. In danh sách các cuốn sách có trong mảng");
                System.out.println("4. In ra cuốn sách lâu đời cổ kính nhất");
                System.out.println("5. In ra cuốn sách phù hợp với giá tiền người mua yêu cầu");
                System.out.println("6. Sắp xếp lại danh sách các cuốn sách(theo tên hoặc theo giá tiền)");
                System.out.print("\nNhap lua chon: ");
                choice = sn.nextInt();
                switch (choice){
                    case 0:
                        System.out.println("Thoát chương trình!");
                        break;
                    case 1:
                        Interact.addBook();
                        break;
                    case 2:
                        Interact.updateBook();
                        break;
                    case 3:
                        System.out.println("Danh sách hiện tại là: ");
                        Interact.printList();
                        break;
                    case 4:
                        Interact.printOlderBooks();
                        break;
                    case 5:
                        Interact.printBookWithCost();
                        break;
                    case 6:
                        System.out.println("Chọn cách muốn sắp xếp(1 hoặc 2):\n1. Theo tên\n2. Theo giá tiền");
                        int sortSelection;
                        do{
                            System.out.print("sortSelection: ");
                            sortSelection = sn.nextInt();
                            if(sortSelection == 1) Interact.sortByName();
                            else if(sortSelection == 2) Interact.sortByPrice();
                            else System.out.println("Không hợp lệ! Nhập lại");
                        }while(sortSelection != 1 && sortSelection != 2);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            }while(choice >  6 || choice <  0);
            if(choice == 0) break;
        }
    }
}
