    #include<bits/stdc++.h>
    using namespace std;

    #define sw setw

    // Khai bao CTDL cua danh sach
    struct NhanVien{
        char hoDem[10];
        char ten[10];
        char gioiTinh[10];
        char maNV[10];
        long hsLuong;
    };

    struct Node{
        NhanVien nv;
        Node* next;

        Node() : next(NULL){}
    };

    typedef Node* TRO;

    void Initialize(TRO& L){
        L = NULL;
    }

    bool isEmpty(TRO& L){
        return L == NULL;
    }

    int Length(TRO L) {
        int count = 0;
        TRO Q = L;
        while (Q != NULL) {
            count++;
            Q = Q->next;
        }
        return count;
    }


    NhanVien inputNhanVien(){
        NhanVien nv;
        cout << "Nhap thong tin cho nhan vien: \n";
        cout << "Nhap ma nhan vien: ";
        cin.getline(nv.maNV, 9);
        cout << "Nhap ho dem: ";
        cin.getline(nv.hoDem, 9);
        cout << "Nhap ten: ";
        cin.getline(nv.ten, 9);
        cout << "Nhap gioi tinh: ";
        cin.getline(nv.gioiTinh, 9);
        
        cout << "Nhap he so luong: ";
        cin >> nv.hsLuong;
        cin.ignore();
        return nv;
    }
    
    void showTitle(){
        cout << left << sw(10) << "STT" 
            << sw(15) << "Ho Dem" 
            << sw(10) << "Ten" 
            << sw(10) << "Gioi tinh" 
            << sw(15) << "MaNV" 
            << sw(5)  << "HSLuong" << endl; 
    }

    void showNV(NhanVien& nv){
        cout << left
            << sw(15) <<  nv.hoDem
            << sw(10) << nv.ten
            << sw(10) << nv.gioiTinh 
            << sw(15) << nv.maNV
            << sw(5)  << nv.hsLuong << endl; 
    }

    void showList(TRO& L){
        showTitle();
        Node* Cur = L;
        int id = 1;
        while(Cur != NULL){
            cout << sw(10) << id++;
            showNV(Cur->nv);
            Cur = Cur->next;
        }
    }
    
    // them nv = chen cuoi ds
    void addNhanVien(TRO& L, NhanVien nv){
        Node* newNode = new Node;
        newNode->nv = nv;
        // newNode->next = NULL;
        if(isEmpty(L)){
            L = newNode;
        }   
        else{
            Node* cur = L;
            while(cur->next != NULL){
                cur = cur->next;
            }
            cur->next = newNode;
        }
    }
    // chen dau
    void chendau(TRO& L, NhanVien nv){
        Node* newNode = new Node;
        newNode->nv = nv;
        newNode->next = L;
        L = newNode;
    }
    // chen vao sau nut tro boi Q
    void Insert(TRO& L, TRO& Q, NhanVien nv){
        TRO P;
        P = new Node;
        P->nv = nv;
        P->next = Q->next;
        Q->next = P;
    }
    //chen giua
    void chengiua(TRO& L){
        int k; NhanVien nv;
        do{
            cout << "Nhap vi tri bs( 0 < k <=  " << Length(L) << "): ";
            cin >> k;
        }while(k < 0 || k > Length(L));
        cout << "Nhap thong tin nhan vien can bo sung:\n";
        nv = inputNhanVien();
        // bs
        if(k == 1) chendau(L, nv);
        else{
            TRO Q = L;
            int d = 1;
            while(d < k - 1){ // tim vi tri truoc vi tri can chen
                d++;
                Q = Q->next;
            }
            Insert(L, Q, nv);
        }
    }

    // xoa boi con tro T
    void remove(TRO &L, TRO T){
        TRO Q;
        if(T == L) L = T->next;
        else{
            Q = L;
            while(Q->next != T){
                Q = Q->next;
            }
            Q->next = T->next;
        }
        delete T;
    }

    //Xoa = ma
    void xoa_ma(TRO& L, char* maNV){
        TRO Q = L;
        TRO P = NULL; // node dung truoc

        while(Q != NULL){
            if(strcmp(Q->nv.maNV, maNV) == 0){
                if(P == NULL) L = Q->next; // xoa node dau
                else P->next = Q->next;
                delete Q;
                cout << "Da xoa nv co ma: " << maNV << endl;
                return;
            }
            P = Q;
            Q = Q->next;
        }
        cout << "Khong tim thay nv co ma: " << maNV << endl;
    }

    // Xoa = vitri
    void xoa_vitri(TRO& L, int vitri){
        if(vitri < 1 || vitri > Length(L)){
            cout << "Vi tri xoa khong hop le";
            return;
        }
        if(vitri == 1){
            TRO tmp = L;
            L = L->next;
            delete tmp;
            return;
        }
        int id = 1;
        TRO Q = L;
        while(id < vitri - 1){
            id++;
            Q = Q->next;
        }
        TRO tmp = Q->next;
        Q->next = tmp->next;
        delete tmp;
    }

    // tim sv = ma
    void tim_ma(TRO& L, char* maNV){
        TRO Q = L;
        while(Q != NULL && strcmp(Q->nv.maNV, maNV) != 0){
            Q = Q->next;
        }
        if(Q == NULL) {
            cout << "Khong co nv co ma " << maNV << endl;
            return;
        }
        else {
            cout << "Thong tin nhan vien co ma " << maNV << ":\n";
            showTitle();
            showNV(Q->nv);
            return;
        }
    }
    // tim = vitri
    void tim_pos(TRO& L, int vitri){
        int id = 1;
        TRO Q = L;
        while(Q != NULL){
            if(id == vitri){
                cout << "Thong tin nhan vien o vi tri thu " << vitri << ":\n";
                showTitle();
                showNV(Q->nv);
                return;
            }
            id++;
            Q = Q->next;
        }
        cout << "Vi tri khong hop le!";
        return;
    }

    
    // dem
    int dem_ma(TRO& L, char* maNV){
        int cnt = 0;
        TRO Q =  L;
        while(Q != NULL){
            if(strcmp(Q->nv.maNV, maNV) == 0){
                cnt++;
            }
            Q = Q->next;
        }
        return cnt;
    }

    //sap xep
    void sx(TRO&L){
        TRO P = L;
        TRO Q, R;
        while(P->next != NULL){
            R = P;
            Q = P->next;
            while(Q != NULL){
                if(Q->nv.hsLuong > P->nv.hsLuong){
                    R = Q;
                }
                Q = Q->next;
            }
            
            NhanVien tmp = P->nv;
            P->nv = R->nv;
            R->nv = tmp;
            P = P->next;
        }
    }

    
    

    int main(){
        TRO L;
        Initialize(L);

        // Tao mot danh sach nhan vien co tu 3 ptu tro len. show
        cout << "Nhap vao danh sach voi it nhat 3 nhan vien: \n";
        for(int i = 0; i < 3; i++){
            addNhanVien(L, inputNhanVien());
        }
        while(true){
            cout << "Nhap tiep?(1: tiep tuc, 2: dung)?: ";
            int choice;
            cin >> choice;
            cin.ignore();
            if(choice == 1){
                addNhanVien(L, inputNhanVien());
            }
            else if(choice == 2){
                break;
            }
            else{
                cout << "Lua chon khong hop le!\n";
            }
        }
		cout << "\n\n\n==========================================================\n";
        cout << "Danh sach nhan vien:\n";
        showList(L);
        
        cout << "\n==========================================================\n";
        // Tìm nhân viên theo mã
        char maNV[10];
        cout << "Nhap ma nhan vien can tim: ";
        cin.getline(maNV, 9);
        tim_ma(L, maNV);
        
        cout << "\n==========================================================\n";
        // Xóa nhân viên sau nhân viên tìm được
        cout << "Xoa nhan vien co ma vua tim duoc.\n";
        xoa_ma(L, maNV);
        cout << "Danh sach sau khi xoa:\n";
        showList(L);
        
        cout << "\n==========================================================\n";
        // Thêm nhân viên vào đầu danh sách
        cout << "Them mot nhan vien vao dau danh sach:\n";
        chendau(L, inputNhanVien());
        cout << "Danh sach sau khi them:\n";
        showList(L);
        
        cout << "\n==========================================================\n";
        // Sắp xếp danh sách theo hệ số lương
        cout << "Sap xep danh sach theo he so luong:\n";
        sx(L);
        cout << "Danh sach sau khi sap xep la:\n";
        showList(L);
        return 0;
}
    