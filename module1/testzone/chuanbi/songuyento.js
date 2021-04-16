//in ra dãy số nguyên tố tới num
function inRaDaySoNguyenTo(num) {
    let count = 0;
    let n = 0;
    let kq = '';
    while (count < num) {
        let kiemTra=kiemTraSoNguyenTo(n);
        if (kiemTra) {
            count++;
            kq += n + "<br> ";
        }
        n++;
    }
    document.write(kq);
}

//kiểm tra số nguyên tố trả về true false
function kiemTraSoNguyenTo(n){
    if (n < 2) {
        return false;
    } else {
        for (let i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                return  false;
            }
        }
    }
    return true;
}