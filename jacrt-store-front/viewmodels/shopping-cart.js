var app = new Vue({
    el: '#app',
    data: {
        myShoppingCart:[]
    },
    mounted(){
        console.log('myShoppingCart show');
        Cookies.set('testname','testvalue',{expires:7});
        var myShoppingCartJson = localStorage['myShoppingCartJson'];
        this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson):[];
    },
    methods:{
        handleDelete(index,row){
            console.log('delete click');
            this.myShoppingCart.splice(index,1);
            localStorage['myShoppingCartJson'] = JSON.stringify(this.myShoppingCart);
            this.$message.success('删除购物车成功');
        },
        handleUpdate(index,row){
            console.log('update click');
            localStorage['myShoppingCartJson'] = JSON.stringify(this.myShoppingCart);
            this.$message.success('修改购物车成功');
        }
    }
})