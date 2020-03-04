var app = new Vue({
    el: '#app',
    data: {
        myAddresses:[],
        shipMethods:[
            {value:0,label:'EMS'},
            {value:1,label:'顺丰'},
            {value:2,label:'圆通'},
            {value:3,label:'中通'},
            {value:4,label:'申通'}
        ],
        payMethods:[
            {value:0,label:'货到付款'},
            {value:1,label:'借记卡'},
            {value:2,label:'信用卡'},
            {value:3,label:'微信支付'},
            {value:4,label:'支付宝'}
        ],
        selectedShipAddressId:'',
        selectShipMethod:'',
        selectedInvoiceAddressId:'',
        selectedPayMethod:'',
        comment:'',
        myShoppingCart:[],
        shipPrice:8.0
    },
    computed:{
        totalPrice(){
            var subTotalPrices = this.myShoppingCart.map(p=>{
                return p.unitPrice * p.discount * p.quantity;
            });
            var totalPrice = subTotalPrices.reduce((a,b)=>a+b,0);
            totalPrice = parseFloat(totalPrice.toFixed(2));
            return totalPrice;
        },
        payPrice(){
            return this.totalPrice + this.shipPrice;
        },
        orderProducts(){
            var orderProducts = this.myShoppingCart.map(p=>{
                var orderProduct = new Object();
                orderProduct.productId = p.productId;
                orderProduct.quantity = p.quantity;
                return orderProduct;
            });

            return orderProducts;
        }
    },
    mounted(){
        console.log('getMyAddress');
        this.getMyAddress();

        var myShoppingCartJson = localStorage['myShoppingCartJson'];
        this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : [];
    },
    methods:{
        handleConfirmOrder(){
            console.log('order click');
            this.checkoutOrder();
        },
        getMyAddress() {
            axios.get('/address/getAddressByCustomerId')
                .then(function (response) {
                    console.log(response);
                    app.myAddresses = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        checkoutOrder(){
            axios.post('/order/checkout',{
                shipMethod:this.selectShipMethod,
                shipAddressId:this.selectedShipAddressId,
                payMethod:this.selectedPayMethod,
                invoiceAddressId:this.selectedInvoiceAddressId,
                comment:this.comment,
                orderProducts:this.orderProducts
            })
                .then(function (response) {
                    console.log(response);
                    alert('下单成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('下单失败');
                })
        }
    }
})