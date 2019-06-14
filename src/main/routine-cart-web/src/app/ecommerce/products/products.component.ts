import { Component, OnInit } from '@angular/core';
import { EcommerceService } from 'src/app/ecommerceServices/EcommerceService';
import { ProductOrder } from 'src/app/models/product-order.model';
import { ProductOrders } from 'src/app/models/product-orders.model';
import { Product } from 'src/app/models/product.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  productOrders: ProductOrder[] = [];
  products: Product[] = [];
  selectedProductOrder: ProductOrder;
  private shoppingCartOrders: ProductOrders;
  sub: Subscription;
  productSelected: boolean = false;

  constructor(private ecommerceService: EcommerceService) { }

  ngOnInit() {
    this.productOrders = [];
    this.loadProducts();
    this.loadOrders();
  }

  addToCart(order: ProductOrder) {
     if(order.quantity==0)
      {
        alert("Select Quantity!");
        return;
      }
    this.ecommerceService.SelectedProductOrder = order;
    this.selectedProductOrder = this.ecommerceService.SelectedProductOrder;
    this.productSelected = true;
}

removeFromCart(productOrder: ProductOrder) {
    let index = this.getProductIndex(productOrder.product);
    if (index > -1) {
        this.shoppingCartOrders.productOrders.splice(
            this.getProductIndex(productOrder.product), 1);
    }
    this.ecommerceService.ProductOrders = this.shoppingCartOrders;
    this.shoppingCartOrders = this.ecommerceService.ProductOrders;
    this.productSelected = false;
    productOrder.quantity = 0;
}

getProductIndex(product: Product): number {
    return this.ecommerceService.ProductOrders.productOrders.findIndex(
        value => value.product === product);
}

isProductSelected(product: Product): boolean {
    return this.getProductIndex(product) > -1;
}

loadProducts() {
    this.ecommerceService.getAllProducts()
        .subscribe(
            (products: any[]) => {
                this.products = products;
                this.products.forEach(product => {
                    this.productOrders.push(new ProductOrder(product, 0));
                })
            },
            (error) => console.log(error)
        );
}

loadOrders() {
    this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
        this.shoppingCartOrders = this.ecommerceService.ProductOrders;
    });
}

reset() {
    this.productOrders = [];
    this.loadProducts();
    this.ecommerceService.ProductOrders.productOrders = [];
    this.loadOrders();
    this.productSelected = false;
  }
}
