let mangLon=parseInt(prompt('Nhập số phần tử của mảng lớn'));
let mangNho=parseInt(prompt('Nhập số phần tử của mảng nhỏ'));
NhapMang2Chieu(mangLon,mangNho);
function NhapMang2Chieu(mangLon, mangNho) {
    for (i = 0; i < mangLon; i++) {
        mang[i] = [];
        for (j = 0; j < mangNho; j++) {
            mang[i][j] = parseInt(prompt('nhập vào phân tử mảng nhỏ'));
        }
    }
}