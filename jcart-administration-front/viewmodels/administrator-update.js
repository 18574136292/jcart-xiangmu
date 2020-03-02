var app = new Vue({
    el: '#app',
    data: {
        administratorId: '',
        username: '',
        realName: '',
        password: '',
        email: '',
        avatarUrl: '',
        selectedStatus: '',
        statuses: [
            { value: 0, label: '禁用' },
            { value: 1, label: '启用' }
        ]
    },
    mounted(){
        console.log('administratorId');
        var url = new URL(location.href);
        this.administratorId = url.searchParams.get("administratorId");
        if(!this.administratorId){
            alert('administratorId is null');
            return;
        }
        this.getAdministratorById();
    },
    methods:{
        handleUpdateClick(){
            console.log('update click');
            this.updateAdministrator();
        },
        getAdministratorById(){
            axios.get('/admin/getById',{
                params:{
                    administratorId:this.administratorId
                }
            })
                .then(function (response) {
                    console.log(response);
                    var ua = response.data;
                    app.username = ua.username;
                    app.realName = ua.realName;
                    app.email = ua.email;
                    app.avatarUrl = ua.avatarUrl;
                    app.selectedStatus = ua.status;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        updateAdministrator(){
            axios.post('/admin/update',{
                administratorId:this.administratorId,
                password:this.password,
                realName:this.realName,
                email:this.email,
                avatarUrl:this.avatarUrl,
                status:this.selectedStatus
            })
                .then(function (response) {
                    console.log(response);
                    alert('更新成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('更新失败');
                })
        }
    }
})