package Homework4;

import java.util.ArrayList;
import java.util.Scanner;

public class Interact {
    static Scanner sn = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    // Thêm sách mới
    public static void addBook(){
        Book new_book = Book.newBook(sn);
        books.add(new_book);
        System.out.println("Thêm sách vào danh sách thành công!");
    }

    // Cập nhật thông tin sách
    public static void updateBook(){
        System.out.print("Nhập mã sách muốn chỉnh sửa: ");
        int maSach  = sn.nextInt();
        sn.nextLine();

        Book bookWantUpdate = null;
        for(Book book : books){
            if(book.getMaSach() == maSach){
                bookWantUpdate = book;
                break;
            }
        }
        if(bookWantUpdate == null){
            System.out.println("Không tìm thấy cuốn sách muốn chỉnh sửa thông tin!");
        }
        else{
            Book new_book = Book.newBook(sn);
            bookWantUpdate.setMaSach(new_book.getMaSach());
            bookWantUpdate.setTenSach(new_book.getTenSach());
            bookWantUpdate.setTenTacGia(new_book.getTenTacGia());
            bookWantUpdate.setNamSanXuat(new_book.getNamSanXuat());
            bookWantUpdate.setTomtatNoiDung(new_book.getTomtatNoiDung());
            bookWantUpdate.setGiaTien(new_book.getGiaTien());
            System.out.println("Chỉnh sửa thành công!!");
        }
    }

    // In danh sách các sách
    public static void printList(){
        if(books.isEmpty()) System.out.println("Danh sách rỗng");
        else{
            for(Book book : books){
                book.Display();
            }
        }
    }

    // In các sách lâu đời nhất
    public static void printOlderBooks(){
        int oldestAge = Integer.MAX_VALUE;
        for(Book book : books){
            oldestAge = Math.min(oldestAge, book.getNamSanXuat());
        }
        System.out.println("Những cuốn sách lâu đời nhất là: ");
        for(Book book : books){
            if(book.getNamSanXuat() == oldestAge){
                book.Display();
            }
        }
    }

    // Tìm sách gần nhất với giá tiền người dùng nhập vào
    public static void printBookWithCost(){
        System.out.print("Nhập giá tiền: ");
        int cost = sn.nextInt();
        int nearestCost = Integer.MAX_VALUE;
        for(Book book : books){
            nearestCost = Math.min(nearestCost, Math.abs((int)(cost - book.getGiaTien())));
        }
        System.out.println("Các sách phù hợp với giá tiền là: ");
        for(Book book : books){
            if(Math.abs((int)(cost - book.getGiaTien())) == nearestCost){
                book.Display();
            }
        }
    }

    // Sắp xếp sách theo giá tiền tăng dần
    public static void sortByPrice(){
        for(int i = 0; i < books.size() - 1; i++){
            for(int j = i + 1; j < books.size(); j++){
                if(books.get(i).getGiaTien() > books.get(j).getGiaTien()){
                    Book tmp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, tmp);
                }
            }
        }
        System.out.println("Danh sách sau khi sắp xếp tăng dần theo giá tiền là: ");
        printList();
    }

    // Sắp xếp sách theo tên sách tăng dần
    public static void sortByName(){
        for(int i = 0; i < books.size() - 1; i++){
            for(int j = i + 1; j < books.size(); j++){
                if(books.get(i).getTenSach().compareToIgnoreCase(books.get(j).getTenSach()) > 0){
                    Book tmp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, tmp);
                }
            }
        }
        System.out.println("Danh sách sau khi sắp xếp tăng dần theo tên là:");
        printList();
    }
}

