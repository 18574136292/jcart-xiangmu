const ReturnShow = {
    template:`
    <div id="app">
        <el-divider>退货基本信息</el-divider>
        退货Id：{{returnId}} <br>
        订单Id：{{orderId}} <br>
        订单时间：{{(new Date(orderTimestamp)).toLocaleString()}} <br>
        客户Id：{{customerId}} <br>
        客户姓名：{{customerName}} <br>
        手机：{{mobile}} <br>
        邮箱：{{email}} <br>
<!--        状态：{{statuses[status].label}}<br>-->
<!--        处理方式：{{actions[action].label}}<br>-->
        <br>
    
        <el-divider>退货商品信息</el-divider>
        商品代号：{{productCode}} <br>
        商品名称：{{productName}} <br>
        数量：{{quantity}} <br>
<!--        原因：{{reasons[reason].label}} <br>-->
        是否开封：<span v-if="opened">是</span><span v-else>否</span> <br>
        备注：{{comment}} <br>
        申请时间：{{(new Date(createTimestamp)).toLocaleString()}}<br>
        更新时间：{{(new Date(updateTimestamp)).toLocaleString()}}<br>
        <br>
    
        <el-select v-model="selectedAction" placeholder="请选择处理方式">
            <el-option v-for="item in actions" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
    
        <el-button type="primary" @click="handleUpdateAction">修改处理方式</el-button>
    </div>
    `,
    data(){
        return {
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
            statuses:[
                { value: 0, label: '待处理' },
                { value: 1, label: '待取货' },
                { value: 2, label: '正在处理' },
                { value: 3, label: '完成' },
                { value: 4, label: '拒绝' }
            ],
            actions:[
                {value:0,label:'退货'},
                {value:1,label:'换货'},
                {value:2,label:'维修'}
            ],
            reasons:[
                { value: 0, label: '发货过期' },
                { value: 1, label: '订单错误' },
                { value: 2, label: '收到错误商品' },
                { value: 3, label: '质量问题' }
            ],
            selectedAction:''
        }
    },
    mounted(){
        console.log('get returnId');
        
        this.returnId = this.$route.params.returnId;
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
                .then((resopnse) => {
                    console.log(resopnse);
                    alert('更新处理方式成功');
                    this.getReturnByReturnId();
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
                .then((response) => {
                    console.log(response);
                    console.log(1111);
                    var returnOne = response.data;
                    this.orderId = returnOne.orderId;
                    this.orderTimestamp = returnOne.orderTimestamp;
                    this.customerId = returnOne.customerId;
                    this.customerName = returnOne.customerName;
                    this.mobile = returnOne.mobile;
                    this.email = returnOne.email;
                    this.status = returnOne.status;
                    this.action = returnOne.action;
                    this.selectedAction = returnOne.action;
                    this.productCode = returnOne.productCode;
                    this.productName = returnOne.productName;
                    this.quantity = returnOne.quantity;
                    this.reason = returnOne.reason;
                    this.opened = returnOne.opened;
                    this.comment = returnOne.comment;
                    this.createTimestamp = returnOne.createTimestamp;
                    this.updateTimestamp = returnOne.updateTimestamp;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
}