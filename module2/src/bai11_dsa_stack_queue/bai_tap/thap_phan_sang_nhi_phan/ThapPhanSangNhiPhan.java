package bai11_dsa_stack_queue.bai_tap.thap_phan_sang_nhi_phan;

public class ThapPhanSangNhiPhan {
    public static String thapPhanSangNhiPhan(int n) {
        String hienthi="";
        while (n>0){
            if (n%2==0){
                hienthi+=0;
                n=n/2;
            }else{
                hienthi+=1;
                n=(n-1)/2;
            }
        }
        return hienthi;
    }
}
