import {Component, OnInit} from '@angular/core';
import {BenhNhan} from '../../model/benh_vien/benh-nhan';
import {BenhNhanService} from '../../service/benh-nhan.service';
import {LoadCssService} from '../../bootstrap/load-css.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-danh-sach',
  templateUrl: './danh-sach.component.html',
  styleUrls: ['./danh-sach.component.scss']
})
export class DanhSachComponent implements OnInit {
  page = 1;
  benhNhans: BenhNhan[] = [];

  constructor(private sv: BenhNhanService, private load: LoadCssService) {

    document.getElementById('b34')?.parentNode.removeChild(document.getElementById('b34'));
    load.loadCss('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css');
    // load.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css');
    load.loadCss('https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css');
    load.loadScript('assets/side-nav.js');
    load.loadScript('https://code.jquery.com/jquery-3.5.1.slim.min.js');
    load.loadScript('https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js');
    load.loadScript('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js');
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.sv.getAll().subscribe(c => {
      this.benhNhans = c;
    });
  }

  delete(id: number, ma: string) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: 'Xác nhận',
      text: 'Bạn có muốn xoá bênh án ' + ma + ' hay không',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Có',
      padding: '10px',
      cancelButtonText: 'Không',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.sv.delete(id).subscribe(() => {
          this.getAll();
        });
        swalWithBootstrapButtons.fire(
          'Xoá Thành Công',
          '',
          'success'
        );
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
