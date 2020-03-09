var app = new Vue({
    el: '#app',
    data: {
        returnId:'',
        orderId:'',
        orderTimestamp:'',
        customerId:'',
        customerName:'',
        mobile:'',
        email:'',
        status:'',
        action:'',
        productCode:'',
        productName:'',
        quantity:'',
        reason:'',
        opened:'',
        comment:'',
        createTimestamp:'',
        updateTimestamp:'',
        actions:[
            {value:0,label:'退货'},
            {value:1,label:'换货'},
            {value:2,label:'维修'}
        ],
        selectedAction:''
    },
    mounted(){
        console.log('get returnId');
        var url = new URL(location.href);
        this.returnId = url.searchParams.get('returnId');
        if(!this.returnId){
            alert('returnId is null');
            return;
        }
        this.getReturnByReturnId();
    },
    methods:{
        handleUpdateAction(){
            console.log('update action click');
            this.updateReturnAction();
        },
        updateReturnAction(){
            axios.post('/return/updateAction',{
                returnId:this.returnId,
                action:this.selectedAction
            })
                .then(function (resopnse) {
                    console.log(resopnse);
                    alert('更新处理方式成功');
                    app.getReturnByReturnId();
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        getReturnByReturnId(){
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
                    app.customerId = returnOne.customerId;
                    app.customerName = returnOne.customerName;
                    app.mobile = returnOne.mobile;
                    app.email = returnOne.email;
                    app.status = returnOne.status;
                    app.action = returnOne.action;
                    app.selectedAction = returnOne.action;
                    app.productCode = returnOne.productCode;
                    app.productName = returnOne.productName;
                    app.quantity = returnOne.quantity;
                    app.reason = returnOne.reason;
                    app.opened = returnOne.opened;
                    app.comment = returnOne.comment;
                    app.createTimestamp = returnOne.createTimestamp;
                    app.updateTimestamp = returnOne.updateTimestamp;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})