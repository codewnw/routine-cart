import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Subscription } from 'rxjs';
import { EcommerceService } from 'src/app/ecommerceServices/EcommerceService';
import { ProductOrder } from 'src/app/models/product-order.model';
import { ProductOrders } from 'src/app/models/product-orders.model';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {
  orderFinished: boolean;
  orders: ProductOrders;
  total: number;
  sub: Subscription;

  @Output() onOrderFinished: EventEmitter<boolean>;
  
  constructor(private ecommerceService: EcommerceService) { 
    this.total = 0;
    this.orderFinished = false;
    this.onOrderFinished = new EventEmitter<boolean>();
  }

  ngOnInit() {
    this.orders = new ProductOrders();
    this.loadCart();
    this.loadTotal();
  }

  private calculateTotal(products: ProductOrder[]): number {
    let sum = 0;
    products.forEach(value => {
        sum += (value.product.price * value.quantity);
    });
    return sum;
}

ngOnDestroy() {
    this.sub.unsubscribe();
}

finishOrder() {
    this.orderFinished = true;
    this.ecommerceService.Total = this.total;
    this.onOrderFinished.emit(this.orderFinished);
}

loadTotal() {
    this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
        this.total = this.calculateTotal(this.orders.productOrders);
    });
}

loadCart() {
    this.sub = this.ecommerceService.ProductOrderChanged.subscribe(() => {
        let productOrder = this.ecommerceService.SelectedProductOrder;
        if (productOrder) {
            this.orders.productOrders.push(new ProductOrder(
                productOrder.product, productOrder.quantity));
        }
        this.ecommerceService.ProductOrders = this.orders;
        this.orders = this.ecommerceService.ProductOrders;
        this.total = this.calculateTotal(this.orders.productOrders);
    });
}

reset() {
    this.orderFinished = false;
    this.orders = new ProductOrders();
    this.orders.productOrders = []
    this.loadTotal();
    this.total = 0;
}
}
