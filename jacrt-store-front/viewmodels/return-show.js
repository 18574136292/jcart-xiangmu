var app = new Vue({
    el: '#app',
    data: {
        returnId:'',
        orderId: '',
        orderTimestamp: '',
        customerName: '',
        mobile: '',
        email: '',
        status: '',
        action: '',
        productCode: '',
        productName: '',
        quantity: '',
        reason: '',
        opened: '',
        comment: '',
        createTimestamp: '',
        updateTimestamp: '',
        returnHistories: []
    },
    mounted(){
        console.log('get returnId');
        var url = new URL(location.href);
        this.returnId = url.searchParams.get("returnId");
        if (!this.returnId){
            alert('returnId is null');
            return;
        }
        this.getReturnById();
    },
    methods:{
        getReturnById(){
            axios.get('/return/getById',{
                params:{
                    returnId:this.returnId
                }
            })
                .then(function (response) {
                    console.log(response);
                    var returnOne = response.data;
                    app.orderId = returnOne.orderId;
                    app.orderTimestamp = returnOne.orderTimestamp;
                    app.customerName = returnOne.customerName;
                    app.mobile = returnOne.mobile;
                    app.email = returnOne.email;
                    app.status = returnOne.status;
                    app.action = returnOne.action;
                    app.productCode = returnOne.productCode;
                    app.productName = returnOne.productName;
                    app.quantity = returnOne.quantity;
                    app.reason = returnOne.reason;
                    app.opened = returnOne.opened;
                    app.comment = returnOne.comment;
                    app.createTimestamp = returnOne.createTimestamp;
                    app.updateTimestamp = returnOne.updateTimestamp;
                    app.returnHistories = returnOne.returnHistories;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})