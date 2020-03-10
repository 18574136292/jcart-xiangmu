var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        returnId:'',
        orderId:'',
        customerName:'',
        productCode:'',
        productName:'',
        selectedStatus:'',
        statuses:[
            {value:0,label:'待处理'},
            {value:1,label:'待取货'},
            {value:2,label:'正在处理'},
            {value:3,label:'完成'},
            {value:4,label:'拒绝'},
        ],
        startTime:'',
        endTime:'',
        pageNum:1
    },
    mounted(){
        console.log('get return list');
        this.pageSearchReturn();
    },
    methods:{
        handleSearchClick(){
            console.log('search click');
            this.pageNum = 1;
            this.pageSearchReturn();
        },
        handleClearClick(){
            console.log('clear click');
            this.returnId = '';
            this.orderId = '';
            this.customerName = '';
            this.productCode = '';
            this.productName = '';
            this.selectedStatus = '';
            this.startTime = '';
            this.endTime = '';
        },
        handlePageChange(value) {
            console.log('page change click', value);
            this.pageNum = value;
            this.pageSearchReturn();
        },
        pageSearchReturn(){
            axios.get('/return/pageSearch',{
                params:{
                    pageNum:this.pageNum,
                    returnId: this.returnId,
                    orderId: this.orderId,
                    customerName: this.customerName,
                    productCode: this.productCode,
                    productName: this.productName,
                    status: this.selectedStatus,
                    startTimestamp: this.startTime ? this.startTime.getTime() : '',
                    endTimestamp: this.endTime ? this.endTime.getTime() : '',
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})