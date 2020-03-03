var app = new Vue({
    el: '#app',
    data: {
        originPwd:'',
        newPwd:'',
        reNewPwd:''
    },
    mounted(){
        console.log('change pwd');
    },
    methods:{
        handleChangeClick(){
            console.log('change click');
            if(this.newPwd != this.reNewPwd){
                alert('请输入相同的密码');
                return;
            }
            this.changeMyPwd();
        },
        changeMyPwd(){
            axios.post('/customer/changePwd',{
                originPwd:this.originPwd,
                newPwd:this.newPwd
            })
                .then(function (response) {
                    console.log(response);
                    alert('修改成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('修改失败');
                })
        }
    }
})