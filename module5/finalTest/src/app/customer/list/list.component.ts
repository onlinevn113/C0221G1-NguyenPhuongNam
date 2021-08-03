import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {CustomerService} from '../../service/customer.service';
import Swal from 'sweetalert2';
import {LoadCssService} from '../../bootstrap/load-css.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  customers: Customer[] = [];
  page = 1;
  nameSearch = '';
  emailSearch = '';

  constructor(private sv: CustomerService, private load: LoadCssService) {
    this.getAll();
    load.loadCss('https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css');
    load.loadScript('assets/side-nav.js');
  }

  ngOnInit(): void {
  }

  getAll() {
    this.sv.getAll().subscribe(c => {
      this.customers = c;
    });
  }

  delete(id: number) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: 'You won\'t be able to revert this!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.sv.delete(id).subscribe(() => {
          this.getAll();
        });
        swalWithBootstrapButtons.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        );
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          'Your imaginary file is safe :)',
          'error'
        );
      }
    });
  }

  search() {
    this.sv.search(this.nameSearch, this.emailSearch).subscribe(c => {
      this.customers = c;
      this.page = 1;
    });
  }
}
