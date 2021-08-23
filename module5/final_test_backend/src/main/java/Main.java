public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 0, 0, 3, 2, 1, 3, 0, 3};
        int[] b = new int[a.length];
        int x=1;
        b[0]=a[0];
        //tach mang chi gom cac phan tu khac nhau
        for(int i=1;i<a.length;i++){
            int dem=0;
            for(int j=0;j<x;j++){
                if(a[i]==b[j])
                    dem++;
            }
            if(dem==0){
                b[x]=a[i];
                x++;
            }
        }
        //tao mang chua so lan xuat hien cua moi phan tu
        int[] c=new int[x];
        for(int i=0;i<x;i++)
            c[i]=0;
        //dem so lan xuat hien cua moi phan tu
        for(int i=0;i<x;i++){
            for(int j=0;j<a.length;j++){
                if(a[j]==b[i])
                    c[i]++;
            }
        }

        //tim so lan xuat hien nhieu nhat
        //bien max luu so lan xuat hien nhieu nhat
        //bien y dung de dem so lan xuat hien bang nhau
        int max=c[0], vtri=0, y=1;

        //tim so lan xuat hien nhieu nhat va vi tri cua no
        for(int i=1;i<x;i++){
            if(c[i]>max){
                max=c[i];
                vtri=i;
                y=1;
            }
            if(c[i]==max){
                y++;
            }
        }

        //neu chi co mot phan tu xuat hien nhieu nhat
        if(y==1){
            cout<<"\nPhan tu xuat hien nhieu nhat la: "<<b[vtri];
            cout<<" xuat hien "<<max<<" lan"<<endl;
        }

        //neu co tu hai phan tu xuat hien nhieu nhat
        else{
            int d[y]; //mang dung luu vi tri cua phan tu xuat hien nhieu nhat
            int z=0;
            for(int i=0;i<x;i++)
                if(c[i]==max){//lay vi tri cua phan tu xuat hien nhieu nhat
                    d[z]=i;
                    z++;
                }
            //in ket qua ra man hinh
            cout<<"\nPhan tu xuat hien nhieu nhat la: ";
            for(int i=0;i<z;i++ )
                cout<<b[d[i]]<<" ";
            cout<<" xuat hien "<<max<<" lan";

        }


    }
}
