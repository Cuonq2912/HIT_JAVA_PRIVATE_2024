#include <bits/stdc++.h>
using namespace std;

#define MAX 100

struct SinhVien {
    char masv[10];
    char hodem[10];
    char ten[10];
    int namSinh;
    float demtk;
};

struct List {
    int cnt;
    SinhVien E[MAX];
};

void Initialize(List &L) {
    L.cnt = -1;
}

int Full(List L) {
    return L.cnt == MAX - 1;
}

int Empty(List L) {
    return L.cnt == -1;
}

int Add(List &L, SinhVien X) {
    if (Full(L)) {
        return 0;
    } else {
        L.cnt++;
        L.E[L.cnt] = X;
        return 1;
    }
}

void nhapsv(SinhVien &sv) {
    cout << "Nhap ma sinh vien: ";
    cin.getline(sv.masv, 10);

    if (strcmp(sv.masv, "***") == 0) {
        return;
    }

    cout << "Ho dem: ";
    cin.getline(sv.hodem, 10);
    cout << "Nhap ten sinh vien: ";
    cin.getline(sv.ten, 10);
    cout << "Nhap nam sinh: ";
    cin >> sv.namSinh;
    cout << "Nhap diem tk: ";
    cin >> sv.demtk;
    cin.ignore();
}

void nhapDS(List &L) {
    Initialize(L);
    SinhVien X;
    int i = 1;
    do {
        cout << "Nhap sv thu " << i << endl;
        nhapsv(X);
        if (strcmp(X.masv, "***") == 0) {
            break;
        }
        if (!Add(L, X)) return;
        i++;
    } while (1);
}

void hien_thi_DS(List L) {
    if (Empty(L)) {
        cout << "Danh sach rong!" << endl;
        return;
    }

    cout << setw(5) << "STT"
         << setw(10) << "Ma SV"
         << setw(25) << "HO VA TEN"
         << setw(10) << "NAM SINH"
         << setw(10) << "diem TK" << endl;

    for (int i = 0; i <= L.cnt; i++) {
        cout << setw(5) << (i + 1)
             << setw(10) << L.E[i].masv
             << setw(17) << L.E[i].hodem
             << setw(8) << L.E[i].ten
             << setw(10) << L.E[i].namSinh
             << setw(10) << L.E[i].demtk << endl;
    }
}

void del_first(List &L){
    if(Empty(L)){
        return;
    }
    for(int i = 1; i <= L.cnt; i++){
        L.E[i - 1] = L.E[i];
    }
    L.cnt--;
}

int search(List L, const char *ma) {
    for (int i = 0; i <= L.cnt; i++) {
        if (strcmp(L.E[i].masv, ma) == 0) {
            return i + 1; // Trả về vị trí (1-based)
        }
    }
    return 0; // Không tìm thấy
}


void Remove(int k, List& L){
    for(int i = k - 1; i < L.cnt; i++){
        L.E[i] = L.E[i + 1];
    }
    L.cnt--;
}

int Xoa_sv8089(List &L) {
    int k = search(L, "sv"); // Tìm vị trí sinh viên có mã "sv8089"
    if (k == 0) {
        return 0; // Không tìm thấy
    }
    Remove(k, L); // Xóa sinh viên tại vị trí tìm được
    return 1;
}


// them vao vi tri thu k
int Insert(int k, List &L){
    int i;
    SinhVien X;
    if(!Full(L) && k <= L.cnt + 1 && k >= 1){
        cout << "\nNhap sinh vien can bo sung\n";
		cin.ignore();
        nhapsv(X);
        for(int i = L.cnt; i >= k; i--){
            L.E[i + 1] = L.E[i];
        }
        L.cnt = L.cnt + 1;
        L.E[k - 1] = X;
        return 1;
    }
    else return 0;
}

void sort(List &L){
    for(int i = 1; i <= L.cnt; i++){
        for(int j = 0; j <= L.cnt - 1; j++){
            if(L.E[j].demtk < L.E[j + 1].demtk){
                SinhVien tmp = L.E[j];
                L.E[j] = L.E[j + 1];
                L.E[j + 1] = tmp;
            }
        }
    }
}

int SortSearch(List &L){
    SinhVien X;
    if(Full(L)) return 0;
    nhapsv(X);
    int i = L.cnt;
    while(i >= 0 && L.E[i].demtk < X.demtk){
        L.E[i + 1] = L.E[i];
        i--;
    }
    L.E[i + 1] = X;
    L.cnt++;
    return 1;
}

void lietKe(List L){
    int i = 0, d = 0;
    cout    << setw(5) << "STT"
            << set(10) << "Ma SV"
            << set(25) << "HO VA TEN"
            << set(10) << "NAM SINH"
            << set(10) << "diem TK" << endl;
    while(i <= L.cnt){
        if(strcmp(L.E[i].ten, "Doand") == 0){
            cout << setw(5) << (L + i)
                << setw(10) << L.E[i].masv
                << setw(17) << L.E[i].hodem
                << setw(8) << L.E[i].ten
                << setw(10) << L.E[i].namSinh
                << setw(10) << L.E[i].demtk << endl;
                d++;
        }
        i++;
    }
    if(d == 0){
        cout << "Khong co sinh vien ten Doanh" << endl;
    }
}


int main() {
    List L;
    nhapDS(L);
    cout << "Danh sach vua nhap:\n";
    hien_thi_DS(L);
    
//	del_first(L);
//    hien_thi_DS(L);

//    if(Xoa_sv8089(L) == 1){
//        cout << "Ds sau khi xoa sv 8089\n";
//        hien_thi_DS(L);
//    } else cout << "Khong co sv co ma nay\n";

//	int k; cout << "Nhap vi tri muon bo sung: "; cin >> k;
//    if(Insert(k, L) == 1){
//        cout << "\n Danh sach sv vua bo sung\n";
//        hien_thi_DS(L);
//    }
//    else{
//        cout << "Vi tri khong thich hop\n";
//    }

	sort(L);
    cout << "Sau sx:\n";
    hien_thi_DS(L);
    
    if(SortSearch(L) == 0){
        cout << "Danh sach day\n";
    }
    else{
        cout << "Danh sach bo sung sau sap xep: \n";
        hien_thi_DS(L);
    }

	

    return 0;
}
