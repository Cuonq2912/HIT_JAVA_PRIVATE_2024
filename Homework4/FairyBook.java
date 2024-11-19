package Homework4;

public class FairyBook extends Book{
    private int soLuongBan;

    public FairyBook(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public FairyBook(int maSach, String tenSach, Author tenTacGia, int namSanXuat, String tomtatNoiDung, double giaTien, int soLuongBan) {
        super(maSach, tenSach, tenTacGia, namSanXuat, tomtatNoiDung, giaTien);
        this.soLuongBan = soLuongBan;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        if(soLuongBan > 0)
            this.soLuongBan = soLuongBan;
    }

    @Override
    public String toString() {
        return "TruyenCoTich{" + super.toString()+
                "soLuongBan=" + soLuongBan +
                '}';
    }



}
