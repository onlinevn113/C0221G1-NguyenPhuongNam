import {Component, OnInit} from '@angular/core';
import {BenhNhan} from '../../model/benh_vien/benh-nhan';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {BenhNhanService} from '../../service/benh-nhan.service';
import {LoadCssService} from '../../bootstrap/load-css.service';
import {ActivatedRoute, Router} from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-chinh-sua',
  templateUrl: './chinh-sua.component.html',
  styleUrls: ['./chinh-sua.component.scss']
})
export class ChinhSuaComponent implements OnInit {
  id: number;
  benhNhan: BenhNhan;
  msg = {
    ten: [
      {type: 'required', msg: 'Không được để trống'},
      {type: 'pattern', msg: 'Vui lòng nhập đúng định dạng và không nhập số'}
    ],
    lyDo: [
      {type: 'required', msg: 'Không được để trống'}
    ],
    phuongPhap: [
      {type: 'required', msg: 'Không được để trống'}
    ],
    bacSi: [
      {type: 'required', msg: 'Không được để trống'}
    ]
  };
  form: FormGroup;


  constructor(private sv: BenhNhanService, private load: LoadCssService, private activatedRoute: ActivatedRoute, private route: Router) {
    load.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css', "b34");
    activatedRoute.paramMap.subscribe((param) => {
      this.id = +param.get('id');
      this.form = new FormGroup({
          maBenAn: new FormControl(''),
          maBenhNhan: new FormControl(''),
          ten: new FormControl('', [Validators.required,Validators.pattern('[(A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴa-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ)\\p{P}]+(?:\\s[(A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴa-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ)\\p{P}]+)+')]),
          ngayNhapVien: new FormControl(''),
          ngayRaVien: new FormControl(''),
          lyDo: new FormControl('', Validators.required),
          phuongPhap: new FormControl('', Validators.required),
          bacSi: new FormControl('', Validators.required),
        }, this.validDate
      );
      sv.findById(this.id).subscribe(c => {
          this.benhNhan = c;
          this.form.patchValue(c);
        }
      );
    });

  }

  ngOnInit(): void {


  }

  validDate(control: AbstractControl) {
    const v = control.value;
    const start = new Date(v.ngayNhapVien);
    const end = new Date(v.ngayRaVien);
    if (end.getTime() - start.getTime() < 0) {
      return {'validDate': true};
    }
    return null;
  }

  edit() {
    this.benhNhan = this.form.value;
    this.sv.update(this.id, this.benhNhan).subscribe(() => {
      this.route.navigateByUrl('benh-nhan');
      Swal.fire({
        icon: 'success',
        showConfirmButton: false,
        timer: 1000
      });
    });
  }

  getValidateEdit(attribute: string, valid): boolean {
    return this.form.get(attribute)?.hasError(valid.type) &&
      (this.form.get(attribute)?.touched || this.form.get(attribute)?.dirty);
  }

  out() {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: 'Xác nhận',
      text: 'Bạn có muốn thoát ',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Có',
      cancelButtonText: 'Không',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.route.navigateByUrl('benh-nhan');
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Huỷ',
          '',
          'error'
        );
      }
    });
  }
}
