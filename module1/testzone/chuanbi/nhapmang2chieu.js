
// let mangLon=parseInt(prompt('nhập số của phân tử mảng lơn'));
// let mangNho=parseInt(prompt('Nhập số của phân tử mảng nhỏ'));
// NhapMang2Chieu(mangLon,mangNho);
function NhapMang2Chieu(m,n) {

    for(i=0; i<m; i++){
        mang[i]=[];
        for(j=0; j<n; j++){
            mang[i][j]=prompt('nhập vào phân tử mảng nhỏ');
        }
    }
}