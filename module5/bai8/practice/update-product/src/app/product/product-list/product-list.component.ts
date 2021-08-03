import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  searchedKeyword: string;
  products: Product[] = [];
  config: any;

  constructor(private productService: ProductService) {
    for (let i = 0; i < this.products.length; i++) {
      this.products.push(
        {
          id: i + 1
        }
      );
    }

    this.config = {
      itemsPerPage: 2,
      currentPage: 1,
      totalItems: this.products.length
    };
  }

  pageChanged(event) {
    this.config.currentPage = event;
  }


  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.products = this.productService.getAll();
  }

}
