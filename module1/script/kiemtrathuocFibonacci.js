let kiemTraThuocFibonacci=parseInt(prompt('Nhập số cần kiểm tra có thuộc dãy Fibonacci'));
KiemTraThuocFibonacci(kiemTraThuocFibonacci);
function KiemTraThuocFibonacci(kiemTraThuocFibonacci) {
    let temp=0;
    let a=1;
    let b=0;
    let kiemTra=false;
    for(let i=0;i<=kiemTraThuocFibonacci;i++){
        temp=a;
        a+=b;
        b=temp;
        if(temp==kiemTraThuocFibonacci){
            kiemTra=true;

        }
    }return kiemTra
}