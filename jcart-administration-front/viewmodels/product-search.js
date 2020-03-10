var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        productCode:'',
        productName:'',
        price:'',
        stockQuantity:'',
        selectedStatus:'',
        statuses:[
            { value: 0, label: '下架' },
            { value: 1, label: '上架' },
            { value: 2, label: '待审核' }
        ],
        pageNum:1
    },
    mounted(){
        this.searchProduct();
    },
    methods:{
        handleSearchClick(){
            console.log('search click');
            this.pageNum = 1;
            this.searchProduct();
        },
        handleClearClick(){
            console.log('clear click');
            this.productCode = '';
            this.productName = '';
            this.price = '';
            this.stockQuantity = '';
            this.selectedStatus = '';
        },
        handlePageChange(value){
            this.pageNum=value;
            this.searchProduct();
        },
        searchProduct(){
            axios.get('product/pageSearch',{
                params:{
                    pageNum:this.pageNum,
                    productCode: this.productCode,
                    productName: this.productName,
                    price: this.price,
                    stockQuantity: this.stockQuantity,
                    status: this.selectedStatus
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo=response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})