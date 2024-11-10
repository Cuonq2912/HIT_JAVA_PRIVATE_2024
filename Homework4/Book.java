import java.util.Scanner;

public class Book {
    protected int maSach;
    protected String tenSach;
    protected String tenTacGia;
    protected int namSanXuat;
    protected String tomtatNoiDung;
    protected double giaTien;

    static Scanner sn = new Scanner(System.in);

    public Book() {
    }

    public Book(int maSach, String tenSach, String tenTacGia, int namSanXuat, String tomtatNoiDung, double giaTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.namSanXuat = namSanXuat;
        this.tomtatNoiDung = tomtatNoiDung;
        this.giaTien = giaTien;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getTomtatNoiDung() {
        return tomtatNoiDung;
    }

    public void setTomtatNoiDung(String tomtatNoiDung) {
        this.tomtatNoiDung = tomtatNoiDung;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "Book{" +
                "maSach=" + maSach +
                ", tenSach='" + tenSach + '\'' +
                ", tenTacGia='" + tenTacGia + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", tomtatNoiDung='" + tomtatNoiDung + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }

    public void Display(){
        System.out.println(toString());
    }


    public static Book newBook(Scanner sn){
        System.out.println("Nhập thông tin cho cuốn sách: ");

        System.out.println("Nhập mã sách :");
        int maSach = sn.nextInt();
        sn.nextLine();

        System.out.println("Nhập tên sách: ");
        String tenSach = sn.nextLine();

        System.out.println("Nhập tên tác giả: ");
        String tenTacGia = sn.nextLine();

        System.out.println("Nhập năm sản xuất: ");
        int namSanXuat = sn.nextInt();
        sn.nextLine();

        System.out.println("Nhâp nội dung tóm tắt: ");
        String ndTomTat = sn.nextLine();

        System.out.println("Nhập giá tiền: ");
        double giaTien = sn.nextDouble();
        sn.nextLine();

        return new Book(maSach, tenSach, tenTacGia, namSanXuat, ndTomTat, giaTien);
    }
}
